package JavaTester;

import java.util.Scanner;

public class Topic_08_Exercise_Operator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    String P1;
	    int age;
		
    // Su dung nextline de nhap du lieu kieu string
	    P1 = scanner.nextLine();
	  //Su dung nextInt de nhap so nguyen: 
	    age = scanner.nextInt();
  
	  //Su dung nextFloat de nhap kieu so thuc
	    System.out.println("After 15 years, age of " + P1 + "will be" + (age +15));
	    
	    
	    //Cho 2 bien so nguyen a va b viet chuong trinh hoan doi gia trij cua bien a va bien b
	    int a, b;
	a = scanner.nextInt();
	b = scanner.nextInt();
	a = a + b;
	b= a - b;
	a= a - b;
	System.out.println("a="+a);
	System.out.println("b="+b);
	
	// Cho hai bien a va b kieu so nguyen, viet chuong trinh hien ti ra man hinh a lon hon b nguoc lai hien thi false
	int x, y;
	x= scanner.nextInt();
	y= scanner.nextInt();
	if (x > y) {
	
	System.out.println("True");
	    
	}
	else 
		System.out.println("False");
	}
	
	
	

}
