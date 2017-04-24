package GUI;

import java.util.ArrayList;

import Models.Flight;
import Models.Order;
import flightFinder.Search;
import QueryManager.queryManager;

/*
 * TODO's:
 *  +actually load a confirmation screen (and save selected items to do so)
 *  +display flight data in a table -->calculate necessary information (per specs)
 *  
 *  +UI error checking
 *  	No flights found
 *  	No departure || arrival date before today
 *  	No departure airport same as arrival airport
 *  	No flight specified
 *  
 *  	Error window --> "no flights found"
 *  
 * 	+add more variables to search
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
	public ArrayList<ArrayList<Flight>> flights = new ArrayList<ArrayList<Flight>>();
	
	private void performSearch() {
		 this.flights =  new Search().Search_Path(order.dep.code, order.arr.code, order.depDate,order.stopovers,order.firstClass);
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
			this.sceneSwitcher.displayConfirm();			
			break;
		case finish:
			sceneSwitcher.close();
			break;
		default:
			break;
		}
	}
	
}