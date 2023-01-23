package Final;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;

import util.CryptoTools;

public class Q1 {

	public static void main(String[] args) throws Exception {
		
		byte [] pt = "YORK LANES MALL".getBytes();
		byte [] secret = "Trying".getBytes();
		byte[] IV = CryptoTools.hexToBytes("20FC19123087BF6CAC8D0F1254123004");
		IvParameterSpec iv = new IvParameterSpec(IV);
        SecretKeySpec secretKey = new SecretKeySpec(secret, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte [] ct = cipher.doFinal(pt);
        
        
        
        
        
		
	}
}
