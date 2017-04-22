package QueryManager;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import Models.Flight;
import flightFinder.Search;   	


public class testQuery {
	@Test
	public void testQq(){
		List<Flight> ans = new LinkedList<>();
		queryManager q = new queryManager();
		Date dep = new Date("2017 May 09 12:20:21");
		ans = q.getDepFlights("DCA",dep);
		int size = ans.size();
		for(int i = 0;i<size; i++){
			System.out.println(ans.get(i));
		}
	}
}
