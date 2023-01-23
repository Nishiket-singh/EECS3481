package hash;

import java.math.BigInteger;
import java.security.MessageDigest;

import util.CryptoTools;

public class Hash1 {

	public static void main(String[] args) throws Exception
	{
		BigInteger n = new BigInteger("94587468335128982981605019776781234618384857805657005686084562260910788622013722070926491690843853690071248130134427832324966728582532832363221542231787068203763027067400082835394459857525017707284768411819006776211493735326500782954621660256501187035611332577696332459049538105669711385995976912007767106063");
		BigInteger e = new BigInteger("74327");
		BigInteger d = new BigInteger("7289370196881601766768920490284861650464951706793000236386405648425161747775298344104658393385359209126267833888223695609366844098655240542152017354442883676634193191857568369042999854440242050353181703706753485749165295123694487676952198090537385200990850805837963871485320168470788328336240930212290450023");
		
		
		//Hash Message
		byte[] msg = "Meet me at 5 pm tomorrow".getBytes();
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		byte[] digest = md.digest(msg);
		
		//Encrypt Digest With Private Key d
		BigInteger hash = new BigInteger(digest);
		BigInteger signature = hash.modPow(e, n);
		
		//Alice receives signature and msg in clear
		//De-crypt to get digest
		BigInteger digestReceived = signature.modPow(d, n);
		
		//Alice hashes message herself
		byte[] digestCalculatedByAlice = md.digest(msg);
		//Compare with the hash she decrypted to verify message.
		System.out.println(CryptoTools.bytesToHex(digestReceived.toByteArray()).equals(CryptoTools.bytesToHex(digestCalculatedByAlice)));
	}
}
