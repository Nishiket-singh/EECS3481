package asymmetric;

import java.math.BigInteger;

public class Q3 {

	public static void main(String[] args)
	{
		BigInteger phi = new BigInteger("8584037913642434144111279062847405921823163865842701785008602377400681495147541519557274092429073976252689387304835782258785521935078205581766754116919200");
		BigInteger q = new BigInteger("87020952829623092932322362936864583897972618059974315662422560067745889600571");
		BigInteger e = new BigInteger("65537");
		
		BigInteger c = new BigInteger("1817487313698347891034157970684926175211834109573277793102901854482611726141560963120214926234448852417078321539316776648109260519063106558303669880226359");
		BigInteger one = new BigInteger("1");
		
		// phi = (p-1)(q-1)    ->      p = phi / (q-1) + 1
		BigInteger q_1 = q.subtract(one);
		BigInteger p = (phi.divide(q_1)).add(one);
		
		BigInteger n = p.multiply(q);
		BigInteger d = e.modInverse(phi);
		BigInteger pt = c.modPow(d, n);
		System.out.println(new String(pt.toByteArray())); //BigInteger -> byte[] -> String
	}
	
}
