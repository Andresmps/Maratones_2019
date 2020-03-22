package circumscribedRecursion;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CircumscribedRecursion {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{
		
		int T = Integer.valueOf(bf.readLine());
		double R, K, L, n, areaS, areaC;
		
		for (int i = 0; i < T; i++) {
			in = new StringTokenizer(bf.readLine().trim());
			R = Integer.valueOf(in.nextToken());
			K = Integer.valueOf(in.nextToken());
			
			if(K % 2 == 0) n = Math.pow(2, (K-2)/2); 
			else n = Math.pow(2, (K-1)/2); 
			
			L = 4 * R * R * n;
			R = R * R * n;
			 
			if(K % 2 == 0) sc.println(Math.round(L)); 
			else sc.println(Math.round(R) + "PI");
			
		}	
		sc.close();

	}
	
	

}
