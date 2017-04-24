package GUI;

import java.util.ArrayList;

import GUI.StateMachine.state;
import Models.Flight;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class confirmcontroller {
	@FXML TableView<Flight> table;
	@FXML Button select;
	@FXML Button cancel;
	@FXML
	public void initialize(){
		StateMachine sm = StateMachine.getInstance();
		
		// create an observable list of all necessary flights
		ArrayList<Flight> flightsTo = sm.getInstance().order.firstFlightPath;
		ArrayList<Flight> flightsFrom = sm.getInstance().order.secondFlightPath;
		if(flightsFrom != null) {
			flightsTo.addAll(flightsFrom);
		}
		
		ObservableList<Flight> list=FXCollections.observableArrayList(flightsTo);
		
		// create relevant display columns
		TableColumn<Flight, String> depColumn = new TableColumn<Flight, String>("From");
        TableColumn<Flight, String> arrColumn = new TableColumn<Flight, String>("To");
        TableColumn<Flight, String> durColumn = new TableColumn<Flight, String>("Duration");
        TableColumn<Flight, String> priColumn = new TableColumn<Flight, String>("Price");
       
        // create column observers
        depColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Flight, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Flight, String> param) {
                return new SimpleStringProperty(param.getValue().dep.code);
            }
        });
        arrColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Flight, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Flight, String> param) {
                return new SimpleStringProperty(param.getValue().arr.code);
            }
        });
        durColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Flight, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Flight, String> param) {
                return new SimpleStringProperty("" + param.getValue().duration);
            }
        });
        priColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Flight, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Flight, String> param) {
            	if(StateMachine.getInstance().order.firstClass) {
                    return new SimpleStringProperty("$" + param.getValue().firstPrice);
            	} else {
                    return new SimpleStringProperty("$" + param.getValue().coachPrice);
            	}
            }
        });
         
        table.getColumns().addAll(depColumn,arrColumn,durColumn,priColumn);
        table.setItems(list);
	}
	public void select(){
		StateMachine sm= StateMachine.getInstance();
		if(sm.order.roundtrip){
			sm.switchState(state.input_params_second);
		}
		else{
			sm.switchState(state.finish);
		}
		
	}
	public void cancel(){
		StateMachine sm=StateMachine.getInstance();
		sm.switchState(state.finish);
	}
	
}
