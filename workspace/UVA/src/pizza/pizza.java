/**
 * 
 */
package pizza;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class pizza {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer in;
	
	// Pizza Deal
	
	public static void main(String[] args) throws IOException{
		
		double A, P1, P2, R;
		double AreaC;
		
		in = new StringTokenizer(bf.readLine().trim());
		
		A = Integer.valueOf(in.nextToken());
		P1 = Integer.valueOf(in.nextToken());
		
		in = new StringTokenizer(bf.readLine().trim());

		R = Integer.valueOf(in.nextToken());
		P2 = Integer.valueOf(in.nextToken());
		
		AreaC = R*R*Math.PI;
		
		if((A / P1) > (AreaC / (double) P2)) {
			sc.println("Slice of pizza");
		}else {
			sc.println("Whole pizza");
		}
		
		sc.close();
	}

}
