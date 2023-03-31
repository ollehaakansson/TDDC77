package Lab4_komposition;

public class ArithemicTable {
	// Deklarerar var
	private double[][] xy;
	public double r,c;
	private int space;
	private char choice;
	Operation op;
	
	public ArithemicTable(Operation op, int r, int c) {
		// Instanserar var
		this.op = op;
		this.c = c;
		this.r = r;
		choice = op.symbol();
		space = (op.width(r, c) + 2);
		xy = (new double[r][c]);
		
		// Fyller våra 2d array med värden
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j ++) {
				xy[i][j] = op.evaluate(i, j);
			}
		}
	}
	public void print() {
		String tecken = String.valueOf(choice);
		System.out.println();
			
		System.out.print("  " + tecken + " |");
		
		for(int i = 0; i < c; i++) {
			System.out.print(String.format("%" + space + "d", i));
		}
		
		System.out.println();
		System.out.print("----+--");
		
		for(int i = 0; i < (c*space); i++) {
			System.out.print("-");
		}
		System.out.println();
		
		for(int i = 0; i < r; i++) {
			System.out.printf("%3d |", i);
			
			for(int j = 0; j < c; j++) {
				if(tecken.equals("/")) {
					String output = (String.format("%.1f", xy[i][j]));
					System.out.printf("%" + space + "s", output);
				}else {
					String output = (String.format("%.0f", xy[i][j]));
					System.out.printf("%" + space + "s", output);
				}
				
				}	
			System.out.println();
		}
	
	}
	
}
