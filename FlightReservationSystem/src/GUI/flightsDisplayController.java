package GUI;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


import Models.Flight;
import Models.Order;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class flightsDisplayController {
	
	
	//@FXML ListView onelist;
		
	@FXML TableView<ArrayList<Flight>> table1;
	
	@FXML
	public void initialize(){				
		makeFliColumn();
		makeDurColumn();
		makePriColumn();  
        table1.setItems(FXCollections.observableArrayList(StateMachine.getInstance().flights));
	}
	
	private void makeFliColumn() {
		TableColumn<ArrayList<Flight>,String> fliColumn=new TableColumn<ArrayList<Flight>,String>("Flights & Connections");
        fliColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ArrayList<Flight>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ArrayList<Flight>, String> param) {
            	ArrayList<Flight> path = param.getValue();
            	String s = "";
            	for(int i = 0; i < path.size(); i++) {
            		s = s + path.get(i).dep.code + " --> ";
            		if(i == path.size() - 1) {
            			s = s + path.get(i).arr.code;
            		}
            	}
            	
                return new SimpleStringProperty(s);
            }
        });
        table1.getColumns().add(fliColumn);
	}
	
	private void makeDurColumn() {
        TableColumn<ArrayList<Flight>,String> durColumn=new TableColumn<ArrayList<Flight>,String>("Total Duration");
        durColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ArrayList<Flight>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ArrayList<Flight>, String> param) {
            	int tot = 0;
            	for (Flight f : param.getValue()) {
            		tot += f.duration;
            	}
            	return new SimpleStringProperty(tot + " minutes");
        	}
        });
        table1.getColumns().add(durColumn);
	}
	
	private void makePriColumn() {
        TableColumn<ArrayList<Flight>,String> priColumn=new TableColumn<ArrayList<Flight>,String>("Total Price");
        priColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ArrayList<Flight>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ArrayList<Flight>, String> param) {
            	double tot = 0.0;
            	for (Flight f : param.getValue()) {
            		if(StateMachine.getInstance().order.firstClass) {
            			tot += f.firstPrice;
            		} else {
            			tot += f.coachPrice;
            		}
            	}
            	DecimalFormat df = new DecimalFormat("#.00");
            	return  new SimpleStringProperty("$" + df.format(tot));
            }
        });
        table1.getColumns().add(priColumn);
	}
	
	@FXML
	public void selectitem() throws IOException{
		// Order which tells us if we're round trip or one way
		StateMachine sm = StateMachine.getInstance();
		Order o = sm.order;
		int in =  table1.getSelectionModel().getSelectedIndex();
		sm.order.firstFlightPath = StateMachine.getInstance().flights.get(in);
		System.out.println(sm.order.firstFlightPath);
		sm.switchState(StateMachine.state.confirm_order);
	}
	@FXML
	public void cancelitem(){
		StateMachine sm = StateMachine.getInstance();
		sm.switchState(StateMachine.state.finish);
	}
}
