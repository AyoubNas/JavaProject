package scores;
import java.util.*;
import java.io.*;
import scores.*;

	/**
		@author Jean Miquel and Ayoub Nasraddine
		@version 3
	*/
		
public class TestHighScore3 {


	/**
		Get username from standard input ad return it
		@return username
	*/

	private String askName(){
		System.out.print("      your name : ");
		Scanner sc = new Scanner(System.in);
		String name= sc.nextLine();
		return name;
	}

	/**
		reads the scores from the csv file
		@return a linkedlist containing the scores
	*/

		private List readScores(){

		File fichier = new File("scores/assets/scoreSamples.txt"); 

		String filePath  = fichier.getAbsolutePath();
		BufferedReader br = null;
		String line = "";
		String separator = ",";
		LinkedList list = new LinkedList(); 

		try {

			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] score = line.split(separator);
				list.add(Integer.parseInt(score[0]));
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
}

	/**
		randomly picks a value from the list given
		@param tab : list of integers containing the scores
		@return the chosen value
	*/
	private int chooseFromTab(List tab){
		Random rand = new Random();
		return (int)tab.get(rand.nextInt(tab.size()));

	}

	/**
		simulate a game
		@param args unused 
	*/
	public static void main(String[] args) {

		//get player name
		TestHighScore3 test = new TestHighScore3();
		String name = test.askName();

		//create HighScores3 instance
		HighScore3 highScores = new HighScore3();
		System.out.println("   Score table");

		//get all the stored scores
		String[] oldScoresArray=highScores.getScores();
		//pick the 10 best ones;
		BestPlayer2[] tenBest = highScores.tenBestScores(oldScoresArray);
		
		//print the 10 best scores
		System.out.println("......");

		for (int i=0;i<tenBest.length;i++){

			String[] parts = (oldScoresArray[i]).split(",");          			
            System.out.println("   "+tenBest[i].getName()+" : "+tenBest[i].getScore());
		}
		System.out.println("......");

		//choose random score from the .txt file
		int score = test.chooseFromTab(test.readScores());

		System.out.println("\n"+	"      "+name+" : "+score);
        
        	//check if the player is qualified to be in the top 10 then report him
		for (BestPlayer2 p : tenBest)
        	{
            		if (p.getScore() < score)
            		{
                		highScores.sendScore(new BestPlayer2(name,score));
                		break;
            		}
        	}

	}
}
