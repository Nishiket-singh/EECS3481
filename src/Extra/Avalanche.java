package Extra;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class Avalanche {

	public static void main(String[] args) throws Exception {

		byte[] pt = CryptoTools.fileToBytes("data/pt");
		byte[] key = CryptoTools.fileToBytes("data/key");

		SecretKeySpec secret = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

		cipher.init(Cipher.DECRYPT_MODE, secret);

		byte[] ct1 = cipher.doFinal(pt);

		pt[pt.length - 1] = (byte) (pt[pt.length - 1] ^ 1);

		byte[] ct2 = cipher.doFinal(pt);

		System.out.println("------------------------");

		String ct1Bits = CryptoTools.bytesToBin(ct1);
		String ct2Bits = CryptoTools.bytesToBin(ct2);

		int x = 0;

		for (int i = 0; i < ct1Bits.toCharArray().length; i++) {
			if (Character.compare(ct1Bits.toCharArray()[i], ct2Bits.toCharArray()[i]) != 0)
				x++;
		}

		System.out.println("----------------------");
		System.out.println(x);
	}

}