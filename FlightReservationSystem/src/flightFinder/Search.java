package flightFinder;
import java.util.*;


import Models.Airport;
import Models.Flight;

import java.text.DateFormat;
import QueryManager.queryManager;



public class Search{
    private List<List<Flight>> ans = null;
    private String end_code = null;
    private String seat;
    private int coachReserved;
    private int firstReserved;
    //private List<Flight> row = null;
    Search() {
        ans = new ArrayList<List<Flight>>();
        //row = new ArrayList<Flight> ();
    }
    
    public List<List<Flight>> Search_Path(String start_code, String end_code, Date depTime){
        Stack<Flight> s = new Stack<Flight>();
        this.end_code = end_code;
        this.dfs(start_code, depTime, 0 , s);
        return this.ans;
    }

    private void dfs(String now_code, Date depTime, int depth, Stack<Flight> s){
        if (now_code.equals(this.end_code)){
        	//row.add(s.clone());
            ans.add((List)s.clone()); // s.clone to list
            
        }
        if (depth > 3) return;
        for (Flight arrival:queryManager.getDepFlights(now_code, depTime)){
        	
            if (depth==0 || canfly(arrival,depTime)){
            		//&& canReserve(arrival, depTime, seat))){
            	System.out.println(arrival);
                s.add(arrival);
                dfs(arrival.arr.code,arrival.arrDate,depth+1,s);
                s.pop();
            }
        }
    }

    // check whether the next flight departures no more than 4 hours
    // to do: more than 0.5 hour
    private boolean canfly(Flight f, Date arr){
    	
    	boolean early = f.depDate.getTime() < arr.getTime() + 30*60*100; // 30*60*100 is 30 minutes in milliseconds
    	boolean late = f.depDate.getTime() > arr.getTime() + 4*60*60*100; // 4*60*60*100 is 4 hours in milliseconds
    	
    	
      /*  Calendar current = Calendar.getInstance();
        current.setTime(arr);
        Calendar fdate = Calendar.getInstance();
        fdate.setTime(f.arrDate);
        current.add(Calendar.HOUR,4);*/
        return !early && !late; 
    }
    
    // check whether the capacity has been occupied
    private boolean canReserve(Flight f, Date arr, String seat){
    	if (this.seat=="Coach"){
    		 coachReserved++;
    		 if(coachReserved<=f.coachSeats) return true;
    	}
    	if (this.seat == "First Class"){
    		firstReserved++;
    		if(firstReserved<=f.firstSeats) return true;
    	}
    	return false;
    }
}
    
    
