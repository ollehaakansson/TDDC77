package Lab4_komposition;

public interface Operation {
	
	public char symbol();
	
	public int width(int rows, int cols);
	
	public double evaluate(int a, int b);

}
