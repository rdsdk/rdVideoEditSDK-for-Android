package com.rd.xpkuisdk.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.rd.xpkuisdk.manager.XpkOSD;

public class CameraWatermarkBuilder extends XpkOSD {
	private final StringBuilder m_sbFormator = new StringBuilder();
	private final Formatter m_formatter = new Formatter(m_sbFormator,
			Locale.getDefault());
	private StringBuilder m_sbBuilder = null;
	private SimpleDateFormat sdfTime = null;
	private boolean isSquare;
	private int osdEndbgColor;

	public CameraWatermarkBuilder(Context context, Boolean isSquare) {
		super(context, isSquare);
		this.isSquare = isSquare;
		osdEndbgColor = context.getResources().getColor(R.color.white);
		// 水印的宽高 相对于屏幕可见区域的宽高
		if (isSquare) {
			setOSDRect(new RectF(0f, 0.7f, 0.8f, 0.99f), null);// 正方形的自定义水印在可视范围的大小
		} else {
			setOSDRect(new RectF(0f, 0.15f, 0.5f, 0.3f), new RectF(0.15f,
					0.85f, 0.65f, 1.0f));// 长方形 自定义水印在可视范围的大小
		}
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
		if (TextUtils.isEmpty(str)) {
			if (mState == OSDState.header) {
				tvOSD.setText(buildOSDString(new Date()));
			} else if (mState == OSDState.recording) {
				tvOSD.setText(stringForTime(recorderTime, false));
			} else if (mState == OSDState.end) {
				tvOSD.setText(buildOSDString(new Date()));
			}
		} else {
			if (mState == OSDState.header) {
				tvOSD.setText(str);
			} else if (mState == OSDState.recording) {
				tvOSD.setText(stringForTime(recorderTime, false));
			} else if (mState == OSDState.end) {
				tvOSD.setText(str);
			}
		}
	}

	private static String str = "";

	public static void setText(String osd) {
		str = osd;
	}

	@Override
	public void setOSDState(OSDState state) {
		// TODO Auto-generated method stub
		super.setOSDState(state);

		// Log.e("setOSDState", state + ".." + this.toString());
		if (state == OSDState.header) {
			setOSDVisible(View.VISIBLE);
			if (isSquare) {
				setOSDRect(new RectF(0f, 0.7f, 0.8f, 0.99f), null);// 正方形的自定义水印在可视范围的大小
			} else {
				setOSDRect(new RectF(0.2f, 0.3f, 0.8f, 0.6f), new RectF(0.1f,
						0.1f, 0.9f, 0.9f));// 长方形 自定义水印在可视范围的大小
			}

		} else if (state == OSDState.recording) {
			setOSDVisible(View.INVISIBLE);// demo中,录制进度中的水印呗UI界面组件遮挡，所以水印此时间段不显示
			if (isSquare) {
				setOSDRect(new RectF(0f, 0.7f, 0.8f, 0.99f), null);// 正方形的自定义水印在可视范围的大小
			} else {
				setOSDRect(new RectF(0f, 0.9f, 0.5f, 1f), new RectF(0.1f, 0.1f,
						0.9f, 0.9f));// 长方形 自定义水印在可视范围的大小
			}
		} else if (state == OSDState.end) {

			setOSDVisible(View.VISIBLE);
			if (null != tvOSD) {
				tvOSD.setBackgroundColor(osdEndbgColor);
			}
			if (isSquare) {
				setOSDRect(new RectF(0f, 0f, 1f, 1f), null);// 正方形的自定义水印在可视范围的大小
			} else {
				setOSDRect(new RectF(0f, 0f, 1f, 1f), new RectF(0f, 0f, 1f, 1f));// 长方形
																					// 自定义水印在可视范围的大小
			}
		}
	}

	/**
	 * 毫秒数转换为时间格式化字符串 支持是否显示小时
	 * 
	 * @param timeMs
	 * @return
	 */
	private String stringForTime(long timeMs, boolean existsHours) {
		boolean bNegative = timeMs < 0;// 是否为负数
		if (bNegative) {
			timeMs = -timeMs;
		}
		int totalSeconds = (int) (timeMs / 1000);

		int seconds = totalSeconds % 60;
		int minutes = (totalSeconds / 60) % 60;
		int hours = totalSeconds / 3600;

		int ms = (int) (timeMs % 1000);

		m_sbFormator.setLength(0);
		try {
			if (hours > 0 || existsHours) {
				return m_formatter.format("%s%02d:%02d:%02d",
						bNegative ? "-" : "", hours, minutes, seconds)
						.toString();
			} else {
				return m_formatter.format("%s%02d:%02d.%03d",
						bNegative ? "- " : "", minutes, seconds, ms).toString();
			}
		} catch (Exception ex) {
			return "";
		}
	}

}
