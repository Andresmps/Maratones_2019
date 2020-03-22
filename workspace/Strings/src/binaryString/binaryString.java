/**
 * 
 */
package binaryString;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class binaryString {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{
		
		String S;
		int T, N, count;
		
		T = Integer.valueOf(bf.readLine().trim());
		
		for(int i = 0; i < T ; ++i) {
			
			N = Integer.valueOf(bf.readLine().trim());
			S = bf.readLine().trim();
			count = 0;
			
			for(int j = 0; j < N; ++j) if(S.charAt(j) == '1') count++;
			
			sc.println((count*(count-1))/2);
		}
		
		sc.close();
		
		
	}
	
	
	public static boolean isValidIP(String s){
		 
		 if(s.charAt(s.length()-1) == '.') s+="0";
		 StringTokenizer on = new StringTokenizer(s.trim(), ".");
		 String temp;
		 
		 if(on.countTokens() != 4) return false;
		 
		 while(on.hasMoreTokens()) {
				temp = on.nextToken(); 
				if(temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z') return false;
				
				if(Integer.valueOf(temp) >= 0 && Integer.valueOf(temp) <= 255 ) {
					if(temp.length() > 1 && temp.charAt(0) == '0') {
						return false;
					}
				} else {
				    return false;
				}
			 }
		 
		 return true;
	}
}


// binaryString
/* 
 
2
1111
1011

 */


// isValid
/* 

sc.println(isValidIP("222.111.111.111"));
sc.println(isValidIP("5555..555"));
sc.println(isValidIP("0.0.0.0."));
sc.println(isValidIP("1.2.3.04"));
 */

