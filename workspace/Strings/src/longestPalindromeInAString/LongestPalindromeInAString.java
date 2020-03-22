/**
 * 
 */
package longestPalindromeInAString;

import java.util.*;
import java.io.*;
/**
 * @author Andres Martinez
 *
 */
public class LongestPalindromeInAString {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{
		
		int T = Integer.valueOf(bf.readLine().trim());

		for (int i = 0; i < T; i++) {
			
			String S = bf.readLine().trim();
			StringBuilder s = new StringBuilder(S);
			Integer[] lps = Lps(S, s.reverse().toString());
			int index = 0, max = -1, k = 0;
			
//			sc.println(Arrays.toString(lps));
			
			for (Integer integer : lps) {
				if(max < integer) {
					max = integer;
					index = k;
				}
				k++;
			}
			sc.println(S.substring(index-max+1, index));
		}
		sc.close();
		
	}

	public static Integer[] Lps(String pattern, String patternR){
		
		int m = pattern.length();
		Integer[] lps = new Integer[m];
		
		// Lps[0] is always 0
		lps[0] = 0;
		
		for(int i = 1, j = 0; i < m; ) {
			
			// There is a match. Both pointer have to be increase.
			if(pattern.charAt(i) == patternR.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			}else {		
				// If j == 0 it means there has not been a match before.
				if(j == 0) {
					lps[i] = 0;
					i++;
					
				// Otherwise, we have to look for the last match that appear.
				// Note that i has not been increase.	
				}else  {
					j = lps[j-1]; 
				}
			}
		}
			
		return lps;
	}
	
}
