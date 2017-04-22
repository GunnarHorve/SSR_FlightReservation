package GUI;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
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
	@FXML ComboBox<String> depart;
	@FXML ComboBox<String> arrive;
	
	@FXML ComboBox<Integer> stop;
	@FXML DatePicker datepicker;
	List<Airport> airports = queryManager.getAllAirports();	
	static Stage stage=new Stage();

	@FXML
	public void initialize() {
		// TODO Auto-generated method stub
		
		// fill combo boxes
		List<String> airportStrings = airports.stream().map(Airport::getName).collect(Collectors.toList());
		ObservableList<String> list = FXCollections.observableArrayList(airportStrings);
		depart.setItems(list);
		arrive.setItems(list);

		
		List<Integer> intArrList = new ArrayList<Integer>();
		intArrList.add(0); intArrList.add(1); intArrList.add(2);
		ObservableList<Integer> intObsList = FXCollections.observableArrayList(intArrList);
		stop.setItems(intObsList);
		
		// select some defaults
		arrive.getSelectionModel().select(0);
		depart.getSelectionModel().select(1);
		stop.getSelectionModel().select(2);
		
		// group radio buttons
		ToggleGroup flightClass = new ToggleGroup();
		first.setToggleGroup(flightClass);
		coach.setToggleGroup(flightClass);
		
		ToggleGroup specifyRoundTrip = new ToggleGroup();
		oneway.setToggleGroup(specifyRoundTrip);
		roundway.setToggleGroup(specifyRoundTrip);

	}
	public void btnclick() throws IOException
	{
		LocalDate day=datepicker.getValue();
		Instant instant = Instant.from(day.atStartOfDay(ZoneId.systemDefault()));
		
		Date date = Date.from(instant);
		Airport dep = airports.get(depart.getSelectionModel().getSelectedIndex());
		Airport arr = airports.get(arrive.getSelectionModel().getSelectedIndex());
		boolean isFirst = first.isSelected();
		boolean roundtrip = roundway.isSelected();
		int stopovers = stop.getSelectionModel().getSelectedItem();
		
		if(!checkInputs(date, dep, arr)) { return; } //nope.
		
		StateMachine sm = StateMachine.getInstance();
		sm.order = new Order(dep, arr, date, isFirst, roundtrip, stopovers);
		sm.switchState(StateMachine.state.display_flights);
	}

	private boolean checkInputs(Date date, Airport dep, Airport arr) {
		return true;
	}

}
