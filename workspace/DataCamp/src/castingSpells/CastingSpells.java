/**
 * 
 */
package castingSpells;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 * Uva 1470
 */

public class CastingSpells {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Vector<Integer> maxSufix = new Vector<>();;
    static StringTokenizer in;

	public static void main(String[] args) throws IOException{
		
		String s;
		int Z;
		
		Z = Integer.valueOf(bf.readLine().trim());
		
		for(int i = 0; i < Z; i++) {
			
			s = bf.readLine().trim();
			int power = 0;
			
			kmp(s, reverse(s));
//			System.out.println(maxSufix);
			
			for (int p : maxSufix) {
				power = Math.max(p, power);
			}
			
			
			sc.println(power);
			maxSufix.clear();
			 
		}
		sc.close();	
	}
	
	public static String reverse(String s) {
		
		String reverseS = "";
		for(int i = s.length()-1; i >= 0; i--) {
			reverseS += s.charAt(i)+"";
		}
		return reverseS;
	}
    
	public static Vector<Integer> kmp(String text, String pattern){
		
		Vector<Integer> indexes = new Vector<>();
		int[] lps = Lps(pattern);
		int m = text.length(), n = pattern.length();
		int count = 0;
		
		for(int i = 0, j = 0; i < m ; ) {
			
			if(text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
				count++;
				
				if(j == n) {
					System.out.println("Match found in "+(i-j));
					indexes.add(i-j);
					j = lps[n-1];
				}
			}else {
				if(count != 0 && count != 1) {
					maxSufix.add(count);
				}
				
				if(j == 0)  i++; 
				else {
					j = count = lps[j-1];
				}
			}	
		}
		
		if(count != 0 && count != 1) {
			maxSufix.add(count);
		}
		return indexes;
		
	}
	
	
	// Lps  
	// Longest prefix that is also a suffix but is not equal to the string
	
	public static int[] Lps(String pattern){
		
		int m = pattern.length();
		int[] lps = new int[m];
		
		// Lps[0] is always 0
		lps[0] = 0;
		
		for(int i = 1, j = 0; i < m; ) {
			
			// There is a match. Both pointer have to be increase.
			if(pattern.charAt(i) == pattern.charAt(j)) {
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

/*

2
abrahellehhelleh
rachelhellabracadabra





		String a = "abrahellehhelleh";
		String a = "abrahhellehhhellehhb";
		
		System.out.println(Arrays.toString(Lps(a)));
		System.out.println(Arrays.toString(Lps(reverse(a)))); 
		System.out.println(kmp(a, reverse(a))); 
		System.out.println(maxSufix);
		
		
		
			
//			reverseS = reverse(s);
			
//			
//			for (int j = 0, c = s.length() - 1; j < s.length(); j += 4) {
//				sc.println("j: "+j+" s(j): "+s.charAt(j)+" c: "+c+" s(c): "+s.charAt(c));
//				if (s.charAt(j) == s.charAt(c)) {
//					temp = 0;
//					do {
//						sc.println("j: "+j+" s(j): "+s.charAt(j)+" c: "+c+" s(c): "+s.charAt(c));
//						temp += 4;
//						c-= 4;
//					}while(s.charAt(j) == s.charAt(c));
//					c = 0;
//					power = Math.max(temp, power);
//					sc.println(power);
//				}
//			}
			
		
*/