package symmetric;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ActivityBcq5a {

	public static void main(String[] args) throws Exception{
		//a)show that double encrypting with all 1's produce the same key.
		byte[] pt = "HelloJA7".getBytes();
		byte[] ky = {1,1,1,1,1,1,1,1};
		Key secret = new SecretKeySpec(ky, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, secret);
		byte[] ct = cipher.doFinal(pt);
		
		Key secret2 = new SecretKeySpec(ky, "DES");
		Cipher cipher2 = Cipher.getInstance("DES/ECB/NoPadding");
		cipher2.init(Cipher.ENCRYPT_MODE, secret2);
		ct = cipher2.doFinal(ct);
		String output = new String(ct);
		System.out.print(output);

	}

}
