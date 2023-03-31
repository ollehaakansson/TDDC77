package se.jimboagency.bookingsystem.logic;

import java.util.Map;
import java.util.Set;

public class UpdateAbleBooking extends Booking {
	
	public UpdateAbleBooking(String bookingNumber, Flight flight, int week, int year, boolean updateable) {
		super(bookingNumber, flight, week, year, updateable);
	}
	
	public boolean isUpdatable() {
		return true;
}

}
