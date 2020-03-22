/**
 * 
 */
package product;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/**
	 * Uva 10106	Product
	 */
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{

		String s;
		
		while((s = bf.readLine()) != null) {
			BigInteger A = new BigInteger(s.trim());
			BigInteger B = new BigInteger(bf.readLine().trim());
			
			pw.println(A.multiply(B));
		}
		pw.close();
		

	}

}
