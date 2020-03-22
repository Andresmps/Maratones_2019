/**
 * 
 */
package andOR;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

/**
 * @author Andres Martinez
 * Uva 12898 And Or
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{

		int T;
		BigInteger setAnd, setOr, count, temp; // A, B;
		long A, B;
		boolean flag1, flag2;

		T = Integer.valueOf(bf.readLine().trim());
		
		for(int i = 0; i < T; ++i) {
			st = new StringTokenizer(bf.readLine());
			A = Long.valueOf(st.nextToken());
			B = Long.valueOf(st.nextToken());
			
			setOr = setAnd = count = BigInteger.ZERO;
			flag1 = flag2 = false;
			
			if(A == B) {
				pw.println("Case "+(i+1)+": "+A+" "+A);
				continue;
			}
			
			if(Long.toBinaryString(A).length() == Long.toBinaryString(B).length()) { 

				for(int j = 0; j < Long.toBinaryString(A).length(); ++j) {	 
					temp = BigInteger.ONE.shiftLeft(j);
					if(BigInteger.valueOf(A).and(temp).compareTo(BigInteger.ZERO) == 0) { 
						if(!flag1) setOr = setOr.add(temp);
						if(!flag2) count = count.add(temp);
					}else {
						if(!flag2) setAnd = setAnd.subtract(temp);
					}
					if(setOr.compareTo(BigInteger.valueOf(B - A)) >= 0) flag1 = true;
					if(count.compareTo(BigInteger.valueOf(B - A)) >= 0) flag2 = true;
					if(flag1 && flag2) break;
				}
				
				setOr = setOr.add(BigInteger.valueOf(A));
				setAnd = setAnd.add(BigInteger.valueOf(A));
				
			}else {
				setOr = setOr.add( BigInteger.ONE.shiftLeft( Long.toBinaryString(B).length()));
				setOr = setOr.subtract(BigInteger.ONE); 
			} 
			
			
			pw.println("Case "+(i+1)+": "+setOr+" "+setAnd);
		}
		pw.close();
	}
}
