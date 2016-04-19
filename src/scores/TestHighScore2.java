package scores;
import java.util.*;
import java.io.*;

		
public class TestHighScore2 {


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

		String filePath  = "C:/Users/ayoub/Desktop/ProjetJava/JavaProject/src/scores/scoreFile.csv";
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
		TestHighScore2 test = new TestHighScore2();
		String name = test.askName();

		//create HighScores2 instance
		HighScore2 highScores = new HighScore2();
		System.out.println("   Score table");

		//get all the stored scores
		String[] oldScoresArray=highScores.getScores();
		//pick the 10 best ones;
		BestPlayer2[] tenBest = highScores.tenBestScores(oldScoresArray);
		
		//afficher les 10 scores
		System.out.println("......");

		for (int i=0;i<oldScoresArray.length;i++){

			String[] parts = (oldScoresArray[i]).split(",");          			
            System.out.println("   "+tenBest[i].getName()+" : "+tenBest[i].getScore());
		}
		System.out.println("......");
		int score = test.chooseFromTab(test.readScores());

		System.out.println("\n"+	"      "+name+" : "+score);

	}
}