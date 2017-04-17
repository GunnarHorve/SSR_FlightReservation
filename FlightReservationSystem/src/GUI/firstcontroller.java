package GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class firstcontroller{
	@FXML RadioButton first;
	@FXML RadioButton coach;
	@FXML RadioButton oneway;
	@FXML RadioButton roundway;
	@FXML ComboBox depart;
	@FXML ComboBox arrive;
	
	
		



	@FXML
	public void initialize() {
		// TODO Auto-generated method stub
		String[] airports = {"Please Choose from Below","Hartsfield-Jackson Atlanta International","Ted Stevens Anchorage International Airport","Austin-Bergstrom International","Baltimore/Washington International",
				"Logan International","Charlotte Douglas International","Chicago Midway Airport","Chicago O'Hare International","Cincinnati/Northern Kentucky International","Cleveland Hopkins International",
				"Port Columbus International","Dallas/Ft. Worth International - DFW Airport","Denver International Airport","Detroit Metropolitan Wayne County Airport","Fort Lauderdale/Hollywood International",
				"Southwest Florida International","Bradley International","Hawaii Honolulu International","George Bush Intercontinental","William P. Hobby Airport","Indianapolis International","Kansas City International",
				"McCarran International","Los Angeles International","Memphis International","Miami International Airport","Minneapolis/St. Paul International","Nashville International","Louis Armstrong International",
				"John F. Kennedy International","LaGuardia International","Newark Liberty International","Metropolitan Oakland International","Ontario International","Orlando International","Philadelphia International","Sky Harbor International",
				"Pittsburgh International","Portland International","Raleigh-Durham International","Sacramento International","Salt Lake City International","San Antonio International","Lindbergh Field International","San Francisco International",
				"Mineta San Jos¨¦ International","John Wayne Airport, Orange County","Seattle-Tacoma International","Lambert-St. Louis International","Tampa International","Dulles International Airport","Ronald Reagan Washington National"};
		
		ObservableList<String> list = FXCollections.observableArrayList(airports);
		depart.setItems(list);
		arrive.setItems(list);
		ToggleGroup group = new ToggleGroup();
		ToggleGroup group1 = new ToggleGroup();
		first.setToggleGroup(group);
		

		coach.setToggleGroup(group);
		oneway.setToggleGroup(group1);
		roundway.setToggleGroup(group1);
		

	}





}
