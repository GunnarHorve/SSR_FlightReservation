package Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * A model meant to contain data about a given flight.
 * Ideally, this class only holds data queried from server.
 */
public class Flight {
	public Airplane type;		// type of airplane
	public int duration;		// how long the flight is to last (in minutes)
	public int num;				// UID flight number
	
	public Airport dep;			// departing airpot
	public Airport arr;			// arrival airport
	
	public String depTime;		// departure time formatted as: "YYYY MMM DD HH:MM" + " GMT"
	public String arrTime;		// arrival time   formatted as: "YYYY MMM DD HH:MM" + " GMT"
	
	public double firstPrice;	// first class ticket price
	public double coachPrice;	// coach class ticket price
	
	public int firstSeats;		// # of already reserved first class seats
	public int coachSeats;		// # of already reserved coach class seats
	
	public Flight(Airplane type, int duration, int num, Airport dep, Airport arr, String depTime, String arrTime, double firstPrice, double coachPrice, int firstSeats, int coachSeats) {
		this.type = type;
		this.duration = duration;
		this.num = num;
		this.dep = dep;
		this.arr = arr;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.firstPrice = firstPrice;
		this.coachPrice = coachPrice;
		this.firstSeats = firstSeats;
		this.coachSeats = coachSeats;
	}
	
	public String toString(){
		return "Airplane[type = "+type+",duration = "+duration+",num = "+num+",dep = "+dep+",arr = "+arr+",depTime = "+depTime+","
				+ "arrTime = "+arrTime+",firstPrice = "+firstPrice+",coachPrice = "+coachPrice+",firstSeats = "+firstSeats+",coachSeats = "+coachSeats+",]";
	}
	
	/*
	 * Returns departure time in ms since epoch
	 */
	
	
	public Long getEpochDeparture() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd hh:mm zzz");
		
		try {
			Date date = sdf.parse(this.depTime);
			return date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1L;
	}
	
	/*
	 * Returns arrival time in ms since epoch
	 */
	public Long getEpochArrival() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd hh:mm zzz");
		
		try {
			Date date = sdf.parse(this.arrTime);
			return date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1L;
	}
}
