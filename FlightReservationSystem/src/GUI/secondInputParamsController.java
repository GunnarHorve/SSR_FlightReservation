package GUI;


import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import Models.Flight;
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
		
		StateMachine sm = StateMachine.getInstance();
		sm.order.secondDepDate = Date.from(instant);
		sm.order.secondRound = true;
		sm.switchState(StateMachine.state.display_flights);
	}
}
