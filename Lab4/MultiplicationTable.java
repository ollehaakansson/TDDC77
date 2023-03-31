package Lab4;

public class MultiplicationTable {
	
	int[][] xy = new int[10][11];
	
	
	
	MultiplicationTable(int op) {
		
		
		for(int i = 0; i < (op + 1); i++) {
			
			for(int a = 0; a < op; a++) {
				
				xy[a][i] = a*i;
			}
			
		}
		
	}
	public void Print(int op) {
			
	
		System.out.print("  * |");
		
		for(int i = 0; i < op; i++) {
			System.out.print(String.format("%4d", i));
		}
		
		System.out.println();
		System.out.print("----+--");
		
		for(int i = 0; i < (op*4); i++) {
			System.out.print("-");
		}
		System.out.println();
		
		for(int i = 0; i < op+1; i++) {
			System.out.print(String.format("%3d |", i));
			
			for(int j = 0; j < op; j++) {
				System.out.print(String.format("%4d", xy[j][i]));
				
				}	
			System.out.println();
		}
		
	}
	
}
