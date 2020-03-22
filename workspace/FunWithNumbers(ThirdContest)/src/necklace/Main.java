/**
 * 
 */
package necklace;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static long MOD = 1000000007;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		
		int T, N;
		long K;
		
		T = Integer.valueOf(bf.readLine().trim());
		
		for(int i = 0; i < T; ++i) {
			
			st = new StringTokenizer(bf.readLine());
			N = Integer.valueOf(st.nextToken());
			K = Integer.valueOf(st.nextToken());
			
			pw.println("Case "+(i+1)+": "+sumatoria(N, K));
		}
		pw.close();
	}
	
	public static long sumatoria(int N, long K) {
		long sum = 0;
		
		for(int i = 0; i < N; ++i) {
			sum += modPow(K, gcd(i, N), MOD) % MOD;
		} 
		sum = sum % MOD;
		sum = (sum * modPow(N, MOD-2, MOD)) % MOD;
		return sum;
	}
	
	
	public static int gcd(int a, int b) {
		if(b != 0) return gcd(b, a%b);
		return a;
	}

	public static long modPow(long x, long n, long mod) {
		
		if(n == 0) return 1 % mod;
		long u = modPow(x, n/2, mod);
		u = (u*u) % mod ;
		
		if(n % 2 == 1) u = (u*x) % mod; 
		
		return u;
	}
	
	 
	public static String sumatoria2(int N, long K) {
		BigInteger sum = BigInteger.ZERO;
		BigInteger k = new BigInteger(K+"");
		for(int i = 0; i < N; ++i) {
			sum = sum.add(k.pow(gcd(i, N))); 
		}
		sum = sum.divide(new BigInteger(N+"")).mod(new BigInteger(MOD+""));  
		return sum.toString();
	}
	
}
/*
7
4 2
5 7
5 2
4 8
4 3
5 3
5 5
*
*/
 