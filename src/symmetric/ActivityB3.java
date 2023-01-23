package symmetric;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class ActivityB3 {

	public static void main(String[] args) throws Exception {
		//DES CBC AND PADDING, first block is junk.
		//Block 1 = 20D0B553DB282A4C
		//Block 2 = 8939CCA40E5F64EB
		//Block 3 = 7272851C8AFD45A9
			byte[] ct = CryptoTools.hexToBytes("B2ACD6ADF010DDC4");
			byte[] ky = "CSE@YORK".getBytes();
			byte[] iv = CryptoTools.hexToBytes("4E51297B424F90D8");
			Key secret = new SecretKeySpec(ky, "DES");
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			AlgorithmParameterSpec aps = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, secret, aps);
			byte[] pt = cipher.doFinal(ct);
			String output = new String(pt);
			
			
			System.out.println(output);
		//Yes you can salvage the other blocks in the cipher text. Since it is using CBC we are able to decrypt the third block (the second block that is not messed up).
		//The reason is because we need the n block to decrypt the n-1 block. Since the first block is garbage, we can't use it to decrypt the second block,
		//but we can use the second block to decrypt the third block. We do this by making the second block the iv and the ct block 3.
	}
	
}


