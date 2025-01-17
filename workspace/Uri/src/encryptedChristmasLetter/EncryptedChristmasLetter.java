/**
 * 
 */
package encryptedChristmasLetter;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class EncryptedChristmasLetter {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	
	public static void main(String[] args) throws IOException{
	
		String s = bf.readLine(), msg = "";
		
		do {
			//if(s.equals("0")) break;
			for(int i = 0; i < s.length(); ++i) {
				switch (s.charAt(i)) {
				case '@':
					msg += "a";
					break;
				case '&':
					msg += "e";
					break;
				case '!':
					msg += "i";
					break;
				case '*':
					msg += "o";
					break;
				case '#':
					msg += "u";
					break;
				default:
					msg += s.charAt(i)+"";
					break;
				}
			}
			
			s = bf.readLine();
			if(s != null) msg += "\n";
			
		}while(s != null);
		
		pw.println(msg);
		pw.close();
	}
}


