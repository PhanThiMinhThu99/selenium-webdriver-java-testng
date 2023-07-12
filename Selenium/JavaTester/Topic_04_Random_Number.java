package JavaTester;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_04_Random_Number {

	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(rand.nextInt(99999));
	}

}
