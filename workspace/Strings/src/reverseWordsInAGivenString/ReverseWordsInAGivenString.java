/**
 * 
 */
package reverseWordsInAGivenString;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class ReverseWordsInAGivenString {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{

		int T = Integer.valueOf(bf.readLine().trim());
		
		for(int i = 0; i < T ; ++i) {
			String reverseString = "";
			
			in = new StringTokenizer(bf.readLine(), ".");
			
			while(in.hasMoreTokens()) {
				reverseString = in.nextToken() +"."+ reverseString;
			}
			sc.println(reverseString.substring(0, reverseString.length()-1));
		}
		
		sc.close();
	}

}
/*

2
i.like.this.program.very.much
pqr.mno

*/