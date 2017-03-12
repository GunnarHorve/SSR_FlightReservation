package XMLParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import XMLParser.Airport;
import XMLParser.Airplane;


public class XMLParser {
	public static void main(String[] args){
		File file = new File("src/Data/airports.xml");
		List<Airport> airports = readAirport(file);
		for(Airport airport : airports){
			System.out.println(airport.toString());
		}
		File file1 = new File("src/Data/Airplanes.xml");
		List<Airplane> airplanes = readAirplane(file1);
		for(Airplane airplane : airplanes){
			System.out.println(airplane.toString());
		}
//		loopXMLFile();
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
					Airport airport = new Airport();
					airport.setName(airportElement.getAttribute("Name"));
					airport.setCode(airportElement.getAttribute("Code"));
					airport.setLatitude(String.valueOf(airportElement.getElementsByTagName("Latitude").item(0).getTextContent()));
					airport.setLongtitude(String.valueOf(airportElement.getElementsByTagName("Longitude").item(0).getTextContent()));
					airport.setGMTOffset(String.valueOf(airportElement.getElementsByTagName("GMTOffset").item(0).getTextContent()));
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
					Airplane airplane = new Airplane();
					airplane.setManufacturer(airplaneElement.getAttribute("Manufacturer"));
					airplane.setModel(airplaneElement.getAttribute("Model"));
					airplane.setTotFirst(Integer.valueOf(airplaneElement.getElementsByTagName("FirstClassSeats").item(0).getTextContent()));
					airplane.setTotCoach(Integer.valueOf(airplaneElement.getElementsByTagName("CoachSeats").item(0).getTextContent()));
					lists.add(airplane);
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lists;
	}
	
//	//traversal the xml file
//	private static void loopXMLFile(){
//		try{
//			File file = new File("src/Data/Airplanes.xml");
//			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//			Document doc = dBuilder.parse(file);
//			if(doc.hasChildNodes()){
//				printNode(doc.getChildNodes());
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	
//	private static void printNode(NodeList nodeList){
//		for(int i =0;i<nodeList.getLength();i++){
//			Node node = nodeList.item(i);
//			if(node.getNodeType() == Node.ELEMENT_NODE){
//				System.out.println("<"+node.getNodeName()+">");
//				System.out.println(node.getTextContent());
//				if(node.hasAttributes()){
//					NamedNodeMap nodeMap = node.getAttributes();
//					for(int j =0;j<nodeMap.getLength();j++){
//						Node nd = nodeMap.item(j);
//						System.out.println(nd.getNodeName() +"="+nd.getNodeValue());
//					}
//				}
//				if(node.hasChildNodes()){
//					printNode(node.getChildNodes());
//				}
//				System.out.println("<"+node.getNodeName()+"/>");
//			}
//		}
//	}
	
	//creat XML file
//	public static void createXMLFile(List<Flight> flights){
//		Document doc;
//		Element 
//	}
	
}
