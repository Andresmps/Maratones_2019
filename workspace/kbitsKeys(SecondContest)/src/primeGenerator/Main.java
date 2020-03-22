/**
 * 
 */
package primeGenerator;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/**
	 * Spoj PRIME1 - Prime Generator
	 */
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int MAX = 1000000000;
	static int[] primes = new int[MAX+1];
	static boolean[] sieve = new boolean[MAX+1];

	public static void main(String[] args) throws IOException{

		long t, m, n;
		t = Integer.valueOf(bf.readLine());
		getPrimes();
		for(int i = 0; i < t; ++i) {
			st = new StringTokenizer(bf.readLine());
			m = Integer.valueOf(st.nextToken());
			n = Integer.valueOf(st.nextToken());
			
			for(long j = m; j <= n; ++j) {}
//			    if(!sieve[j]) pw.print(primes[j]);
			
		}
		pw.close();

	}
	
	public static void getPrimes() {
		
		for(int i = 2; i <= MAX; ++i) {
			if(sieve[i]) continue;
			primes[i] = i;
			for(int j = 2*i; j <= MAX; j+=i) 
				sieve[j] = true;
		}
	}

}
