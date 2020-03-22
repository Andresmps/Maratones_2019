/**
 * 
 */
package theDecoder;

import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * @author Andres Martinez
 *
 */
public class TheDecoder {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static DataInputStream a = new DataInputStream(System.in);
	
	public static void main(String[] args) throws IOException{
		
		char s = '_';
//		a.readChar()
		while(s != '-') {
//			if(s.equals("-1")) break;
			s = a.readChar();
			if(s != '\n') pw.print((char)(s - 7));
			else pw.println("hola");
		}
		pw.close();
	}

}
