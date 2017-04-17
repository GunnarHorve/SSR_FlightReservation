package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import flightFinder.Search;
import Models.Airport;
import Models.Flight;
import QueryManager.queryManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class firstcontroller{
	@FXML RadioButton first;
	@FXML RadioButton coach;
	@FXML RadioButton oneway;
	@FXML RadioButton roundway;
	@FXML ComboBox depart;
	@FXML ComboBox arrive;
	
	@FXML ComboBox stop;
	@FXML DatePicker datepicker;
	List<Airport> airports = queryManager.getAllAirports();	



	@FXML
	public void initialize() {
		// TODO Auto-generated method stub
		

		List<String> airportStrings = airports.stream().map(Airport::getName).collect(Collectors.toList());
		ObservableList<String> list = FXCollections.observableArrayList(airportStrings);
		depart.setItems(list);
		arrive.setItems(list);
		ToggleGroup group = new ToggleGroup();
		ToggleGroup group1 = new ToggleGroup();
		first.setToggleGroup(group);
		

		coach.setToggleGroup(group);
		oneway.setToggleGroup(group1);
		roundway.setToggleGroup(group1);
		
	

	}
	public void btnclick() throws IOException
	{
		
		LocalDate day=datepicker.getValue();
		Instant instant = Instant.from(day.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		System.out.println(day);
		List<Airport> airports = queryManager.getAllAirports();	

		Object stopnum=stop.getSelectionModel().getSelectedItem();
		String dep=airports.get(depart.getSelectionModel().getSelectedIndex()).code;
		String arr=airports.get(arrive.getSelectionModel().getSelectedIndex()).code;
		
		
		if(oneway.isSelected()){
			Search search=new Search();
			List<List<Flight>> flight=search.Search_Path(dep,arr,date);
			
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/oneway.fxml"));
            
			Stage stage=new Stage();
			
			stage.setTitle("My Application");
            stage.setScene(new Scene(root));
            stage.show();

            

            
			
			if(coach.isSelected()){}
			else if(first.isSelected()){}
		}
		else if(roundway.isSelected()){
			if(coach.isSelected()){}
			else if(first.isSelected()){}
		}
		
	}

}
