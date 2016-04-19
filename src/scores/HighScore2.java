package scores;
import java.util.*;
import java.net.*;
import java.io.*;
import scores.*;

public class HighScore2 {
  
  	/**
  	 * Constructor of the HighScore class
  	 **/

  	public void HighScore2() {	
	}
	
	
	/**
	 * Return all the lines of the feed.csv file (on our ThingSpeak channel)
	 **/
	 
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

	private BestPlayer2[] tenBestScores(String [] readScores){

		BestPlayer2[] allBest= new BestPlayer2[readScores.length];

		for(int i=0;i<readScores.length;i++){
			String[] parts = ((String)readScores[i]).split(",");
			allBest[i]=new BestPlayer2(parts[3],parts[2]);
		}



		return;
	}
  
}
