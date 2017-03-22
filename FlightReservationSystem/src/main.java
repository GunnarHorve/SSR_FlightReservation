import java.io.File;
import java.util.List;
import XMLParser.XMLParser;
import Models.Airport;

public class main {
	public static void main(String[] args) {
		File file = new File("src/Data/airports.xml");
		List<Airport> airports = readAirport(file);
		for(Airport airport : airports){
			System.out.println(airport.toString());
		}
	}
}