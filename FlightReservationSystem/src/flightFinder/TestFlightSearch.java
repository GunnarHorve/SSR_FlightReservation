//package flightFinder;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.LinkedList;
//import java.util.List;
//
//import org.junit.Test;
//import Models.Flight;
//import Models.Airport;
//
//public class TestFlightSearch {
//	@Test
//	public void testFlishtSearch(){
//		Search s = new Search();
//
//		ArrayList<ArrayList<Flight>>res = new ArrayList<>();
//		Date dep = new Date("2017 May 09");
//		
//		Models.Airport depar = new Models.Airport("BOS","Logan International",0);
//		Models.Airport arr = new Models.Airport("ORD","Chicago O'Hare International",1);
//		res = s.Search_Path(depar, arr, dep, 2, true);
//		//System.out.println(res.size());
//		int i =1;
//		for(List<Flight> lf: res){
//			//System.out.println(i++);
//			for(Flight f: lf){
//				System.out.println(f.toString());
//			}
//		}
//	}
//
//}
