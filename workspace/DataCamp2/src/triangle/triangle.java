package triangle;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

// https://codeforces.com/problemset/problem/6/A
// priority queue

public class triangle {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static ArrayList<Integer> sides = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{

		in = new StringTokenizer(bf.readLine().trim());
		for (int i = 0; i < sides.size(); i++) {
			sides.add(Integer.valueOf(in.nextToken()));		
		}
		Collections.sort(sides);
		
		Point p1 = new Point();
		
		if(sides.get(0)+ sides.get(1) > sides.get(2) || sides.get(1)+sides.get(2) > sides.get(3)){
			System.out.println("TRIANGLE");
		}
	 	
		
		
	}

	public static double crossProduct(Point v1, Point v2){
		 return v1.getX()*v2.getY() - v1.getX()*v2.getY();
	}
	
}
