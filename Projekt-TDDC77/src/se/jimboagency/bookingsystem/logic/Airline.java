package se.jimboagency.bookingsystem.logic;

import java.util.ArrayList;

public class Airline {

	private String airlineName;
	
	public Airline(String airlineName) {
		this.airlineName = airlineName;
	}
	
	public boolean equals(ArrayList<Airline> airlines) {
		for(int i = 0; i < airlines.size(); i++) {
			if((this.toString().equals((airlines.get(i).toString())))) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return this.airlineName;
	}
	
	
	
	
	
//	String airline;
//	String[] airlines;
//	
//	// gör om till en airline mannen
//	public Airline(String airline) {
//		this.airline = airline;
//	}
//	
//	
//	//returnerar en boolean om stringen man skickat in är en airline eller ej
//	public boolean isAirline(String inp1) {
//		
//		for(int i = 0; i < airlines.length; i++) {
//			if(airlines[i].equals(inp1)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
}
