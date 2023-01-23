package PracticeGodGiveMeCourage;

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class test1fail {
	public static void main(String[] args) throws Exception{
	byte [] IV = "InVector".getBytes();
	byte [] K1 = "HelpThem".getBytes();
	byte []	K2 = "OurRight".getBytes();
	
	byte [] ct = CryptoTools.hexToBytes("80148EACC62D91D1BA297A477A8B6FBCD1EA13A43859D464");
	
	AlgorithmParameterSpec aps1 = new IvParameterSpec(IV);

     SecretKeySpec Key1 = new SecretKeySpec(K1, "DES");
     SecretKeySpec Key2 = new SecretKeySpec(K2, "DES");
     
     Cipher cipher1 = Cipher.getInstance("DES/CBC/NoPadding");
     cipher1.init(Cipher.DECRYPT_MODE, Key1, aps1);
     byte[] pt1 = cipher1.doFinal(ct, 0, 8);
     String pt1_ = new String(pt1);
     System.out.print(pt1_);
     
     Cipher cipher2 = Cipher.getInstance("DES/CBC/NoPadding");
     AlgorithmParameterSpec aps2 = new IvParameterSpec(ct, 0, 8);
     cipher2.init(Cipher.DECRYPT_MODE, Key2, aps2);
     byte[] pt2 = cipher1.doFinal(ct, 8, 8);
     String pt2_ = new String(pt2);
     System.out.print(pt2_);
     
     Cipher cipher3 = Cipher.getInstance("DES/CBC/NoPadding");
     AlgorithmParameterSpec aps3 = new IvParameterSpec(ct, 8, 8);
     cipher3.init(Cipher.DECRYPT_MODE, Key1, aps3);
     byte[] pt3 = cipher1.doFinal(ct, 16, 8);
     String pt3_ = new String(pt3);
     System.out.print(pt3_);
     
     
     
			
			
}
}
