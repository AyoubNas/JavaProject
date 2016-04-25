package scores;
import java.util.*;
import java.io.*;

	/**
		@author Jean Miquel and Ayoub Nasraddine
		@version 2
	*/

public class BestPlayer2{

	String name=new String();
	int score=0;

	public BestPlayer2(){
		
	}

	public BestPlayer2(String nm, int scr){

		score=scr;
		name=nm;
	}

	public int getScore(){

		return score;
	}

	public String getName(){

		return name;
	}

	public void setScore(int sc){

		score=sc;
	}

	public void setName(String nm){

		name=nm;
	}

	/**
		Compares the implicit player (this) to the one given in parameter considering the score
		@param b player we want to compare the implicit (this) player to
		@return int =1 if the implicit (this) player has a better score than the one given in parameter, -1 in the opposite case, and 0 if the scores are identicals

	*/

	public int compareTo(BestPlayer2 b){

		if (score<b.getScore()) return -1;
		if (score>b.getScore()) return 1;
		return 0;

	}




}
