/**
 * 
 */
package concatenatedPrimeNumbers;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Cocatenated {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	static int MAX = 10001000;
	static boolean[] sieve = new boolean[MAX+1];
	static ArrayList<Integer> primes = new ArrayList<>();


	public static void main(String[] args) throws IOException{

		String s, n;
		int k; 
		boolean flag;
		getPrimes();
		//System.out.println(primes);
		
		while((s = bf.readLine()) != null) {
			
			in = new StringTokenizer(s.trim());
			k = Integer.valueOf(in.nextToken());
			//if(k == -1) break;
			n = in.nextToken();
			flag = false;
			
			for (int i = 0; i < n.length(); i += k) {
				//System.out.println(Integer.valueOf(n.substring(i, i+k)));
				if(sieve[Integer.valueOf(n.substring(i, i+k))]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				sc.println(":(");
			}else {
				sc.println(":)"); 
			}
			
		}
		sc.close();

	}
	
	public static void getPrimes() {
		
		sieve[0] = sieve[1] = true;
		
		for (int i = 2; i <= MAX; i++) {
			if(sieve[i]) continue;
			primes.add(i);
			for (int j = 2*i; j <= MAX; j += i) {
				sieve[j] = true;
			}
		}
		
	}

}
/*

1 2
1 3
2 12331719232931374143475359616771737983
1 4347
2 4347
1 245
2 130711
*/