package GUI;


import java.awt.List;
import java.util.Stack;

import GUI.StateMachine.state;
import Models.Flight;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class confirmcontroller {
	@FXML TableView<flighttableview> table;
	@FXML Button select;
	@FXML Button cancel;
	@FXML
	public void initialize(){
		//Stack st1=new Stack();
		//Stack st2=new Stack();
		StateMachine sm=StateMachine.getInstance();
		java.util.List<Flight> fly1 = sm.getInstance().order.firstFlightPath;
		ObservableList<flighttableview> list=FXCollections.observableArrayList();
		
		java.util.List<Flight> fly2 = sm.getInstance().order.secondFlightPath;
		System.out.println(fly1);
		System.out.println(fly2);
		TableColumn<flighttableview,String> depColumn=new TableColumn<flighttableview,String>("From");
        TableColumn<flighttableview,String> arrColumn=new TableColumn<flighttableview,String>("To");
        TableColumn<flighttableview,String> durColumn=new TableColumn<flighttableview,String>("Duration");
        TableColumn<flighttableview,String> priColumn=new TableColumn<flighttableview,String>("Price");
       
        
        //把列和bean对应起来，这个很重要，两种写法，第一种
        depColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<flighttableview, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<flighttableview, String> param) {
                return param.getValue().getDepProperty();
            }
        });
        //firstColumn.setCellValueFactory(new PropertyValueFactory<flighttableview,String>("firstName"));第二种用法
        System.out.println("zhge s  ces hide ");
        
        arrColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<flighttableview, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<flighttableview, String> param) {
                return param.getValue().getArrProperty();
            }
        });
        durColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<flighttableview, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<flighttableview, String> param) {
                return param.getValue().getDurProperty();
            }
        });
        priColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<flighttableview, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<flighttableview, String> param) {
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
