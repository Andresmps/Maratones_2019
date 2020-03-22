/**
 * 
 */
package attractiveSubsecuence;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class AttractiveSubsecuence {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	static ArrayList<Integer> prefix = new ArrayList<>();
	static int[] mark = new int[100100000]; 
	static Random rand = new Random();

	public static void main(String[] args) throws IOException{
		
		int T, N, Q, temp, a, b, w;
		
		T = Integer.valueOf(bf.readLine().trim());
		
//		T = rand.nextInt(20);
//		System.out.println(T);
		
		for (int i = 0; i < T; i++) {
			in = new StringTokenizer(bf.readLine().trim());
			N = Integer.valueOf(in.nextToken());
			Q = Integer.valueOf(in.nextToken());
			
//			N = rand.nextInt(100000);
//			Q = rand.nextInt(1000);
//			System.out.println(N + " "+Q);
 			
			in = new StringTokenizer(bf.readLine().trim());
			
			temp = 0;
			for (int j = 0; j < N; j++) {
				temp += Integer.valueOf(in.nextToken());
				
//				w = rand.nextInt(1000);
//				temp += w;
//				System.out.print(w+" ");
				prefix.add(temp); 
				
			}
//			sc.println();
			//sc.println(prefix);
			
			for (int j = 0; j < N; j++) {
				for (int k = j; k < N; k++) {
					a = prefix.get(k);
					if(j != 0) b = prefix.get(j-1);
					else b = 0;
					
//					System.out.println("j: "+j+" k: "+k+" sum:"+(a-b)); 
					mark[a-b]++;
				}
			}
			
			in = new StringTokenizer(bf.readLine().trim());
			
			for (int j = 0; j < Q; j++) {
				if(j != Q-1) {
					sc.print(mark[Integer.valueOf(in.nextToken())]+" ");
					
//					w = rand.nextInt(10000000);
//					System.out.print(mark[w]+" ");
				}
				else {
					sc.println(mark[Integer.valueOf(in.nextToken())]);
					
//					w = rand.nextInt(10000000);
//					System.out.print(mark[w]); 
				}
			}
//			System.out.println();
			prefix.clear();
		}
		sc.close();

	}

}


/*
 
2
6 2
0 0 25 0 0 25
25 50
7 3
1 6 5 2 3 4 7
7 5 11

*/

