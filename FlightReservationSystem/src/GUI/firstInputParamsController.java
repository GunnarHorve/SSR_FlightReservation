package GUI;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import Models.Airport;
import Models.Flight;
import Models.Order;
import QueryManager.queryManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class firstInputParamsController{
	@FXML RadioButton first;
	@FXML RadioButton coach;
	@FXML RadioButton oneway;
	@FXML RadioButton roundway;
	@FXML ComboBox depart;
	@FXML ComboBox arrive;
	
	@FXML ComboBox stop;
	@FXML DatePicker datepicker;
	List<Airport> airports = queryManager.getAllAirports();	
	static Stage stage=new Stage();

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
		Airport dep=airports.get(depart.getSelectionModel().getSelectedIndex());
		Airport arr=airports.get(arrive.getSelectionModel().getSelectedIndex());
		Boolean isFirst = first.isSelected();
		
		StateMachine sm = StateMachine.getInstance();
		sm.order = new Order(dep, arr, date, isFirst, roundway.isSelected());
		sm.switchState(StateMachine.state.display_flights);
	}

}
