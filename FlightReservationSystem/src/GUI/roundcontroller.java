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
	firstcontroller first=new firstcontroller();
	List<List<Flight>> aa = first.flight;
	
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
		Object fly=roundlist.getSelectionModel().getSelectedItem();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/second.fxml"));
        
		Stage stage=new Stage();
		
		stage.setTitle("My Application");
        stage.setScene(new Scene(root));
        stage.show();
		
	}
	@FXML
	public void cancelitem(){
		first.stage.close();
		
	}


}
