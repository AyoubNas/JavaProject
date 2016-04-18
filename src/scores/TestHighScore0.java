package scores;
import java.util.*;
import java.io.*;

		
public class TestHighScore0 {


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

		TestHighScore0 test = new TestHighScore0();
		String name = test.askName();
		Highscore1 highScores = new Highscore1();
		highScores.getScores();
		//afficher les anciens scores
		int score = test.chooseFromTab(test.readScores());

		System.out.println("      "+name+" : "+score);

	}
}
