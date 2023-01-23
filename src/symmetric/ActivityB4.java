package symmetric;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class ActivityB4 {

	public static void main(String[] args) throws Exception{
		//York mode of operation. 
				byte[] ct = CryptoTools.hexToBytes("437DBAB5607137A5");
				byte[] ct2 = CryptoTools.hexToBytes("CFC1031114634087");
				byte[] ky = CryptoTools.hexToBytes("6B79466F724D4F50");
				byte[] iv = CryptoTools.hexToBytes("6976466F724D4F50");
				for(int i = 0; i < iv.length; i++) {
					iv[i] = (byte)(~iv[i]);
				}
				
				
				Key secret = new SecretKeySpec(ky, "DES");
				Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
				cipher.init(Cipher.DECRYPT_MODE, secret);
				byte[] pt = cipher.doFinal(ct);
				byte[] pt2 = cipher.doFinal(ct2);
				byte[] end = new byte[16];
				for(int i = 0; i < 16; i++) {
					if(i < 8) {
						end[i] = (byte) (pt[i] ^ iv[i]);
						ct[i] = (byte) (~ct[i]);
					} else {
						end[i] = (byte) (pt2[i-8] ^ ct[i-8]);
					}
				}
				String output = new String(end);
				System.out.print(output);
				//The first word of the plain text is TraditionalBread
	}
}
