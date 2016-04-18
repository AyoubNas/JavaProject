package scores;
import java.util.*;
import java.net.*;
import java.io.*;

public class HighScore1 {
  
  	/**
  	 * Constructor of the HighScore class
  	 **/

  	public HighScore() {	
	}
	
	
	/**
	 * Return all the lines of the feed.csv file (on our ThingSpeak channel)
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
