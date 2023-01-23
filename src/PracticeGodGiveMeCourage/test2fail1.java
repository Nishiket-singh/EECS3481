package PracticeGodGiveMeCourage;

import java.security.MessageDigest;
import util.CryptoTools;

public class test2fail1 {
	
	public static void main(String[] args) throws Exception{

	MessageDigest md = MessageDigest.getInstance("SHA1");
	String msg = "Maximum price is @@ plus tax";
	byte [] key = CryptoTools.hexToBytes("52456BAF456AB5555DEFA4");
	byte [] ymac = CryptoTools.hexToBytes("A500C1589108B7DED7B35C82DF0D141F4BC9FC65");
	for (int nn = 11; nn < 100; nn++)
	{
	String test = msg.replaceAll("@@", "" + nn);
	String kmk = key + CryptoTools.bytesToHex(test.getBytes()) + key;
	String hash = CryptoTools.bytesToHex(md.digest(CryptoTools.hexToBytes(kmk)));
	if (hash.equals(ymac)) 
		System.out.println(nn);
	}
	}
}
