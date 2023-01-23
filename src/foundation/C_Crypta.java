package foundation;

import util.CryptoTools;

public class C_Crypta {
	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/MSG2.CT");
		int[] freq = CryptoTools.getFrequencies(ct);
		int maxFreq = 0;
		for(int i = 0; i < 26; i++) {
			System.out.println("Letter = " + (char) (i + 'A') + " Freq " + freq[i]/(double)ct.length);
			if(freq[i] > freq[maxFreq]) {
				maxFreq = i;
			}
		}
		// Yes I can deduce the key, the most frequent letter is A and this must be E. So 0 - 4 = -4 + 26 = 22, thus the key is 22.
		int key = maxFreq - 4;
		if(key < 0) {
			key += 26;
		}
		for(int i = 0; i < ct.length; i++) {
			ct[i] = (byte) (ct[i] - 'A' - key % 26);
			if(ct[i] < 0) {
				ct[i] += 26;
			}
			ct[i] += 'A';
		}
		CryptoTools.bytesToFile(ct, "data/CryptaCesear.pt");
	}
	//COURSE is the first word in the decrypted plain text. 
}
