package JavaTester;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_Data_Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// *CÁCH KHAI BÁO BIẾN:
		// 1- Kiểu dữ liệu của biến
		// 2- Tên biến
		// 3- Giá trị của biến
		// Có hai cách khai báo và gán giá trị 
		// Cách 1: Vừa khai báo vừa gán trực tiếp:
		// String name= "Auto test"
		
		//  Cách 2: Khai báo trước rồi gán sau
		// String name;
		// name = "Auto Test";
		
		
		
//2 loại kiểu dữ liệu
		//+Kiểu dữ liệu nguyên thuỷ:(Primitive) 8 loại
		//Số nguyên: byte/ short/ int/ long
		 byte bNumber = 5;
		 short sNumber = 500;
		 int iNumber = 6000;
		 long lNumber = 1234454545;
		// So thuc: Float/ double (so dang co phan thap phan)
		 float salary = 15.5f;
		 double salary1 = 20.2d;
		//Ký tự: Char
		  // Dùng dấu nháy đơn ''
		  // Chưa duy nhât 1 ký tự
		 char a = 'a';
		 
		// Logic: Boolean
		boolean marriedStatus = true;
		marriedStatus = false;
		
		
		//+ Kiểu dữ liệu tham chiếu:(Reference)
		// Chuoi: String (Chu/ so/ ky tu dac biet)
		// Dung dau nhay doi
		String emailInvalid = "minhthu@#$%.gmail.com";
		// Class/ interface (Datetime)
		Date date = new Date ();
		
		WebDriver driver = new FirefoxDriver();
		
		// Đối tượng: Object
		Object students;
		
		
		// Array: Mảng
		int numbers[] = {15, 20, 45};
		String addresses [] = {"Da Nang", "Ha Noi", "Sai Gon"};
		// List/ Set/ Queue (Collection)- Động
		List<Integer> studentNumber = new ArrayList <Integer>();
		List<String> studentAddress = new ArrayList <String>();
		Set<String> staudentCity =  new LinkedHashSet<String>();
		// Ví dụ:Tên (String), Tuổi ( int)/ Ngày tháng năm sinh (Class)/ Quê quán(String)/ lương (Float/Doble)/ Giới tính (Boolean)
		  
	}

}
