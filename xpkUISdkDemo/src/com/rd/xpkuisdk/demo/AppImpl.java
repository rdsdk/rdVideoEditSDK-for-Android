package com.rd.xpkuisdk.demo;

import android.app.Application;
import android.os.Environment;

import com.rd.xpkuisdk.MyCrashHandler;
import com.rd.xpkuisdk.XpkSdk;

/**
 * ************************集成步骤 *******************
 * 
 * 1. 在官网注册开发者账户
 * 
 * 2. 下载SDK和demo代码
 * 
 * 3. 创建应用，获取appKey和appSecret，导入SDK
 * 
 ******************************************************** 
 * 
 * xpkUISDK自定义Application
 * 
 */
public class AppImpl extends Application {
	/**
	 * 已获取的AppKey
	 */
	public static final String APP_KEY = "27eb1f31f0f52501";
	/**
	 * 已获取的AppSecret
	 */
	public static final String APP_SECRET = "3ac8a8b40ce5bd5c37642978ef097731TDgMqucwJLGDvj09ws+W82FH8K5E5H6onCA01GRnpc0BSFM1ih2nXeX5aHyRfjlZY5hbwHrXlyTcH3i3cDebjS//Q++L5M30pIHb4S/4W6gGO4rIzup6ImsxgHExwqy/k/08HScy8OSkjK67JlkaS3ivejvTZpMGlst/hizafT4JkrarYi3vSBmin2i+4kKc4BuJHNAfORV3JnJi52A/nbPhbSCulMUWAC/ccw+f1a5RBWY6ZMl4VB4hpCx87tvKpF9Ctzf0XuaoNWSWlYSAyNoAp1UhM5nlEk0nf2nzScTovrt4CfR1qq5vrifqMubvSfjAT4y4jck30YFyxRnJLXAcWPKoUisUCwhelVMc2o+4s+UlIBDtsm/5rhddUoPmWRBsKllAENGsCD1oRJMeRiA0Wr/EgZ+XNu6NMC3PrQcaw/HWaM1dwT4c3o2z9yXh3zokTvDVjR5SmX0ab19YanCEy4vlfobIaJoBFbIbzlfymJGnpkfoObHN9b7qjYwA";

	@Override
	public void onCreate() {
		super.onCreate();
		initXpkSdk();
	}

	/**
	 * 初始化SDK
	 */
	public void initXpkSdk() {
		// 这里确定是否启用日志，在调试阶段可开启该选项，方便定位问题。打包为发行版时，此启用无效
		XpkSdk.enableDebugLog(true);
		// 自定义根目录，如果为空则默认为/sdcard/xpk
		String strCustomPath = Environment.getExternalStorageDirectory()
				+ "/xpk";
		// sdk初始
		XpkSdk.init(AppImpl.this, strCustomPath, APP_KEY, APP_SECRET,
				new SdkHandler().getCallBack());
		// 自定义Crash handler,实际项目可不加入
		MyCrashHandler.getInstance().init(this);
		faceHanlder = new FaceHandler(this);
	}

	@SuppressWarnings("unused")
	private FaceHandler faceHanlder;

}
