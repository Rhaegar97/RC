import java.io.*;
import java.net.*;


public class URLSimpleWebBrowser {
    public static void main(String[] args) 
    	throws IOException {

   
   URL test = new URL("http://localhost/index.html"); 
   
  
   
     BufferedReader in = new BufferedReader( 
       new InputStreamReader(test.openStream())); 
     String inputLine; 
     

     
     while ((inputLine = in.readLine()) != null) 
     	{	
     		
     		System.out.println(inputLine);
     		
     		
     	}
     in.close();     
    


  
    }
    

      
 
    
    
    
}

