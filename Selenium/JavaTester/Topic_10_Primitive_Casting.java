package JavaTester;

public class Topic_10_Primitive_Casting {

	public static void main (String[]args) {
//		byte bNumber=126;
//		System.out.println(bNumber);
//		
//		short sNumber = bNumber;
//		System.out.println(sNumber);
//		
//		int iNumber = sNumber;
//		System.out.println(iNumber);
//		
//		long lNumber = iNumber;
//		System.out.println(lNumber);
//		
//		float fNumber = lNumber;
//		System.out.println(fNumber);
//		
//		double dNumber = fNumber;
//		System.out.println(dNumber);
//		
		//Tuong Minh (Cast)
		double dNumber = 65423d;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) fNumber;
		System.out.println(fNumber);
		
		int iNumber = (int) lNumber;
		System.out.println(iNumber);
		
		
		
	}
}
