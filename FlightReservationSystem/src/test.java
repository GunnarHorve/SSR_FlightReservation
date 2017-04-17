import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import Models.Flight;
import QueryManager.queryManager;

public class test {
	public static void main(String[] args){
		List<Flight> ans = new ArrayList<Flight> ();
//		queryManager res = new queryManager();
		
		String airportCode = "BOS";
		Date date= new Date("2016 May 10");
		
		
		List<Flight> list = queryManager.getDepFlights(airportCode, date);
		/*For(Flight flight : list){
			System.out.println(x);
		}*/
		
		
		// System.out.println(d);
		//  ans = res.getDepFlights("BOS",d);
		//  for (Flight flight: ans){
			//System.out.println(flight);
		}
}
