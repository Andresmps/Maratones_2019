/**
 * 
 */
package mountainRanges;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		
		int N, X, views[];
		
		sc = new StringTokenizer(bf.readLine());
		N = Integer.valueOf(sc.nextToken());
		X = Integer.valueOf(sc.nextToken());
		
		views = new int[N];
		sc = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i < N; ++i) 
			views[i] = Integer.valueOf(sc.nextToken());
		
		int count = 0, max = 0;
		for(int i = 1; i < N; ++i) {
			
			if(views[i] - views[i-1] <= X) {
//				System.out.println(i+" 1");
				count++;
			}else {
//				System.out.println(i+" 0");
				if(count != 0) {
					max = Math.max(max, count);
					count = 0;
				}
			}
//			System.out.println("count: "+count);
		}
		max = Math.max(max, count);
		pw.println(max+1);
		pw.close();
	}

}
