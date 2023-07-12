package JavaTester;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_13_Switch_Case_Exercise {
	Scanner scanner=new Scanner(System.in);
//	@Test
//	public void TC_01(){
//		
//		//Viet chuong trinh in ra ten cac chu so nhap vao bang tieng anh
//		int number;
//		number=scanner.nextInt();
//		switch(number){
//		case 1: System.out.println("One");
//		break;
//		case 2: System.out.println("Two");
//		break;
//		case 3: System.out.println("Three");
//		break;
//		case 4: System.out.println("Four");
//		break;
//		case 5: System.out.println("Five");
//		break;
//		case 6: System.out.println("Six");
//		break;
//		case 7: System.out.println("Seven");
//		break;
//		case 8: System.out.println("Eight");
//		break;
//		case 9: System.out.println("Nine");
//		break;
//		case 10: System.out.println("Ten");
//		break;
//		}
//		}
//		@Test
//		public void TC_02(){
//			
//			//Nhap vao hai so nguyen a va b vap vao phep toan +,-,*,/,%, thuc hien tinh toan
//			int a,b;
//			a=scanner.nextInt();
//			b=scanner.nextInt();
//			String operator=scanner.next();
//			
//			System.out.println(a);
//			System.out.println(b);
//			System.out.println(operator);
//			switch (operator) {
//			case "+":
//				System.out.println("A+B= "+ (a+b));
//				break;
//			case"-":
//				System.out.println("A-B= "+ (a-b));
//				break;
//			case"*":
//				System.out.println("A*B= "+ (a*b));
//				break;
//			case "/":
//				System.out.println("A/B= "+ (a/b));
//				break;
//			case "%":
//				System.out.println("A%B= "+ (a%b));
//				break;
//				}
//			}
			@Test
			public void TC_03(){
				
				//Nhap vao mot thang va hien thi so ngay cua thang do
				int month;
				month=scanner.nextInt();
				switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					System.out.println("thang co 31 ngay ");
					break;
				case 2:
					System.out.println("thang co 28 ngay");
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					System.out.println("thang co 30 ngay");
					break;
					default:
					System.out.println("thang vua nhap sai dinh dang");
					break;
				}
				
		}
}
