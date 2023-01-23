package Final;
import java.math.BigInteger;

import util.CryptoTools;

public class Q4 {
	
	public static void main(String[] args) throws Exception {
		BigInteger n = new BigInteger("3771660537665364710755306279024836095493900640071426658950335383917887359113402700135658447922981150379");
		BigInteger e = new BigInteger("101");
		BigInteger d = new BigInteger("3510258322183606760504938420600694087788610867337878281227587986722021417671231183403413442265596214045");
		
		BigInteger two = new BigInteger("2");
		BigInteger four = new BigInteger("4");
		BigInteger ed =  e.multiply(d);
		
		BigInteger x = n.add(two);
		
		BigInteger y = x.subtract(ed);
		
		BigInteger ysqr = y.multiply(y);
		BigInteger fourn = n.multiply(four);
		BigInteger rot = ysqr.subtract(fourn);
		
		BigInteger sqrt = rot.sqrt();
		
		BigInteger p = y.subtract(sqrt);
		
		BigInteger last = p.divide(two);
		
		System.out.println(last);
		
		
		
	}

}
