package JavaTester;

import org.testng.Assert;

public class Topic_09_Operator {

	public static void main(String[] args) {
		int number = 10;
		number += 5;
		System.out.println(number++);
		// In number ra truoc
		//++= tang number len 1
		
		System.out.println(++number);
		//++truoc: tang number len truoc len 1
		//In number ra
	    for (int i=0; i<3; ++i) {
	    	System.out.println(i);
	    }
	    Assert.assertTrue(5<6);
	    String address = "Ho Chi Minh";
	    
//	    if (address!= "Ha Noi") {
//	    	System.out.println("Address is not the same");
//	    }
	    
//	    if (address!= "Ha Noi"&& address != "Da Nang") {
//	    	System.out.println("Address is not the same");
//	    }
      if (address!= "Ha Noi"||address != "Da Nang") {
	System.out.println("Address is not the same");	    }
	
	if (address == "Ha Noi") {
		System.out.println("Address is not the same");
	}
	
// 15%/6 = 2 du 3
	System.out.println(number/6);
	System.out.println(number++);
	System.out.println(number--);
	
	}
}
