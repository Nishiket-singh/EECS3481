package asymmetric;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class Q6 {

	public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException 
	{
		// TODO Auto-generated method stub
		byte[] ct = CryptoTools.hexToBytes("B1803ED24B595CCB11AA39473DC7B10B");
		byte[] bobPrivate = CryptoTools.hexToBytes("3041020100301306072A8648CE3D020106082A8648CE3D0301070427302" + 
				"50201010420090145EB296FD96158EDF5E59D20EBB8E7332BBE150784D9190" + 
				"0DB2006980127");

		byte[] bobPublic = CryptoTools.hexToBytes("3059301306072A8648CE3D020106082A8648CE3D0301070342000467" + 
				"8DF0E72D7FC86006174E506B1729081E5D1201936EBA8A39E8741E4F713F8" + 
				"C29AE2E62038D95B36A585E2A87FEA73BE482611115457A3D3823EA5D79E" + 
				"31154");

		byte[] alicePrivate = CryptoTools.hexToBytes("3041020100301306072A8648CE3D020106082A8648CE3D0301" + 
				"070427302502010104200FE89D3070EECF985F971851B088EC976" + 
				"05A08D037F3CF3463FED25BCE0037B5");

		byte[] alicePublic = CryptoTools.hexToBytes("3059301306072A8648CE3D020106082A8648CE3D03010703" + 
				"42000450C35C2FB11926C2C91E089CFC743F9D942EE14B8D4" + 
				"2E25AE6588C4F93DDFF6ACDF520F74AF3E2500EF2A5E2C346" + 
				"D4DA7E92C1F89AD9FD4F3ED1B97DC3F39DC8");

		//read other pub key

		KeyFactory kf = KeyFactory.getInstance("EC");
		X509EncodedKeySpec pkSpec = new X509EncodedKeySpec(bobPublic);
		X509EncodedKeySpec pkSpec2 = new X509EncodedKeySpec(alicePublic);
		PublicKey bobPublicKey = kf.generatePublic(pkSpec);
		PublicKey alicePublicKey = kf.generatePublic(pkSpec2);
		
		PKCS8EncodedKeySpec pSpec2 = new PKCS8EncodedKeySpec(alicePrivate);
		PKCS8EncodedKeySpec pSpec = new PKCS8EncodedKeySpec(bobPrivate);
		PrivateKey bobPrivatekey = kf.generatePrivate(pSpec);		
		PrivateKey alicePrivatekey = kf.generatePrivate(pSpec2);
		
		
		KeyAgreement ka = KeyAgreement.getInstance("ECDH");
		ka.init(alicePrivatekey);
		ka.doPhase(bobPublicKey, true);
		
		
		byte[] shared_secret = ka.generateSecret();
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecretKeySpec secretKey = new SecretKeySpec(shared_secret, "AES");
		
		byte[] iv = CryptoTools.hexToBytes("4000000001000000000C00000001000C");
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey,ivSpec );
		
		byte[] pt = cipher.doFinal(ct);
		
		System.out.println(new String(pt));

		
		
	}

}
