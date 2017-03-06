import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/*print*/
public class main {

	public static void main(String[] args) {//set comments
		Double lat = 33.641045;
		Double lng = -84.427764;
		getGMTOffsetFromAPI(lat, lng);
	}
	
	/*
	 * queries an API to get a GMT offset in hours (requires 1s between queries)
	 */
	static int getGMTOffsetFromAPI(Double lat, Double lng) {
		
		try {
			//query server
			TimeUnit.SECONDS.sleep(1);
			String baseStr = "http://api.timezonedb.com/v2/get-time-zone?key=7SAIBM5LH9VW&by=position";
			URL url = new URL(baseStr + "&lat=" + lat + "&lng=" + lng);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				InputStream inputStream = connection.getInputStream();
				String encoding = connection.getContentEncoding();
				encoding = (encoding == null ? "UTF-8" : encoding);
				
				//interpret server query as a string
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				String line;
		        StringBuilder sb = new StringBuilder();
				while((line = reader.readLine()) != null) {
					sb.append(line);
				}
				reader.close();
				
				//convert string to .xml
				Document doc = convertStringToDocument(sb.toString());
				Element root = doc.getDocumentElement();
				NodeList children = root.getChildNodes();
				
				//search through .xml
				for(int i = 0; i < children.getLength(); i++) {
					if(children.item(i).getNodeName().equals("gmtOffset")) {
						return Integer.parseInt(children.item(i).getTextContent())/(60*60);
					}
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * converts java string object to DOM parsable xml document
	 */
    public static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
            return doc;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return null;
    }
}