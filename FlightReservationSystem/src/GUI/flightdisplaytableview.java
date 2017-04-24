package GUI;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Administrator
 */
public class flightdisplaytableview {
    //这点要注意，在初始化的时候一定要写上new，否则会出错的，因为他不像int那样活着是String那样有默认的构造函数。
   public StringProperty trip=new SimpleStringProperty();

   public  StringProperty dur=new SimpleStringProperty();
   public  StringProperty pri=new SimpleStringProperty();
   
    //下面就是中规中矩的写法，但是要注意和构造普通bean方法的区别
    public flightdisplaytableview(String trip,String dur,String pri)
    {
        this.trip.set(trip);
        this.dur.set(dur);
        this.pri.set(pri);
    }
//    public flightdisplaytableview(){
//        
//    }
}