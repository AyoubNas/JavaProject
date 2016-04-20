package scores;
import java.util.*;
import java.net.*;
import java.io.*;
import scores.*;

	/**
		@author Jean Miquel and Ayoub Nasraddine
		@version 1
	*/

public class HighScore1 {
  
  	/**
  	 * Constructor of the HighScore class
  	 **/

  	public void HighScore() {	
	}
	
	
	/**
	 Return all the lines of the feed.csv file (on our ThingSpeak channel)
	 @return a linkedList containing all the lines read from the channel
	 */
	 
	public LinkedList getScores(){

		LinkedList results = new LinkedList();



		try {

		URL monURL = new URL("https://thingspeak.com/channels/108862/feed.csv");
		URLConnection connexion = monURL.openConnection();
		InputStreamReader inStream = new InputStreamReader(connexion.getInputStream());
		BufferedReader buff = new BufferedReader(inStream);
		String entete = buff.readLine();
		
					
		while (true){
            		String nextLine = buff.readLine();  
            		if ((nextLine !=null)&&(nextLine.length()>24)){

						//String[] parts = nextLine.split(",");          			
            			//System.out.println("   "+parts[3]+","+parts[2]);
            			results.add(nextLine);
            		}
            		else {
            			break;
            		}
		}
		
		inStream.close();
		
		} catch (Exception e) { e.printStackTrace(); }

		return results;
		
		
	}
  
}
