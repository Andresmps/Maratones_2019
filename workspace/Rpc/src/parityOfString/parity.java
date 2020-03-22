/**
 * 
 */
package parityOfString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Andres Martinez
 *
 */
public class parity {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out))); 
	/**
	 * @param args
	 * Parity Of String
	 */
	public static void main(String[] args) throws IOException{
		
		String s = bf.readLine();
		int[] letters = new int[26];
		int even = 0, odd = 0;
		
		for(int i = 0; i < s.length(); ++i) {
			letters[s.charAt(i)-'a']++;
		}
		
		for (int i : letters) {
			if(i != 0) {
				if(i % 2 == 0) even++;
				else odd++;
			}
		}
		
		if(even == 0 && odd > 0) {
			sc.println(1);
		}else if(odd == 0 && even > 0) {
			sc.println(0);
		}else {
			sc.println(2); 
		}
		
		sc.close();
	}

}
/* 
coachesc 
coachesarefun 
coachessoaehwwwwww 

1 2 0
*/