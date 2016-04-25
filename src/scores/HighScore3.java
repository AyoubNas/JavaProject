package scores;
import java.util.*;
import java.net.*;
import java.io.*;
import scores.*;

		/**
		@author Jean Miquel and Ayoub Nasraddine
		@version 2
	*/

public class HighScore3 {
  
  	/**
  	 * Constructor of the HighScore class
  	 **/

  	public void HighScore3() {
	}
	
	
	/**
	 * Return all the lines of the feed.csv file (on our ThingSpeak channel)
	 **/
	 
	/**
		Get all the scores from the channel
		@return a String Array containing all the lines read (no parsing has been done)
	*/

	public String[] getScores(){

		//LinkedList results = new LinkedList();
		List<String> results = new ArrayList<String>();



		try {

		//prepare the url connection 
		URL monURL = new URL("https://thingspeak.com/channels/108862/feed.csv");
		URLConnection connexion = monURL.openConnection();
		InputStreamReader inStream = new InputStreamReader(connexion.getInputStream());
		BufferedReader buff = new BufferedReader(inStream);

		String entete = buff.readLine(); //ignore the first line containing the fieldnames
		
					
		while (true){
            		String nextLine = buff.readLine();  
            		if ((nextLine !=null)&&(nextLine.length()>24)){  //append the non null lines and with at least 24 characters (so it contains infos to exploit)

            			results.add(nextLine);
            		}
            		else {
            			break;
            		}
		}
		
		inStream.close();
		
		} catch (Exception e) { e.printStackTrace(); }

		return results.toArray(new String[1]);
		
		
	}



	/**
		returns the ten (or less if no results available) BestPlayers created from the results array in parameter
		@param readScores String array containing the lines read from the channel
		@return BestPlayer2[] containing the ten best players of the channel 
	*/


	public BestPlayer2[] tenBestScores(String [] readScores){

		BestPlayer2[] allBest= new BestPlayer2[readScores.length];

		for(int i=0;i<readScores.length;i++){
			String[] parts = ((String)readScores[i]).split(",");
			allBest[i]=new BestPlayer2();
			allBest[i].setName(parts[3]);
			allBest[i].setScore(Integer.parseInt(parts[2]));
		}

		int i=0;
		int j=0;
		List<BestPlayer2> resList = new ArrayList<BestPlayer2>();
		BestPlayer2 mem;

		while((i<allBest.length) && (i<10)){
			
			mem= allBest[0];

			for(j=0;j<allBest.length;j++){
				
				if((allBest[j].compareTo(mem)>=0)&& !(resList.contains(allBest[j]))){

					mem=allBest[j];
				}
			}

			resList.add(mem);
			i++;

		}



		return resList.toArray(new BestPlayer2[1]);
	}

	/**
		Modify the channel on the ThingSpeak server about a player and his score
		@param sendScores BestPlayer2 we want to send/update on the ThingSpeak channel
	*/

    	public void sendScore(BestPlayer2 p){
        	try {
        
            	String nom = p.getName();
            	int score = p.getScore();
            	URL getURL = new URL("https://api.thingspeak.com/update?api_key=P8HE9INZIOGHX1BL&field1="+score+ "&field2="+nom);
            	getURL.openStream();
            
        	} catch (Exception e) { e.printStackTrace(); }
    	}


}
