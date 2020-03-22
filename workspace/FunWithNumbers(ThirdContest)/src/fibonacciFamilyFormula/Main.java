/**
 * 
 */
package fibonacciFamilyFormula;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/**
	 * Fibonacci Family Formula
	 */
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int MAX = 101;
	static long[][] identM;
	static long[][] matriz;
	static int MOD = 1000000009;

	public static void main(String[] args) throws IOException{

		int k;
		long n;

		while(true) { 
			
			st = new StringTokenizer(bf.readLine());
			k = Integer.valueOf(st.nextToken());
			n = Long.valueOf(st.nextToken());
			
			identM = new long[k][k];
			matriz = new long[k][k];
		
			identMatrix(k);
			initMatrix(k);
			
//			mostrarMatrix(matriz);
			if(k == 0 && n == 0) break;
			if(n == 0) pw.println(1);
			else {
				if (k == 2)
					n %= 333333336;
				chanceMatrix(k, 1); 
				System.out.println(modPow(matriz, n, MOD, k)[0][0]);
			}
		}
		
		pw.close();
	}
		
	public static void initMatrix(int k) {
		
		for(int i = 0; i < k; ++i) {
			if(i-1 >= 0) matriz[i][i-1] = 1;
		}
		
	}
	
	public static void chanceMatrix(int n, int value) {
		
		for(int i = 0; i < n; ++i) {
			 matriz[0][i] = value;
		}
		
	}
	
	public static void identMatrix(int k) {
		for(int i = 0; i < k; ++i) {
			identM[i][i] = 1;
		}
	}

	public static long multiplyVector(long[][] a, long[] b, long mod, int K) {
		long A = 0;
		
		for(int k = 0; k < K; ++k) 
			A += (a[0][k] * b[k]) % mod;
		
		A %= mod; 
		return A;
	}
	
	public static long[][] multiplyMatrix(long[][] a, long[][] b, long mod, int K) {
		long[][] A = new long[K][K];
		
		for(int i = 0; i < A.length; ++i) {
			for(int j = 0; j < A[i].length; ++j) {
				for(int k = 0; k < A[i].length; ++k) {
					A[i][j] += (a[i][k] * b[k][j]) % mod;
				}
				A[i][j] %= mod;
			}
		} 
		return A;
	}
	
	public static long[][] modPow(long[][] x, long n, long mod, int K){
		
		long[][] A = identM;
		while(n > 0) {
			if((n & 1) == 1) A = multiplyMatrix(A, x, mod, K);
			
			x = multiplyMatrix(x, x, mod, K); 
			n >>= 1;
		} 
		return A;
	}
	
	public static void mostrarMatrix(long[][] A) {
		
		for(int i = 0; i < A.length; ++i) {
			for(int j = 0; j < A[i].length; ++j) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	
}


/*
15 195997924115520
63 22187858690755
87 170137135597457
93 111916752324163
96 79073200316925
7 110034978335987
13 369329951123240
0 0

*/