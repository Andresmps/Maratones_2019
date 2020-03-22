/**
 * 
 */
package permutationOfAGivenString;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */

public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{
		
		int T = Integer.valueOf(bf.readLine().trim());
		
		for(int i = 0; i < T; ++i) {
			
			char[] temp = bf.readLine().trim().toCharArray();
			
			Arrays.sort(temp);
			computePermutations("", new String(temp), 0);
//			computePermutations("", bf.readLine(), 0);
			
//			Collections.sort(permutations);
//			permutations.forEach(s -> sc.print(s+" "));
			sc.println();
//			permutations.clear();
		}
		
		sc.close();
	}
	
	public static void computePermutations(String define, String undefine, int i) {
		
		if(0 == undefine.length()) {
			sc.println(define+" ");
//			permutations.add(define);
			return;
		}
		
		for(int j = 0; j < undefine.length(); j++) {
			StringBuilder tempS = new StringBuilder(undefine);
			computePermutations(define+tempS.charAt(j), tempS.deleteCharAt(j).toString(), ++i);
		}
	}
}
