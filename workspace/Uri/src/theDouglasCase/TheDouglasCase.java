/**
 * 
 */
package theDouglasCase;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class TheDouglasCase {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	static int MAX = 100000;
	static boolean marks[] = new boolean[MAX];
	 
	public static void main(String[] args) throws IOException{
		
		int N, n_i;
		
		getPrimes();
		N = Integer.valueOf(bf.readLine());
		
		for(int i = 0; i < N; ++i) {
			n_i = Integer.valueOf(bf.readLine())+1;
			pw.println((n_i % 7 == 0 && n_i % 2 != 0 && !marks[n_i+2]) ? "Yes" : "No");
		}
		
		
		pw.close();
	}
	
	public static void getPrimes() {
		
		for(int i = 2; i < MAX; ++i) {
			if(marks[i]) continue;
			
			for(int j = 2*i; j < MAX; j += i) 
				marks[j] = true;
		}
	}
}


