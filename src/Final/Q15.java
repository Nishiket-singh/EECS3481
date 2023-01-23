package Final;

import java.math.BigInteger;
import java.security.MessageDigest;

import util.CryptoTools;


public class Q15 {
	public static void main(String[] args) throws Exception {
		
		// DH modulus:
		BigInteger p = new BigInteger("133717718270293296200188525502739327388353629179621058494112854251193809058703");
		// DH primitive root:
		BigInteger g = new BigInteger("88653877561129476419831247959360597000469401190192885546499619313456391487");
		// Alice's DH private key:
		BigInteger aX = new BigInteger("40946114960323376780632697114159865026104715183899616608412774756574256842942");
		// Bob's DH public key:
		BigInteger bY = new BigInteger("66084206540781068627271629211666577778562915982852519047450133068281295962922");
		
		byte[] ct = CryptoTools.hexToBytes("46ECC6540D13291E1C6D97277597423F40EE73C6FE179DEBDB40B6CB7A0C973E");
		
		//KeyDH they agreed upon
		BigInteger keyDH = bY.modPow(aX, p);
		
		//No way to retrieve KeyAES
		//No way to decipher ct without KeyAES
		
		
		
		
	}

}
