/**
 * 
 */
package reversingTheVowels;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class ReversingTheVowels {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{
		
		String S;
		int T;
		Stack<Character> vowels;
		
		T = Integer.valueOf(bf.readLine().trim());
		for(int i = 0; i < T ; ++i) {
			
			S = bf.readLine().trim();
			vowels = new Stack<>();
			
			initStacks(S, vowels);
			
			sc.println(reverseVowels(S, vowels));
  			
		}
		sc.close();

	}
	
	public static void initStacks(String S, Stack<Character> vowels) {
		
		for(int j = 0; j < S.length(); ++j) {
			
			if(S.charAt(j) == 'a' || S.charAt(j) == 'e' || S.charAt(j) == 'i' || 
				S.charAt(j) == 'o' || S.charAt(j) == 'u') {
					vowels.push(S.charAt(j)); 
			}
		}
	}
	
	public static String reverseVowels(String S, Stack<Character> vowels) {
		
		StringBuilder copyS = new StringBuilder();
		
		for(int j = 0; j < S.length(); ++j) {
			
			if(S.charAt(j) == 'a' || S.charAt(j) == 'e' || S.charAt(j) == 'i' || 
					S.charAt(j) == 'o' || S.charAt(j) == 'u') {
				copyS.append(vowels.pop());
			}else {
				copyS.append(S.charAt(j));
			}
		
		}
		
		return copyS.toString();
	}

}
