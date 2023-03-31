package Lab4_arv;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int storlek;
		char val;
		boolean nörd = true;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Vänligen välj antal rader på x-axeln (max 10st): ");
		storlek = input.nextInt();
		
		Scanner input1 = new Scanner(System.in);
		System.out.print("Vänligen välj operator (+,-,/,*): ");
		val = input1.next().charAt(0);
	
		
		
		while(nörd) {
			switch(val) {
			
			case '*': 
				ArithemicTable ArTab = new MultiplicationTable(storlek);
				ArTab.print();
				nörd = false;
				break;
				
			case '+':
				ArithemicTable ArTab1 = new AdditionTable(storlek);
				ArTab1.print();
				nörd = false;
				break;
				
			case '/':
				ArithemicTable ArTab2 = new DivisionTable(storlek);
				ArTab2.print();
				nörd = false;
				break;
				
			case '-':
				ArithemicTable ArTab3 = new SubtractionTable(storlek);
				ArTab3.print();
				nörd = false;
				break;
				
			default:
				Scanner input2 = new Scanner(System.in);
				System.out.print("Vänligen välj operator (+,-,/,*): ");
				val = input2.next().charAt(0);
			}
		}
		
	}

}
