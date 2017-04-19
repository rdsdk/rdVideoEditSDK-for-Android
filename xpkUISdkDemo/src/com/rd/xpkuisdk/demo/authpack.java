package com.rd.xpkuisdk.demo;

import java.security.MessageDigest;

public class authpack {
	public static int sha1_32(byte[] buf) {
		int ret = 0;
		try {
			byte[] digest = MessageDigest.getInstance("SHA1").digest(buf);
			return ((int) (digest[0] & 0xff) << 24)
					+ ((int) (digest[1] & 0xff) << 16)
					+ ((int) (digest[2] & 0xff) << 8)
					+ ((int) (digest[3] & 0xff) << 0);
		} catch (Exception e) {
		}
		return ret;
	}

	public static byte[] A() {
		byte[] buf = new byte[1139];
		int i = 0;
		for (i = -125; i < -119; i++) {
			buf[0] = (byte) i;
			if (sha1_32(buf) == -1865180591) {
				break;
			}
		}
		for (i = 103; i < 119; i++) {
			buf[1] = (byte) i;
			if (sha1_32(buf) == 158846183) {
				break;
			}
		}
		for (i = -78; i < -55; i++) {
			buf[2] = (byte) i;
			if (sha1_32(buf) == 2104013352) {
				break;
			}
		}
		for (i = -128; i < -117; i++) {
			buf[3] = (byte) i;
			if (sha1_32(buf) == 1100192532) {
				break;
			}
		}
		for (i = -85; i < -59; i++) {
			buf[4] = (byte) i;
			if (sha1_32(buf) == 1420488895) {
				break;
			}
		}
		for (i = -66; i < -53; i++) {
			buf[5] = (byte) i;
			if (sha1_32(buf) == -839410929) {
				break;
			}
		}
		for (i = 48; i < 75; i++) {
			buf[6] = (byte) i;
			if (sha1_32(buf) == -1846566790) {
				break;
			}
		}
		for (i = -8; i < 2; i++) {
			buf[7] = (byte) i;
			if (sha1_32(buf) == -1846566790) {
				break;
			}
		}
		for (i = -75; i < -48; i++) {
			buf[8] = (byte) i;
			if (sha1_32(buf) == -229994126) {
				break;
			}
		}
		for (i = 27; i < 52; i++) {
			buf[9] = (byte) i;
			if (sha1_32(buf) == 101850508) {
				break;
			}
		}
		for (i = 20; i < 36; i++) {
			buf[10] = (byte) i;
			if (sha1_32(buf) == -1921392001) {
				break;
			}
		}
		for (i = -44; i < -35; i++) {
			buf[11] = (byte) i;
			if (sha1_32(buf) == -1104671605) {
				break;
			}
		}
		for (i = -37; i < -18; i++) {
			buf[12] = (byte) i;
			if (sha1_32(buf) == -2008150432) {
				break;
			}
		}
		for (i = -80; i < -54; i++) {
			buf[13] = (byte) i;
			if (sha1_32(buf) == -1280214184) {
				break;
			}
		}
		for (i = 47; i < 63; i++) {
			buf[14] = (byte) i;
			if (sha1_32(buf) == 1624302888) {
				break;
			}
		}
		for (i = 100; i < 125; i++) {
			buf[15] = (byte) i;
			if (sha1_32(buf) == -1761516743) {
				break;
			}
		}
		for (i = -33; i < -22; i++) {
			buf[16] = (byte) i;
			if (sha1_32(buf) == -344912107) {
				break;
			}
		}
		for (i = -103; i < -77; i++) {
			buf[17] = (byte) i;
			if (sha1_32(buf) == 217552405) {
				break;
			}
		}
		for (i = 92; i < 103; i++) {
			buf[18] = (byte) i;
			if (sha1_32(buf) == 2051843116) {
				break;
			}
		}
		for (i = -105; i < -96; i++) {
			buf[19] = (byte) i;
			if (sha1_32(buf) == 1901356149) {
				break;
			}
		}
		for (i = 33; i < 52; i++) {
			buf[20] = (byte) i;
			if (sha1_32(buf) == 1940134839) {
				break;
			}
		}
		for (i = -38; i < -25; i++) {
			buf[21] = (byte) i;
			if (sha1_32(buf) == 691508929) {
				break;
			}
		}
		for (i = -72; i < -48; i++) {
			buf[22] = (byte) i;
			if (sha1_32(buf) == -210568968) {
				break;
			}
		}
		for (i = -54; i < -39; i++) {
			buf[23] = (byte) i;
			if (sha1_32(buf) == -1026033549) {
				break;
			}
		}
		for (i = 93; i < 112; i++) {
			buf[24] = (byte) i;
			if (sha1_32(buf) == -1784455881) {
				break;
			}
		}
		for (i = 31; i < 47; i++) {
			buf[25] = (byte) i;
			if (sha1_32(buf) == 1560503828) {
				break;
			}
		}
		for (i = 74; i < 93; i++) {
			buf[26] = (byte) i;
			if (sha1_32(buf) == -234543967) {
				break;
			}
		}
		for (i = -57; i < -48; i++) {
			buf[27] = (byte) i;
			if (sha1_32(buf) == 1308300189) {
				break;
			}
		}
		for (i = 63; i < 64; i++) {
			buf[28] = (byte) i;
			if (sha1_32(buf) == -986319074) {
				break;
			}
		}
		for (i = -52; i < -25; i++) {
			buf[29] = (byte) i;
			if (sha1_32(buf) == -1725971175) {
				break;
			}
		}
		for (i = -82; i < -63; i++) {
			buf[30] = (byte) i;
			if (sha1_32(buf) == 491976702) {
				break;
			}
		}
		for (i = -120; i < -106; i++) {
			buf[31] = (byte) i;
			if (sha1_32(buf) == 1110069289) {
				break;
			}
		}
		for (i = -32; i < -14; i++) {
			buf[32] = (byte) i;
			if (sha1_32(buf) == -1791575355) {
				break;
			}
		}
		for (i = 125; i < 128; i++) {
			buf[33] = (byte) i;
			if (sha1_32(buf) == -412410350) {
				break;
			}
		}
		for (i = -4; i < 18; i++) {
			buf[34] = (byte) i;
			if (sha1_32(buf) == -1892322868) {
				break;
			}
		}
		for (i = -31; i < -15; i++) {
			buf[35] = (byte) i;
			if (sha1_32(buf) == 1204117283) {
				break;
			}
		}
		for (i = -56; i < -34; i++) {
			buf[36] = (byte) i;
			if (sha1_32(buf) == -460451396) {
				break;
			}
		}
		for (i = 50; i < 70; i++) {
			buf[37] = (byte) i;
			if (sha1_32(buf) == 345245367) {
				break;
			}
		}
		for (i = -17; i < -1; i++) {
			buf[38] = (byte) i;
			if (sha1_32(buf) == 1831906725) {
				break;
			}
		}
		for (i = -43; i < -34; i++) {
			buf[39] = (byte) i;
			if (sha1_32(buf) == -1219832682) {
				break;
			}
		}
		for (i = -75; i < -61; i++) {
			buf[40] = (byte) i;
			if (sha1_32(buf) == -352262179) {
				break;
			}
		}
		for (i = -42; i < -30; i++) {
			buf[41] = (byte) i;
			if (sha1_32(buf) == 977523627) {
				break;
			}
		}
		for (i = 67; i < 78; i++) {
			buf[42] = (byte) i;
			if (sha1_32(buf) == -1328934111) {
				break;
			}
		}
		for (i = 73; i < 91; i++) {
			buf[43] = (byte) i;
			if (sha1_32(buf) == -966482674) {
				break;
			}
		}
		for (i = -107; i < -105; i++) {
			buf[44] = (byte) i;
			if (sha1_32(buf) == 1984668392) {
				break;
			}
		}
		for (i = -79; i < -65; i++) {
			buf[45] = (byte) i;
			if (sha1_32(buf) == 109327710) {
				break;
			}
		}
		for (i = -77; i < -58; i++) {
			buf[46] = (byte) i;
			if (sha1_32(buf) == -788707022) {
				break;
			}
		}
		for (i = 52; i < 63; i++) {
			buf[47] = (byte) i;
			if (sha1_32(buf) == 1513898474) {
				break;
			}
		}
		for (i = 58; i < 78; i++) {
			buf[48] = (byte) i;
			if (sha1_32(buf) == 314087476) {
				break;
			}
		}
		for (i = 77; i < 85; i++) {
			buf[49] = (byte) i;
			if (sha1_32(buf) == -1256060092) {
				break;
			}
		}
		for (i = -40; i < -23; i++) {
			buf[50] = (byte) i;
			if (sha1_32(buf) == 91052409) {
				break;
			}
		}
		for (i = 14; i < 32; i++) {
			buf[51] = (byte) i;
			if (sha1_32(buf) == 710169518) {
				break;
			}
		}
		for (i = 36; i < 42; i++) {
			buf[52] = (byte) i;
			if (sha1_32(buf) == -194528118) {
				break;
			}
		}
		for (i = 82; i < 98; i++) {
			buf[53] = (byte) i;
			if (sha1_32(buf) == 570147664) {
				break;
			}
		}
		for (i = -122; i < -97; i++) {
			buf[54] = (byte) i;
			if (sha1_32(buf) == -1967901272) {
				break;
			}
		}
		for (i = 6; i < 19; i++) {
			buf[55] = (byte) i;
			if (sha1_32(buf) == 1514646167) {
				break;
			}
		}
		for (i = -128; i < -117; i++) {
			buf[56] = (byte) i;
			if (sha1_32(buf) == 2028410523) {
				break;
			}
		}
		for (i = 34; i < 41; i++) {
			buf[57] = (byte) i;
			if (sha1_32(buf) == -1600681103) {
				break;
			}
		}
		for (i = 109; i < 114; i++) {
			buf[58] = (byte) i;
			if (sha1_32(buf) == 700356825) {
				break;
			}
		}
		for (i = -110; i < -104; i++) {
			buf[59] = (byte) i;
			if (sha1_32(buf) == 977555166) {
				break;
			}
		}
		for (i = 38; i < 54; i++) {
			buf[60] = (byte) i;
			if (sha1_32(buf) == -1287721165) {
				break;
			}
		}
		for (i = -66; i < -40; i++) {
			buf[61] = (byte) i;
			if (sha1_32(buf) == 1314736397) {
				break;
			}
		}
		for (i = -75; i < -64; i++) {
			buf[62] = (byte) i;
			if (sha1_32(buf) == -816441145) {
				break;
			}
		}
		for (i = -38; i < -22; i++) {
			buf[63] = (byte) i;
			if (sha1_32(buf) == -1708673940) {
				break;
			}
		}
		for (i = -93; i < -72; i++) {
			buf[64] = (byte) i;
			if (sha1_32(buf) == -1488073082) {
				break;
			}
		}
		for (i = -3; i < 3; i++) {
			buf[65] = (byte) i;
			if (sha1_32(buf) == 53656049) {
				break;
			}
		}
		for (i = 112; i < 128; i++) {
			buf[66] = (byte) i;
			if (sha1_32(buf) == 668062525) {
				break;
			}
		}
		for (i = -128; i < -118; i++) {
			buf[67] = (byte) i;
			if (sha1_32(buf) == -1822891210) {
				break;
			}
		}
		for (i = 113; i < 128; i++) {
			buf[68] = (byte) i;
			if (sha1_32(buf) == -943791374) {
				break;
			}
		}
		for (i = 27; i < 43; i++) {
			buf[69] = (byte) i;
			if (sha1_32(buf) == -651534852) {
				break;
			}
		}
		for (i = 24; i < 36; i++) {
			buf[70] = (byte) i;
			if (sha1_32(buf) == 1262031965) {
				break;
			}
		}
		for (i = 6; i < 15; i++) {
			buf[71] = (byte) i;
			if (sha1_32(buf) == 1789660922) {
				break;
			}
		}
		for (i = -89; i < -70; i++) {
			buf[72] = (byte) i;
			if (sha1_32(buf) == 1572428361) {
				break;
			}
		}
		for (i = 19; i < 44; i++) {
			buf[73] = (byte) i;
			if (sha1_32(buf) == -1609369923) {
				break;
			}
		}
		for (i = 36; i < 59; i++) {
			buf[74] = (byte) i;
			if (sha1_32(buf) == 593416279) {
				break;
			}
		}
		for (i = 50; i < 62; i++) {
			buf[75] = (byte) i;
			if (sha1_32(buf) == -1835939275) {
				break;
			}
		}
		for (i = 90; i < 108; i++) {
			buf[76] = (byte) i;
			if (sha1_32(buf) == 1073315442) {
				break;
			}
		}
		for (i = -64; i < -56; i++) {
			buf[77] = (byte) i;
			if (sha1_32(buf) == 320658952) {
				break;
			}
		}
		for (i = -128; i < -119; i++) {
			buf[78] = (byte) i;
			if (sha1_32(buf) == -1271010207) {
				break;
			}
		}
		for (i = -125; i < -117; i++) {
			buf[79] = (byte) i;
			if (sha1_32(buf) == 2063041729) {
				break;
			}
		}
		for (i = 74; i < 90; i++) {
			buf[80] = (byte) i;
			if (sha1_32(buf) == -1521753754) {
				break;
			}
		}
		for (i = -39; i < -24; i++) {
			buf[81] = (byte) i;
			if (sha1_32(buf) == 2003149212) {
				break;
			}
		}
		for (i = -12; i < 9; i++) {
			buf[82] = (byte) i;
			if (sha1_32(buf) == 2003149212) {
				break;
			}
		}
		for (i = 113; i < 128; i++) {
			buf[83] = (byte) i;
			if (sha1_32(buf) == 214971673) {
				break;
			}
		}
		for (i = 21; i < 35; i++) {
			buf[84] = (byte) i;
			if (sha1_32(buf) == -494774672) {
				break;
			}
		}
		for (i = -38; i < -26; i++) {
			buf[85] = (byte) i;
			if (sha1_32(buf) == 1856041950) {
				break;
			}
		}
		for (i = 56; i < 68; i++) {
			buf[86] = (byte) i;
			if (sha1_32(buf) == -1959707810) {
				break;
			}
		}
		for (i = -115; i < -96; i++) {
			buf[87] = (byte) i;
			if (sha1_32(buf) == -1372933653) {
				break;
			}
		}
		for (i = 98; i < 119; i++) {
			buf[88] = (byte) i;
			if (sha1_32(buf) == 1962374048) {
				break;
			}
		}
		for (i = -19; i < 9; i++) {
			buf[89] = (byte) i;
			if (sha1_32(buf) == 1918125050) {
				break;
			}
		}
		for (i = -63; i < -50; i++) {
			buf[90] = (byte) i;
			if (sha1_32(buf) == 1340260819) {
				break;
			}
		}
		for (i = 100; i < 111; i++) {
			buf[91] = (byte) i;
			if (sha1_32(buf) == 379573469) {
				break;
			}
		}
		for (i = -109; i < -90; i++) {
			buf[92] = (byte) i;
			if (sha1_32(buf) == 1704132479) {
				break;
			}
		}
		for (i = 0; i < 7; i++) {
			buf[93] = (byte) i;
			if (sha1_32(buf) == 1438741657) {
				break;
			}
		}
		for (i = 74; i < 89; i++) {
			buf[94] = (byte) i;
			if (sha1_32(buf) == 814873528) {
				break;
			}
		}
		for (i = -97; i < -87; i++) {
			buf[95] = (byte) i;
			if (sha1_32(buf) == 1098435649) {
				break;
			}
		}
		for (i = -69; i < -47; i++) {
			buf[96] = (byte) i;
			if (sha1_32(buf) == -298164156) {
				break;
			}
		}
		for (i = -47; i < -33; i++) {
			buf[97] = (byte) i;
			if (sha1_32(buf) == -2032405500) {
				break;
			}
		}
		for (i = 36; i < 54; i++) {
			buf[98] = (byte) i;
			if (sha1_32(buf) == -768780839) {
				break;
			}
		}
		for (i = -7; i < 8; i++) {
			buf[99] = (byte) i;
			if (sha1_32(buf) == -768780839) {
				break;
			}
		}
		for (i = -16; i < 2; i++) {
			buf[100] = (byte) i;
			if (sha1_32(buf) == -773077298) {
				break;
			}
		}
		for (i = -25; i < -16; i++) {
			buf[101] = (byte) i;
			if (sha1_32(buf) == 610163573) {
				break;
			}
		}
		for (i = 115; i < 128; i++) {
			buf[102] = (byte) i;
			if (sha1_32(buf) == 1103029895) {
				break;
			}
		}
		for (i = 103; i < 119; i++) {
			buf[103] = (byte) i;
			if (sha1_32(buf) == 2019796122) {
				break;
			}
		}
		for (i = -90; i < -77; i++) {
			buf[104] = (byte) i;
			if (sha1_32(buf) == 607647156) {
				break;
			}
		}
		for (i = -62; i < -45; i++) {
			buf[105] = (byte) i;
			if (sha1_32(buf) == -1301961503) {
				break;
			}
		}
		for (i = 74; i < 92; i++) {
			buf[106] = (byte) i;
			if (sha1_32(buf) == -1706568052) {
				break;
			}
		}
		for (i = -92; i < -74; i++) {
			buf[107] = (byte) i;
			if (sha1_32(buf) == 1990197403) {
				break;
			}
		}
		for (i = -60; i < -53; i++) {
			buf[108] = (byte) i;
			if (sha1_32(buf) == -1726623136) {
				break;
			}
		}
		for (i = 18; i < 42; i++) {
			buf[109] = (byte) i;
			if (sha1_32(buf) == -1792162492) {
				break;
			}
		}
		for (i = -117; i < -98; i++) {
			buf[110] = (byte) i;
			if (sha1_32(buf) == -161417241) {
				break;
			}
		}
		for (i = 109; i < 128; i++) {
			buf[111] = (byte) i;
			if (sha1_32(buf) == 945531095) {
				break;
			}
		}
		for (i = 14; i < 37; i++) {
			buf[112] = (byte) i;
			if (sha1_32(buf) == -777263843) {
				break;
			}
		}
		for (i = -123; i < -117; i++) {
			buf[113] = (byte) i;
			if (sha1_32(buf) == -1831194448) {
				break;
			}
		}
		for (i = 81; i < 100; i++) {
			buf[114] = (byte) i;
			if (sha1_32(buf) == -1671007164) {
				break;
			}
		}
		for (i = -85; i < -61; i++) {
			buf[115] = (byte) i;
			if (sha1_32(buf) == -1049899208) {
				break;
			}
		}
		for (i = 40; i < 57; i++) {
			buf[116] = (byte) i;
			if (sha1_32(buf) == -795884523) {
				break;
			}
		}
		for (i = -8; i < 21; i++) {
			buf[117] = (byte) i;
			if (sha1_32(buf) == -1762561637) {
				break;
			}
		}
		for (i = 75; i < 106; i++) {
			buf[118] = (byte) i;
			if (sha1_32(buf) == -1072026264) {
				break;
			}
		}
		for (i = 86; i < 110; i++) {
			buf[119] = (byte) i;
			if (sha1_32(buf) == -291029660) {
				break;
			}
		}
		for (i = -99; i < -86; i++) {
			buf[120] = (byte) i;
			if (sha1_32(buf) == 217388137) {
				break;
			}
		}
		for (i = 77; i < 86; i++) {
			buf[121] = (byte) i;
			if (sha1_32(buf) == -2071347914) {
				break;
			}
		}
		for (i = -70; i < -42; i++) {
			buf[122] = (byte) i;
			if (sha1_32(buf) == -1760111902) {
				break;
			}
		}
		for (i = -5; i < 15; i++) {
			buf[123] = (byte) i;
			if (sha1_32(buf) == -273588183) {
				break;
			}
		}
		for (i = -44; i < -28; i++) {
			buf[124] = (byte) i;
			if (sha1_32(buf) == 2109084052) {
				break;
			}
		}
		for (i = 105; i < 125; i++) {
			buf[125] = (byte) i;
			if (sha1_32(buf) == -1475332465) {
				break;
			}
		}
		for (i = -50; i < -33; i++) {
			buf[126] = (byte) i;
			if (sha1_32(buf) == 1886130027) {
				break;
			}
		}
		for (i = -110; i < -94; i++) {
			buf[127] = (byte) i;
			if (sha1_32(buf) == -468132663) {
				break;
			}
		}
		for (i = -20; i < -4; i++) {
			buf[128] = (byte) i;
			if (sha1_32(buf) == 1395877280) {
				break;
			}
		}
		for (i = 48; i < 61; i++) {
			buf[129] = (byte) i;
			if (sha1_32(buf) == -1951048305) {
				break;
			}
		}
		for (i = -11; i < 11; i++) {
			buf[130] = (byte) i;
			if (sha1_32(buf) == -1951048305) {
				break;
			}
		}
		for (i = 42; i < 54; i++) {
			buf[131] = (byte) i;
			if (sha1_32(buf) == -1612878784) {
				break;
			}
		}
		for (i = -82; i < -65; i++) {
			buf[132] = (byte) i;
			if (sha1_32(buf) == -1675588104) {
				break;
			}
		}
		for (i = 10; i < 25; i++) {
			buf[133] = (byte) i;
			if (sha1_32(buf) == -105377574) {
				break;
			}
		}
		for (i = -95; i < -74; i++) {
			buf[134] = (byte) i;
			if (sha1_32(buf) == 1635463891) {
				break;
			}
		}
		for (i = 59; i < 69; i++) {
			buf[135] = (byte) i;
			if (sha1_32(buf) == 43307734) {
				break;
			}
		}
		for (i = 99; i < 128; i++) {
			buf[136] = (byte) i;
			if (sha1_32(buf) == -2063381175) {
				break;
			}
		}
		for (i = 76; i < 94; i++) {
			buf[137] = (byte) i;
			if (sha1_32(buf) == -1562029057) {
				break;
			}
		}
		for (i = 49; i < 56; i++) {
			buf[138] = (byte) i;
			if (sha1_32(buf) == -1305816530) {
				break;
			}
		}
		for (i = 12; i < 30; i++) {
			buf[139] = (byte) i;
			if (sha1_32(buf) == -1242606213) {
				break;
			}
		}
		for (i = -124; i < -95; i++) {
			buf[140] = (byte) i;
			if (sha1_32(buf) == 2147277256) {
				break;
			}
		}
		for (i = 40; i < 56; i++) {
			buf[141] = (byte) i;
			if (sha1_32(buf) == 1790844748) {
				break;
			}
		}
		for (i = 82; i < 89; i++) {
			buf[142] = (byte) i;
			if (sha1_32(buf) == 1597266710) {
				break;
			}
		}
		for (i = 67; i < 84; i++) {
			buf[143] = (byte) i;
			if (sha1_32(buf) == -2043113408) {
				break;
			}
		}
		for (i = 25; i < 39; i++) {
			buf[144] = (byte) i;
			if (sha1_32(buf) == -2073097953) {
				break;
			}
		}
		for (i = 64; i < 82; i++) {
			buf[145] = (byte) i;
			if (sha1_32(buf) == -1151187958) {
				break;
			}
		}
		for (i = 119; i < 128; i++) {
			buf[146] = (byte) i;
			if (sha1_32(buf) == -1982502779) {
				break;
			}
		}
		for (i = 25; i < 44; i++) {
			buf[147] = (byte) i;
			if (sha1_32(buf) == -881053201) {
				break;
			}
		}
		for (i = 90; i < 101; i++) {
			buf[148] = (byte) i;
			if (sha1_32(buf) == 1324076735) {
				break;
			}
		}
		for (i = -106; i < -86; i++) {
			buf[149] = (byte) i;
			if (sha1_32(buf) == -1657414574) {
				break;
			}
		}
		for (i = 15; i < 33; i++) {
			buf[150] = (byte) i;
			if (sha1_32(buf) == 1426109270) {
				break;
			}
		}
		for (i = 50; i < 60; i++) {
			buf[151] = (byte) i;
			if (sha1_32(buf) == 1731316192) {
				break;
			}
		}
		for (i = 98; i < 128; i++) {
			buf[152] = (byte) i;
			if (sha1_32(buf) == 296957518) {
				break;
			}
		}
		for (i = 73; i < 92; i++) {
			buf[153] = (byte) i;
			if (sha1_32(buf) == -1080018528) {
				break;
			}
		}
		for (i = 65; i < 86; i++) {
			buf[154] = (byte) i;
			if (sha1_32(buf) == 786224059) {
				break;
			}
		}
		for (i = 59; i < 76; i++) {
			buf[155] = (byte) i;
			if (sha1_32(buf) == 516243737) {
				break;
			}
		}
		for (i = -122; i < -108; i++) {
			buf[156] = (byte) i;
			if (sha1_32(buf) == -436168043) {
				break;
			}
		}
		for (i = 105; i < 128; i++) {
			buf[157] = (byte) i;
			if (sha1_32(buf) == 2117923054) {
				break;
			}
		}
		for (i = 52; i < 69; i++) {
			buf[158] = (byte) i;
			if (sha1_32(buf) == 2120756166) {
				break;
			}
		}
		for (i = -62; i < -50; i++) {
			buf[159] = (byte) i;
			if (sha1_32(buf) == -1532499260) {
				break;
			}
		}
		for (i = -40; i < -27; i++) {
			buf[160] = (byte) i;
			if (sha1_32(buf) == 1569445456) {
				break;
			}
		}
		for (i = 98; i < 103; i++) {
			buf[161] = (byte) i;
			if (sha1_32(buf) == -1123793408) {
				break;
			}
		}
		for (i = 119; i < 128; i++) {
			buf[162] = (byte) i;
			if (sha1_32(buf) == -287511701) {
				break;
			}
		}
		for (i = 50; i < 73; i++) {
			buf[163] = (byte) i;
			if (sha1_32(buf) == -537524079) {
				break;
			}
		}
		for (i = 9; i < 24; i++) {
			buf[164] = (byte) i;
			if (sha1_32(buf) == 1737052335) {
				break;
			}
		}
		for (i = -128; i < -103; i++) {
			buf[165] = (byte) i;
			if (sha1_32(buf) == -2141812385) {
				break;
			}
		}
		for (i = 65; i < 81; i++) {
			buf[166] = (byte) i;
			if (sha1_32(buf) == -18202269) {
				break;
			}
		}
		for (i = -30; i < -22; i++) {
			buf[167] = (byte) i;
			if (sha1_32(buf) == -1837987339) {
				break;
			}
		}
		for (i = 51; i < 78; i++) {
			buf[168] = (byte) i;
			if (sha1_32(buf) == -902338623) {
				break;
			}
		}
		for (i = 83; i < 97; i++) {
			buf[169] = (byte) i;
			if (sha1_32(buf) == 1667884573) {
				break;
			}
		}
		for (i = 0; i < 21; i++) {
			buf[170] = (byte) i;
			if (sha1_32(buf) == 464888164) {
				break;
			}
		}
		for (i = 72; i < 89; i++) {
			buf[171] = (byte) i;
			if (sha1_32(buf) == -210721612) {
				break;
			}
		}
		for (i = -73; i < -51; i++) {
			buf[172] = (byte) i;
			if (sha1_32(buf) == 1135447599) {
				break;
			}
		}
		for (i = -36; i < -25; i++) {
			buf[173] = (byte) i;
			if (sha1_32(buf) == 651231200) {
				break;
			}
		}
		for (i = 26; i < 46; i++) {
			buf[174] = (byte) i;
			if (sha1_32(buf) == 1324935334) {
				break;
			}
		}
		for (i = 112; i < 126; i++) {
			buf[175] = (byte) i;
			if (sha1_32(buf) == 1319149769) {
				break;
			}
		}
		for (i = -103; i < -96; i++) {
			buf[176] = (byte) i;
			if (sha1_32(buf) == 957341178) {
				break;
			}
		}
		for (i = -9; i < 0; i++) {
			buf[177] = (byte) i;
			if (sha1_32(buf) == -752808215) {
				break;
			}
		}
		for (i = -50; i < -43; i++) {
			buf[178] = (byte) i;
			if (sha1_32(buf) == -248683805) {
				break;
			}
		}
		for (i = -98; i < -72; i++) {
			buf[179] = (byte) i;
			if (sha1_32(buf) == -1936771097) {
				break;
			}
		}
		for (i = -4; i < 21; i++) {
			buf[180] = (byte) i;
			if (sha1_32(buf) == -1464025722) {
				break;
			}
		}
		for (i = -34; i < -16; i++) {
			buf[181] = (byte) i;
			if (sha1_32(buf) == -2030580979) {
				break;
			}
		}
		for (i = 102; i < 125; i++) {
			buf[182] = (byte) i;
			if (sha1_32(buf) == -95049697) {
				break;
			}
		}
		for (i = 40; i < 61; i++) {
			buf[183] = (byte) i;
			if (sha1_32(buf) == -861650980) {
				break;
			}
		}
		for (i = 95; i < 107; i++) {
			buf[184] = (byte) i;
			if (sha1_32(buf) == 1146270419) {
				break;
			}
		}
		for (i = -45; i < -27; i++) {
			buf[185] = (byte) i;
			if (sha1_32(buf) == -843857846) {
				break;
			}
		}
		for (i = 20; i < 32; i++) {
			buf[186] = (byte) i;
			if (sha1_32(buf) == -223279269) {
				break;
			}
		}
		for (i = -120; i < -104; i++) {
			buf[187] = (byte) i;
			if (sha1_32(buf) == -7002049) {
				break;
			}
		}
		for (i = -83; i < -69; i++) {
			buf[188] = (byte) i;
			if (sha1_32(buf) == 927602438) {
				break;
			}
		}
		for (i = -81; i < -64; i++) {
			buf[189] = (byte) i;
			if (sha1_32(buf) == 744697446) {
				break;
			}
		}
		for (i = -9; i < 12; i++) {
			buf[190] = (byte) i;
			if (sha1_32(buf) == 744697446) {
				break;
			}
		}
		for (i = -117; i < -90; i++) {
			buf[191] = (byte) i;
			if (sha1_32(buf) == -1771819823) {
				break;
			}
		}
		for (i = 64; i < 78; i++) {
			buf[192] = (byte) i;
			if (sha1_32(buf) == 974245175) {
				break;
			}
		}
		for (i = 96; i < 108; i++) {
			buf[193] = (byte) i;
			if (sha1_32(buf) == 1746506050) {
				break;
			}
		}
		for (i = -13; i < -3; i++) {
			buf[194] = (byte) i;
			if (sha1_32(buf) == 411600297) {
				break;
			}
		}
		for (i = -116; i < -89; i++) {
			buf[195] = (byte) i;
			if (sha1_32(buf) == -1348220542) {
				break;
			}
		}
		for (i = 40; i < 57; i++) {
			buf[196] = (byte) i;
			if (sha1_32(buf) == -1307141991) {
				break;
			}
		}
		for (i = 20; i < 38; i++) {
			buf[197] = (byte) i;
			if (sha1_32(buf) == 904749289) {
				break;
			}
		}
		for (i = 26; i < 36; i++) {
			buf[198] = (byte) i;
			if (sha1_32(buf) == 1621253639) {
				break;
			}
		}
		for (i = -99; i < -78; i++) {
			buf[199] = (byte) i;
			if (sha1_32(buf) == 1177603199) {
				break;
			}
		}
		for (i = -93; i < -82; i++) {
			buf[200] = (byte) i;
			if (sha1_32(buf) == 1605376735) {
				break;
			}
		}
		for (i = -106; i < -89; i++) {
			buf[201] = (byte) i;
			if (sha1_32(buf) == 1036992879) {
				break;
			}
		}
		for (i = -115; i < -89; i++) {
			buf[202] = (byte) i;
			if (sha1_32(buf) == 1148625284) {
				break;
			}
		}
		for (i = -42; i < -32; i++) {
			buf[203] = (byte) i;
			if (sha1_32(buf) == 951257683) {
				break;
			}
		}
		for (i = 61; i < 69; i++) {
			buf[204] = (byte) i;
			if (sha1_32(buf) == -1770545505) {
				break;
			}
		}
		for (i = -122; i < -115; i++) {
			buf[205] = (byte) i;
			if (sha1_32(buf) == -580819414) {
				break;
			}
		}
		for (i = 28; i < 36; i++) {
			buf[206] = (byte) i;
			if (sha1_32(buf) == 1828296467) {
				break;
			}
		}
		for (i = -73; i < -50; i++) {
			buf[207] = (byte) i;
			if (sha1_32(buf) == 913651232) {
				break;
			}
		}
		for (i = 12; i < 32; i++) {
			buf[208] = (byte) i;
			if (sha1_32(buf) == -880252904) {
				break;
			}
		}
		for (i = 124; i < 128; i++) {
			buf[209] = (byte) i;
			if (sha1_32(buf) == 1581575705) {
				break;
			}
		}
		for (i = 105; i < 123; i++) {
			buf[210] = (byte) i;
			if (sha1_32(buf) == -1755621000) {
				break;
			}
		}
		for (i = -128; i < -123; i++) {
			buf[211] = (byte) i;
			if (sha1_32(buf) == 188207922) {
				break;
			}
		}
		for (i = -80; i < -64; i++) {
			buf[212] = (byte) i;
			if (sha1_32(buf) == -2083453371) {
				break;
			}
		}
		for (i = 89; i < 100; i++) {
			buf[213] = (byte) i;
			if (sha1_32(buf) == -1299372513) {
				break;
			}
		}
		for (i = -101; i < -91; i++) {
			buf[214] = (byte) i;
			if (sha1_32(buf) == -1047398693) {
				break;
			}
		}
		for (i = -123; i < -104; i++) {
			buf[215] = (byte) i;
			if (sha1_32(buf) == 1007614131) {
				break;
			}
		}
		for (i = -113; i < -90; i++) {
			buf[216] = (byte) i;
			if (sha1_32(buf) == 494321593) {
				break;
			}
		}
		for (i = 27; i < 54; i++) {
			buf[217] = (byte) i;
			if (sha1_32(buf) == 869167503) {
				break;
			}
		}
		for (i = 79; i < 93; i++) {
			buf[218] = (byte) i;
			if (sha1_32(buf) == 835003500) {
				break;
			}
		}
		for (i = -3; i < 20; i++) {
			buf[219] = (byte) i;
			if (sha1_32(buf) == -1848458456) {
				break;
			}
		}
		for (i = 10; i < 20; i++) {
			buf[220] = (byte) i;
			if (sha1_32(buf) == -1204659636) {
				break;
			}
		}
		for (i = -37; i < -23; i++) {
			buf[221] = (byte) i;
			if (sha1_32(buf) == 1601282799) {
				break;
			}
		}
		for (i = 54; i < 64; i++) {
			buf[222] = (byte) i;
			if (sha1_32(buf) == -2024989900) {
				break;
			}
		}
		for (i = -66; i < -55; i++) {
			buf[223] = (byte) i;
			if (sha1_32(buf) == 1779795033) {
				break;
			}
		}
		for (i = 53; i < 77; i++) {
			buf[224] = (byte) i;
			if (sha1_32(buf) == -688554721) {
				break;
			}
		}
		for (i = 37; i < 65; i++) {
			buf[225] = (byte) i;
			if (sha1_32(buf) == -1546138699) {
				break;
			}
		}
		for (i = 53; i < 72; i++) {
			buf[226] = (byte) i;
			if (sha1_32(buf) == -833593305) {
				break;
			}
		}
		for (i = -65; i < -53; i++) {
			buf[227] = (byte) i;
			if (sha1_32(buf) == -611335714) {
				break;
			}
		}
		for (i = -88; i < -74; i++) {
			buf[228] = (byte) i;
			if (sha1_32(buf) == 1050080854) {
				break;
			}
		}
		for (i = -71; i < -57; i++) {
			buf[229] = (byte) i;
			if (sha1_32(buf) == 1222070430) {
				break;
			}
		}
		for (i = -24; i < -16; i++) {
			buf[230] = (byte) i;
			if (sha1_32(buf) == -1902670144) {
				break;
			}
		}
		for (i = -84; i < -55; i++) {
			buf[231] = (byte) i;
			if (sha1_32(buf) == 23398793) {
				break;
			}
		}
		for (i = -26; i < -7; i++) {
			buf[232] = (byte) i;
			if (sha1_32(buf) == -960391508) {
				break;
			}
		}
		for (i = 72; i < 85; i++) {
			buf[233] = (byte) i;
			if (sha1_32(buf) == 914638023) {
				break;
			}
		}
		for (i = -115; i < -100; i++) {
			buf[234] = (byte) i;
			if (sha1_32(buf) == 1641394697) {
				break;
			}
		}
		for (i = -87; i < -74; i++) {
			buf[235] = (byte) i;
			if (sha1_32(buf) == -1254012346) {
				break;
			}
		}
		for (i = -128; i < -112; i++) {
			buf[236] = (byte) i;
			if (sha1_32(buf) == -526538114) {
				break;
			}
		}
		for (i = 78; i < 98; i++) {
			buf[237] = (byte) i;
			if (sha1_32(buf) == 650622724) {
				break;
			}
		}
		for (i = 19; i < 25; i++) {
			buf[238] = (byte) i;
			if (sha1_32(buf) == 1503993216) {
				break;
			}
		}
		for (i = -109; i < -101; i++) {
			buf[239] = (byte) i;
			if (sha1_32(buf) == 2047306628) {
				break;
			}
		}
		for (i = 45; i < 74; i++) {
			buf[240] = (byte) i;
			if (sha1_32(buf) == 1309259491) {
				break;
			}
		}
		for (i = 13; i < 39; i++) {
			buf[241] = (byte) i;
			if (sha1_32(buf) == 96005399) {
				break;
			}
		}
		for (i = -124; i < -112; i++) {
			buf[242] = (byte) i;
			if (sha1_32(buf) == -1728435856) {
				break;
			}
		}
		for (i = -125; i < -109; i++) {
			buf[243] = (byte) i;
			if (sha1_32(buf) == -1779893744) {
				break;
			}
		}
		for (i = 7; i < 21; i++) {
			buf[244] = (byte) i;
			if (sha1_32(buf) == -97343206) {
				break;
			}
		}
		for (i = -126; i < -103; i++) {
			buf[245] = (byte) i;
			if (sha1_32(buf) == 1700665377) {
				break;
			}
		}
		for (i = 121; i < 128; i++) {
			buf[246] = (byte) i;
			if (sha1_32(buf) == -1304524989) {
				break;
			}
		}
		for (i = -10; i < 7; i++) {
			buf[247] = (byte) i;
			if (sha1_32(buf) == -2031347899) {
				break;
			}
		}
		for (i = 118; i < 126; i++) {
			buf[248] = (byte) i;
			if (sha1_32(buf) == 1958675709) {
				break;
			}
		}
		for (i = -94; i < -79; i++) {
			buf[249] = (byte) i;
			if (sha1_32(buf) == -1742134538) {
				break;
			}
		}
		for (i = -106; i < -90; i++) {
			buf[250] = (byte) i;
			if (sha1_32(buf) == 134399946) {
				break;
			}
		}
		for (i = -65; i < -57; i++) {
			buf[251] = (byte) i;
			if (sha1_32(buf) == -187055925) {
				break;
			}
		}
		for (i = -56; i < -42; i++) {
			buf[252] = (byte) i;
			if (sha1_32(buf) == 1199409323) {
				break;
			}
		}
		for (i = 102; i < 105; i++) {
			buf[253] = (byte) i;
			if (sha1_32(buf) == 1471044276) {
				break;
			}
		}
		for (i = 36; i < 52; i++) {
			buf[254] = (byte) i;
			if (sha1_32(buf) == -609148843) {
				break;
			}
		}
		for (i = -94; i < -82; i++) {
			buf[255] = (byte) i;
			if (sha1_32(buf) == -143853134) {
				break;
			}
		}
		for (i = 66; i < 87; i++) {
			buf[256] = (byte) i;
			if (sha1_32(buf) == 620600536) {
				break;
			}
		}
		for (i = 97; i < 116; i++) {
			buf[257] = (byte) i;
			if (sha1_32(buf) == -1739392185) {
				break;
			}
		}
		for (i = 66; i < 69; i++) {
			buf[258] = (byte) i;
			if (sha1_32(buf) == 260311760) {
				break;
			}
		}
		for (i = 113; i < 128; i++) {
			buf[259] = (byte) i;
			if (sha1_32(buf) == 1426626487) {
				break;
			}
		}
		for (i = 86; i < 103; i++) {
			buf[260] = (byte) i;
			if (sha1_32(buf) == 1291228645) {
				break;
			}
		}
		for (i = -75; i < -57; i++) {
			buf[261] = (byte) i;
			if (sha1_32(buf) == -1455333876) {
				break;
			}
		}
		for (i = 54; i < 81; i++) {
			buf[262] = (byte) i;
			if (sha1_32(buf) == 2094897728) {
				break;
			}
		}
		for (i = -128; i < -111; i++) {
			buf[263] = (byte) i;
			if (sha1_32(buf) == -855452205) {
				break;
			}
		}
		for (i = -47; i < -23; i++) {
			buf[264] = (byte) i;
			if (sha1_32(buf) == -529923120) {
				break;
			}
		}
		for (i = 6; i < 19; i++) {
			buf[265] = (byte) i;
			if (sha1_32(buf) == -1826728102) {
				break;
			}
		}
		for (i = -9; i < -8; i++) {
			buf[266] = (byte) i;
			if (sha1_32(buf) == 1186561284) {
				break;
			}
		}
		for (i = -80; i < -68; i++) {
			buf[267] = (byte) i;
			if (sha1_32(buf) == 1863143156) {
				break;
			}
		}
		for (i = 98; i < 113; i++) {
			buf[268] = (byte) i;
			if (sha1_32(buf) == 1200204421) {
				break;
			}
		}
		for (i = 46; i < 70; i++) {
			buf[269] = (byte) i;
			if (sha1_32(buf) == 1321504864) {
				break;
			}
		}
		for (i = -24; i < -14; i++) {
			buf[270] = (byte) i;
			if (sha1_32(buf) == -441565972) {
				break;
			}
		}
		for (i = 89; i < 103; i++) {
			buf[271] = (byte) i;
			if (sha1_32(buf) == 1228885525) {
				break;
			}
		}
		for (i = -123; i < -106; i++) {
			buf[272] = (byte) i;
			if (sha1_32(buf) == 509074687) {
				break;
			}
		}
		for (i = -38; i < -23; i++) {
			buf[273] = (byte) i;
			if (sha1_32(buf) == 1498818003) {
				break;
			}
		}
		for (i = -22; i < -1; i++) {
			buf[274] = (byte) i;
			if (sha1_32(buf) == -482092222) {
				break;
			}
		}
		for (i = -16; i < -11; i++) {
			buf[275] = (byte) i;
			if (sha1_32(buf) == -1815159713) {
				break;
			}
		}
		for (i = -85; i < -62; i++) {
			buf[276] = (byte) i;
			if (sha1_32(buf) == -290833996) {
				break;
			}
		}
		for (i = -62; i < -54; i++) {
			buf[277] = (byte) i;
			if (sha1_32(buf) == -170293697) {
				break;
			}
		}
		for (i = -5; i < 10; i++) {
			buf[278] = (byte) i;
			if (sha1_32(buf) == -277501856) {
				break;
			}
		}
		for (i = 6; i < 33; i++) {
			buf[279] = (byte) i;
			if (sha1_32(buf) == -684413789) {
				break;
			}
		}
		for (i = 68; i < 72; i++) {
			buf[280] = (byte) i;
			if (sha1_32(buf) == 2091630015) {
				break;
			}
		}
		for (i = -124; i < -99; i++) {
			buf[281] = (byte) i;
			if (sha1_32(buf) == 1524752794) {
				break;
			}
		}
		for (i = 108; i < 115; i++) {
			buf[282] = (byte) i;
			if (sha1_32(buf) == 582843872) {
				break;
			}
		}
		for (i = 40; i < 56; i++) {
			buf[283] = (byte) i;
			if (sha1_32(buf) == 1720737083) {
				break;
			}
		}
		for (i = -80; i < -71; i++) {
			buf[284] = (byte) i;
			if (sha1_32(buf) == 1900698600) {
				break;
			}
		}
		for (i = -22; i < -15; i++) {
			buf[285] = (byte) i;
			if (sha1_32(buf) == -2008755230) {
				break;
			}
		}
		for (i = 54; i < 69; i++) {
			buf[286] = (byte) i;
			if (sha1_32(buf) == -1929191523) {
				break;
			}
		}
		for (i = -84; i < -60; i++) {
			buf[287] = (byte) i;
			if (sha1_32(buf) == -1249577052) {
				break;
			}
		}
		for (i = -85; i < -65; i++) {
			buf[288] = (byte) i;
			if (sha1_32(buf) == 31282409) {
				break;
			}
		}
		for (i = -9; i < 10; i++) {
			buf[289] = (byte) i;
			if (sha1_32(buf) == -427182272) {
				break;
			}
		}
		for (i = 26; i < 44; i++) {
			buf[290] = (byte) i;
			if (sha1_32(buf) == -1418509699) {
				break;
			}
		}
		for (i = 30; i < 50; i++) {
			buf[291] = (byte) i;
			if (sha1_32(buf) == 731268434) {
				break;
			}
		}
		for (i = 126; i < 128; i++) {
			buf[292] = (byte) i;
			if (sha1_32(buf) == 1247017155) {
				break;
			}
		}
		for (i = 99; i < 117; i++) {
			buf[293] = (byte) i;
			if (sha1_32(buf) == 1121354307) {
				break;
			}
		}
		for (i = 60; i < 69; i++) {
			buf[294] = (byte) i;
			if (sha1_32(buf) == -2130646228) {
				break;
			}
		}
		for (i = -69; i < -41; i++) {
			buf[295] = (byte) i;
			if (sha1_32(buf) == 210681325) {
				break;
			}
		}
		for (i = -49; i < -29; i++) {
			buf[296] = (byte) i;
			if (sha1_32(buf) == -1168336812) {
				break;
			}
		}
		for (i = 39; i < 49; i++) {
			buf[297] = (byte) i;
			if (sha1_32(buf) == 1760440017) {
				break;
			}
		}
		for (i = 112; i < 128; i++) {
			buf[298] = (byte) i;
			if (sha1_32(buf) == 326119087) {
				break;
			}
		}
		for (i = 105; i < 110; i++) {
			buf[299] = (byte) i;
			if (sha1_32(buf) == 144361647) {
				break;
			}
		}
		for (i = 32; i < 56; i++) {
			buf[300] = (byte) i;
			if (sha1_32(buf) == -1008483758) {
				break;
			}
		}
		for (i = -17; i < -7; i++) {
			buf[301] = (byte) i;
			if (sha1_32(buf) == -218093880) {
				break;
			}
		}
		for (i = 62; i < 70; i++) {
			buf[302] = (byte) i;
			if (sha1_32(buf) == -136231685) {
				break;
			}
		}
		for (i = -53; i < -38; i++) {
			buf[303] = (byte) i;
			if (sha1_32(buf) == 442426132) {
				break;
			}
		}
		for (i = 71; i < 93; i++) {
			buf[304] = (byte) i;
			if (sha1_32(buf) == 1401899134) {
				break;
			}
		}
		for (i = -73; i < -67; i++) {
			buf[305] = (byte) i;
			if (sha1_32(buf) == 56696019) {
				break;
			}
		}
		for (i = -95; i < -66; i++) {
			buf[306] = (byte) i;
			if (sha1_32(buf) == -296506955) {
				break;
			}
		}
		for (i = -8; i < 13; i++) {
			buf[307] = (byte) i;
			if (sha1_32(buf) == 657605005) {
				break;
			}
		}
		for (i = -31; i < -17; i++) {
			buf[308] = (byte) i;
			if (sha1_32(buf) == 156995225) {
				break;
			}
		}
		for (i = 81; i < 96; i++) {
			buf[309] = (byte) i;
			if (sha1_32(buf) == 1120136352) {
				break;
			}
		}
		for (i = -65; i < -59; i++) {
			buf[310] = (byte) i;
			if (sha1_32(buf) == 1342494815) {
				break;
			}
		}
		for (i = 64; i < 79; i++) {
			buf[311] = (byte) i;
			if (sha1_32(buf) == -761694691) {
				break;
			}
		}
		for (i = -14; i < 17; i++) {
			buf[312] = (byte) i;
			if (sha1_32(buf) == 446362188) {
				break;
			}
		}
		for (i = -120; i < -104; i++) {
			buf[313] = (byte) i;
			if (sha1_32(buf) == -1910243384) {
				break;
			}
		}
		for (i = -85; i < -71; i++) {
			buf[314] = (byte) i;
			if (sha1_32(buf) == 1202155712) {
				break;
			}
		}
		for (i = -47; i < -32; i++) {
			buf[315] = (byte) i;
			if (sha1_32(buf) == -581421996) {
				break;
			}
		}
		for (i = 18; i < 37; i++) {
			buf[316] = (byte) i;
			if (sha1_32(buf) == -55533636) {
				break;
			}
		}
		for (i = -118; i < -107; i++) {
			buf[317] = (byte) i;
			if (sha1_32(buf) == -242606417) {
				break;
			}
		}
		for (i = 52; i < 64; i++) {
			buf[318] = (byte) i;
			if (sha1_32(buf) == -364153175) {
				break;
			}
		}
		for (i = 111; i < 127; i++) {
			buf[319] = (byte) i;
			if (sha1_32(buf) == -647996041) {
				break;
			}
		}
		for (i = -123; i < -122; i++) {
			buf[320] = (byte) i;
			if (sha1_32(buf) == -727017171) {
				break;
			}
		}
		for (i = -128; i < -119; i++) {
			buf[321] = (byte) i;
			if (sha1_32(buf) == 163784984) {
				break;
			}
		}
		for (i = -5; i < 23; i++) {
			buf[322] = (byte) i;
			if (sha1_32(buf) == -150542060) {
				break;
			}
		}
		for (i = -67; i < -61; i++) {
			buf[323] = (byte) i;
			if (sha1_32(buf) == -84235747) {
				break;
			}
		}
		for (i = -117; i < -108; i++) {
			buf[324] = (byte) i;
			if (sha1_32(buf) == -786288494) {
				break;
			}
		}
		for (i = -45; i < -43; i++) {
			buf[325] = (byte) i;
			if (sha1_32(buf) == 2099105891) {
				break;
			}
		}
		for (i = 86; i < 92; i++) {
			buf[326] = (byte) i;
			if (sha1_32(buf) == -376534493) {
				break;
			}
		}
		for (i = -125; i < -103; i++) {
			buf[327] = (byte) i;
			if (sha1_32(buf) == -426904375) {
				break;
			}
		}
		for (i = 31; i < 48; i++) {
			buf[328] = (byte) i;
			if (sha1_32(buf) == 191815195) {
				break;
			}
		}
		for (i = 32; i < 61; i++) {
			buf[329] = (byte) i;
			if (sha1_32(buf) == 1543675428) {
				break;
			}
		}
		for (i = -128; i < -108; i++) {
			buf[330] = (byte) i;
			if (sha1_32(buf) == -198977511) {
				break;
			}
		}
		for (i = 60; i < 85; i++) {
			buf[331] = (byte) i;
			if (sha1_32(buf) == 1313486258) {
				break;
			}
		}
		for (i = -87; i < -66; i++) {
			buf[332] = (byte) i;
			if (sha1_32(buf) == 1286641637) {
				break;
			}
		}
		for (i = -41; i < -19; i++) {
			buf[333] = (byte) i;
			if (sha1_32(buf) == 71864909) {
				break;
			}
		}
		for (i = 26; i < 49; i++) {
			buf[334] = (byte) i;
			if (sha1_32(buf) == 1396885573) {
				break;
			}
		}
		for (i = 96; i < 114; i++) {
			buf[335] = (byte) i;
			if (sha1_32(buf) == -355192797) {
				break;
			}
		}
		for (i = -60; i < -58; i++) {
			buf[336] = (byte) i;
			if (sha1_32(buf) == -487683831) {
				break;
			}
		}
		for (i = 114; i < 118; i++) {
			buf[337] = (byte) i;
			if (sha1_32(buf) == -934672133) {
				break;
			}
		}
		for (i = 29; i < 38; i++) {
			buf[338] = (byte) i;
			if (sha1_32(buf) == -441095301) {
				break;
			}
		}
		for (i = -81; i < -66; i++) {
			buf[339] = (byte) i;
			if (sha1_32(buf) == -632888709) {
				break;
			}
		}
		for (i = -54; i < -29; i++) {
			buf[340] = (byte) i;
			if (sha1_32(buf) == 2110165958) {
				break;
			}
		}
		for (i = 17; i < 31; i++) {
			buf[341] = (byte) i;
			if (sha1_32(buf) == 1313076837) {
				break;
			}
		}
		for (i = 65; i < 67; i++) {
			buf[342] = (byte) i;
			if (sha1_32(buf) == 1554283) {
				break;
			}
		}
		for (i = -65; i < -52; i++) {
			buf[343] = (byte) i;
			if (sha1_32(buf) == -1287909014) {
				break;
			}
		}
		for (i = -87; i < -75; i++) {
			buf[344] = (byte) i;
			if (sha1_32(buf) == -1245722967) {
				break;
			}
		}
		for (i = 73; i < 88; i++) {
			buf[345] = (byte) i;
			if (sha1_32(buf) == -657932512) {
				break;
			}
		}
		for (i = -128; i < -108; i++) {
			buf[346] = (byte) i;
			if (sha1_32(buf) == -1174789682) {
				break;
			}
		}
		for (i = 92; i < 102; i++) {
			buf[347] = (byte) i;
			if (sha1_32(buf) == -106448015) {
				break;
			}
		}
		for (i = -88; i < -70; i++) {
			buf[348] = (byte) i;
			if (sha1_32(buf) == 546630292) {
				break;
			}
		}
		for (i = -96; i < -68; i++) {
			buf[349] = (byte) i;
			if (sha1_32(buf) == 1090897527) {
				break;
			}
		}
		for (i = -39; i < -36; i++) {
			buf[350] = (byte) i;
			if (sha1_32(buf) == 894516607) {
				break;
			}
		}
		for (i = 81; i < 93; i++) {
			buf[351] = (byte) i;
			if (sha1_32(buf) == 1753795142) {
				break;
			}
		}
		for (i = 45; i < 54; i++) {
			buf[352] = (byte) i;
			if (sha1_32(buf) == -184662755) {
				break;
			}
		}
		for (i = -80; i < -71; i++) {
			buf[353] = (byte) i;
			if (sha1_32(buf) == -686549565) {
				break;
			}
		}
		for (i = -52; i < -36; i++) {
			buf[354] = (byte) i;
			if (sha1_32(buf) == -1555254478) {
				break;
			}
		}
		for (i = 107; i < 112; i++) {
			buf[355] = (byte) i;
			if (sha1_32(buf) == -67046852) {
				break;
			}
		}
		for (i = 37; i < 48; i++) {
			buf[356] = (byte) i;
			if (sha1_32(buf) == -1851999581) {
				break;
			}
		}
		for (i = 56; i < 80; i++) {
			buf[357] = (byte) i;
			if (sha1_32(buf) == 792286573) {
				break;
			}
		}
		for (i = -5; i < 3; i++) {
			buf[358] = (byte) i;
			if (sha1_32(buf) == -403419066) {
				break;
			}
		}
		for (i = 45; i < 57; i++) {
			buf[359] = (byte) i;
			if (sha1_32(buf) == -1793390494) {
				break;
			}
		}
		for (i = 50; i < 59; i++) {
			buf[360] = (byte) i;
			if (sha1_32(buf) == 336171496) {
				break;
			}
		}
		for (i = -100; i < -90; i++) {
			buf[361] = (byte) i;
			if (sha1_32(buf) == -1036667530) {
				break;
			}
		}
		for (i = -92; i < -84; i++) {
			buf[362] = (byte) i;
			if (sha1_32(buf) == 555384313) {
				break;
			}
		}
		for (i = 21; i < 30; i++) {
			buf[363] = (byte) i;
			if (sha1_32(buf) == -360807921) {
				break;
			}
		}
		for (i = 45; i < 72; i++) {
			buf[364] = (byte) i;
			if (sha1_32(buf) == 1576268489) {
				break;
			}
		}
		for (i = -23; i < -10; i++) {
			buf[365] = (byte) i;
			if (sha1_32(buf) == 1672703695) {
				break;
			}
		}
		for (i = 120; i < 128; i++) {
			buf[366] = (byte) i;
			if (sha1_32(buf) == -1793295406) {
				break;
			}
		}
		for (i = -116; i < -93; i++) {
			buf[367] = (byte) i;
			if (sha1_32(buf) == 2142074614) {
				break;
			}
		}
		for (i = 25; i < 45; i++) {
			buf[368] = (byte) i;
			if (sha1_32(buf) == -301084071) {
				break;
			}
		}
		for (i = -52; i < -38; i++) {
			buf[369] = (byte) i;
			if (sha1_32(buf) == -1270166043) {
				break;
			}
		}
		for (i = 41; i < 57; i++) {
			buf[370] = (byte) i;
			if (sha1_32(buf) == 2134066932) {
				break;
			}
		}
		for (i = 95; i < 120; i++) {
			buf[371] = (byte) i;
			if (sha1_32(buf) == 725943603) {
				break;
			}
		}
		for (i = 95; i < 117; i++) {
			buf[372] = (byte) i;
			if (sha1_32(buf) == 1284276085) {
				break;
			}
		}
		for (i = 83; i < 112; i++) {
			buf[373] = (byte) i;
			if (sha1_32(buf) == -92363809) {
				break;
			}
		}
		for (i = -120; i < -99; i++) {
			buf[374] = (byte) i;
			if (sha1_32(buf) == 183653558) {
				break;
			}
		}
		for (i = -21; i < -7; i++) {
			buf[375] = (byte) i;
			if (sha1_32(buf) == 724040476) {
				break;
			}
		}
		for (i = -60; i < -57; i++) {
			buf[376] = (byte) i;
			if (sha1_32(buf) == 464233689) {
				break;
			}
		}
		for (i = -29; i < -25; i++) {
			buf[377] = (byte) i;
			if (sha1_32(buf) == 686059625) {
				break;
			}
		}
		for (i = 73; i < 86; i++) {
			buf[378] = (byte) i;
			if (sha1_32(buf) == 709072330) {
				break;
			}
		}
		for (i = 62; i < 65; i++) {
			buf[379] = (byte) i;
			if (sha1_32(buf) == 2444033) {
				break;
			}
		}
		for (i = -30; i < -15; i++) {
			buf[380] = (byte) i;
			if (sha1_32(buf) == 111511993) {
				break;
			}
		}
		for (i = 109; i < 119; i++) {
			buf[381] = (byte) i;
			if (sha1_32(buf) == 1220029165) {
				break;
			}
		}
		for (i = 71; i < 88; i++) {
			buf[382] = (byte) i;
			if (sha1_32(buf) == 2105770638) {
				break;
			}
		}
		for (i = -128; i < -111; i++) {
			buf[383] = (byte) i;
			if (sha1_32(buf) == -415989082) {
				break;
			}
		}
		for (i = -67; i < -54; i++) {
			buf[384] = (byte) i;
			if (sha1_32(buf) == 411788415) {
				break;
			}
		}
		for (i = -88; i < -81; i++) {
			buf[385] = (byte) i;
			if (sha1_32(buf) == -529104335) {
				break;
			}
		}
		for (i = -85; i < -68; i++) {
			buf[386] = (byte) i;
			if (sha1_32(buf) == -1437030848) {
				break;
			}
		}
		for (i = -121; i < -95; i++) {
			buf[387] = (byte) i;
			if (sha1_32(buf) == -1830580369) {
				break;
			}
		}
		for (i = -103; i < -92; i++) {
			buf[388] = (byte) i;
			if (sha1_32(buf) == 86084483) {
				break;
			}
		}
		for (i = -21; i < 6; i++) {
			buf[389] = (byte) i;
			if (sha1_32(buf) == 870180142) {
				break;
			}
		}
		for (i = 124; i < 128; i++) {
			buf[390] = (byte) i;
			if (sha1_32(buf) == -454998889) {
				break;
			}
		}
		for (i = 5; i < 27; i++) {
			buf[391] = (byte) i;
			if (sha1_32(buf) == -909289226) {
				break;
			}
		}
		for (i = 118; i < 128; i++) {
			buf[392] = (byte) i;
			if (sha1_32(buf) == 870108323) {
				break;
			}
		}
		for (i = -107; i < -93; i++) {
			buf[393] = (byte) i;
			if (sha1_32(buf) == -1639601786) {
				break;
			}
		}
		for (i = -76; i < -67; i++) {
			buf[394] = (byte) i;
			if (sha1_32(buf) == 177983964) {
				break;
			}
		}
		for (i = 94; i < 111; i++) {
			buf[395] = (byte) i;
			if (sha1_32(buf) == -1053732656) {
				break;
			}
		}
		for (i = -92; i < -75; i++) {
			buf[396] = (byte) i;
			if (sha1_32(buf) == 1055028170) {
				break;
			}
		}
		for (i = 26; i < 47; i++) {
			buf[397] = (byte) i;
			if (sha1_32(buf) == 2019585299) {
				break;
			}
		}
		for (i = -117; i < -102; i++) {
			buf[398] = (byte) i;
			if (sha1_32(buf) == 423672926) {
				break;
			}
		}
		for (i = 116; i < 128; i++) {
			buf[399] = (byte) i;
			if (sha1_32(buf) == -1381722109) {
				break;
			}
		}
		for (i = 15; i < 30; i++) {
			buf[400] = (byte) i;
			if (sha1_32(buf) == -179285955) {
				break;
			}
		}
		for (i = 71; i < 80; i++) {
			buf[401] = (byte) i;
			if (sha1_32(buf) == 1714010543) {
				break;
			}
		}
		for (i = -27; i < -4; i++) {
			buf[402] = (byte) i;
			if (sha1_32(buf) == -24466999) {
				break;
			}
		}
		for (i = 28; i < 43; i++) {
			buf[403] = (byte) i;
			if (sha1_32(buf) == -1893105741) {
				break;
			}
		}
		for (i = 26; i < 38; i++) {
			buf[404] = (byte) i;
			if (sha1_32(buf) == 1100621616) {
				break;
			}
		}
		for (i = 109; i < 125; i++) {
			buf[405] = (byte) i;
			if (sha1_32(buf) == 771634113) {
				break;
			}
		}
		for (i = 11; i < 18; i++) {
			buf[406] = (byte) i;
			if (sha1_32(buf) == -1325331133) {
				break;
			}
		}
		for (i = -126; i < -104; i++) {
			buf[407] = (byte) i;
			if (sha1_32(buf) == -142519129) {
				break;
			}
		}
		for (i = -128; i < -103; i++) {
			buf[408] = (byte) i;
			if (sha1_32(buf) == 49578837) {
				break;
			}
		}
		for (i = -88; i < -74; i++) {
			buf[409] = (byte) i;
			if (sha1_32(buf) == 836736601) {
				break;
			}
		}
		for (i = -42; i < -34; i++) {
			buf[410] = (byte) i;
			if (sha1_32(buf) == -580651096) {
				break;
			}
		}
		for (i = -90; i < -79; i++) {
			buf[411] = (byte) i;
			if (sha1_32(buf) == 791043790) {
				break;
			}
		}
		for (i = -31; i < -21; i++) {
			buf[412] = (byte) i;
			if (sha1_32(buf) == 1804351426) {
				break;
			}
		}
		for (i = -44; i < -22; i++) {
			buf[413] = (byte) i;
			if (sha1_32(buf) == 1494267409) {
				break;
			}
		}
		for (i = 39; i < 58; i++) {
			buf[414] = (byte) i;
			if (sha1_32(buf) == 106988905) {
				break;
			}
		}
		for (i = 21; i < 36; i++) {
			buf[415] = (byte) i;
			if (sha1_32(buf) == -1839654890) {
				break;
			}
		}
		for (i = -64; i < -43; i++) {
			buf[416] = (byte) i;
			if (sha1_32(buf) == 1902769423) {
				break;
			}
		}
		for (i = -68; i < -48; i++) {
			buf[417] = (byte) i;
			if (sha1_32(buf) == -1808708638) {
				break;
			}
		}
		for (i = 71; i < 85; i++) {
			buf[418] = (byte) i;
			if (sha1_32(buf) == 1064727067) {
				break;
			}
		}
		for (i = 24; i < 50; i++) {
			buf[419] = (byte) i;
			if (sha1_32(buf) == -1605023206) {
				break;
			}
		}
		for (i = -38; i < -28; i++) {
			buf[420] = (byte) i;
			if (sha1_32(buf) == 182059425) {
				break;
			}
		}
		for (i = -39; i < -28; i++) {
			buf[421] = (byte) i;
			if (sha1_32(buf) == 464053872) {
				break;
			}
		}
		for (i = -112; i < -85; i++) {
			buf[422] = (byte) i;
			if (sha1_32(buf) == -140005249) {
				break;
			}
		}
		for (i = 82; i < 95; i++) {
			buf[423] = (byte) i;
			if (sha1_32(buf) == 299587314) {
				break;
			}
		}
		for (i = 55; i < 64; i++) {
			buf[424] = (byte) i;
			if (sha1_32(buf) == -220718284) {
				break;
			}
		}
		for (i = 93; i < 106; i++) {
			buf[425] = (byte) i;
			if (sha1_32(buf) == 1619581875) {
				break;
			}
		}
		for (i = -46; i < -17; i++) {
			buf[426] = (byte) i;
			if (sha1_32(buf) == -1136634290) {
				break;
			}
		}
		for (i = 9; i < 31; i++) {
			buf[427] = (byte) i;
			if (sha1_32(buf) == -256339763) {
				break;
			}
		}
		for (i = 29; i < 42; i++) {
			buf[428] = (byte) i;
			if (sha1_32(buf) == 2115268533) {
				break;
			}
		}
		for (i = -64; i < -45; i++) {
			buf[429] = (byte) i;
			if (sha1_32(buf) == -1198041945) {
				break;
			}
		}
		for (i = -56; i < -34; i++) {
			buf[430] = (byte) i;
			if (sha1_32(buf) == 1082148571) {
				break;
			}
		}
		for (i = 2; i < 20; i++) {
			buf[431] = (byte) i;
			if (sha1_32(buf) == 1741874446) {
				break;
			}
		}
		for (i = 42; i < 66; i++) {
			buf[432] = (byte) i;
			if (sha1_32(buf) == 458618770) {
				break;
			}
		}
		for (i = -62; i < -36; i++) {
			buf[433] = (byte) i;
			if (sha1_32(buf) == -421469879) {
				break;
			}
		}
		for (i = 84; i < 108; i++) {
			buf[434] = (byte) i;
			if (sha1_32(buf) == -449043040) {
				break;
			}
		}
		for (i = 42; i < 68; i++) {
			buf[435] = (byte) i;
			if (sha1_32(buf) == 27728764) {
				break;
			}
		}
		for (i = 94; i < 112; i++) {
			buf[436] = (byte) i;
			if (sha1_32(buf) == -27077280) {
				break;
			}
		}
		for (i = 69; i < 90; i++) {
			buf[437] = (byte) i;
			if (sha1_32(buf) == -1650544603) {
				break;
			}
		}
		for (i = -53; i < -52; i++) {
			buf[438] = (byte) i;
			if (sha1_32(buf) == -619586268) {
				break;
			}
		}
		for (i = -121; i < -94; i++) {
			buf[439] = (byte) i;
			if (sha1_32(buf) == 452682635) {
				break;
			}
		}
		for (i = -120; i < -97; i++) {
			buf[440] = (byte) i;
			if (sha1_32(buf) == 1306770917) {
				break;
			}
		}
		for (i = -128; i < -100; i++) {
			buf[441] = (byte) i;
			if (sha1_32(buf) == -1205806879) {
				break;
			}
		}
		for (i = -90; i < -82; i++) {
			buf[442] = (byte) i;
			if (sha1_32(buf) == 1529239328) {
				break;
			}
		}
		for (i = -13; i < 2; i++) {
			buf[443] = (byte) i;
			if (sha1_32(buf) == -1873915621) {
				break;
			}
		}
		for (i = -73; i < -60; i++) {
			buf[444] = (byte) i;
			if (sha1_32(buf) == 485928590) {
				break;
			}
		}
		for (i = -52; i < -24; i++) {
			buf[445] = (byte) i;
			if (sha1_32(buf) == 1641418944) {
				break;
			}
		}
		for (i = -107; i < -78; i++) {
			buf[446] = (byte) i;
			if (sha1_32(buf) == -477814708) {
				break;
			}
		}
		for (i = -69; i < -54; i++) {
			buf[447] = (byte) i;
			if (sha1_32(buf) == -1988977115) {
				break;
			}
		}
		for (i = -8; i < 0; i++) {
			buf[448] = (byte) i;
			if (sha1_32(buf) == -1934488810) {
				break;
			}
		}
		for (i = 1; i < 19; i++) {
			buf[449] = (byte) i;
			if (sha1_32(buf) == 748691571) {
				break;
			}
		}
		for (i = -80; i < -58; i++) {
			buf[450] = (byte) i;
			if (sha1_32(buf) == -4568986) {
				break;
			}
		}
		for (i = 56; i < 81; i++) {
			buf[451] = (byte) i;
			if (sha1_32(buf) == 963638766) {
				break;
			}
		}
		for (i = -105; i < -81; i++) {
			buf[452] = (byte) i;
			if (sha1_32(buf) == -1865481519) {
				break;
			}
		}
		for (i = 55; i < 67; i++) {
			buf[453] = (byte) i;
			if (sha1_32(buf) == -1891462345) {
				break;
			}
		}
		for (i = -60; i < -48; i++) {
			buf[454] = (byte) i;
			if (sha1_32(buf) == -2057228803) {
				break;
			}
		}
		for (i = 38; i < 51; i++) {
			buf[455] = (byte) i;
			if (sha1_32(buf) == 983025427) {
				break;
			}
		}
		for (i = -66; i < -57; i++) {
			buf[456] = (byte) i;
			if (sha1_32(buf) == 35436839) {
				break;
			}
		}
		for (i = 74; i < 90; i++) {
			buf[457] = (byte) i;
			if (sha1_32(buf) == 930392142) {
				break;
			}
		}
		for (i = -124; i < -109; i++) {
			buf[458] = (byte) i;
			if (sha1_32(buf) == 1244594131) {
				break;
			}
		}
		for (i = 67; i < 89; i++) {
			buf[459] = (byte) i;
			if (sha1_32(buf) == -625572493) {
				break;
			}
		}
		for (i = -76; i < -47; i++) {
			buf[460] = (byte) i;
			if (sha1_32(buf) == 505155591) {
				break;
			}
		}
		for (i = -9; i < 4; i++) {
			buf[461] = (byte) i;
			if (sha1_32(buf) == -1762425899) {
				break;
			}
		}
		for (i = 57; i < 73; i++) {
			buf[462] = (byte) i;
			if (sha1_32(buf) == 222593306) {
				break;
			}
		}
		for (i = 102; i < 117; i++) {
			buf[463] = (byte) i;
			if (sha1_32(buf) == -608346762) {
				break;
			}
		}
		for (i = 45; i < 65; i++) {
			buf[464] = (byte) i;
			if (sha1_32(buf) == 1023720097) {
				break;
			}
		}
		for (i = -111; i < -94; i++) {
			buf[465] = (byte) i;
			if (sha1_32(buf) == 1016792553) {
				break;
			}
		}
		for (i = -65; i < -47; i++) {
			buf[466] = (byte) i;
			if (sha1_32(buf) == 1731656006) {
				break;
			}
		}
		for (i = 114; i < 128; i++) {
			buf[467] = (byte) i;
			if (sha1_32(buf) == 219209856) {
				break;
			}
		}
		for (i = -118; i < -96; i++) {
			buf[468] = (byte) i;
			if (sha1_32(buf) == 498749904) {
				break;
			}
		}
		for (i = 71; i < 76; i++) {
			buf[469] = (byte) i;
			if (sha1_32(buf) == -670455788) {
				break;
			}
		}
		for (i = -37; i < -14; i++) {
			buf[470] = (byte) i;
			if (sha1_32(buf) == 394502498) {
				break;
			}
		}
		for (i = 24; i < 36; i++) {
			buf[471] = (byte) i;
			if (sha1_32(buf) == 1864868133) {
				break;
			}
		}
		for (i = 29; i < 47; i++) {
			buf[472] = (byte) i;
			if (sha1_32(buf) == -1092528567) {
				break;
			}
		}
		for (i = -42; i < -27; i++) {
			buf[473] = (byte) i;
			if (sha1_32(buf) == -1311938018) {
				break;
			}
		}
		for (i = -68; i < -46; i++) {
			buf[474] = (byte) i;
			if (sha1_32(buf) == -2067457957) {
				break;
			}
		}
		for (i = -111; i < -97; i++) {
			buf[475] = (byte) i;
			if (sha1_32(buf) == 1004348601) {
				break;
			}
		}
		for (i = 30; i < 50; i++) {
			buf[476] = (byte) i;
			if (sha1_32(buf) == 1402438213) {
				break;
			}
		}
		for (i = 41; i < 56; i++) {
			buf[477] = (byte) i;
			if (sha1_32(buf) == 1672872699) {
				break;
			}
		}
		for (i = 53; i < 63; i++) {
			buf[478] = (byte) i;
			if (sha1_32(buf) == 364886415) {
				break;
			}
		}
		for (i = -96; i < -76; i++) {
			buf[479] = (byte) i;
			if (sha1_32(buf) == -1608750736) {
				break;
			}
		}
		for (i = 31; i < 53; i++) {
			buf[480] = (byte) i;
			if (sha1_32(buf) == 375936688) {
				break;
			}
		}
		for (i = 88; i < 103; i++) {
			buf[481] = (byte) i;
			if (sha1_32(buf) == 1805159817) {
				break;
			}
		}
		for (i = -73; i < -57; i++) {
			buf[482] = (byte) i;
			if (sha1_32(buf) == 2144781251) {
				break;
			}
		}
		for (i = 5; i < 16; i++) {
			buf[483] = (byte) i;
			if (sha1_32(buf) == -486077097) {
				break;
			}
		}
		for (i = -63; i < -36; i++) {
			buf[484] = (byte) i;
			if (sha1_32(buf) == -543649974) {
				break;
			}
		}
		for (i = 54; i < 63; i++) {
			buf[485] = (byte) i;
			if (sha1_32(buf) == -1185109313) {
				break;
			}
		}
		for (i = 121; i < 128; i++) {
			buf[486] = (byte) i;
			if (sha1_32(buf) == -1652458581) {
				break;
			}
		}
		for (i = 12; i < 18; i++) {
			buf[487] = (byte) i;
			if (sha1_32(buf) == -1540816359) {
				break;
			}
		}
		for (i = -61; i < -49; i++) {
			buf[488] = (byte) i;
			if (sha1_32(buf) == -864860939) {
				break;
			}
		}
		for (i = -55; i < -44; i++) {
			buf[489] = (byte) i;
			if (sha1_32(buf) == 1329549122) {
				break;
			}
		}
		for (i = 35; i < 52; i++) {
			buf[490] = (byte) i;
			if (sha1_32(buf) == 1534790016) {
				break;
			}
		}
		for (i = 41; i < 67; i++) {
			buf[491] = (byte) i;
			if (sha1_32(buf) == -1856737002) {
				break;
			}
		}
		for (i = 87; i < 110; i++) {
			buf[492] = (byte) i;
			if (sha1_32(buf) == -115674326) {
				break;
			}
		}
		for (i = -21; i < -9; i++) {
			buf[493] = (byte) i;
			if (sha1_32(buf) == 1585885396) {
				break;
			}
		}
		for (i = -123; i < -106; i++) {
			buf[494] = (byte) i;
			if (sha1_32(buf) == -902591220) {
				break;
			}
		}
		for (i = -118; i < -106; i++) {
			buf[495] = (byte) i;
			if (sha1_32(buf) == -741331269) {
				break;
			}
		}
		for (i = 89; i < 99; i++) {
			buf[496] = (byte) i;
			if (sha1_32(buf) == 96780992) {
				break;
			}
		}
		for (i = 28; i < 43; i++) {
			buf[497] = (byte) i;
			if (sha1_32(buf) == 842892819) {
				break;
			}
		}
		for (i = 9; i < 32; i++) {
			buf[498] = (byte) i;
			if (sha1_32(buf) == -317631435) {
				break;
			}
		}
		for (i = -16; i < -2; i++) {
			buf[499] = (byte) i;
			if (sha1_32(buf) == -654733406) {
				break;
			}
		}
		for (i = 39; i < 46; i++) {
			buf[500] = (byte) i;
			if (sha1_32(buf) == -1409606948) {
				break;
			}
		}
		for (i = 5; i < 28; i++) {
			buf[501] = (byte) i;
			if (sha1_32(buf) == -272319489) {
				break;
			}
		}
		for (i = -100; i < -80; i++) {
			buf[502] = (byte) i;
			if (sha1_32(buf) == 1055954527) {
				break;
			}
		}
		for (i = 19; i < 26; i++) {
			buf[503] = (byte) i;
			if (sha1_32(buf) == 2012509394) {
				break;
			}
		}
		for (i = -1; i < 9; i++) {
			buf[504] = (byte) i;
			if (sha1_32(buf) == 789409849) {
				break;
			}
		}
		for (i = 98; i < 122; i++) {
			buf[505] = (byte) i;
			if (sha1_32(buf) == -515044622) {
				break;
			}
		}
		for (i = 58; i < 69; i++) {
			buf[506] = (byte) i;
			if (sha1_32(buf) == 1130853058) {
				break;
			}
		}
		for (i = 14; i < 35; i++) {
			buf[507] = (byte) i;
			if (sha1_32(buf) == 329798665) {
				break;
			}
		}
		for (i = -19; i < -13; i++) {
			buf[508] = (byte) i;
			if (sha1_32(buf) == 1241961101) {
				break;
			}
		}
		for (i = 71; i < 94; i++) {
			buf[509] = (byte) i;
			if (sha1_32(buf) == -2007044793) {
				break;
			}
		}
		for (i = 117; i < 128; i++) {
			buf[510] = (byte) i;
			if (sha1_32(buf) == 538936918) {
				break;
			}
		}
		for (i = -33; i < -17; i++) {
			buf[511] = (byte) i;
			if (sha1_32(buf) == 1593463232) {
				break;
			}
		}
		for (i = 101; i < 109; i++) {
			buf[512] = (byte) i;
			if (sha1_32(buf) == 1879735458) {
				break;
			}
		}
		for (i = -128; i < -125; i++) {
			buf[513] = (byte) i;
			if (sha1_32(buf) == -1657205400) {
				break;
			}
		}
		for (i = -128; i < -118; i++) {
			buf[514] = (byte) i;
			if (sha1_32(buf) == -2031477253) {
				break;
			}
		}
		for (i = 125; i < 128; i++) {
			buf[515] = (byte) i;
			if (sha1_32(buf) == 1399723412) {
				break;
			}
		}
		for (i = -92; i < -81; i++) {
			buf[516] = (byte) i;
			if (sha1_32(buf) == 412633298) {
				break;
			}
		}
		for (i = 62; i < 70; i++) {
			buf[517] = (byte) i;
			if (sha1_32(buf) == -34698746) {
				break;
			}
		}
		for (i = -128; i < -120; i++) {
			buf[518] = (byte) i;
			if (sha1_32(buf) == -1765971070) {
				break;
			}
		}
		for (i = -69; i < -50; i++) {
			buf[519] = (byte) i;
			if (sha1_32(buf) == 1126529071) {
				break;
			}
		}
		for (i = -34; i < -16; i++) {
			buf[520] = (byte) i;
			if (sha1_32(buf) == -1085729465) {
				break;
			}
		}
		for (i = 102; i < 115; i++) {
			buf[521] = (byte) i;
			if (sha1_32(buf) == -721658120) {
				break;
			}
		}
		for (i = -5; i < 7; i++) {
			buf[522] = (byte) i;
			if (sha1_32(buf) == -721658120) {
				break;
			}
		}
		for (i = -69; i < -59; i++) {
			buf[523] = (byte) i;
			if (sha1_32(buf) == -868725404) {
				break;
			}
		}
		for (i = 12; i < 24; i++) {
			buf[524] = (byte) i;
			if (sha1_32(buf) == -199165197) {
				break;
			}
		}
		for (i = -55; i < -39; i++) {
			buf[525] = (byte) i;
			if (sha1_32(buf) == 1964713990) {
				break;
			}
		}
		for (i = -70; i < -61; i++) {
			buf[526] = (byte) i;
			if (sha1_32(buf) == -210667132) {
				break;
			}
		}
		for (i = 78; i < 94; i++) {
			buf[527] = (byte) i;
			if (sha1_32(buf) == 1797040269) {
				break;
			}
		}
		for (i = 86; i < 91; i++) {
			buf[528] = (byte) i;
			if (sha1_32(buf) == -844613669) {
				break;
			}
		}
		for (i = -103; i < -92; i++) {
			buf[529] = (byte) i;
			if (sha1_32(buf) == -1430511491) {
				break;
			}
		}
		for (i = 52; i < 61; i++) {
			buf[530] = (byte) i;
			if (sha1_32(buf) == 216074005) {
				break;
			}
		}
		for (i = 97; i < 119; i++) {
			buf[531] = (byte) i;
			if (sha1_32(buf) == 302265375) {
				break;
			}
		}
		for (i = -73; i < -59; i++) {
			buf[532] = (byte) i;
			if (sha1_32(buf) == -830548755) {
				break;
			}
		}
		for (i = -74; i < -56; i++) {
			buf[533] = (byte) i;
			if (sha1_32(buf) == 1500755723) {
				break;
			}
		}
		for (i = 111; i < 128; i++) {
			buf[534] = (byte) i;
			if (sha1_32(buf) == 1185126112) {
				break;
			}
		}
		for (i = 34; i < 53; i++) {
			buf[535] = (byte) i;
			if (sha1_32(buf) == 2053339881) {
				break;
			}
		}
		for (i = -121; i < -94; i++) {
			buf[536] = (byte) i;
			if (sha1_32(buf) == 2017471443) {
				break;
			}
		}
		for (i = -30; i < -13; i++) {
			buf[537] = (byte) i;
			if (sha1_32(buf) == 2034179644) {
				break;
			}
		}
		for (i = 98; i < 110; i++) {
			buf[538] = (byte) i;
			if (sha1_32(buf) == 1946419178) {
				break;
			}
		}
		for (i = -115; i < -87; i++) {
			buf[539] = (byte) i;
			if (sha1_32(buf) == -1607790462) {
				break;
			}
		}
		for (i = 67; i < 87; i++) {
			buf[540] = (byte) i;
			if (sha1_32(buf) == 1724371281) {
				break;
			}
		}
		for (i = -15; i < 12; i++) {
			buf[541] = (byte) i;
			if (sha1_32(buf) == -491996676) {
				break;
			}
		}
		for (i = -59; i < -34; i++) {
			buf[542] = (byte) i;
			if (sha1_32(buf) == 1428981784) {
				break;
			}
		}
		for (i = 77; i < 96; i++) {
			buf[543] = (byte) i;
			if (sha1_32(buf) == 75001115) {
				break;
			}
		}
		for (i = 96; i < 122; i++) {
			buf[544] = (byte) i;
			if (sha1_32(buf) == 1595103770) {
				break;
			}
		}
		for (i = 46; i < 70; i++) {
			buf[545] = (byte) i;
			if (sha1_32(buf) == -1164813747) {
				break;
			}
		}
		for (i = 44; i < 55; i++) {
			buf[546] = (byte) i;
			if (sha1_32(buf) == -1074376027) {
				break;
			}
		}
		for (i = -102; i < -89; i++) {
			buf[547] = (byte) i;
			if (sha1_32(buf) == 378308484) {
				break;
			}
		}
		for (i = 48; i < 60; i++) {
			buf[548] = (byte) i;
			if (sha1_32(buf) == -24676165) {
				break;
			}
		}
		for (i = -9; i < 12; i++) {
			buf[549] = (byte) i;
			if (sha1_32(buf) == -738317995) {
				break;
			}
		}
		for (i = 108; i < 117; i++) {
			buf[550] = (byte) i;
			if (sha1_32(buf) == 650921927) {
				break;
			}
		}
		for (i = 36; i < 49; i++) {
			buf[551] = (byte) i;
			if (sha1_32(buf) == -1198396893) {
				break;
			}
		}
		for (i = -37; i < -18; i++) {
			buf[552] = (byte) i;
			if (sha1_32(buf) == 848614706) {
				break;
			}
		}
		for (i = -77; i < -64; i++) {
			buf[553] = (byte) i;
			if (sha1_32(buf) == -1427520631) {
				break;
			}
		}
		for (i = 26; i < 33; i++) {
			buf[554] = (byte) i;
			if (sha1_32(buf) == -289599193) {
				break;
			}
		}
		for (i = 38; i < 50; i++) {
			buf[555] = (byte) i;
			if (sha1_32(buf) == 1699640351) {
				break;
			}
		}
		for (i = -40; i < -32; i++) {
			buf[556] = (byte) i;
			if (sha1_32(buf) == 1218831888) {
				break;
			}
		}
		for (i = -30; i < -13; i++) {
			buf[557] = (byte) i;
			if (sha1_32(buf) == 783622122) {
				break;
			}
		}
		for (i = -73; i < -65; i++) {
			buf[558] = (byte) i;
			if (sha1_32(buf) == 1243569078) {
				break;
			}
		}
		for (i = 65; i < 79; i++) {
			buf[559] = (byte) i;
			if (sha1_32(buf) == -1549335977) {
				break;
			}
		}
		for (i = 1; i < 21; i++) {
			buf[560] = (byte) i;
			if (sha1_32(buf) == -980507019) {
				break;
			}
		}
		for (i = 70; i < 83; i++) {
			buf[561] = (byte) i;
			if (sha1_32(buf) == 88967498) {
				break;
			}
		}
		for (i = 84; i < 101; i++) {
			buf[562] = (byte) i;
			if (sha1_32(buf) == -1513536936) {
				break;
			}
		}
		for (i = -128; i < -107; i++) {
			buf[563] = (byte) i;
			if (sha1_32(buf) == -800110391) {
				break;
			}
		}
		for (i = -23; i < -6; i++) {
			buf[564] = (byte) i;
			if (sha1_32(buf) == 513563916) {
				break;
			}
		}
		for (i = -107; i < -86; i++) {
			buf[565] = (byte) i;
			if (sha1_32(buf) == -359547623) {
				break;
			}
		}
		for (i = -48; i < -30; i++) {
			buf[566] = (byte) i;
			if (sha1_32(buf) == 2092928046) {
				break;
			}
		}
		for (i = -99; i < -84; i++) {
			buf[567] = (byte) i;
			if (sha1_32(buf) == -641260151) {
				break;
			}
		}
		for (i = -4; i < 21; i++) {
			buf[568] = (byte) i;
			if (sha1_32(buf) == -574916317) {
				break;
			}
		}
		for (i = -102; i < -89; i++) {
			buf[569] = (byte) i;
			if (sha1_32(buf) == -713826092) {
				break;
			}
		}
		for (i = -112; i < -86; i++) {
			buf[570] = (byte) i;
			if (sha1_32(buf) == 1221548323) {
				break;
			}
		}
		for (i = -62; i < -41; i++) {
			buf[571] = (byte) i;
			if (sha1_32(buf) == -1430777902) {
				break;
			}
		}
		for (i = 24; i < 47; i++) {
			buf[572] = (byte) i;
			if (sha1_32(buf) == -816514736) {
				break;
			}
		}
		for (i = 79; i < 105; i++) {
			buf[573] = (byte) i;
			if (sha1_32(buf) == -1714102940) {
				break;
			}
		}
		for (i = 34; i < 51; i++) {
			buf[574] = (byte) i;
			if (sha1_32(buf) == 1387581488) {
				break;
			}
		}
		for (i = -92; i < -69; i++) {
			buf[575] = (byte) i;
			if (sha1_32(buf) == -792146533) {
				break;
			}
		}
		for (i = 90; i < 102; i++) {
			buf[576] = (byte) i;
			if (sha1_32(buf) == 1767754345) {
				break;
			}
		}
		for (i = 112; i < 126; i++) {
			buf[577] = (byte) i;
			if (sha1_32(buf) == -1500745727) {
				break;
			}
		}
		for (i = -42; i < -14; i++) {
			buf[578] = (byte) i;
			if (sha1_32(buf) == 1206817105) {
				break;
			}
		}
		for (i = -63; i < -57; i++) {
			buf[579] = (byte) i;
			if (sha1_32(buf) == 527110606) {
				break;
			}
		}
		for (i = 88; i < 115; i++) {
			buf[580] = (byte) i;
			if (sha1_32(buf) == 1263345300) {
				break;
			}
		}
		for (i = -111; i < -101; i++) {
			buf[581] = (byte) i;
			if (sha1_32(buf) == 589128076) {
				break;
			}
		}
		for (i = -63; i < -36; i++) {
			buf[582] = (byte) i;
			if (sha1_32(buf) == -1650312163) {
				break;
			}
		}
		for (i = -77; i < -65; i++) {
			buf[583] = (byte) i;
			if (sha1_32(buf) == -815301412) {
				break;
			}
		}
		for (i = 107; i < 115; i++) {
			buf[584] = (byte) i;
			if (sha1_32(buf) == -1401432136) {
				break;
			}
		}
		for (i = 117; i < 128; i++) {
			buf[585] = (byte) i;
			if (sha1_32(buf) == 377725203) {
				break;
			}
		}
		for (i = -37; i < -14; i++) {
			buf[586] = (byte) i;
			if (sha1_32(buf) == 1805001634) {
				break;
			}
		}
		for (i = -87; i < -66; i++) {
			buf[587] = (byte) i;
			if (sha1_32(buf) == 510648228) {
				break;
			}
		}
		for (i = -127; i < -111; i++) {
			buf[588] = (byte) i;
			if (sha1_32(buf) == 729693920) {
				break;
			}
		}
		for (i = 62; i < 70; i++) {
			buf[589] = (byte) i;
			if (sha1_32(buf) == -1739416725) {
				break;
			}
		}
		for (i = -76; i < -62; i++) {
			buf[590] = (byte) i;
			if (sha1_32(buf) == -1954152632) {
				break;
			}
		}
		for (i = 10; i < 28; i++) {
			buf[591] = (byte) i;
			if (sha1_32(buf) == -185380627) {
				break;
			}
		}
		for (i = 114; i < 128; i++) {
			buf[592] = (byte) i;
			if (sha1_32(buf) == -1047831964) {
				break;
			}
		}
		for (i = 30; i < 39; i++) {
			buf[593] = (byte) i;
			if (sha1_32(buf) == -115804026) {
				break;
			}
		}
		for (i = -93; i < -79; i++) {
			buf[594] = (byte) i;
			if (sha1_32(buf) == -1069224020) {
				break;
			}
		}
		for (i = -123; i < -110; i++) {
			buf[595] = (byte) i;
			if (sha1_32(buf) == 724236069) {
				break;
			}
		}
		for (i = 52; i < 68; i++) {
			buf[596] = (byte) i;
			if (sha1_32(buf) == -1876373377) {
				break;
			}
		}
		for (i = 69; i < 88; i++) {
			buf[597] = (byte) i;
			if (sha1_32(buf) == -1779612985) {
				break;
			}
		}
		for (i = -8; i < 1; i++) {
			buf[598] = (byte) i;
			if (sha1_32(buf) == -893790360) {
				break;
			}
		}
		for (i = 50; i < 63; i++) {
			buf[599] = (byte) i;
			if (sha1_32(buf) == 1902683290) {
				break;
			}
		}
		for (i = 35; i < 57; i++) {
			buf[600] = (byte) i;
			if (sha1_32(buf) == 514644298) {
				break;
			}
		}
		for (i = -86; i < -69; i++) {
			buf[601] = (byte) i;
			if (sha1_32(buf) == 1112254607) {
				break;
			}
		}
		for (i = 89; i < 97; i++) {
			buf[602] = (byte) i;
			if (sha1_32(buf) == 1011268346) {
				break;
			}
		}
		for (i = -15; i < 8; i++) {
			buf[603] = (byte) i;
			if (sha1_32(buf) == -843580910) {
				break;
			}
		}
		for (i = 88; i < 104; i++) {
			buf[604] = (byte) i;
			if (sha1_32(buf) == 1106821422) {
				break;
			}
		}
		for (i = -93; i < -77; i++) {
			buf[605] = (byte) i;
			if (sha1_32(buf) == 1494338398) {
				break;
			}
		}
		for (i = -5; i < 21; i++) {
			buf[606] = (byte) i;
			if (sha1_32(buf) == -922575011) {
				break;
			}
		}
		for (i = -126; i < -112; i++) {
			buf[607] = (byte) i;
			if (sha1_32(buf) == 50223907) {
				break;
			}
		}
		for (i = -4; i < 9; i++) {
			buf[608] = (byte) i;
			if (sha1_32(buf) == -1734605421) {
				break;
			}
		}
		for (i = -115; i < -98; i++) {
			buf[609] = (byte) i;
			if (sha1_32(buf) == -2086246562) {
				break;
			}
		}
		for (i = -83; i < -75; i++) {
			buf[610] = (byte) i;
			if (sha1_32(buf) == -1345055944) {
				break;
			}
		}
		for (i = -111; i < -96; i++) {
			buf[611] = (byte) i;
			if (sha1_32(buf) == 2004112104) {
				break;
			}
		}
		for (i = -89; i < -77; i++) {
			buf[612] = (byte) i;
			if (sha1_32(buf) == -706742870) {
				break;
			}
		}
		for (i = -112; i < -92; i++) {
			buf[613] = (byte) i;
			if (sha1_32(buf) == -669133471) {
				break;
			}
		}
		for (i = 18; i < 32; i++) {
			buf[614] = (byte) i;
			if (sha1_32(buf) == 848657052) {
				break;
			}
		}
		for (i = 38; i < 57; i++) {
			buf[615] = (byte) i;
			if (sha1_32(buf) == 366587808) {
				break;
			}
		}
		for (i = 47; i < 63; i++) {
			buf[616] = (byte) i;
			if (sha1_32(buf) == -108174836) {
				break;
			}
		}
		for (i = 60; i < 68; i++) {
			buf[617] = (byte) i;
			if (sha1_32(buf) == -503261789) {
				break;
			}
		}
		for (i = 95; i < 105; i++) {
			buf[618] = (byte) i;
			if (sha1_32(buf) == 967203139) {
				break;
			}
		}
		for (i = 31; i < 52; i++) {
			buf[619] = (byte) i;
			if (sha1_32(buf) == 1390511626) {
				break;
			}
		}
		for (i = -2; i < 9; i++) {
			buf[620] = (byte) i;
			if (sha1_32(buf) == 1483851420) {
				break;
			}
		}
		for (i = -65; i < -47; i++) {
			buf[621] = (byte) i;
			if (sha1_32(buf) == -1619838494) {
				break;
			}
		}
		for (i = 42; i < 50; i++) {
			buf[622] = (byte) i;
			if (sha1_32(buf) == -1511942073) {
				break;
			}
		}
		for (i = 34; i < 39; i++) {
			buf[623] = (byte) i;
			if (sha1_32(buf) == -681661491) {
				break;
			}
		}
		for (i = -77; i < -70; i++) {
			buf[624] = (byte) i;
			if (sha1_32(buf) == 413094793) {
				break;
			}
		}
		for (i = 84; i < 97; i++) {
			buf[625] = (byte) i;
			if (sha1_32(buf) == 1128981184) {
				break;
			}
		}
		for (i = -69; i < -44; i++) {
			buf[626] = (byte) i;
			if (sha1_32(buf) == -655992947) {
				break;
			}
		}
		for (i = -127; i < -107; i++) {
			buf[627] = (byte) i;
			if (sha1_32(buf) == 376027725) {
				break;
			}
		}
		for (i = 10; i < 28; i++) {
			buf[628] = (byte) i;
			if (sha1_32(buf) == 373193553) {
				break;
			}
		}
		for (i = -112; i < -104; i++) {
			buf[629] = (byte) i;
			if (sha1_32(buf) == -703025081) {
				break;
			}
		}
		for (i = -108; i < -99; i++) {
			buf[630] = (byte) i;
			if (sha1_32(buf) == -712128319) {
				break;
			}
		}
		for (i = -87; i < -81; i++) {
			buf[631] = (byte) i;
			if (sha1_32(buf) == 85959749) {
				break;
			}
		}
		for (i = -128; i < -127; i++) {
			buf[632] = (byte) i;
			if (sha1_32(buf) == -1828819802) {
				break;
			}
		}
		for (i = -27; i < -25; i++) {
			buf[633] = (byte) i;
			if (sha1_32(buf) == -977582650) {
				break;
			}
		}
		for (i = -128; i < -110; i++) {
			buf[634] = (byte) i;
			if (sha1_32(buf) == -458098699) {
				break;
			}
		}
		for (i = -66; i < -45; i++) {
			buf[635] = (byte) i;
			if (sha1_32(buf) == 1321563682) {
				break;
			}
		}
		for (i = 22; i < 37; i++) {
			buf[636] = (byte) i;
			if (sha1_32(buf) == 1379196248) {
				break;
			}
		}
		for (i = -117; i < -104; i++) {
			buf[637] = (byte) i;
			if (sha1_32(buf) == -1012487122) {
				break;
			}
		}
		for (i = 76; i < 94; i++) {
			buf[638] = (byte) i;
			if (sha1_32(buf) == 1941179886) {
				break;
			}
		}
		for (i = -128; i < -110; i++) {
			buf[639] = (byte) i;
			if (sha1_32(buf) == 243010653) {
				break;
			}
		}
		for (i = -58; i < -31; i++) {
			buf[640] = (byte) i;
			if (sha1_32(buf) == 2071844725) {
				break;
			}
		}
		for (i = 106; i < 112; i++) {
			buf[641] = (byte) i;
			if (sha1_32(buf) == 483282803) {
				break;
			}
		}
		for (i = 24; i < 45; i++) {
			buf[642] = (byte) i;
			if (sha1_32(buf) == 932794943) {
				break;
			}
		}
		for (i = -62; i < -52; i++) {
			buf[643] = (byte) i;
			if (sha1_32(buf) == 1009305400) {
				break;
			}
		}
		for (i = -30; i < -20; i++) {
			buf[644] = (byte) i;
			if (sha1_32(buf) == 682188368) {
				break;
			}
		}
		for (i = -111; i < -94; i++) {
			buf[645] = (byte) i;
			if (sha1_32(buf) == -1917804612) {
				break;
			}
		}
		for (i = 20; i < 38; i++) {
			buf[646] = (byte) i;
			if (sha1_32(buf) == -118383360) {
				break;
			}
		}
		for (i = -94; i < -85; i++) {
			buf[647] = (byte) i;
			if (sha1_32(buf) == 1984735659) {
				break;
			}
		}
		for (i = -21; i < -11; i++) {
			buf[648] = (byte) i;
			if (sha1_32(buf) == -736000712) {
				break;
			}
		}
		for (i = -121; i < -106; i++) {
			buf[649] = (byte) i;
			if (sha1_32(buf) == 1132955633) {
				break;
			}
		}
		for (i = 25; i < 41; i++) {
			buf[650] = (byte) i;
			if (sha1_32(buf) == 1426780392) {
				break;
			}
		}
		for (i = -38; i < -18; i++) {
			buf[651] = (byte) i;
			if (sha1_32(buf) == -1734538871) {
				break;
			}
		}
		for (i = 29; i < 46; i++) {
			buf[652] = (byte) i;
			if (sha1_32(buf) == -36985402) {
				break;
			}
		}
		for (i = 87; i < 92; i++) {
			buf[653] = (byte) i;
			if (sha1_32(buf) == 165576732) {
				break;
			}
		}
		for (i = -111; i < -96; i++) {
			buf[654] = (byte) i;
			if (sha1_32(buf) == -1884391925) {
				break;
			}
		}
		for (i = 95; i < 107; i++) {
			buf[655] = (byte) i;
			if (sha1_32(buf) == 1589973375) {
				break;
			}
		}
		for (i = 80; i < 92; i++) {
			buf[656] = (byte) i;
			if (sha1_32(buf) == -1637611421) {
				break;
			}
		}
		for (i = -128; i < -108; i++) {
			buf[657] = (byte) i;
			if (sha1_32(buf) == -65969154) {
				break;
			}
		}
		for (i = 59; i < 67; i++) {
			buf[658] = (byte) i;
			if (sha1_32(buf) == 171188237) {
				break;
			}
		}
		for (i = 78; i < 99; i++) {
			buf[659] = (byte) i;
			if (sha1_32(buf) == -1225225457) {
				break;
			}
		}
		for (i = 41; i < 59; i++) {
			buf[660] = (byte) i;
			if (sha1_32(buf) == -598565660) {
				break;
			}
		}
		for (i = -101; i < -89; i++) {
			buf[661] = (byte) i;
			if (sha1_32(buf) == -786399673) {
				break;
			}
		}
		for (i = 35; i < 62; i++) {
			buf[662] = (byte) i;
			if (sha1_32(buf) == -1053103556) {
				break;
			}
		}
		for (i = 68; i < 83; i++) {
			buf[663] = (byte) i;
			if (sha1_32(buf) == 1762574357) {
				break;
			}
		}
		for (i = -102; i < -95; i++) {
			buf[664] = (byte) i;
			if (sha1_32(buf) == 1298341578) {
				break;
			}
		}
		for (i = -15; i < 6; i++) {
			buf[665] = (byte) i;
			if (sha1_32(buf) == 1298341578) {
				break;
			}
		}
		for (i = -5; i < 10; i++) {
			buf[666] = (byte) i;
			if (sha1_32(buf) == -1689277059) {
				break;
			}
		}
		for (i = -124; i < -108; i++) {
			buf[667] = (byte) i;
			if (sha1_32(buf) == -1773798358) {
				break;
			}
		}
		for (i = -75; i < -48; i++) {
			buf[668] = (byte) i;
			if (sha1_32(buf) == 1859165543) {
				break;
			}
		}
		for (i = -62; i < -57; i++) {
			buf[669] = (byte) i;
			if (sha1_32(buf) == 1623686334) {
				break;
			}
		}
		for (i = -32; i < -12; i++) {
			buf[670] = (byte) i;
			if (sha1_32(buf) == -950881735) {
				break;
			}
		}
		for (i = -107; i < -82; i++) {
			buf[671] = (byte) i;
			if (sha1_32(buf) == -1001074375) {
				break;
			}
		}
		for (i = -117; i < -93; i++) {
			buf[672] = (byte) i;
			if (sha1_32(buf) == 2053137373) {
				break;
			}
		}
		for (i = -100; i < -92; i++) {
			buf[673] = (byte) i;
			if (sha1_32(buf) == -1212502065) {
				break;
			}
		}
		for (i = -2; i < 10; i++) {
			buf[674] = (byte) i;
			if (sha1_32(buf) == 1679412976) {
				break;
			}
		}
		for (i = -76; i < -48; i++) {
			buf[675] = (byte) i;
			if (sha1_32(buf) == -1879470388) {
				break;
			}
		}
		for (i = -118; i < -104; i++) {
			buf[676] = (byte) i;
			if (sha1_32(buf) == 1075662232) {
				break;
			}
		}
		for (i = -88; i < -71; i++) {
			buf[677] = (byte) i;
			if (sha1_32(buf) == -967842559) {
				break;
			}
		}
		for (i = -115; i < -97; i++) {
			buf[678] = (byte) i;
			if (sha1_32(buf) == -833053897) {
				break;
			}
		}
		for (i = -12; i < 1; i++) {
			buf[679] = (byte) i;
			if (sha1_32(buf) == 1110884527) {
				break;
			}
		}
		for (i = 72; i < 91; i++) {
			buf[680] = (byte) i;
			if (sha1_32(buf) == -261243384) {
				break;
			}
		}
		for (i = 14; i < 27; i++) {
			buf[681] = (byte) i;
			if (sha1_32(buf) == 1242399709) {
				break;
			}
		}
		for (i = -26; i < -14; i++) {
			buf[682] = (byte) i;
			if (sha1_32(buf) == 440960039) {
				break;
			}
		}
		for (i = 14; i < 25; i++) {
			buf[683] = (byte) i;
			if (sha1_32(buf) == 2067760819) {
				break;
			}
		}
		for (i = -19; i < -4; i++) {
			buf[684] = (byte) i;
			if (sha1_32(buf) == -1358037570) {
				break;
			}
		}
		for (i = 119; i < 128; i++) {
			buf[685] = (byte) i;
			if (sha1_32(buf) == 838784891) {
				break;
			}
		}
		for (i = -83; i < -65; i++) {
			buf[686] = (byte) i;
			if (sha1_32(buf) == -259057331) {
				break;
			}
		}
		for (i = 81; i < 98; i++) {
			buf[687] = (byte) i;
			if (sha1_32(buf) == 1806560397) {
				break;
			}
		}
		for (i = -5; i < 8; i++) {
			buf[688] = (byte) i;
			if (sha1_32(buf) == -961651518) {
				break;
			}
		}
		for (i = 6; i < 15; i++) {
			buf[689] = (byte) i;
			if (sha1_32(buf) == 279343018) {
				break;
			}
		}
		for (i = 88; i < 102; i++) {
			buf[690] = (byte) i;
			if (sha1_32(buf) == -6778335) {
				break;
			}
		}
		for (i = -52; i < -36; i++) {
			buf[691] = (byte) i;
			if (sha1_32(buf) == 1324177019) {
				break;
			}
		}
		for (i = 102; i < 111; i++) {
			buf[692] = (byte) i;
			if (sha1_32(buf) == -1729229075) {
				break;
			}
		}
		for (i = -128; i < -116; i++) {
			buf[693] = (byte) i;
			if (sha1_32(buf) == 522392574) {
				break;
			}
		}
		for (i = 68; i < 83; i++) {
			buf[694] = (byte) i;
			if (sha1_32(buf) == -1465574449) {
				break;
			}
		}
		for (i = 120; i < 128; i++) {
			buf[695] = (byte) i;
			if (sha1_32(buf) == -1757772756) {
				break;
			}
		}
		for (i = -94; i < -81; i++) {
			buf[696] = (byte) i;
			if (sha1_32(buf) == 1837865504) {
				break;
			}
		}
		for (i = -52; i < -42; i++) {
			buf[697] = (byte) i;
			if (sha1_32(buf) == -551957073) {
				break;
			}
		}
		for (i = 121; i < 128; i++) {
			buf[698] = (byte) i;
			if (sha1_32(buf) == -1030090346) {
				break;
			}
		}
		for (i = -89; i < -80; i++) {
			buf[699] = (byte) i;
			if (sha1_32(buf) == 599996412) {
				break;
			}
		}
		for (i = 43; i < 48; i++) {
			buf[700] = (byte) i;
			if (sha1_32(buf) == 1081216224) {
				break;
			}
		}
		for (i = -32; i < -11; i++) {
			buf[701] = (byte) i;
			if (sha1_32(buf) == 1291530482) {
				break;
			}
		}
		for (i = -61; i < -52; i++) {
			buf[702] = (byte) i;
			if (sha1_32(buf) == -260863676) {
				break;
			}
		}
		for (i = 63; i < 85; i++) {
			buf[703] = (byte) i;
			if (sha1_32(buf) == 1303612509) {
				break;
			}
		}
		for (i = 88; i < 99; i++) {
			buf[704] = (byte) i;
			if (sha1_32(buf) == -1925925400) {
				break;
			}
		}
		for (i = 9; i < 35; i++) {
			buf[705] = (byte) i;
			if (sha1_32(buf) == -1315250612) {
				break;
			}
		}
		for (i = 31; i < 48; i++) {
			buf[706] = (byte) i;
			if (sha1_32(buf) == 751950018) {
				break;
			}
		}
		for (i = -101; i < -83; i++) {
			buf[707] = (byte) i;
			if (sha1_32(buf) == -644453660) {
				break;
			}
		}
		for (i = -38; i < -24; i++) {
			buf[708] = (byte) i;
			if (sha1_32(buf) == 1345821500) {
				break;
			}
		}
		for (i = -108; i < -93; i++) {
			buf[709] = (byte) i;
			if (sha1_32(buf) == 1741709405) {
				break;
			}
		}
		for (i = -10; i < 10; i++) {
			buf[710] = (byte) i;
			if (sha1_32(buf) == -790260628) {
				break;
			}
		}
		for (i = 18; i < 28; i++) {
			buf[711] = (byte) i;
			if (sha1_32(buf) == 2103192694) {
				break;
			}
		}
		for (i = 113; i < 128; i++) {
			buf[712] = (byte) i;
			if (sha1_32(buf) == 426322789) {
				break;
			}
		}
		for (i = -63; i < -46; i++) {
			buf[713] = (byte) i;
			if (sha1_32(buf) == 373568653) {
				break;
			}
		}
		for (i = -117; i < -86; i++) {
			buf[714] = (byte) i;
			if (sha1_32(buf) == -2071515891) {
				break;
			}
		}
		for (i = 96; i < 108; i++) {
			buf[715] = (byte) i;
			if (sha1_32(buf) == 1281727227) {
				break;
			}
		}
		for (i = 17; i < 30; i++) {
			buf[716] = (byte) i;
			if (sha1_32(buf) == -775454129) {
				break;
			}
		}
		for (i = 38; i < 49; i++) {
			buf[717] = (byte) i;
			if (sha1_32(buf) == 888581712) {
				break;
			}
		}
		for (i = -87; i < -86; i++) {
			buf[718] = (byte) i;
			if (sha1_32(buf) == -932547214) {
				break;
			}
		}
		for (i = 97; i < 106; i++) {
			buf[719] = (byte) i;
			if (sha1_32(buf) == 351153388) {
				break;
			}
		}
		for (i = -90; i < -75; i++) {
			buf[720] = (byte) i;
			if (sha1_32(buf) == -53541523) {
				break;
			}
		}
		for (i = 120; i < 124; i++) {
			buf[721] = (byte) i;
			if (sha1_32(buf) == 304988188) {
				break;
			}
		}
		for (i = -50; i < -34; i++) {
			buf[722] = (byte) i;
			if (sha1_32(buf) == -556191085) {
				break;
			}
		}
		for (i = 91; i < 113; i++) {
			buf[723] = (byte) i;
			if (sha1_32(buf) == -593499333) {
				break;
			}
		}
		for (i = -84; i < -68; i++) {
			buf[724] = (byte) i;
			if (sha1_32(buf) == 1672258818) {
				break;
			}
		}
		for (i = -10; i < 9; i++) {
			buf[725] = (byte) i;
			if (sha1_32(buf) == -479882238) {
				break;
			}
		}
		for (i = -75; i < -57; i++) {
			buf[726] = (byte) i;
			if (sha1_32(buf) == 1962403917) {
				break;
			}
		}
		for (i = -53; i < -36; i++) {
			buf[727] = (byte) i;
			if (sha1_32(buf) == 1904087994) {
				break;
			}
		}
		for (i = -42; i < -21; i++) {
			buf[728] = (byte) i;
			if (sha1_32(buf) == 564235664) {
				break;
			}
		}
		for (i = 43; i < 54; i++) {
			buf[729] = (byte) i;
			if (sha1_32(buf) == -2089942234) {
				break;
			}
		}
		for (i = -118; i < -100; i++) {
			buf[730] = (byte) i;
			if (sha1_32(buf) == -1304248566) {
				break;
			}
		}
		for (i = 113; i < 128; i++) {
			buf[731] = (byte) i;
			if (sha1_32(buf) == -1414630152) {
				break;
			}
		}
		for (i = -128; i < -117; i++) {
			buf[732] = (byte) i;
			if (sha1_32(buf) == -1787923076) {
				break;
			}
		}
		for (i = -99; i < -88; i++) {
			buf[733] = (byte) i;
			if (sha1_32(buf) == -1907304855) {
				break;
			}
		}
		for (i = -123; i < -99; i++) {
			buf[734] = (byte) i;
			if (sha1_32(buf) == 1251380074) {
				break;
			}
		}
		for (i = 123; i < 128; i++) {
			buf[735] = (byte) i;
			if (sha1_32(buf) == 931003166) {
				break;
			}
		}
		for (i = -128; i < -113; i++) {
			buf[736] = (byte) i;
			if (sha1_32(buf) == 1778554731) {
				break;
			}
		}
		for (i = 43; i < 48; i++) {
			buf[737] = (byte) i;
			if (sha1_32(buf) == -624092857) {
				break;
			}
		}
		for (i = 64; i < 88; i++) {
			buf[738] = (byte) i;
			if (sha1_32(buf) == 190634826) {
				break;
			}
		}
		for (i = 33; i < 39; i++) {
			buf[739] = (byte) i;
			if (sha1_32(buf) == 305586751) {
				break;
			}
		}
		for (i = -60; i < -53; i++) {
			buf[740] = (byte) i;
			if (sha1_32(buf) == 88942601) {
				break;
			}
		}
		for (i = -91; i < -74; i++) {
			buf[741] = (byte) i;
			if (sha1_32(buf) == -781138812) {
				break;
			}
		}
		for (i = 64; i < 73; i++) {
			buf[742] = (byte) i;
			if (sha1_32(buf) == -1046707258) {
				break;
			}
		}
		for (i = 104; i < 120; i++) {
			buf[743] = (byte) i;
			if (sha1_32(buf) == -1268554108) {
				break;
			}
		}
		for (i = -105; i < -91; i++) {
			buf[744] = (byte) i;
			if (sha1_32(buf) == -1684925445) {
				break;
			}
		}
		for (i = 28; i < 45; i++) {
			buf[745] = (byte) i;
			if (sha1_32(buf) == 1086716604) {
				break;
			}
		}
		for (i = 24; i < 45; i++) {
			buf[746] = (byte) i;
			if (sha1_32(buf) == 1497128474) {
				break;
			}
		}
		for (i = -128; i < -120; i++) {
			buf[747] = (byte) i;
			if (sha1_32(buf) == -1070068452) {
				break;
			}
		}
		for (i = 82; i < 95; i++) {
			buf[748] = (byte) i;
			if (sha1_32(buf) == 1599668699) {
				break;
			}
		}
		for (i = 112; i < 117; i++) {
			buf[749] = (byte) i;
			if (sha1_32(buf) == 929815461) {
				break;
			}
		}
		for (i = -11; i < 6; i++) {
			buf[750] = (byte) i;
			if (sha1_32(buf) == 6384412) {
				break;
			}
		}
		for (i = -80; i < -64; i++) {
			buf[751] = (byte) i;
			if (sha1_32(buf) == -1553360448) {
				break;
			}
		}
		for (i = 118; i < 128; i++) {
			buf[752] = (byte) i;
			if (sha1_32(buf) == -1415183786) {
				break;
			}
		}
		for (i = -12; i < -7; i++) {
			buf[753] = (byte) i;
			if (sha1_32(buf) == -491645949) {
				break;
			}
		}
		for (i = 111; i < 128; i++) {
			buf[754] = (byte) i;
			if (sha1_32(buf) == -1704475516) {
				break;
			}
		}
		for (i = 82; i < 99; i++) {
			buf[755] = (byte) i;
			if (sha1_32(buf) == 2034658972) {
				break;
			}
		}
		for (i = -45; i < -29; i++) {
			buf[756] = (byte) i;
			if (sha1_32(buf) == -660006209) {
				break;
			}
		}
		for (i = -70; i < -50; i++) {
			buf[757] = (byte) i;
			if (sha1_32(buf) == -1310594119) {
				break;
			}
		}
		for (i = -7; i < 15; i++) {
			buf[758] = (byte) i;
			if (sha1_32(buf) == 1996152196) {
				break;
			}
		}
		for (i = 26; i < 33; i++) {
			buf[759] = (byte) i;
			if (sha1_32(buf) == 1777066125) {
				break;
			}
		}
		for (i = -74; i < -61; i++) {
			buf[760] = (byte) i;
			if (sha1_32(buf) == 2053833281) {
				break;
			}
		}
		for (i = 116; i < 128; i++) {
			buf[761] = (byte) i;
			if (sha1_32(buf) == -1523104372) {
				break;
			}
		}
		for (i = 11; i < 21; i++) {
			buf[762] = (byte) i;
			if (sha1_32(buf) == -1027396562) {
				break;
			}
		}
		for (i = 106; i < 115; i++) {
			buf[763] = (byte) i;
			if (sha1_32(buf) == -2134721677) {
				break;
			}
		}
		for (i = -39; i < -34; i++) {
			buf[764] = (byte) i;
			if (sha1_32(buf) == 1440360286) {
				break;
			}
		}
		for (i = -125; i < -107; i++) {
			buf[765] = (byte) i;
			if (sha1_32(buf) == -1850836287) {
				break;
			}
		}
		for (i = 11; i < 13; i++) {
			buf[766] = (byte) i;
			if (sha1_32(buf) == -849916311) {
				break;
			}
		}
		for (i = -8; i < 16; i++) {
			buf[767] = (byte) i;
			if (sha1_32(buf) == 370775812) {
				break;
			}
		}
		for (i = -94; i < -83; i++) {
			buf[768] = (byte) i;
			if (sha1_32(buf) == -1641710672) {
				break;
			}
		}
		for (i = -119; i < -98; i++) {
			buf[769] = (byte) i;
			if (sha1_32(buf) == 1281682262) {
				break;
			}
		}
		for (i = -14; i < 0; i++) {
			buf[770] = (byte) i;
			if (sha1_32(buf) == 1634380073) {
				break;
			}
		}
		for (i = -128; i < -110; i++) {
			buf[771] = (byte) i;
			if (sha1_32(buf) == 672007098) {
				break;
			}
		}
		for (i = 18; i < 26; i++) {
			buf[772] = (byte) i;
			if (sha1_32(buf) == -874087021) {
				break;
			}
		}
		for (i = 20; i < 27; i++) {
			buf[773] = (byte) i;
			if (sha1_32(buf) == -1230228108) {
				break;
			}
		}
		for (i = 38; i < 57; i++) {
			buf[774] = (byte) i;
			if (sha1_32(buf) == 1325230279) {
				break;
			}
		}
		for (i = -105; i < -90; i++) {
			buf[775] = (byte) i;
			if (sha1_32(buf) == -522664833) {
				break;
			}
		}
		for (i = -75; i < -59; i++) {
			buf[776] = (byte) i;
			if (sha1_32(buf) == -690187510) {
				break;
			}
		}
		for (i = 95; i < 101; i++) {
			buf[777] = (byte) i;
			if (sha1_32(buf) == 1223100861) {
				break;
			}
		}
		for (i = -32; i < -19; i++) {
			buf[778] = (byte) i;
			if (sha1_32(buf) == -1265912518) {
				break;
			}
		}
		for (i = 88; i < 105; i++) {
			buf[779] = (byte) i;
			if (sha1_32(buf) == -195195566) {
				break;
			}
		}
		for (i = -65; i < -54; i++) {
			buf[780] = (byte) i;
			if (sha1_32(buf) == -1492368161) {
				break;
			}
		}
		for (i = -120; i < -100; i++) {
			buf[781] = (byte) i;
			if (sha1_32(buf) == -495302619) {
				break;
			}
		}
		for (i = -85; i < -65; i++) {
			buf[782] = (byte) i;
			if (sha1_32(buf) == 1639252025) {
				break;
			}
		}
		for (i = 75; i < 90; i++) {
			buf[783] = (byte) i;
			if (sha1_32(buf) == 1448779979) {
				break;
			}
		}
		for (i = 92; i < 100; i++) {
			buf[784] = (byte) i;
			if (sha1_32(buf) == -1304222294) {
				break;
			}
		}
		for (i = -48; i < -41; i++) {
			buf[785] = (byte) i;
			if (sha1_32(buf) == 1641939071) {
				break;
			}
		}
		for (i = -91; i < -75; i++) {
			buf[786] = (byte) i;
			if (sha1_32(buf) == 611251826) {
				break;
			}
		}
		for (i = 102; i < 112; i++) {
			buf[787] = (byte) i;
			if (sha1_32(buf) == -2041675622) {
				break;
			}
		}
		for (i = -27; i < -16; i++) {
			buf[788] = (byte) i;
			if (sha1_32(buf) == 1314521540) {
				break;
			}
		}
		for (i = 112; i < 128; i++) {
			buf[789] = (byte) i;
			if (sha1_32(buf) == 108393889) {
				break;
			}
		}
		for (i = -62; i < -49; i++) {
			buf[790] = (byte) i;
			if (sha1_32(buf) == 1871046119) {
				break;
			}
		}
		for (i = 5; i < 33; i++) {
			buf[791] = (byte) i;
			if (sha1_32(buf) == 1055924251) {
				break;
			}
		}
		for (i = -121; i < -102; i++) {
			buf[792] = (byte) i;
			if (sha1_32(buf) == -238926123) {
				break;
			}
		}
		for (i = 98; i < 111; i++) {
			buf[793] = (byte) i;
			if (sha1_32(buf) == 605895637) {
				break;
			}
		}
		for (i = 66; i < 93; i++) {
			buf[794] = (byte) i;
			if (sha1_32(buf) == 1718019329) {
				break;
			}
		}
		for (i = 83; i < 99; i++) {
			buf[795] = (byte) i;
			if (sha1_32(buf) == -1567122996) {
				break;
			}
		}
		for (i = 93; i < 113; i++) {
			buf[796] = (byte) i;
			if (sha1_32(buf) == -866950288) {
				break;
			}
		}
		for (i = -26; i < 0; i++) {
			buf[797] = (byte) i;
			if (sha1_32(buf) == -708647262) {
				break;
			}
		}
		for (i = -128; i < -119; i++) {
			buf[798] = (byte) i;
			if (sha1_32(buf) == 413697037) {
				break;
			}
		}
		for (i = 72; i < 86; i++) {
			buf[799] = (byte) i;
			if (sha1_32(buf) == -488672714) {
				break;
			}
		}
		for (i = 80; i < 100; i++) {
			buf[800] = (byte) i;
			if (sha1_32(buf) == 893581200) {
				break;
			}
		}
		for (i = -86; i < -78; i++) {
			buf[801] = (byte) i;
			if (sha1_32(buf) == -31470400) {
				break;
			}
		}
		for (i = -128; i < -101; i++) {
			buf[802] = (byte) i;
			if (sha1_32(buf) == 111089079) {
				break;
			}
		}
		for (i = -19; i < 7; i++) {
			buf[803] = (byte) i;
			if (sha1_32(buf) == 436690345) {
				break;
			}
		}
		for (i = -74; i < -59; i++) {
			buf[804] = (byte) i;
			if (sha1_32(buf) == -81899961) {
				break;
			}
		}
		for (i = -82; i < -63; i++) {
			buf[805] = (byte) i;
			if (sha1_32(buf) == -1186412389) {
				break;
			}
		}
		for (i = 40; i < 50; i++) {
			buf[806] = (byte) i;
			if (sha1_32(buf) == -201024927) {
				break;
			}
		}
		for (i = 82; i < 100; i++) {
			buf[807] = (byte) i;
			if (sha1_32(buf) == -244441183) {
				break;
			}
		}
		for (i = 20; i < 41; i++) {
			buf[808] = (byte) i;
			if (sha1_32(buf) == -1076297480) {
				break;
			}
		}
		for (i = -27; i < 0; i++) {
			buf[809] = (byte) i;
			if (sha1_32(buf) == 314711432) {
				break;
			}
		}
		for (i = -4; i < 21; i++) {
			buf[810] = (byte) i;
			if (sha1_32(buf) == -2121937342) {
				break;
			}
		}
		for (i = 73; i < 78; i++) {
			buf[811] = (byte) i;
			if (sha1_32(buf) == 1676060296) {
				break;
			}
		}
		for (i = -84; i < -62; i++) {
			buf[812] = (byte) i;
			if (sha1_32(buf) == 2019675812) {
				break;
			}
		}
		for (i = -128; i < -115; i++) {
			buf[813] = (byte) i;
			if (sha1_32(buf) == 265230090) {
				break;
			}
		}
		for (i = 102; i < 112; i++) {
			buf[814] = (byte) i;
			if (sha1_32(buf) == -1693509994) {
				break;
			}
		}
		for (i = -11; i < -5; i++) {
			buf[815] = (byte) i;
			if (sha1_32(buf) == 808342637) {
				break;
			}
		}
		for (i = 13; i < 23; i++) {
			buf[816] = (byte) i;
			if (sha1_32(buf) == 2032660623) {
				break;
			}
		}
		for (i = 54; i < 66; i++) {
			buf[817] = (byte) i;
			if (sha1_32(buf) == 177305307) {
				break;
			}
		}
		for (i = 72; i < 79; i++) {
			buf[818] = (byte) i;
			if (sha1_32(buf) == 2146898185) {
				break;
			}
		}
		for (i = 58; i < 67; i++) {
			buf[819] = (byte) i;
			if (sha1_32(buf) == 438297368) {
				break;
			}
		}
		for (i = -98; i < -90; i++) {
			buf[820] = (byte) i;
			if (sha1_32(buf) == 817570832) {
				break;
			}
		}
		for (i = 111; i < 122; i++) {
			buf[821] = (byte) i;
			if (sha1_32(buf) == 15752248) {
				break;
			}
		}
		for (i = -23; i < -15; i++) {
			buf[822] = (byte) i;
			if (sha1_32(buf) == -226176947) {
				break;
			}
		}
		for (i = -56; i < -41; i++) {
			buf[823] = (byte) i;
			if (sha1_32(buf) == -1555641779) {
				break;
			}
		}
		for (i = 95; i < 110; i++) {
			buf[824] = (byte) i;
			if (sha1_32(buf) == -1692336234) {
				break;
			}
		}
		for (i = -8; i < 10; i++) {
			buf[825] = (byte) i;
			if (sha1_32(buf) == -1806712740) {
				break;
			}
		}
		for (i = -104; i < -99; i++) {
			buf[826] = (byte) i;
			if (sha1_32(buf) == -1692766807) {
				break;
			}
		}
		for (i = 105; i < 128; i++) {
			buf[827] = (byte) i;
			if (sha1_32(buf) == 1467849677) {
				break;
			}
		}
		for (i = 59; i < 72; i++) {
			buf[828] = (byte) i;
			if (sha1_32(buf) == 1803991747) {
				break;
			}
		}
		for (i = 75; i < 82; i++) {
			buf[829] = (byte) i;
			if (sha1_32(buf) == 816880552) {
				break;
			}
		}
		for (i = -23; i < -4; i++) {
			buf[830] = (byte) i;
			if (sha1_32(buf) == 757533233) {
				break;
			}
		}
		for (i = 90; i < 98; i++) {
			buf[831] = (byte) i;
			if (sha1_32(buf) == 14613826) {
				break;
			}
		}
		for (i = -91; i < -84; i++) {
			buf[832] = (byte) i;
			if (sha1_32(buf) == -1302441580) {
				break;
			}
		}
		for (i = -76; i < -70; i++) {
			buf[833] = (byte) i;
			if (sha1_32(buf) == -1760357735) {
				break;
			}
		}
		for (i = -72; i < -47; i++) {
			buf[834] = (byte) i;
			if (sha1_32(buf) == 1611745734) {
				break;
			}
		}
		for (i = -87; i < -79; i++) {
			buf[835] = (byte) i;
			if (sha1_32(buf) == -2012989404) {
				break;
			}
		}
		for (i = -28; i < -13; i++) {
			buf[836] = (byte) i;
			if (sha1_32(buf) == -1790716218) {
				break;
			}
		}
		for (i = -20; i < 7; i++) {
			buf[837] = (byte) i;
			if (sha1_32(buf) == -2082501087) {
				break;
			}
		}
		for (i = -119; i < -105; i++) {
			buf[838] = (byte) i;
			if (sha1_32(buf) == -1602903203) {
				break;
			}
		}
		for (i = 68; i < 90; i++) {
			buf[839] = (byte) i;
			if (sha1_32(buf) == -1105242127) {
				break;
			}
		}
		for (i = 104; i < 113; i++) {
			buf[840] = (byte) i;
			if (sha1_32(buf) == 878777970) {
				break;
			}
		}
		for (i = -103; i < -74; i++) {
			buf[841] = (byte) i;
			if (sha1_32(buf) == -1528784199) {
				break;
			}
		}
		for (i = 52; i < 57; i++) {
			buf[842] = (byte) i;
			if (sha1_32(buf) == 1366935586) {
				break;
			}
		}
		for (i = 21; i < 29; i++) {
			buf[843] = (byte) i;
			if (sha1_32(buf) == 1753129410) {
				break;
			}
		}
		for (i = -112; i < -100; i++) {
			buf[844] = (byte) i;
			if (sha1_32(buf) == -302040791) {
				break;
			}
		}
		for (i = 65; i < 82; i++) {
			buf[845] = (byte) i;
			if (sha1_32(buf) == -254883294) {
				break;
			}
		}
		for (i = -72; i < -55; i++) {
			buf[846] = (byte) i;
			if (sha1_32(buf) == 1944318492) {
				break;
			}
		}
		for (i = -62; i < -45; i++) {
			buf[847] = (byte) i;
			if (sha1_32(buf) == 1256987375) {
				break;
			}
		}
		for (i = 41; i < 58; i++) {
			buf[848] = (byte) i;
			if (sha1_32(buf) == -1547706865) {
				break;
			}
		}
		for (i = 58; i < 79; i++) {
			buf[849] = (byte) i;
			if (sha1_32(buf) == 1829329841) {
				break;
			}
		}
		for (i = 91; i < 119; i++) {
			buf[850] = (byte) i;
			if (sha1_32(buf) == -1806974042) {
				break;
			}
		}
		for (i = -36; i < -12; i++) {
			buf[851] = (byte) i;
			if (sha1_32(buf) == -5149075) {
				break;
			}
		}
		for (i = -64; i < -50; i++) {
			buf[852] = (byte) i;
			if (sha1_32(buf) == -1198902226) {
				break;
			}
		}
		for (i = 86; i < 101; i++) {
			buf[853] = (byte) i;
			if (sha1_32(buf) == -1491141465) {
				break;
			}
		}
		for (i = 43; i < 59; i++) {
			buf[854] = (byte) i;
			if (sha1_32(buf) == 444854132) {
				break;
			}
		}
		for (i = 86; i < 93; i++) {
			buf[855] = (byte) i;
			if (sha1_32(buf) == 1211094876) {
				break;
			}
		}
		for (i = -88; i < -83; i++) {
			buf[856] = (byte) i;
			if (sha1_32(buf) == -1185364046) {
				break;
			}
		}
		for (i = -97; i < -86; i++) {
			buf[857] = (byte) i;
			if (sha1_32(buf) == 762290411) {
				break;
			}
		}
		for (i = 77; i < 97; i++) {
			buf[858] = (byte) i;
			if (sha1_32(buf) == -2067142946) {
				break;
			}
		}
		for (i = -67; i < -57; i++) {
			buf[859] = (byte) i;
			if (sha1_32(buf) == 33588560) {
				break;
			}
		}
		for (i = 4; i < 26; i++) {
			buf[860] = (byte) i;
			if (sha1_32(buf) == -2001115721) {
				break;
			}
		}
		for (i = -56; i < -35; i++) {
			buf[861] = (byte) i;
			if (sha1_32(buf) == -1661699301) {
				break;
			}
		}
		for (i = -121; i < -106; i++) {
			buf[862] = (byte) i;
			if (sha1_32(buf) == 245968811) {
				break;
			}
		}
		for (i = -128; i < -120; i++) {
			buf[863] = (byte) i;
			if (sha1_32(buf) == 542003640) {
				break;
			}
		}
		for (i = 101; i < 126; i++) {
			buf[864] = (byte) i;
			if (sha1_32(buf) == -1264506728) {
				break;
			}
		}
		for (i = -128; i < -122; i++) {
			buf[865] = (byte) i;
			if (sha1_32(buf) == -320041811) {
				break;
			}
		}
		for (i = 64; i < 88; i++) {
			buf[866] = (byte) i;
			if (sha1_32(buf) == -928213595) {
				break;
			}
		}
		for (i = -10; i < 1; i++) {
			buf[867] = (byte) i;
			if (sha1_32(buf) == 1064406068) {
				break;
			}
		}
		for (i = -98; i < -95; i++) {
			buf[868] = (byte) i;
			if (sha1_32(buf) == 747802426) {
				break;
			}
		}
		for (i = 68; i < 88; i++) {
			buf[869] = (byte) i;
			if (sha1_32(buf) == -729114963) {
				break;
			}
		}
		for (i = -125; i < -103; i++) {
			buf[870] = (byte) i;
			if (sha1_32(buf) == -2074100942) {
				break;
			}
		}
		for (i = 93; i < 110; i++) {
			buf[871] = (byte) i;
			if (sha1_32(buf) == 1003128825) {
				break;
			}
		}
		for (i = 89; i < 116; i++) {
			buf[872] = (byte) i;
			if (sha1_32(buf) == 1844442075) {
				break;
			}
		}
		for (i = -103; i < -77; i++) {
			buf[873] = (byte) i;
			if (sha1_32(buf) == -150106170) {
				break;
			}
		}
		for (i = 114; i < 124; i++) {
			buf[874] = (byte) i;
			if (sha1_32(buf) == 724341795) {
				break;
			}
		}
		for (i = 8; i < 31; i++) {
			buf[875] = (byte) i;
			if (sha1_32(buf) == 680775291) {
				break;
			}
		}
		for (i = 0; i < 13; i++) {
			buf[876] = (byte) i;
			if (sha1_32(buf) == 1527730026) {
				break;
			}
		}
		for (i = 33; i < 46; i++) {
			buf[877] = (byte) i;
			if (sha1_32(buf) == -1215278517) {
				break;
			}
		}
		for (i = 120; i < 128; i++) {
			buf[878] = (byte) i;
			if (sha1_32(buf) == 1453782833) {
				break;
			}
		}
		for (i = 6; i < 27; i++) {
			buf[879] = (byte) i;
			if (sha1_32(buf) == -96662271) {
				break;
			}
		}
		for (i = 27; i < 42; i++) {
			buf[880] = (byte) i;
			if (sha1_32(buf) == -1011155944) {
				break;
			}
		}
		for (i = 107; i < 126; i++) {
			buf[881] = (byte) i;
			if (sha1_32(buf) == 1127103439) {
				break;
			}
		}
		for (i = 69; i < 81; i++) {
			buf[882] = (byte) i;
			if (sha1_32(buf) == 548176983) {
				break;
			}
		}
		for (i = -17; i < 10; i++) {
			buf[883] = (byte) i;
			if (sha1_32(buf) == -392099849) {
				break;
			}
		}
		for (i = 80; i < 109; i++) {
			buf[884] = (byte) i;
			if (sha1_32(buf) == -442597636) {
				break;
			}
		}
		for (i = 9; i < 15; i++) {
			buf[885] = (byte) i;
			if (sha1_32(buf) == 941551653) {
				break;
			}
		}
		for (i = -64; i < -60; i++) {
			buf[886] = (byte) i;
			if (sha1_32(buf) == -1847971972) {
				break;
			}
		}
		for (i = -80; i < -63; i++) {
			buf[887] = (byte) i;
			if (sha1_32(buf) == -1969210099) {
				break;
			}
		}
		for (i = 107; i < 116; i++) {
			buf[888] = (byte) i;
			if (sha1_32(buf) == 31616478) {
				break;
			}
		}
		for (i = 29; i < 48; i++) {
			buf[889] = (byte) i;
			if (sha1_32(buf) == 958241737) {
				break;
			}
		}
		for (i = -74; i < -63; i++) {
			buf[890] = (byte) i;
			if (sha1_32(buf) == 1689301767) {
				break;
			}
		}
		for (i = -63; i < -39; i++) {
			buf[891] = (byte) i;
			if (sha1_32(buf) == 1901636558) {
				break;
			}
		}
		for (i = 50; i < 70; i++) {
			buf[892] = (byte) i;
			if (sha1_32(buf) == 474832536) {
				break;
			}
		}
		for (i = 28; i < 54; i++) {
			buf[893] = (byte) i;
			if (sha1_32(buf) == 177039996) {
				break;
			}
		}
		for (i = -29; i < -14; i++) {
			buf[894] = (byte) i;
			if (sha1_32(buf) == 15137734) {
				break;
			}
		}
		for (i = 109; i < 128; i++) {
			buf[895] = (byte) i;
			if (sha1_32(buf) == -830187656) {
				break;
			}
		}
		for (i = -34; i < -12; i++) {
			buf[896] = (byte) i;
			if (sha1_32(buf) == 58015791) {
				break;
			}
		}
		for (i = -41; i < -16; i++) {
			buf[897] = (byte) i;
			if (sha1_32(buf) == 1138768329) {
				break;
			}
		}
		for (i = -123; i < -110; i++) {
			buf[898] = (byte) i;
			if (sha1_32(buf) == 1933323135) {
				break;
			}
		}
		for (i = 47; i < 59; i++) {
			buf[899] = (byte) i;
			if (sha1_32(buf) == 104995547) {
				break;
			}
		}
		for (i = -104; i < -97; i++) {
			buf[900] = (byte) i;
			if (sha1_32(buf) == -1973159912) {
				break;
			}
		}
		for (i = -113; i < -98; i++) {
			buf[901] = (byte) i;
			if (sha1_32(buf) == -1758649236) {
				break;
			}
		}
		for (i = 50; i < 71; i++) {
			buf[902] = (byte) i;
			if (sha1_32(buf) == -2135416246) {
				break;
			}
		}
		for (i = -128; i < -118; i++) {
			buf[903] = (byte) i;
			if (sha1_32(buf) == -1219498076) {
				break;
			}
		}
		for (i = -62; i < -48; i++) {
			buf[904] = (byte) i;
			if (sha1_32(buf) == -1009156150) {
				break;
			}
		}
		for (i = 26; i < 28; i++) {
			buf[905] = (byte) i;
			if (sha1_32(buf) == 678922386) {
				break;
			}
		}
		for (i = 11; i < 28; i++) {
			buf[906] = (byte) i;
			if (sha1_32(buf) == -2090370479) {
				break;
			}
		}
		for (i = -77; i < -60; i++) {
			buf[907] = (byte) i;
			if (sha1_32(buf) == -1036132607) {
				break;
			}
		}
		for (i = -95; i < -74; i++) {
			buf[908] = (byte) i;
			if (sha1_32(buf) == 1084711515) {
				break;
			}
		}
		for (i = 44; i < 52; i++) {
			buf[909] = (byte) i;
			if (sha1_32(buf) == 1694100217) {
				break;
			}
		}
		for (i = -93; i < -65; i++) {
			buf[910] = (byte) i;
			if (sha1_32(buf) == 1064201326) {
				break;
			}
		}
		for (i = -32; i < -12; i++) {
			buf[911] = (byte) i;
			if (sha1_32(buf) == -53026319) {
				break;
			}
		}
		for (i = -51; i < -40; i++) {
			buf[912] = (byte) i;
			if (sha1_32(buf) == -815936587) {
				break;
			}
		}
		for (i = 69; i < 82; i++) {
			buf[913] = (byte) i;
			if (sha1_32(buf) == -480818222) {
				break;
			}
		}
		for (i = -8; i < 15; i++) {
			buf[914] = (byte) i;
			if (sha1_32(buf) == 643959929) {
				break;
			}
		}
		for (i = -85; i < -69; i++) {
			buf[915] = (byte) i;
			if (sha1_32(buf) == -574713748) {
				break;
			}
		}
		for (i = 81; i < 97; i++) {
			buf[916] = (byte) i;
			if (sha1_32(buf) == -408255808) {
				break;
			}
		}
		for (i = -58; i < -41; i++) {
			buf[917] = (byte) i;
			if (sha1_32(buf) == -1846561784) {
				break;
			}
		}
		for (i = -32; i < -10; i++) {
			buf[918] = (byte) i;
			if (sha1_32(buf) == 614829340) {
				break;
			}
		}
		for (i = 93; i < 124; i++) {
			buf[919] = (byte) i;
			if (sha1_32(buf) == -366358440) {
				break;
			}
		}
		for (i = -128; i < -115; i++) {
			buf[920] = (byte) i;
			if (sha1_32(buf) == 1445667441) {
				break;
			}
		}
		for (i = -79; i < -55; i++) {
			buf[921] = (byte) i;
			if (sha1_32(buf) == 169010147) {
				break;
			}
		}
		for (i = -128; i < -116; i++) {
			buf[922] = (byte) i;
			if (sha1_32(buf) == -554171636) {
				break;
			}
		}
		for (i = -77; i < -71; i++) {
			buf[923] = (byte) i;
			if (sha1_32(buf) == 1695819567) {
				break;
			}
		}
		for (i = -87; i < -80; i++) {
			buf[924] = (byte) i;
			if (sha1_32(buf) == -1827915504) {
				break;
			}
		}
		for (i = 107; i < 122; i++) {
			buf[925] = (byte) i;
			if (sha1_32(buf) == 1003659362) {
				break;
			}
		}
		for (i = 13; i < 43; i++) {
			buf[926] = (byte) i;
			if (sha1_32(buf) == -2026050272) {
				break;
			}
		}
		for (i = 23; i < 51; i++) {
			buf[927] = (byte) i;
			if (sha1_32(buf) == -1480164700) {
				break;
			}
		}
		for (i = 43; i < 50; i++) {
			buf[928] = (byte) i;
			if (sha1_32(buf) == 1227248694) {
				break;
			}
		}
		for (i = -14; i < 13; i++) {
			buf[929] = (byte) i;
			if (sha1_32(buf) == -1581458491) {
				break;
			}
		}
		for (i = -116; i < -97; i++) {
			buf[930] = (byte) i;
			if (sha1_32(buf) == 262080149) {
				break;
			}
		}
		for (i = -72; i < -46; i++) {
			buf[931] = (byte) i;
			if (sha1_32(buf) == 508959540) {
				break;
			}
		}
		for (i = 82; i < 98; i++) {
			buf[932] = (byte) i;
			if (sha1_32(buf) == 710916795) {
				break;
			}
		}
		for (i = 56; i < 75; i++) {
			buf[933] = (byte) i;
			if (sha1_32(buf) == -901160701) {
				break;
			}
		}
		for (i = 71; i < 82; i++) {
			buf[934] = (byte) i;
			if (sha1_32(buf) == -1008959965) {
				break;
			}
		}
		for (i = 15; i < 29; i++) {
			buf[935] = (byte) i;
			if (sha1_32(buf) == 2146953454) {
				break;
			}
		}
		for (i = 85; i < 114; i++) {
			buf[936] = (byte) i;
			if (sha1_32(buf) == -1992264446) {
				break;
			}
		}
		for (i = 2; i < 21; i++) {
			buf[937] = (byte) i;
			if (sha1_32(buf) == -50910802) {
				break;
			}
		}
		for (i = -128; i < -110; i++) {
			buf[938] = (byte) i;
			if (sha1_32(buf) == -767650707) {
				break;
			}
		}
		for (i = 57; i < 71; i++) {
			buf[939] = (byte) i;
			if (sha1_32(buf) == 693642807) {
				break;
			}
		}
		for (i = 14; i < 38; i++) {
			buf[940] = (byte) i;
			if (sha1_32(buf) == 1971680825) {
				break;
			}
		}
		for (i = 25; i < 38; i++) {
			buf[941] = (byte) i;
			if (sha1_32(buf) == 2067708488) {
				break;
			}
		}
		for (i = -94; i < -76; i++) {
			buf[942] = (byte) i;
			if (sha1_32(buf) == 1866302487) {
				break;
			}
		}
		for (i = -115; i < -101; i++) {
			buf[943] = (byte) i;
			if (sha1_32(buf) == 232518920) {
				break;
			}
		}
		for (i = -119; i < -100; i++) {
			buf[944] = (byte) i;
			if (sha1_32(buf) == -396668282) {
				break;
			}
		}
		for (i = -102; i < -81; i++) {
			buf[945] = (byte) i;
			if (sha1_32(buf) == 396663217) {
				break;
			}
		}
		for (i = 49; i < 64; i++) {
			buf[946] = (byte) i;
			if (sha1_32(buf) == -150302126) {
				break;
			}
		}
		for (i = -27; i < -14; i++) {
			buf[947] = (byte) i;
			if (sha1_32(buf) == -987624242) {
				break;
			}
		}
		for (i = 49; i < 68; i++) {
			buf[948] = (byte) i;
			if (sha1_32(buf) == 1143315044) {
				break;
			}
		}
		for (i = -56; i < -43; i++) {
			buf[949] = (byte) i;
			if (sha1_32(buf) == -847243362) {
				break;
			}
		}
		for (i = -99; i < -85; i++) {
			buf[950] = (byte) i;
			if (sha1_32(buf) == -4314144) {
				break;
			}
		}
		for (i = -125; i < -110; i++) {
			buf[951] = (byte) i;
			if (sha1_32(buf) == -1766537228) {
				break;
			}
		}
		for (i = 98; i < 118; i++) {
			buf[952] = (byte) i;
			if (sha1_32(buf) == -1462005058) {
				break;
			}
		}
		for (i = 46; i < 51; i++) {
			buf[953] = (byte) i;
			if (sha1_32(buf) == 2062642745) {
				break;
			}
		}
		for (i = -107; i < -96; i++) {
			buf[954] = (byte) i;
			if (sha1_32(buf) == -1149645909) {
				break;
			}
		}
		for (i = -77; i < -59; i++) {
			buf[955] = (byte) i;
			if (sha1_32(buf) == 961165506) {
				break;
			}
		}
		for (i = 21; i < 39; i++) {
			buf[956] = (byte) i;
			if (sha1_32(buf) == 588484526) {
				break;
			}
		}
		for (i = 21; i < 44; i++) {
			buf[957] = (byte) i;
			if (sha1_32(buf) == 2014378825) {
				break;
			}
		}
		for (i = -75; i < -67; i++) {
			buf[958] = (byte) i;
			if (sha1_32(buf) == -89501697) {
				break;
			}
		}
		for (i = -102; i < -83; i++) {
			buf[959] = (byte) i;
			if (sha1_32(buf) == -1238855912) {
				break;
			}
		}
		for (i = 27; i < 50; i++) {
			buf[960] = (byte) i;
			if (sha1_32(buf) == -333303525) {
				break;
			}
		}
		for (i = -1; i < 7; i++) {
			buf[961] = (byte) i;
			if (sha1_32(buf) == -71338525) {
				break;
			}
		}
		for (i = 40; i < 59; i++) {
			buf[962] = (byte) i;
			if (sha1_32(buf) == 825651919) {
				break;
			}
		}
		for (i = 100; i < 118; i++) {
			buf[963] = (byte) i;
			if (sha1_32(buf) == -1557318585) {
				break;
			}
		}
		for (i = 44; i < 62; i++) {
			buf[964] = (byte) i;
			if (sha1_32(buf) == 441776412) {
				break;
			}
		}
		for (i = -86; i < -70; i++) {
			buf[965] = (byte) i;
			if (sha1_32(buf) == 61181767) {
				break;
			}
		}
		for (i = 72; i < 91; i++) {
			buf[966] = (byte) i;
			if (sha1_32(buf) == -462788311) {
				break;
			}
		}
		for (i = -125; i < -116; i++) {
			buf[967] = (byte) i;
			if (sha1_32(buf) == -1510180083) {
				break;
			}
		}
		for (i = 102; i < 123; i++) {
			buf[968] = (byte) i;
			if (sha1_32(buf) == -1545240628) {
				break;
			}
		}
		for (i = -13; i < -11; i++) {
			buf[969] = (byte) i;
			if (sha1_32(buf) == 367363587) {
				break;
			}
		}
		for (i = 80; i < 98; i++) {
			buf[970] = (byte) i;
			if (sha1_32(buf) == -332146524) {
				break;
			}
		}
		for (i = 15; i < 39; i++) {
			buf[971] = (byte) i;
			if (sha1_32(buf) == 1702105168) {
				break;
			}
		}
		for (i = -32; i < -5; i++) {
			buf[972] = (byte) i;
			if (sha1_32(buf) == -1095461934) {
				break;
			}
		}
		for (i = -48; i < -21; i++) {
			buf[973] = (byte) i;
			if (sha1_32(buf) == -50216655) {
				break;
			}
		}
		for (i = 81; i < 90; i++) {
			buf[974] = (byte) i;
			if (sha1_32(buf) == 1947989459) {
				break;
			}
		}
		for (i = -21; i < -16; i++) {
			buf[975] = (byte) i;
			if (sha1_32(buf) == -284476337) {
				break;
			}
		}
		for (i = 86; i < 95; i++) {
			buf[976] = (byte) i;
			if (sha1_32(buf) == 2016252435) {
				break;
			}
		}
		for (i = -128; i < -113; i++) {
			buf[977] = (byte) i;
			if (sha1_32(buf) == 365329615) {
				break;
			}
		}
		for (i = -55; i < -36; i++) {
			buf[978] = (byte) i;
			if (sha1_32(buf) == -478348510) {
				break;
			}
		}
		for (i = -107; i < -93; i++) {
			buf[979] = (byte) i;
			if (sha1_32(buf) == 1042788445) {
				break;
			}
		}
		for (i = 8; i < 21; i++) {
			buf[980] = (byte) i;
			if (sha1_32(buf) == 1317055745) {
				break;
			}
		}
		for (i = 8; i < 9; i++) {
			buf[981] = (byte) i;
			if (sha1_32(buf) == 1143601875) {
				break;
			}
		}
		for (i = 107; i < 120; i++) {
			buf[982] = (byte) i;
			if (sha1_32(buf) == -201537706) {
				break;
			}
		}
		for (i = 101; i < 116; i++) {
			buf[983] = (byte) i;
			if (sha1_32(buf) == 1170807299) {
				break;
			}
		}
		for (i = 102; i < 112; i++) {
			buf[984] = (byte) i;
			if (sha1_32(buf) == 1054390872) {
				break;
			}
		}
		for (i = -25; i < -11; i++) {
			buf[985] = (byte) i;
			if (sha1_32(buf) == -58197616) {
				break;
			}
		}
		for (i = -128; i < -122; i++) {
			buf[986] = (byte) i;
			if (sha1_32(buf) == -798460782) {
				break;
			}
		}
		for (i = 53; i < 65; i++) {
			buf[987] = (byte) i;
			if (sha1_32(buf) == 927071258) {
				break;
			}
		}
		for (i = -29; i < -8; i++) {
			buf[988] = (byte) i;
			if (sha1_32(buf) == -179300097) {
				break;
			}
		}
		for (i = 91; i < 109; i++) {
			buf[989] = (byte) i;
			if (sha1_32(buf) == 741765371) {
				break;
			}
		}
		for (i = -51; i < -40; i++) {
			buf[990] = (byte) i;
			if (sha1_32(buf) == -1466538159) {
				break;
			}
		}
		for (i = 38; i < 63; i++) {
			buf[991] = (byte) i;
			if (sha1_32(buf) == 545188760) {
				break;
			}
		}
		for (i = 65; i < 75; i++) {
			buf[992] = (byte) i;
			if (sha1_32(buf) == -1197390427) {
				break;
			}
		}
		for (i = -128; i < -114; i++) {
			buf[993] = (byte) i;
			if (sha1_32(buf) == 2077312575) {
				break;
			}
		}
		for (i = 5; i < 26; i++) {
			buf[994] = (byte) i;
			if (sha1_32(buf) == -521909113) {
				break;
			}
		}
		for (i = 96; i < 115; i++) {
			buf[995] = (byte) i;
			if (sha1_32(buf) == -1862183725) {
				break;
			}
		}
		for (i = 87; i < 105; i++) {
			buf[996] = (byte) i;
			if (sha1_32(buf) == -1786426980) {
				break;
			}
		}
		for (i = 122; i < 128; i++) {
			buf[997] = (byte) i;
			if (sha1_32(buf) == -668542283) {
				break;
			}
		}
		for (i = -26; i < -9; i++) {
			buf[998] = (byte) i;
			if (sha1_32(buf) == 1552648398) {
				break;
			}
		}
		for (i = 51; i < 56; i++) {
			buf[999] = (byte) i;
			if (sha1_32(buf) == -1137409935) {
				break;
			}
		}
		for (i = -45; i < -26; i++) {
			buf[1000] = (byte) i;
			if (sha1_32(buf) == -145894892) {
				break;
			}
		}
		for (i = -8; i < 8; i++) {
			buf[1001] = (byte) i;
			if (sha1_32(buf) == -790356516) {
				break;
			}
		}
		for (i = 102; i < 121; i++) {
			buf[1002] = (byte) i;
			if (sha1_32(buf) == 56105138) {
				break;
			}
		}
		for (i = 92; i < 115; i++) {
			buf[1003] = (byte) i;
			if (sha1_32(buf) == -1240084288) {
				break;
			}
		}
		for (i = -31; i < -23; i++) {
			buf[1004] = (byte) i;
			if (sha1_32(buf) == -596488751) {
				break;
			}
		}
		for (i = 48; i < 79; i++) {
			buf[1005] = (byte) i;
			if (sha1_32(buf) == -233161408) {
				break;
			}
		}
		for (i = 49; i < 76; i++) {
			buf[1006] = (byte) i;
			if (sha1_32(buf) == 963671544) {
				break;
			}
		}
		for (i = -81; i < -67; i++) {
			buf[1007] = (byte) i;
			if (sha1_32(buf) == 774279218) {
				break;
			}
		}
		for (i = -77; i < -59; i++) {
			buf[1008] = (byte) i;
			if (sha1_32(buf) == -659322049) {
				break;
			}
		}
		for (i = 13; i < 19; i++) {
			buf[1009] = (byte) i;
			if (sha1_32(buf) == 1753312527) {
				break;
			}
		}
		for (i = -54; i < -33; i++) {
			buf[1010] = (byte) i;
			if (sha1_32(buf) == -17904973) {
				break;
			}
		}
		for (i = 92; i < 112; i++) {
			buf[1011] = (byte) i;
			if (sha1_32(buf) == -2136754856) {
				break;
			}
		}
		for (i = 98; i < 112; i++) {
			buf[1012] = (byte) i;
			if (sha1_32(buf) == 1617657252) {
				break;
			}
		}
		for (i = 15; i < 21; i++) {
			buf[1013] = (byte) i;
			if (sha1_32(buf) == -1230482252) {
				break;
			}
		}
		for (i = -50; i < -40; i++) {
			buf[1014] = (byte) i;
			if (sha1_32(buf) == 1523692492) {
				break;
			}
		}
		for (i = -34; i < -16; i++) {
			buf[1015] = (byte) i;
			if (sha1_32(buf) == -336880966) {
				break;
			}
		}
		for (i = 81; i < 104; i++) {
			buf[1016] = (byte) i;
			if (sha1_32(buf) == -1058143440) {
				break;
			}
		}
		for (i = -121; i < -114; i++) {
			buf[1017] = (byte) i;
			if (sha1_32(buf) == -1205653965) {
				break;
			}
		}
		for (i = 98; i < 111; i++) {
			buf[1018] = (byte) i;
			if (sha1_32(buf) == 699383607) {
				break;
			}
		}
		for (i = 45; i < 72; i++) {
			buf[1019] = (byte) i;
			if (sha1_32(buf) == -726513851) {
				break;
			}
		}
		for (i = 8; i < 39; i++) {
			buf[1020] = (byte) i;
			if (sha1_32(buf) == -6710321) {
				break;
			}
		}
		for (i = 97; i < 107; i++) {
			buf[1021] = (byte) i;
			if (sha1_32(buf) == 2005853126) {
				break;
			}
		}
		for (i = -104; i < -85; i++) {
			buf[1022] = (byte) i;
			if (sha1_32(buf) == 1995430168) {
				break;
			}
		}
		for (i = 64; i < 75; i++) {
			buf[1023] = (byte) i;
			if (sha1_32(buf) == 1046409186) {
				break;
			}
		}
		for (i = 14; i < 42; i++) {
			buf[1024] = (byte) i;
			if (sha1_32(buf) == -1994760546) {
				break;
			}
		}
		for (i = -35; i < -14; i++) {
			buf[1025] = (byte) i;
			if (sha1_32(buf) == -1854469923) {
				break;
			}
		}
		for (i = -2; i < 25; i++) {
			buf[1026] = (byte) i;
			if (sha1_32(buf) == 686446182) {
				break;
			}
		}
		for (i = 77; i < 88; i++) {
			buf[1027] = (byte) i;
			if (sha1_32(buf) == -148675469) {
				break;
			}
		}
		for (i = 57; i < 68; i++) {
			buf[1028] = (byte) i;
			if (sha1_32(buf) == 1116917681) {
				break;
			}
		}
		for (i = -118; i < -107; i++) {
			buf[1029] = (byte) i;
			if (sha1_32(buf) == -416520088) {
				break;
			}
		}
		for (i = 5; i < 25; i++) {
			buf[1030] = (byte) i;
			if (sha1_32(buf) == -1870100804) {
				break;
			}
		}
		for (i = -54; i < -40; i++) {
			buf[1031] = (byte) i;
			if (sha1_32(buf) == -1482382890) {
				break;
			}
		}
		for (i = -33; i < -25; i++) {
			buf[1032] = (byte) i;
			if (sha1_32(buf) == 1378975253) {
				break;
			}
		}
		for (i = -105; i < -90; i++) {
			buf[1033] = (byte) i;
			if (sha1_32(buf) == -2046007084) {
				break;
			}
		}
		for (i = -107; i < -91; i++) {
			buf[1034] = (byte) i;
			if (sha1_32(buf) == -1294420529) {
				break;
			}
		}
		for (i = -128; i < -124; i++) {
			buf[1035] = (byte) i;
			if (sha1_32(buf) == 1155140284) {
				break;
			}
		}
		for (i = 51; i < 70; i++) {
			buf[1036] = (byte) i;
			if (sha1_32(buf) == 1961133104) {
				break;
			}
		}
		for (i = -64; i < -45; i++) {
			buf[1037] = (byte) i;
			if (sha1_32(buf) == -1350457141) {
				break;
			}
		}
		for (i = -71; i < -54; i++) {
			buf[1038] = (byte) i;
			if (sha1_32(buf) == -1941841177) {
				break;
			}
		}
		for (i = -78; i < -70; i++) {
			buf[1039] = (byte) i;
			if (sha1_32(buf) == -2007771411) {
				break;
			}
		}
		for (i = -66; i < -59; i++) {
			buf[1040] = (byte) i;
			if (sha1_32(buf) == -283764995) {
				break;
			}
		}
		for (i = 43; i < 59; i++) {
			buf[1041] = (byte) i;
			if (sha1_32(buf) == 524282965) {
				break;
			}
		}
		for (i = -58; i < -43; i++) {
			buf[1042] = (byte) i;
			if (sha1_32(buf) == -492824936) {
				break;
			}
		}
		for (i = -50; i < -40; i++) {
			buf[1043] = (byte) i;
			if (sha1_32(buf) == -734432786) {
				break;
			}
		}
		for (i = 60; i < 76; i++) {
			buf[1044] = (byte) i;
			if (sha1_32(buf) == -210777147) {
				break;
			}
		}
		for (i = 12; i < 29; i++) {
			buf[1045] = (byte) i;
			if (sha1_32(buf) == 249047807) {
				break;
			}
		}
		for (i = 24; i < 41; i++) {
			buf[1046] = (byte) i;
			if (sha1_32(buf) == 1073106329) {
				break;
			}
		}
		for (i = 41; i < 63; i++) {
			buf[1047] = (byte) i;
			if (sha1_32(buf) == -694762996) {
				break;
			}
		}
		for (i = 81; i < 99; i++) {
			buf[1048] = (byte) i;
			if (sha1_32(buf) == -221868820) {
				break;
			}
		}
		for (i = -81; i < -58; i++) {
			buf[1049] = (byte) i;
			if (sha1_32(buf) == 1433165171) {
				break;
			}
		}
		for (i = 109; i < 128; i++) {
			buf[1050] = (byte) i;
			if (sha1_32(buf) == -1012889280) {
				break;
			}
		}
		for (i = -54; i < -37; i++) {
			buf[1051] = (byte) i;
			if (sha1_32(buf) == 306873454) {
				break;
			}
		}
		for (i = -27; i < -24; i++) {
			buf[1052] = (byte) i;
			if (sha1_32(buf) == -2079112999) {
				break;
			}
		}
		for (i = 47; i < 65; i++) {
			buf[1053] = (byte) i;
			if (sha1_32(buf) == -791757322) {
				break;
			}
		}
		for (i = -80; i < -64; i++) {
			buf[1054] = (byte) i;
			if (sha1_32(buf) == 487344836) {
				break;
			}
		}
		for (i = -99; i < -78; i++) {
			buf[1055] = (byte) i;
			if (sha1_32(buf) == -789181399) {
				break;
			}
		}
		for (i = 62; i < 70; i++) {
			buf[1056] = (byte) i;
			if (sha1_32(buf) == -680520405) {
				break;
			}
		}
		for (i = -102; i < -90; i++) {
			buf[1057] = (byte) i;
			if (sha1_32(buf) == -1575424369) {
				break;
			}
		}
		for (i = 63; i < 83; i++) {
			buf[1058] = (byte) i;
			if (sha1_32(buf) == -1479020748) {
				break;
			}
		}
		for (i = -77; i < -53; i++) {
			buf[1059] = (byte) i;
			if (sha1_32(buf) == -605128164) {
				break;
			}
		}
		for (i = 106; i < 128; i++) {
			buf[1060] = (byte) i;
			if (sha1_32(buf) == -1426912418) {
				break;
			}
		}
		for (i = 65; i < 75; i++) {
			buf[1061] = (byte) i;
			if (sha1_32(buf) == 622231701) {
				break;
			}
		}
		for (i = 6; i < 28; i++) {
			buf[1062] = (byte) i;
			if (sha1_32(buf) == 875695742) {
				break;
			}
		}
		for (i = 84; i < 108; i++) {
			buf[1063] = (byte) i;
			if (sha1_32(buf) == 1682966745) {
				break;
			}
		}
		for (i = 5; i < 19; i++) {
			buf[1064] = (byte) i;
			if (sha1_32(buf) == -1590606750) {
				break;
			}
		}
		for (i = 5; i < 12; i++) {
			buf[1065] = (byte) i;
			if (sha1_32(buf) == -1417813317) {
				break;
			}
		}
		for (i = 14; i < 31; i++) {
			buf[1066] = (byte) i;
			if (sha1_32(buf) == -104854007) {
				break;
			}
		}
		for (i = -76; i < -71; i++) {
			buf[1067] = (byte) i;
			if (sha1_32(buf) == 1027334679) {
				break;
			}
		}
		for (i = -24; i < -8; i++) {
			buf[1068] = (byte) i;
			if (sha1_32(buf) == 687057100) {
				break;
			}
		}
		for (i = -43; i < -16; i++) {
			buf[1069] = (byte) i;
			if (sha1_32(buf) == 562062092) {
				break;
			}
		}
		for (i = -128; i < -118; i++) {
			buf[1070] = (byte) i;
			if (sha1_32(buf) == -1090297352) {
				break;
			}
		}
		for (i = -122; i < -92; i++) {
			buf[1071] = (byte) i;
			if (sha1_32(buf) == -174485668) {
				break;
			}
		}
		for (i = 64; i < 87; i++) {
			buf[1072] = (byte) i;
			if (sha1_32(buf) == 16690406) {
				break;
			}
		}
		for (i = 72; i < 88; i++) {
			buf[1073] = (byte) i;
			if (sha1_32(buf) == 638297545) {
				break;
			}
		}
		for (i = -46; i < -27; i++) {
			buf[1074] = (byte) i;
			if (sha1_32(buf) == 758446194) {
				break;
			}
		}
		for (i = 115; i < 122; i++) {
			buf[1075] = (byte) i;
			if (sha1_32(buf) == -573616916) {
				break;
			}
		}
		for (i = 49; i < 69; i++) {
			buf[1076] = (byte) i;
			if (sha1_32(buf) == -1891001586) {
				break;
			}
		}
		for (i = 77; i < 99; i++) {
			buf[1077] = (byte) i;
			if (sha1_32(buf) == -1464117667) {
				break;
			}
		}
		for (i = 67; i < 86; i++) {
			buf[1078] = (byte) i;
			if (sha1_32(buf) == -1741641253) {
				break;
			}
		}
		for (i = -30; i < -8; i++) {
			buf[1079] = (byte) i;
			if (sha1_32(buf) == 1809574788) {
				break;
			}
		}
		for (i = -120; i < -104; i++) {
			buf[1080] = (byte) i;
			if (sha1_32(buf) == -1707144893) {
				break;
			}
		}
		for (i = 91; i < 108; i++) {
			buf[1081] = (byte) i;
			if (sha1_32(buf) == -1261374018) {
				break;
			}
		}
		for (i = 1; i < 19; i++) {
			buf[1082] = (byte) i;
			if (sha1_32(buf) == -1141798546) {
				break;
			}
		}
		for (i = -72; i < -50; i++) {
			buf[1083] = (byte) i;
			if (sha1_32(buf) == 1467301038) {
				break;
			}
		}
		for (i = 10; i < 19; i++) {
			buf[1084] = (byte) i;
			if (sha1_32(buf) == -307715793) {
				break;
			}
		}
		for (i = -105; i < -93; i++) {
			buf[1085] = (byte) i;
			if (sha1_32(buf) == -446602419) {
				break;
			}
		}
		for (i = 11; i < 33; i++) {
			buf[1086] = (byte) i;
			if (sha1_32(buf) == 715981719) {
				break;
			}
		}
		for (i = -21; i < -10; i++) {
			buf[1087] = (byte) i;
			if (sha1_32(buf) == 1606746168) {
				break;
			}
		}
		for (i = -98; i < -78; i++) {
			buf[1088] = (byte) i;
			if (sha1_32(buf) == -1485944626) {
				break;
			}
		}
		for (i = 115; i < 128; i++) {
			buf[1089] = (byte) i;
			if (sha1_32(buf) == -95490726) {
				break;
			}
		}
		for (i = 109; i < 120; i++) {
			buf[1090] = (byte) i;
			if (sha1_32(buf) == -571472412) {
				break;
			}
		}
		for (i = -93; i < -83; i++) {
			buf[1091] = (byte) i;
			if (sha1_32(buf) == -1686424511) {
				break;
			}
		}
		for (i = 113; i < 127; i++) {
			buf[1092] = (byte) i;
			if (sha1_32(buf) == 1611286161) {
				break;
			}
		}
		for (i = -26; i < -11; i++) {
			buf[1093] = (byte) i;
			if (sha1_32(buf) == -316394334) {
				break;
			}
		}
		for (i = 8; i < 38; i++) {
			buf[1094] = (byte) i;
			if (sha1_32(buf) == 1679794485) {
				break;
			}
		}
		for (i = -41; i < -25; i++) {
			buf[1095] = (byte) i;
			if (sha1_32(buf) == 1594669067) {
				break;
			}
		}
		for (i = -55; i < -38; i++) {
			buf[1096] = (byte) i;
			if (sha1_32(buf) == -1580185779) {
				break;
			}
		}
		for (i = 104; i < 128; i++) {
			buf[1097] = (byte) i;
			if (sha1_32(buf) == -876586583) {
				break;
			}
		}
		for (i = 97; i < 126; i++) {
			buf[1098] = (byte) i;
			if (sha1_32(buf) == -1514650016) {
				break;
			}
		}
		for (i = 20; i < 39; i++) {
			buf[1099] = (byte) i;
			if (sha1_32(buf) == -1147993972) {
				break;
			}
		}
		for (i = 22; i < 47; i++) {
			buf[1100] = (byte) i;
			if (sha1_32(buf) == 1564661952) {
				break;
			}
		}
		for (i = 78; i < 101; i++) {
			buf[1101] = (byte) i;
			if (sha1_32(buf) == 1665627136) {
				break;
			}
		}
		for (i = -78; i < -70; i++) {
			buf[1102] = (byte) i;
			if (sha1_32(buf) == 1672338672) {
				break;
			}
		}
		for (i = 20; i < 46; i++) {
			buf[1103] = (byte) i;
			if (sha1_32(buf) == 1258186146) {
				break;
			}
		}
		for (i = -29; i < -16; i++) {
			buf[1104] = (byte) i;
			if (sha1_32(buf) == -1613227617) {
				break;
			}
		}
		for (i = -59; i < -44; i++) {
			buf[1105] = (byte) i;
			if (sha1_32(buf) == -145177991) {
				break;
			}
		}
		for (i = -71; i < -53; i++) {
			buf[1106] = (byte) i;
			if (sha1_32(buf) == -98307452) {
				break;
			}
		}
		for (i = 7; i < 21; i++) {
			buf[1107] = (byte) i;
			if (sha1_32(buf) == 718435163) {
				break;
			}
		}
		for (i = -42; i < -24; i++) {
			buf[1108] = (byte) i;
			if (sha1_32(buf) == 56743064) {
				break;
			}
		}
		for (i = -60; i < -54; i++) {
			buf[1109] = (byte) i;
			if (sha1_32(buf) == -243533193) {
				break;
			}
		}
		for (i = -96; i < -92; i++) {
			buf[1110] = (byte) i;
			if (sha1_32(buf) == 1846166747) {
				break;
			}
		}
		for (i = 91; i < 103; i++) {
			buf[1111] = (byte) i;
			if (sha1_32(buf) == 805309941) {
				break;
			}
		}
		for (i = -41; i < -40; i++) {
			buf[1112] = (byte) i;
			if (sha1_32(buf) == 1236335847) {
				break;
			}
		}
		for (i = 67; i < 75; i++) {
			buf[1113] = (byte) i;
			if (sha1_32(buf) == -1240346044) {
				break;
			}
		}
		for (i = 14; i < 30; i++) {
			buf[1114] = (byte) i;
			if (sha1_32(buf) == 170224276) {
				break;
			}
		}
		for (i = 22; i < 43; i++) {
			buf[1115] = (byte) i;
			if (sha1_32(buf) == 1840848108) {
				break;
			}
		}
		for (i = -62; i < -56; i++) {
			buf[1116] = (byte) i;
			if (sha1_32(buf) == 139720341) {
				break;
			}
		}
		for (i = -98; i < -85; i++) {
			buf[1117] = (byte) i;
			if (sha1_32(buf) == 1132464513) {
				break;
			}
		}
		for (i = -33; i < -6; i++) {
			buf[1118] = (byte) i;
			if (sha1_32(buf) == 236676370) {
				break;
			}
		}
		for (i = 25; i < 43; i++) {
			buf[1119] = (byte) i;
			if (sha1_32(buf) == -220390349) {
				break;
			}
		}
		for (i = -6; i < 21; i++) {
			buf[1120] = (byte) i;
			if (sha1_32(buf) == 198831763) {
				break;
			}
		}
		for (i = 11; i < 21; i++) {
			buf[1121] = (byte) i;
			if (sha1_32(buf) == -1460247634) {
				break;
			}
		}
		for (i = 96; i < 104; i++) {
			buf[1122] = (byte) i;
			if (sha1_32(buf) == 54142867) {
				break;
			}
		}
		for (i = 92; i < 105; i++) {
			buf[1123] = (byte) i;
			if (sha1_32(buf) == -1585587022) {
				break;
			}
		}
		for (i = -12; i < 6; i++) {
			buf[1124] = (byte) i;
			if (sha1_32(buf) == -1524657737) {
				break;
			}
		}
		for (i = -19; i < -6; i++) {
			buf[1125] = (byte) i;
			if (sha1_32(buf) == -847444283) {
				break;
			}
		}
		for (i = 30; i < 44; i++) {
			buf[1126] = (byte) i;
			if (sha1_32(buf) == -244213283) {
				break;
			}
		}
		for (i = 0; i < 14; i++) {
			buf[1127] = (byte) i;
			if (sha1_32(buf) == -1330301533) {
				break;
			}
		}
		for (i = -28; i < -10; i++) {
			buf[1128] = (byte) i;
			if (sha1_32(buf) == 1231813606) {
				break;
			}
		}
		for (i = -42; i < -22; i++) {
			buf[1129] = (byte) i;
			if (sha1_32(buf) == 1814617650) {
				break;
			}
		}
		for (i = 94; i < 105; i++) {
			buf[1130] = (byte) i;
			if (sha1_32(buf) == 1917658400) {
				break;
			}
		}
		for (i = 56; i < 62; i++) {
			buf[1131] = (byte) i;
			if (sha1_32(buf) == -365223186) {
				break;
			}
		}
		for (i = -9; i < 6; i++) {
			buf[1132] = (byte) i;
			if (sha1_32(buf) == -1117623468) {
				break;
			}
		}
		for (i = -77; i < -61; i++) {
			buf[1133] = (byte) i;
			if (sha1_32(buf) == 1749339261) {
				break;
			}
		}
		for (i = -124; i < -109; i++) {
			buf[1134] = (byte) i;
			if (sha1_32(buf) == -1522699579) {
				break;
			}
		}
		for (i = -102; i < -85; i++) {
			buf[1135] = (byte) i;
			if (sha1_32(buf) == -1693765011) {
				break;
			}
		}
		for (i = 99; i < 112; i++) {
			buf[1136] = (byte) i;
			if (sha1_32(buf) == 275263419) {
				break;
			}
		}
		for (i = 68; i < 79; i++) {
			buf[1137] = (byte) i;
			if (sha1_32(buf) == 845794588) {
				break;
			}
		}
		for (i = -25; i < 3; i++) {
			buf[1138] = (byte) i;
			if (sha1_32(buf) == 855092939) {
				break;
			}
		}
		return buf;
	}
}
