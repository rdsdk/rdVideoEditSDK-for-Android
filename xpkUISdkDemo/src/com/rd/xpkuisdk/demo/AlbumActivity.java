package com.rd.xpkuisdk.demo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.rd.xpkuisdk.XpkSdk;

/**
 * xpkUISDK演示页
 */
public class AlbumActivity extends Activity {

	private final int REQUESTCODE_FOR_SYSTEM_ALBUM = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 此activity没有界面,直接调用系统相册
		Intent picture = new Intent(Intent.ACTION_PICK, getIntent().getData());
		startActivityForResult(picture, REQUESTCODE_FOR_SYSTEM_ALBUM);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			if (requestCode == REQUESTCODE_FOR_SYSTEM_ALBUM && data != null) {
				ArrayList<String> arrPath = new ArrayList<String>();
				// 获取系统返回的媒体地址
				Uri selectedImage = data.getData();
				if ("file".equals(selectedImage.getScheme())) {
					arrPath.add(selectedImage.getPath());
				} else {
					String[] filePathColumns = { MediaStore.Images.Media.DATA };
					Cursor c = this.getContentResolver().query(selectedImage,
							filePathColumns, null, null, null);
					c.moveToFirst();
					int columnIndex = c.getColumnIndex(filePathColumns[0]);
					String picturePath = c.getString(columnIndex);
					arrPath.add(picturePath);
				}
				// 将媒体地址列表传到sdk接口
				XpkSdk.onCustomizeAlbum(this, arrPath);
			}
		}
		AlbumActivity.this.finish();
	}
}
