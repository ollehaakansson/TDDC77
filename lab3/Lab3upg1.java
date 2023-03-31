package lab3;
import java.util.Scanner;
import java.util.*;
import java.text.DecimalFormat;

public class Lab3upg1 {

	public static void main(String[] args) {

		//deklarerar variabler
		String val;
		double tal1,tal2;
		boolean nörd = true;
		DecimalFormat df = new DecimalFormat("0.00");

		
		// vi skriver detta för att "länka" main mot vår andra klass "Calculator". Behöver användas när vi ska anropa från primärminnet
		Calculator calc = new Calculator();
		
		
		// inmatning
		while(nörd) {
		  Scanner input1 = new Scanner(System.in);
		  System.out.print("Välj mellan: Plus, Minus, Multiply, Divide: ");
		  val = input1.next();
		  
		  if(val.equals("x") || val.equals("X")) {
			  System.out.println("Dem senaste resultaten är: " + Arrays.toString(calc.getMemory()));
			  nörd = false;
			  break;
		  }else {
			  
			  Scanner input2 = new Scanner(System.in);
			  System.out.print("Välj en siffra: ");
			  tal1 = input1.nextDouble();
			  
			  Scanner input3 = new Scanner(System.in);
			  System.out.print("Välj en siffra: ");
			  tal2 = input3.nextDouble();
			  
			//Vi använder switch här istället för if satser pga det är 4st val som användaren kan göra. 
		switch(val){
		
		case "Plus", "plus", "+":
			System.out.println("Resultat: " + df.format(calc.add(tal1,tal2)));
		System.out.println("==================================");
			break;
			
		case "Minus", "minus", "-":
			System.out.println("Resultat: " + df.format(calc.minus(tal1,tal2)));
		System.out.println("==================================");
			break;
			
		case "Multiply", "multiply", "*":
			System.out.println("Resultat: " + df.format(calc.multiply(tal1,tal2)));
		System.out.println("==================================");
			break;
			
		case "Divide", "divide", "/":
			System.out.println("Resultat: " + df.format(calc.divide(tal1,tal2)));
		System.out.println("==================================");
			break;
			
		default:
			nörd = false;
			break;
			
			
			
					}
		  		}
		
			}
		
		}

	}

