package Lab4_komposition;

public enum EnumOperation implements Operation{
	
	MULTIPLICATION('*'){
		//Bestämmer bredden på våran största siffra så att vi kan använda korrekta mellanrummet mellan siffror
		public int width(int rows, int cols) {
			int numWidth = rows * cols;
			int numLength = (String.valueOf(numWidth)).length();
			return numLength;
		}
		//Bestämmer värdet
		public double evaluate(int a, int b) {
			return a*b;
			}
		
	}, 
	ADDITION('+'){
		//Bestämmer bredden på våran största siffra så att vi kan använda korrekta mellanrummet mellan siffror
		public int width(int rows, int cols) {
			int numWidth = rows + cols;
			int numLength = (String.valueOf(numWidth)).length();
			return numLength;		
			}
		//Bestämmer värdet
		public double evaluate(int a, int b) {
			return a+b;		
			}
		
	}, 
	SUBTRACTION('-'){
		//Bestämmer bredden på våran största siffra så att vi kan använda korrekta mellanrummet mellan siffror
		public int width(int rows, int cols) {
			int numWidth = rows;
			int numLength = (String.valueOf(numWidth)).length();
			return numLength;	
			}
		//Bestämmer värdet
		public double evaluate(int a, int b) {
			return a-b;		
			}
	}, 
	DIVISION('/'){
		//Bestämmer bredden på våran största siffra så att vi kan använda korrekta mellanrummet mellan siffror
		public int width(int rows, int cols) {
			int numWidth = rows;
			int numLength = ((String.valueOf(numWidth)).length() + 3);
			return numLength;
		}
		//Bestämmer värdet
		public double evaluate(int a, int b) {
			if(b==0) {
				return 0;
			}else {
				return (double)a/(double)b;
			}
		}
	};
	
	private final char symbol;

	private EnumOperation(char c) {
		this.symbol = c;
	}

	public char symbol() {
		return symbol;
	}


}
