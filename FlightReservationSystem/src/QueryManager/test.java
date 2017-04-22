package QueryManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.Flight;

public class test {
	public static void main(String[] args){
		
		
		String airportCode = "ANC";
		Date date= new Date("2017 May 22");
		
		List<Flight> ans = queryManager.getDepFlights(airportCode, date);

		queryManager.reserveFlights(ans,true);

		
		
	}
}
