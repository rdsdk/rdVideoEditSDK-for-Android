package com.rd.xpkuisdk.demo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore.Video;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.rd.xpkuisdk.ISdkCallBack;
import com.rd.xpkuisdk.XpkSdk;

/**
 * SDK回调演示用handler
 * 
 */
public class SdkHandler {
	private String TAG;

	public SdkHandler() {

		TAG = this.toString();
	}

	public ISdkCallBack getCallBack() {
		return isdk;
	}

	/**
	 * 响应视频导出<br>
	 * 1.读取视频信息并写入系统相册<br>
	 * 2.播放该视频
	 * 
	 * @param context
	 *            应用上下文
	 * @param videoPath
	 *            视频路径
	 */
	private void onVideoExport(Context context, String videoPath) {
		if (!TextUtils.isEmpty(videoPath)) {
			// 读取导出视频的媒体信息，如宽度，持续时间等
			MediaMetadataRetriever retriever = new MediaMetadataRetriever();
			try {
				retriever.setDataSource(videoPath);
				int nRotation = Integer
						.parseInt(retriever
								.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION));
				boolean bInvertWH = nRotation % 180 != 0;
				int nVideoWidth = Integer
						.parseInt(retriever
								.extractMetadata(bInvertWH ? MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT
										: MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH));
				int nVideoHeight = Integer
						.parseInt(retriever
								.extractMetadata(bInvertWH ? MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH
										: MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT));
				int duration = Integer
						.parseInt(retriever
								.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
				// 写入系统相册
				insertToGalleryr(context, videoPath, duration, nVideoWidth,
						nVideoHeight);
			} catch (Exception ex) {
			} finally {
				retriever.release();
			}
			// 播放该视频
			XpkSdk.onPlayVideo(context, videoPath);
		} else {
			Log.d(TAG, "获取视频地址失败");
		}
	}

	private ISdkCallBack isdk = new ISdkCallBack() {

		/**
		 * 目标视频的路径
		 * 
		 * @param context
		 *            应用上下文
		 * @param exportType
		 *            回调类型 来自简单录制 {@link XpkSdk#XPK_CAMERA_EXPORT}<br>
		 *            来自录制编辑{@link XpkSdk#XPK_CAMERA_EDIT_EXPORT}<br>
		 *            来自编辑导出{@link XpkSdk#XPK_EDIT_EXPORT}<br>
		 *            来自普通截取视频导出{@link XpkSdk#XPK_TRIMVIDEO_EXPORT}<br>
		 *            来自定长截取视频导出{@link XpkSdk#XPK_TRIMVIDEO_DURATION_EXPORT}<br>
		 * @param videoPath
		 */
		@Override
		public void getVideoPath(Context context, int exportType,
				String videoPath) {

			if (exportType == XpkSdk.XPK_EDIT_EXPORT) {
				Log.i(TAG, "getvideoPath  普通编辑");
			} else if (exportType == XpkSdk.XPK_CAMERA_EXPORT) {
				Log.i(TAG, "getvideoPath  简单录制");
			} else if (exportType == XpkSdk.XPK_CAMERA_EDIT_EXPORT) {
				Log.i(TAG, "getvideoPath  录制并编辑");
			} else if (exportType == XpkSdk.XPK_TRIMVIDEO_EXPORT) {
				Log.i(TAG, "getvideoPath  普通截取");
			} else if (exportType == XpkSdk.XPK_TRIMVIDEO_DURATION_EXPORT) {
				Log.i(TAG, "getvideoPath  定长截取");
			} else {
				Log.e(TAG, "getvideoPath  未知");
			}

			onVideoExport(context, videoPath);
		}

		/**
		 * 响应截取视频时间
		 * 
		 * @param context
		 *            应用上下文
		 * @param exportType
		 *            回调类型 来自普通截取视频的时间导出{@link XpkSdk#XPK_TRIMVIDEO_EXPORT}<br>
		 *            来自定长截取视频的时间导出{@link XpkSdk#XPK_TRIMVIDEO_DURATION_EXPORT}<br>
		 * @param startTime
		 *            开始时间
		 * @param endTime
		 *            结束时间
		 */
		@Override
		public void getVideoTrimTime(Context context, int exportType,
				int startTime, int endTime) {
			Toast.makeText(context,
					"截取开始时间:" + startTime + ",截取结束时间:" + endTime,
					Toast.LENGTH_LONG).show();
			if (exportType == XpkSdk.XPK_TRIMVIDEO_EXPORT) {
				Log.i(TAG, "getVideoTrimTime  普通截取");
			} else if (exportType == XpkSdk.XPK_TRIMVIDEO_DURATION_EXPORT) {
				Log.i(TAG, "getVideoTrimTime  定长截取");
			} else {
				Log.e(TAG, "getVideoTrimTime  未知");
			}
		}

		/**
		 * 响应确认截取按钮
		 * 
		 * @param context
		 *            应用上下文
		 * @param exportType
		 *            来自普通截取的确认 {@link XpkSdk#XPK_TRIMVIDEO_EXPORT}<br>
		 *            来自定长截取的确认 {@link XpkSdk#XPK_TRIMVIDEO_DURATION_EXPORT}<br>
		 */
		@Override
		public void getVideoTrim(Context context, int exportType) {
			if (exportType == XpkSdk.XPK_TRIMVIDEO_EXPORT) {
				Log.i(TAG, "getVideoTrimTime  普通截取的确认按钮");
			} else if (exportType == XpkSdk.XPK_TRIMVIDEO_DURATION_EXPORT) {
				Log.i(TAG, "getVideoTrimTime  定长截取的确认按钮");
			} else {
				Log.e(TAG, "getVideoTrimTime  未知");
			}
			Intent intent = new Intent(context, DialogActivity.class);
			context.startActivity(intent);
		}

		/**
		 * 响应进入相册（只显示照片、图片）
		 * 
		 * @param context
		 *            应用上下文
		 */
		@Override
		public void getPhoto(Context context) {
			// 自定义相册调用位置
			Intent intent = new Intent(context, AlbumActivity.class);
			intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			context.startActivity(intent);
		}

		/**
		 * 响应进入相册（只显示视频）
		 * 
		 * @param context
		 *            应用上下文
		 */
		@Override
		public void getVideo(Context context) {
			// 自定义视频集调用位置
			Intent intent = new Intent(context, AlbumActivity.class);
			intent.setData(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
			context.startActivity(intent);
		}

	};

	/**
	 * 将视频信息存入相册数据库
	 * 
	 * @param path
	 *            视频路径
	 * @param duration
	 *            视频持续时间
	 * @param width
	 *            视频宽度
	 * @param height
	 *            视频高度
	 */
	private void insertToGalleryr(Context context, String path, int duration,
			int width, int height) {
		ContentValues videoValues = new ContentValues();
		videoValues.put(Video.Media.TITLE, "未定义");
		videoValues.put(Video.Media.MIME_TYPE, "video/mp4");
		videoValues.put(Video.Media.DATA, path);
		videoValues.put(Video.Media.ARTIST,
				context.getString(R.string.app_name));
		videoValues.put(Video.Media.DATE_TAKEN,
				String.valueOf(System.currentTimeMillis()));
		videoValues.put(Video.Media.DESCRIPTION,
				context.getString(R.string.app_name));
		videoValues.put(Video.Media.DURATION, duration);
		videoValues.put(Video.Media.WIDTH, width);
		videoValues.put(Video.Media.HEIGHT, height);
		context.getContentResolver().insert(Video.Media.EXTERNAL_CONTENT_URI,
				videoValues);

	}

}
