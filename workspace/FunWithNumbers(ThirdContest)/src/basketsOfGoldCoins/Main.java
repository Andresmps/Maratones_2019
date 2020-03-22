/**
 * 
 */
package basketsOfGoldCoins;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {
	
	/**
	 * Baskets Of Gold Coins
	 */
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		String s;
		int N, w, d, T, numBasket, factors;
		
		while((s = bf.readLine()) != null) {
			
			st = new StringTokenizer(s);
			N = Integer.valueOf(st.nextToken());
			w = Integer.valueOf(st.nextToken());
			d = Integer.valueOf(st.nextToken());
			T = Integer.valueOf(st.nextToken());
			
			factors = (N * (N - 1)) / 2;
			numBasket = ( (factors * w) - T) / d;
			
			pw.println(numBasket != 0 ? numBasket : N);
		}
		pw.close();
	}

}