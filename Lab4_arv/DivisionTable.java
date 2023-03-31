package Lab4_arv;

public class DivisionTable extends ArithemicTable{
	
	DivisionTable(int storlek) {
		super(storlek,'/');
		
		for(int i = 0; i < (getOp() + 1); i++) {
			
			for(int a = 0; a < getOp(); a++) {
				
				if(i==0) {
					double result = 0;
					setXy(a, i, result);
				}else {
					double result = (double)a/(double)i;
					setXy(a, i, result);
				}
				
			}
			
		}
		
	}

}
