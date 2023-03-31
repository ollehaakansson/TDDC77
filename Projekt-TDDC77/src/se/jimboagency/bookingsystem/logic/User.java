package se.jimboagency.bookingsystem.logic;
import java.util.ArrayList;

import se.jimboagency.bookingsystem.ui.*;

public class User {
	
	private String inp1;
	private String inp2;
	
	public User(String inp1, String inp2) { 
		this.inp1 = inp1;
		this.inp2 = inp2;
	}
	
	public boolean equals (ArrayList<User> users) {
		
		for (int i = 0; i < users.size(); i++) {
	
			if((this.toString().equals((users.get(i).toString())))) {
				return true;
			}
		}
		return false;
	}
	
	public String toString () {
		
		return (this.inp1 + " " + this.inp2);
		
	}
	

	
}
