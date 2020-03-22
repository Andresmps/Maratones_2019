/**
 * 
 */
package threePowers;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * @author Andres Martinez
 *
 */
public class ThreePowers {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		
		while(true) {

			long n = Long.valueOf(bf.readLine());
			if(n-- == 0)break;
			String message = "{";
			BigInteger three = new BigInteger("3");
			
			for(int i = 0; i < Long.toBinaryString(n).length(); ++i) {	
				if((n >> i & 1) == 1)
					message += " "+three.pow(i)+","; 
			}
			if(!message.equals("{")) message = message.substring(0, message.length()-1);
			message += " }";
			
			pw.println(message);
			
		}
		pw.close();
	}

}
