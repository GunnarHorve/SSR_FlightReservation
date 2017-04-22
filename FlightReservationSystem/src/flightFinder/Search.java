package flightFinder;
import java.util.*;
import Models.Airport;
import Models.Flight;

import java.text.DateFormat;
import QueryManager.queryManager;



public class Search{
    private List<List<Flight>> ans = null;
    private List<List<Flight>> finalAns = null;
    private String end_code = null;
    private String seat;
    private int coachReserved;
    private int firstReserved;
    //private int maxStopOver;
    //private List<Flight> row = null;
    public Search() {
        ans = new ArrayList<List<Flight>>();
        finalAns = new ArrayList<List<Flight>>();
        //row = new ArrayList<Flight> ();
    }
    
    public List<List<Flight>> Search_Path(String start_code, String end_code, Date depTime, int maxStopOver){
    	
        Stack<Flight> s = new Stack<Flight>();
        this.end_code = end_code;
        this.dfs(start_code, depTime, 0 , s);
        for(List<Flight> listFlight: this.ans){
        	if (listFlight.size()-1 == maxStopOver){
        		finalAns.add(listFlight);
        	}
        }
        return this.finalAns;
    }
    
    private void dfs(String now_code, Date depTime, int depth, Stack<Flight> s){
        if (now_code.equals(this.end_code)){
        	//row.add(s.clone());
            ans.add((List<Flight>)s.clone()); // s.clone to list
        }
        if (depth > 2) return;
        for (Flight arrival:queryManager.getDepFlights(now_code, depTime)){
            if (depth==0){
            	//System.out.println(++i);
                s.add(arrival);
                dfs(arrival.arr.code,arrival.arrDate,depth+1,s);
                s.pop();
            }else if (canfly(arrival,depTime)){
            	//System.out.println(++i);
                s.add(arrival);
                dfs(arrival.arr.code,arrival.arrDate,depth+1,s);
                s.pop();
            }
        }
    }

    // check whether the next flight departures no more than 4 hours
    // to do: more than 0.5 hour
    
    
    private boolean canfly(Flight f, Date arr){
//    	System.out.println(x);
    	boolean early = f.depDate.getTime() < arr.getTime() + 30*60*100; // 30*60*100 is 30 minutes in milliseconds
    	boolean late = f.depDate.getTime() > arr.getTime() + 4*60*60*100; //+ f.duration*60*100; // 4*60*60*100 is 4 hours in milliseconds
        return !early && !late; 
    }
    
    // check whether the capacity has been occupied
    private boolean canReserve(Flight f, Date arr, String seat){
    	if (this.seat=="Coach"){
    		 coachReserved++;
    		 if(coachReserved<=f.coachSeats){
    			 System.out.println("1");
    			 return true;
    		 }
    		 
    	}
    	if (this.seat == "First Class"){
    		firstReserved++;
    		if(firstReserved<=f.firstSeats){
    			System.out.println("2");
    			return true;
    		}
    	}
    	System.out.println("3");
    	return false;
    }
    
    
}