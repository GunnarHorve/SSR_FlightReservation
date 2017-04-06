package flightFinder;
import java.util.*;

import Models.Airplane;
import Models.Airport;
import Models.Flight;
import QueryManager.queryManager;

public class FlightTrail{
	  public static void main(String[] args) {
		   Calendar cal = Calendar.getInstance();
		   Calendar future = Calendar.getInstance();

		   // print the current date
		   System.out.println("Current date: " + cal.getTime());
		   future.set(Calendar.YEAR, 2018);
		   System.out.println("Future Year is " + future.get(Calendar.YEAR));
		   Date time = future.getTime();
		   if (future.after(cal)) {
		   System.out.println("Date " + time + " is after current date.");
		   }
	  }
}