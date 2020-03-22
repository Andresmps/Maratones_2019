/**
 * 
 */
package maratonaPopCorn;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException{

		double N, C, T;
		
		st = new StringTokenizer(bf.readLine());
		
		N = Double.valueOf(st.nextToken());
		C = Double.valueOf(st.nextToken());
		T = Double.valueOf(st.nextToken());
		
		Vector<Stack<Integer>> bags = new Vector<>();
		
		for(int i = 0; i < C; ++i) {
			bags.add(new Stack<Integer>());
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < C; ++i) {
			for(int j = 0; j < Math.ceil(N/C); ++j) {
				if(!st.hasMoreTokens()) break;
				bags.get(i).push(Integer.valueOf(st.nextToken()));
			}
			
		}
		
		
		int t = (int)N, count = 0;
		while(t > 0) {
			count++;
			for(int i = 0; i < C; ++i) {
				
				if(!bags.get(i).isEmpty()) {
					
					if(bags.get(i).peek()-(int)T <= 0) {
						bags.get(i).pop(); t--;
					}else 
						bags.get(i).push(bags.get(i).pop()-(int)T);
				}
			}
		}
		pw.println(count);
		pw.close();

	}

}
