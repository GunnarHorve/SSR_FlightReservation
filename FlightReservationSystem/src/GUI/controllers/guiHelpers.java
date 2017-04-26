package GUI.controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.TimeZone;

import GUI.SceneSwitcher;
import Models.Flight;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class guiHelpers {
	private guiHelpers() { } //don't allow instantiation
	
	public static ArrayList<TableColumn<ArrayList<Flight>, String>> getColumns() {
		ArrayList<TableColumn<ArrayList<Flight>, String>> toReturn = new ArrayList<TableColumn<ArrayList<Flight>, String>>();
		toReturn.add(makeFliColumn());
		toReturn.add(makeDepTimeColumn());
		toReturn.add(makeArrTimeColumn());
		toReturn.add(makeDurColumn());
		toReturn.add(makePriColumn());		
		return toReturn;
	}
	
	public static void throwPopup(String toYell) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(SceneSwitcher.primaryStage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text(toYell));
        Scene dialogScene = new Scene(dialogVbox, 400, 100);
        dialog.setScene(dialogScene);
        dialog.show();
	}
	
	private static TableColumn<ArrayList<Flight>,String> makeDepTimeColumn() {
        TableColumn<ArrayList<Flight>,String> depTimeColumn = new TableColumn<ArrayList<Flight>,String>("Departure Time (local)");
        depTimeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ArrayList<Flight>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ArrayList<Flight>, String> param) {
            	String s = "";
            	for(Flight f : param.getValue()) {
                	TimeZone.setDefault(TimeZone.getTimeZone("Etc/GMT+" + Math.abs(f.dep.gmtOffset)));     
                	s = s + f.depDate.toString() + "\n";
            	}
            	return new SimpleStringProperty(s);
        	}
        });
        return depTimeColumn;
	}
	
	private static TableColumn<ArrayList<Flight>,String> makeArrTimeColumn() {
        TableColumn<ArrayList<Flight>,String> arrTimeColumn = new TableColumn<ArrayList<Flight>,String>("Arrival Time (local)");
        arrTimeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ArrayList<Flight>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ArrayList<Flight>, String> param) {
            	String s = "";
            	for(Flight f : param.getValue()) {
                	TimeZone.setDefault(TimeZone.getTimeZone("Etc/GMT+" + Math.abs(f.arr.gmtOffset)));     
                	s = s + f.arrDate.toString() + "\n";
            	}
            	return new SimpleStringProperty(s);
        	}
        });
        return arrTimeColumn;
	}
	
	private static TableColumn<ArrayList<Flight>,String> makeFliColumn() {
		TableColumn<ArrayList<Flight>,String> fliColumn = new TableColumn<ArrayList<Flight>,String>("Flights & Connections");
        fliColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ArrayList<Flight>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ArrayList<Flight>, String> param) {
            	ArrayList<Flight> path = param.getValue();
            	String s = "";
            	for(int i = 0; i < path.size(); i++) {
            		s = s + path.get(i).dep.code + " --> " + path.get(i).arr.code + "\n";
            	}	
                return new SimpleStringProperty(s);
            }
        });
        return fliColumn;
	}
	
	private static TableColumn<ArrayList<Flight>,String> makeDurColumn() {
        TableColumn<ArrayList<Flight>,String> durColumn = new TableColumn<ArrayList<Flight>,String>("Total Duration");
        durColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ArrayList<Flight>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ArrayList<Flight>, String> param) {
            	int tot = param.getValue().stream().filter(f -> f.getDuration() > 10).mapToInt(f -> f.getDuration()).sum();
            	return new SimpleStringProperty(tot + " minutes");
        	}
        });
        return durColumn;
	}
	
	private static TableColumn<ArrayList<Flight>,String> makePriColumn() {
        TableColumn<ArrayList<Flight>,String> priColumn = new TableColumn<ArrayList<Flight>,String>("Total Price");
        priColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ArrayList<Flight>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ArrayList<Flight>, String> param) {
            	double tot = param.getValue().stream().filter(f -> f.getPrice() > 10).mapToDouble(f -> f.getPrice()).sum();
            	return  new SimpleStringProperty("$" +  new DecimalFormat("#.00").format(tot));
            }
        });
        return priColumn;  
	}
}
