package GUI;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Administrator
 */
public class flightdisplaytableview {
    //���Ҫע�⣬�ڳ�ʼ����ʱ��һ��Ҫд��new����������ģ���Ϊ������int����������String������Ĭ�ϵĹ��캯����
   public StringProperty trip=new SimpleStringProperty();

   public  StringProperty dur=new SimpleStringProperty();
   public  StringProperty pri=new SimpleStringProperty();
   
    //��������й��оص�д��������Ҫע��͹�����ͨbean����������
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