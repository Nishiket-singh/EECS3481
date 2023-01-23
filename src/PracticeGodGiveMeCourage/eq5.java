package PracticeGodGiveMeCourage;

import java.math.BigInteger;

import util.CryptoTools;

public class eq5 {
	public static void main(String[]args) throws Exception {
		BigInteger p = new BigInteger("341769842231234673709819975074677605139");
		BigInteger g = new BigInteger("37186859139075205179672162892481226795");
		BigInteger aX = new BigInteger("83986164647417479907629397738411168307");
		BigInteger bX = new BigInteger("140479748264028247931575653178988397140");
		
		BigInteger aY = g.modPow(aX, p);
		
		BigInteger Key = aY.modPow(bX, p);
		
		byte [] sKey = Key.toByteArray();
		
		/*
		 * byte[] key = new byte[8]; for (int i = 0; i < 8; i++){ key[i] = sKey[i]; }
		 */
		
		System.out.println(CryptoTools.bytesToHex(sKey));
		
		//Let's suppose Alice, Bob, and Charlie generate keys a, b, and c respectively. We have some base g and some prime modulus p. Each of the 3 raises the base g to their exponent (in the eyes of p), giving Alice g^a % p, Bob g^b % p, and Charlie g^c % p. They each send their message to one of the other people (i.e. Alice to Bob, Bob to Charlie, and Charlie to Alice) and they raise that message to their exponent (Alice will have g^ca % p, Bob will have g^ab % p, Charlie will have g^bc % p). They pass this result once more to the same person they sent the first message to, and raise that to their exponent. This will give them all the same key "g^abc % p", thus 6 messages total (2 per person) would need to be sent.
		//eq4
		
		
	}
}
