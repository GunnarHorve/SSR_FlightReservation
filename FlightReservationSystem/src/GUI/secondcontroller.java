package GUI;

import java.awt.TextField;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import Models.Flight;
import flightFinder.Search;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class secondcontroller {
	@FXML TextField depart2;
	@FXML TextField arrive2;
	@FXML DatePicker date2;
	
	static List<List<Flight>> flight;
	static Stage stage=new Stage();
	
	@FXML
	public void initialize(){
		
		
		depart2.setText(firstcontroller.arr.toString());
		arrive2.setText(firstcontroller.dep.toString());
		
	}
	@FXML
	public void btnclick2() throws IOException{
		LocalDate day=date2.getValue();
		Instant instant = Instant.from(day.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		Search search=new Search();
		flight=search.Search_Path(firstcontroller.dep1,firstcontroller.arr1,date);
		System.out.println(flight);
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/oneway.fxml"));
        
		
		
		stage.setTitle("My Application");
        stage.setScene(new Scene(root));
        stage.show();

	}

}
