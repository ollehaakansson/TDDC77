package se.jimboagency.bookingsystem.logic;

import java.util.Map;
import java.util.Set;

public class Flight {
	
	private String flightNumber, depCity, depTime, depDay, arrCity, arrDay, airline, arrTime;
	private int numSeats;
	
//	String[] days = {"Monday","Tuesday","Wednesday","Thursday", "Friday", "Saturday", "Sunday"};
	
//	private Map<String, Flight> Flights;
	
	public Flight(String depCity, String depTime, String depDay, String arrCity, String arrDay, String airline, String flightNumber, int numSeats, String arrTime) {
		this.flightNumber = flightNumber;
		this.depCity = depCity;
		this.depTime = depTime;
		this.depDay = depDay;
		this.arrCity = arrCity;
		this.arrDay = arrDay;
		this.airline = airline;
		this.numSeats = numSeats;
		this.arrTime = arrTime;
	}
	
	public String toString() {
		
		String[] realArrTime = arrTime.split(":");
		
		//denna if-satsen ser till att tidsformatet blir korrekt
		if(Integer.valueOf(realArrTime[0]) < 10) {
			return flightNumber + " - " + depCity + "(" + depDay + ") - " 
					+ arrCity + "(" + arrDay + ")," + depTime + " - 0" + arrTime;
		}else {
			return flightNumber + " - " + depCity + "(" + depDay + ") - " 
					+ arrCity + "(" + arrDay + ")," + depTime + " - " + arrTime;
		}
		
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDepTime() {
		return depTime;
	}

	public String getArrCity() {
		return arrCity;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getDepDay() {
		return depDay;
	}

	public void setDepDay(String depDay) {
		this.depDay = depDay;
	}

	

}
