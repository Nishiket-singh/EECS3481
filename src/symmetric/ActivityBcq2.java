package symmetric;

import util.CryptoTools;

public class ActivityBcq2 {

	public static void main(String[] args) throws Exception{
		byte[] msg1 = CryptoTools.hexToBytes("0A4F0C08003503492F247442105B5757");
		byte[] msg2 = CryptoTools.hexToBytes("5E2769286B507A69494B066252343579");
		byte[] msg3 = CryptoTools.hexToBytes("170708454B1116002A2E2111725F5000");
		byte[] m = new byte[msg3.length];
		m = xor(msg3, msg2);
		m = xor(m, msg1);
		String output = new String(m);
		System.out.println(output);
		//Output = Come to LAS1002.

	}
	
	private static byte[] xor(byte[] a, byte[] b)
	{
		if (a.length != b.length) throw new RuntimeException("Diff sizes!!");
		byte[] result = new byte[a.length];
		for (int i = 0; i < a.length; i++) result[i] = (byte) (a[i] ^ b[i]);
		return result;
	}

}
