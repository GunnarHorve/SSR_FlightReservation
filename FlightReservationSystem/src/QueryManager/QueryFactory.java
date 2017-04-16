package QueryManager;

public class QueryFactory {
	public static String lock (String ticketAgency) {
		return "team=" + ticketAgency + "&action=lockDB";
	}
	
	public static String unlock (String ticketAgency) {
		return "team=" + ticketAgency + "&action=unlockDB";
	}
	
	public static String reserve (String ticketAgency, String xmlFlights) {
		String query = "team=" + ticketAgency;
		query = query + "&action=buyTickets";
		query = query + "&flightData=" + xmlFlights;
		return query;
	}
}
