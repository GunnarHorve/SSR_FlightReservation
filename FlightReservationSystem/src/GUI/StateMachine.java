package GUI;

import java.util.ArrayList;
import java.util.List;

import Models.Flight;
import Models.Order;
import flightFinder.Search;

/*
 * TODO's:
 * 	+add more variables to search
 *  +actually load a confirmation screen (and save selected items to do so)
 *  +display flight data in a table
 *  +UI error checking
 *  +optimize search
 */
public class StateMachine {

	
	private StateMachine() { }
	
	public static StateMachine getInstance() {
		if(sm == null) {
			sm = new StateMachine();
		}
		return sm;
	}
	
	public enum state { input_params_first, input_params_second, display_flights, confirm_order, finish}	
	
	private static StateMachine sm;
	public Order order;
	public SceneSwitcher sceneSwitcher;
	public List<List<Flight>> flights = new ArrayList<List<Flight>>();
		
	
	private void performSearch() {
		 System.out.println("searching flights.  Wait a moment!");
		 if(order.secondRound) { //1st time searching
			 this.flights =  new Search().Search_Path(order.dep.code, order.arr.code, order.depDate);
		 } else {
			 this.flights =  new Search().Search_Path(order.dep.code, order.arr.code, order.secondDepDate);
		 }
		 System.out.println("finished searching flights.  Sorry it took so long!");
	}
	
	public void switchState(state s) {
		switch(s) {
		case input_params_first:
			this.sceneSwitcher.displayFirst();
			break;
		case input_params_second:
			this.sceneSwitcher.displaySecond();
			break;
		case display_flights:
			performSearch();
			this.sceneSwitcher.displayFlightsDisplay();
			break;
		case confirm_order:
			System.out.println("confirm order called");
			switchState(state.finish);
			break;
		case finish:
			System.out.println("finish called");
			sceneSwitcher.close();
			break;
		default:
			break;
		}
	}
	
}