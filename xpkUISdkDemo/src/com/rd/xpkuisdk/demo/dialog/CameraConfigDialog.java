package com.rd.xpkuisdk.demo.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.rd.xpkuisdk.demo.R;

/**
 * 拍摄设置对话框
 * 
 */
public class CameraConfigDialog {
	private AlertDialog dialog;
	private ConfigData tempData;
	private CheckBox cbRec, cbMV, cbPhoto, cbOsd, cbAntiChange;
	private Switch swIsSaveToAlbum, swEnableAlbum, swUseCustomAlbum;
	private RadioGroup rgCameraMode, rgIsRearCamera, rgFaceUnity;
	private EditText etCameraMaxTime, etCameraMinTime, etCameraMVMaxTime,
			etCameraMVMinTime, etCamareOsdEnd;

	/**
	 * 构造函数
	 */
	public CameraConfigDialog(Activity activity,
			final ConfigDialogListener listener, ConfigData configData) {
		tempData = new ConfigData();
		tempData.setConfig(configData);
		View view = activity.getLayoutInflater().inflate(
				R.layout.camera_config_dialog, null);
		initCameraDialogView(view);
		dialog = new AlertDialog.Builder(activity).setView(view)
				.setPositiveButton("返回", null)
				.setNegativeButton("保存", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						saveCameraConfigData();
						listener.onSaveConfigData(tempData);
					}
				}).show();
		dialog.setOnDismissListener(listener);
	}

	OnCheckedChangeListener CameraCheckListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			int id = buttonView.getId();
			if (id == R.id.cbMV) {
				tempData.hideMV = !isChecked;
			} else if (id == R.id.cbRec) {
				tempData.hideRec = !isChecked;
			} else if (id == R.id.cbPhoto) {
				tempData.hidePhoto = !isChecked;
			} else if (id == R.id.cbOsd) {
				tempData.enableCameraWatermark = isChecked;
			} else if (id == R.id.cbAntiChange) {
				tempData.enableAntiChange = isChecked;
			}
		}
	};

	/**
	 * 初始化拍摄设置对话框
	 * 
	 * @param view
	 */
	private void initCameraDialogView(View view) {
		cbMV = (CheckBox) view.findViewById(R.id.cbMV);
		cbOsd = (CheckBox) view.findViewById(R.id.cbOsd);
		cbRec = (CheckBox) view.findViewById(R.id.cbRec);
		cbPhoto = (CheckBox) view.findViewById(R.id.cbPhoto);
		cbAntiChange = (CheckBox) view.findViewById(R.id.cbAntiChange);

		cbAntiChange.setOnCheckedChangeListener(CameraCheckListener);
		cbMV.setOnCheckedChangeListener(CameraCheckListener);
		cbRec.setOnCheckedChangeListener(CameraCheckListener);
		cbPhoto.setOnCheckedChangeListener(CameraCheckListener);
		cbOsd.setOnCheckedChangeListener(CameraCheckListener);
		
		cbAntiChange.setChecked(tempData.enableAntiChange);
		cbOsd.setChecked(tempData.enableCameraWatermark);
		cbMV.setChecked(!tempData.hideMV);
		cbRec.setChecked(!tempData.hideRec);
		cbPhoto.setChecked(!tempData.hidePhoto);

		// 片尾水印
		etCamareOsdEnd = (EditText) view.findViewById(R.id.etOsdEnd);
		if (tempData.cameraWatermarkEnd != 0) {
			etCamareOsdEnd.setText("" + tempData.cameraWatermarkEnd);
		}

		// 设置拍摄最小时长
		etCameraMinTime = (EditText) view.findViewById(R.id.etCameraMinTime);
		if (tempData.cameraMinTime != 0) {
			etCameraMinTime.setText("" + tempData.cameraMinTime);
		}

		// 设置拍摄最大时长
		etCameraMaxTime = (EditText) view.findViewById(R.id.etCameraMaxTime);
		if (tempData.cameraMaxTime != 0) {
			etCameraMaxTime.setText("" + tempData.cameraMaxTime);
		}

		// 设置MV最小时长
		etCameraMVMinTime = (EditText) view
				.findViewById(R.id.etCameraMVMinTime);
		if (tempData.cameraMVMinTime != 0) {
			etCameraMVMinTime.setText("" + tempData.cameraMVMinTime);
		}

		// 设置MV最大时长
		etCameraMVMaxTime = (EditText) view
				.findViewById(R.id.etCameraMVMaxTime);
		if (tempData.cameraMVMaxTime != 0) {
			etCameraMVMaxTime.setText("" + tempData.cameraMVMaxTime);
		}

		// 设置默认摄像头方向
		rgIsRearCamera = (RadioGroup) view.findViewById(R.id.rgIsRearCamera);
		rgIsRearCamera
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbFrontCamera) {
							tempData.isDefaultRearCamera = false;
						} else if (checkedId == R.id.rbRearCamera) {
							tempData.isDefaultRearCamera = true;
						}
					}
				});
		if (tempData.isDefaultRearCamera) {
			rgIsRearCamera.check(R.id.rbRearCamera);
		} else {
			rgIsRearCamera.check(R.id.rbFrontCamera);
		}
		rgFaceUnity = (RadioGroup) view.findViewById(R.id.rgCameraFaceGroup);
		rgFaceUnity
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbEnableFace) {
							tempData.isDefaultFace = true;
						} else {
							tempData.isDefaultFace = false;
						}
					}
				});
		if (tempData.isDefaultFace) {
			rgFaceUnity.check(R.id.rbEnableFace);
		} else {
			rgFaceUnity.check(R.id.rbUnableFace);
		}

		// 设置拍摄方式
		rgCameraMode = (RadioGroup) view.findViewById(R.id.rgCameraMode);
		rgCameraMode
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbMultiShoot) {
							tempData.useMultiShoot = true;
						} else if (checkedId == R.id.rbSingleShoot) {
							tempData.useMultiShoot = false;
						}
					}
				});
		if (tempData.useMultiShoot) {
			rgCameraMode.check(R.id.rbMultiShoot);
		} else {
			rgCameraMode.check(R.id.rbSingleShoot);
		}

		// 单次拍摄是否将图片保存至相册
		swIsSaveToAlbum = (Switch) view.findViewById(R.id.swIsSaveToAlbum);
		swIsSaveToAlbum
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						tempData.isSaveToAlbum = isChecked;
					}
				});
		swIsSaveToAlbum.setChecked(tempData.isSaveToAlbum);

		// 是否显示相册按钮
		swEnableAlbum = (Switch) view.findViewById(R.id.swEnableAlbum);
		swEnableAlbum.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				tempData.enableAlbum = isChecked;
			}
		});
		swEnableAlbum.setChecked(tempData.enableAlbum);

		// 是否使用自定义相册
		swUseCustomAlbum = (Switch) view.findViewById(R.id.swUseCustomAlbum);
		swUseCustomAlbum
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						tempData.useCustomAlbum = isChecked;
					}
				});
		swUseCustomAlbum.setChecked(tempData.useCustomAlbum);
	}

	/**
	 * 保存录制设置对话框的参数
	 */
	private void saveCameraConfigData() {
		// 读取最小录制时间
		if (etCameraMinTime != null) {
			if (!TextUtils.isEmpty(etCameraMinTime.getText())) {
				tempData.cameraMinTime = Integer.valueOf(etCameraMinTime
						.getText().toString());
			} else {
				tempData.cameraMinTime = 0;
			}
		}
		// 读取最大录制时间
		if (etCameraMaxTime != null) {
			if (!TextUtils.isEmpty(etCameraMaxTime.getText())) {
				tempData.cameraMaxTime = Integer.valueOf(etCameraMaxTime
						.getText().toString());
			} else {
				tempData.cameraMaxTime = 0;
			}
		}
		// 读取MV最小时长
		if (etCameraMVMinTime != null) {
			if (!TextUtils.isEmpty(etCameraMVMinTime.getText())) {
				tempData.cameraMVMinTime = Integer.valueOf(etCameraMVMinTime
						.getText().toString());
			} else {
				tempData.cameraMVMinTime = 0;
			}
		}
		// 读取MV最大时长
		if (etCameraMVMaxTime != null) {
			if (!TextUtils.isEmpty(etCameraMVMaxTime.getText())) {
				tempData.cameraMVMaxTime = Integer.valueOf(etCameraMVMaxTime
						.getText().toString());
			} else {
				tempData.cameraMVMaxTime = 0;
			}
		}
		if (etCamareOsdEnd != null) {
			if (!TextUtils.isEmpty(etCamareOsdEnd.getText())) {
				float ft = Float.valueOf(etCamareOsdEnd.getText().toString());
				float ftarget = Math.min(1.0f, Math.max(ft, 0));
				tempData.cameraWatermarkEnd = ftarget;
			} else {
				tempData.cameraWatermarkEnd = 0f;
			}
		}
	}
}
