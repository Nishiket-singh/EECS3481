package symmetric;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class ActivityB5 {

	public static void main(String[] args) throws Exception{
				byte [] ct = CryptoTools.hexToBytes("8A9FF0E2CD27DA4DC7F0C810E73D0E3B3B27CA03762BAE85597995997E625BDF0FEC655994EDD4B0851D7955B3F66717A52F83D01D73ABD9C593DA8C8CCBB073BB19E78442D9AA6D13B307EC0E8EA191E6A21897A82F1A643DC3BE0E12854D01C6006AA1D0EB1B94CAC573908018F284");
		//byte[] ct = CryptoTools.hexToBytes("8A9FF0E2CD27DA4DC7F0C810E73D0E3B3B27CA03762BAE85597995997E625BDF0FEC655994EDD4B0851D7955B3F66717A52F83D01D73ABD9C593DA8C8CCBB073BB19E78442D9AA6D13B307EC0E8EA191E6A21897A82F1A643DC3BE0E12854D01C6006AA1D0EB1B94CAC573908018F284");
				
				byte[] ky1 = "FACEBOOK".getBytes();
				byte[] ky2 = new byte[ky1.length];
				
				for(int i = 0 ; i < ky2.length; i++) {
					ky2[i] = (byte) (~ky1[i]);
				}
				
				
				
				Key secret1 = new SecretKeySpec(ky2, "DES");
				Cipher cipher1 = Cipher.getInstance("DES/ECB/NoPadding");
				cipher1.init(Cipher.DECRYPT_MODE, secret1);
				byte[] pt1 = cipher1.doFinal(ct);
				
				Key secret2 = new SecretKeySpec(ky1, "DES");
				Cipher cipher2 = Cipher.getInstance("DES/ECB/NoPadding");
				cipher2.init(Cipher.DECRYPT_MODE, secret2);
				byte[] pt2 = cipher2.doFinal(pt1);
				
				String output = new String(pt2);
				System.out.print(output);
				//The first word in the pt is Extinguish
	}

}
