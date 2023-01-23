package Test;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class Question2 {
	public static void main(String args[]) throws Exception {
	byte[] key1 = "HelpThem".getBytes();
    byte[] key2 = "OurRight".getBytes();
    byte[] iv = "InVector".getBytes();
    byte[] ct = CryptoTools.hexToBytes("20D0B553DB282A4C8939CCA40E5F64EB7272851C8AFD45A9");

    
    SecretKeySpec ky1 = new SecretKeySpec(key1, "DES");
    Cipher d1Cipher = Cipher.getInstance("DES/ECB/NoPadding");
    d1Cipher.init(Cipher.DECRYPT_MODE, ky1);

    SecretKeySpec ky2 = new SecretKeySpec(key2, "DES");
    Cipher d2Cipher = Cipher.getInstance("DES/ECB/NoPadding");
    d2Cipher.init(Cipher.DECRYPT_MODE, ky2);

    byte[] pt = new byte[ct.length];
    byte[] block = new byte[8];
    byte[] dBlock = new byte[8];
    byte[] nBlock = new byte[8];
    int counter = 0;
    int blockCounter = 1;

    // Decrypt bytes
    for (int i = 0; i < ct.length; i++) {
        // Load new blocks into array
        if (i % 8 == 0) {
            for (int j = 0; j < 8; j++) {
                block[j] = ct[counter];
                counter++;
            }

            if (blockCounter % 2 == 1) { // Use k1 for odd blocks
                dBlock = d1Cipher.doFinal(block);
            } else if (blockCounter % 2 == 0) { // Use k2 for even blocks
                    dBlock = d2Cipher.doFinal(block);
            }
            blockCounter++;
        }

        // If first block, XOR decrypted block with IV
        if(i < 8) {
            pt[i] = (byte) (dBlock[i % 8] ^ iv[i]);
            nBlock[i % 8] = block[i % 8]; // Record previous block
        } else { // XOR decrypted block with previous block
            pt[i] = (byte) (dBlock[i % 8] ^ nBlock[i % 8]);
            nBlock[i % 8] = block[i % 8]; // Record previous block
        }
    }

    String output = new String(pt);
    System.out.print(output);

}


}
