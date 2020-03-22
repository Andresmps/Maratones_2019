/**
 * 
 */
package caseOfFakeNumbers;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/**
	 * caseOfFakeNumbers
	 */
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	
	public static void main(String[] args) throws IOException{
		
		int n, begin, temp;
		boolean flag =true;
		n = Integer.valueOf(bf.readLine());
		sc = new StringTokenizer(bf.readLine());
		
		begin = n - Integer.valueOf(sc.nextToken());
		
		for(int i = 1; i < n; ++i) {
			temp = Integer.valueOf(sc.nextToken());
			if((i & 1) == 0) // If it's even substract
				temp = (temp + begin) % n;
			else  // If it's odd add
				temp = (n + temp - begin) % n;
			
//			System.out.println(temp);
			if(temp != i) {
				flag = false;
				break;
			}
		}
		 
		pw.println(flag ? "Yes":"No");
		pw.close();

	}

}
