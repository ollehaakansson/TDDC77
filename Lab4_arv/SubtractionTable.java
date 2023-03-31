package Lab4_arv;

public class SubtractionTable extends ArithemicTable{
	
	SubtractionTable(int storlek) {
		super(storlek,'-');
		
		for(int i = 0; i < (getOp() + 1); i++) {
			
			for(int a = 0; a < getOp(); a++) {
				
				double result = a-i;
				setXy(a, i, result);
			}
			
		}
		
	}

}
