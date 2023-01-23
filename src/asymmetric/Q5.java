package asymmetric;

import java.math.BigInteger;

import util.CryptoTools;

public class Q5 {

	public static void main(String[] args)
	{
		BigInteger p = new BigInteger("341769842231234673709819975074677605139"); //p
		BigInteger g = new BigInteger("37186859139075205179672162892481226795"); // alpha
		BigInteger aX = new BigInteger("83986164647417479907629397738411168307"); //a
		BigInteger bX = new BigInteger("140479748264028247931575653178988397140"); //b 
		
		//session key is:
		// B = alpha^b, A = alpha^a
		// session key: B^a or A^b
		
		//compute A 
		BigInteger A = g.modPow(aX, p);
		BigInteger B = g.modPow(bX, p);
		
		//session key
		// B^a
		
		BigInteger sessionKey = B.modPow(aX, p);
		
		System.out.println(CryptoTools.bytesToHex(sessionKey.toByteArray()));
		System.out.println("00C15A519D8BB2050044D9E7F9803CCF66");
		
		
		
		
		

	}

}
