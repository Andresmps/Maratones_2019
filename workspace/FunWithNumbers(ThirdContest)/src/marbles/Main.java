/**
 * 
 */
package marbles;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/**
	 * Marbles
	 */
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{

		long n, c1, n1, c2, n2, k, x, y, d, minCost;
		
		while(true) {
			
			n = Integer.valueOf(bf.readLine());
			if(n == 0) break;
			
			st = new StringTokenizer(bf.readLine());
			c1 = Long.valueOf(st.nextToken());
			n1 = Long.valueOf(st.nextToken());
			
			st = new StringTokenizer(bf.readLine());
			c2 = Long.valueOf(st.nextToken());
			n2 = Long.valueOf(st.nextToken());
			
			long[] gcd = euclidExtended(n1, n2);
			
			if(n % gcd[2] != 0) {
				System.out.println("failed");
				continue;
			} 
			k = 0; x = gcd[0]*n; y = gcd[1]*n; d = gcd[2]; minCost = Long.MAX_VALUE;
			
			while(minCost > (x*c1)+(y*c2)) {
				
				x = (gcd[0]*n) + ((n2*k)/d);
				y = (gcd[1]*n) - ((n1*k)/d);
				minCost = (x*c1)+(y*c2);
				System.out.println(x+", " +y);
				
				if(x < 0) {
					k = n1 > 0 ? k-1 : k+1;
					continue;
				}
					
				if(y < 0) {
					k = n1 > 0 ? k-1 : k+1;
					continue;
				}
				
				if(c1 > c2) {
					k = n1 > 0 ? k-1 : k+1;
				}else if(c1 < c2) {
					k = n2 > 0 ? k+1 : k-1;
				}else {
					if(n1 > n2) {
						if(y < 0) break;
						k = n2 > 0 ? k+1 : k-1;
					}else {
						if(x < 0) break;
						k = n1 > 0 ? k-1 : k+1;
					}
				}
			}
			
			k--;
			x = (gcd[0]*n) + ((n2*k)/d);
			y = (gcd[1]*n) - ((n1*k)/d);
			
			System.out.println(x+" "+y);
			
		}
		

	}
	
	public static long[] euclidExtended(long a, long b){
		
		long x, y, d;
		
		if(b == 0) { long[] temp = {1, 0, a}; return temp;}
		
		long[] temp = euclidExtended(b, a%b);
		x = temp[1]; y = temp[0] - ((a/b)*temp[1]); d = temp[2];
		long[] temp1 = {x, y, d};
		
		return temp1;
	}

}
