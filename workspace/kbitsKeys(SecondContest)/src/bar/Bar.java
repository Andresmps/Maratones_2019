/**
 * 
 */
package bar;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Bar {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static ArrayList<Integer> bars = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
	
		int t = Integer.valueOf(bf.readLine().trim());
		
		for(int i = 0; i < t; ++i) {
			
			int n = Integer.valueOf(bf.readLine().trim());
			int p = Integer.valueOf(bf.readLine().trim());
			
			StringTokenizer in = new StringTokenizer(bf.readLine());
			
			while(in.hasMoreTokens()) 
				bars.add(Integer.valueOf(in.nextToken()));
			
			int sum;
			boolean flag = false;

			for(int j = 0; j < 1<<p ; ++j) {
				sum = 0;
				for(int k = 0; k < p ; ++k) {
					if((j >> k & 1) == 1) 
						sum += bars.get(k);
				}

				if(sum == n) { flag = true; break; }
			}
			
			pw.println(flag ? "YES" : "NO");
			bars.clear();
		}
		pw.close();

	}

}
