package Models;

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
	
	public String depTime;		// departure time
	public String arrTime;		// arrival time
	
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
}
