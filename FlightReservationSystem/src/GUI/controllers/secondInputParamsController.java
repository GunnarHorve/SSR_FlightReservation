package GUI.controllers;


import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import GUI.StateMachine;
import Models.Airport;
import Models.Flight;
import Models.Order;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class secondInputParamsController {
	@FXML private DatePicker date;
		
	@FXML
	public void initialize(){ }
	
	@FXML
	public void btnclickk() throws IOException{
		LocalDate day = date.getValue();
		Instant instant = Instant.from(day.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
	
		StateMachine sm = StateMachine.getInstance();
		sm.order.secondDepDate = Date.from(instant);
		sm.order.secondRound = true;
		Airport arr = sm.order.dep;
		Airport dep = sm.order.arr;
		sm.switchState(StateMachine.state.display_flights);
		sm.order = new Order(dep, arr, date, sm.order.firstClass, true, sm.order.stopovers);
	}
}
