//package GUI;
//
//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
///**
// *
// * @author Administrator
// */
//public class flighttableview {
//    //���Ҫע�⣬�ڳ�ʼ����ʱ��һ��Ҫд��new����������ģ���Ϊ������int����������String������Ĭ�ϵĹ��캯����
//   private StringProperty dep=new SimpleStringProperty();
//   private StringProperty arr=new SimpleStringProperty();
//   private  StringProperty dur=new SimpleStringProperty();
//   private  StringProperty pri=new SimpleStringProperty();
//   
//    //��������й��оص�д��������Ҫע��͹�����ͨbean����������
//    public flighttableview(String dep,String arr,String dur,String pri)
//    {
//        this.setdep(dep);
//        this.setarr(arr);
//        this.setdur(dur);
//        this.setdur(pri);
//    }
//    public flighttableview(){
//        
//    }
//    public String getdep(){
//        return this.dep.get();
//    } 
//    public void setdep(String dep){
//        this.dep.set(dep);
//    }
//     public String getarr(){
//        return this.arr.get();
//    } 
//    public void setarr(String arr){
//        this.arr.set(arr);
//    }
//    public String getdur(){
//        return this.dur.get();
//    }
//    public void setdur(String dur){
//        this.dur.set(dur);
//    }
//    
//    public String getpri(){
//        return this.pri.get();
//    } 
//    public void setpri(String pri){
//        this.pri.set(pri);
//    }
//    public StringProperty getDurProperty(){
//        return this.dur;
//    }
//    public StringProperty getDepProperty(){
//        return this.dep;
//    }
//    public StringProperty getArrProperty(){
//        return this.arr;
//    }
//    public StringProperty getPriProperty(){
//        return this.pri;
//    }
//    
//}