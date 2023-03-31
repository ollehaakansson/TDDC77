package lab2;
import java.util.Scanner;

public class Lab2upg4 {

  public static void main(String[] args){
	
	  //deklaration
	  double bas,höjd,radie;
	  
	  //Inmatning av bas & höjd & radie
	  Scanner input1 = new Scanner(System.in);
	  System.out.print("Vänligen ange basen på triangeln: ");
	  bas = input1.nextDouble();
	  
	  
	  Scanner input2 = new Scanner(System.in);
	  System.out.print("Vänligen ange höjden på triangeln: ");
	  höjd = input2.nextDouble();
	  
	  
	  Scanner input3 = new Scanner(System.in);
	  System.out.print("Vänligen ange radien på cirkeln: ");
	  radie = input3.nextDouble();
	  
	  input1.close();
	  input2.close();
	  input3.close();
	  
	  //Beräkning
	  double areaTri = (bas*höjd)/2;
	  double areaCir = 2*radie*Math.PI;
	  
	  //Utmatning
	  
	  System.out.println("Arean av din triangel är: " + areaTri + " cm²");
	  System.out.println("Arean av din cirkel är: " + areaCir + " cm²");
	  
	  
  	}
  }