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
		if(!verifyInputs()) { return; }
		
		LocalDate day = date.getValue();
		Instant instant = Instant.from(day.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
	
		StateMachine sm = StateMachine.getInstance();
		Airport arr = sm.order.dep;
		Airport dep = sm.order.arr;
		
		sm.order.arr = arr;
		sm.order.dep = dep;
		sm.order.depDate = date;
		sm.order.secondRound = true;
		
		sm.switchState(StateMachine.state.display_flights);
	}
	
	private boolean verifyInputs() {
		LocalDate day   = date.getValue();
		
		// check for bookings prior to your original departure
		Instant instant = Instant.from(day.atStartOfDay(ZoneId.systemDefault()));
		if(Date.from(instant).getTime() <= StateMachine.getInstance().order.depDate.getTime()) {
			guiHelpers.throwPopup("No matter how much of a jetsetter you are,\nyou cannot fly back before you fly out");
			return false;
		}
		return true;
	}

}
