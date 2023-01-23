package hash;

import java.security.MessageDigest;

import util.CryptoTools;

public class Q3_HMAC {
	
	static int blockSize = 64; //64 bytes for SHA-1
	static MessageDigest md;
	
	public static void main(String[] args) throws Exception
	{
		byte[] m = "Mainly cloudy with 40 percent chance of showers".getBytes();
		byte[] k = "This is an ultra-secret key".getBytes();
		
		String opad1 = "5c";
		String ipad1 = "36";
		
		byte[] hmac1 = HMAC(m, k, opad1, ipad1);
		System.out.println(new String(CryptoTools.bytesToHex(hmac1)));
		
		String opad2 = "36";
		String ipad2 = "5c";
		
		byte[] hmac2 = HMAC(m, k, opad2, ipad2);
		System.out.println(new String(CryptoTools.bytesToHex(hmac2)));	
	}
	
	public static byte[] HMAC(byte[] m, byte[] k, String opadString, String ipadString) throws Exception
	{
		//Repeat opad and ipad
		byte[] opad = new byte[blockSize];
		byte[] ipad = new byte[blockSize];
		for (int i = 0; i < blockSize; i++)
		{
			opad[i] = CryptoTools.hexToBytes(opadString)[0];
		}

		for (int i = 0; i < blockSize; i++)
		{
			ipad[i] = CryptoTools.hexToBytes(ipadString)[0];
		}
		
		//Resize K
		byte[] resizedK_opad = determineKey(k, opad);
		byte[] resizedK_ipad = determineKey(k, ipad);

		//Find xor values
		byte[] k_xor_opad = xor(resizedK_opad, opad);
		byte[] k_xor_ipad = xor(resizedK_ipad, ipad);
		
		byte[] rightSide = hashSHA1(concat(k_xor_ipad, m));
		byte[] result = hashSHA1(concat(k_xor_opad, rightSide));
		return result;
	}
	public static byte[] xor(byte[] a, byte[] b)
	{
		byte[] result = new byte[a.length];
		for (int i = 0; i < a.length; i++)
			result[i] = (byte) (a[i] ^ b[i]);
		return result;
	}
	public static byte[] determineKey(byte[] k, byte[] padding) throws Exception
	{
		if (k.length > blockSize) //Hash key to reduce size
		{
			k = hashSHA1(k);
		}
		
		if (k.length < blockSize) //Pad with 0's to make block size
		{
			byte[] newK = new byte[blockSize];
			for(int i = 0; i < k.length; i++)
				newK[i] = k[i];
			return newK;
		}
		return k;
	}
	
	public static byte[] concat(byte[] a, byte[] b) throws Exception
	{
		byte[] c = new byte[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}
	public static byte[] hashSHA1(byte[] input) throws Exception
	{
		md = MessageDigest.getInstance("SHA-1");
		byte[] hash = md.digest(input);
		return hash;
	}
	
	
}
