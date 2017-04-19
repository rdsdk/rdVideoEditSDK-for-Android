package com.rd.xpkuisdk.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.Context;
import android.graphics.RectF;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.rd.xpkuisdk.manager.XpkOSD;

public class CameraWatermarkBuilder extends XpkOSD {

	private StringBuilder m_sbBuilder = null;
	private SimpleDateFormat sdfTime = null;

	public CameraWatermarkBuilder(Context context) {
		super(context);
		// 水印的宽高 相对于屏幕可见区域的宽高
		setOSDRect(new RectF(0.5f, 0.5f, 0.99f, 0.9f), new RectF(0.4f, 0.5f,
				0.9f, 0.8f));// 自定义水印在可视范围的大小
	}

	@Override
	protected void cleanUp() {
		m_sbBuilder = null;
		tvOSD = null;
		sdfTime = null;
	}

	@Override
	protected View getOSDView(Context context) {
		m_sbBuilder = new StringBuilder();
		sdfTime = new SimpleDateFormat("HH:mm:ss S", Locale.getDefault());
		View view = LayoutInflater.from(context).inflate(
				R.layout.camera_watermark_layout, null);
		onRefreshOSDView(view);
		return view;
	}

	private String buildOSDString(Date date) {
		m_sbBuilder.setLength(0);
		m_sbBuilder.append(DateFormat.format("yyyy年MM月dd日  ", date)).append(
				sdfTime.format(date));

		return m_sbBuilder.toString();
	}

	private TextView tvOSD;

	@Override
	protected void onRefreshOSDView(View view) {
		if (null == tvOSD) {
			tvOSD = (TextView) view.findViewById(R.id.osdInfo);
		}
		if (state == OSDState.recording) {
			tvOSD.setText(buildOSDString(new Date()));
		} else if (state == OSDState.end) {
			tvOSD.setText("end");
		} else {
			tvOSD.setText("准备录制...");
		}
	}

	private OSDState state = OSDState.recording;

	@Override
	public void setOSDState(OSDState mstate) {
		this.state = mstate;
	}
}
