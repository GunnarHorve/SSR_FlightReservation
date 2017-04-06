package flightFinder;

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
		List<List<Flight> >res = new LinkedList<>();
		Date dep = new Date("2017 May 09 10:20:21");
		res = s.Search_Path("BOS", "SFO", dep);
		System.out.println(res.iterator().next().iterator().next().toString());
	}

}
