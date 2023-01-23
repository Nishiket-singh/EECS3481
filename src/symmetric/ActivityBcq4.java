package symmetric;

import java.math.BigInteger;
import java.security.Key;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class ActivityBcq4 {

	public static void main(String[] args) throws Exception{
		byte[] pt = "facebook".getBytes();
		byte[] ky = "universe".getBytes();
		
		Key secret = new SecretKeySpec(ky, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, secret);
		byte[] ct = cipher.doFinal(pt);
		String str = CryptoTools.bytesToBin(ct);
		System.out.println(str);
		
		Random rand = new Random();
		int index = rand.nextInt(64);
		
		System.out.println(index);
		
		str = CryptoTools.bytesToBin(pt);
		System.out.println(str);
		char[] ch = str.toCharArray();
		char[] newpt = new char[ch.length];
		String s = "";
		for (int i = 0; i < ch.length; i++) {
			if(i == index) {
				if (ch[i] == '1')
					newpt[i] = '0';
				else
					newpt[i] = '1';
			}
			else {
				newpt[i] = ch[i];
			}
			s += newpt[i];
		}
		
		System.out.println(s);
		byte[] bval = new BigInteger(s, 2).toByteArray();
		System.out.println(CryptoTools.bytesToBin(bval));
		
		String ct1 = CryptoTools.bytesToBin(ct);
		System.out.println(ct1);
		
		cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, secret);
		ct = cipher.doFinal(bval);

		String ct2 = CryptoTools.bytesToBin(ct);
		System.out.println(ct2);
		
		
		
		
		
	}

}
