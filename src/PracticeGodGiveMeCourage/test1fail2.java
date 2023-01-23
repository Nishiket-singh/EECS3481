package PracticeGodGiveMeCourage;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;


public class test1fail2 {
	public static void main(String[] args) throws Exception {
		byte [] iv = "InVector".getBytes();
		byte [] k1 = "HelpThem".getBytes();
		byte []	k2 = "OurRight".getBytes();
		byte[] ct = CryptoTools.hexToBytes("80148EACC62D91D1BA297A477A8B6FBCD1EA13A43859D464");
		

		Key oddSecret = new SecretKeySpec(k1, "DES");
		Key evenSecret = new SecretKeySpec(k2, "DES");

		byte[] ctBlock1 = CryptoTools.hexToBytes("80148EACC62D91D1");
		byte[] ctBlock2 = CryptoTools.hexToBytes("BA297A477A8B6FBC");
		byte[] ctBlock3 = CryptoTools.hexToBytes("D1EA13A43859D464");

		Cipher cipher1 = Cipher.getInstance("DES/ECB/NoPadding");
		cipher1.init(Cipher.DECRYPT_MODE, oddSecret);

		byte[] pt1 = cipher1.doFinal(ctBlock1);
		for (int i = 0; i < pt1.length; i++) {
			pt1[i] = (byte) ((byte) pt1[i] ^ iv[i]);
		}

		Cipher cipher2 = Cipher.getInstance("DES/ECB/NoPadding");
		cipher2.init(Cipher.DECRYPT_MODE, evenSecret);

		byte[] pt2 = cipher2.doFinal(ctBlock2);
		for (int i = 0; i < pt2.length; i++) {
			pt2[i] = (byte) ((byte) pt2[i] ^ ctBlock1[i]);
		}

		Cipher cipher3 = Cipher.getInstance("DES/ECB/NoPadding");
		cipher3.init(Cipher.DECRYPT_MODE, oddSecret);

		byte[] pt3 = cipher3.doFinal(ctBlock3);
		for (int i = 0; i < pt3.length; i++) {
			pt3[i] = (byte) ((byte) pt3[i] ^ ctBlock2[i]);
		}

		String ptString1 = new String(pt1);
		String ptString2 = new String(pt2);
		String ptString3 = new String(pt3);
		System.out.println(ptString1 + ptString2 + ptString3);

	}

}


