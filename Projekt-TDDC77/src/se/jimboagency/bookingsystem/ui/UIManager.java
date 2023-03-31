package se.jimboagency.bookingsystem.ui;
import se.jimboagency.bookingsystem.logic.*;
import se.jimboagency.bookingsystem.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UIManager {
	
	private char menuChoice;
	private Scanner input = new Scanner(System.in).useDelimiter("\n");
	private LogicManager logicManager;
	
	//alla booleans som vi använder i vår felhantering
	private boolean mismatch = true, mismatchNotANumber = true, menuActive = true;
	
	private boolean haveLoadedData = false;
	
	public UIManager (LogicManager logicManager) {
		this.logicManager = logicManager;
	}
	
	// Denna kommunicerar med logicmanager ifall en användare får logga in eller ej
	public void login(String[] args) {
		
		if(logicManager.authenticator()) {
			System.out.println("Login succesfull! \nWelcome to JIMBO!");
			mainMenu();
		}else {
			wrongLogin(); 
			}
	}
	
	public void mainMenu() {
		
//		System.out.println(logicManager.getDate() + " " + logicManager.getTime());
//		System.out.println(logicManager.getDayOfTheWeek());
//		System.out.println("Week: " + logicManager.getWeek());
	
		System.out.println("MAIN MENU");
		System.out.println("1) CMD1");
		System.out.println("2) Load data");
		System.out.println("0) Exit");
		System.out.print("Choose an option: ");
		
		menuChoice = input.next().charAt(0);
		
		while (menuActive) {
			switch(menuChoice) {
			
			case '1':
				CMD1();
				break;
				
			case '2':
				logicManager.loadData();
//				haveLoadedData = true;
				mainMenu();
				break;
				
			case '0':
				closeMenu();
				break;
				
			default:
				System.out.println("Error, no matching input!");
				System.out.print("Choose an option: ");
				menuChoice = input.next().charAt(0);
			}
		}
		
	}
	
	public void CMD1() {
		
		System.out.println("CMD1 MENU");
		System.out.println("1) Go Back to Main Menu");
		System.out.println("2) Flight Menu");
		System.out.println("3) Booking Menu");
		System.out.println("0) Exit");
		System.out.print("Choose an option: ");
		
		
		
		menuChoice = input.next().charAt(0);
		
		while (menuActive) {
			switch(menuChoice) {
			
			case '1':
				mainMenu();
				break;
			case '2':
				flightMenu();
				break;
			case '3':
				bookingMenu();
				break;
			case '0':
				closeMenu();
				break;
			default:
				System.out.println("Error, no matching input!");
				System.out.print("Choose an option: ");
				menuChoice = input.next().charAt(0);
			}
		}
	}
	
	public void flightMenu() {
		
		System.out.println("Flight Menu");
		System.out.println("1) Go back to main menu");
		System.out.println("2) Create a new flight");
		System.out.println("3) testflight");
		System.out.println("4) Remove flight");
		System.out.println("0) Exit");
		System.out.print("Choose an option: ");
		
		menuChoice = input.next().charAt(0);
		
		while (menuActive) {
			switch(menuChoice) {
			
			case '1':
				mainMenu();
				break;
			case '2':
				createFlight();
				break;
			case '3':
				testFlight();
				break;
			case '4':
				removeFlight();
				break;
			case'0':
				closeMenu();
				break;
			default:
				System.out.println("Error, no matching input!");
				System.out.print("Choose an option: ");
				menuChoice = input.next().charAt(0);
			} 
			
		}
		
	}
	
	public void bookingMenu() {
		System.out.println("Booking Menu");
		System.out.println("1) Go back to main menu");
		System.out.println("2) Search for boooking");
		System.out.println("3) Create a new booking");
		System.out.println("4) Update booking");
		System.out.println("5) Remove booking");
		System.out.println("6) test booking");
		System.out.println("0) Exit");
		System.out.print("Choose an option: ");
		
		menuChoice = input.next().charAt(0);
		
		while (menuActive) {
			switch(menuChoice) {
			
			case '1':
				mainMenu();
				break;
			case '2':
				searchBookings();
				break;
			case '3':
				createBooking();
				break;
			case'4':
				updateBooking();
				break;
			case '5':
				deleteBooking();
				break;
			case '6':
				testCreateBooking();
				break;
			case '0':
				closeMenu();
				break;
			default:
				System.out.println("Error, no matching input!");
				System.out.print("Choose an option: ");
				menuChoice = input.next().charAt(0);
			} 
			
		}
		
	}
	
	public void createFlight() {
		int finNumSeats = 0, finTravelLength = 0;
		mismatch = true;
		
		
		System.out.println("Please enter the following information:");
		
			System.out.print("Departing City: ");
			String depCity = input.next();
			
			System.out.print("Departing Time (Format HH:mm): ");
			String depTime = input.next();
			while(mismatch) {
				if(!logicManager.checkTimeFormat(depTime)) { //Dubbelkollar så att formattet på tiden stämmer
					System.out.println("Incorrect format on time");
					System.out.print("Enter again: ");
					depTime = input.next();
				}else {
					mismatch = false;
					
				}
			} mismatch = true;
			
			System.out.print("Departing Day: ");
			String depDay = input.next();
			while(mismatch) {
					if(logicManager.isDay(depDay)) { //Dubbelkollar att det man skrivit in är en veckodag.
						mismatch = false;
					}else {
						System.out.println("Departure day must be one of the weekdays");
						System.out.print("Enter again: ");
						depDay = input.next();
					}
			}mismatch = true;
			
			System.out.print("Arrival City: ");
			String arrCity = input.next();
			while(mismatch) {
				if(arrCity.equals(depCity)) { //Ser till så att folk inte bokar en resa till & från samma flygplats
					System.out.println("You cannot depart and arrive at the same airport");
					System.out.print("Enter again: ");
					arrCity = input.next();
				}else {
					mismatch = false;
				}
			}mismatch = true;
			
			System.out.print("Airline: ");
			String airline = input.next();
			while(mismatch) {
					if(logicManager.isAirline(airline)) { //Kollar så att det man skrivit in är en airline
						if(!logicManager.checkFlightCities(depCity, arrCity, airline)) { // Dubbelkollar så att samma airline inte kör samma rut.
							System.out.println("This airline already uses this route");
							System.out.print("Enter again: ");
							airline = input.next();
						}else {
							mismatch = false;
						}
					}else {
						System.out.println("One of these airlines: SAS, Norwegian, Turkish, Ryanair, Qatar, Finnair, Lufthansa, Virgin atlantic, Air France, Easyjet");
						System.out.print("Enter again: ");
						airline = input.next();
					}
				} mismatch = true;
			
			System.out.print("Flightnumber (format LLDDD): ");
			String flightNumber = input.next();
			while(mismatch) {
				if(!logicManager.checkFlightNumberFormat(flightNumber)) { //Dubbelkollar formatet på flygnumret
					System.out.println("Incorrect format (LLDDD)");
					System.out.print("Enter again: ");
					flightNumber = input.next();
				}else if(logicManager.isFlight(flightNumber)) { //Kollar så att dte flyfnumret inte redan används
					System.out.println("This flightnumber already exists");
					System.out.print("Enter again: ");
					flightNumber = input.next();
				}else {
					mismatch = false;
				}
			} mismatch = true;
			
			System.out.print("Number Of Seats: ");
			String numSeats = input.next();
				while(mismatch) {
					if(logicManager.isANumber(numSeats)) { //Dubbelkollar att det man skrivit in är ett nummer
						finNumSeats = logicManager.makeIntoANumber(numSeats);
						if(finNumSeats < 381 && finNumSeats > 79) { //Kollar så att det numret är mellan 80 & 380
							mismatch = false;
						}else {
							System.out.println("Number of seats must be a number between 80 & 380");
							System.out.print("Enter again: ");
							numSeats = input.next();
						}
					}else {
						System.out.println("Number of seats must be a number");
						System.out.print("Enter again: ");
						numSeats = input.next();
					}
				} mismatch = true;
			
			System.out.print("Travellength: ");
			String travelLength = input.next();
				while(mismatch) {
					if(logicManager.isANumber(travelLength)) { //Dubbelkollar att det man skrivit in är ett nummer
						finTravelLength = logicManager.makeIntoANumber(travelLength);
						if(finTravelLength < 19 && finTravelLength > 0) { //Kollar så att det numret är mellan 1 & 18
							mismatch = false;
						}else {
							System.out.println("Travellength must be a number beetween 0 & 18");
							System.out.print("Enter again: ");
							travelLength = input.next();
						}
					}else {
						System.out.println("Travellength must be a number");
						System.out.print("Enter again: ");
						travelLength = input.next();
					}
				} mismatch = true;
				
			System.out.println("A flight (" + flightNumber + ") has now been created.");
			
			logicManager.createFlight(depCity, depTime, depDay, arrCity, airline, flightNumber, finNumSeats, finTravelLength);
			
			CMD1();
		
	}
	
	public void removeFlight() {
		if(logicManager.listflightNumbers() == "") {
			System.out.println("There are no available flights to remove");
			mainMenu();
		}
		
		System.out.print("Here are all the available flights to remove: ");
		System.out.println(logicManager.listflightNumbers());
		
		System.out.print("Enter which number you want to delete: ");
		String flightNumber = input.next();
		
		//Kollar så att de man skrivit in är ett giltigt flightnumber
		if(logicManager.isFlight(flightNumber)) {
			logicManager.deleteFlight(flightNumber);
			System.out.println("The flight with flightnumber " + flightNumber + " has now been deleted");
		}else {
			System.out.println("Error, no matvhing flightnumber");
		}
		CMD1();
	}
	
	public void testFlight() {
		
		logicManager.createFlight("Luleå", "10:00", "Monday", "Stockholm", "SAS", "SK101", 81, 8);
		logicManager.createFlight("Sthlm", "13:00", "Wednesday", "Lule", "Turkish", "SK102", 89, 3);
		logicManager.createFlight("Borås", "16:00", "Sunday", "Göteborg", "SAS", "SK103", 130, 2);
		System.out.println("FLYG HAR SKAPATS");
		CMD1();
	}
	
	public void createBooking() {
		
		mismatch = true;
		
		boolean updateable = true;
		int finYear = 3, finWeekNR = 3;
		
		if(logicManager.listflightNumbers() == "") {
			System.out.println("There are no available flights to book \n");
			mainMenu();
		}
		System.out.print("Here are all the available flights to book: ");
		System.out.println(logicManager.listflightNumbers());
		
			System.out.print("Name: ");
			String name = input.next();
			
			System.out.print("Traveldoc ID: ");
			String id = input.next();
			while(mismatch) {
				if(!logicManager.checkIDFormat(id)) {
					System.out.println("Incorrect format (Format DDDDDDDD)");
					System.out.print("Enter again: ");
					id = input.next();
				}else {
					mismatch = false;
				}
			}mismatch = true;
			
			System.out.print("Flight Number (Format LLDDD): ");
			String flightNumber = input.next();
			while(mismatch) {
					if((logicManager.isFlight(flightNumber))) { // Kollar så att flightnumret man skrivit in finns
						mismatch = false;
					}else {
						System.out.println("This flightnumber does not exist");
						System.out.print("Enter again: ");
						flightNumber = input.next();
					}
			}
			while(mismatch) {
				if(logicManager.numFreeSeats(flightNumber)<1) { //Kollar ås att det finns lediga platser på flyget
					System.out.println("This flight has been fully booked");
					System.out.print("Enter again: ");
					flightNumber = input.next();
				}else {
					mismatch = false;
				}
			}mismatch = true;
			
			
			System.out.print("Year: "); 
			String year = input.next();
			
			//Dubbelkollar så att man ej bokar ej flyg i dåtiden & så att man faktiskt skriver in ett nummer
		while(mismatch) {
			while(mismatchNotANumber) {
				if(logicManager.isANumber(year)) {
					finYear = logicManager.makeIntoANumber(year);
					mismatchNotANumber = false;
					
				}else {
					System.out.println("Year must be a number");
					System.out.print("Enter again: ");
					year = input.next();
				}
			}
			if(logicManager.checkYear(finYear) == 0) {
				System.out.println("You cannot book flights in the past nor later than 2030");
				System.out.print("Enter again: ");
				year = input.next();
				if (logicManager.isANumber(year)) {
					finYear = logicManager.makeIntoANumber(year);
					}
				
			}else if(logicManager.checkYear(finYear) == 1 || logicManager.checkYear(finYear) == 2) {
				mismatchNotANumber = false;
				mismatch = false;
			}else
				mismatchNotANumber = true;
			} mismatch = true;
			mismatchNotANumber = true;
		
		
			System.out.print("Week Number: ");
			String weekNR = input.next();
			
			//Kollar så att man inte bokar ett flyg i dåtiden & så att man faktiskt skirver in ett NUMMER mellan 1 & 52
			while(mismatch) {
				while(mismatchNotANumber) {
					if(logicManager.isANumber(weekNR)) {
						finWeekNR = logicManager.makeIntoANumber(weekNR);
							if(finWeekNR < 53 && finWeekNR > 0) {
								
								if(logicManager.checkYear(finYear) == 1 || (logicManager.checkYear(finYear) == 2 && logicManager.checkWeek(finWeekNR) == 1)) {
									mismatchNotANumber = false;
								}else if(logicManager.checkYear(finYear) == 2 && logicManager.checkWeek(finWeekNR) == 2 && logicManager.checkDay(flightNumber)== 1) {
									mismatchNotANumber = false;
								}else if(logicManager.checkYear(finYear) == 2 && logicManager.checkWeek(finWeekNR) == 2 && logicManager.checkDay(flightNumber)== 2 && logicManager.checkTime(flightNumber)) {
									mismatchNotANumber = false;
								}else {
									System.out.println("You cannot book flights in the past.");
									System.out.print("Enter again: ");
									weekNR = input.next();
								}
							} else {
								System.out.println("The weeknumber must be a number between 1 and 52");
								System.out.print("Enter again: ");
								weekNR = input.next();
							}
					}else {
						System.out.println("The weeknumber must be a number between 1 and 52");
						System.out.print("Enter again: ");
						weekNR = input.next();
					}
				}
				mismatch = false;
			} mismatch = true;
			mismatchNotANumber = true;
			
			System.out.print("Uppdateable (true or false): ");
			String ans = input.next();
			while(mismatch) {
			if(ans.equals("True") || ans.equals("true")) {
				updateable = true;
				mismatch = false;
			}else if(ans.equals("False") || ans.equals("false")){
				updateable = false;
				mismatch = false;
			}else {
				System.out.println("Muste be either true or false");
				System.out.print("Enter again: ");
				ans = input.next();
			}
	} mismatch = true;
			
			logicManager.bookFlight(name, id, flightNumber, finWeekNR, finYear, updateable);
			System.out.println("A booking has now been made with bookingnumber: " + logicManager.getBookingNr(flightNumber));
			mainMenu();
	}
	
	public void testCreateBooking() {
		boolean bol = false;
		logicManager.bookFlight("olle","12345678", "SK101", 25, 2000, bol);
		System.out.println("A booking has now been made with bookingnumber: " + logicManager.getBookingNr("SK101"));
		testCreateBooking1();
	}
	
	public void testCreateBooking1() {
		boolean bol = true;
		logicManager.bookFlight("olle", "12345678", "SK102", 25, 2000, bol);
		System.out.println("A booking has now been made with bookingnumber: " + logicManager.getBookingNr("SK102"));
		testCreateBooking2();
	}
	
	public void testCreateBooking2() {
		boolean bol = true;
		logicManager.bookFlight("olle", "12345678", "SK103", 25, 2000, bol);
		System.out.println("A booking has now been made with bookingnumber: " + logicManager.getBookingNr("SK103"));
		testCreateBooking3();
	}
	
	public void testCreateBooking3() {
		boolean bol = true;
		logicManager.bookFlight("spåls", "12345678", "SK103", 25, 2000, bol);
		System.out.println("A booking has now been made with bookingnumber: " + logicManager.getBookingNr("SK103"));
		testCreateBooking4();
	}
	
	public void testCreateBooking4() {
		boolean bol = true;
		logicManager.bookFlight("spåls", "12345678", "SK103", 25, 2000, bol);
		System.out.println("A booking has now been made with bookingnumber: " + logicManager.getBookingNr("SK103"));
		CMD1();
	}
	
	public void updateBooking() {
		mismatch = true; 
		
		System.out.print("Enter bookingnumber you wish to update: ");
		String bookingNumber = input.next();
		
		while(mismatch) {
			//Kollar ifall bokningen är updateable
//			if(haveLoadedData) {
//				if(!logicManager.isUpdateablBookingIfLoaded(bookingNumber)) {
//					System.out.println("Error, that is not a updateable bookingnumber.");
//					System.out.print("Enter bookingnumber you wish to update: ");
//					bookingNumber = input.next();
//				}else if(!logicManager.isBookingNumber(bookingNumber)){
//					System.out.println("Error, that is not a bookingnumber.");
//					System.out.print("Enter bookingnumber you wish to update: ");
//					bookingNumber = input.next();
//				}else {
//					mismatch = false;
//				}
//				
//			}else 
//			if(!logicManager.isUpdateablBooking(bookingNumber)) {
			if(logicManager.isUpdateablBooking(bookingNumber)) {
				System.out.println("Error, that is not a updateable bookingnumber.");
				System.out.print("Enter bookingnumber you wish to update: ");
				bookingNumber = input.next();
				
				//Kollar ifall det är ett boknigsnummer man skrivit in
			}else if(!logicManager.isBookingNumber(bookingNumber)){
				System.out.println("Error, that is not a bookingnumber.");
				System.out.print("Enter bookingnumber you wish to update: ");
				bookingNumber = input.next();
			}else {
				mismatch = false;
			}
		} mismatch = true;
		
		System.out.print("Enter the name of the passenger you wish to switch: ");
		String oldName = input.next();
		System.out.print("Enter the ID of the passenger you wish to switch: ");
		String oldID = input.next();
		
		while(mismatch) {
			if(!logicManager.isPassengerInBooking((oldName + " " + oldID), bookingNumber)) {
				System.out.println("Error, not a passenger on that booking");
				System.out.print("Enter the name of the passenger you wish to switch: ");
				oldName = input.next();
				System.out.print("Enter the ID of the passenger you wish to switch: ");
				oldID = input.next();
			}else {
				mismatch = false;
			}
		} mismatch = true;
		
		System.out.print("Enter the name of the new passenger: ");
		String name = input.next();
		System.out.print("Enter the ID of the new passenger: ");
		String id = input.next();
		
		while(mismatch) {
			if(name == oldName && id == oldID) {
				System.out.println("Error, not a new passenger");
				System.out.print("Enter the name of the new passenger: ");
				name = input.next();
				System.out.print("Enter the ID of the new passenger: ");
				id = input.next();
			}else {
				mismatch = false;
			}
		} mismatch = true;
		
			logicManager.updateBooking(bookingNumber, (name + " " + id), (oldName + " " + oldID));
		
		System.out.println("The booking has now been updated");
		CMD1();

	}
	
	public void searchBookings() {
		mismatch = true;
		
		System.out.println("What passenger do you want to see bookings for?");
		System.out.print("Enter name: ");
		String name = input.next();
		System.out.print("Enter ID: ");
		String ID = input.next();
		String pass = (name + " " + ID);
		
		
		while(mismatch) {
			//Kollar så att det man skriver in faktiskt är en passagerare
			if(logicManager.isAPassenger(pass)) {
				mismatch = false;
				
			}else {
				System.out.println("Not a real passenger");
				System.out.print("Enter name again : ");
				name = input.next();
				System.out.print("Enter ID again : ");
				ID = input.next();
				pass = (name + " " + ID);
			}
			
			mismatch = true;
			
			String[] passBookingNumbersList = new String[logicManager.numBookings(pass)];
			passBookingNumbersList = logicManager.lookUpPassBookingNumber(pass);
			System.out.println(passBookingNumbersList);
			
			//Kollar så att passageraren har några bookings
			if(logicManager.numBookings(pass)>0 && !haveLoadedData) {
				
				System.out.println(name + " - " + logicManager.numBookings(pass) + " matches found." );
				System.out.println("==============================================================================");
					
//				String[] bookingInfo = logicManager.listBookingInfo(passBookingNumbersList);
					
				for(String bookingNumber : passBookingNumbersList) {
					System.out.println(logicManager.listBookingInfo2(bookingNumber));
				}
				
//				for(int i = 0; i< logicManager.numBookings(pass); i++) {
//						System.out.println(bookingInfo[i]);
//				}
					CMD1();
				
//				}else if(logicManager.numBookings(pass)>0 && haveLoadedData) {
//					
//					System.out.println(name + " - " + logicManager.numBookings(pass) + " matches found." );
//					System.out.println("==============================================================================");
//					
////					for(String passengersBookingNumber : passBookingNumbersList) {
////						System.out.println(logicManager.listBookingInfoIfLoadedData(passengersBookingNumber));
////					}
//					
//					String[] bookingInfo = logicManager.listBookingInfoIfLoadedData(passBookingNumbersList);
//					
//					for(int i = 0; i< logicManager.numBookings(pass); i++) {
//						System.out.println(bookingInfo[i]);
//					}
//					
//					CMD1();
//					
//				}
			}else {
					System.out.println(name + " - no matches found." );
					System.out.println("==============================================================================");
					CMD1();
				}
			}mismatch = true;
		}
	
	public void deleteBooking() {
		
		System.out.println("Here are all the bookings: " + logicManager.listBookingNumbers());
		System.out.println("Which booking do you want do delete?");
		System.out.print("Enter bookingnumber:  ");
		String bookingNumber = input.next();
		if(logicManager.isBookingNumber(bookingNumber)) {
			logicManager.deleteBooking(bookingNumber);
			System.out.println("The booking with bookingnumber: " + bookingNumber + " has now been deleted");
		}else {
			System.out.println("Error, no matching bookingnumber");
		}
		CMD1();
	}
	
	public void closeMenu() {
		System.out.println("Goodbye..");
		logicManager.saveData();
		menuActive = false;
	}
	
	public void wrongLogin() {
		System.out.println("Wrong username or password, nerd.");
		closeMenu();
	}
	}
