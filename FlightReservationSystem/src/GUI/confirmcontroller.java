package GUI;

import java.util.ArrayList;

import GUI.StateMachine.state;
import Models.Flight;
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
		flightsTo.addAll(flightsFrom);
		ObservableList<Flight> list=FXCollections.observableArrayList(flightsTo);
		
		// create relevant column
		TableColumn<Flight, String> depColumn = new TableColumn<Flight, String>("From");
        TableColumn<Flight, String> arrColumn = new TableColumn<Flight, String>("To");
        TableColumn<Flight, String> durColumn = new TableColumn<Flight, String>("Duration");
        TableColumn<Flight, String> priColumn = new TableColumn<Flight, String>("Price");
       
        
        depColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Flight, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Flight, String> param) {
                return param.getValue().getDepProperty();
            }
        });
        
        arrColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Flight, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Flight, String> param) {
                return param.getValue().getArrProperty();
            }
        });
        durColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Flight, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Flight, String> param) {
                return param.getValue().getDurProperty();
            }
        });
        priColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Flight, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Flight, String> param) {
                return param.getValue().getPriProperty();
            }
        });
         
        table.getColumns().addAll(depColumn,arrColumn,durColumn,priColumn);
        
        int i=0;
		while(i<fly1.size())
		{
			Flight a =fly1.get(i);
			if(sm.order.firstClass){
				
				flighttableview air = new flighttableview(a.dep.code,a.arr.code,Integer.toString(a.duration),Double.toString(a.firstPrice)); 
				list.addAll(air);
				
				
				
			}
			else{
				flighttableview air = new flighttableview(a.dep.code,a.arr.code,Integer.toString(a.duration),Double.toString(a.coachPrice)); 
				list.addAll(air);}
			i+=1;
			
		}
	
		table.setItems(list);
		System.out.println(i);
		while(fly2!=null&&i<fly2.size())
		{
			Flight a =fly2.get(i);
			if(sm.order.firstClass){
				flighttableview air = new flighttableview(a.dep.code,a.arr.code,Integer.toString(a.duration),Double.toString(a.firstPrice)); 
				list.addAll(air);
				
			}
			else{flighttableview air = new flighttableview(a.dep.code,a.arr.code,Integer.toString(a.duration),Double.toString(a.coachPrice)); 
				list.addAll(air);}
			i+=1;
		}
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
