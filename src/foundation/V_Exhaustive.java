package foundation;

import util.CryptoTools;

public class V_Exhaustive {
	public static void main(String args[]) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/q5.txt");
		double ic = 0.0;
		int keyLength = 2;
		byte[] holder = null;
		for(int i = 1; i < 15; i++) {
			byte[] test = new byte[ct.length/i];
			for(int k = 1; k < (ct.length/i); k++) {
				test[k-1] = ct[(k-1)*i];
			}
			ic = CryptoTools.getIC(test);
			System.out.println(ic);
			if(ic > 0.065 && ic < 0.075 && keyLength == 2) {
				keyLength = i;
				holder = new byte[ct.length/i];
				holder = test;
			}
		}
		
		holder = new byte[ct.length/keyLength];
		int[] freq = new int[26];
		int counter = 0;
		int[] key = new int[keyLength];
		for(int i = 0; i < keyLength; i++) {
			counter = 0;
			for(int k = 0; k < ct.length/keyLength; k++) {
				holder[k] = ct[counter + i];
				counter += keyLength;
			}
			freq = CryptoTools.getFrequencies(holder);
			int maxFreq = 0;
			for(int j = 0; j < 26; j++) {
				if(freq[j] > freq[maxFreq]) {
					maxFreq = j;
				}
			}
			key[i] = maxFreq - 4;
			if(key[i] < 0) {
				key[i] += 26;
			}
		}
		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		String s = "";
		for (int i = 0; i < key.length; i++) {
			s += letters[key[i]];
		}
		System.out.println(s);
		int count = 0;
		for(int z = 0; z < ct.length; z++) {
			ct[z] = (byte) ((ct[z] - 'A' - key[count]) % 26);
			if(ct[z] < 0) {
				ct[z] += 26;
			}
			ct[z] += 'A';
			count++;
			if(count >= 9) {
				count = 0;
			}
		}
		System.out.println("done");
		CryptoTools.bytesToFile(ct, "data/VigenereDecryption.pt");
	}
	//The first word in the text is LABORATORY.
	
}
