package Models;

/*
 * A model meant to contain data about a given US airport.
 * Ideally, this class only holds data queried from server.
 */
public class Airport {
	private double latitude;
	private double longitude;
	private String code;
	private String name;
	
	public Airport(String name, String code, double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.code = code;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCode() {
		return this.code;
	}
	
	/*
	 * TODO: implement getGMTOffset
	 * returns local time offset from GMT in hours
	 */
	public int getGMTOffset() {
		return 0;
	}
	
	public double[] getCoordinates() {
		
	}
}
