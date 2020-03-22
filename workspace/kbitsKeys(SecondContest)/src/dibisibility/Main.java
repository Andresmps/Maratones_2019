/**
 * 
 */
package dibisibility;

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
	 * Uva 10036 - Divisibility
	 */
	public static void main(String[] args) throws IOException{
		
		int M, N, K, sum;
		boolean flag;
		
		M = Integer.valueOf(bf.readLine());
		
		for(int i = 0; i < M; ++i) {
			
			flag = false;
			st = new StringTokenizer(bf.readLine());
			
			N = Integer.valueOf(st.nextToken());
			K = Integer.valueOf(st.nextToken());
			int[] numbers = new int[N];
			
			st = new StringTokenizer(bf.readLine());
			
			for(int j = 0; j < N; ++j) 
				numbers[j] = Integer.valueOf(st.nextToken());
			
			
			for(int j = 0; j < 1<< (N-1); ++j) {
				sum = numbers[0];
				for(int k = 0; k < (N-1); ++k) 
					sum += (j & (1 << k)) == 0 ? -numbers[k+1]: numbers[k+1];
				
				if(sum % K == 0) { flag = true; break; }
			}
			
			pw.println(flag ? "Divisible" : "Not divisible" );
		}
		pw.close();
	}
}

/*

2
4 7
17 5 -21 15
4 5
17 5 -21 15
*/

