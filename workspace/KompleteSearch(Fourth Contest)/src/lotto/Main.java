/**
 * 
 */
package lotto;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	/**
	 * Uva 441 - Lotto
	 */
	public static void main(String[] args) throws IOException{
		
		int k;
		st = new StringTokenizer(bf.readLine());
		k = Integer.valueOf(st.nextToken());
		int array[];
		
		while(k != 0) {
			array = new int[k];
			
			for(int i = 0; i < k; ++i) 
				array[i] = Integer.valueOf(st.nextToken());
			
			for(int a = 1; a <= k-5; ++a) {
				for(int b = a+1; b <= k-4; ++b) {
					for(int c = b+1; c <= k-3; ++c) {
						for(int d = c+1; d <= k-2; ++d) {
							for(int e = d+1; e <= k-1; ++e) {
								for(int f = e+1; f <= k; ++f) {
									pw.println(array[a-1]+" "+array[b-1]+" "+array[c-1]+" "+array[d-1]+" "+array[e-1]+" "+array[f-1]);
								}
							}
						}
					}
				}
			}
			st = new StringTokenizer(bf.readLine());
			k = Integer.valueOf(st.nextToken());
			if(k != 0) pw.println();
		}
		pw.close();

	}

}
