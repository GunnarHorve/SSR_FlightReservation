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
		int many = 0;
		Search s = new Search();
		List<List<Flight> >res = new LinkedList<>();
		Date dep = new Date("2017_May_09");
		res = s.Search_Path("BOS", "SFO", dep);
		int size = res.size();
		for(int i = 0; i<size; i++){
			System.out.println(res.get(i));
		}
		//System.out.println(res.iterator().next().toString());
	}

}
