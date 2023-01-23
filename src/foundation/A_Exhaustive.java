package foundation;

import java.math.BigInteger;

import util.CryptoTools;

public class A_Exhaustive {
	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/check.txt");
		BigInteger alpha = new BigInteger("1");
		BigInteger beta = new BigInteger("0");
		BigInteger maxVal = new BigInteger("26");
		BigInteger maxAlpha = new BigInteger("1");
		BigInteger maxBeta = new BigInteger("0");
		byte[] test = new byte[ct.length];
		double dot = 0;
		int[] freq = new int[26];
		double dotMax = 0;
		for(int a = 1; a < 26; a++) {
			alpha = BigInteger.valueOf(a);
			if(alpha.gcd(maxVal).intValue() == 1) {
				for(int b = 0; b < 26; b++) {
					beta = BigInteger.valueOf(b);
					for(int i = 0; i < ct.length; i++) {
						test[i] = (byte) (((ct[i] - 'A' - b) * alpha.modInverse(maxVal).intValue()) % 26);
						if(test[i] < 0) {
							test[i] += 26;
						}
						test[i] += 'A';
					}
					freq = CryptoTools.getFrequencies(test);
					dot = 0;
					for(int k = 0; k < 26; k++) {
						dot += (freq[k] / (double) ct.length) * CryptoTools.ENGLISH[k];
					}
					if(dot > dotMax) {
						dotMax = dot;
						maxAlpha = alpha;
						maxBeta = beta;
					}
					System.out.println("Alpha = " + a + " Beta = " + b +  " Dot = " + dot);
					//Alpha key is 5 and Beta key is 14... aka key is (5,14).
				}
			}
		}
		for(int i = 0; i < ct.length; i++) {
			ct[i] = (byte) (((ct[i] - 'A' - maxBeta.intValue()) * maxAlpha.modInverse(maxVal).intValue()) % 26);
			if(ct[i] < 0) {
				ct[i] += 26;
			}
			ct[i] += 'A';
		}
		CryptoTools.bytesToFile(ct, "data/Affine.pt");
		//The first word is ELECTION.	
	}
}
