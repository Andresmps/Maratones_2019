/**
 * 
 */
package raisingBacteria;

import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class RaisingBacteria {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	public static void main(String[] args) throws IOException{

		int X = Integer.valueOf(bf.readLine());
		
		pw.println((X & (X-1)) == 0 ? 1 : calculateMod(X)); 
		pw.close();
	}
	
	public static int calculateMod(int x) {
		
		int count = 1; 
		
		while(x > 1) { count += x%2; x >>= 1; }
		
		return count;
	}

}
