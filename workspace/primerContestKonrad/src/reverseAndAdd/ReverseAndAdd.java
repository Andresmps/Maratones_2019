/**
 * 
 */
package reverseAndAdd;

/**
 * @author Andres Martinez
 * Uva 10018	Reverse and Add
 */
import java.util.*;
import java.io.*;

public class ReverseAndAdd {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		int N = Integer.valueOf(bf.readLine().trim());
		StringBuilder P;
		for(int i = 0; i < N; ++i) {
			P = new StringBuilder(bf.readLine().trim());
			int j = 0;
			 do{
				long temp = Long.valueOf(P.toString()) + Long.valueOf(P.reverse().toString());
				P = new StringBuilder(String.valueOf(temp));
				j++;	
			}while(!isPalindrome(P.toString()));
			pw.println(j + " "+P); 
		}
		pw.close();
	}
	
	public static boolean isPalindrome(String number) {
		
		int mid = number.length() % 2 == 0 ? number.length()/2 : (number.length()/2)+1;
		for(int i = 0, j = number.length()-1; i < mid; i++, j--) {
			if (number.charAt(i) != number.charAt(j)) return false;
		}
		
		return true;
	}
}
