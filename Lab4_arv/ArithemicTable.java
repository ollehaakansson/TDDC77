package Lab4_arv;

public class ArithemicTable {
	
	private double[][] xy;
	private double op;
	private int mellanrum;
	private char vald;
	private double maxTal;
	private int maxTalLangd;

	
	public ArithemicTable(int storlek, char val) {
		setOp(storlek);
		xy = (new double[storlek][(storlek+1)]);
		vald = val;
		
		if(vald == '*') {
			maxTal = (storlek * (storlek+1));
		}else if(vald == '+') {
			maxTal = 2 * storlek + 1;
		}else{
			maxTal = storlek;
		}
		
		maxTalLangd = (String.valueOf(maxTal)).length();
		
		mellanrum = maxTalLangd + 1;
		
		if(vald == '/') {
			mellanrum = mellanrum + 2 ;
		}
		
	}
	public void print() {
		String tecken = String.valueOf(vald);
		System.out.println();
			
		System.out.print("  " + tecken + " |");
			
		
		for(int i = 0; i < getOp(); i++) {
			System.out.print(String.format("%" + mellanrum + "d", i));
		}
		
		System.out.println();
		System.out.print("----+--");
		
		for(int i = 0; i < (getOp()*mellanrum); i++) {
			System.out.print("-");
		}
		System.out.println();
		
		for(int i = 0; i < getOp()+1; i++) {
			System.out.printf("%3d |", i);
			
			for(int j = 0; j < getOp(); j++) {
				if(tecken.equals("/")) {
					String output = (String.format("%.1f", getXy()[j][i]));
					System.out.printf("%" + mellanrum + "s", output);
				}else {
					String output = (String.format("%.0f", getXy()[j][i]));
					System.out.printf("%" + mellanrum + "s", output);
				}
				
				}	
			System.out.println();
		}
		
	}
	public double getOp() {
		return op;
	}
	public void setOp(double op) {
		this.op = op;
	}
	public double[][] getXy() {
		return xy;
	}
	public void setXy(int x, int y, double result) {
		this.xy[x][y] = result;
	}

}
