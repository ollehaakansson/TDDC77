package lab2;
import java.util.Scanner;

public class Lab2upg5 {

  public static void main(String[] args){
	  
	  int svar,gissning;
	  int antal = 0;
	  boolean fel = true;
	  
	  Scanner input1 = new Scanner(System.in);
	  System.out.print("Spelare 1, Mata in ett heltal mellan 1-100: ");
	  svar = input1.nextInt();
	  
	  for(int i = 0; i < 20; i++){
		  System.out.println(" ");
		  }
	  
	  Scanner input2 = new Scanner(System.in);
	  System.out.print("Spelare 2, Gissa på ett heltal mellan 1-100: ");
	  gissning = input2.nextInt();
	  
	  
	  while(fel) {
		  antal++;
	  if (gissning > svar) {
		  System.out.print("FEEEEEEEL, FÖR STOOOR, GISSA IGEN: ");
		  gissning = input2.nextInt();
	  }else if (gissning < svar) {
		  System.out.print("FEEEEEEEL, FÖR litet, GISSA IGEN: ");
		  gissning = input2.nextInt();
	  }else {
		  System.out.println("Bra fucking jobbat, du behövde gissa " + antal + " gånger!");
		  fel = false;
	  }
	  }
	  
	  input1.close();
	  input2.close();
	  
  	}
  }