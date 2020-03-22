/**
 * 
 */
package gameFuntion;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class GameFuntion {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{
		int t = Integer.valueOf(bf.readLine());
		for (int i = 0; i < t; i++) {	
			int n = Integer.valueOf(bf.readLine());
			sc.println(funtion(n));
			
		}
		sc.close();
	}
	
	public static int funtion(int x) {
		if(x == 0) return 1;
		
		return funtion(x-1)-x+1;
	}
}
