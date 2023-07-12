package JavaTester;

public class Topic_15_While_Do_While {
	public static void main(String[]args) {
  int i=0;
  for (i=0;i<5;i++) {
	  System.out.println("For: "+ i);
  }
  System.out.println("Bien i sau khi done vong for: "+i);
  while (i<5) {
	  
	System.out.println("While: "+i);
	i++;
	if (i==3) {
		break;
	}
}
  //Chay it nhat 1 lan roi moi kiem tra dieu kien
  do {
	  System.out.println("Do_While: " + i);
	  i++;
	
} while (i<5);
}
	}
	