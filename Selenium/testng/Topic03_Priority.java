package testng;

import org.testng.annotations.Test;

public class Topic03_Priority {
	//-priority //Vi testng uu tien chay tu 1-9 truoc a-z nen khi dat ten nen dat theo so de rox rang hon
	
	//-enabled// Neu muon skip testcase nao khong chay thi them tuw khoas "enabled=false"
	
	//-description// giups moo tar testcase rox rang hon va de tim de fix bug hown
  @Test (enabled=false)
  public void Enduser_01_Register_New_Employee() {
  }
  
  @Test(description = "JIRA_0789 - Create a new employee and verify the employee created success")
  public void Enduser_02_View_New_Employee() {
  }
  
  @Test(enabled=false)
  public void Enduser_03_Edit_New_Employee() {
  }
  
  @Test (enabled=false)
  public void Enduser_04_Move_New_Employee() {
  }
}
