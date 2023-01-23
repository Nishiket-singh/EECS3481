package Extra;

import java.math.BigInteger;
import java.util.Random;
import util.CryptoTools;

public class KeySplit {

	public static void main(String[] args) {
		Random rand = new Random();
		BigInteger secret = new BigInteger("291639075201575653178417");
		BigInteger[] secretShares = new BigInteger[5];
		BigInteger finalShare = new BigInteger(secret.bitLength(), rand);

		secretShares[0] = finalShare;
		for (int i = 1; i < 4; i++) {
			secretShares[i] = new BigInteger(secret.bitLength(), rand);
			finalShare = finalShare.xor(secretShares[i]);
		}
		secretShares[4] = finalShare.xor(secret);

		System.out.println(finalShare.xor(secretShares[4]));
		System.out.println(secretShares[0]);
		System.out.println(secretShares[1]);
		System.out.println(secretShares[2]);
		System.out.println(secretShares[3]);
		System.out.println(secretShares[4]);
		System.out.println(finalShare);
	}

}
