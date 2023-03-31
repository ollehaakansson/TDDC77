package se.jimboagency.bookingsystem.logic;

import java.util.Map;
import java.util.Set;

public class UnUpdateAbleBooking extends Booking {

	public UnUpdateAbleBooking(String bookingNumber, Flight flight, int week, int year, boolean updateable) {
		super(bookingNumber, flight, week, year, updateable);
	}

	public boolean isUpdatable() {
		return false;
	}
}
