package com.rd.xpkuisdk.demo;

import static com.rd.xpkuisdk.XpkSdk.onXpkEdit;
import static com.rd.xpkuisdk.XpkSdk.onXpkTrimVideo;

import java.io.File;
import java.util.ArrayList;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rd.xpkuisdk.XpkSdk;
import com.rd.xpkuisdk.XpksdkService;
import com.rd.xpkuisdk.callback.ICompressVideoCallback;
import com.rd.xpkuisdk.demo.dialog.AlbumConfigDialog;
import com.rd.xpkuisdk.demo.dialog.CameraConfigDialog;
import com.rd.xpkuisdk.demo.dialog.CompressConfigDialog;
import com.rd.xpkuisdk.demo.dialog.ConfigData;
import com.rd.xpkuisdk.demo.dialog.ConfigDialogListener;
import com.rd.xpkuisdk.demo.dialog.EditorUIAndExportConfigDialog;
import com.rd.xpkuisdk.demo.dialog.VideoTrimConfigDialog;
import com.rd.xpkuisdk.demo.utils.SDKUtils;
import com.rd.xpkuisdk.manager.CameraConfiguration;
import com.rd.xpkuisdk.manager.CompressConfiguration;
import com.rd.xpkuisdk.manager.EditObject;
import com.rd.xpkuisdk.manager.ExportConfiguration;
import com.rd.xpkuisdk.manager.TrimConfiguration;
import com.rd.xpkuisdk.manager.UIConfiguration;
import com.rd.xpkuisdk.manager.UIConfiguration.ClipEditingModules;
import com.rd.xpkuisdk.manager.UIConfiguration.EditAndExportModules;
import com.rd.xpkuisdk.manager.VideoMetadataRetriever;

/**
 * xpkUISDK演示页
 */
@TargetApi(23)
public class SimpleActivity extends Activity {
	private final String TAG = this.toString();
	private final String EDIT_PICTURE_PATH = Environment
			.getExternalStorageDirectory() + "/android.jpg";
	/**
	 * 导出的横向16:9视频
	 */
	private final String EDIT_L_VIDEO_PATH = Environment
			.getExternalStorageDirectory() + "/demoVideo1.mp4";
	/**
	 * 测试用1：1方型视频
	 */
	private final String EDIT_S_VIDEO_PATH = Environment
			.getExternalStorageDirectory() + "/demoVideo2.mp4";
	/**
	 * 测试用竖向9:16视频
	 */
	private final String EDIT_P_VIDEO_PATH = Environment
			.getExternalStorageDirectory() + "/demoVideo3.mp4";

	/**
	 * REQUEST_CODE定义：<br>
	 * 录制
	 */
	private final int XPK_CAMERA_REQUEST_CODE = 100;
	/**
	 * REQUEST_CODE定义：<br>
	 * 相册
	 */
	private final int XPK_ALBUM_REQUEST_CODE = 101;

	/**
	 * 从相册选折要压缩的文件
	 */
	private final int XPK_ALBUM_COMPRESS_REQUEST_CODE = 1011;
	/**
	 * 从相册选折要播放的视频
	 */
	private final int XPK_ALBUM_PLAYER_REQUEST_CODE = 1012;

	/**
	 * REQUEST_CODE定义：<br>
	 * 视频编辑
	 */
	private final int XPK_EDIT_REQUEST_CODE = 102;
	/**
	 * REQUEST_CODE定义：<br>
	 * 读取外置存储
	 */
	private static final int REQUEST_CODE_READ_EXTERNAL_STORAGE_PERMISSIONS = 1;

	/**
	 * REQUEST_CODE定义：<br>
	 * 视频截取
	 */
	private final int XPK_TRIM_REQUEST_CODE = 103;

