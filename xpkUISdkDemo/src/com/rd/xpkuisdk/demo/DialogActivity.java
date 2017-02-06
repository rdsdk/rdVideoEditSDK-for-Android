package com.rd.xpkuisdk.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.rd.xpkuisdk.XpkSdk;

/**
 * xpkUISDK确认截取方式演示页
 */
public class DialogActivity extends Activity {

	private final int RETURN_TRIM_VIDEO = 0; // 返回截取视频
	private final int RETURN_TRIM_TIME = 1; // 返回截取时间

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			XpkSdk.onVideoTrim(this, RETURN_TRIM_VIDEO);
			DialogActivity.this.finish();
			break;
		case R.id.btn2:
			XpkSdk.onVideoTrim(this, RETURN_TRIM_TIME);
			DialogActivity.this.finish();
			break;
		default:
			break;
		}
	}
}
