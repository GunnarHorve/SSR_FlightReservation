package Models;

public class Airplane {
	String manufacturer;	// manufacturer of this plane
	String model;			// model number of this plane
	int totFirst;			// how many first class seats exist on this plane
	int totCoach;			// how many coach class seats exist on this plane
	
	public Airplane(String manufacturer, String model, int totFirst, int totCoach) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.totFirst = totFirst;
		this.totCoach = totCoach;
	}
}
