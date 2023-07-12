package JavaTester;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_14_For_ForEach_Exercise {


@Test
public void TC_01_For(){
//	for (int i=0;i<10; i++) {
//		System.out.println(i);
//	}

//Array
String[] cityName = {"Ha Noi","Ho Chi Minh","Da Nang","Can Tho"};
//Apply for Array/Set/Queue(index)
//For ket howp voi if: Thao man dieu kien moi action

for (int i= 0; i < cityName.length; i++){
System.out.println(cityName[i]);

}
//Bieen ddeem dung dieu kieenj de filter
for (int i=0; i<cityName.length;i++) {
	if (cityName[i].equals("Da Nang")){
			//action
			System.out.println("Do action");
			break;
}}
 
//Dung de chay qua het tat ca gia tri
}
@Test
public void TC_02_For_each(){
//	String[] cityName= {"Ha Noi","Ho Chi Minh","Da Nang","Can Tho"};
//		for (String city:cityName) {
//			System.out.println(city);
//		}
		
		//Array
		String[] cityName= {"Ha Noi","Ho Chi Minh","Da Nang","Can Tho","Hai Phong","Khanh Hoa"};
		//Java Collection
		// Class: ArrayList/LinkedList/Vector,...
		//Interface: list/Set/Queue
		List<String> cityAddress= new ArrayList<String>();
		System.out.println(cityAddress.size());
		
		//Compile (Coding)
		cityAddress.add("Bac Giang");
		cityAddress.add("Ha Giang");
		cityAddress.add("Sa Pa");
		
		System.out.println(cityAddress.size());
		
		// Runtime (Running)
		for (String city: cityName) {
			cityAddress.add(city);
			
		}
		System.out.println(cityAddress.size());
		for (String cityAdd: cityAddress) {
			System.out.println(cityAdd);
		}
		//Java Generic
		
		
	}




} 
