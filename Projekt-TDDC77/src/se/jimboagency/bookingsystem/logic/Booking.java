package se.jimboagency.bookingsystem.logic;

import java.util.Map;
import java.util.Set;

public abstract class Booking {
	
	private String bookingNumber;
	private int week, year;
	private boolean updateable;
	private Flight flight;
	
	public abstract boolean isUpdatable();
	
	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public Booking(String bookingNumber, Flight flight, int week, int year, boolean updateable) {
		this.flight = flight;
		this.bookingNumber = bookingNumber;
		this.updateable = updateable;
		this.week = week;
		this.year = year;
	}
	
	public String toString() {
		String[] flightInfo = getFlight().toString().split(",");
		String data = flightInfo[0];
		String data1 = flightInfo[1];
		String bookingInfo = (bookingNumber + " - " + data + " - V" + getWeek() + " - " + getYear() + " - " + data1);
		
		return bookingInfo;
	}
	
	public boolean isUpd() {
		return updateable;
	}
	
	public boolean isUpdateable() {
		return updateable;
	}

	public void setUpdateable(boolean updateable) {
		this.updateable = updateable;
	}
	
	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
}
