package foundation;

import util.CryptoTools;

public class C_Encrypt {
	public static void main(String[] args) throws Exception {
		byte[] pt = CryptoTools.fileToBytes("data/MSG1.pt"); 
		byte[] clean = CryptoTools.clean(pt);
		CryptoTools.bytesToFile(clean, "data/MSG1.clean");
		int key = 19;
		byte[] ct = new byte[clean.length];
		for(int i = 0; i < clean.length; i++) {
			ct[i] = (byte) (((clean[i] - 'A') + key) % 26 + 'A');
		}
		CryptoTools.bytesToFile(ct, "data/MSG1.ct");
		System.out.println(CryptoTools.getMD5(ct));
		double IC = CryptoTools.getIC(clean);
		// I think the IC with be around 0.7 since it is a plain english text.
		System.out.println(IC);
		double ICct = CryptoTools.getIC(ct);
		System.out.println(ICct);
	}
} 