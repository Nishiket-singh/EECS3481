package hash;

import java.math.BigInteger;

public class Hash2 {

	public static void main(String[] args)
	{
		BigInteger one = BigInteger.ONE;
		BigInteger nA = new BigInteger("171024704183616109700818066925197841516671277");
		BigInteger eA = new BigInteger("1571");
		
		BigInteger pB = new BigInteger("98763457697834568934613");
		BigInteger qB = new BigInteger("8495789457893457345793");
		BigInteger eB = new BigInteger("87697");
		
		//RSA = pt.modPow(e,n)
		
		// m: Message
		// s: Message signed with dA
				
		//mCT: m encrypted with eB
		//sCT: s encrypted with eB
		BigInteger mCT = new BigInteger("418726553997094258577980055061305150940547956");
		BigInteger sCT = new BigInteger("749142649641548101520133634736865752883277237");

		//Find Bob's Private Key dB
		BigInteger nB = pB.multiply(qB);
		BigInteger phiB = (pB.subtract(one)).multiply(qB.subtract(one));
		BigInteger dB = eB.modInverse(phiB);
		
		BigInteger m = mCT.modPow(dB, nB);
		BigInteger s = sCT.modPow(dB, nB);
		
		BigInteger mFromS = s.modPow(eA, nA);
		
		// True if m from mCT is equal to the message encrypted with signature.
		// Ensures content is intact, even if message is not English (Software Download)
		System.out.println(m.equals(mFromS));		
	}
}
