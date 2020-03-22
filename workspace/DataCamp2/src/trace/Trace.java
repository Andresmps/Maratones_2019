package trace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Trace {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static ArrayList<Integer> numbers = new ArrayList<>();

	
	public static void main(String[] args) throws IOException{
		
		int s = Integer.valueOf(bf.readLine().trim());
		double area = 0;
		in = new StringTokenizer(bf.readLine().trim());
		
		for (int i = 0; i < s; i++) {
			numbers.add(Integer.valueOf(in.nextToken())); 
		}
		
		Collections.sort(numbers); 
		
		for (int i = numbers.size()-1; i >= 0; i--) {
			area += numbers.get(i)*numbers.get(i)*Math.PI;
			if((i-1) != -1){
				area -= numbers.get(i-1)*numbers.get(i-1)*Math.PI;
				i--;
			}
			
		}
		System.out.println(area);
		
	}

}
