package XMLParser;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Models.Airplane;
import Models.Airport;
import Models.Flight;


public class XMLParser {
	public static void main(String[] args){
//		File file = new File("src/Data/airports.xml");
//		List<Airport> airports = readAirport(file);
//		for(Airport airport : airports){
//			System.out.println(airport.toString());
//		}
//		File file1 = new File("src/Data/Airplanes.xml");
//		List<Airplane> airplanes = readAirplane(file1);
//		for(Airplane airplane : airplanes){
//			System.out.println(airplane.toString());
//		}
//		File file2 = new File("src/Data/ArrivingFlights.xml");
//		List<Flight> flights = readAirport();
//		for(Flight flight : flights){
//			System.out.println(flight.toString());
//		}
		String Time = "2017 May 10 20:21";
		Date date = Format(Time);
		System.out.println(date);
		
		
		
	}
	//parse the airports xml file
	public static List<Airport> readAirport(File file){
		List<Airport> lists = new ArrayList<Airport>();
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			NodeList airportList = doc.getElementsByTagName("Airport");
			for(int i =0;i<airportList.getLength();i++){
				Node airportNode = airportList.item(i);
				if(airportNode.getNodeType() == Node.ELEMENT_NODE){
					Element airportElement = (Element)airportNode;
					Airport airport = new Airport(airportElement.getAttribute("Name"),
							airportElement.getAttribute("Code"),
							Integer.valueOf(airportElement.getElementsByTagName("GMTOffset").item(0).getTextContent()));
					lists.add(airport);
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lists;
	}
	
	//parse the Airplane xml file
	public static List<Airplane> readAirplane(File file){
		List<Airplane> lists = new ArrayList<Airplane>();
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			NodeList airplaneList = doc.getElementsByTagName("Airplane");
			for(int i =0;i<airplaneList.getLength();i++){
				Node airplaneNode = airplaneList.item(i);
				if(airplaneNode.getNodeType() == Node.ELEMENT_NODE){
					Element airplaneElement = (Element)airplaneNode;
					Airplane airplane = new Airplane(airplaneElement.getAttribute("Manufacturer"),airplaneElement.getAttribute("Model"),
							Integer.valueOf(airplaneElement.getElementsByTagName("FirstClassSeats").item(0).getTextContent()),
							Integer.valueOf(airplaneElement.getElementsByTagName("CoachSeats").item(0).getTextContent()));
					lists.add(airplane);
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lists;
	}
	
	public static Airplane getAirplaneModel(String airplaneType){
		File file = new File("src/Data/Airplanes.xml");
		List<Airplane> airplanes = readAirplane(file);
		for(Airplane airplane : airplanes){
			if(airplane.model.equals(airplaneType)){
				return airplane;
			}
		}
		return null;
	}
	
	public static Airport getAirport(String airportType){
		File file = new File("src/Data/airports.xml");
		List<Airport> airports = readAirport(file);
		for(Airport airport : airports){
			if(airport.code.equals(airportType)){
				return airport;
			}
		}
		return null;
	}
	
	
	public static Date Format(String time){
		try{
			DateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm"+"GMT",Locale.ENGLISH);
			Date date = sdf.parse(time);
			return date;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//parse the arrivingFlight and departingFlight xml file
	public static List<Flight> readFlight(File file){
		List<Flight> lists = new ArrayList<Flight>();
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			NodeList flightList = doc.getElementsByTagName("Flight");
			for(int i =0;i<flightList.getLength();i++){
				Node flightNode = flightList.item(i);
				if(flightNode.getNodeType()==Node.ELEMENT_NODE){
					Element flightElement = (Element)flightNode;
					String airplaneType = flightElement.getAttribute("Airplane");
					NodeList departureList = flightElement.getElementsByTagName("Departure");
					String departureCode=null,depTime=null;
					for(int j=0;j<departureList.getLength();j++){
						Node departureNode = departureList.item(j);
						Element departureElement = (Element)departureNode;
						departureCode = departureElement.getElementsByTagName("Code").item(0).getTextContent();
						depTime = departureElement.getElementsByTagName("Time").item(0).getTextContent();
						
					}
					
					NodeList arrivalList = flightElement.getElementsByTagName("Arrival");
					String arrivalCode=null,arrTime=null;
					for(int k=0;k<arrivalList.getLength();k++){
						Node arrivalNode = arrivalList.item(k);
						Element arrivalElement = (Element)arrivalNode;
						arrivalCode = arrivalElement.getElementsByTagName("Code").item(0).getTextContent();
						arrTime = arrivalElement.getElementsByTagName("Time").item(0).getTextContent();
					}
					
					NodeList seatingList = flightElement.getElementsByTagName("Seating");
					double firstPrice=0,coachPrice=0;
					int firstNum=0,coachNum=0;
					for(int j=0;j<seatingList.getLength();j++){
						Node seatingNode = seatingList.item(j);
						Element seatingElement = (Element)seatingNode;
						NodeList firstList = seatingElement.getElementsByTagName("FirstClass");
				    	firstNum = Integer.parseInt(seatingElement.getElementsByTagName("FirstClass").item(0).getTextContent());
					    Node firstNode = firstList.item(0);
					    Element firstElement = (Element)firstNode;
					    int len1 =  firstElement.getAttribute("Price").length();
					    firstPrice = Double.valueOf(firstElement.getAttribute("Price").substring(1,len1-1));
					    NodeList coachList = seatingElement.getElementsByTagName("Coach");
					    coachNum = Integer.parseInt(seatingElement.getElementsByTagName("Coach").item(0).getTextContent());
					    Node coachNode = coachList.item(0);
					    Element coachElement = (Element)coachNode;
					    int len = coachElement.getAttribute("Price").length();
					    coachPrice = Double.valueOf(coachElement.getAttribute("Price").substring(1, len-1));   
					}
					Flight flight = new Flight(getAirplaneModel(airplaneType),Integer.parseInt(flightElement.getAttribute("FlightTime")),
							Integer.parseInt(flightElement.getAttribute("Number")),getAirport(departureCode),getAirport(arrivalCode),
							depTime,arrTime,firstPrice,coachPrice,firstNum,coachNum);
					lists.add(flight);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lists;
	}	
}
