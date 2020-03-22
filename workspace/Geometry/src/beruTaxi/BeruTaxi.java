/**
 * 
 */
package beruTaxi;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class BeruTaxi {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer in;
    
	public static void main(String[] args) throws IOException{

		int a, b, n, x, y;
		double time = 0, velocity;
		
		in = new StringTokenizer(bf.readLine());
		
		a = Integer.valueOf(in.nextToken());
		b = Integer.valueOf(in.nextToken());

		n = Integer.valueOf(bf.readLine());
		
		for (int i = 0; i < n; i++) {
			in = new StringTokenizer(bf.readLine());
			x = Integer.valueOf(in.nextToken());
			y = Integer.valueOf(in.nextToken());
			velocity = Integer.valueOf(in.nextToken());
			
			if(i == 0) time = distance(a, b, x, y) / velocity;
			else time = Math.min(time, distance(a, b, x, y) / velocity);
		}
		sc.println(time);
		sc.close();
		
	}
	public static double distance(int a, int b, int x, int y) {
		
		return Math.sqrt((x-a)*(x-a) + (y-b) * (y-b));
	}

}
