/**
 * 
 */
package gameDigits;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class GameDigits {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	static ArrayList<Integer> primes = new ArrayList<>();
	static int MAX = 100000000;
	static Random rand = new Random();
	static boolean[] sieve = new boolean[MAX+1]; 
	
	
	public static void main(String[] args) throws IOException {
		getPrimes();
//		System.out.println(primes.size());
//		System.out.println(primes.get(primes.size()-1));
		System.out.println(Long.MAX_VALUE);
		//int T = Integer.valueOf(bf.readLine().trim());
		int T = rand.nextInt(100);
		System.out.println(T);
		
		for (int i = 0; i < T; i++) {
			Deque<Integer> factors = new LinkedList<>();
//			Long N = Long.valueOf(bf.readLine().trim());
			int N = rand.nextInt(100000000);
			System.out.println(N); 
			int k = 0;
			while(N != 1) {
				if(N % primes.get(k) == 0) {
					N = N/primes.get(k);
					factors.add(primes.get(k));
				}else {
					k++;
				}
			}
			
			String message = "";
			
			message += factors.pollFirst();
			
				
			while(!factors.isEmpty()) {
				
				int temp = factors.pollFirst();
				
				if(factors.isEmpty()) {
					
					message += temp;
				}else if(( (temp * factors.peekFirst() ) + "").length() == 1) {
					
					message += (temp * factors.pollFirst()) + "";					
				}else {
					
					message += temp;
					message += factors.pollFirst();
				}
					
			}
				
			System.out.println(message);
			
		}

	}
	
	public static void getPrimes() {
		
		for (int i = 2; i <= MAX; i++) {
			if(sieve[i]) continue;
			
			primes.add(i);
			for (int j = 2*i; j <=MAX; j+=i) {
				sieve[j] = true;
			}
		}
	}

}
