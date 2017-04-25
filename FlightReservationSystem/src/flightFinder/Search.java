package flightFinder;
import java.util.*;
import Models.Airport;
import Models.Flight;

import java.text.DateFormat;
import QueryManager.queryManager;



public class Search{
    private ArrayList<ArrayList<Flight>> ans = null;
    private ArrayList<ArrayList<Flight>> finalAns = null;
    private String end_code = null;
    private String seat;
    private int coachReserved;
    private int firstReserved;
    private HashMap<String, ArrayList<Flight>> myMap = new HashMap<String, ArrayList<Flight>>();

   
    String startAirport;
  
    public Search() {
        ans = new ArrayList<ArrayList<Flight>>();
        //finalAns = new ArrayList<List<Flight>>();
     
    }
    

     
    /**
     * 
     * A main method of the class, which is to return all the result list.
     * 
     * This function passes departure airport code, arrival airport code, departure date, the maxium stop overs users 
     * would like to have and the seat class the users has chosen, then it would call dfs(depth first search) function 
     * later and the searching result corresponding to users' requirement. 
     * 
     * @param start_code 	departure airport's code users has selected in GUI
     * @param end_code		arrival airport's code users has selected in GUI
     * @param depTime		departure date users would like to leave  
     * @param maxStopOver	how many stop overs the users would like to take, the choice includes 0,1 and 2 
     * @param isFirstClass	boolean is true when it is first class, false when it is coach class
     * @return				the final result to present in GUI
     */
    
    public ArrayList<ArrayList<Flight>> Search_Path(String start_code, String end_code, Date depTime, int maxStopOver, boolean isFirstClass){
        ArrayList<Flight> s = new ArrayList<Flight>();
        this.end_code = end_code;
        this.dfs(start_code, depTime, 0 , s, isFirstClass, maxStopOver);
        return this.ans;
    }
    
    
    /**
     * This is where we implement the Depth First Search algorithm, the main idea is to recursively call the dfs until
     *  "max stopover" achieved.
     * 
     * Call "getFlights" repeatedly to get all arrival airports by given departure airports and date.
     * Update now_code, depTime, depth and s repeatedly until we get the desired arrival airport, which meets time limit and has space. 
     * We have avoided the situation when the user flies back to where he has departed before.
     *  
     * @param now_code 		Meaning current departure airport code, if depth is not 0, it is 
     * 						the arrival airport from the previous layer; if depth is 0, then it is the 
     * 						departure airport the users would like to leave
     * 
     * @param depTime 		Meaning to pass current departure date, if depth is not 0, it is 
     * 						the arrival airport's arrival date from the previous layer; if depth is 0, then it is the 
     * 						departure date the users would like to leave.
     * @param depth			Means stopover.
     * @param s				To store the arrival airports.
     * @param isFirstClass	whether the seat is first class or coach class
     * @param maxStopOver	how many stop overs users would like to take in maxium, 0,1 or 2.
     */
    
    private void dfs(String now_code, Date depTime, int depth, ArrayList<Flight> s, boolean isFirstClass, int maxStopOver){
    	
        if (now_code.equals(this.end_code)&&!now_code.equals(this.startAirport)){
            ans.add((ArrayList<Flight>)s.clone()); // s.clone to list
            return;
        }
        if (depth > maxStopOver) return;
        for (Flight getArrival : getFlights(now_code, depTime)){
            	if (canfly(getArrival,depTime,isFirstClass,depth)){
                s.add(getArrival);
                dfs(getArrival.arr.code,getArrival.arrDate,depth+1,s,isFirstClass, maxStopOver);
                int last = s.size()-1;
                s.remove(last);
            }
        }
    }

    
    
    /**
     * A helper function, to check whether the flight has met the time constraint and seat constraint.
     * 
     * To check whether the stop over time is between 0.5 hour to 4 hours, and the flight has space for chosen seat class.
     * 
     * @param f  			the flight info of the arrival airpot of last layer.	
     * @param arr			departure time
     * @param isFirstClass 	true when it is first class, false when it is not
     * @param depth			stopover time constraint should just work when depth is to 0.
     * @return
     */
    
    
    private boolean canfly(Flight f, Date arr, boolean isFirstClass, int depth){
    	
    	boolean validTime = true;
    	if(depth == 0){
    		this.startAirport = f.dep.code;
    	}
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
    
    /**
     * A helper fucntion to optimize the DFS and make it more efficient.
     * 
     * If we have searched flight info given the departure airport and departure date, then we retrive its info from hashmap,
     * else, we put the airpot code and flight info into the hash map together.
     * 
     * @param now_code		current departure airport code
     * @param depTime		current layer's departure date
     * @return				i
     */
    
    private List<Flight> getFlights(String now_code, Date depTime) {
    	
    	if(!myMap.containsKey(now_code)) {
    		ArrayList<Flight> myQuery = queryManager.getDepFlights(now_code, depTime);
        	myMap.put(now_code, myQuery);
    	}
    	
    	return myMap.get(now_code);
    }
    
    
}