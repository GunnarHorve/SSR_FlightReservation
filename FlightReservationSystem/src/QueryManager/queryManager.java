package QueryManager;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import Models.Airplane;
import Models.Airport;
import Models.Flight;
import XMLParser.XMLParser;

public class queryManager {
	public static void main(String[] args){

//		Airport arrAirport = new Airport("arrAirport","BOS",5);
//		Airport depAirport = new Airport("depAirport","CVG",5);
//		List<Flight> flights = getFlights(arrAirport,depAirport,"2017 May 10 00:54 GMT");
//		for(Flight flight : flights){
//			System.out.println(flight.toString());
//		}
//		String str = "2017 May 10 00:54 GMT";
//		System.out.println(getDate(str));

	}

	
		
	
	
	
	public static List<Flight> requestFlights(){
		List<Flight> lists = new ArrayList<>();
		
		
		return lists;
	}
	public static void reserveFlight(Flight flight){
		
	}
	public static void reserveFlights(ArrayList<Flight> lists){
		
	}
	
public static List<Airport> getAllAirports(){
		File file = new File("src/Data/airports.xml");
		List<Airport> airports = XMLParser.readAirport(file);
		return airports;
	}
	
	public static List<Airplane> getAllAirplanes(){
		File file = new File("src/Data/Airplanes.xml");
		List<Airplane> airplanes = XMLParser.readAirplane(file);
		return airplanes;
	}
	
	public static List<Flight> getAllFlights(){
		File file = new File("src/Data/ArrivingFlights.xml");
		List<Flight> flights = XMLParser.readFlight(file);
		File file1 = new File("src/Data/DepartingFlights.xml");
		List<Flight> flights1 = XMLParser.readFlight(file1);
		flights.addAll(flights1);
		return flights;
	}
	
	public static List<Flight> getFlights(Airport arrAirport, Airport depAirport,String date){
		List<Flight> flights = getAllFlights();
		List<Flight> selectedFlights = new ArrayList<>();
		for(Flight flight : flights){
			try{
				if(arrAirport.code.equals(flight.arr.code)&&
				depAirport.code.equals(flight.dep.code)&&
				date.equals(flight.depTime))
				selectedFlights.add(flight);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return selectedFlights;
	}
	
//	public static String getDate(String str){
//		//String temp = "";
//		int count = 0;
//		int i = 0;
//		while(count<3){
//			if(str.charAt(i)==' ') count++;
//			++i;
//		}
//		
//	return str.substring(0, i);
//	}
	
	public static List<Flight> getFlights_noDep(String arrAirport,Date date){
		List<Flight> flights = getAllFlights();
		List<Flight> selectedFlights = new ArrayList<>();
		for(Flight flight:flights){
			try{
				Date depDate = getEDTDate(flight.depTime);
				if(arrAirport.equals(flight.arr.name)&&date.getMonth()==depDate.getMonth()&&date.getDate()==depDate.getDate()){
					selectedFlights.add(flight);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return selectedFlights;
	}
	
	
	public static  Date getEDTDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm zzz",Locale.ENGLISH);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			
			Date date = sdf.parse(str);
			
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean lock(Flight flight){
		return true;
	}
	public boolean unlock(Flight flight){
		return true;
	}
}
