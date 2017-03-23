package QueryManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.Airplane;
import Models.Airport;
import Models.Flight;

public class queryManager {
	
	private static String baseURL = "http://cs509.cs.wpi.edu:8181/CS509.server/ReservationSystem?team=SSR&action=list";
	
	//prevent this class from being instantiated
	private queryManager() { }
	
	public static void main(String[] args){

//		Airport arrAirport = new Airport("arrAirport","BOS",5);
//		Airport depAirport = new Airport("depAirport","CVG",5);
//		List<Flight> flights = getFlights(arrAirport,depAirport,"2017 May 10 00:54 GMT");
//		for(Flight flight : flights){
//			System.out.println(flight.toString());
//		}
//		String str = "2017 May 10 00:54 GMT";
//		System.out.println(getDate(str));

//		Airport arrAirport = new Airport("arrAirport","BOS",5);
//		Airport depAirport = new Airport("depAirport","CVG",5);
//		List<Flight> flights = getFlights(arrAirport,depAirport, "2017 May 10 00:54 GMT");
//		for(Flight flight : flights){
//			System.out.println(flight.toString());
//		}
//		
//		
//		List<Flight> depFlights = getDepFlights(depAirport,"2017 May 10 00:54 GMT");
//		for(Flight flight : depFlights){
//			System.out.println(flight.toString());
//		}
//		
//		List<Flight> arrFlights = getArrFlights(arrAirport,"2017 May 10 02:31 GMT");
//		for(Flight flight : arrFlights){
//			System.out.println(flight.toString());
//		}
//		String str = "Logan International";
//		String date = "2017 May 11 02:31 GMT";
//		Date temp = getEDTDate(date);
//		System.out.println(temp);
//		List<Flight> flights = getFlights_noDep(str,temp);
//		int i =0;
//		for(Flight flight : flights){
//			System.out.println(i+flight.toString());
//			i++;
//		}
		System.out.println("Query Manager's main ran");
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
	
	public static List<Flight> getDepFlights(String airportCode, Date date) {
		   String modifiedDate= new SimpleDateFormat("yyyy_MM_dd").format(date);		   
		   String query = baseURL + "&list_type=departing&airport=" + airportCode + "&day=" + modifiedDate;
		   return XMLParser.parseFlights(getXMLFromServer(query));
	}
	
	public static List<Flight> getArrFlights(String airportCode, Date date) {
		   String modifiedDate= new SimpleDateFormat("yyyy_MM_dd").format(date);		   
		   String query = baseURL + "&list_type=arriving&airport=" + airportCode + "&day=" + modifiedDate;
		   return XMLParser.parseFlights(getXMLFromServer(query));
	}
	
	public static String getXMLFromServer (String query) {
		  URL url;
		  HttpURLConnection connection;
		  BufferedReader reader;
		  String line;
		  StringBuffer result = new StringBuffer();

		  try {
		   /**
		    * Create an HTTP connection to the server for a GET 
		    */			  			  
		   url = new URL(query);
		   
		   System.out.println(url.toString());
		   connection = (HttpURLConnection) url.openConnection();
		   connection.setRequestMethod("GET");

		   /**
		    * If response code of SUCCESS read the XML string returned
		    * line by line to build the full return string
		    */
		   int responseCode = connection.getResponseCode();
		   if ((responseCode >= 200) && (responseCode <= 299)) {
		    InputStream inputStream = connection.getInputStream();
		    String encoding = connection.getContentEncoding();
		    encoding = (encoding == null ? "URF-8" : encoding);

		    reader = new BufferedReader(new InputStreamReader(inputStream));
		    while ((line = reader.readLine()) != null) {
		     result.append(line);
		    }
		    reader.close();
		   }
		  } catch (Exception e) {
		   e.printStackTrace();
		  }

		  return result.toString();
		 }

	public boolean lock(Flight flight){
		return true;
	}
	public boolean unlock(Flight flight){
		return true;
	}
}
