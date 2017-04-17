package nouse;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import Models.Airport;
import Models.Flight;
import QueryManager.queryManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ToggleGroup;

public class result extends JFrame {
	public result(){}
	public result(List<Flight> flights) {
		String[] airports = {"Please Choose from Below","Hartsfield-Jackson Atlanta International","Ted Stevens Anchorage International Airport","Austin-Bergstrom International","Baltimore/Washington International",
				"Logan International","Charlotte Douglas International","Chicago Midway Airport","Chicago O'Hare International","Cincinnati/Northern Kentucky International","Cleveland Hopkins International",
				"Port Columbus International","Dallas/Ft. Worth International - DFW Airport","Denver International Airport","Detroit Metropolitan Wayne County Airport","Fort Lauderdale/Hollywood International",
				"Southwest Florida International","Bradley International","Hawaii Honolulu International","George Bush Intercontinental","William P. Hobby Airport","Indianapolis International","Kansas City International",
				"McCarran International","Los Angeles International","Memphis International","Miami International Airport","Minneapolis/St. Paul International","Nashville International","Louis Armstrong International",
				"John F. Kennedy International","LaGuardia International","Newark Liberty International","Metropolitan Oakland International","Ontario International","Orlando International","Philadelphia International","Sky Harbor International",
				"Pittsburgh International","Portland International","Raleigh-Durham International","Sacramento International","Salt Lake City International","San Antonio International","Lindbergh Field International","San Francisco International",
				"Mineta San Jos¨¦ International","John Wayne Airport, Orange County","Seattle-Tacoma International","Lambert-St. Louis International","Tampa International","Dulles International Airport","Ronald Reagan Washington National"};
		List<String> flig = new ArrayList<>();
		for (Flight flight:flights){flig.add(flight.toString());}
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));;
		String[] st=new String[flig.size()];
		String[] a= flig.toArray(st);
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		setLayout(null);
		scrollPane.setBounds(50, 50, 400, 200);
		JList list = new JList(a);
		
		list.setLocation(100,100);
		list.setBounds(50, 50, 200, 300);
		scrollPane.setViewportView(list);;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					result frame = new result();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

ToggleGroup group = new ToggleGroup();
ToggleGroup group1 = new ToggleGroup();
first.setToggleGroup(group);
coach.setSelected(true);

coach.setToggleGroup(group);
oneway.setToggleGroup(group1);
roundway.setToggleGroup(group1);
oneway.setSelected(true);
public void initialize() {
	// TODO Auto-generated method stub
	List<Airport> airports = queryManager.getAllAirports();	

	List<String> airportStrings = airports.stream().map(Airport::getName).collect(Collectors.toList());
	ObservableList<String> list = FXCollections.observableArrayList(airportStrings);
	depart.setItems(list);
	arrive.setItems(list);
	ToggleGroup group = new ToggleGroup();
	ToggleGroup group1 = new ToggleGroup();
	first.setToggleGroup(group);
	ObservableList<String> list1 = FXCollections.observableArrayList("0","1","2");

	coach.setToggleGroup(group);
	oneway.setToggleGroup(group1);
	roundway.setToggleGroup(group1);
	stop.setItems(list1);


}
public void btnclick()
{
	List<Airport> airports = queryManager.getAllAirports();	

	Object stopnum=stop.getSelectionModel().getSelectedItem();
	String dep=airports.get(depart.getSelectionModel().getSelectedIndex()).code;
	String arr=airports.get(arrive.getSelectionModel().getSelectedIndex()).code;
	Object day=datepicker.getUserData();
	System.out.println(day);
	if(oneway.isSelected()){
		if(coach.isSelected()){}
		else if(first.isSelected()){}
	}
	else if(roundway.isSelected()){
		if(coach.isSelected()){}
		else if(first.isSelected()){}
	}
}



if(e.getActionCommand().equals("reserve")){
	
	
}
else if(e.getActionCommand().equals("cancel")){
	
	
}
