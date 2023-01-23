package symmetric;

public class ActivityBcq1 {
	public static void main(String[] args) throws Exception {
		// question 1a)
		byte[] pt = "SENDMOREMONEY".getBytes();
		byte[] key = "JABHXPVOLLCIJ".getBytes();
		byte[] ct = new byte[pt.length];
		for(int i = 0; i < pt.length; i++) {
			ct[i] = (byte)(((pt[i] - 'A') + key[i]) % 26 + 'A');
			System.out.print((char)ct[i]);
		}
	}
}
