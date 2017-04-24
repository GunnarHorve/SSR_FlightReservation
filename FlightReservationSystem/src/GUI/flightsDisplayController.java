package GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Models.Flight;
import Models.Order;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class flightsDisplayController {
	
	
	//@FXML ListView onelist;
		
	@FXML TableView<flightdisplaytableview> table1;
	
	@FXML
	public void initialize(){
		System.out.println("found " + StateMachine.getInstance().flights.size() + " flights");
		//ObservableList name = FXCollections.observableArrayList();		
		//name.addAll(StateMachine.getInstance().flights);		
		//onelist.setItems(name);
		
		TableColumn<flightdisplaytableview,String> fliColumn=new TableColumn<flightdisplaytableview,String>("flights");
        
        TableColumn<flightdisplaytableview,String> durColumn=new TableColumn<flightdisplaytableview,String>("Duration");
        TableColumn<flightdisplaytableview,String> priColumn=new TableColumn<flightdisplaytableview,String>("Price");
       
        ObservableList<flightdisplaytableview> list=FXCollections.observableArrayList();
        //把列和bean对应起来，这个很重要，两种写法，第一种
        fliColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<flightdisplaytableview, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<flightdisplaytableview, String> param) {
                return param.getValue().getTripProperty();
            }
        });
        //firstColumn.setCellValueFactory(new PropertyValueFactory<flightdisplaytableview,String>("firstName"));第二种用法
        System.out.println("zhge s  ces hide ");
        
        
        durColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<flightdisplaytableview, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<flightdisplaytableview, String> param) {
                return param.getValue().getDurProperty();
            }
        });
        priColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<flightdisplaytableview, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<flightdisplaytableview, String> param) {
                return param.getValue().getPriProperty();
            }
        });
        System.out.println(table1); 
        table1.getColumns().addAll(fliColumn,durColumn,priColumn);
        int i=0;
        while(i<StateMachine.getInstance().flights.size()){
        	List<Flight> ff = StateMachine.getInstance().flights.get(i);
        	int j=0;
        	StringBuilder trip=new StringBuilder("");
        	Double time=0.0;
        	Double price=0.0;
        	while(j<ff.size()){
        		Flight f = ff.get(j);
        		trip.append(f.dep.code+"-");
        		trip.append(f.arr.code+" ");
        		time+=f.duration;
        		StateMachine sm=StateMachine.getInstance();
        		if(sm.order.firstClass){
        			price+=f.firstPrice;
        		}
        		else{price+=f.coachPrice;}
        		j=j+1;
        		
        	}
        	flightdisplaytableview air = new flightdisplaytableview(trip.toString(),Double.toString(time),Double.toString(price));
        	list.addAll(air);
        	i+=1;
        }
        table1.setItems(list);
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
