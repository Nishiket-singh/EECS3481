package foundation;

import util.CryptoTools;

public class C_Exhaustive {
	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/MSG2.CT");
		double dot = 0;
		double dotMax = 0;
		int key = 0;
		int[] freq = CryptoTools.getFrequencies(ct);
		for(int i = 0; i < 26; i++) {
			
			byte[] test = new byte[ct.length];
			for(int j = 0; j < ct.length; j++) {
				test[j] = (byte) ((ct[j] - 'A' - i) % 26);
				if(test[j] < 0) {
					test[j] += 26;
				}
				test[j] += 'A';
			}
			freq = CryptoTools.getFrequencies(test);
			dot = 0;
			for(int k = 0; k < 26; k++) {
				dot += (freq[k] / (double) ct.length) * CryptoTools.ENGLISH[k];
			}
			if(dot > dotMax) {
				dotMax = dot;
				key = i;
			}
			System.out.println("Shift = " + i + " Dot = " + dot);
			//key must be 22 since it is the biggest dot product.
		}
		for(int i = 0; i < ct.length; i++) {
			ct[i] = (byte) (ct[i] - 'A' - key % 26);
			if(ct[i] < 0) {
				ct[i] += 26;
			}
			ct[i] += 'A';
		}
		CryptoTools.bytesToFile(ct, "data/CesearExhuastive.pt");
		//The first word in the plain text is COURSE.
	}
}