package GUI;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import Models.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class roundcontroller {
	
	
	@FXML ListView roundlist;
	
	List<List<Flight>> aa = secondcontroller.flight1;
	
	
	@FXML
	public void initialize(){
		ObservableList name = FXCollections.observableArrayList();
		
		name.addAll(aa);
		roundlist.setItems(name);
		System.out.println(aa);
		
		
		
	}
	@FXML
	public void selectitem() throws IOException{
		
		
		//reserve
		System.out.println(4);
		Object fly=roundlist.getSelectionModel().getSelectedItem();
		
			
		
		
		
	}
	@FXML
	public void cancelitem(){
		secondcontroller.stage1.close();
		
	}


}
