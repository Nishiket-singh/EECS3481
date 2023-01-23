package Test2;

import java.math.BigInteger;

public class Q5 {

	public static void main(String[] args) throws Exception
	{
		BigInteger p = new BigInteger("270208816742950846165867774432236299371");
		BigInteger q = new BigInteger("212339076166563026994707591649705499891");
		BigInteger e = new BigInteger("1031");
		BigInteger ct = new BigInteger("127833752397689537730867232484673025344739353166885012630590181083225230237");
		BigInteger one = new BigInteger("1");
		
		// n = pq   ->   q = n/p
		BigInteger n = p.multiply(q);
		BigInteger pMinus1 = p.subtract(one);
		BigInteger qMinus1 = q.subtract(one);

		BigInteger phi = pMinus1.multiply(qMinus1);
		
		BigInteger d = e.modInverse(phi);
		BigInteger pt = ct.modPow(d, n);
		System.out.println(new String(pt.toByteArray())); //BigInteger -> byte[] -> String
	}
}