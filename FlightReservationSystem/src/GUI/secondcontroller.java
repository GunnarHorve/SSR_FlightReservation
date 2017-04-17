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
import javafx.scene.control.Label;

public class secondcontroller {
	@FXML private Label departt;
	@FXML private Label arrivee;
	@FXML private DatePicker datee;
	
	static List<List<Flight>> flight1;
	static Stage stage1=new Stage();
	
	@FXML
	public void initialize(){
		
		System.out.println(4);
		System.out.println(4);
		System.out.println(4);
		
		departt.setText(firstcontroller.arr.toString());
		arrivee.setText(firstcontroller.dep.toString());
		
		//arrivee.setText("4");
	}
	@FXML
	public void btnclickk() throws IOException{
		LocalDate day=datee.getValue();
		System.out.println(day);
		Instant instant = Instant.from(day.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		System.out.println(date);
		
		Search search=new Search();
		flight1=search.Search_Path(firstcontroller.arr2.code,firstcontroller.dep2.code,date);
		System.out.println(flight1);
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/round.fxml"));
        
		
		
		stage1.setTitle("My Application");
        stage1.setScene(new Scene(root));
        stage1.show();

	}

}
