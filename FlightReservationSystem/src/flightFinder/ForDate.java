package flightFinder;
import java.time.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class ForDate {
	
		/*Date date1 = (03/07/2011);
		ForDate mydate = HalDateTime.valueOf( "25.12.1988" );
		System.out.println( mydate );
		*/
		
		 
		  public static void main(String args[]){
			  ForDate d = new ForDate();
			  d.Testing();
			  }
		
		  public void Testing(){
			 
		    try
		    {
		      String date = "04121985";//"04221985" changed the 22 to 12
		      SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
		      SimpleDateFormat formatoNew = new SimpleDateFormat("yyyy_MM_dd");
		      //formato.setLenient(false);//optional e.g. 04221985 will error
		      Calendar cal = Calendar.getInstance();
		      cal.setTime(formato.parse(date));
		   
		      System.out.println("date is: " + formatoNew.format(cal.getTime()));
		    }
		    catch(Exception e){System.out.println("error");}
		  }
	
}




