package com.rd.xpkuisdk.demo;

import java.io.File;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Environment;

import com.rd.xpkuisdk.XpkSdk;
import com.rd.xpkuisdk.XpksdkService;
import com.rd.xpkuisdk.manager.FaceUnityConfig;

/**
 * 导入FaceUnity资源
 * 
 * @author JIAN
 * @date 2017-3-18 上午11:36:37
 */
public class FaceHandler {

	private Context context;
	private final String root = Environment.getExternalStorageDirectory()
			+ "/xpk/";

	private FaceUnityConfig config = null;

	public FaceHandler(Context _context) {
		context = _context;
		final String dog = root + "BeagleDog.mp3", dogIcon = root
				+ "beagledog.png";
		final String colorCrown = root + "ColorCrown.mp3", colorCrownIcon = root
				+ "colorcrown.png";
		final String deer = root + "Deer.mp3", deerIcon = root + "deer.png";
		final String happy = root + "HappyRabbi.mp3", happyIcon = root
				+ "happyrabbi.png";
		final String hartshorn = root + "hartshorn.mp3", hartShornIcon = root
				+ "hartshorn.png";
		final String item0204 = root + "item0204.mp3", item0204Icon = root
				+ "item0204.png";
		final String item0208 = root + "item0208.mp3", item0208Icon = root
				+ "item0208.png";
		final String item0210 = root + "item0210.mp3", item0210Icon = root
				+ "item0210.png";
		final String item0501 = root + "item0501.mp3", item0501Icon = root
				+ "item0501.png";
		final String mood = root + "Mood.mp3", moodIcon = root + "mood.png";
		final String princessCrown = root + "PrincessCrown.mp3", PrincessCrownIcon = root
				+ "princesscrown.png";
		final String tiara = root + "tiara.mp3", tiaraIcon = root + "tiara.png";
		final String yellowEar = root + "YellowEar.mp3", YellowEarIcon = root
				+ "yellowear.png";

		new AsyncTask<Integer, Integer, Integer>() {
			// private ProgressDialog m_dlgProgress;

			AssetManager asset;

			@Override
			protected void onPreExecute() {
				// m_dlgProgress = ProgressDialog.show(SimpleActivity.this,
				// null, "导出测试资源...");
				asset = context.getAssets();

				File f = new File(root);

				if (!f.exists()) {
					f.mkdirs();
				}

			};

			@Override
			protected Integer doInBackground(Integer... params) {

				config = new FaceUnityConfig();
				String v3 = root + "v3.mp3";
				SimpleActivity.assetRes2File(asset, "v3.mp3", v3);
				config.setV3Path(v3);// 必须设置,否则无法初始化FaceUnity

				String beauty = root + "face_beautification.mp3";
				SimpleActivity.assetRes2File(asset, "face_beautification.mp3",
						beauty);
				config.setBeautyPath(beauty);// 必须设置,否则无法设置美颜

				addItem(asset, dog, "BeagleDog.mp3", dogIcon, "beagledog.png",
						"BeagleDog");
				addItem(asset, colorCrown, "ColorCrown.mp3", colorCrownIcon,
						"colorcrown.png", "ColorCrown");
				addItem(asset, deer, "Deer.mp3", deerIcon, "deer.png", "Deer");
				addItem(asset, happy, "HappyRabbi.mp3", happyIcon,
						"happyrabbi.png", "HappyRabbi");
				addItem(asset, hartshorn, "hartshorn.mp3", hartShornIcon,
						"hartshorn.png", "hartshorn");
				addItem(asset, item0204, "item0204.mp3", item0204Icon,
						"item0204.png", "item0204");
				addItem(asset, item0208, "item0208.mp3", item0208Icon,
						"item0208.png", "item0208");
				addItem(asset, item0210, "item0210.mp3", item0210Icon,
						"item0210.png", "item0210");
				addItem(asset, item0501, "item0501.mp3", item0501Icon,
						"item0501.png", "item0501");
				addItem(asset, mood, "Mood.mp3", moodIcon, "mood.png", "Mood");
				addItem(asset, princessCrown, "PrincessCrown.mp3",
						PrincessCrownIcon, "princesscrown.png", "PrincessCrown");
				addItem(asset, tiara, "tiara.mp3", tiaraIcon, "tiara.png",
						"tiara");
				addItem(asset, yellowEar, "YellowEar.mp3", YellowEarIcon,
						"yellowear.png", "YellowEar");

				return null;
			}

			@Override
			protected void onPostExecute(Integer result) {
				XpksdkService service = XpkSdk.getXpksdkService();
				if (null != service) {
					service.initFaceUnityConfig(config);
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
	private void addItem(AssetManager asset, String path, String assMp3,
			String Icon, String assIcon, String title) {
		if (!new File(path).exists()) {
			SimpleActivity.assetRes2File(asset, assMp3, path);
		}
		if (!new File(Icon).exists()) {
			SimpleActivity.assetRes2File(asset, assIcon, Icon);
		}
		config.addFaceUnity(path, Icon, title);
	}

}
