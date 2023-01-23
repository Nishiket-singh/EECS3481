package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import util.CryptoTools;

public class Hash4 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		MessageDigest md = MessageDigest.getInstance("MD5");
		  byte[] digest = md.digest("crypto".getBytes());
		  System.out.println(CryptoTools.bytesToHex(digest));
		  
		  
	}

}
