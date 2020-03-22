/**
 * 
 */
package soldiersAndBananas;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/**
	 * Soldier and Bananas 
	 * CodeForces 546A
	 */
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		int k, w, n, cost;
		
		st = new StringTokenizer(bf.readLine());
		
		k = Integer.valueOf(st.nextToken());
		w = Integer.valueOf(st.nextToken());
		n = Integer.valueOf(st.nextToken());
		cost = k*((n*(n+1))/2);
		
		pw.println(cost <= w ? 0 : cost-w);
		pw.close();
	}

}
