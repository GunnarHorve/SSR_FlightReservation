package Models;

import java.util.Date;

/*
 * A model meant to contain data about a given customer flight order.
 * Ideally, this class only holds data that was input from UI.
 */
public class Order {
	public boolean firstClass;	// whether order is first class
	
	public Airport dep;			// departing airpot
	public Airport arr;			// arrival airport
	public Date depDate;
	public boolean roundtrip;  // whether we have a round trip or not
	
	public boolean secondRound = false;
	public Date secondDepDate = null;
	
	public Order(Airport dep, Airport arr, Date depDate, boolean firstClass, boolean roundtrip) {
		this.firstClass = firstClass;
		this.dep = dep;
		this.arr = arr;
		this.depDate = depDate;
		this.roundtrip = roundtrip;
	}
}