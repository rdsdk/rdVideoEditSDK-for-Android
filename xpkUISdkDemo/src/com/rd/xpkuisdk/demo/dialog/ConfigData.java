package com.rd.xpkuisdk.demo.dialog;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

import com.rd.xpkuisdk.manager.TrimConfiguration;
import com.rd.xpkuisdk.manager.UIConfiguration;

/**
 * 演示配置数据
 */
public class ConfigData implements Parcelable {
    public static final String WEB_MV_URL = "http://dianbook.17rd.com/api/shortvideo/getmvprop";
    public static final String WEB_MUSIC_URL = "http://dianbook.17rd.com/api/shortvideo/getbgmusic";

    public String videoTrailerPath = null; // 片尾图片路径
    // ui配置参数
    public boolean enableWizard = false;
    public boolean enableAutoRepeat = false;
    public boolean enableMV = false;
    public String mvUrl = WEB_MV_URL;
    public boolean enableImageDuration = true;
    public boolean enableEdit = true;
    public boolean enableTrim = true;
    public boolean enableVideoSpeed = true;
    public boolean enableSplit = true;
    public boolean enableCopy = true;
    public boolean enableProportion = true;
    public boolean enableSort = true;
    public boolean enableText = true;
    public boolean enableReverse = true;

    public boolean enableSoundTrack = true;
    public boolean enableDubbing = true;
    public boolean enableFilter = true;
    public boolean enableTitling = true;
    public boolean enableSpecialEffects = true;
    public boolean enableClipEditing = true;

    public int videoProportionType = UIConfiguration.PROPORTION_AUTO;
    public int albumSupportFormatType = UIConfiguration.ALBUM_SUPPORT_DEFAULT;
    public int orientation = UIConfiguration.ORIENTATION_PORTRAIT;
    public int albumMediaCountLimit = 0;

    public int soundTrakLayoutType = UIConfiguration.SOUND_TRACK_LAYOUT_1;
    public int voiceLayoutType = UIConfiguration.VOICE_LAYOUT_1;
    public String musicUrl = WEB_MUSIC_URL;
    public int filterLayoutType = UIConfiguration.FILTER_LAYOUT_1;

    public boolean enableAlbumCamera = true;

    // 导出配置参数
    public boolean enableWatermark = true;
    public boolean enableVideoTrailer = false;

    public RectF watermarkShowRectF = new RectF();
    public int exportVideoDuration = 0;

    // 拍摄配置参数
    public boolean useMultiShoot = false;
    public boolean isSaveToAlbum = false;
    public boolean isDefaultRearCamera = false;
    public boolean isDefaultFace = false;
    public boolean enableAlbum = true;
    public boolean useCustomAlbum = false;

    public int cameraMinTime = 0;
    public int cameraMaxTime = 0;
    public int cameraMVMaxTime = 0;
    public int cameraMVMinTime = 0;

    public boolean hideMV = false;
    public boolean hidePhoto = false;
    public boolean hideRec = false;

    // 截取配置参数
    public boolean enable1x1 = true;
    public boolean default1x1CropMode = false;

    // 压缩配置参数
    public boolean enableHWCode = true;
    public boolean enableCompressWatermark = false;
    public RectF compressWatermarkShowRect = new RectF();
    public double compressBitRate = 0;
    public int compressVideoWidth = 0;
    public int compressVideoHeight = 0;

    // 截取时间
    public int mTrimType = TrimConfiguration.TRIM_TYPE_FREE;
    public int trimSingleFixedDuration = 0;
    public int trimTime1 = 0;
    public int trimTime2 = 0;

    // 相机水印
    public boolean enableCameraWatermark = false;
    // 相机录制片尾水印 （0-1.0f） 单位：秒
    public float cameraWatermarkEnd = 0f;
    // 截取行为
    public int mTrimReturnMode = TrimConfiguration.TRIM_RETURN_MEDIA;

    /**
     * 为true时，字幕在mv的外面
     */
    public boolean enableTitlingOuter = true;
    /**
     * 为true时，特效在mv的外面
     */
    public boolean enableSpecialeffectsOuter = false;

    /**
     * 是否启用防篡改录制
     */
    public boolean enableAntiChange = false;

    /**
     * 防篡改水印的内容
     */
    public String antiChangeText = "";

    /**
     * 构造函数
     */
    public ConfigData() {

    }

