package QueryManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Models.Airplane;
import Models.Airport;
import Models.Flight;
import XMLParser.XMLParser;

public class queryManager {
	public static void main(String[] args){

		Airport arrAirport = new Airport("arrAirport","BOS",5);
		Airport depAirport = new Airport("depAirport","CVG",5);
		List<Flight> flights = getFlights(arrAirport,depAirport,"2017 May 10 00:54 GMT");
		for(Flight flight : flights){
			System.out.println(flight.toString());
		}
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
	
	
	
	
	
	
	public boolean lock(Flight flight){
		return true;
	}
	public boolean unlock(Flight flight){
		return true;
	}
}
