package scores;
import java.util.*;
import java.io.*;

public class BestPlayer2{

	String name=new String();
	int score=0;

	void BestPlayer2(String nm, int scr){

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

	public int compareTo(BestPlayer2 b){

		if (score<b.getScore()) return -1;
		if (score>b.getScore()) return 1;
		return 0;

	}




}