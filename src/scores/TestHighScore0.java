package scores;
import java.util.*;

import java.io.*;			
		
public class TestHighScore0 {

	public int[] toIntArray(List list){
		System.out.println("entered tointarray");
	  	int[] ret = new int[list.size()];
	  	System.out.println("created result");
	  	for(int i = 0;i < ret.length;i++){
	    	ret[i] = (int)list.get(i);
	    	System.out.println("added one value"+i);}

	  	return ret;
}

	public String askName(){
		System.out.print("      your name : ");
		Scanner sc = new Scanner(System.in);
		String name= sc.nextLine();
		return name;
	}

	public int[] readScores(){

		String filePath  = "C:/Users/soumia/Desktop/AyoubJava/JavaProject/src/scores/scoreFile.csv";
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


	return toIntArray(list);
}

public int chooseFromTab(int[] tab){
	Random rand = new Random();
	return  tab[rand.nextInt(tab.length)];

}


	public static void main(String[] args) {

		TestHighScore0 test = new TestHighScore0();
		System.out.println("created");
		String name = test.askName();
		System.out.println("askedName");
		System.out.println(name+test.chooseFromTab(test.readScores()));

	}
}
