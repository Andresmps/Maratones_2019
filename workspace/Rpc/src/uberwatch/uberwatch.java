package uberwatch;

import java.util.*;
import java.io.*;

public class uberwatch {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int[] enemies = new int[3*1000000];
	static int[] solution = new int[3*1000000];

	public static void main(String[] args) throws IOException{

		int n, m, x = 0, m2;
		
		st = new StringTokenizer(bf.readLine());
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i < n; i++) {
			enemies[i] = Integer.valueOf(st.nextToken()); 
		}
		
		for(int i = m; i < n; i++) {
			solution[i] = Math.max(enemies[i]+solution[i-m], solution[i-1]); 
		}
		
		pw.println(solution[n-1]);
		pw.close();

	}

}
