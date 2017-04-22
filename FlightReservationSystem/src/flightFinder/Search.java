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
    private HashMap<String, List<Flight>> myMap = new HashMap<String, List<Flight>>();

   
    String startAirport;
  
    public Search() {
        ans = new ArrayList<List<Flight>>();
        finalAns = new ArrayList<List<Flight>>();
     
    }
    

     
    /**
     * 
     * A main method of the class, which is to return all the result list.
     * 
     * 
     * @param start_code 	the departure airport   
     * @param end_code
     * @param depTime
     * @param maxStopOver
     * @param isFirstClass
     * @return
     */
    
    public List<List<Flight>> Search_Path(String start_code, String end_code, Date depTime, int maxStopOver, boolean isFirstClass){
    	
        ArrayList<Flight> s = new ArrayList<Flight>();
        this.end_code = end_code;
        this.dfs(start_code, depTime, 0 , s, isFirstClass, maxStopOver);
        return this.ans;
    }
    
    private void dfs(String now_code, Date depTime, int depth, ArrayList<Flight> s, boolean isFirstClass, int maxStopOver){
    	
        if (now_code.equals(this.end_code)&&!now_code.equals(this.startAirport)){
            ans.add((List<Flight>)s.clone()); // s.clone to list
        }
        if (depth > maxStopOver) return;
        for (Flight getArrival : getFlights(now_code, depTime)){
        
            	if (canfly(getArrival,depTime,isFirstClass,depth)){
                s.add(getArrival);
                dfs(getArrival.arr.code,getArrival.arrDate,depth+1,s,isFirstClass, maxStopOver);
                s.remove(s.size()-1);
            }
        }
    }

    // check whether the next flight departures is between 0.5 hour and  4 hours;
    // check whether the 
    
    
    
    private boolean canfly(Flight f, Date arr, boolean isFirstClass, int depth){
    	
    	boolean validTime = true;
    	if(depth != 0) {
        	boolean early = f.depDate.getTime() < arr.getTime() + 30*60*1000; // 30*60*100 is 30 minutes in milliseconds
        	boolean late = f.depDate.getTime() > arr.getTime() + 4*60*60*1000; //+ f.duration*60*100; // 4*60*60*100 is 4 hours in milliseconds
        	validTime = !early && !late;
    	}
    	
    	boolean hasSpace = true;
    	if(isFirstClass){
    		hasSpace = f.type.totFirst - f.firstSeats >= 0;
    				
    	} else {
    		hasSpace = f.type.totCoach - f.coachSeats >= 0;
    	}
    		return hasSpace && validTime;
    }
    
    
    private List<Flight> getFlights(String now_code, Date depTime) {
    	
    	if(!myMap.containsKey(now_code)) {
        	List<Flight> myQuery = queryManager.getDepFlights(now_code, depTime);
        	myMap.put(now_code, myQuery);
    	}
    	
    	return myMap.get(now_code);
    }
    
    
}