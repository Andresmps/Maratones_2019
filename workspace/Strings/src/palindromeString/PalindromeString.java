/**
 * 
 */
package palindromeString;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class PalindromeString {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{
	
		String S;
		int T, N;
		
		T = Integer.valueOf(bf.readLine().trim());

		for (int i = 0; i < T ; ++i) {
			
			N = Integer.valueOf(bf.readLine().trim());
			S = bf.readLine().trim();
			
			sc.println(isPalindrome(S, N) ? "Yes" : "No");
		}
		sc.close();
	}
	
	public static boolean isPalindrome(String S, int N) {
		
		for(int j = 0, k = N-1; j <= k ; ++j, --k) {
			sc.println(j);
			if(S.charAt(j) != S.charAt(k)) {
				return false;
			}
		}
		
		return true;
	}
}
