package foundation;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class PracticeTest {

	public static void main(String[] args) throws Exception{
		byte[] pt = CryptoTools.fileToBytes("data/PracticeTest.pt");
		byte[] ky = CryptoTools.fileToBytes("data/PracticeTest.key");
				SecretKeySpec secret = new SecretKeySpec(ky, "AES");
				Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
				cipher.init(Cipher.ENCRYPT_MODE, secret);
				byte[] ct = cipher.doFinal(pt);
				String ctBin = CryptoTools.bytesToBin(ct);
				String ptBin = CryptoTools.bytesToBin(pt);
				byte[] ctValue = ctBin.getBytes();
				byte[] ptValue = ptBin.getBytes();
				System.out.println(ctValue.length - ptValue.length);
	}
}
//#3 If the first person chooses one letter then the remaining times in the bag drops from 260 to 259 and the letter they picked now appear one time less in
// the bag meaning it appears 9 times. Thus the probability is (9/259) * 100 = 3.475%
