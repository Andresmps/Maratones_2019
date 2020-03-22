package gcd;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	
	public static void main (String[] args) throws IOException{
		
		int T, a, b, aux;
		
		T = Integer.valueOf(bf.readLine());
		
		for (int i = 0; i < T; i++) {
			in = new StringTokenizer(bf.readLine());
			a = Integer.valueOf(in.nextToken());
			b = Integer.valueOf(in.nextToken());
			aux = gcd(a, b);
			sc.println(((a*b) /aux)+" "+aux);
		}
		sc.close();
	}
	public static int gcd(int a, int b) {
		
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}
