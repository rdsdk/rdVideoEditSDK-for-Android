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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.rd.xpkuisdk.demo.R;
import com.rd.xpkuisdk.demo.utils.SDKUtils;
import com.rd.xpkuisdk.manager.UIConfiguration;

/**
 * 视频编辑界面及导出设置对话框
 */
public class EditorUIAndExportConfigDialog {
	private AlertDialog dialog;
	private ConfigData tempData;
	private Activity mActitivy;

	// 对话框界面的控件
	private CheckBox soundTrack, dubbing, filter, titling, specialEffects,
			clipEditing, mv, subTitleOuter, specialOuter;
	private CheckBox watermark, videoTrailer;
	private Switch swWizard, swAutoRepeat;
	private CheckBox imageDuration, edit, trim, videoSpeed, split, copy,
			proportion, sort, text;
	private EditText etExportDuration;
	private EditText etWatermarkXAxis, etWatermarkYAxis, etWatermarkXZoom,
			etWatermarkYZoom;
	private RadioGroup rgProportion, rgSupportFormat, rgSoundTrack, rgFilter,
			rgOrientation, rgVoice;
	private RadioButton rbPorportionSquare, rbPorportionLandscape,
			rbPorportionAuto;

	/**
	 * 构造函数
	 */
	public EditorUIAndExportConfigDialog(Activity activity,
			final ConfigDialogListener listener, ConfigData configData) {
		mActitivy = activity;
		tempData = new ConfigData();
		tempData.setConfig(configData);
		View view = activity.getLayoutInflater().inflate(
				R.layout.ui_config_dialog, null);
		initDialogView(view);
		dialog = new AlertDialog.Builder(activity).setView(view)
				.setPositiveButton("返回", null)
				.setNegativeButton("保存", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						saveUIConfigData();
						listener.onSaveConfigData(tempData);
					}
				}).show();
		dialog.setOnDismissListener(listener);
	}

	private void initDialogView(final View view) {
		rbPorportionSquare = (RadioButton) view
				.findViewById(R.id.rbProportionSquare);
		rbPorportionAuto = (RadioButton) view
				.findViewById(R.id.rbProportionAuto);
		rbPorportionLandscape = (RadioButton) view
				.findViewById(R.id.rbProportionLandscape);
		// 控制向导模式开关
		swWizard = (Switch) view.findViewById(R.id.swWizard);
		swWizard.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				TextView tvWizard = (TextView) view.findViewById(R.id.tvWizard);
				if (isChecked) {
					tvWizard.setText("开启向导模式");
				} else {
					tvWizard.setText("关闭向导模式");
				}
				tempData.enableWizard = isChecked;
			}
		});
		swWizard.setChecked(tempData.enableWizard);

		// 控制自动播放开关
		swAutoRepeat = (Switch) view.findViewById(R.id.swAutoRepeat);
		swAutoRepeat.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				TextView tvAutoRepeat = (TextView) view
						.findViewById(R.id.tvAutoRepeat);
				if (isChecked) {
					tvAutoRepeat.setText("开启自动播放");
				} else {
					tvAutoRepeat.setText("关闭自动播放");
				}
				tempData.enableAutoRepeat = isChecked;
			}
		});
		swAutoRepeat.setChecked(tempData.enableAutoRepeat);

		// 配乐界面选择
		rgSoundTrack = (RadioGroup) view.findViewById(R.id.rgSoundTrack);
		if (tempData.soundTrakLayoutType == UIConfiguration.SOUND_TRACK_LAYOUT_1) {
			rgSoundTrack.check(R.id.rbSoundTrak1);
		} else if (tempData.soundTrakLayoutType == UIConfiguration.SOUND_TRACK_LAYOUT_2) {
			rgSoundTrack.check(R.id.rbSoundTrak2);
		}
		rgSoundTrack
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbSoundTrak1) {
							tempData.soundTrakLayoutType = UIConfiguration.SOUND_TRACK_LAYOUT_1;
						} else if (checkedId == R.id.rbSoundTrak2) {
							if (tempData.orientation == UIConfiguration.ORIENTATION_PORTRAIT) {
								tempData.soundTrakLayoutType = UIConfiguration.SOUND_TRACK_LAYOUT_2;
							} else {
								rgSoundTrack.check(R.id.rbSoundTrak1);
								Toast.makeText(mActitivy, "只有竖屏支持使用配乐二界面",
										Toast.LENGTH_SHORT).show();
							}

						}
					}
				});

		// 配音
		rgVoice = (RadioGroup) view.findViewById(R.id.rgVoiceTrack);
		if (tempData.voiceLayoutType == UIConfiguration.VOICE_LAYOUT_1) {
			rgVoice.check(R.id.rbVoiceTrak1);
		} else if (tempData.voiceLayoutType == UIConfiguration.VOICE_LAYOUT_2) {
			rgVoice.check(R.id.rbVoiceTrak2);
		}
		rgVoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.rbVoiceTrak1) {
					tempData.voiceLayoutType = UIConfiguration.VOICE_LAYOUT_1;
				} else if (checkedId == R.id.rbVoiceTrak2) {
					tempData.voiceLayoutType = UIConfiguration.VOICE_LAYOUT_2;
					if (!tempData.enableSoundTrack) {
						rgVoice.check(R.id.rbVoiceTrak1);
						tempData.voiceLayoutType = UIConfiguration.VOICE_LAYOUT_1;
						Toast.makeText(mActitivy, "方式二配音只能在配乐开启的情况下有效",
								Toast.LENGTH_SHORT).show();
					}
				}
			}
		});

		// 滤镜界面选择
		rgFilter = (RadioGroup) view.findViewById(R.id.rgFilter);
		if (tempData.filterLayoutType == UIConfiguration.FILTER_LAYOUT_1) {
			rgFilter.check(R.id.rbFilter1);
		} else if (tempData.filterLayoutType == UIConfiguration.FILTER_LAYOUT_2) {
			rgFilter.check(R.id.rbFilter2);
		}
		rgFilter.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.rbFilter1) {
					tempData.filterLayoutType = UIConfiguration.FILTER_LAYOUT_1;
				} else if (checkedId == R.id.rbFilter2) {
					if (tempData.orientation == UIConfiguration.ORIENTATION_PORTRAIT) {
						tempData.filterLayoutType = UIConfiguration.FILTER_LAYOUT_2;
					} else {
						rgFilter.check(R.id.rbFilter1);
						Toast.makeText(mActitivy, "只有竖屏支持使用滤镜二界面",
								Toast.LENGTH_SHORT).show();
					}

				}
			}
		});

		// 选择视频比例
		rgProportion = (RadioGroup) view.findViewById(R.id.rgProportion);
		if (tempData.videoProportionType == UIConfiguration.PROPORTION_AUTO) {
			rgProportion.check(R.id.rbProportionAuto);
		} else if (tempData.videoProportionType == UIConfiguration.PROPORTION_SQUARE) {
			rgProportion.check(R.id.rbProportionSquare);
		} else if (tempData.videoProportionType == UIConfiguration.PROPORTION_LANDSCAPE) {
			rgProportion.check(R.id.rbProportionLandscape);
		}
		rgProportion
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbProportionAuto) {
							tempData.videoProportionType = UIConfiguration.PROPORTION_AUTO;
						} else if (checkedId == R.id.rbProportionSquare) {
							tempData.videoProportionType = UIConfiguration.PROPORTION_SQUARE;
						} else if (checkedId == R.id.rbProportionLandscape) {
							tempData.videoProportionType = UIConfiguration.PROPORTION_LANDSCAPE;
						}
					}
				});

		// 选择秀拍客相册支持的格式
		rgSupportFormat = (RadioGroup) view.findViewById(R.id.rgSupportFormat);
		if (tempData.albumSupportFormatType == UIConfiguration.ALBUM_SUPPORT_DEFAULT) {
			rgSupportFormat.check(R.id.rbSupportDefault);
		} else if (tempData.albumSupportFormatType == UIConfiguration.ALBUM_SUPPORT_IMAGE_ONLY) {
			rgSupportFormat.check(R.id.rbSupportImageOnly);
		} else if (tempData.albumSupportFormatType == UIConfiguration.ALBUM_SUPPORT_VIDEO_ONLY) {
			rgSupportFormat.check(R.id.rbSupportVideoOnly);
		}
		rgSupportFormat
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbSupportDefault) {
							tempData.albumSupportFormatType = UIConfiguration.ALBUM_SUPPORT_DEFAULT;
						} else if (checkedId == R.id.rbSupportImageOnly) {
							tempData.albumSupportFormatType = UIConfiguration.ALBUM_SUPPORT_IMAGE_ONLY;
						} else if (checkedId == R.id.rbSupportVideoOnly) {
							tempData.albumSupportFormatType = UIConfiguration.ALBUM_SUPPORT_VIDEO_ONLY;
						}
					}
				});

		// 设置横竖屏
		rgOrientation = (RadioGroup) view.findViewById(R.id.rgOrientation);
		if (tempData.orientation == UIConfiguration.ORIENTATION_PORTRAIT) {
			rgOrientation.check(R.id.rbOrientationPortrait);
		} else if (tempData.orientation == UIConfiguration.ORIENTATION_LANDSCAPE) {
			rgOrientation.check(R.id.rbOrientationLandscape);
		} else if (tempData.orientation == UIConfiguration.ORIENTATION_AUTO) {
			rgOrientation.check(R.id.rbOrientationAuto);
		}
		rgOrientation
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbOrientationPortrait) {
							tempData.orientation = UIConfiguration.ORIENTATION_PORTRAIT;
						} else if (checkedId == R.id.rbOrientationLandscape) {
							tempData.orientation = UIConfiguration.ORIENTATION_LANDSCAPE;
							rgSoundTrack.check(R.id.rbSoundTrak1);
							rgFilter.check(R.id.rbFilter1);
						} else if (checkedId == R.id.rbOrientationAuto) {
							tempData.orientation = UIConfiguration.ORIENTATION_AUTO;
							rgSoundTrack.check(R.id.rbSoundTrak1);
							rgFilter.check(R.id.rbFilter1);
						}
					}
				});

		// 设置视频水印位置
		etWatermarkXAxis = (EditText) view.findViewById(R.id.etWatermarkXAxis);
		etWatermarkYAxis = (EditText) view.findViewById(R.id.etWatermarkYAxis);
		etWatermarkXZoom = (EditText) view.findViewById(R.id.etWatermarkXZoom);
		etWatermarkYZoom = (EditText) view.findViewById(R.id.etWatermarkYZoom);
		if (tempData.watermarkShowRectF != null) {
			if (tempData.watermarkShowRectF.left != 0) {
				etWatermarkXAxis.setText("" + tempData.watermarkShowRectF.left);
			}
			if (tempData.watermarkShowRectF.top != 0) {
				etWatermarkYAxis.setText("" + tempData.watermarkShowRectF.top);
			}
			if (tempData.watermarkShowRectF.right != 0) {
				etWatermarkXZoom
						.setText("" + tempData.watermarkShowRectF.right);
			}
			if (tempData.watermarkShowRectF.bottom != 0) {
				etWatermarkYZoom.setText(""
						+ tempData.watermarkShowRectF.bottom);
			}
		}

		// 限制导出视频时间的EditText
		etExportDuration = (EditText) view.findViewById(R.id.etTimeLimit);
		if (tempData.exportVideoDuration != 0) {
			etExportDuration.setText("" + tempData.exportVideoDuration);
		}

		// 控制功能模块的CheckBox
		imageDuration = (CheckBox) view.findViewById(R.id.imageDurationControl);
		edit = (CheckBox) view.findViewById(R.id.edit);
		trim = (CheckBox) view.findViewById(R.id.trim);
		videoSpeed = (CheckBox) view.findViewById(R.id.videoSpeedControl);
		split = (CheckBox) view.findViewById(R.id.split);
		copy = (CheckBox) view.findViewById(R.id.copy);
		proportion = (CheckBox) view.findViewById(R.id.proportion);
		sort = (CheckBox) view.findViewById(R.id.sort);
		text = (CheckBox) view.findViewById(R.id.text);
		mv = (CheckBox) view.findViewById(R.id.mv);

		soundTrack = (CheckBox) view.findViewById(R.id.soundTrack);
		dubbing = (CheckBox) view.findViewById(R.id.VoiceTrack);
		filter = (CheckBox) view.findViewById(R.id.filter);
		titling = (CheckBox) view.findViewById(R.id.titling);
		specialEffects = (CheckBox) view.findViewById(R.id.specialEffects);
		clipEditing = (CheckBox) view.findViewById(R.id.clipEditing);

		watermark = (CheckBox) view.findViewById(R.id.watermark);
		videoTrailer = (CheckBox) view.findViewById(R.id.videoTrailer);

		subTitleOuter = (CheckBox) view.findViewById(R.id.subTitleOuter);
		specialOuter = (CheckBox) view.findViewById(R.id.specialOuter);

		subTitleOuter.setOnCheckedChangeListener(UICheckListener);
		specialOuter.setOnCheckedChangeListener(UICheckListener);

		imageDuration.setOnCheckedChangeListener(UICheckListener);
		edit.setOnCheckedChangeListener(UICheckListener);
		trim.setOnCheckedChangeListener(UICheckListener);
		videoSpeed.setOnCheckedChangeListener(UICheckListener);
		split.setOnCheckedChangeListener(UICheckListener);
		copy.setOnCheckedChangeListener(UICheckListener);
		proportion.setOnCheckedChangeListener(UICheckListener);
		sort.setOnCheckedChangeListener(UICheckListener);
		text.setOnCheckedChangeListener(UICheckListener);

		soundTrack.setOnCheckedChangeListener(UICheckListener);
		dubbing.setOnCheckedChangeListener(UICheckListener);
		filter.setOnCheckedChangeListener(UICheckListener);
		titling.setOnCheckedChangeListener(UICheckListener);
		specialEffects.setOnCheckedChangeListener(UICheckListener);
		clipEditing.setOnCheckedChangeListener(UICheckListener);
		mv.setOnCheckedChangeListener(UICheckListener);

		watermark.setOnCheckedChangeListener(UICheckListener);
		videoTrailer.setOnCheckedChangeListener(UICheckListener);

		imageDuration.setChecked(tempData.enableImageDuration);
		edit.setChecked(tempData.enableEdit);
		trim.setChecked(tempData.enableTrim);
		videoSpeed.setChecked(tempData.enableVideoSpeed);
		split.setChecked(tempData.enableSplit);
		copy.setChecked(tempData.enableCopy);
		proportion.setChecked(tempData.enableProportion);
		sort.setChecked(tempData.enableSort);
		text.setChecked(tempData.enableText);

		soundTrack.setChecked(tempData.enableSoundTrack);
		dubbing.setChecked(tempData.enableDubbing);
		filter.setChecked(tempData.enableFilter);
		titling.setChecked(tempData.enableTitling);
		specialEffects.setChecked(tempData.enableSpecialEffects);
		clipEditing.setChecked(tempData.enableClipEditing);

		videoTrailer.setChecked(tempData.enableVideoTrailer);
		watermark.setChecked(tempData.enableWatermark);
		mv.setChecked(tempData.enableMV);

		proportion.setEnabled(!tempData.enableMV);

		rbPorportionSquare.setEnabled(!tempData.enableMV);
		rbPorportionAuto.setEnabled(!tempData.enableMV);
		rbPorportionLandscape.setEnabled(!tempData.enableMV);
		setClipEditingMudulesEnabled(tempData.enableClipEditing);

		subTitleOuter.setChecked(tempData.enableTitlingOuter);
		specialOuter.setChecked(tempData.enableSpecialeffectsOuter);
	}

	OnCheckedChangeListener UICheckListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			int id = buttonView.getId();

			// 片段编辑
			if (id == R.id.imageDurationControl) {
				tempData.enableImageDuration = isChecked;
			} else if (id == R.id.edit) {
				tempData.enableEdit = isChecked;
			} else if (id == R.id.trim) {
				tempData.enableTrim = isChecked;
			} else if (id == R.id.videoSpeedControl) {
				tempData.enableVideoSpeed = isChecked;
			} else if (id == R.id.split) {
				tempData.enableSplit = isChecked;
			} else if (id == R.id.copy) {
				tempData.enableCopy = isChecked;
			} else if (id == R.id.proportion) {
				tempData.enableProportion = isChecked;
			} else if (id == R.id.sort) {
				tempData.enableSort = isChecked;
			} else if (id == R.id.text) {
				tempData.enableText = isChecked;
			}  else if (id == R.id.mv) {
				tempData.enableMV = isChecked;
				proportion.setEnabled(!isChecked);
				proportion.setChecked(!isChecked);
				if (!tempData.enableClipEditing) {
					proportion.setEnabled(false);
				}
				rgProportion.check(R.id.rbProportionSquare);
				rbPorportionSquare.setEnabled(!isChecked);
				rbPorportionAuto.setEnabled(!isChecked);
				rbPorportionLandscape.setEnabled(!isChecked);
			}
			// 编辑与导出
			else if (id == R.id.soundTrack) {
				tempData.enableSoundTrack = isChecked;
				View v = (View) buttonView.getParent();
				v.findViewById(R.id.rbSoundTrak1).setEnabled(isChecked);
				v.findViewById(R.id.rbSoundTrak2).setEnabled(isChecked);

			} else if (id == R.id.filter) {
				tempData.enableFilter = isChecked;
				View v = (View) buttonView.getParent();
				v.findViewById(R.id.rbFilter1).setEnabled(isChecked);
				v.findViewById(R.id.rbFilter2).setEnabled(isChecked);

			} else if (id == R.id.VoiceTrack) {
				tempData.enableDubbing = isChecked;
			} else if (id == R.id.titling) {
				tempData.enableTitling = isChecked;
			} else if (id == R.id.specialEffects) {
				tempData.enableSpecialEffects = isChecked;
			} else if (id == R.id.clipEditing) {
				tempData.enableClipEditing = isChecked;
				setClipEditingMudulesEnabled(isChecked);
			}
			// 视频水印
			else if (id == R.id.watermark) {
				tempData.enableWatermark = isChecked;
			}
			// 片尾水印
			else if (id == R.id.videoTrailer) {
				tempData.enableVideoTrailer = isChecked;
			} else if (id == R.id.subTitleOuter) {
				tempData.enableTitlingOuter = isChecked;
			} else if (id == R.id.specialOuter) {
				tempData.enableSpecialeffectsOuter = isChecked;
			}
		}
	};

	private void setClipEditingMudulesEnabled(boolean enable) {
		imageDuration.setEnabled(enable);
		edit.setEnabled(enable);
		trim.setEnabled(enable);
		videoSpeed.setEnabled(enable);
		split.setEnabled(enable);
		copy.setEnabled(enable);
		proportion.setEnabled(enable);
		sort.setEnabled(enable);
		text.setEnabled(enable);
		if (tempData.enableMV) {
			proportion.setEnabled(false);
		}
	}

	/**
	 * 保存UI设置对话框的参数
	 */
	private void saveUIConfigData() {
		// 读取导出时间限制
		if (etExportDuration != null) {
			if (!TextUtils.isEmpty(etExportDuration.getText())) {
				tempData.exportVideoDuration = Integer.valueOf(etExportDuration
						.getText().toString());
			} else {
				tempData.exportVideoDuration = 0;
			}
		}
		// 水印显示位置
		if (etWatermarkXAxis != null) {
			float left, top, right, bottom;
			if (!TextUtils.isEmpty(etWatermarkXAxis.getText())) {
				left = Float.valueOf(etWatermarkXAxis.getText().toString());
			} else {
				left = 0;
			}
			if (!TextUtils.isEmpty(etWatermarkYAxis.getText())) {
				top = Float.valueOf(etWatermarkYAxis.getText().toString());
			} else {
				top = 0;
			}
			if (!TextUtils.isEmpty(etWatermarkXZoom.getText())) {
				right = Float.valueOf(etWatermarkXZoom.getText().toString());
			} else {
				right = 0;
			}
			if (!TextUtils.isEmpty(etWatermarkYZoom.getText())) {
				bottom = Float.valueOf(etWatermarkYZoom.getText().toString());
			} else {
				bottom = 0;
			}
			tempData.watermarkShowRectF.set(left, top, right, bottom);
		}
		if (tempData.enableVideoTrailer) {
			// TODO:构造片尾
			tempData.videoTrailerPath = SDKUtils.createVideoTrailerImage(
					mActitivy, "秀友", 480, 50, 50);
		} else {
			tempData.videoTrailerPath = null;
		}
	}
}
