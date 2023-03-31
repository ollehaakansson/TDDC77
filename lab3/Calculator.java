package lab3;
import java.util.Arrays;
import java.util.*;


public class Calculator {
	
	ArrayList<Double> mem = new ArrayList<Double>();

	
	public double add (double op1, double op2) {
		double result = op1 + op2;
		addToMemory(result);
		return result;
	}
	public double minus (double op1, double op2) {
		double result = op1 - op2;
		addToMemory(result);
		return result;
	}
	public double multiply (double op1, double op2) {
		double result = (op1 * op2);
		addToMemory(result);
		return result;
	}
	public double divide (double op1, double op2) {

		double result = (op1 / op2);
		addToMemory(result);
		return result;
	}
	
	public void addToMemory (double memory) {
		mem.add(memory);
	}
	
	public double[] getMemory () {
		
		int i = 0;
		double[] getMem = new double[mem.size()];
		
		while(i < mem.size()) {
			getMem[i] = mem.get(i);
			
			i++;
		}
		
	return getMem;
	}
	
}
