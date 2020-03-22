/**
 * 
 */
package triTiling;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class TriTiling {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{
		
		while(true) {
			int n = Integer.valueOf(bf.readLine());
			if(n == -1) break;
			if(n % 2 != 0) sc.println(0);
			else sc.println((long)numberOfTiles(3, n));
		}
		sc.close();
	}

	public static double numberOfTiles(int n, int m) {
		
		double result = 1;
		
		for(int i = 1; i <= Math.ceil(n/2); i++) {
			for(int j = 1; j <= Math.ceil(m/2); j++) {
				result *= 4 * ( (Math.cos((Math.PI*i)/(n+1)) * Math.cos((Math.PI*i)/(n+1))) + 
						(Math.cos((Math.PI*j)/(m+1)) * Math.cos((Math.PI*j)/(m+1))) ); 
			}
		}
		
		return result;
	}
}
