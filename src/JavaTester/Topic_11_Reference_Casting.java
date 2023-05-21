package JavaTester;

public class Topic_11_Reference_Casting {

	public String studentName;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName (String studentName) {
		this.studentName = studentName;
	}
	public void showStudentName() {
		System.out.println("Student name=" + studentName);
	}

	public static void main(String[] args) {
		
		Topic_11_Reference_Casting firstStudent = new Topic_11_Reference_Casting();

		Topic_11_Reference_Casting secondStudent = new Topic_11_Reference_Casting();
		
		firstStudent.setStudentName("Phan Thi Minh Thu");
		secondStudent.setStudentName("Phan Thu");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		//Ep kieuer
		firstStudent = secondStudent;
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		secondStudent.setStudentName("Le Phan");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
	
	}
}
