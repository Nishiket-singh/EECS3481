package Final;

import util.CryptoTools;

public class Q2 {
	
			public static void main(String[] args)
			{
				byte[] ky = "Go Leafs Go!!".getBytes();
				
				// Alice:
				byte[] pt = "Meet Wed@1:30".getBytes();
				byte[] ct = xor(pt, ky);
				
				// Bob:
				byte[] bk = xor(ct, ky);
				
				
				byte [] ct1 = CryptoTools.hexToBytes("2B52080947040046451912444402031F");
				byte [] ct2 = CryptoTools.hexToBytes("3A431308450F005D411441144C1E020A");
				
				byte [] m1xorm2 = xor(ct1,ct2);
				byte [] m1 = "bridge".getBytes();
				byte[] end = new byte[m1.length];
				
				for (int i = 0; i < m1.length; i++) {
					 end[i] = (byte) (m1[i] ^ m1xorm2[i]);
				}
				
				
				System.out.println(m1xorm2);
				
				String output = new String(end);
				System.out.print(output);
			}
			
			private static byte[] xor(byte[] a, byte[] b)
			{
				if (a.length != b.length) throw new RuntimeException("Diff sizes!!");
				byte[] result = new byte[a.length];
				for (int i = 0; i < a.length; i++) result[i] = (byte) (a[i] ^ b[i]);
				return result;
			}
		
	}


