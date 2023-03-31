package lab2;

import java.text.DecimalFormat;

public class Lab2upg6 {

	public static void main(String[] args) {
		
		double antOrd,antSki,avgOrd;
		double antBokTot = 0;
		char[] ski = {'@','!','.',',','?'};
		antOrd = args.length;
		antSki = antOrd - 1;
		
		
		for(int i = 0; i < antOrd; i++) {
	
			antBokTot = antBokTot += args[i].length();
		}
		
		// första for satsen är för att varje ord i arrayen ska kollas
		for(int i = 0; i < args.length; i++) {
			
			// denna är för att köra igenom varje bokstav i varje ord
			for(int a = 0; a < args[i].length(); a++) {
				
				// denna är för att kolla varje individuell bokstav mot varje specialltecken
				for(int o = 0; o < ski.length; o++) {
					
					if(args[i].charAt(a) == ski[o]) {
						antSki++;
						antBokTot--;
					}
				}
			}
		}
		
		// gör så att bara 2 decimaler tillåts att printas när man kallar på den
		DecimalFormat df = new DecimalFormat("0.00");
		
		avgOrd = antBokTot/antOrd;
		
		System.out.println("Antal ord: " + antOrd);
		System.out.println("Antal bokstäver: " + antBokTot);
		System.out.println("Antal skiljetecken: " + antSki);
		System.out.println("Medellängd på ord: " + df.format(avgOrd));

		/* Systemet ska kunna skilja på tecken & bokstäver.
		 * Kolla på javadocs om det finns någon funktion som jämför om två olika strings har samma tecken i sig
		 */
		
	}
	
}
