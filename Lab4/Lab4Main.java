package Lab4;
import java.util.*;


public class Lab4Main {

	
	public static void main(String[] args) {
		
		int val;
		
		
		Scanner input = new Scanner(System.in);
		System.out.print("Vänligen välj antal rader på x-axeln (max 10st): ");
		val = input.nextInt(); 
		
		
		MultiplicationTable multi = new MultiplicationTable(val);
		multi.Print(val);
		



	}

}
