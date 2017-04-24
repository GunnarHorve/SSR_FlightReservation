package flightFinder;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import Models.Flight;
import nouse.welcome;

public class TestFlightSearch {
	@Test
	public void testFlishtSearch(){
		Search s = new Search();
		List<List<Flight>>res = new ArrayList<>();
		Date dep = new Date("2017 May 10");
		res = s.Search_Path("BOS", "ORD", dep, 2, true);
		//System.out.println(res.size());
		int i =1;
		for(List<Flight> lf: res){
			//System.out.println(i++);
			for(Flight f: lf){
				System.out.println(f.toString());
			}
		}
	}

}
