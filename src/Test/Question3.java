package Test;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class Question3 {
	public static void main(String[] args) throws Exception{
		
		// Since we already have the encrypted hex string for Saturday which we use 
		// as the IV for our encryption in CTR mode we just take the bytes equal to the 
		// length and XOR it to get the answer.
		byte[] pt = "FRIDAY".getBytes();
		byte[] enciv = "BF8EFD25AE71".getBytes();
		byte[] end = new byte[pt.length];
		for (int i = 0; i < pt.length; i++) {
			end[i] = (byte) (pt[i] ^ enciv[i]);
		}
		System.out.println(CryptoTools.bytesToHex(end));
	}
}
