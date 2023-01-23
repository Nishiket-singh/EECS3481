package hash;

import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class Mac {

	public static void main(String[] args) throws Exception
	{
		byte[] msg = "No one can make you feel inferior without your consent.".getBytes();
		byte[] key = "concerntheirexpl".getBytes();
		
		//Hash message H(m)
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(msg);
		
		Key secret = new SecretKeySpec(key, "AES");		
		Cipher engine = Cipher.getInstance("AES/ECB/NoPadding");
		engine.init(Cipher.ENCRYPT_MODE, secret);
		
		byte[] ct = engine.doFinal(digest);
		System.out.println(CryptoTools.bytesToHex(ct));
	}
}
