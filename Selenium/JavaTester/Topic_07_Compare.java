package JavaTester;

public class Topic_07_Compare {
	int number= 8;
	
public static void main(String[] args) {
	//1 vung nho cho bien x
	int x = 5;
	
	//1 vung nho cho bien y
	
	int y = x; 
	System.out.println("x="+x);
	System.out.println("y="+y);
	
	y =10;
	System.out.println("x="+x);
	System.out.println("y="+y);
	
	Topic_07_Compare firstVariable =  new Topic_07_Compare();
	Topic_07_Compare secondVariable = firstVariable;
	
	System.out.println("number="+ firstVariable.number);
	System.out.println("number="+ secondVariable.number);
	
	secondVariable.number=15;
	System.out.println("number="+firstVariable.number);
	System.out.println("number="+secondVariable.number);
	
	  
	
	
}
}
