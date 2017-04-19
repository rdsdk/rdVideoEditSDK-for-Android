package com.rd.xpkuisdk.demo.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.rd.xpkuisdk.demo.R;

/**
 * 相册设置对话框
 */
public class AlbumConfigDialog {
    private AlertDialog dialog;
    private ConfigData tempData;
    private Switch swEnableAlbumCamera;
    private EditText etAlbumMediaCountLimit;

    /**
     * 构造函数
     */
    public AlbumConfigDialog(Activity activity,
                             final ConfigDialogListener listener, ConfigData configData) {
        tempData = new ConfigData();
        tempData.setConfig(configData);
        View view = activity.getLayoutInflater().inflate(
                R.layout.album_config_dialog, null);
        dialog = new AlertDialog.Builder(activity)
                .setView(view)
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
        swEnableAlbumCamera = (Switch) view.findViewById(R.id.swEnableAlbumCamera);
        swEnableAlbumCamera.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tempData.enableAlbumCamera = isChecked;
            }
        });
        swEnableAlbumCamera.setChecked(tempData.enableAlbumCamera);

        etAlbumMediaCountLimit = (EditText) view
                .findViewById(R.id.etAlbumMediaCountLimit);
        if (tempData.albumMediaCountLimit != 0) {
            etAlbumMediaCountLimit.setText("" + tempData.albumMediaCountLimit);
        }
    }

    /**
     * 保存设置对话框的参数
     */
    private void saveConfigData() {
        // 读取相册选择媒体数量上限
        if (etAlbumMediaCountLimit != null) {
            if (!TextUtils.isEmpty(etAlbumMediaCountLimit.getText())) {
                tempData.albumMediaCountLimit = Integer
                        .valueOf(etAlbumMediaCountLimit.getText().toString());
            } else {
                tempData.albumMediaCountLimit = 0;
            }
        }
    }
}
