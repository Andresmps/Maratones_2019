/**
 * 
 */
package simpleEquation;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	/**
	 * Uva 11565 - Simple Equations
	 */
	public static void main(String[] args) throws IOException{

		int A, B, C, x, y, z, N, k;
		boolean flag;
		// -2 -1 4 - 2 6 9
		N = Integer.valueOf(bf.readLine());
		
		for (int p = 0; p < N; ++p) {
			flag = false;
			x = 0; y = 0; z = 0;
			st = new StringTokenizer(bf.readLine());
			
			A = Integer.valueOf(st.nextToken()); 
			B = Integer.valueOf(st.nextToken());
			C = Integer.valueOf(st.nextToken());
			
			for(int i = -100; i < 100; ++i) {
				x = i;
				for(int j = i+1; j < 100; ++j) {
					y = j;
					k = (x+y-A)*-1;
					if(k == j || k == i) continue;
						
					if(x+y+k == A && x*y*k == B && (x*x)+(y*y)+(k*k) == C) {
						z = k;
						flag = true;
						break;
					}
						
						
					
					if(flag) break;
				}
				if(flag) break;
			}
			pw.println(flag ? x+" "+y+" "+z : "No solution.");
		}
		pw.close();
	}

}
