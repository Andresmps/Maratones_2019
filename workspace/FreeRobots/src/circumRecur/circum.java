package circumRecur;

import java.util.*;
import java.lang.*;
import java.io.*;

public class circum {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{
		
		int T = Integer.valueOf(bf.readLine());
		double R, K, L, temp, areaS, areaC;
		
		for (int i = 0; i < T; i++) {
			in = new StringTokenizer(bf.readLine().trim());
			R = Integer.valueOf(in.nextToken());
			K = Integer.valueOf(in.nextToken());
			
			if(K % 2 == 0) temp = Math.pow(Math.sqrt(2), (K-2)/2); 
			else temp = Math.pow(Math.sqrt(2), (K-1)/2); 
			
			L = 2 * R * temp;
			R = R * temp;
			
			areaS = L*L;
			areaC = areaS/4;
			 
			if(K % 2 == 0) sc.println(Math.round(areaS)); 
			else sc.println(Math.round(areaC) + "PI");
			
		}	
		sc.close();

	}
	
	

}
