package GUI;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Administrator
 */
public class flightdisplaytableview {
    //���Ҫע�⣬�ڳ�ʼ����ʱ��һ��Ҫд��new����������ģ���Ϊ������int����������String������Ĭ�ϵĹ��캯����
   private StringProperty trip=new SimpleStringProperty();

   private  StringProperty dur=new SimpleStringProperty();
   private  StringProperty pri=new SimpleStringProperty();
   
    //��������й��оص�д��������Ҫע��͹�����ͨbean����������
    public flightdisplaytableview(String trip,String dur,String pri)
    {
        this.settrip(trip);
      
        this.setdur(dur);
        this.setdur(pri);
    }
    public flightdisplaytableview(){
        
    }
    public String gettrip(){
        return this.trip.get();
    } 
    public void settrip(String dep){
        this.trip.set(dep);
    }
  
    public String getdur(){
        return this.dur.get();
    }
    public void setdur(String dur){
        this.dur.set(dur);
    }
    
    public String getpri(){
        return this.pri.get();
    } 
    public void setpri(String pri){
        this.pri.set(pri);
    }
    public StringProperty getDurProperty(){
        return this.dur;
    }
    public StringProperty getTripProperty(){
        return this.trip;
    }
    
    public StringProperty getPriProperty(){
        return this.pri;
    }
    
}