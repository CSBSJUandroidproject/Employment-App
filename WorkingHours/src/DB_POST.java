

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class DB_POST {
  
  protected static String doInBackground(String... arg0) {
    try{
      String username = (String)arg0[0];
      String password = (String)arg0[1];
      String link = "http://csbsjustudentemployment.org/app_accessor_php/get_employee_hours.php";
      String data  = URLEncoder.encode("username", "UTF-8") 
        + "=" + URLEncoder.encode(username, "UTF-8");
      data += "&" + URLEncoder.encode("password", "UTF-8") 
        + "=" + URLEncoder.encode(password, "UTF-8");
      URL url = new URL(link);
      URLConnection conn = url.openConnection(); 
      conn.setDoOutput(true); 
      OutputStreamWriter wr = new OutputStreamWriter
        (conn.getOutputStream()); 
      wr.write( data ); 
      wr.flush(); 
      BufferedReader reader = new BufferedReader
        (new InputStreamReader(conn.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line = null;
      // Read Server Response
      while((line = reader.readLine()) != null)
      {
        sb.append(line);
        break;
      }
      
      return sb.toString();
    }catch(Exception e){
      return new String("Exception: " + e.getMessage());
    }
  }
}
