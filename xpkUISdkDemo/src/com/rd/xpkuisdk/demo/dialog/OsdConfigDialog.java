package com.rd.xpkuisdk.demo.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.rd.xpkuisdk.demo.R;

/**
 * 相册设置对话框
 */
public class OsdConfigDialog {
	private AlertDialog dialog;
	private ConfigData tempData;
	private EditText etOsd;

	/**
	 * 构造函数
	 */
	public OsdConfigDialog(Activity activity,
			final ConfigDialogListener listener, ConfigData configData) {
		tempData = new ConfigData();
		tempData.setConfig(configData);
		View view = activity.getLayoutInflater().inflate(R.layout.osd_dialog,
				null);
		dialog = new AlertDialog.Builder(activity).setView(view)
				.setPositiveButton("返回", null)
				.setNegativeButton("保存", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						saveConfigData();
						listener.onSaveConfigData(tempData);
					}
				}).show();
		dialog.setOnDismissListener(listener);
		initDialogView(view);
	}

	/**
	 * 初始化拍摄设置对话框
	 * 
	 * @param view
	 */
	private void initDialogView(View view) {

		etOsd = (EditText) view.findViewById(R.id.etOsdContent);
		if (!TextUtils.isEmpty(tempData.antiChangeText)) {
			etOsd.setText(tempData.antiChangeText);
		}
	}

	/**
	 * 保存设置对话框的参数
	 */
	private void saveConfigData() {
		tempData.antiChangeText = etOsd.getText().toString();
	}
}
