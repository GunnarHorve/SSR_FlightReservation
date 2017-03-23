import java.io.File;
import java.util.List;

import Models.Airport;
import XMLParser.XMLParser;

public class main {
	public static void main(String[] args) {
		File file = new File("src/Data/airports.xml");
		List<Airport> airports = XMLParser.readAirport(file);
		for(Airport airport : airports){
			System.out.println(airport.toString());
		}
	}
}