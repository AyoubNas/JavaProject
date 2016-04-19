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
	 
	public String[] getScores(){

		//LinkedList results = new LinkedList();
		List<String> results = new ArrayList<String>();



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

		return results.toArray(new String[1]);
		
		
	}

	public BestPlayer2[] tenBestScores(String [] readScores){

		BestPlayer2[] allBest= new BestPlayer2[readScores.length];

		for(int i=0;i<readScores.length;i++){
			String[] parts = ((String)readScores[i]).split(",");
			allBest[i]=new BestPlayer2();
			allBest[i].setName(parts[3]);
			allBest[i].setScore(Integer.parseInt(parts[2]));
			//System.out.println(i+" "+allBest[i].getName()+" "+allBest[i].getScore());
		}
		System.out.println(allBest.length);

		int i=0;
		int j=0;
		//LinkedList resList= new LinkedList();
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
  
}
