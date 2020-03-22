package freeRobots;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class FreeRobots {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static Long[] steps = new Long[15];  
	
	public static void main(String[] args) throws IOException{
		
		int T = Integer.valueOf(bf.readLine()), N;
		
		steps[1] = (long)3;
		for (int i = 2; i < steps.length; i++) {
			steps[i] = steps[i-1]* 5;
		}
		
		for (int i = 0; i < T; i++) {
			N = Integer.valueOf(bf.readLine());
			
			sc.println(steps[N]); 
		}
		sc.close();
	}
	
	

}
