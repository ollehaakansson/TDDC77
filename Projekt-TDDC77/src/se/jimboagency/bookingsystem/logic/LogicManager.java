package se.jimboagency.bookingsystem.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class LogicManager{
	
	private ArrayList<User> users = new ArrayList<>(); //Lista med users, alltså username & password
	private ArrayList<Airline> airlineNames = new ArrayList<>(); //Lista med airlineNames
	private ArrayList<String> passengers = new ArrayList<>(); //Lista med passengers, alltså name & id
	
	private Map<String, Booking> Bookings = new HashMap<String, Booking>(); // bookingnumber till booking
	private Map<String, HashSet<String>> passenger2BookingNumber = new HashMap<String, HashSet<String>>(); //passenger till bookingNumber
	private Map<String, Flight> Flights = new HashMap<String, Flight>(); // flightnumber till flight
	private Map<String, Integer> flightSeats = new HashMap<String, Integer>(); //flightnumber till freeseats
	private Map<String, String> BookingNumbers = new HashMap<String, String>(); // flightnumber till bookingnumber
	private Map<String, String> Airlines = new HashMap<String, String>(); //flightnumber till airlineName
	
	private String[] days = {"monday","tuesday","wednesday","thursday", "friday", "saturday", "sunday"};
	private String[] args;
	
	private boolean haveLoadedInData = false;
	
	Calendar calendar = Calendar.getInstance();
	Date date = calendar.getTime();
	
	public LogicManager(String[] args) {
		this.args = args;
		users.add(new User("shipa001","2eff43"));
		users.add(new User("Ennpe001", "wedr5t"));
		users.add(new User("julno001", "wwr4r3")); 
		users.add(new User("johni001", "lk9h6d"));
		users.add(new User("adabe001", "0o3u33"));
		users.add(new User("guest", "password"));
		airlineNames.add(new Airline ("SAS"));
		airlineNames.add(new Airline ("Norwegian"));
		airlineNames.add(new Airline ("Turkish"));
		airlineNames.add(new Airline ("Ryanair"));
		airlineNames.add(new Airline ("Qatar"));
		airlineNames.add(new Airline ("Finnair"));
		airlineNames.add(new Airline ("Lufthansa"));
		airlineNames.add(new Airline ("Virgin"));
		airlineNames.add(new Airline ("Air France"));
		airlineNames.add(new Airline ("Easyjet"));
	}
	
	public void loadData() {

		BufferedReader bufferedReader;
		
		String filePathBookings = "/home/ollha403/bookings.json";
		String filePathPassenger2BookingNumber = "/home/ollha403/passenger2BookingNumber.json";
		String filePathFlights = "/home/ollha403/Flights.json";
		String filePathFlightSeats = "/home/ollha403/flightSeats.json";
		String filePathBookingNumbers = "/home/ollha403/BookingNumbers.json";
		String filePathAirlines = "/home/ollha403/Airlines.json";
		
		Gson gson = new Gson();
		
		try {
//			Reader readerPassenger = Files.newBufferedReader(Paths.get(filePathPassenger));
			
//			Reader readerPassenger2BookingNumber = Files.newBufferedReader(Paths.get(filePathPassenger2BookingNumber));
//			Reader readerFlights = Files.newBufferedReader(Paths.get(filePathFlights));
//			Reader readerFlightSeats = Files.newBufferedReader(Paths.get(filePathFlightSeats));
//			Reader readerBookingNumbers = Files.newBufferedReader(Paths.get(filePathBookingNumbers));
//			Reader readerAirlines = Files.newBufferedReader(Paths.get(filePathAirlines));
//			Reader readerBookings = Files.newBufferedReader(Paths.get(filePathBookings));
//			passengers = gson.fromJson(readerPassenger, );
			
			
//			BookingNumbers = (Map<String, String>) gson.fromJson(bufferedReader, BookingNumbers.getClass());
//			Airlines = (Map<String, String>) gson.fromJson(readerAirlines, Airlines.getClass());
//			Bookings = (Map<String, Booking>) gson.fromJson(readerBookings, Bookings.getClass());
//			flightSeats = (Map<String, Integer>) gson.fromJson(readerFlightSeats, flightSeats.getClass());
//			Flights = (Map<String, Flight>) gson.fromJson(readerFlights, Flights.getClass());
			
//			Reader readerBookings = Files.newBufferedReader(Paths.get(filePathBookings));
//			BufferedReader readerBookings = new BufferedReader(new FileReader(filePathBookings));
//			bufferedReader = new BufferedReader (new FileReader(filePathBookings));
//			
//			Type typeBooking = new TypeToken<Map<String, HashSet<UpdateAbleBooking>>>(){}.getType();
//			Map<String, HashSet<UpdateAbleBooking>> clonedBookingMap = gson.fromJson(bufferedReader, typeBooking);
//			
//			Booking b = null;
//			String p = null;
//			for(String key: clonedBookingMap.keySet()) {
//				String bookingNumber = key;
//				
//				for(Booking booking : clonedBookingMap.get(key)) {
//					if(booking.isUpdatable()) {
//						b = new UpdateAbleBooking(booking.getBookingNumber(), booking.getFlight(), booking.getWeek(), booking.getYear(), booking.isUpdatable());
//						if(p!=null && b!=null) {
//							addBooking(bookingNumber, booking);
//						}
//					}
//					if(!booking.isUpdatable()) {
//						b = new UnUpdateAbleBooking(booking.getBookingNumber(), booking.getFlight(), booking.getWeek(), booking.getYear(), booking.isUpdatable());
//						if(p!=null && b!=null) {
//							addBooking(bookingNumber, booking);
//						}
//					}
//				}
//				
//			}
			
			
			//allt för passenger2BookingNumber
			bufferedReader = new BufferedReader(new FileReader(filePathPassenger2BookingNumber)); 
			Type typePassenger2BookingNumber = new TypeToken<HashMap<String, HashSet<String>>>() {}.getType();
			Map<String, HashSet<String>> clonedPassenger2BookingNumber = gson.fromJson(bufferedReader, typePassenger2BookingNumber);
			
			for(String passenger : clonedPassenger2BookingNumber.keySet()) {
				
				for(String bookingNumber : clonedPassenger2BookingNumber.get(passenger)) {
					if(passenger != null && bookingNumber != null ) {
						addPassenger2BookingNumber(passenger, bookingNumber);
					}
				}
			}
			
			//allt för flights
			bufferedReader = new BufferedReader(new FileReader(filePathFlights));
			Type typeFlights = new TypeToken <HashMap<String, Flight>>() {}.getType();
			Map<String, Flight> clonedFights = gson.fromJson(bufferedReader, typeFlights);
			
			if(clonedFights != null) {
				Flights = clonedFights;
			}
			
			//allt för flightseats
			bufferedReader = new BufferedReader(new FileReader(filePathFlightSeats));
			Type typeFlightSeats = new TypeToken <HashMap<String, Integer>>() {}.getType();
			Map<String, Integer> clonedFlightSeats = gson.fromJson(bufferedReader, typeFlightSeats);
			
			if(clonedFlightSeats != null) {
				flightSeats = clonedFlightSeats;
			}
			
			//allt för bookingNumbers
			bufferedReader = new BufferedReader(new FileReader(filePathBookingNumbers));
			Type typeBookingNumbers = new TypeToken<HashMap<String, String>>() {}.getType();
			Map<String, String> clonedBookingNumbers = gson.fromJson(bufferedReader, typeBookingNumbers);
			
			if(clonedBookingNumbers != null) {
				BookingNumbers = clonedBookingNumbers;
			}
			
			//Allt för airlines
			bufferedReader = new BufferedReader(new FileReader(filePathAirlines));
			Type typeAirlines = new TypeToken<HashMap<String, String>>() {}.getType();
			Map<String, String> clonedAirlines = gson.fromJson(bufferedReader, typeAirlines);
			
			if(clonedAirlines != null) {
				Airlines = clonedAirlines;
			}
			
			//Allt för Bookings
			bufferedReader = new BufferedReader(new FileReader(filePathBookings));
			Type typeBooking = new TypeToken<HashMap<String, UpdateAbleBooking>>() {}.getType();
			Map<String, UpdateAbleBooking> clonedBookings = gson.fromJson(bufferedReader, typeBooking);
			
			Booking b = null; //en bokning
			String bNr = null; //ett bookingNumber
			
			if(clonedBookings != null) {
				for(String key : clonedBookings.keySet()) {
					System.out.println(key);
					bNr = key;
					for(Booking booking : clonedBookings.values()) {
						
						if(booking.isUpdateable()) {
							b = new UpdateAbleBooking(booking.getBookingNumber(), booking.getFlight(), booking.getWeek(), booking.getYear(), booking.isUpdateable());
							
							if(b !=null && bNr != null) {
								addBooking(bNr, b);
							}
						}if(!booking.isUpdateable()) {
							b = new UnUpdateAbleBooking(booking.getBookingNumber(), booking.getFlight(), booking.getWeek(), booking.getYear(), booking.isUpdateable());
							
							if(b !=null && bNr != null) {
								addBooking(bNr, b);
							}
						}
					}
					
				}
			}
			
			for(String passenger : passenger2BookingNumber.keySet()) {
				passengers.add(passenger.toString());
			}
			haveLoadedInData = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveData() {
		
		try {
			
			FileWriter filePassenger = new FileWriter("/home/ollha403/passengers.json");
			FileWriter fileBookings = new FileWriter("/home/ollha403/bookings.json");
			FileWriter filePassenger2Bookings =new FileWriter("/home/ollha403/passenger2BookingNumber.json");
			FileWriter fileFlights =new FileWriter("/home/ollha403/Flights.json");
			FileWriter fileFlightSeats =new FileWriter("/home/ollha403/flightSeats.json");
			FileWriter fileBookingNumbers =new FileWriter("/home/ollha403/BookingNumbers.json");
			FileWriter fileAirlines=new FileWriter("/home/ollha403/Airlines.json");
			
			Gson gsonObj = new GsonBuilder().setPrettyPrinting().create();
			
			String strGsonPassenger = gsonObj.toJson(passengers);
			String strGsonBookings = gsonObj.toJson(Bookings);
			
			String strGsonPassenger2bookingNumber = gsonObj.toJson(passenger2BookingNumber);
			
			String strGsonFlights = gsonObj.toJson(Flights);
			String strGsonFlightSeats = gsonObj.toJson(flightSeats);
			String strGsonBookingNumbers = gsonObj.toJson(BookingNumbers);
			String strGsonAirlines = gsonObj.toJson(Airlines);			
			
			filePassenger.write(strGsonPassenger);
			filePassenger.flush();
			filePassenger.close();
			
			fileBookings.write(strGsonBookings);
			fileBookings.flush();
			fileBookings.close();
			
			filePassenger2Bookings.write(strGsonPassenger2bookingNumber);
			filePassenger2Bookings.flush();
			filePassenger2Bookings.close();
			
			fileFlights.write(strGsonFlights);
			fileFlights.flush();
			fileFlights.close();
			
			fileFlightSeats.write(strGsonFlightSeats);
			fileFlightSeats.flush();
			fileFlightSeats.close();
			
			fileBookingNumbers.write(strGsonBookingNumbers);
			fileBookingNumbers.flush();
			fileBookingNumbers.close();
			
			fileAirlines.write(strGsonAirlines);
			fileAirlines.flush();
			fileAirlines.close();
			
		} catch (Exception e) {
			
		}
		
	}
	
	public Flight lookUpFlight(String flightNumber) { 
			return Flights.get(flightNumber);
	}

	public Set<String> termsFlight() {
		
		return Flights.keySet();
	}
	
	public Set<String> termsPassenger2BookingNumber() {
		
		return passenger2BookingNumber.keySet();
	}
	
	public Set<String> lookUpPassenger2BookingNumber(String pass) {
		
		return passenger2BookingNumber.get(pass);
			
	}
	
	public Booking lookUpBooking(String bookingNumber) {
		return Bookings.get(bookingNumber); 
	} 
	
	public String[] lookUpPassBookingNumber(String pass) { //pass är uppbyggt med namn + " " + id 
		String bookingNumbers = passenger2BookingNumber.get(pass).toString();
		
		Object[] var1 = passenger2BookingNumber.get(pass).toArray();
		String[] passBookingNumbersList = new String[var1.length];
			
		for(int i = 0; i<var1.length; i++) {
			passBookingNumbersList[i] = (String) var1[i];
		}
		return passBookingNumbersList;
	}
	
	public Set<String> termsBooking() {
		return Bookings.keySet();
	}
	
	//Returnerar i int hur många bookningar en passagegare har
	public int numBookings(String pass) { //pass är uppbyggt med namn + " " + id 
		
//		int i = 0;
//		if(passenger2BookingNumber.get(pass) != null) {
//			
//			
//			for(String var1 : passenger2BookingNumber.get(pass));
//			
//			i++;
//		}
//		return i;
		
		
		if(passenger2BookingNumber.get(pass)!=null) {
			Object[] var1 = passenger2BookingNumber.get(pass).toArray();
			return var1.length;
		}
		return 0;
	}
	
	public void createFlight(String depCity, String depTime, String depDay, String arrCity, String airlineName, String flightNumber, int numSeats, int travelLength) {
		
		String arrTime = travelTime(depTime, travelLength);
		String arrDay = arrDay(depTime, depDay, arrTime);
		Flight flight = new Flight(depCity, depTime, depDay, arrCity, arrDay, airlineName, flightNumber, numSeats, arrTime);
		addFlightSeats(flightNumber, numSeats);
		addAirline(flightNumber, airlineName);
		addFlight(flightNumber, flight);
		
	}
	
	// räknar ut vad klockan är när flyget landar
	
	public String travelTime(String depTime, int travelLength) {
		
		String[] realDepTime = depTime.split(":");
		
		if((Integer.valueOf(realDepTime[0]) + Integer.valueOf(travelLength)) > 24) {
			return ((Integer.valueOf(realDepTime[0]) + Integer.valueOf(travelLength)) - 24) + ":" + realDepTime[1];
		}else
			return (Integer.valueOf(realDepTime[0]) + Integer.valueOf(travelLength)) + ":" + realDepTime[1];
	}
	
	//Räknar ut vilken dag flyget landar
	
	public String arrDay(String depTime, String depDay, String arrTime) {
		
		String[] realDepTime = depTime.split(":");
		String[] realArrTime = arrTime.split(":");

		
		if(Integer.valueOf(realArrTime[0]) < Integer.valueOf(realDepTime[0])) {
			for(int i = 0; i < 7; i++) {
				if(realDepTime.equals(days[i])) {
					if((i +1) == 7) {
						return days[0];
					}else {
						return days[(i+1)];
					}
				}
			}
		}
		return depDay;
	}
	
	//Lägger till ett flygnummer & ett flight i vår flights hashmap
	
	public void addFlight(String flightNumber, Flight flight) {
		Flights.put(flightNumber, flight);
	}
	
	// lägger till ett flygnummer & en airline i vår airlines hashmap
	
	public void addAirline(String flightNumber, String airlineName) {
		Airlines.put(flightNumber, airlineName);
	}
	
	//bokar ett flyg
	
	public void bookFlight(String name, String id, String flightNumber, int week, int year, boolean updateable) {
		
		createBookingNr(flightNumber); //Skickar flygnumret till en metod som skapar ett bokningsnummer
		
			String passNameId = name + " " + id;
			
			if(!passengers.contains(passNameId)) { //Kollar om passageraren redan finns, om den finns görs inget, men om den inte finns läggs den till i vår hashmap
				passengers.add(passNameId);
			}
			
			addPassenger2BookingNumber(passNameId, BookingNumbers.get(flightNumber));
			seatTaken(flightNumber); // Ser till att ett säte tas på flyget
			
		if(updateable) { 
			Booking booking = new UpdateAbleBooking(BookingNumbers.get(flightNumber), Flights.get(flightNumber), week, year, updateable); //Skapar en updateable instans av booking
			addBooking(BookingNumbers.get(flightNumber), booking); //Lägger till bookningen i vår hashmap med bookingnumbers till bookings
		}else {
			Booking booking = new UnUpdateAbleBooking(BookingNumbers.get(flightNumber), Flights.get(flightNumber), week, year, updateable);//Skapar en unupdateable instans av booking
			addBooking(BookingNumbers.get(flightNumber), booking); //Lägger till bookningen i vår hashmap med bookingnumbers till bookings
		}
	}
	
	//Lägger till en passenger & ett bokningsnummer i vår hashmap passenger2BookingNumber
	
	public void addPassenger2BookingNumber(String pass, String bookingNumber) { //pass är uppbyggt med namn + " " + id 
		
		if(!passenger2BookingNumber.containsKey(pass)) {
			passenger2BookingNumber.put(pass, new HashSet<String>());
		}
		passenger2BookingNumber.get(pass).add(bookingNumber);
		
	}
	
	//returnerar en array med all bokningsinfo
	
	public String[] listBookingInfo(String[] bookingNumbers) {
		
		String[] bookingInfo = new String[bookingNumbers.length];
		
		for(int i = 0; i<bookingNumbers.length; i++) {
			
			bookingInfo[i] = String.valueOf(Bookings.get(bookingNumbers[i]));
		}
		
		return bookingInfo;
	}
	
	public String listBookingInfo1(String bookingNumber) {
		
		return String.valueOf(Bookings.get(bookingNumber));
	}
	
	public String listBookingInfo2(String bookingNumber) {
		
		String bookingInfo = null;
		
		for(String key : Bookings.keySet()) {
			if(key.equals(bookingNumber)) {
				bookingInfo = String.valueOf(Bookings.get(key));
			}
		}
		return bookingInfo;
	}
	
	public String[] listBookingInfoIfLoadedData(String [] bookingNumbers) {
		
		String[] bookingInfo = new String[bookingNumbers.length];
		String[] testArray = new String[14];
		String[] splitTestArray = new String[30];

		String hej = "hej";
		hej.split("=");
		
		for(String specBookingNumber : bookingNumbers) {
			
			String test = String.valueOf((Bookings.get(specBookingNumber)));
			testArray = test.split("=");
			
			
//			for(int a = 0; a < testArray.length; a++) {
//				
//				splitTestArray = testArray[a].split(",");
//				
//			}
			
			String[] splitBookingNumber = testArray[1].split(",");
			String bookingNumber = splitBookingNumber[0];
			
			String weekNumber = testArray[2];
			String finWeekNumber = weekNumber.substring(0, 2);
			
			String year = testArray[3];
			String finYear = year.substring(0, 4);
			
			String[] splitFlightNumber = testArray[6].split(",");
			String flightNumber = splitFlightNumber[0];
			
			String[] splitDepCity = testArray[7].split(",");
			String depCity = splitDepCity[0];
			
			String[] splitDepTime = testArray[8].split(",");
			String depTime = splitDepTime[0];
			
			String[] splitDepDay = testArray[9].split(",");
			String depDay = splitDepDay[0];
			
			String[] splitArrCity = testArray[10].split(",");
			String arrCity = splitArrCity[0];
			
			String[] splitArrDay = testArray[11].split(",");
			String arrDay = splitArrDay[0];
			
			String[] splitArrTime = testArray[13].split(",");
			String arrTime = splitArrTime[0];
			
			String masterString = bookingNumber + " - " + flightNumber + " - " + depCity + "(" + depDay+") - " + arrCity + "(" + arrDay + ") - V" + finWeekNumber + " - " + finYear + " - " + depTime + " - " + arrTime;
			
			for(int i = 0; i < bookingNumbers.length; i++) {
				bookingInfo[i] = masterString;
			}
			
		}
		return bookingInfo;
//		return bookingInfo;
		
		
//		String bookingNumber = var1[1];
//		String weekNumber = var1[2].replace(".0", "");
//		String year = var1[3].replace(".0", "");
//		String flightNumber = var1[6];
//		String depCity = var1[7];
//		String depTime = var1[8];
//		String depDay = var1[9];
//		String arrCity = var1[10];
//		String arrDay = var1[11];
//		String airlineName = var1[12];
//		String arrTime = var1[13];
//		String numSeats = var1[14].replace(".0", "");
//		
//		String masterString = bookingNumber + " - " + flightNumber + " - " + depCity + "(" + depDay+") - " + arrCity + "(" + arrDay + ") - V" + weekNumber + " - " + year + " - " + depTime + " - " + arrTime;
//		
//		return masterString;
	}
	
	//Lägger till ett bokningsnummer & bokning i vår hashmap Bookings
	
	public void addBooking(String bookingNumber, Booking booking) {
		
			Bookings.put(bookingNumber, booking);
	}
	
	//Skapar & returnerar ett unikt bokningsnummer
	
	public String createBookingNr(String flightNumber) {
		String airlineName = (Airlines.get(flightNumber)).toString();
		
		char var0 = airlineName.charAt(0);
		char var1 = airlineName.charAt(1);
		String firstLetter = (String.valueOf(var0)).toUpperCase();
		String secondLetter = (String.valueOf(var1)).toUpperCase();
		int number = ThreadLocalRandom.current().nextInt(100,999);
		String bookingNumber = firstLetter + secondLetter + number;
		
		BookingNumbers.put(flightNumber, bookingNumber);
		
		return bookingNumber;
	}
	
	
	public String getBookingNr(String flightNumber) {
		return BookingNumbers.get(flightNumber);
	}
	
	//returnerar en String med alla bokningsnummer
	
	public ArrayList<String> listBookingNumbers() { 
		ArrayList<String> bookingNumbersList = new ArrayList<String>();
		
		for(String bookingNumber : Bookings.keySet()) {
			bookingNumbersList.add(bookingNumber);
		}
		return bookingNumbersList;
	
	}
	
	//Returnerar en string med alla flightnumbers
	
	public String listflightNumbers() {
		String var1 = Flights.keySet().toString();
		
		String var2 = var1.replace("[", "");
		String listOfAllFlightNumbers = var2.replace("]", "");
		
		return listOfAllFlightNumbers;
		
	}
	
	//Tar bort en bokning & friar upp ett säte på ett flyg
	
	public void deleteBooking(String bookingNumber) {
		
		for(String flightNumber: BookingNumbers.keySet()) {
			 if(bookingNumber.equals(BookingNumbers.get(flightNumber))) {
				 freeSeat(flightNumber);
			 }	
		}
		Bookings.remove(bookingNumber);
	}
	
	//Tar bort en bokning från en passagerares set av bookings
	
	public void deletePassenger2BookingNumber(String pass, String bookingNumber) {
		
		if(isPassengerInBooking(pass, bookingNumber)) {
			passenger2BookingNumber.get(pass).remove(bookingNumber);
		}
	}
	
	//Tar bor ett flyg
	
	public void deleteFlight(String flightNumber) {
		
		//Kollar först ifall flyget är bokat, om det är bokat så raderas även bokningen
		if(BookingNumbers.containsKey(flightNumber)) {
			for(String pass : passengers) {
				if(passenger2BookingNumber.containsKey(pass)) {
					passenger2BookingNumber.get(pass).remove(BookingNumbers.get(flightNumber));
				}
			}
			Bookings.remove(BookingNumbers.get(flightNumber));
		}
		// Tas bort från resterande datastrukturer
		Flights.remove(flightNumber);
		flightSeats.remove(flightNumber);
		BookingNumbers.remove(flightNumber);
		Airlines.remove(flightNumber);
	}
	
	//uppdaterar en bokning
	
	public void updateBooking(String bookingNumber, String newPass, String oldPass) { //pass är uppbyggt med namn + " " + id 
		
		if(!passengers.contains(newPass)) {
			passengers.add(newPass);
		}
		addPassenger2BookingNumber(newPass, bookingNumber);
		deletePassenger2BookingNumber(oldPass, bookingNumber);
	}
	
	// returnerar en in med hur många fria säten som finns på ett givet flightnummer
	
	public int numFreeSeats(String flightNumber) {
		return flightSeats.get(flightNumber);
	}
	
	//Lägger till ett flightnumer & antal säten i flightSeats
	
	public void addFlightSeats(String flightNumber, int freeSeats) {
		flightSeats.put(flightNumber, freeSeats);
	}
	
	//Om ett flyg bokas så gör denna funktion så att ett säte blir upptaget
	
	public void seatTaken(String flightNumber) {
		flightSeats.put(flightNumber, (flightSeats.get(flightNumber) - 1));
	}
	
	//Om en bokning avbokas så gör denna så att ett säte blir ledigt
	
	public void freeSeat(String flightNumber) {
		flightSeats.put(flightNumber, (flightSeats.get(flightNumber) + 1));
	}
	
	// en getter för depDay
	
	public String getFlightDepDay(String flightNumber) {
		Flight flight = lookUpFlight(flightNumber);
		
		return flight.getDepDay();
	}
	
	// en getter för arrCity
	
	public String getFlightArrCity(String flightNumber) {
		Flight flight = lookUpFlight(flightNumber);
		
		return flight.getArrCity();
	}
	
	// en getter för depCity
	
	public String getFlightDepCity(String flightNumber) {
		Flight flight = lookUpFlight(flightNumber);
		
		return flight.getDepCity();
	}
	
	// en getter för airline
	
	public String getFlightAirline(String flightNumber) {
		Flight flight = lookUpFlight(flightNumber);
		
		return flight.getAirline();
	}
	
	// en getter för depTime
	
	public String getFlightDepTime(String flightNumber) {
		Flight flight = lookUpFlight(flightNumber);
		
		return flight.getDepTime();
	}
	
	// en getter för vilken dag i veckan det är just nu
	
	public String getDayOfTheWeek() {
		
		return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
	}
	
	// en getter för för vilket datum det är just nu
	
	public String getDate() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		String[] currDate = formatter.format(date).split(" ");
		
		return currDate[0];
	}
	
	// en getter för tid det är just nu
	
	public String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		
		String[] currTime = formatter.format(date).split(" ");
		
		return currTime[1];
		
	}
	
	// en getter för vilket år det är just nu
	
	public String getYear() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		String[] data1 = formatter.format(date).split(" ");
		String[] data2 = data1[0].split("/");
		
		return data2[2];
	}
	
	// en getter för vilket vecko nummer det är just nu
	
	public int getWeek() {
		Calendar calendar = Calendar.getInstance();
		
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	// En funktion som jämför vilket år man skickar in & nuvarande år. Den returnerar 1 om året man inputar är i framiden. 
	// Den returnerar två om det är samma år man inputar som det är just nu & de returnerar noll om et är ett tidigare år man skickat in
	
	public int checkYear(int year) {
		
		int currYear = Integer.valueOf(getYear());
		
		if(currYear < year && year < 2031) {
			return 1;
		}else if(currYear == year) {
			return 2;
		}else {
			return 0;
		}
	}
	
	// En funktion som jämför vilken vecka man skickar in & vilket veckonummer det är just nu. Den returnerar 1 om veckonr man skickar in är i framtiden.
	// den returnerar två om det är samma vekonr & den returnerar noll om det är en tidigare vecka
	
	public int checkWeek(int week) {
		
		if(getWeek() < week) {
			return 1;
		}else if(getWeek() == week) {
			return 2;
		}else {
			return 0;
		}
		
	}
	
	// En funktion som jämför vilken veckodag man skickar in & vilket veckodag det är just nu. Den returnerar 1 om dagen man skickar in är i framtiden.
	// den returnerar två om det är samma dag & den returnerar noll om det är en tidigare dag
	
	public int checkDay(String flightNumber) {
		String depDay = getFlightDepDay(flightNumber).toLowerCase();
		int depDayPlace = 0, currDayPlace = 0;
		
		for(int i = 0; i < days.length; i++) {
			if(days[i].equals(depDay)) {
				depDayPlace = i;
			}
			if(days[i].equals(getDayOfTheWeek().toLowerCase())) {
				currDayPlace = i;
			}
		}
		
		if(currDayPlace < depDayPlace) {
			return 1;
		}else if(currDayPlace == depDayPlace) {
			return 2;
		}else {
			return 0;
		}
	}
	
	//Kollar om en booking är updateable eller ej
	public boolean isUpdateablBooking(String bookingNumber) {
		
		Booking book = Bookings.get(bookingNumber);
		
		return book.isUpdateable();
		
//		return Bookings.get(bookingNumber) instanceof UpdateAbleBooking;
	}
	
	
//	//Kollar om en booking är updateable eller ej ifall man sparat in data
//	
//	public boolean isUpdateablBookingIfLoaded(String bookingNumber) {
//		
//		for(String passenger : passenger2BookingNumber.keySet()) {
//			
//			for(String specBookingNumber : passenger2BookingNumber.get(passenger)) {
//				
//				if(specBookingNumber.equals(bookingNumber)) {
//					
//					String booking = String.valueOf(Bookings.get(bookingNumber));
//					
//					return booking.contains("\"updateable\": true");
//				}
//			}
//		}
//		
//		return false;
//	}
	
	// returnerar en boolean om flyget som hör till flygnumret redan avgått eller ej
	
	public boolean checkTime(String flightNumber) {
		
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		
		try {
			Date currTime = parser.parse(getTime());
			Date depTime = parser.parse(getFlightDepTime(flightNumber));
			
			if(currTime.after(depTime) || currTime.equals(depTime)) {
				return false;
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	// Returnerar en boolean om en passagerare är med i en bookning eller ej.
	
	public boolean isPassengerInBooking(String pass, String bookingNumber) { //pass är uppbyggt med namn + " " + id 
		
		for(String key: passenger2BookingNumber.keySet()) {
			for(String value: passenger2BookingNumber.get(key)) {
				if(key.equals(pass) && value.equals(bookingNumber)) {
					return true;
				}
			}
		}
		return false;
	}
	
	// Kollar i args som man skickar in vid inloggning & säkerställer att allt är rätt
	
	public boolean authenticator() {
		if(args.length==4 && args[0].equals("-u") && args[2].equals("-p")) {
			User user = new User(args[1],args[3]);
			return user.equals(users); //sickar infon till userklassen där users equals funktion kollar att inloggningsuppgifterna stämmer
			
		}else if(args.length==4 && args[0].equals("-p") && args[2].equals("-u")) {
			User user = new User(args[3],args[1]);
			return user.equals(users); //sickar infon till userklassen där users equals funktion kollar att inloggningsuppgifterna stämmer
		}
		return false;
	}
	
	// returnerar en boolean om det man skickar in är ett bokningsnummer eller ej
	
	public boolean isBookingNumber(String bookingNumber) {
		return Bookings.containsKey(bookingNumber);
	}
	
	// returnerar en boolean om det man skickar in är en airline eller ej
	
	public boolean isAirline(String inp1) {
		
		for(Airline airlineName : airlineNames) {
			if(((airlineName.toString()).toLowerCase()).equals(inp1.toLowerCase())) {
				return true;
			}
		}
		return false;
//		return airlineNames.contains(inp1);
			
		
		
//		for(String airlineName : Airlines.values()) {
//			if((airlineName.toLowerCase()).equals((inp1.toLowerCase()))) {
//				return true;
//			}
//		}
//		return false;
	}
	
	// returnerar en boolean om det man skickar in är en veckodag eller ej
	
	public boolean isDay(String inp1) {
		inp1 = inp1.toLowerCase();
		
		for(int i = 0; i < days.length; i++) {
			if(days[i].equals(inp1)) {
				return true;
			}
		}
		return false;
	}
	
	// returnerar en boolean om det man skickar in är ett flight eller ej
	
	public boolean isFlight(String flightNumber) {
		return Flights.containsKey(flightNumber);

	}
	
	// returnerar en boolean om airline:en man skickar in redan har en rutt mellan de två städer man skickar in
	
	public boolean checkFlightCities(String depCity, String arrCity, String airline) {
		
		for(String varFlightNumber : Flights.keySet()) {
			
			if(getFlightDepCity(varFlightNumber).equals(depCity) && getFlightArrCity(varFlightNumber).equals(arrCity) && getFlightAirline(varFlightNumber).equals(airline)) {
				return false;
			}
		}
		return true;
	}
	
	//returnerar en boolean om det formatet på flightnumret man skrivit in stämmer
	
	public boolean checkFlightNumberFormat(String flightNumber) {
		
		if(!(flightNumber.length()==5)) {
			return false;
		}
		
		String letters = flightNumber.substring(0, 2);
		String numbers = flightNumber.substring(2, 5);
		
		if(letters.matches("[A-Z]+") && numbers.matches("^[0-9]+$")) {
			return true;
		}
		return false;
	}
	
	//returnerar en boolean om det formatet på tiden man skrivit in stämmer
	
	public boolean checkTimeFormat(String depTime) {
		
		if(!(depTime.length() == 5)) {
			return false;
		}
		
		String hours = depTime.substring(0, 2);
		String minutes = depTime.substring(3 , 5);
		char symbol =  depTime.charAt(2);
		
		if(hours.matches("^[0-9]+$") && symbol == ':' && minutes.matches("^[0-9]+$") && Integer.valueOf(hours) < 24 && Integer.valueOf(minutes) < 60) {
			
			return true;
		}
		return false;
	}
	
	//returnerar en boolean om det formatet på id man skrivit in stämmer
	
	public boolean checkIDFormat(String ID) {
		
		if(ID.length() == 8 && ID.matches("^[0-9]+$")) {
			return true;
		}
		
		return false;
	}
	
	//gör om den stringen man skickar in till en int
	
	public int makeIntoANumber(String inp1) {
		
		return Integer.valueOf(inp1);
		
	}
	
	//returnerar en boolean om den stringen man skickar in bara innehåller siffror eller ej
	
	public boolean isANumber(String inp1) {
		return inp1.matches("^[0-9]+$");
	}
	
	//returnerar en boolean om stringen man skikar in är en passenger eller ej
	public boolean isAPassenger(String pass) { //pass är uppbyggt med namn + " " + id 
		return passengers.contains(pass);
	}
}
