package symmetric;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ActivityBcq5b {

	public static void main(String[] args) throws Exception{
		//show that if K encrypts P to C, then ~K encrypts ~P to ~C
		byte[] K = "HELLOJA7".getBytes();
		byte[] P = "JOHNNYA7".getBytes();
		
		Key secret = new SecretKeySpec(K, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, secret);
		byte[] ct = cipher.doFinal(P);
		
		byte[] Kinv = "HELLOJA7".getBytes();
		byte[] Pinv = "JOHNNYA7".getBytes();
		
		for(int i = 0; i < Kinv.length; i++) {
			Kinv[i] = (byte) ~Kinv[i];
			Pinv[i] = (byte) ~Pinv[i];
		}
		
		Key secret1 = new SecretKeySpec(Kinv, "DES");
		Cipher cipher2 = Cipher.getInstance("DES/ECB/NoPadding");
		cipher2.init(Cipher.DECRYPT_MODE, secret1);
		byte[] ctinv = cipher2.doFinal(Pinv);
		
		String output1 = new String(ct);
		
		for(int i = 0; i < ctinv.length; i++) {
			ctinv[i] = (byte) ~ctinv[i];
		}
		
		String output2 = new String(ctinv);
		
		System.out.println(output1);
		System.out.println(output2);
		
	}
}
