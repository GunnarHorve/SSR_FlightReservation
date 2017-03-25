package flightFinder;
import java.util.*;

import Models.Airport;
import Models.Flight;

import java.text.DateFormat;
import QueryManager.queryManager;;

public class Search {
	public static List<List<Flight>> SearchBFS(String start, Airport end, Date depTime){  // String or AIRPORT TYPE
		
		List<List<Flight>> ans = new ArrayList<List<Flight>> (); // type of stack undecided
		Queue<Flight> queue = new LinkedList<Flight> (); //type of stack undecided
		
		/*get the result list of departure */
		
		List<Flight> arrCollection = new ArrayList<Flight> ();
		arrCollection = queryManager.getArrFlights(start, depTime);// can I pass the result like this?? 
		for(Flight arrival: arrCollection){
			queue.add(arrival);
		}
				
		int depth = 0;
		
		while(depth<3){
			if(queue.size() == 0) break;
			Flight curr = queue.poll(); // node -- type
		
			List<Flight> row = new ArrayList<Flight> ();
	

			if(curr.arr == end){
				row.add(curr);
				ans.add(row);
				continue;
			}
			
			
			else{
				depth++;
				//List<Flight> level = new ArrayList<Flight> ();
				//level = queryManager.getArrFlights(curr.arr, date);
				for(Flight arr : arrCollection){
					if(!stopHours(curr.depDate, arr.arrDate)){  //meet the need of less than 4 hours and 
																// arrDate > depDate
						continue;
					}
					if(!classCo()){
						continue;
					}
					stack.push(queryManager.getArrFlights(curr,date));
				}					
			}
			
		}
		return ans;
	}
	
	public static boolean stopHours(Date arr, Date dep){ 
		switch 
		case:
		case
		
	}
	public static boolean classssCo(){
		
	}

}