	/**
	 * 短视频录制演示request_code
	 */
	private final int XPK_SHORTVIDEO_CAMERA_REQUEST_CODE = 110;
	/**
	 * 短视频录制进入相册演示request_code
	 */
	private final int XPK_SHORTVIDEO_ALBUM_REQUEST_CODE = 111;
	/**
	 * 短视频录制进入相册进入截取演示request_code
	 */
	private final int XPK_SHORTVIDEO_TRIM_REQUEST_CODE = 112;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
			finish();
			return;
		}
		setContentView(R.layout.activity_simple_layout);
		restoreConfigInstanceState();

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
				&& !XpkSdk.isInitialized()) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
				requestPermissions(
						new String[] { Manifest.permission.READ_EXTERNAL_STORAGE },
						REQUEST_CODE_READ_EXTERNAL_STORAGE_PERMISSIONS);
			}
		} else {
			exportDemoResource();
		}
		// 初始化秀拍客配置
		initEditorUIAndExportConfig();
	}

	/**
	 * 初始标准编辑及导出配置
	 */
	private void initEditorUIAndExportConfig() {
		initAndGetConfigData();
		// 视频编辑UI配置
		UIConfiguration uiConfig = new UIConfiguration.Builder()
				// 设置横竖屏，参数分别有 0:自动，1:竖屏，2:横屏
				.setOrientation(configData.orientation)
				// 设置是否使用自定义相册
				.useCustomAlbum(false)
				// 设置向导化
				.enableWizard(configData.enableWizard)
				// 设置自动播放
				.enableAutoRepeat(configData.enableAutoRepeat)
				// 设置MV和mv网络地址
				.enableMV(configData.enableMV, configData.mvUrl)
				// 配音模式
				.setVoiceLayoutType(configData.voiceLayoutType)
				// 设置秀拍客相册支持格式
				.setAlbumSupportFormat(configData.albumSupportFormatType)
				// 设置默认进入界面画面比例
				.setVideoProportion(configData.videoProportionType)
				// 设置配乐界面风格
				.setSoundTrackType(configData.soundTrakLayoutType)
				// 设置滤镜界面风格
				.setFilterType(configData.filterLayoutType)
				// 设置相册媒体选择数量上限(目前只对相册接口生效)
				.setMediaCountLimit(configData.albumMediaCountLimit)
				// 设置相册是否显示跳转拍摄按钮(目前只对相册接口生效)
				.enableAlbumCamera(configData.enableAlbumCamera)
				// 编辑与导出模块显示与隐藏（默认不设置为显示）
				.setEditAndExportModuleVisibility(
						EditAndExportModules.SOUNDTRACK,
						configData.enableSoundTrack)
				.setEditAndExportModuleVisibility(EditAndExportModules.DUBBING,
						configData.enableDubbing)
				.setEditAndExportModuleVisibility(EditAndExportModules.FILTER,
						configData.enableFilter)
				.setEditAndExportModuleVisibility(EditAndExportModules.TITLING,
						configData.enableTitling)
				.setEditAndExportModuleVisibility(
						EditAndExportModules.SPECIAL_EFFECTS,
						configData.enableSpecialEffects)
				.setEditAndExportModuleVisibility(
						EditAndExportModules.CLIP_EDITING,
						configData.enableClipEditing)
				// 片段编辑模块显示与隐藏（默认不设置为显示）
				.setClipEditingModuleVisibility(
						ClipEditingModules.IMAGE_DURATION_CONTROL,
						configData.enableImageDuration)
				.setClipEditingModuleVisibility(ClipEditingModules.EDIT,
						configData.enableEdit)
				.setClipEditingModuleVisibility(ClipEditingModules.TRIM,
						configData.enableTrim)
				.setClipEditingModuleVisibility(
						ClipEditingModules.VIDEO_SPEED_CONTROL,
						configData.enableVideoSpeed)
				.setClipEditingModuleVisibility(ClipEditingModules.SPLIT,
						configData.enableSplit)
				.setClipEditingModuleVisibility(ClipEditingModules.COPY,
						configData.enableCopy)
				.setClipEditingModuleVisibility(ClipEditingModules.PROPORTION,
						configData.enableProportion)
				.setClipEditingModuleVisibility(ClipEditingModules.SORT,
						configData.enableSort)
				.setClipEditingModuleVisibility(ClipEditingModules.TEXT,
						configData.enableText)
				// 字幕在mv的外面
				.enableTitlingOuter(configData.enableTitlingOuter)
				// 特效在mv的外面
				.enableSpecialeffectsOuter(configData.enableSpecialeffectsOuter)
				.get();

		// 导出视频参数配置
		ExportConfiguration exportConfig = new ExportConfiguration.Builder()
		// 设置保存路径，传null或不设置
		// 将保存至默认路径(即调用XpkSdk.init初始时自定义路径$strCustomRootPath$/xpkVideos）
				.setSavePath(null)
				// 设置片尾图片路径，传null或者不设置 将没有片尾
				.setTrailerPath(configData.videoTrailerPath)
				// 设置片尾时长 单位ms 默认2000ms
				.setTrailerDuration(2000)
				// 设置导出视频时长 单位ms 传0或者不设置 将导出完整视频
				.setVideoDuration(configData.exportVideoDuration * 1000)
				// 设置是否显示水印
				.enableWatermark(configData.enableWatermark)
				// 设置水印位置
				.setWatermarkPosition(configData.watermarkShowRectF).get();

		// 获取秀拍客配置服务器
		XpksdkService xpkService = XpkSdk.getXpksdkService();
		if (null != xpkService) {
			// 初始化所有配置
			xpkService.initConfiguration(exportConfig, uiConfig);
		}
	}

	/**
	 * 选折相册资源
	 */
	private void initUIAblumConfig() {
		// 视频编辑UI配置
		UIConfiguration uiConfig = new UIConfiguration.Builder()
		// 设置是否使用自定义相册
				.useCustomAlbum(false)
				// 设置秀拍客相册支持格式
				.setAlbumSupportFormat(UIConfiguration.ALBUM_SUPPORT_DEFAULT)
				// 设置滤镜界面风格
				// 设置相册媒体选择数量上限(目前只对相册接口生效)
				.setMediaCountLimit(1)
				// 设置相册是否显示跳转拍摄按钮(目前只对相册接口生效)
				.enableAlbumCamera(false).get();

		// 获取秀拍客配置服务器
		XpksdkService xpkService = XpkSdk.getXpksdkService();
		if (null != xpkService) {
			// 初始化所有配置
			xpkService.initConfiguration(null, uiConfig);
		}
	}

	/**
	 * 初始拍摄配置
	 * 
	 * @param UIType
	 *            * 设置录制时默认界面:<br>
	 *            默认16：9录制:<br>
	 *            CameraConfiguration. WIDE_SCREEN_CAN_CHANGE<br>
	 *            默认1：1:<br>
	 *            CameraConfiguration. SQUARE_SCREEN_CAN_CHANGE<br>
	 *            仅1：1录制:<br>
	 *            CameraConfiguration.ONLY_SQUARE_SCREEN
	 */
	private void initCameraConfig(int UIType) {
		XpkSdk.getXpksdkService().initConfiguration(
				new CameraConfiguration.Builder()
						// 可设置最小录制时长,0代表不限制
						.setVideoMinTime(configData.cameraMinTime)
						// 可设置最大录制时长,0代表不限制
						.setVideoMaxTime(configData.cameraMaxTime)
						// 为true代表多次拍摄，拍摄完成一段之后，将保存至相册并开始下一段拍摄，默认为false单次拍摄，拍摄完成后返回资源地址
						.useMultiShoot(configData.useMultiShoot)
						/**
						 * 设置录制时默认界面:<br>
						 * 默认16：9录制:<br>
						 * CameraConfiguration. WIDE_SCREEN_CAN_CHANGE<br>
						 * 默认1：1:<br>
						 * CameraConfiguration. SQUARE_SCREEN_CAN_CHANGE<br>
						 * 仅1：1录制:<br>
						 * CameraConfiguration.ONLY_SQUARE_SCREEN
						 */
						.setCameraUIType(UIType)
						// 设置拍摄完成后，是否保存至相册（仅单次拍摄方式有效），同时通过onActivityResult及SIMPLE_CAMERA_REQUEST_CODE返回
						.setSingleCameraSaveToAlbum(configData.isSaveToAlbum)
						// 设置录制时是否静音，true代表录制后无声音
						.setAudioMute(false)
						// 设置是否启用faceunity
						.setEnableFace(configData.isDefaultFace)
						// 设置Faceunity鉴权证书
						.setPack(authpack.A())
						// 设置是否默认为后置摄像头
						.setDefaultRearCamera(configData.isDefaultRearCamera)
						// 是否显示相册按钮
						.enableAlbum(configData.enableAlbum)
						// 是否使用自定义相册
						.useCustomAlbum(configData.useCustomAlbum)
						// 设置隐藏拍摄功能（全部隐藏将强制开启视频拍摄）
						.hideMV(configData.hideMV)
						.hidePhoto(configData.hidePhoto)
						.hideRec(configData.hideRec)
						// 设置mv最小时长
						.setCameraMVMinTime(configData.cameraMVMinTime)
						// 设置mv最大时长
						.setCameraMVMaxTime(configData.cameraMVMaxTime)

						// 开启相机水印时需注册水印
						// XpkSdk.registerOSDBuilder(CameraWatermarkBuilder.class);
						// 相机录制水印
						.enableWatermark(configData.enableCameraWatermark)
						// 相机录制结束时片尾水印时长(0-1.0 单位：秒)
						.setCameraTrailerTime(configData.cameraWatermarkEnd)
						// 是否启用防篡改录制
						.enableAntiChange(configData.enableAntiChange).get());

	}

	/**
	 * 短视频录制推荐参数
	 */
	private void initCameraShortVideoConfig() {

		CameraConfiguration cameraConfig = new CameraConfiguration.Builder()
		// 为true代表多次拍摄，拍摄完成一段之后，将保存至相册并开始下一段拍摄，默认为false单次拍摄，拍摄完成后返回资源地址
				.useMultiShoot(false)
				/**
				 * 设置录制时默认界面:<br>
				 * 默认16：9录制:<br>
				 * CameraConfiguration. WIDE_SCREEN_CAN_CHANGE<br>
				 * 默认1：1:<br>
				 * CameraConfiguration. SQUARE_SCREEN_CAN_CHANGE<br>
				 * 仅1：1录制:<br>
				 * CameraConfiguration.ONLY_SQUARE_SCREEN
				 */
				.setCameraUIType(CameraConfiguration.ONLY_SQUARE_SCREEN)
				// 设置拍摄完成后，是否保存至相册（仅单次拍摄方式有效），同时通过onActivityResult及SIMPLE_CAMERA_REQUEST_CODE返回
				.setSingleCameraSaveToAlbum(true)
				// 设置录制时是否静音，true代表录制后无声音
				.setAudioMute(false)
				// 设置是否启用faceunity
				.setEnableFace(false)
				// 设置Faceunity鉴权证书
				// .setPack(authpack.A())
				// 设置是否默认为后置摄像头
				.setDefaultRearCamera(false)
				// 是否显示相册按钮
				.enableAlbum(true)
				// 是否使用自定义相册
				.useCustomAlbum(false)
				// 设置隐藏拍摄功能（全部隐藏将强制开启视频拍摄）
				.hideMV(false).hidePhoto(true).hideRec(true)
				// 设置mv最小时长
				.setCameraMVMinTime(3)
				// 设置mv最大时长
				.setCameraMVMaxTime(15).get();
		// 视频编辑UI配置
		UIConfiguration uiConfig = new UIConfiguration.Builder()
		// 设置横竖屏，参数分别有 0:自动，1:竖屏，2:横屏
		// 设置横竖屏，参数分别有 0:自动，1:竖屏，2:横屏
				.setOrientation(UIConfiguration.ORIENTATION_PORTRAIT)
				// 设置是否使用自定义相册
				.useCustomAlbum(false)
				// 设置MV和mv网络地址
				.enableMV(true, ConfigData.WEB_MV_URL)
				// 配音模式
				.setVoiceLayoutType(UIConfiguration.VOICE_LAYOUT_2)
				// 滤镜二
				.setFilterType(UIConfiguration.FILTER_LAYOUT_2)
				// 配乐方式2
				.setSoundTrackType(UIConfiguration.SOUND_TRACK_LAYOUT_2)
				// 设置画面比例为1:1
				.setVideoProportion(UIConfiguration.PROPORTION_SQUARE)
				// 相册仅支持视频
				.setAlbumSupportFormat(UIConfiguration.ALBUM_SUPPORT_VIDEO_ONLY)
				// 设置视频选择最大数量
				.setMediaCountLimit(1)
				// 设置隐藏相册中的拍摄按钮
				.enableAlbumCamera(false)
				// 隐藏字幕
				.setEditAndExportModuleVisibility(EditAndExportModules.TITLING,
						false)
				// 隐藏片段编辑
				.setEditAndExportModuleVisibility(
						EditAndExportModules.CLIP_EDITING, false)
				// 隐藏特效
				.setEditAndExportModuleVisibility(
						EditAndExportModules.SPECIAL_EFFECTS, false)
				// 启用自动重播
				.enableAutoRepeat(true).get();

		TrimConfiguration trimConfig = new TrimConfiguration.Builder()
		// 设置默认裁剪区域为1:1
				.setDefault1x1CropMode(true)
				// 设置截取返回类型
				.setTrimReturnMode(TrimConfiguration.TRIM_RETURN_TIME)
				// 设置截取类型
				.setTrimType(TrimConfiguration.TRIM_TYPE_SINGLE_FIXED)
				// 设置是否显示1：1按钮
				.enable1x1(false)
				// 设置定长截取时间
				.setTrimDuration(15).get();
		XpkSdk.getXpksdkService().initConfiguration(null, uiConfig,
				cameraConfig);
		XpkSdk.getXpksdkService().initTrimConfiguration(trimConfig);
	}

	/**
	 * 初始压缩配置
	 */
	private void initCompressConfig() {
		XpksdkService xpkService = XpkSdk.getXpksdkService();
		if (null != xpkService) {
			xpkService
					.initCompressConfiguration(new CompressConfiguration.Builder()
					// 设置是否使用硬件加速
							.enableHWCode(configData.enableHWCode)
							// 设置压缩视频码率
							.setBitRate(configData.compressBitRate)
							// 是否显示水印
							.enableWatermark(configData.enableCompressWatermark)
							// 显示水印的位置
							.setWatermarkPosition(
									configData.compressWatermarkShowRect)
							// 设置视频分辨率
							.setVideoSize(configData.compressVideoWidth,
									configData.compressVideoHeight)
							// 设置保存路径
							.setSavePath(
									Environment.getExternalStorageDirectory()
											+ "/xpkVideos/").get());
		}
	}

	/**
	 * 初始视频截取配置
	 */
	private void initTrimConfig() {
		XpksdkService xpkService = XpkSdk.getXpksdkService();
		if (null != xpkService) {
			xpkService
					.initTrimConfiguration(new TrimConfiguration.Builder()
							// 设置默认裁剪区域为1:1
							.setDefault1x1CropMode(
									configData.default1x1CropMode)
							// 设置是否显示1:1裁剪按钮
							.enable1x1(configData.enable1x1)
							.
							// 设置截取返回类型
							setTrimReturnMode(configData.mTrimReturnMode)
							// 设置截取类型
							.setTrimType(configData.mTrimType)
							// 设置两定长截取时间
							.setTrimDuration(configData.trimTime1,
									configData.trimTime2)
							// 设置单个定长截取时间
							.setTrimDuration(configData.trimSingleFixedDuration)
							.get());
		}
	}

	@SuppressLint("NewApi")
	@Override
	public void onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults) {
		switch (requestCode) {
		case REQUEST_CODE_READ_EXTERNAL_STORAGE_PERMISSIONS: {
			for (int i = 0; i < permissions.length; i++) {
				if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
					if (!XpkSdk.isInitialized()) {
						((AppImpl) getApplication()).initXpkSdk();
					}
					exportDemoResource();
				} else {
					Toast.makeText(this, "未允许读写存储！", Toast.LENGTH_SHORT).show();
					finish();
				}
			}
		}
			break;
		default: {
			super.onRequestPermissionsResult(requestCode, permissions,
					grantResults);
		}
		}
	}

	/**
	 * 响应点击
	 * 
	 * @param v
	 */
	public void onVideo(View v) {
		switch (v.getId()) {
		case R.id.xpkrec_square: // 正方形录制视频，编辑录制后的视频，如果有导出时，导出视频的路径
			XpkSdk.registerOSDBuilder(CameraWatermarkBuilder.class);
			initCameraConfig(CameraConfiguration.ONLY_SQUARE_SCREEN);
			XpkSdk.onXpkCamera(this, XPK_CAMERA_REQUEST_CODE);
			break;
		case R.id.xpkrec_wide: // 长方形录制视频，编辑录制后的视频，如果有导出时，导出视频的路径
			XpkSdk.registerOSDBuilder(null);// 测试置NULL
			initCameraConfig(CameraConfiguration.WIDE_SCREEN_CAN_CHANGE);
			XpkSdk.onXpkCamera(this, XPK_CAMERA_REQUEST_CODE);
			break;
		case R.id.xpkrec: // 正方形，长方形可切换录制视频，编辑录制后的视频，如果有导出时，导出视频的路径
			XpkSdk.registerOSDBuilder(CameraWatermarkBuilder.class);
			initCameraConfig(CameraConfiguration.SQUARE_SCREEN_CAN_CHANGE);
			XpkSdk.onXpkCamera(this, XPK_CAMERA_REQUEST_CODE);
			break;
		case R.id.xpkedit: // 传递资源路径，进入视频编辑，返回导出的视频的地址
			initEditorUIAndExportConfig();
			XpkSdk.getXpksdkService().initConfiguration(
					new CameraConfiguration.Builder().get());
			ArrayList<String> list = new ArrayList<String>();
			list.add(EDIT_PICTURE_PATH);
			list.add(EDIT_L_VIDEO_PATH);
			onXpkEdit(SimpleActivity.this, list, XPK_EDIT_REQUEST_CODE);
			break;
		case R.id.xpk: // 进入sdk媒体资源的选择界面(图片、视频)
			initEditorUIAndExportConfig();
			XpkSdk.getXpksdkService().initConfiguration(
					new CameraConfiguration.Builder().get());
			XpkSdk.onXpkVideo(this, XPK_EDIT_REQUEST_CODE);
			break;
		case R.id.xpk_player: // 播放器

			initUIAblumConfig();
			XpkSdk.onXpkAlbum(this, UIConfiguration.ALBUM_SUPPORT_VIDEO_ONLY,
					XPK_ALBUM_PLAYER_REQUEST_CODE);

			break;
		case R.id.xpk_trim_l: // 截取横屏视频
			initTrimConfig();
			onXpkTrimVideo(this, EDIT_L_VIDEO_PATH, XPK_TRIM_REQUEST_CODE);
			break;
		case R.id.xpk_trim_p: // 截取竖屏视频
			initTrimConfig();
			onXpkTrimVideo(this, EDIT_P_VIDEO_PATH, XPK_TRIM_REQUEST_CODE);
			break;
		case R.id.xpk_trim_s: // 截取正方型视频
			initTrimConfig();
			onXpkTrimVideo(this, EDIT_S_VIDEO_PATH, XPK_TRIM_REQUEST_CODE);
			break;
		case R.id.xpk_default_album: // 默认相册（支持图片和视频）
			initEditorUIAndExportConfig();
			XpkSdk.getXpksdkService().initConfiguration(
					new CameraConfiguration.Builder().get());
			XpkSdk.onXpkAlbum(this, UIConfiguration.ALBUM_SUPPORT_DEFAULT,
					XPK_ALBUM_REQUEST_CODE);
			break;
		case R.id.xpk_only_video: // 相册只显示视频
			initEditorUIAndExportConfig();
			XpkSdk.getXpksdkService().initConfiguration(
					new CameraConfiguration.Builder().get());
			XpkSdk.onXpkAlbum(this, UIConfiguration.ALBUM_SUPPORT_VIDEO_ONLY,
					XPK_ALBUM_REQUEST_CODE);
			break;
		case R.id.xpk_only_photo: // 相册只显示图片
			initEditorUIAndExportConfig();
			XpkSdk.getXpksdkService().initConfiguration(
					new CameraConfiguration.Builder().get());
			XpkSdk.onXpkAlbum(this, UIConfiguration.ALBUM_SUPPORT_IMAGE_ONLY,
					XPK_ALBUM_REQUEST_CODE);
			break;
		case R.id.xpk_compress: // 压缩视频
			// 选折要压缩的视频
			initUIAblumConfig();
			XpkSdk.onXpkAlbum(this, UIConfiguration.ALBUM_SUPPORT_VIDEO_ONLY,
					XPK_ALBUM_COMPRESS_REQUEST_CODE);

			break;
		case R.id.xpk_ui_config: // ui配置
			if (isConfigDialogShow) {
				return;
			}
			new EditorUIAndExportConfigDialog(this, new ConfigDialogListener() {

				@Override
				public void onSaveConfigData(ConfigData configData) {
					initAndGetConfigData().setConfig(configData);
					initEditorUIAndExportConfig();
					initCameraConfig(CameraConfiguration.SQUARE_SCREEN_CAN_CHANGE);
					saveConfigInstanceState();
				}

				@Override
				public void onDismiss(DialogInterface dialog) {
					isConfigDialogShow = false;
				}
			}, configData);
			isConfigDialogShow = true;
			break;
		case R.id.xpk_camera_config: // 拍摄配置
			if (isConfigDialogShow) {
				return;
			}
			new CameraConfigDialog(this, new ConfigDialogListener() {

				@Override
				public void onSaveConfigData(ConfigData configData) {
					initAndGetConfigData().setConfig(configData);
					saveConfigInstanceState();
				}

				@Override
				public void onDismiss(DialogInterface dialog) {
					isConfigDialogShow = false;
				}
			}, configData);
			isConfigDialogShow = true;
			break;
		case R.id.xpk_trim_config: // 截取配置
			if (isConfigDialogShow) {
				return;
			}
			new VideoTrimConfigDialog(this, new ConfigDialogListener() {

				@Override
				public void onSaveConfigData(ConfigData configData) {
					initAndGetConfigData().setConfig(configData);
					saveConfigInstanceState();
				}

				@Override
				public void onDismiss(DialogInterface dialog) {
					isConfigDialogShow = false;
				}
			}, configData);
			isConfigDialogShow = true;
			break;
		case R.id.xpk_album_config: // 相册配置
			if (isConfigDialogShow) {
				return;
			}
			new AlbumConfigDialog(this, new ConfigDialogListener() {

				@Override
				public void onSaveConfigData(ConfigData configData) {
					initAndGetConfigData().setConfig(configData);
					saveConfigInstanceState();
				}

				@Override
				public void onDismiss(DialogInterface dialog) {
					isConfigDialogShow = false;
				}
			}, configData);
			isConfigDialogShow = true;
			break;
		case R.id.xpk_compress_config: // 压缩配置
			if (isConfigDialogShow) {
				return;
			}
			new CompressConfigDialog(this, new ConfigDialogListener() {

				@Override
				public void onSaveConfigData(ConfigData configData) {
					initAndGetConfigData().setConfig(configData);
					initCompressConfig();
					saveConfigInstanceState();
				}

				@Override
				public void onDismiss(DialogInterface dialog) {
					isConfigDialogShow = false;
				}
			}, configData);
			isConfigDialogShow = true;
			break;

		case R.id.xpkSVideoEdit:// 15秒短视频
			initCameraShortVideoConfig();
			XpkSdk.onXpkCamera(this, XPK_SHORTVIDEO_CAMERA_REQUEST_CODE);
			break;
		case R.id.reset_config:
			resetConfigInstanceState();
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == XPK_CAMERA_REQUEST_CODE) {
			if (resultCode == XpkSdk.RESULT_CAMERA_TO_ALBUM) {
				// 点击拍摄的相册按钮，将返回在此，并在这里做进入相册界面操作
				XpkSdk.onXpkAlbum(this, UIConfiguration.ALBUM_SUPPORT_DEFAULT,
						XPK_ALBUM_REQUEST_CODE);
			} else if (resultCode == RESULT_OK) {
				// 拍摄后返回的媒体路径
				ArrayList<String> arrMediaListPath = new ArrayList<String>();
				arrMediaListPath.add(data
						.getStringExtra(XpkSdk.INTENT_KEY_VIDEO_PATH));
				arrMediaListPath.add(data
						.getStringExtra(XpkSdk.INTENT_KEY_PICTURE_PATH));
				String logInfo = String.format("Video path：%s,Picture path：%s",
						data.getStringExtra(XpkSdk.INTENT_KEY_VIDEO_PATH),
						data.getStringExtra(XpkSdk.INTENT_KEY_PICTURE_PATH));
				Log.d(TAG, logInfo);
				onXpkEdit(this, arrMediaListPath);

				// Intent intent = new Intent(this, VideoPlayerActivity.class);
				// intent.putExtra(VideoPlayerActivity.ACTION_PATH,
				// data.getStringExtra(XpkSdk.INTENT_KEY_VIDEO_PATH));
				// startActivity(intent);

			}
		} else if (requestCode == XPK_ALBUM_REQUEST_CODE) {
			if (resultCode == XpkSdk.RESULT_ALBUM_TO_CAMERA) {
				// 点击相册的拍摄按钮，将返回在此，并在这里做进入拍摄界面操作
				XpkSdk.onXpkCamera(this, XPK_CAMERA_REQUEST_CODE);
			} else if (resultCode == RESULT_OK) {
				// 返回选择的图片视频地址list
				ArrayList<String> arrMediaListPath = data
						.getStringArrayListExtra(XpkSdk.XPK_ALBUM_RESULT);
				String logInfo = "";
				for (String path : arrMediaListPath) {
					Log.d(TAG, path);
					logInfo += path + "\n";
				}
				Toast.makeText(this, logInfo, Toast.LENGTH_LONG).show();
			}
		} else if (requestCode == XPK_EDIT_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				String mediaPath = data.getStringExtra(XpkSdk.XPK_EDIT_RESULT);
				if (mediaPath != null) {
					Log.d(TAG, mediaPath);
					Toast.makeText(this, mediaPath, Toast.LENGTH_LONG).show();
				}
			}
		} else if (requestCode == XPK_TRIM_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				int startTime = data.getIntExtra(XpkSdk.TRIM_START_TIME, 0);
				int endTime = data.getIntExtra(XpkSdk.TRIM_END_TIME, 0);
				Rect rect = data.getParcelableExtra(XpkSdk.TRIM_CROP_RECT);
				String logInfo = "截取开始时间:" + startTime + "ms" + ",结束时间:"
						+ endTime + "ms\n裁剪区域：" + rect;
				Log.d(TAG, logInfo);
				Toast.makeText(this, logInfo, Toast.LENGTH_LONG).show();
			}
		} else if (requestCode == XPK_SHORTVIDEO_CAMERA_REQUEST_CODE) {// 短视频录制
			if (resultCode == XpkSdk.RESULT_CAMERA_TO_ALBUM) {
				// TODO: 按下拍摄的相册按钮，在此进入相册
				XpkSdk.onXpkAlbum(this,
						UIConfiguration.ALBUM_SUPPORT_VIDEO_ONLY,
						XPK_SHORTVIDEO_ALBUM_REQUEST_CODE);
			} else if (resultCode == RESULT_OK) {
				// TODO: 拍摄完成，在此进入编辑界面
				ArrayList<String> arrMediaListPath = new ArrayList<String>();
				arrMediaListPath.add(data
						.getStringExtra(XpkSdk.INTENT_KEY_VIDEO_PATH));
				onXpkEdit(this, arrMediaListPath);
			}
		} else if (requestCode == XPK_SHORTVIDEO_ALBUM_REQUEST_CODE) {
			if (resultCode == XpkSdk.RESULT_ALBUM_TO_CAMERA) {
				// TODO: 按下相册的拍摄按钮，在此进入拍摄界面
				XpkSdk.onXpkCamera(this, XPK_SHORTVIDEO_CAMERA_REQUEST_CODE);
			} else if (resultCode == RESULT_OK) {
				// TODO: 选择媒体结束后，在此进入截取界面
				ArrayList<String> arrCameraMediaListPath = data
						.getStringArrayListExtra(XpkSdk.XPK_ALBUM_RESULT);
				if (arrCameraMediaListPath != null) {
					if (arrCameraMediaListPath.get(0) != null) {
						String path = arrCameraMediaListPath.get(0);
						// 获取视频信息
						VideoMetadataRetriever vmr = new VideoMetadataRetriever();
						vmr.setDataSource(path);
						int duration = Integer
								.valueOf(vmr
										.extractMetadata(VideoMetadataRetriever.METADATA_KEY_VIDEO_DURATION));
						int videoHeight = Integer
								.valueOf(vmr
										.extractMetadata(VideoMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT));
						int videoWidth = Integer
								.valueOf(vmr
										.extractMetadata(VideoMetadataRetriever.METADATA_KEY_VIDEO_WIDHT));

						if (duration < 15000 && videoHeight == videoWidth) {
							// TODO: 视频小于15秒且为正方形视频，将跳过截取，进入编辑界面
							onXpkEdit(SimpleActivity.this,
									arrCameraMediaListPath,
									XPK_EDIT_REQUEST_CODE);
							return;
						}
						onXpkTrimVideo(SimpleActivity.this,
								arrCameraMediaListPath.get(0),
								XPK_SHORTVIDEO_TRIM_REQUEST_CODE);
					}
				}
			}
		} else if (requestCode == XPK_SHORTVIDEO_TRIM_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				// TODO: 截取完成，在此进入编辑界面
				EditObject eo = new EditObject(
						data.getStringExtra(XpkSdk.TRIM_MEDIA_PATH));
				eo.setCropRect((Rect) data
						.getParcelableExtra(XpkSdk.TRIM_CROP_RECT));
				eo.setStartTime(data.getIntExtra(XpkSdk.TRIM_START_TIME, 0));
				eo.setEndTime(data.getIntExtra(XpkSdk.TRIM_END_TIME, 0));
				onXpkEdit(this, eo, XPK_EDIT_REQUEST_CODE);
			}
		} else if (requestCode == XPK_ALBUM_COMPRESS_REQUEST_CODE) {
			// 选择要压缩的视频资源
			if (resultCode == RESULT_OK) {
				// 返回选择的图片视频地址list
				ArrayList<String> arrMediaListPath = data
						.getStringArrayListExtra(XpkSdk.XPK_ALBUM_RESULT);
				if (arrMediaListPath.size() > 0) {
					if (!TextUtils.isEmpty(arrMediaListPath.get(0))) {
						XpkSdk.onCompressVideo(this, arrMediaListPath.get(0),
								iCompressVideoCallback);
					}
				}
			}
		} else if (requestCode == XPK_ALBUM_PLAYER_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				// 返回选择的视频地址list
				ArrayList<String> arrMediaListPath = data
						.getStringArrayListExtra(XpkSdk.XPK_ALBUM_RESULT);
				if (arrMediaListPath.size() > 0) {
					if (!TextUtils.isEmpty(arrMediaListPath.get(0))) {
						Intent intent = new Intent(this,
								VideoPlayerActivity.class);
						intent.putExtra(VideoPlayerActivity.ACTION_PATH,
								arrMediaListPath.get(0));
						startActivity(intent);
					}
				}
			}
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		XpkSdk.exitApp(this);
	}

	// 防止多次弹出对话框
	private boolean isConfigDialogShow;
	private ConfigData configData;

	/**
	 * 初始化并返回配置
	 */
	private ConfigData initAndGetConfigData() {
		if (configData == null) {
			configData = new ConfigData();
		}
		return configData;
	}

	private void exportDemoResource() {
		if (!new File(EDIT_PICTURE_PATH).exists()
				|| !new File(EDIT_L_VIDEO_PATH).exists()
				|| !new File(EDIT_S_VIDEO_PATH).exists()
				|| !new File(EDIT_P_VIDEO_PATH).exists()) {
			new AsyncTask<Integer, Integer, Integer>() {
				private ProgressDialog m_dlgProgress;

				@Override
				protected void onPreExecute() {
					m_dlgProgress = ProgressDialog.show(SimpleActivity.this,
							null, "导出测试资源...");
				}

				@Override
				protected Integer doInBackground(Integer... params) {
					if (!new File(EDIT_PICTURE_PATH).exists()) {
						// 导出测试编辑资源
						SDKUtils.assetRes2File(getAssets(),
								"demomedia/android.jpg", EDIT_PICTURE_PATH);
					}
					if (!new File(EDIT_L_VIDEO_PATH).exists()) {
						SDKUtils.assetRes2File(getAssets(),
								"demomedia/demoVideo1.mp4", EDIT_L_VIDEO_PATH);
					}
					if (!new File(EDIT_S_VIDEO_PATH).exists()) {
						SDKUtils.assetRes2File(getAssets(),
								"demomedia/demoVideo2.mp4", EDIT_S_VIDEO_PATH);
					}
					if (!new File(EDIT_P_VIDEO_PATH).exists()) {
						SDKUtils.assetRes2File(getAssets(),
								"demomedia/demoVideo3.mp4", EDIT_P_VIDEO_PATH);
					}
					return null;
				}

				@Override
				protected void onPostExecute(Integer result) {
					m_dlgProgress.dismiss();
					m_dlgProgress = null;
				}
			}.execute();
		}
	}

	/**
	 * 压缩视频回调函数
	 */
	private ICompressVideoCallback iCompressVideoCallback = new ICompressVideoCallback() {
		private AlertDialog dialog;
		private ProgressBar progressBar;
		private Button btnCancel;

		@Override
		public void onCompressStart() {
			View v = LayoutInflater.from(SimpleActivity.this).inflate(
					R.layout.progress_view, null);
			progressBar = (ProgressBar) v.findViewById(R.id.pbCompress);
			btnCancel = (Button) v.findViewById(R.id.btnCancelCompress);
			btnCancel.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					XpkSdk.cancelCompressVideo();
				}
			});
			dialog = new AlertDialog.Builder(SimpleActivity.this).setView(v)
					.show();
			dialog.setCanceledOnTouchOutside(false);
		}

		@Override
		public void onProgress(int progress, int max) {
			if (progressBar != null) {
				progressBar.setMax(max);
				progressBar.setProgress(progress);
			}
		}

		@Override
		public void onCompressError(String errorLog) {
			Log.e(TAG, errorLog);
			if (dialog != null) {
				dialog.dismiss();
				dialog = null;
			}
		}

		@Override
		public void onCompressComplete(String path) {
			Intent intent = new Intent(SimpleActivity.this,
					VideoPlayerActivity.class);
			intent.putExtra(VideoPlayerActivity.ACTION_PATH, path);
			startActivity(intent);
			if (dialog != null) {
				dialog.dismiss();
				dialog = null;
			}
		}
	};

	/**
	 * 重置持续化保存的配置
	 */
	private void resetConfigInstanceState() {
		configData = null;
		Toast.makeText(this,
				"所有设置重置" + (saveConfigInstanceState() ? "成功！" : "失败！"),
				Toast.LENGTH_SHORT).show();
	}

	/**
	 * 持续化保存配置
	 */
	private boolean saveConfigInstanceState() {
		SharedPreferences sharedPreferences = getSharedPreferences("demo",
				Context.MODE_PRIVATE);
		return XpksdkService.saveObject(sharedPreferences, "CONFIG_DATA",
				initAndGetConfigData());
	}

	/**
	 * 还原持续久化保存的配置
	 */
	private void restoreConfigInstanceState() {
		SharedPreferences sharedPreferences = getSharedPreferences("demo",
				Context.MODE_PRIVATE);
		configData = XpksdkService.restoreObject(sharedPreferences,
				"CONFIG_DATA", initAndGetConfigData());
	}
}
