/**
 * 
 */
package marbles;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Marbles {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer in;
    static int x, y, d;
    
	public static void main(String[] args) throws IOException{

		gcd(4, 43); 
		System.out.println(x);
		System.out.println(y);
		System.out.println(d);
		
		gcd(3, 43); 
		System.out.println(x);
		System.out.println(y);
		System.out.println(d);
		
		int n, c1, c2, n1, n2, temp;
		
		while(true) {
		
			n = Integer.valueOf(bf.readLine().trim());
			
			if(n == 0)
				break;
			
			in = new StringTokenizer(bf.readLine().trim());
			c1 = Integer.valueOf(in.nextToken());
			n1 = Integer.valueOf(in.nextToken());
			
			in = new StringTokenizer(bf.readLine().trim());
			c2 = Integer.valueOf(in.nextToken());
			n2 = Integer.valueOf(in.nextToken());
			
			if(c1 > c2) {
				gcd(n2, n);
//				temp = 
			}else {
				gcd(n1, n);
			}
			
					
		}
		sc.close();
	}
	
	public static void gcd(int a, int b){
		
		int[] nums = new int[3];
		
		if(b == 0) {
			x = 1;
			y = 0;
			d = a;
			return;
			
		}else {
			gcd(b, a % b);
			int x1 = y;
			int y1 = x - (a / b) * y;
			x = x1;
			y = y1;
		}
	}
	

}

/*
43
1 3
2 4
40
5 9
5 12
0
 */