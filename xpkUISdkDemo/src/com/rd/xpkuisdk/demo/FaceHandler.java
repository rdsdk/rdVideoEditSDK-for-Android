package com.rd.xpkuisdk.demo;

import java.io.File;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Environment;

import com.rd.xpkuisdk.XpkSdk;
import com.rd.xpkuisdk.XpksdkService;
import com.rd.xpkuisdk.demo.utils.SDKUtils;
import com.rd.xpkuisdk.manager.FaceuConfig;

/**
 * 导入人脸贴纸资源
 * 
 * @author JIAN 
 * @date 2017-3-18 上午11:36:37
 */
public class FaceHandler {

	private Context context;
	private final String root = Environment.getExternalStorageDirectory()
			+ "/xpk/faceu/";

	private FaceuConfig config = null;

	// 自定义网络化加载人脸贴纸资源
	private final String url = "http://dianbook.17rd.com/api/shortvideo/getfaceprop";

	public FaceHandler(Context _context) {
		context = _context;

		new AsyncTask<Integer, Integer, Integer>() {
			AssetManager asset;

			@Override
			protected void onPreExecute() {
				asset = context.getAssets();
				File f = new File(root);
				if (!f.exists()) {
					f.mkdirs();
				}
			};

			@Override
			protected Integer doInBackground(Integer... params) {
				config = new FaceuConfig();
				String v3 = root + "v3.mp3";
				if (!new File(v3).exists()) {
					SDKUtils.assetRes2File(asset, "faceu/v3.mp3", v3);
				}
				config.setV3Path(v3);// //设置基础库本地路径（必须,否则无法开启人脸识别及贴纸）
				String beauty = root + "face_beautification.mp3";
				if (!new File(beauty).exists()) {
					SDKUtils.assetRes2File(asset,
							"faceu/face_beautification.mp3", beauty);
				}
				config.setBeautyPath(beauty);// //设置美颜基础库本地路径（必须,否则无法启用美颜）

				//设置开启美颜时美白的等级 (参数值0.0f-1.0f,开启人脸识别且开启美颜之后生效)
				config.setColor_level(0.48f);
				//设置开启美颜时磨皮的等级(参数值0.0f-4.0f,开启人脸识别且开启美颜之后生效)
				config.setBlur_level(4.0f);
				//设置开启美颜时瘦脸的等级 (有效参数值0.0f-2.0f,开启人脸识别且开启美颜之后生效)
				config.setCheek_thinning(0.68f);
				//设置美颜时大眼的等级(有效参数值0.0f-4.0f,开启人脸识别且开启美颜之后生效)
				config.setEye_enlarging(1.53f);

				// // 方式一: 加载本地资源

				// String dog = root + "BeagleDog.mp3", dogIcon = root
				// + "beagledog.png";
				// String colorCrown = root + "ColorCrown.mp3", colorCrownIcon =
				// root
				// + "colorcrown.png";
				// String tiara = root + "tiara.mp3", tiaraIcon = root
				// + "tiara.png";
				// String yellowEar = root + "YellowEar.mp3", YellowEarIcon =
				// root
				// + "yellowear.png";
				//
				// addItem(asset, dog, "BeagleDog.mp3", dogIcon,
				// "beagledog.png",
				// "BeagleDog");
				// addItem(asset, colorCrown, "ColorCrown.mp3", colorCrownIcon,
				// "colorcrown.png", "ColorCrown");
				// addItem(asset, tiara, "tiara.mp3", tiaraIcon, "tiara.png",
				// "tiara");
				// addItem(asset, yellowEar, "YellowEar.mp3", YellowEarIcon,
				// "yellowear.png", "YellowEar");
				// 方式二:加载网络资源
				config.enableNetFaceu(true);// 如果要启用网络化加载贴纸的方式
				config.setUrl(url);// 设置网络化的人脸贴纸数据接口

				return null;
			}

			@Override
			protected void onPostExecute(Integer result) {
				XpksdkService service = XpkSdk.getXpksdkService();
				if (null != service) {
					service.initFaceuConfig(config);
				}
			};
		}.execute();

	}

	/**
	 * 新增
	 * 
	 * @param asset
	 * @param path
	 * @param assMp3
	 * @param Icon
	 * @param assIcon
	 * @param title
	 */
	@SuppressWarnings("unused")
	private void addItem(AssetManager asset, String path, String assMp3,
			String Icon, String assIcon, String title) {
		if (!new File(path).exists()) {
			SDKUtils.assetRes2File(asset, "faceu/" + assMp3, path);
		}
		if (!new File(Icon).exists()) {
			SDKUtils.assetRes2File(asset, "faceu/" + assIcon, Icon);
		}
		config.addFaceu(path, Icon, title);
	}

}
