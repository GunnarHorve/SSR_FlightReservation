package XMLParser;



public class Airplane {
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTotFirst() {
		return totFirst;
	}

	public void setTotFirst(int totFirst) {
		this.totFirst = totFirst;
	}

	public int getTotCoach() {
		return totCoach;
	}

	public void setTotCoach(int totCoach) {
		this.totCoach = totCoach;
	}

	String manufacturer;	// manufacturer of this plane
	String model;			// model number of this plane
	int totFirst;			// how many first class seats exist on this plane
	int totCoach;			// how many coach class seats exist on this plane
	
	public Airplane(){
		
	}
	public Airplane(String manufacturer, String model, int totFirst, int totCoach) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.totFirst = totFirst;
		this.totCoach = totCoach;
	}
	
	public String toString(){
		return "Airplane[manufacturer = "+manufacturer+",model = "+model+",totFirst = "+totFirst+",totCoach = "+totCoach+"]";
	}
}

