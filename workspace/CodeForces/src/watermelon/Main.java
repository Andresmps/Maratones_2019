/**
 * 
 */
package watermelon;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/**
	 * Watermelon
	 * CodeForces 4A
	 */
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
	
		int w = Integer.valueOf(bf.readLine());

		pw.println(w % 2 == 0 && w != 2? "YES": "NO");
		pw.close();
	}

}
