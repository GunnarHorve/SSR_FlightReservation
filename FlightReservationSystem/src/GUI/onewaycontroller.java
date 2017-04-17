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

public class onewaycontroller {
	
	
	@FXML ListView onelist;
	
	List<List<Flight>> aa = firstcontroller.flight;
	int j=firstcontroller.i;
	
	@FXML
	public void initialize(){
		ObservableList name = FXCollections.observableArrayList();
		
		name.addAll(aa);
		onelist.setItems(name);
		System.out.println(aa);
		
		System.out.println(j);
		
	}
	@FXML
	public void selectitem() throws IOException{
		if(j==1){
			System.out.println(3);
			//Object fly=onelist.getSelectionModel().getSelectedItem();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/second.fxml"));
	        
			Stage stage1=new Stage();
			
			stage1.setTitle("My Application");
	        stage1.setScene(new Scene(root));
	        stage1.show();
			
		}
		//reserve
		else {
			System.out.println(4);
			Object fly=onelist.getSelectionModel().getSelectedItem();
			firstcontroller.stage.close();
		}
		
		
	}
	@FXML
	public void cancelitem(){
		firstcontroller.stage.close();
		
	}


}
