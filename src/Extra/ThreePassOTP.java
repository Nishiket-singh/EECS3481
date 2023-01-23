package Extra;

import util.CryptoTools;

public class ThreePassOTP {

	public static void main(String[] args) {
		byte[] alice1 = CryptoTools.hexToBytes("0A4F0C08003503492F247442105B5757");
		byte[] bob = CryptoTools.hexToBytes("5E2769286B507A69494B066252343579");
		byte[] alice2 = CryptoTools.hexToBytes("170708454B1116002A2E2111725F5000");

		byte[] bobKey = new byte[bob.length];

		for (int i = 0; i < bob.length; i++) {
			bobKey[i] = (byte) (alice1[i] ^ bob[i]);
		}

		byte[] pt = new byte[bob.length];

		for (int i = 0; i < bob.length; i++) {
			pt[i] = (byte) (alice2[i] ^ bobKey[i]);
		}
		
		for (byte p: pt) System.out.print((char) p);
	}

}
