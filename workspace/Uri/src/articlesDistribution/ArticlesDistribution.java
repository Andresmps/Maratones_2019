/**
 * 
 */
package articlesDistribution;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class ArticlesDistribution {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	
	public static void main(String[] args) throws IOException{
	
		int N, A, sum;
		
		
		while(true) {
		
			N = Integer.valueOf(bf.readLine());
			
			if(N == 0) break;
			
			int array1[] = new int[N];
			int array2[] = new int[N];
			sum = 0;
			
			for(int i = 0; i < N; ++i) {
				array1[i] = Integer.valueOf(bf.readLine());
				sum += array1[i];
			}
			
			A = Integer.valueOf(bf.readLine());
			
//			System.out.println(N+" "+A+" "+" "+Arrays.toString(array1));
			
			if(sum < A) {
				pw.println("Impossible");
				continue;
			}
			Arrays.sort(array1);
			int puntero = 0, temp;
			
			while(A != 0) {
				if(puntero >= array2.length) break;
				temp = (int) A/N;
				if(array1[puntero] <= temp) {
					A -= array1[puntero];
					array2[puntero] = array1[puntero];
				}else {
					A -= temp;
					array2[puntero] = temp;
				}
				puntero++; N--;
//				System.out.println(Arrays.toString(array2)+" "+A);
			}
//			System.out.println(Arrays.toString(array2));
			Arrays.sort(array2);
			
			for(int i = 0; i < array2.length; ++i) {
				pw.println(array2[array2.length-i-1]);
			}
			

		}
		pw.close();		
		
	}
}
