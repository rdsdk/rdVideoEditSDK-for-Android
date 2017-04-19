package com.rd.xpkuisdk.demo.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rd.xpkuisdk.demo.R;
import com.rd.xpkuisdk.manager.TrimConfiguration;


/**
 * 截取设置对话框
 */
public class VideoTrimConfigDialog {
    private AlertDialog dialog;
    private ConfigData tempData;
    private RadioGroup rgTrimReturnMode, rgTrimType, rgTrimCropMode;
    private RadioButton rbTrimNormal, rbTrim1x1, rbTrimNormalWithItem,
            rbTrim1x1WithItem;
    private EditText etSingleFixedTrimTime, etTrimTime1, etTrimTime2;

    /**
     * 构造函数
     */
    public VideoTrimConfigDialog(Activity activity,
                                 final ConfigDialogListener listener, ConfigData configData) {
        tempData = new ConfigData();
        tempData.setConfig(configData);
        View view = activity.getLayoutInflater().inflate(
                R.layout.trim_config_dialog, null);
        initDialogView(view);
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
    }

    /**
     * 初始化拍摄设置对话框
     *
     * @param view
     */
    private void initDialogView(final View view) {
        rbTrimNormal = (RadioButton) view.findViewById(R.id.rbTrimNormal);
        rbTrim1x1 = (RadioButton) view.findViewById(R.id.rbTrim1x1);
        rbTrimNormalWithItem = (RadioButton) view.findViewById(R.id.rbTrimNormalWithItem);
        rbTrim1x1WithItem = (RadioButton) view.findViewById(R.id.rbTrim1x1WithItem);

        rgTrimReturnMode = (RadioGroup) view.findViewById(R.id.rgTrimReturnMode);
        rgTrimType = (RadioGroup) view.findViewById(R.id.rgTrimType);
        rgTrimCropMode = (RadioGroup) view.findViewById(R.id.rgTrimCropMode);


        rgTrimReturnMode
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        if (checkedId == R.id.rbTrimReturnMedia) {
                            tempData.mTrimReturnMode = TrimConfiguration.TRIM_RETURN_MEDIA;
                        } else if (checkedId == R.id.rbTrimReturnTime) {
                            tempData.mTrimReturnMode = TrimConfiguration.TRIM_RETURN_TIME;
                        } else {
                            tempData.mTrimReturnMode = TrimConfiguration.TRIM_DYNAMIC_RETURN;
                        }
                    }
                });
        rgTrimType
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        if (checkedId == R.id.rbTrimTypeFree) {
                            tempData.mTrimType = TrimConfiguration.TRIM_TYPE_FREE;
                            setCropRadioButtonEnable(false);
                            rgTrimCropMode.check(R.id.rbTrimNormal);
                            view.findViewById(R.id.llSingleFixedTrimTime).setVisibility(View.GONE);
                            view.findViewById(R.id.llTrimTime1).setVisibility(View.GONE);
                            view.findViewById(R.id.llTrimTime2).setVisibility(View.GONE);
                        } else if (checkedId == R.id.rbTrimSingleFixed) {
                            tempData.mTrimType = TrimConfiguration.TRIM_TYPE_SINGLE_FIXED;
                            setCropRadioButtonEnable(true);
                            view.findViewById(R.id.llSingleFixedTrimTime).setVisibility(View.VISIBLE);
                            view.findViewById(R.id.llTrimTime1).setVisibility(View.GONE);
                            view.findViewById(R.id.llTrimTime2).setVisibility(View.GONE);
                        } else {
                            tempData.mTrimType = TrimConfiguration.TRIM_TYPE_DOUBLE_FIXED;
                            setCropRadioButtonEnable(true);
                            view.findViewById(R.id.llSingleFixedTrimTime).setVisibility(View.GONE);
                            view.findViewById(R.id.llTrimTime1).setVisibility(View.VISIBLE);
                            view.findViewById(R.id.llTrimTime2).setVisibility(View.VISIBLE);
                        }
                    }
                });
        rgTrimCropMode
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        if (checkedId == R.id.rbTrimNormal) {
                            tempData.enable1x1 = false;
                            tempData.default1x1CropMode = false;
                        } else if (checkedId == R.id.rbTrim1x1) {
                            tempData.enable1x1 = false;
                            tempData.default1x1CropMode = true;
                        } else if (checkedId == R.id.rbTrimNormalWithItem) {
                            tempData.enable1x1 = true;
                            tempData.default1x1CropMode = false;
                        } else {
                            tempData.enable1x1 = true;
                            tempData.default1x1CropMode = true;
                        }
                    }
                });

        etSingleFixedTrimTime = (EditText) view.findViewById(R.id.etSingleFixedTrimTime);
        if (tempData.trimSingleFixedDuration != 0) {
            etSingleFixedTrimTime.setText("" + tempData.trimSingleFixedDuration);
        }

        etTrimTime1 = (EditText) view.findViewById(R.id.etTrimTime1);
        if (tempData.trimTime1 != 0) {
            etTrimTime1.setText("" + tempData.trimTime1);
        }

        etTrimTime2 = (EditText) view.findViewById(R.id.etTrimTime2);
        if (tempData.trimTime2 != 0) {
            etTrimTime2.setText("" + tempData.trimTime2);
        }

        initdata();
    }

    private void setCropRadioButtonEnable(boolean enable) {
        rbTrimNormal.setEnabled(enable);
        rbTrim1x1.setEnabled(enable);
        rbTrimNormalWithItem.setEnabled(enable);
        rbTrim1x1WithItem.setEnabled(enable);
    }

    /***
     * 重置各配置项的默认value
     */
    private void initdata() {

        if (tempData.mTrimReturnMode == TrimConfiguration.TRIM_RETURN_MEDIA) {
            rgTrimReturnMode.check(R.id.rbTrimReturnMedia);
        } else if (tempData.mTrimReturnMode == TrimConfiguration.TRIM_RETURN_TIME) {
            rgTrimReturnMode.check(R.id.rbTrimReturnTime);
        } else {
            rgTrimReturnMode.check(R.id.rbTrimDynamicReturn);
        }
        if (tempData.mTrimType == TrimConfiguration.TRIM_TYPE_FREE) {
            rgTrimType.check(R.id.rbTrimTypeFree);
        } else if (tempData.mTrimType == TrimConfiguration.TRIM_TYPE_SINGLE_FIXED) {
            rgTrimType.check(R.id.rbTrimSingleFixed);
        } else {
            rgTrimType.check(R.id.rbTrimDoubleFixed);
        }
        if (tempData.default1x1CropMode) {
            if (tempData.enable1x1) {
                rgTrimCropMode.check(R.id.rbTrim1x1WithItem);
            } else {
                rgTrimCropMode.check(R.id.rbTrim1x1);
            }
        } else {
            if (tempData.enable1x1) {
                rgTrimCropMode.check(R.id.rbTrimNormalWithItem);
            } else {
                rgTrimCropMode.check(R.id.rbTrimNormal);
            }
        }
    }


    /**
     * 保存录制设置对话框的参数
     */
    private void saveConfigData() {

        // 读取单定长截取时间
        if (etSingleFixedTrimTime != null) {
            if (!TextUtils.isEmpty(etSingleFixedTrimTime.getText())) {
                tempData.trimSingleFixedDuration = Integer.valueOf(etSingleFixedTrimTime
                        .getText().toString());
            } else {
                tempData.trimSingleFixedDuration = 0;
            }
        }
        // 读取两定长截取时间1
        if (etTrimTime1 != null) {
            if (!TextUtils.isEmpty(etTrimTime1.getText())) {
                tempData.trimTime1 = Integer.valueOf(etTrimTime1
                        .getText().toString());
            } else {
                tempData.trimTime1 = 0;
            }
        }
        // 读取两定长截取时间2
        if (etTrimTime2 != null) {
            if (!TextUtils.isEmpty(etTrimTime2.getText())) {
                tempData.trimTime2 = Integer.valueOf(etTrimTime2
                        .getText().toString());
            } else {
                tempData.trimTime2 = 0;
            }
        }
    }
}
