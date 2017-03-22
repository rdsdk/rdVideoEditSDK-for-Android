package com.rd.xpkuisdk.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.rd.xpkuisdk.ICompressVideoCallback;
import com.rd.xpkuisdk.XpkSdk;
import com.rd.xpkuisdk.XpksdkService;
import com.rd.xpkuisdk.manager.CameraConfiguration;
import com.rd.xpkuisdk.manager.CompressConfiguration;
import com.rd.xpkuisdk.manager.ExportConfiguration;
import com.rd.xpkuisdk.manager.UIConfiguration;
import com.rd.xpkuisdk.manager.UIConfiguration.ClipEditingModules;
import com.rd.xpkuisdk.manager.UIConfiguration.EditAndExportModules;

/**
 * xpkUISDK演示页
 */
@TargetApi(23)
public class SimpleActivity extends Activity {
	private final String TAG = this.toString();
	private final String EDIT_PICTURE_PATH = Environment
			.getExternalStorageDirectory() + "/android.png";
	private final String EDIT_VIDEO_PATH = Environment
			.getExternalStorageDirectory() + "/RXG1.mp4";
	private String videoTrailerPath = null;
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
	 * REQUEST_CODE定义：<br>
	 * 视频编辑
	 */
	private final int XPK_EDIT_REQUEST_CODE = 102;
	/**
	 * REQUEST_CODE定义：<br>
	 * 读取外置存储
	 */
	private static final int REQUEST_CODE_READ_EXTERNAL_STORAGE_PERMISSIONS = 1;

	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
			finish();
			return;
		}
		setContentView(R.layout.activity_simple_layout);
		initConfigData();
		if (getLastNonConfigurationInstance() != null) {
			configData = (ConfigData) getLastNonConfigurationInstance();
		}

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
		initUIAndExportConfig();
	}

	private void initUIAndExportConfig() {
		if (configData == null) {
			configData = new ConfigData();
		}
		// UI配置
		UIConfiguration uiConfig = new UIConfiguration.Builder()
				// 设置横竖屏，参数分别有 0:自动，1:竖屏，2:横屏
				.setOrientation(configData.orientation)
				// 设置是否使用自定义相册
				.useCustomAlbum(false)
				// 设置向导化
				.enableWizard(configData.enableWizard)
				// 设置秀拍客相册支持格式
				.setAlbumSupportFormat(configData.albumSupportFormatType)
				// 设置默认进入界面画面比例
				.setVideoProportion(configData.videoProportionType)
				// 设置配乐界面风格
				.setSoundTrackType(configData.soundTrakLayoutType)
				// 设置滤镜界面风格
				.setFilterType(configData.filterLayoutType)
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
						configData.enableText).get();

		// 导出视频参数配置
		ExportConfiguration exportConfig = new ExportConfiguration.Builder()
		// 设置保存路径，传null或不设置
		// 将保存至默认路径(即调用XpkSdk.init初始时自定义路径$strCustomRootPath$/xpkVideos）
				.setSavePath(null)
				// 设置片尾图片路径，传null或者不设置 将没有片尾
				.setTrailerPath(videoTrailerPath)
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

	private void initCameraConfig(int UIType) {
		XpksdkService xpkService = XpkSdk.getXpksdkService();
		if (null != xpkService) {
			xpkService.initConfiguration(new CameraConfiguration.Builder()
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
					// 设置是否打开人脸
					.setEnableFace(configData.isDefaultFace)
					// 设置FaceUnity解密key
					.setPack(authpack.A())
					// 设置是否默认为后置摄像头
					.setDefaultRearCamera(configData.isDefaultRearCamera)
					// 是否显示相册按钮
					.enableAlbum(configData.enableAlbum)
					// 是否使用自定义相册
					.useCustomAlbum(configData.useCustomAlbum).get());
		}
	}

	private void initCompressConfig() {
		XpksdkService xpkService = XpkSdk.getXpksdkService();
		if (null != xpkService) {
			xpkService
					.initCompressConfiguration(new CompressConfiguration.Builder()
					// 设置压缩视频码率
							.setBitRate(configData.compressBitRate)
							// 是否显示水印
							.enableWatermark(configData.enableCompressWatermark)
							// 显示水印的位置
							.setWatermarkPosition(
									configData.compressWatermarkPosition)
							// 设置视频分辨率
							.setVideoSize(configData.compressVideoWidth,
									configData.compressVideoHeight).get());
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
			initCameraConfig(CameraConfiguration.ONLY_SQUARE_SCREEN);
			XpkSdk.onXpkCamera(this, XPK_CAMERA_REQUEST_CODE);
			break;
		case R.id.xpkrec_wide: // 长方形录制视频，编辑录制后的视频，如果有导出时，导出视频的路径
			initCameraConfig(CameraConfiguration.WIDE_SCREEN_CAN_CHANGE);
			XpkSdk.onXpkCamera(this, XPK_CAMERA_REQUEST_CODE);
			break;
		case R.id.xpkrec: // 正方形，长方形可切换录制视频，编辑录制后的视频，如果有导出时，导出视频的路径
			initCameraConfig(CameraConfiguration.SQUARE_SCREEN_CAN_CHANGE);
			XpkSdk.onXpkCamera(this, XPK_CAMERA_REQUEST_CODE);
			break;
		case R.id.xpkedit: // 传递资源路径，进入视频编辑，返回导出的视频的地址
			ArrayList<String> list = new ArrayList<String>();
			list.add(EDIT_PICTURE_PATH);
			list.add(EDIT_VIDEO_PATH);
			XpkSdk.onXpkEdit(SimpleActivity.this, list, XPK_EDIT_REQUEST_CODE);
			break;
		case R.id.xpk: // 进入sdk媒体资源的选择界面(图片、视频)
			XpkSdk.onXpkVideo(this, XPK_EDIT_REQUEST_CODE);
			break;
		case R.id.xpk_player: // 播放器
			Intent intent = new Intent(this, VideoPlayerActivity.class);
			intent.putExtra(VideoPlayerActivity.ACTION_PATH, EDIT_VIDEO_PATH);
			startActivity(intent);
			break;
		case R.id.xpk_trim: // 自由截取
			XpkSdk.onXpkTrimVideo(this, EDIT_VIDEO_PATH,
					Environment.getExternalStorageDirectory() + "/xpkVideos/",
					"修剪片段", Color.BLACK, "取消", "下载选中片段", Color.BLACK);
			break;
		case R.id.xpk_trim_item: // 定长截取
			XpkSdk.onXpkTrimVideo(this, EDIT_VIDEO_PATH,
					Environment.getExternalStorageDirectory() + "/xpkVideos/",
					"修剪片段", Color.BLACK, "取消", "下载选中片段", Color.BLACK, 8, 16);
			break;
		case R.id.xpk_default_album: // 默认相册（支持图片和视频）
			XpkSdk.onXpkAlbum(this, UIConfiguration.ALBUM_SUPPORT_DEFAULT,
					XPK_ALBUM_REQUEST_CODE);
			break;
		case R.id.xpk_only_video: // 相册只显示视频
			XpkSdk.onXpkAlbum(this, UIConfiguration.ALBUM_SUPPORT_VIDEO_ONLY,
					XPK_ALBUM_REQUEST_CODE);
			break;
		case R.id.xpk_only_photo: // 相册只显示图片
			XpkSdk.onXpkAlbum(this, UIConfiguration.ALBUM_SUPPORT_IMAGE_ONLY,
					XPK_ALBUM_REQUEST_CODE);
			break;
		case R.id.xpk_compress: // 压缩视频
			XpkSdk.onCompressVideo(this, EDIT_VIDEO_PATH,
					iCompressVideoCallback);
			break;
		case R.id.xpk_ui_config: // ui配置
			if (isConfigDialogShow) {
				return;
			}
			View uiConfigView = getLayoutInflater().inflate(
					R.layout.ui_config_dialog, null);
			AlertDialog uiConfigDialog = new AlertDialog.Builder(
					SimpleActivity.this).setView(uiConfigView)
					.setPositiveButton("返回", null)
					.setNegativeButton("保存", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							saveUIConfigData();
							initUIAndExportConfig();
							initCameraConfig(CameraConfiguration.SQUARE_SCREEN_CAN_CHANGE);
						}
					}).show();
			uiConfigDialog.setOnDismissListener(new OnDismissListener() {

				@Override
				public void onDismiss(DialogInterface dialog) {
					isConfigDialogShow = false;
				}
			});
			isConfigDialogShow = true;
			initUiDialogView(uiConfigView);

			break;
		case R.id.xpk_camera_config: // 拍摄配置
			if (isConfigDialogShow) {
				return;
			}
			View cameraConfigView = getLayoutInflater().inflate(
					R.layout.camera_config_dialog, null);
			AlertDialog cameraConfigDialog = new AlertDialog.Builder(
					SimpleActivity.this).setView(cameraConfigView)
					.setPositiveButton("返回", null)
					.setNegativeButton("保存", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							saveCameraConfigData();
						}
					}).show();
			cameraConfigDialog.setOnDismissListener(new OnDismissListener() {

				@Override
				public void onDismiss(DialogInterface dialog) {
					isConfigDialogShow = false;
				}
			});
			isConfigDialogShow = true;
			initCameraDialogView(cameraConfigView);

			break;
		case R.id.xpk_compress_config: // 压缩配置
			if (isConfigDialogShow) {
				return;
			}
			View compressConfigView = getLayoutInflater().inflate(
					R.layout.compress_config_dialog, null);
			AlertDialog compressConfigDialog = new AlertDialog.Builder(
					SimpleActivity.this).setView(compressConfigView)
					.setPositiveButton("返回", null)
					.setNegativeButton("保存", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							saveCompressConfigData();
							initCompressConfig();
						}
					}).show();
			compressConfigDialog.setOnDismissListener(new OnDismissListener() {

				@Override
				public void onDismiss(DialogInterface dialog) {
					isConfigDialogShow = false;
				}
			});
			isConfigDialogShow = true;
			initCompressDialogView(compressConfigView);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == XPK_CAMERA_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				ArrayList<String> arrMediaListPath = new ArrayList<String>();
				arrMediaListPath.add(data
						.getStringExtra(XpkSdk.INTENT_KEY_VIDEO_PATH));
				arrMediaListPath.add(data
						.getStringExtra(XpkSdk.INTENT_KEY_PICTURE_PATH));
				XpkSdk.onXpkEdit(this, arrMediaListPath);
				Log.d(TAG, String.format("简单录制返回视频路径为：%s,图片路径为：%s",
						data.getStringExtra(XpkSdk.INTENT_KEY_VIDEO_PATH),
						data.getStringExtra(XpkSdk.INTENT_KEY_PICTURE_PATH)));
			}
		} else if (requestCode == XPK_ALBUM_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				// 返回选择的图片视频地址list
				ArrayList<String> arrMediaListPath = data
						.getStringArrayListExtra(XpkSdk.XPK_ALBUM_RESULT);
				for (String path : arrMediaListPath) {
					Log.d(TAG, path);
				}
			}
		} else if (requestCode == XPK_EDIT_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				String mediaPath = data.getStringExtra(XpkSdk.XPK_EDIT_RESULT);
				Log.d(TAG, mediaPath);
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

	// 对话框界面的控件
	private CheckBox imageDuration, edit, trim, videoSpeed, split, copy,
			proportion, sort, text;
	private CheckBox soundTrack, dubbing, filter, titling, specialEffects,
			clipEditing;
	private CheckBox watermark, videoTrailer;
	private Switch swWizard, swIsSaveToAlbum, swEnableAlbum, swUseCustomAlbum;
	private RadioGroup rgProportion, rgSupportFormat, rgSoundTrack, rgFilter,
			rgOrientation, rgCameraMode, rgIsRearCamera, rgFaceUnity;
	private EditText etExportDuration, etCameraMaxTime, etCameraMinTime;
	private EditText etWatermarkXAxis, etWatermarkYAxis, etWatermarkXZoom,
			etWatermarkYZoom;

	private ConfigData configData, tempData;

	private RadioGroup rgCompressWatermark;
	private CheckBox compressWatermark;
	private EditText etCompressBitRate, etCompressVideoWidth,
			etCompressVideoHeight;

	// 保存配置的类
	private class ConfigData {
		// ui配置参数
		boolean enableWizard = false;

		boolean enableImageDuration = true;
		boolean enableEdit = true;
		boolean enableTrim = true;
		boolean enableVideoSpeed = true;
		boolean enableSplit = true;
		boolean enableCopy = true;
		boolean enableProportion = true;
		boolean enableSort = true;
		boolean enableText = true;

		boolean enableSoundTrack = true;
		boolean enableDubbing = true;
		boolean enableFilter = true;
		boolean enableTitling = true;
		boolean enableSpecialEffects = true;
		boolean enableClipEditing = true;

		int videoProportionType = UIConfiguration.PROPORTION_AUTO;
		int albumSupportFormatType = UIConfiguration.ALBUM_SUPPORT_DEFAULT;
		int orientation = UIConfiguration.ORIENTATION_PORTRAIT;

		int soundTrakLayoutType = UIConfiguration.SOUND_TRACK_LAYOUT_1;
		int filterLayoutType = UIConfiguration.FILTER_LAYOUT_1;

		// 导出配置参数
		boolean enableWatermark = true;
		boolean enableVideoTrailer = false;

		RectF watermarkShowRectF = new RectF();
		int exportVideoDuration = 0;

		// 拍摄配置参数
		boolean useMultiShoot = false;
		boolean isSaveToAlbum = false;
		boolean isDefaultRearCamera = false;
		boolean isDefaultFace = true;
		boolean enableAlbum = true;
		boolean useCustomAlbum = false;

		int cameraMinTime = 0;
		int cameraMaxTime = 0;

		// 压缩配置参数
		boolean enableCompressWatermark = false;
		int compressWatermarkPosition = CompressConfiguration.WATERMARK_LEFT_BOTTOM;
		double compressBitRate = 0;
		int compressVideoWidth = 0;
		int compressVideoHeight = 0;

		public void equal(ConfigData data) {
			enableWizard = data.enableWizard;
			isDefaultFace = data.isDefaultFace;
			enableImageDuration = data.enableImageDuration;
			enableEdit = data.enableEdit;
			enableTrim = data.enableTrim;
			enableVideoSpeed = data.enableVideoSpeed;
			enableSplit = data.enableSplit;
			enableCopy = data.enableCopy;
			enableProportion = data.enableProportion;
			enableSort = data.enableSort;
			enableText = data.enableText;

			enableSoundTrack = data.enableSoundTrack;
			enableDubbing = data.enableDubbing;
			enableFilter = data.enableFilter;
			enableTitling = data.enableTitling;
			enableSpecialEffects = data.enableSpecialEffects;
			enableClipEditing = data.enableClipEditing;

			enableWatermark = data.enableWatermark;
			enableVideoTrailer = data.enableVideoTrailer;

			videoProportionType = data.videoProportionType;
			albumSupportFormatType = data.albumSupportFormatType;
			orientation = data.orientation;
			watermarkShowRectF = data.watermarkShowRectF;

			soundTrakLayoutType = data.soundTrakLayoutType;
			filterLayoutType = data.filterLayoutType;

			exportVideoDuration = data.exportVideoDuration;

			useMultiShoot = data.useMultiShoot;
			isSaveToAlbum = data.isSaveToAlbum;
			isDefaultRearCamera = data.isDefaultRearCamera;

			cameraMinTime = data.cameraMinTime;
			cameraMaxTime = data.cameraMaxTime;

			enableAlbum = data.enableAlbum;
			useCustomAlbum = data.useCustomAlbum;

			enableCompressWatermark = data.enableCompressWatermark;
			compressWatermarkPosition = data.compressWatermarkPosition;
			compressBitRate = data.compressBitRate;
			compressVideoWidth = data.compressVideoWidth;
			compressVideoHeight = data.compressVideoHeight;
		}
	}

	private void initUiDialogView(final View view) {
		initConfigData();
		// 控制向导模式开关
		swWizard = (Switch) view.findViewById(R.id.swWizard);
		swWizard.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				TextView tvWizard = (TextView) view.findViewById(R.id.tvWizard);
				if (isChecked) {
					tvWizard.setText("开启向导模式");
				} else {
					tvWizard.setText("关闭向导模式");
				}
				tempData.enableWizard = isChecked;
			}
		});
		swWizard.setChecked(tempData.enableWizard);

		// 配乐界面选择
		rgSoundTrack = (RadioGroup) view.findViewById(R.id.rgSoundTrack);
		if (tempData.soundTrakLayoutType == UIConfiguration.SOUND_TRACK_LAYOUT_1) {
			rgSoundTrack.check(R.id.rbSoundTrak1);
		} else if (tempData.soundTrakLayoutType == UIConfiguration.SOUND_TRACK_LAYOUT_2) {
			rgSoundTrack.check(R.id.rbSoundTrak2);
		}
		rgSoundTrack
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbSoundTrak1) {
							tempData.soundTrakLayoutType = UIConfiguration.SOUND_TRACK_LAYOUT_1;
						} else if (checkedId == R.id.rbSoundTrak2) {
							if (tempData.orientation == UIConfiguration.ORIENTATION_PORTRAIT) {
								tempData.soundTrakLayoutType = UIConfiguration.SOUND_TRACK_LAYOUT_2;
							} else {
								rgSoundTrack.check(R.id.rbSoundTrak1);
								Toast.makeText(getApplicationContext(),
										"只有竖屏支持使用配乐二界面", Toast.LENGTH_SHORT)
										.show();
							}

						}
					}
				});

		// 滤镜界面选择
		rgFilter = (RadioGroup) view.findViewById(R.id.rgFilter);
		if (tempData.filterLayoutType == UIConfiguration.FILTER_LAYOUT_1) {
			rgFilter.check(R.id.rbFilter1);
		} else if (tempData.filterLayoutType == UIConfiguration.FILTER_LAYOUT_2) {
			rgFilter.check(R.id.rbFilter2);
		}
		rgFilter.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.rbFilter1) {
					tempData.filterLayoutType = UIConfiguration.FILTER_LAYOUT_1;
				} else if (checkedId == R.id.rbFilter2) {
					if (tempData.orientation == UIConfiguration.ORIENTATION_PORTRAIT) {
						tempData.filterLayoutType = UIConfiguration.FILTER_LAYOUT_2;
					} else {
						rgFilter.check(R.id.rbFilter1);
						Toast.makeText(getApplicationContext(),
								"只有竖屏支持使用滤镜二界面", Toast.LENGTH_SHORT).show();
					}

				}
			}
		});

		// 选择视频比例
		rgProportion = (RadioGroup) view.findViewById(R.id.rgProportion);
		if (tempData.videoProportionType == UIConfiguration.PROPORTION_AUTO) {
			rgProportion.check(R.id.rbProportionAuto);
		} else if (tempData.videoProportionType == UIConfiguration.PROPORTION_SQUARE) {
			rgProportion.check(R.id.rbProportionSquare);
		} else if (tempData.videoProportionType == UIConfiguration.PROPORTION_LANDSCAPE) {
			rgProportion.check(R.id.rbProportionLandscape);
		}
		rgProportion
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbProportionAuto) {
							tempData.videoProportionType = UIConfiguration.PROPORTION_AUTO;
						} else if (checkedId == R.id.rbProportionSquare) {
							tempData.videoProportionType = UIConfiguration.PROPORTION_SQUARE;
						} else if (checkedId == R.id.rbProportionLandscape) {
							tempData.videoProportionType = UIConfiguration.PROPORTION_LANDSCAPE;
						}
					}
				});

		// 选择秀拍客相册支持的格式
		rgSupportFormat = (RadioGroup) view.findViewById(R.id.rgSupportFormat);
		if (tempData.albumSupportFormatType == UIConfiguration.ALBUM_SUPPORT_DEFAULT) {
			rgSupportFormat.check(R.id.rbSupportDefault);
		} else if (tempData.albumSupportFormatType == UIConfiguration.ALBUM_SUPPORT_IMAGE_ONLY) {
			rgSupportFormat.check(R.id.rbSupportImageOnly);
		} else if (tempData.albumSupportFormatType == UIConfiguration.ALBUM_SUPPORT_VIDEO_ONLY) {
			rgSupportFormat.check(R.id.rbSupportVideoOnly);
		}
		rgSupportFormat
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbSupportDefault) {
							tempData.albumSupportFormatType = UIConfiguration.ALBUM_SUPPORT_DEFAULT;
						} else if (checkedId == R.id.rbSupportImageOnly) {
							tempData.albumSupportFormatType = UIConfiguration.ALBUM_SUPPORT_IMAGE_ONLY;
						} else if (checkedId == R.id.rbSupportVideoOnly) {
							tempData.albumSupportFormatType = UIConfiguration.ALBUM_SUPPORT_VIDEO_ONLY;
						}
					}
				});

		// 设置横竖屏
		rgOrientation = (RadioGroup) view.findViewById(R.id.rgOrientation);
		if (tempData.orientation == UIConfiguration.ORIENTATION_PORTRAIT) {
			rgOrientation.check(R.id.rbOrientationPortrait);
		} else if (tempData.orientation == UIConfiguration.ORIENTATION_LANDSCAPE) {
			rgOrientation.check(R.id.rbOrientationLandscape);
		} else if (tempData.orientation == UIConfiguration.ORIENTATION_AUTO) {
			rgOrientation.check(R.id.rbOrientationAuto);
		}
		rgOrientation
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbOrientationPortrait) {
							tempData.orientation = UIConfiguration.ORIENTATION_PORTRAIT;
						} else if (checkedId == R.id.rbOrientationLandscape) {
							tempData.orientation = UIConfiguration.ORIENTATION_LANDSCAPE;
							rgSoundTrack.check(R.id.rbSoundTrak1);
							rgFilter.check(R.id.rbFilter1);
						} else if (checkedId == R.id.rbOrientationAuto) {
							tempData.orientation = UIConfiguration.ORIENTATION_AUTO;
							rgSoundTrack.check(R.id.rbSoundTrak1);
							rgFilter.check(R.id.rbFilter1);
						}
					}
				});

		// 设置视频水印位置
		etWatermarkXAxis = (EditText) view.findViewById(R.id.etWatermarkXAxis);
		etWatermarkYAxis = (EditText) view.findViewById(R.id.etWatermarkYAxis);
		etWatermarkXZoom = (EditText) view.findViewById(R.id.etWatermarkXZoom);
		etWatermarkYZoom = (EditText) view.findViewById(R.id.etWatermarkYZoom);
		if (tempData.watermarkShowRectF != null) {
			if (tempData.watermarkShowRectF.left != 0) {
				etWatermarkXAxis.setText("" + tempData.watermarkShowRectF.left);
			}
			if (tempData.watermarkShowRectF.top != 0) {
				etWatermarkYAxis.setText("" + tempData.watermarkShowRectF.top);
			}
			if (tempData.watermarkShowRectF.right != 0) {
				etWatermarkXZoom
						.setText("" + tempData.watermarkShowRectF.right);
			}
			if (tempData.watermarkShowRectF.bottom != 0) {
				etWatermarkYZoom.setText(""
						+ tempData.watermarkShowRectF.bottom);
			}
		}

		// 限制导出视频时间的EditText
		etExportDuration = (EditText) view.findViewById(R.id.etTimeLimit);
		if (tempData.exportVideoDuration != 0) {
			etExportDuration.setText("" + tempData.exportVideoDuration);
		}

		// 控制功能模块的CheckBox
		imageDuration = (CheckBox) view.findViewById(R.id.imageDurationControl);
		edit = (CheckBox) view.findViewById(R.id.edit);
		trim = (CheckBox) view.findViewById(R.id.trim);
		videoSpeed = (CheckBox) view.findViewById(R.id.videoSpeedControl);
		split = (CheckBox) view.findViewById(R.id.split);
		copy = (CheckBox) view.findViewById(R.id.copy);
		proportion = (CheckBox) view.findViewById(R.id.proportion);
		sort = (CheckBox) view.findViewById(R.id.sort);
		text = (CheckBox) view.findViewById(R.id.text);

		soundTrack = (CheckBox) view.findViewById(R.id.soundTrack);
		dubbing = (CheckBox) view.findViewById(R.id.dubbing);
		filter = (CheckBox) view.findViewById(R.id.filter);
		titling = (CheckBox) view.findViewById(R.id.titling);
		specialEffects = (CheckBox) view.findViewById(R.id.specialEffects);
		clipEditing = (CheckBox) view.findViewById(R.id.clipEditing);

		watermark = (CheckBox) view.findViewById(R.id.watermark);
		videoTrailer = (CheckBox) view.findViewById(R.id.videoTrailer);

		imageDuration.setOnCheckedChangeListener(UICheckListener);
		edit.setOnCheckedChangeListener(UICheckListener);
		trim.setOnCheckedChangeListener(UICheckListener);
		videoSpeed.setOnCheckedChangeListener(UICheckListener);
		split.setOnCheckedChangeListener(UICheckListener);
		copy.setOnCheckedChangeListener(UICheckListener);
		proportion.setOnCheckedChangeListener(UICheckListener);
		sort.setOnCheckedChangeListener(UICheckListener);
		text.setOnCheckedChangeListener(UICheckListener);

		soundTrack.setOnCheckedChangeListener(UICheckListener);
		dubbing.setOnCheckedChangeListener(UICheckListener);
		filter.setOnCheckedChangeListener(UICheckListener);
		titling.setOnCheckedChangeListener(UICheckListener);
		specialEffects.setOnCheckedChangeListener(UICheckListener);
		clipEditing.setOnCheckedChangeListener(UICheckListener);

		watermark.setOnCheckedChangeListener(UICheckListener);
		videoTrailer.setOnCheckedChangeListener(UICheckListener);

		imageDuration.setChecked(tempData.enableImageDuration);
		edit.setChecked(tempData.enableEdit);
		trim.setChecked(tempData.enableTrim);
		videoSpeed.setChecked(tempData.enableVideoSpeed);
		split.setChecked(tempData.enableSplit);
		copy.setChecked(tempData.enableCopy);
		proportion.setChecked(tempData.enableProportion);
		sort.setChecked(tempData.enableSort);
		text.setChecked(tempData.enableText);

		soundTrack.setChecked(tempData.enableSoundTrack);
		dubbing.setChecked(tempData.enableDubbing);
		filter.setChecked(tempData.enableFilter);
		titling.setChecked(tempData.enableTitling);
		specialEffects.setChecked(tempData.enableSpecialEffects);
		clipEditing.setChecked(tempData.enableClipEditing);

		videoTrailer.setChecked(tempData.enableVideoTrailer);
		watermark.setChecked(tempData.enableWatermark);

		setClipEditingMudulesEnabled(tempData.enableClipEditing);
	}

	OnCheckedChangeListener UICheckListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			int id = buttonView.getId();

			// 片段编辑
			if (id == R.id.imageDurationControl) {
				tempData.enableImageDuration = isChecked;
			} else if (id == R.id.edit) {
				tempData.enableEdit = isChecked;
			} else if (id == R.id.trim) {
				tempData.enableTrim = isChecked;
			} else if (id == R.id.videoSpeedControl) {
				tempData.enableVideoSpeed = isChecked;
			} else if (id == R.id.split) {
				tempData.enableSplit = isChecked;
			} else if (id == R.id.copy) {
				tempData.enableCopy = isChecked;
			} else if (id == R.id.proportion) {
				tempData.enableProportion = isChecked;
			} else if (id == R.id.sort) {
				tempData.enableSort = isChecked;
			} else if (id == R.id.text) {
				tempData.enableText = isChecked;
			}
			// 编辑与导出
			else if (id == R.id.soundTrack) {
				tempData.enableSoundTrack = isChecked;
				View v = (View) buttonView.getParent();
				v.findViewById(R.id.rbSoundTrak1).setEnabled(isChecked);
				v.findViewById(R.id.rbSoundTrak2).setEnabled(isChecked);

			} else if (id == R.id.filter) {
				tempData.enableFilter = isChecked;
				View v = (View) buttonView.getParent();
				v.findViewById(R.id.rbFilter1).setEnabled(isChecked);
				v.findViewById(R.id.rbFilter2).setEnabled(isChecked);

			} else if (id == R.id.dubbing) {
				tempData.enableDubbing = isChecked;
			} else if (id == R.id.titling) {
				tempData.enableTitling = isChecked;
			} else if (id == R.id.specialEffects) {
				tempData.enableSpecialEffects = isChecked;
			} else if (id == R.id.clipEditing) {
				tempData.enableClipEditing = isChecked;
				setClipEditingMudulesEnabled(isChecked);
			}
			// 视频水印
			else if (id == R.id.watermark) {
				tempData.enableWatermark = isChecked;
			}
			// 片尾水印
			else if (id == R.id.videoTrailer) {
				tempData.enableVideoTrailer = isChecked;
			}
		}
	};

	private void setClipEditingMudulesEnabled(boolean enable) {
		imageDuration.setEnabled(enable);
		edit.setEnabled(enable);
		trim.setEnabled(enable);
		videoSpeed.setEnabled(enable);
		split.setEnabled(enable);
		copy.setEnabled(enable);
		proportion.setEnabled(enable);
		sort.setEnabled(enable);
		text.setEnabled(enable);
	}

	/**
	 * 初始化拍摄设置对话框
	 * 
	 * @param view
	 */
	private void initCameraDialogView(View view) {
		initConfigData();

		// 设置默认摄像头方向
		rgIsRearCamera = (RadioGroup) view.findViewById(R.id.rgIsRearCamera);
		rgIsRearCamera
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbFrontCamera) {
							tempData.isDefaultRearCamera = false;
						} else if (checkedId == R.id.rbRearCamera) {
							tempData.isDefaultRearCamera = true;
						}
					}
				});
		if (tempData.isDefaultRearCamera) {
			rgIsRearCamera.check(R.id.rbRearCamera);
		} else {
			rgIsRearCamera.check(R.id.rbFrontCamera);
		}
		rgFaceUnity = (RadioGroup) view.findViewById(R.id.rgCameraFaceGroup);
		rgFaceUnity
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbEnableFace) {
							tempData.isDefaultFace = true;
						} else {
							tempData.isDefaultFace = false;
						}
					}
				});
		if (tempData.isDefaultFace) {
			rgFaceUnity.check(R.id.rbEnableFace);
		} else {
			rgFaceUnity.check(R.id.rbUnableFace);
		}

		// 设置拍摄方式
		rgCameraMode = (RadioGroup) view.findViewById(R.id.rgCameraMode);
		rgCameraMode
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbMultiShoot) {
							tempData.useMultiShoot = true;
						} else if (checkedId == R.id.rbSingleShoot) {
							tempData.useMultiShoot = false;
						}
					}
				});
		if (tempData.useMultiShoot) {
			rgCameraMode.check(R.id.rbMultiShoot);
		} else {
			rgCameraMode.check(R.id.rbSingleShoot);
		}

		// 单次拍摄是否将图片保存至相册
		swIsSaveToAlbum = (Switch) view.findViewById(R.id.swIsSaveToAlbum);
		swIsSaveToAlbum
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						tempData.isSaveToAlbum = isChecked;
					}
				});
		swIsSaveToAlbum.setChecked(tempData.isSaveToAlbum);

		// 是否显示相册按钮
		swEnableAlbum = (Switch) view.findViewById(R.id.swEnableAlbum);
		swEnableAlbum.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				tempData.enableAlbum = isChecked;
			}
		});
		swEnableAlbum.setChecked(tempData.enableAlbum);

		// 是否使用自定义相册
		swUseCustomAlbum = (Switch) view.findViewById(R.id.swUseCustomAlbum);
		swUseCustomAlbum
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						tempData.useCustomAlbum = isChecked;
					}
				});
		swUseCustomAlbum.setChecked(tempData.useCustomAlbum);

		// 设置拍摄最小时长
		etCameraMinTime = (EditText) view.findViewById(R.id.etCameraMinTime);
		if (tempData.cameraMinTime != 0) {
			etCameraMinTime.setText("" + tempData.cameraMinTime);
		}

		// 设置拍摄最大时长
		etCameraMaxTime = (EditText) view.findViewById(R.id.etCameraMaxTime);
		if (tempData.cameraMaxTime != 0) {
			etCameraMaxTime.setText("" + tempData.cameraMaxTime);
		}

	}

	/**
	 * 初始化压缩设置对话框
	 * 
	 * @param view
	 */
	private void initCompressDialogView(View view) {
		initConfigData();
		// 水印开关
		compressWatermark = (CheckBox) view
				.findViewById(R.id.compressWatermark);
		compressWatermark
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						tempData.enableCompressWatermark = isChecked;
						View v = (View) buttonView.getParent();
						v.findViewById(R.id.rbCompressLeftBottom).setEnabled(
								isChecked);
						v.findViewById(R.id.rbCompressLeftTop).setEnabled(
								isChecked);
						v.findViewById(R.id.rbCompressRightBottom).setEnabled(
								isChecked);
						v.findViewById(R.id.rbCompressRightTop).setEnabled(
								isChecked);

					}
				});
		compressWatermark.setChecked(tempData.enableCompressWatermark);

		// 设置压缩视频水印位置
		rgCompressWatermark = (RadioGroup) view
				.findViewById(R.id.rgCompressWatermark);
		if (tempData.compressWatermarkPosition == CompressConfiguration.WATERMARK_LEFT_BOTTOM) {
			rgCompressWatermark.check(R.id.rbCompressLeftBottom);
		} else if (tempData.compressWatermarkPosition == CompressConfiguration.WATERMARK_LEFT_TOP) {
			rgCompressWatermark.check(R.id.rbCompressLeftTop);
		} else if (tempData.compressWatermarkPosition == CompressConfiguration.WATERMARK_RIGHT_BOTTOM) {
			rgCompressWatermark.check(R.id.rbCompressRightBottom);
		} else if (tempData.compressWatermarkPosition == CompressConfiguration.WATERMARK_RIGHT_TOP) {
			rgCompressWatermark.check(R.id.rbCompressRightTop);
		}
		rgCompressWatermark
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbCompressLeftBottom) {
							tempData.compressWatermarkPosition = CompressConfiguration.WATERMARK_LEFT_BOTTOM;
						} else if (checkedId == R.id.rbCompressLeftTop) {
							tempData.compressWatermarkPosition = CompressConfiguration.WATERMARK_LEFT_TOP;
						} else if (checkedId == R.id.rbCompressRightBottom) {
							tempData.compressWatermarkPosition = CompressConfiguration.WATERMARK_RIGHT_BOTTOM;
						} else if (checkedId == R.id.rbCompressRightTop) {
							tempData.compressWatermarkPosition = CompressConfiguration.WATERMARK_RIGHT_TOP;
						}
					}
				});

		// 码率
		etCompressBitRate = (EditText) view
				.findViewById(R.id.etCompressBitRate);
		if (tempData.compressBitRate != 0) {
			etCompressBitRate.setText("" + tempData.compressBitRate);
		}

		// 视频宽度
		etCompressVideoWidth = (EditText) view
				.findViewById(R.id.etCompressVideoWidth);
		if (tempData.compressVideoWidth != 0) {
			etCompressVideoWidth.setText("" + tempData.compressVideoWidth);
		}

		// 视频高度
		etCompressVideoHeight = (EditText) view
				.findViewById(R.id.etCompressVideoHeight);
		if (tempData.compressVideoHeight != 0) {
			etCompressVideoHeight.setText("" + tempData.compressVideoHeight);
		}

	}

	/**
	 * 初始化配置
	 */
	private void initConfigData() {
		if (configData == null) {
			configData = new ConfigData();
		}
		if (tempData == null) {
			tempData = new ConfigData();
		}
		tempData.equal(configData);
	}

	/**
	 * 保存UI设置对话框的参数
	 */
	private void saveUIConfigData() {
		// 读取导出时间限制
		if (etExportDuration != null) {
			if (!TextUtils.isEmpty(etExportDuration.getText())) {
				tempData.exportVideoDuration = Integer.valueOf(etExportDuration
						.getText().toString());
			} else {
				tempData.exportVideoDuration = 0;
			}
		}
		// 水印显示位置
		if (etWatermarkXAxis != null) {
			float left, top, right, bottom;
			if (!TextUtils.isEmpty(etWatermarkXAxis.getText())) {
				left = Float.valueOf(etWatermarkXAxis.getText().toString());
			} else {
				left = 0;
			}
			if (!TextUtils.isEmpty(etWatermarkYAxis.getText())) {
				top = Float.valueOf(etWatermarkYAxis.getText().toString());
			} else {
				top = 0;
			}
			if (!TextUtils.isEmpty(etWatermarkXZoom.getText())) {
				right = Float.valueOf(etWatermarkXZoom.getText().toString());
			} else {
				right = 0;
			}
			if (!TextUtils.isEmpty(etWatermarkYZoom.getText())) {
				bottom = Float.valueOf(etWatermarkYZoom.getText().toString());
			} else {
				bottom = 0;
			}
			tempData.watermarkShowRectF.set(left, top, right, bottom);
		}
		configData.equal(tempData);
		if (configData.enableVideoTrailer) {
			videoTrailerPath = createVideoTrailerImage(this, "null", 480, 50,
					50);
		} else {
			videoTrailerPath = null;
		}
	}

	/**
	 * 保存录制设置对话框的参数
	 */
	private void saveCameraConfigData() {
		// 读取最小录制时间
		if (etCameraMinTime != null) {
			if (!TextUtils.isEmpty(etCameraMinTime.getText())) {
				tempData.cameraMinTime = Integer.valueOf(etCameraMinTime
						.getText().toString());
			} else {
				tempData.cameraMinTime = 0;
			}
		}
		// 读取最大录制时间
		if (etCameraMaxTime != null) {
			if (!TextUtils.isEmpty(etCameraMaxTime.getText())) {
				tempData.cameraMaxTime = Integer.valueOf(etCameraMaxTime
						.getText().toString());
			} else {
				tempData.cameraMaxTime = 0;
			}
		}
		configData.equal(tempData);
	}

	/**
	 * 保存压缩设置对话框的参数
	 */
	private void saveCompressConfigData() {
		// 读取码率
		if (etCompressBitRate != null) {
			if (!TextUtils.isEmpty(etCompressBitRate.getText())) {
				tempData.compressBitRate = Integer.valueOf(etCompressBitRate
						.getText().toString());
			} else {
				tempData.compressBitRate = 0;
			}
		}
		// 读取视频宽度
		if (etCompressVideoWidth != null) {
			if (!TextUtils.isEmpty(etCompressVideoWidth.getText())) {
				tempData.compressVideoWidth = Integer
						.valueOf(etCompressVideoWidth.getText().toString());
			} else {
				tempData.compressVideoWidth = 0;
			}
		}
		// 读取视频高度
		if (etCompressVideoHeight != null) {
			if (!TextUtils.isEmpty(etCompressVideoHeight.getText())) {
				tempData.compressVideoHeight = Integer
						.valueOf(etCompressVideoHeight.getText().toString());
			} else {
				tempData.compressVideoHeight = 0;
			}
		}
		configData.equal(tempData);
	}

	private void exportDemoResource() {
		if (!new File(EDIT_PICTURE_PATH).exists()
				|| !new File(EDIT_VIDEO_PATH).exists()) {
			new AsyncTask<Integer, Integer, Integer>() {
				private ProgressDialog m_dlgProgress;

				@Override
				protected void onPreExecute() {
					m_dlgProgress = ProgressDialog.show(SimpleActivity.this,
							null, "导出测试资源...");
				};

				@Override
				protected Integer doInBackground(Integer... params) {
					if (!new File(EDIT_PICTURE_PATH).exists()) {
						// 导出测试编辑资源
						assetRes2File(getAssets(), "demomedia/android.png",
								EDIT_PICTURE_PATH);
					}
					if (!new File(EDIT_VIDEO_PATH).exists()) {
						assetRes2File(getAssets(), "demomedia/RXG1.mp4",
								EDIT_VIDEO_PATH);
					}
					return null;
				}

				@Override
				protected void onPostExecute(Integer result) {
					m_dlgProgress.dismiss();
					m_dlgProgress = null;
				};
			}.execute();
		}
	}

	/**
	 * 将asset文件保存为指定文件
	 * 
	 * @param am
	 * @param strAssetFile
	 * @param strDstFile
	 * @throws IOException
	 */
	public static boolean assetRes2File(AssetManager am, String strAssetFile,
			String strDstFile) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(strDstFile);
			byte[] pBuffer = new byte[1024];
			int nReadLen;
			if (null == am) {
				return false;
			}
			InputStream is = am.open(strAssetFile);
			while ((nReadLen = is.read(pBuffer)) != -1) {
				os.write(pBuffer, 0, nReadLen);
			}
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * 压缩视频回调函数
	 */
	private ICompressVideoCallback iCompressVideoCallback = new ICompressVideoCallback() {
		private AlertDialog dialog;
		private ProgressBar progressBar;

		@Override
		public void onCompressStart() {
			View v = LayoutInflater.from(SimpleActivity.this).inflate(
					R.layout.progress_view, null);
			progressBar = (ProgressBar) v.findViewById(R.id.pbCompress);
			dialog = new AlertDialog.Builder(SimpleActivity.this).setView(v)
					.show();
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
	 * 绘制片尾图片 并将其保存为临时文件
	 * 
	 * @param author
	 *            作者名字
	 * @param videoHeight
	 *            视频高度
	 * @return 图片路径
	 */
	private String createVideoTrailerImage(Activity context, String author,
			int videoHeight, int horiPadding, int dataWidth) {
		String path = Environment.getExternalStorageDirectory()
				+ "/trailer_logo.png";

		Bitmap bmpLogo = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.video_trailer_logo);
		Bitmap bmpDate = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.video_trailer_date);
		Bitmap bmpAuthor = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.video_trailer_author);

		Paint bmpPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		bmpPaint.setFilterBitmap(true);
		Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setARGB(255, 175, 171, 170);
		linePaint.setStrokeWidth(2);

		textPaint.setARGB(255, 232, 232, 232);

		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String date = sDateFormat.format(new java.util.Date());

		int textSize = 150;
		while (true) {
			textPaint.setTextSize(textSize);
			float textHeight = textPaint.getFontMetrics().descent
					- textPaint.getFontMetrics().ascent;

			if (textHeight > bmpDate.getHeight()) {
				textSize -= 1;
			} else {
				break;
			}
		}

		try {
			int authorLength = author.length();
			int authorByte = author.getBytes("GBK").length;
			while (authorByte > 16) {
				authorLength -= 1;
				author = author.substring(0, authorLength) + "...";
				authorByte = author.getBytes("GBK").length;
			}

		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		int logoWidth = bmpLogo.getWidth();
		int messageWidth = (int) (bmpDate.getWidth() + bmpAuthor.getWidth()
				+ dataWidth + 40 + textPaint.measureText(date) + textPaint
				.measureText(author));

		int logoDateHeight = (bmpDate.getHeight() + bmpLogo.getHeight() + 80);

		float scale = (float) videoHeight / (logoDateHeight * 2);

		int bmpWidth;
		int logoLeft = 0;
		int top = (int) ((videoHeight - logoDateHeight * scale) / (2 * scale));
		int messageLeft = 0;
		if (logoWidth >= messageWidth) {
			bmpWidth = (int) (logoWidth * scale);
			messageLeft = (logoWidth - messageWidth) / 2;
		} else {
			bmpWidth = (int) (messageWidth * scale);
			logoLeft = (messageWidth - logoWidth) / 2;
		}

		Bitmap bmp = Bitmap.createBitmap(bmpWidth + 2 * horiPadding,
				videoHeight, Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(bmp);
		canvas.scale(scale, scale);
		logoLeft += horiPadding / scale;
		messageLeft += horiPadding / scale;
		canvas.drawBitmap(bmpLogo, logoLeft, top, bmpPaint);

		top = top + bmpLogo.getHeight() + 40;
		canvas.drawLine(logoLeft, top, logoLeft + bmpLogo.getWidth(), top,
				linePaint);
		top = top + 40;
		int baseline = (int) ((bmpDate.getHeight()
				- textPaint.getFontMetrics().bottom - textPaint
				.getFontMetrics().top) / 2);
		int textTop = top + baseline;

		canvas.drawBitmap(bmpDate, messageLeft, top, bmpPaint);
		messageLeft = messageLeft + bmpDate.getWidth() + 20;

		canvas.drawText(date, messageLeft, textTop, textPaint);

		messageLeft = (int) (messageLeft + textPaint.measureText(date) + dataWidth);
		canvas.drawBitmap(bmpAuthor, messageLeft, top, bmpPaint);

		messageLeft = messageLeft + bmpAuthor.getWidth() + 20;
		canvas.drawText(author, messageLeft, textTop, textPaint);
		File file = new File(path);
		if (file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			FileOutputStream out = new FileOutputStream(file);
			bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		bmp.recycle();
		bmp = null;
		return path;
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		initConfigData();
		return configData;
	}
}
