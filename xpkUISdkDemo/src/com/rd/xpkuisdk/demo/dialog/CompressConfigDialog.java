package com.rd.xpkuisdk.demo.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Switch;

import com.rd.xpkuisdk.demo.R;

/**
 * 压缩设置对话框
 */
public class CompressConfigDialog {
    private AlertDialog dialog;
    private ConfigData tempData;
    private CheckBox compressWatermark;
    private Switch swEnableHWCode;
    private EditText etCompressBitRate, etCompressVideoWidth,
            etCompressVideoHeight, etCompressWatermarkXAxis,
            etCompressWatermarkYAxis, etCompressWatermarkXZoom,
            etCompressWatermarkYZoom;

    /**
     * 构造函数
     */
    public CompressConfigDialog(Activity activity,
                                final ConfigDialogListener listener, ConfigData configData) {
        tempData = new ConfigData();
        tempData.setConfig(configData);
        View view = activity.getLayoutInflater().inflate(
                R.layout.compress_config_dialog, null);
        initCompressDialogView(view);
        dialog = new AlertDialog.Builder(activity).setView(view)
                .setPositiveButton("返回", null)
                .setNegativeButton("保存", new OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        saveCompressConfigData();
                        listener.onSaveConfigData(tempData);
                    }
                }).show();
        dialog.setOnDismissListener(listener);
    }

    /**
     * 初始化压缩设置对话框
     *
     * @param view
     */
    private void initCompressDialogView(View view) {
        // 硬件加速开关
        swEnableHWCode = (Switch) view.findViewById(R.id.swEnableHWcode);
        swEnableHWCode.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tempData.enableHWCode = isChecked;
            }
        });
        swEnableHWCode.setChecked(tempData.enableHWCode);

        // 水印开关
        compressWatermark = (CheckBox) view
                .findViewById(R.id.compressWatermark);
        compressWatermark
                .setOnCheckedChangeListener(new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        tempData.enableCompressWatermark = isChecked;
                    }
                });
        compressWatermark.setChecked(tempData.enableCompressWatermark);

        // 设置压缩视频水印位置
        etCompressWatermarkXAxis = (EditText) view
                .findViewById(R.id.etCompressWatermarkXAxis);
        etCompressWatermarkYAxis = (EditText) view
                .findViewById(R.id.etCompressWatermarkYAxis);
        etCompressWatermarkXZoom = (EditText) view
                .findViewById(R.id.etCompressWatermarkXZoom);
        etCompressWatermarkYZoom = (EditText) view
                .findViewById(R.id.etCompressWatermarkYZoom);
        if (tempData.compressWatermarkShowRect != null) {
            if (tempData.compressWatermarkShowRect.left != 0) {
                etCompressWatermarkXAxis.setText(""
                        + tempData.compressWatermarkShowRect.left);
            }
            if (tempData.compressWatermarkShowRect.top != 0) {
                etCompressWatermarkYAxis.setText(""
                        + tempData.compressWatermarkShowRect.top);
            }
            if (tempData.compressWatermarkShowRect.right != 0) {
                etCompressWatermarkXZoom.setText(""
                        + tempData.compressWatermarkShowRect.right);
            }
            if (tempData.compressWatermarkShowRect.bottom != 0) {
                etCompressWatermarkYZoom.setText(""
                        + tempData.compressWatermarkShowRect.bottom);
            }
        }

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
     * 保存压缩设置对话框的参数
     */
    private void saveCompressConfigData() {
        // 读取码率
        if (etCompressBitRate != null) {
            if (!TextUtils.isEmpty(etCompressBitRate.getText())) {
                tempData.compressBitRate = Float.valueOf(etCompressBitRate
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
        // 水印显示位置
        if (etCompressWatermarkXAxis != null) {
            float left, top, right, bottom;
            if (!TextUtils.isEmpty(etCompressWatermarkXAxis.getText())) {
                left = Float.valueOf(etCompressWatermarkXAxis.getText()
                        .toString());
            } else {
                left = 0;
            }
            if (!TextUtils.isEmpty(etCompressWatermarkYAxis.getText())) {
                top = Float.valueOf(etCompressWatermarkYAxis.getText()
                        .toString());
            } else {
                top = 0;
            }
            if (!TextUtils.isEmpty(etCompressWatermarkXZoom.getText())) {
                right = Float.valueOf(etCompressWatermarkXZoom.getText()
                        .toString());
            } else {
                right = 0;
            }
            if (!TextUtils.isEmpty(etCompressWatermarkYZoom.getText())) {
                bottom = Float.valueOf(etCompressWatermarkYZoom.getText()
                        .toString());
            } else {
                bottom = 0;
            }
            if (tempData.compressWatermarkShowRect == null) {
                tempData.compressWatermarkShowRect = new RectF();
            }
            tempData.compressWatermarkShowRect.set(left, top, right, bottom);
        }
    }

}
