package Extra;

import util.CryptoTools;

public class TenCopyAlphabetIC {

	public static void main(String[] args) {
		byte[] alphabet = new byte[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		byte[] arr = new byte[260];
		int i = 0;
		for (byte a : alphabet) {
			for (int j = 0; j < 10; j++) {
				arr[i++] = a;
			}
		}

		double ic = CryptoTools.getIC(arr);
		System.out.println(ic);
	}

}
