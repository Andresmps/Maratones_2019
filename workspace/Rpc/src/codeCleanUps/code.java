/**
 * 
 */
package codeCleanUps;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class code {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		int n, temp, count = 0, cleans = 0;;

		n = Integer.valueOf(bf.readLine());
		int[] times = new int[366];
		List<Integer> dirts = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i< n; ++i) {
			times[Integer.valueOf(st.nextToken())] = 1;
		}
		
		
		for(int i = 1; i <= 365; ++i) {
//			System.out.println(i+" "+count);
			if(count >= 20) {
				cleans++;
				count = 0;
				dirts.clear();
			}
			
			if(times[i] == 1) {
				dirts.add(1);
			}
			count+=dirts.size();
		}
		
		if(count != 0) cleans++;
		// 3
		// 310 330 350
		pw.println(cleans);
		pw.close();
	}

}
