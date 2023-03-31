package Lab4_komposition;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int rows,cols;
		char choice;
		boolean nerd = true;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Vänligen välj antal rader på x-axeln: ");
		cols = input.nextInt();
		
		Scanner input1 = new Scanner(System.in);
		System.out.print("Vänligen välj antal rader på y-axeln: ");
		rows = input1.nextInt();
		
		Scanner input2 = new Scanner(System.in);
		System.out.print("Vänligen välj operator (+,-,/,*): ");
		choice = input2.next().charAt(0);
	
	
		
		while(nerd) {
			switch(choice) {
			
			case '*': 
				ArithemicTable ArTab = new ArithemicTable(EnumOperation.MULTIPLICATION, rows, cols);
				ArTab.print();
				nerd = false;
				break;
				
			case '+':
				ArithemicTable ArTab1 = new ArithemicTable(EnumOperation.ADDITION, rows, cols);
				ArTab1.print();
				nerd = false;
				break;
				
			case '/':
				ArithemicTable ArTab2 = new ArithemicTable(EnumOperation.DIVISION, rows, cols);
				ArTab2.print();
				nerd = false;
				break;
				
			case '-':
				ArithemicTable ArTab3 = new ArithemicTable(EnumOperation.SUBTRACTION, rows, cols);
				ArTab3.print();
				nerd = false;
				break;
				
			default:
				Scanner input3 = new Scanner(System.in);
				System.out.print("FEL! Vänligen välj operator igen (+,-,/,*): ");
				choice = input3.next().charAt(0);

		
				}

		}
		input.close();
		input1.close();
		input2.close();
		
	}
}

/*
Operation Multiplication = new Operation() {
	@Override
	public char symbol() {
		char tecken = '*';
		return tecken;
	}

	@Override
	public int width(int rows, int cols) {
		int bred = rows * cols;
		int längd = (String.valueOf(bred)).length();
		return längd;
	}

	@Override
	public double evaluate(int a, int b) {		
		return a*b;
	} 
};
		
Operation Addition = new Operation() {

	@Override
	public char symbol() {
		char tecken = '+';
		return tecken;
	}

	@Override
	public int width(int rows, int cols) {
		int bred = rows + cols;
		int längd = (String.valueOf(bred)).length();
		return längd;
	}

	@Override
	public double evaluate(int a, int b) {
		return a+b;
	}
};

Operation Division = new Operation() {
	@Override
	public char symbol() {
		char tecken = '/';
		return tecken;
	}

	@Override
	public int width(int rows, int cols) {
		int bred = rows;
		int längd = (String.valueOf(bred)).length();
		return längd;
	}

	@Override
	public double evaluate(int a, int b) {
		if(b==0) {
			return 0;
		}else {
			return (double)a/(double)b;
	}
}
};

Operation Subtraction = new Operation() {
	@Override
	public char symbol() {
		char tecken = '-';
		return tecken;
	}

	@Override
	public int width(int rows, int cols) {
		int bred = rows;
		int längd = (String.valueOf(bred)).length();
		return längd;
	}

	@Override
	public double evaluate(int a, int b) {
		return a-b;
		}
};
	*/