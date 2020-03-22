/**
 * 
 */
package balanceGame;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/**
	 * Balance Game
	 */
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int MAX = 5*1000001;
	
	public static void main(String[] args) throws IOException{
		
		String s;
		int M, W;
		
		while((s = bf.readLine()) != null) {
			
			st = new StringTokenizer(s); 
			
			M = Integer.valueOf(st.nextToken());
			W = Integer.valueOf(st.nextToken());
			
			int[] tokens = new int[3];
			int[] numbTokens = new int[3];
			int[] count = new int[W+1];
			
			st = new StringTokenizer(bf.readLine());
			
			tokens[0] = Integer.valueOf(st.nextToken());
			tokens[1] = Integer.valueOf(st.nextToken());
			tokens[2] = Integer.valueOf(st.nextToken());
			
			Arrays.fill(numbTokens, M);
			
			count[0] = 1;
			for(int x = 1; x <= W; ++x) {
				int t = 0;
				for(int c = 0; c < tokens.length; ++c) {
					if(x - tokens[c] >= 0 && numbTokens[c] > 0) {
						count[x] += count[x-tokens[c]];
						numbTokens[c]--;
					}
				}
				
			}
			
			System.out.println(Arrays.toString(count));
			
			System.out.println(count[W]);
			
		}
		

	}

}
