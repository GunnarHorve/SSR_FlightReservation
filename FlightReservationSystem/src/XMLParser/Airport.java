package XMLParser;

public class Airport {


	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongtitude() {
		return Longtitude;
	}
	public void setLongtitude(String longtitude) {
		Longtitude = longtitude;
	}
	public String getGMTOffset() {
		return GMTOffset;
	}
	public void setGMTOffset(String gMTOffset) {
		GMTOffset = gMTOffset;
	}
	private String Code;
	private String Name;
	private String Latitude;
	private String Longtitude;
	private String GMTOffset;
	@Override
	public String toString(){
		return "Airport[code = "+Code+",name = "+Name+",latitude = "+Latitude+",longtitude = "+Longtitude+",GMTOffset = "+GMTOffset+"]";
	}
}
