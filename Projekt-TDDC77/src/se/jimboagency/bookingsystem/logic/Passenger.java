package se.jimboagency.bookingsystem.logic;

public class Passenger {
	
	private String name, id;
	
	public Passenger(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String toString() {
		return this.name + " " + this.id;
	}
}
