package com.rd.xpkuisdk.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.rd.xpkuisdk.XpkSdk;
import com.rd.xpkuisdk.XpksdkService;

import com.rd.xpkuisdk.manager.CameraConfiguration;
import com.rd.xpkuisdk.manager.ExportConfiguration;
import com.rd.xpkuisdk.manager.UIConfiguration;

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
	/**
	 * REQUEST_CODE定义：<br>
	 * 简单录制
	 */
	private final int SIMPLE_CAMERA_REQUEST_CODE = 100;
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
		initConfig();
	}

	private void initConfig() {
		// UI配置
		UIConfiguration uiConfig = new UIConfiguration.Builder()
		// 设置横竖屏，参数分别有 0:自动，1:竖屏，2:横屏
				.setOrientation(UIConfiguration.ORIENTATION_AUTO)
				// 设置是否使用自定义相册
				.useCustomAlbum(false)
				// 设置是否隐藏配音配乐
				.hideMusic(false)
				// 设置是否隐藏片段编辑
				.hidePartEdit(false).get();

		// 导出视频参数配置
		ExportConfiguration exportConfig = new ExportConfiguration.Builder()
		// 设置保存路径，传null或不设置
		// 将保存至默认路径(即调用XpkSdk.init初始时自定义路径$strCustomRootPath$/xpkVideos）
				.setSavePath(null)
				// 设置片尾图片路径，传null或者不设置 将没有片尾
				.setTrailerPath(null)
				// 设置片尾时长 单位ms 默认2000ms
				.setTrailerDuration(2000)
				// 设置导出视频时长 单位ms 传0或者不设置 将导出完整视频
				.setVideoDuration(0).get();

		// 获取秀拍客配置服务器
		XpksdkService xpkService = XpkSdk.getXpksdkService();
		// 初始化所有配置
		xpkService.initConfiguration(exportConfig, uiConfig);
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

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == SIMPLE_CAMERA_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				Log.d(TAG, String.format("简单录制返回视频路径为：%s,图片路径为：%s",
						data.getStringExtra(XpkSdk.INTENT_KEY_VIDEO_PATH),
						data.getStringExtra(XpkSdk.INTENT_KEY_PICTURE_PATH)));
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
		case R.id.xpk: // 进入sdk媒体资源的选择界面(图片、视频)
			XpkSdk.onXpkVideo(this);
			break;

		case R.id.xpkedit: // 传递资源路径，进入视频编辑，返回导出的视频的地址
			ArrayList<String> list = new ArrayList<String>();
			list.add(EDIT_PICTURE_PATH);
			list.add(EDIT_VIDEO_PATH);

			XpkSdk.onXpkEdit(SimpleActivity.this, list);

			break;

		case R.id.xpkrec: // 录制视频，编辑录制后的视频，如果有导出时，导出视频的路径
			XpkSdk.onXpkCamera(this, true);
			break;
		case R.id.xpkrec_back: // 只录制视频，返回录制的视频的地址
			XpkSdk.getXpksdkService()
					.initConfiguration(
							new CameraConfiguration.Builder()
									// 可设置最大录制时长,0代表不限制
									.setVideoMaxTime(0)
									// 为true代表在拍照模式下点击拍照按钮立即返回，通过onActivityResult及SIMPLE_CAMERA_REQUEST_CODE
									.setTakePhotoReturn(true)
									/**
									 * 设置录制时默认界面:<br>
									 * 默认16：9录制:<br>
									 * CameraConfiguration.
									 * WIDE_SCREEN_CAN_CHANGE<br>
									 * 默认1：1:<br>
									 * CameraConfiguration.
									 * SQUARE_SCREEN_CAN_CHANGE<br>
									 * 仅1：1录制:<br>
									 * CameraConfiguration.ONLY_SQUARE_SCREEN
									 */
									.setCameraUIType(
											CameraConfiguration.WIDE_SCREEN_CAN_CHANGE)
									// 设置录制时是否静音，true代表录制后无声音
									.setAudioMute(false).get());
			XpkSdk.onXpkCamera(this, false, SIMPLE_CAMERA_REQUEST_CODE);
			break;
		case R.id.xpk_player: // 播放器
			Intent intent = new Intent(this, VideoPlayerActivity.class);
			intent.putExtra(VideoPlayerActivity.ACTION_PATH, EDIT_VIDEO_PATH);
			startActivity(intent);
			break;
		case R.id.xpk_trim: // 截取视频
			XpkSdk.onXpkTrimVideo(this, EDIT_VIDEO_PATH,
					Environment.getExternalStorageDirectory() + "/xpkVideos/",
					"修剪片段", Color.BLACK, "取消", "下载选中片段", Color.BLACK);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		XpkSdk.exitApp(this);
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
}
