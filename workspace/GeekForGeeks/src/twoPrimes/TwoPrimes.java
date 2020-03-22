package twoPrimes;

import java.util.*;
import java.lang.*;
import java.io.*;

public class TwoPrimes {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	static int MAX = 12000;
	static ArrayList<Integer> primes = new ArrayList<>();
	static boolean[] sieve = new boolean[MAX+1];
	
	public static void main(String[] args) throws IOException{
		
		getPrimes();
		
		int T = Integer.valueOf(bf.readLine());
		int N;
		
		for (int i = 0; i < T; i++) {
			N = Integer.valueOf(bf.readLine().trim());
			
			for (int j = 0; j < N; j++) {

				if(!sieve[N-primes.get(j)]) {
					sc.println(primes.get(j)+" "+(N-primes.get(j))); 
					break;
				}
			}
			
		}
		
		sc.close();

	}
	
	public static void getPrimes() {
		
		for (int i = 2; i <= MAX; i++) {
			if(sieve[i]) continue;
			primes.add(i);
			for (int j = i*2; j <= MAX; j+=i) {
				sieve[j] = true;
			}
		}
	}

}
