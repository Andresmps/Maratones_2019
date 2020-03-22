/**
 * 
 */
package division;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Division {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		String s;
		
		while(true) {
			int k = Integer.valueOf(bf.readLine().trim()), N, M, X, Y;
			if(k == 0) break;
			st = new StringTokenizer(bf.readLine().trim());
			N = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());
			
			for(int i = 0; i < k; ++i) {
				st = new StringTokenizer(bf.readLine().trim());
				X = Integer.valueOf(st.nextToken());
				Y = Integer.valueOf(st.nextToken());
				
				if(X == N || Y == M) pw.println("divisa");
				else if(Y > M) pw.println(X > N ? "NE" : "NO");
				else pw.println(X > N ? "SE" : "SO");
			}
		}
		pw.close();
	}

}
