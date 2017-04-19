package com.rd.xpkuisdk.demo.dialog;

import android.content.DialogInterface;

/**
 * 配置对话框listener
 */
public interface ConfigDialogListener extends DialogInterface.OnDismissListener {
	/**
	 * 响应保存配置数据
	 * 
	 * @param configData
	 */
	void onSaveConfigData(ConfigData configData);
}
