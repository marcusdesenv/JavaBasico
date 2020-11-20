package br.com;
/**
 * 
 */

/**
 * @author marcu
 *
 */
public class WrappersJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		Integer wrapperInt = Integer.valueOf(3);
		float f = 3.4f;
		Float wrapperFloat = Float.valueOf(f);
		char c = 'c';
		Character wrapperChar = Character.valueOf(c);
		byte b = 32;
		Byte wrapperByte = Byte.valueOf(b);
		long l = 34433L;
		Long wrapperLong = Long.valueOf(l);
		short s = 12;
		Short wrapperShort  = Short.valueOf(s);
		double d = 12.3;
		Double wrapperDouble = Double.valueOf(d);
		boolean bol = false;
		Boolean wrapperBoolean = Boolean.valueOf(bol);
	}

}
