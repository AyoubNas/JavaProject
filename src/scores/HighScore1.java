package scores;
import java.util.*;
import java.net.*;
import java.io.*;

public class HighScore1 {
  
  public HighScore() {	
	}
	
	
	/**Create a connection between the score file written in the URL (feed.csv) and the HighScore class
	 * thanks to a created bufferedReader, we can read each line of the file then print them
	 **/
	public void getScores(){

		try {
			
		URL monURL = new URL("https://thingspeak.com/channels/108862/feed.csv");
		URLConnection connexion = monURL.openConnection();
		InputStreamReader inStream = new InputStreamReader(connexion.getInputStream());
		BufferedReader buff = new BufferedReader(inStream);
		
		while (true){
            String nextLine = buff.readLine();  
            if (nextLine !=null){
            	System.out.println(nextLine);
            }
            else {
            	break;
            	}
			}
		inStream.close();
		
		} catch (Exception e) { e.printStackTrace(); }
		
		
	}
  
}