    /**
     * 复制配置
     *
     * @param data
     */
    public void setConfig(ConfigData data) {
        Parcel parcel = Parcel.obtain();
        data.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        this.readFromParcel(parcel);
        parcel.recycle();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.videoTrailerPath);
        dest.writeByte(this.enableWizard ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableAutoRepeat ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableMV ? (byte) 1 : (byte) 0);
        dest.writeString(this.mvUrl);
        dest.writeByte(this.enableImageDuration ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableEdit ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableTrim ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableVideoSpeed ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableSplit ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableCopy ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableProportion ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableSort ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableText ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableReverse ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableSoundTrack ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableDubbing ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableFilter ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableTitling ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableSpecialEffects ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableClipEditing ? (byte) 1 : (byte) 0);
        dest.writeInt(this.videoProportionType);
        dest.writeInt(this.albumSupportFormatType);
        dest.writeInt(this.orientation);
        dest.writeInt(this.albumMediaCountLimit);
        dest.writeInt(this.soundTrakLayoutType);
        dest.writeInt(this.voiceLayoutType);
        dest.writeInt(this.filterLayoutType);
        dest.writeByte(this.enableAlbumCamera ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableWatermark ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableVideoTrailer ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.watermarkShowRectF, flags);
        dest.writeInt(this.exportVideoDuration);
        dest.writeByte(this.useMultiShoot ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isSaveToAlbum ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isDefaultRearCamera ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isDefaultFace ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableAlbum ? (byte) 1 : (byte) 0);
        dest.writeByte(this.useCustomAlbum ? (byte) 1 : (byte) 0);
        dest.writeInt(this.cameraMinTime);
        dest.writeInt(this.cameraMaxTime);
        dest.writeInt(this.cameraMVMaxTime);
        dest.writeInt(this.cameraMVMinTime);
        dest.writeByte(this.hideMV ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hidePhoto ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hideRec ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enable1x1 ? (byte) 1 : (byte) 0);
        dest.writeByte(this.default1x1CropMode ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableHWCode ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableCompressWatermark ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.compressWatermarkShowRect, flags);
        dest.writeDouble(this.compressBitRate);
        dest.writeInt(this.compressVideoWidth);
        dest.writeInt(this.compressVideoHeight);
        dest.writeInt(this.mTrimType);
        dest.writeInt(this.trimSingleFixedDuration);
        dest.writeInt(this.trimTime1);
        dest.writeInt(this.trimTime2);
        dest.writeInt(this.mTrimReturnMode);
        dest.writeByte(this.enableCameraWatermark ? (byte) 1 : (byte) 0);
        dest.writeFloat(this.cameraWatermarkEnd);
        dest.writeByte(this.enableTitlingOuter ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableSpecialeffectsOuter ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableAntiChange ? (byte) 1 : (byte) 0);
        dest.writeString(this.antiChangeText);
        dest.writeString(this.musicUrl);
    }

    protected ConfigData readFromParcel(Parcel in) {
        this.videoTrailerPath = in.readString();
        this.enableWizard = in.readByte() != 0;
        this.enableAutoRepeat = in.readByte() != 0;
        this.enableMV = in.readByte() != 0;
        this.mvUrl = in.readString();
        this.enableImageDuration = in.readByte() != 0;
        this.enableEdit = in.readByte() != 0;
        this.enableTrim = in.readByte() != 0;
        this.enableVideoSpeed = in.readByte() != 0;
        this.enableSplit = in.readByte() != 0;
        this.enableCopy = in.readByte() != 0;
        this.enableProportion = in.readByte() != 0;
        this.enableSort = in.readByte() != 0;
        this.enableText = in.readByte() != 0;
        this.enableReverse = in.readByte() != 0;
        this.enableSoundTrack = in.readByte() != 0;
        this.enableDubbing = in.readByte() != 0;
        this.enableFilter = in.readByte() != 0;
        this.enableTitling = in.readByte() != 0;
        this.enableSpecialEffects = in.readByte() != 0;
        this.enableClipEditing = in.readByte() != 0;
        this.videoProportionType = in.readInt();
        this.albumSupportFormatType = in.readInt();
        this.orientation = in.readInt();
        this.albumMediaCountLimit = in.readInt();
        this.soundTrakLayoutType = in.readInt();
        this.voiceLayoutType = in.readInt();
        this.filterLayoutType = in.readInt();
        this.enableAlbumCamera = in.readByte() != 0;
        this.enableWatermark = in.readByte() != 0;
        this.enableVideoTrailer = in.readByte() != 0;
        this.watermarkShowRectF = in.readParcelable(RectF.class
                .getClassLoader());
        this.exportVideoDuration = in.readInt();
        this.useMultiShoot = in.readByte() != 0;
        this.isSaveToAlbum = in.readByte() != 0;
        this.isDefaultRearCamera = in.readByte() != 0;
        this.isDefaultFace = in.readByte() != 0;
        this.enableAlbum = in.readByte() != 0;
        this.useCustomAlbum = in.readByte() != 0;
        this.cameraMinTime = in.readInt();
        this.cameraMaxTime = in.readInt();
        this.cameraMVMaxTime = in.readInt();
        this.cameraMVMinTime = in.readInt();
        this.hideMV = in.readByte() != 0;
        this.hidePhoto = in.readByte() != 0;
        this.hideRec = in.readByte() != 0;
        this.enable1x1 = in.readByte() != 0;
        this.default1x1CropMode = in.readByte() != 0;
        this.enableHWCode = in.readByte() != 0;
        this.enableCompressWatermark = in.readByte() != 0;
        this.compressWatermarkShowRect = in.readParcelable(RectF.class
                .getClassLoader());
        this.compressBitRate = in.readDouble();
        this.compressVideoWidth = in.readInt();
        this.compressVideoHeight = in.readInt();
        this.mTrimType = in.readInt();
        this.trimSingleFixedDuration = in.readInt();
        this.trimTime1 = in.readInt();
        this.trimTime2 = in.readInt();
        this.mTrimReturnMode = in.readInt();
        this.enableCameraWatermark = in.readByte() != 0;
        this.cameraWatermarkEnd = in.readFloat();
        this.enableTitlingOuter = in.readByte() == 1;
        this.enableSpecialeffectsOuter = in.readByte() == 1;
        this.enableAntiChange = in.readByte() == 1;
        this.antiChangeText = in.readString();
        this.musicUrl = in.readString();
        return this;
    }

    public static final Parcelable.Creator<ConfigData> CREATOR = new Parcelable.Creator<ConfigData>() {
        @Override
        public ConfigData createFromParcel(Parcel source) {
            return new ConfigData().readFromParcel(source);
        }

        @Override
        public ConfigData[] newArray(int size) {
            return new ConfigData[size];
        }
    };
}
