package Models;

/*
 * A model meant to contain data about a given US airport.
 * Ideally, this class only holds data queried from server.
 */
public class Airport {
	private int gmtOffset;
	private String code;
	private String name;
	
	public Airport(String name, String code, int gmtOffset) {
		this.gmtOffset = gmtOffset;
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
	 * returns local time offset from GMT in hours
	 */
	public int getGMTOffset() {
		return gmtOffset;
	}
}
