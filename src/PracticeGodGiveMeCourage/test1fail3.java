package PracticeGodGiveMeCourage;

import util.CryptoTools;

public class test1fail3 {
	public static void main(String[] args) throws Exception{
		
		byte [] ct = CryptoTools.hexToBytes("25C2CBDBF2F7FB05");
		byte [] pt = "INFORMAL".getBytes();
		byte [] pt2 = "INFORMAL".getBytes();
		byte [] iv2 = pt;
		
		byte[] end = new byte[ct.length];
		for (int i = 0; i < ct.length; i++) {
			end[i] = (byte) (pt[i] ^ ct[i]);
		}
		
		System.out.println(CryptoTools.bytesToHex(end));
	}
	}
