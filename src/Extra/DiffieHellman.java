package Extra;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import util.CryptoTools;
import util.Engine;

public class DiffieHellman{
	public static void main(String[]args) throws Exception {
		BigInteger p = new BigInteger("1426978031065901624399459");
		BigInteger g = new BigInteger("142983226354603241203899");
		BigInteger aX = new BigInteger("1045117068635078734441949");
		BigInteger bY = new BigInteger("421895309718259156024604");
		byte[] ct = CryptoTools.hexToBytes("8BB3446A10F9656FB06BBC10313E9399");

		// Find the key agreement = g ^ (a * b) mod p
		// bX is not necessary, as both will compute to the same thing
		BigInteger aY = g.modPow(aX, p);
		BigInteger gAB = bY.modPow(aX,p);
		byte[] bytesGAB = gAB.toByteArray();

		// Get first 64 bits for key
		byte[] key = new byte[8];
		for (int i = 0; i < 8; i++){
			key[i] = bytesGAB[i];
		}

		// Decrypt cipher text using key and DES, ECB, PKCS5
		byte[] pt = Engine.decryptDES_ECB_PKCS5(ct, key);
		String message = new String(pt);
		System.out.println(message);

		
	}
}