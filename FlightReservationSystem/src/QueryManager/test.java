package QueryManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.Flight;

public class test {
	public static void main(String[] args){
		List<Flight> ans = new ArrayList<Flight> ();
		
//		queryManager res = new queryManager();
		
		String airportCode = "BDL";
		Date date= new Date("2017 May 09");
		
//		queryManager a = new queryManager();
		ans = queryManager.getDepFlights(airportCode, date);
		int size = ans.size();
		for(int i = 0; i<size; i++){
			System.out.println(ans.get(i));
		}
	}
}
