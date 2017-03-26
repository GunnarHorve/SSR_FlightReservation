package flightFinder;
import java.util.*;


import Models.Airport;
import Models.Flight;

import java.text.DateFormat;
import QueryManager.queryManager;



public class Search{
    private List<List<Flight>> ans = null;
    private String end_code = null;
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
        if (now_code == this.end_code){
        	//row.add(s.clone());
            ans.add(s.clone()); // s.clone to list
            return;
        }
        if (depth > 3) return;
        for (Flight arrival:queryManager.getDepFlights(now_code, depTime)){
            if (depth==0 || canfly(arrival,depTime)){
                s.add(arrival);
                dfs(arrival.arr.code,arrival.arrDate,depth+1,s);
                s.pop();
            }
        }
    }

    private boolean canfly(Flight f, Date t){
        Calendar c = Calendar.getInstance();
        c.setTime(t);
        Calendar fdate = Calendar.getInstance();
        fdate.setTime(f.depDate);
        c.add(Calendar.HOUR,4);
        return c.after(fdate);    
    }
    
    
}