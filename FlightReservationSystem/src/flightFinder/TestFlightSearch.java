package flightFinder;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import Models.Flight;   
import GUI.welcome;

public class TestFlightSearch {
	@Test
	public void testFlishtSearch(){
		Search s = new Search();
		List<List<Flight>>res = new ArrayList<>();
		Date dep = new Date("2017 May 09");
		res = s.Search_Path("BOS", "EWR", dep, 1);
		//System.out.println(res.size());
		int i =1;
		for(List<Flight> lf: res){
			//System.out.println(i++);
			for(Flight f: lf){
				System.out.println(lf.toString());
			}
		}
	}

}
