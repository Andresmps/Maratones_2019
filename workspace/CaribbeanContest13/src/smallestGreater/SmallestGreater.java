/**
 * 
 */
package smallestGreater;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class SmallestGreater {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer in;
    static BigInteger[] pows = new BigInteger[101];
    static BigInteger[] prefix = new BigInteger[101];

	public static void main(String[] args) throws IOException{

		String s, ones;
    	BigInteger M, two, temp, temp2, temp3;
    	int k;
    	
    	two = new BigInteger("2");
    	
    	prefix[0] = pows[0] = temp = BigInteger.ONE;
    	
    	for (int i = 1; i < 101; i++) {
			pows[i] = temp.shiftLeft(i);
			prefix[i] = pows[i].add(prefix[i-1]);
//			System.out.println("i: "+i+" pows: "+pows[i]);
//			System.out.println("i: "+i+" prefix: "+prefix[i]);
//			String a = bf.readLine();
		}
    
    	
    	while((s = bf.readLine()) != null) {
    		
    		in = new StringTokenizer(s.trim());
    		M = new BigInteger(in.nextToken());  
    		k = Integer.valueOf(in.nextToken());
    		
//    		if(k == -1) break;
    		temp = pows[k];
    		
//    		sc.println("M: "+M+" k: "+k);
    		
    		if(M.compareTo(temp) == 0) {
    			sc.println(pows[k+1].subtract(two));
    		}else if(M.compareTo(temp) == -1) {
    		
    			sc.println(temp.subtract(BigInteger.ONE));  
    		}else { 
    			
    			String binary;
    			
    			while(temp.subtract(BigInteger.ONE).compareTo(M) == -1) {			
    				temp = temp.subtract(BigInteger.ONE).shiftLeft(1);
    			}
    			
    			temp2 = M;
    			temp3 = prefix[k-1];
    			binary = temp2.toString(2);

    			for (int i = binary.length()-1-k, j = k; i >= 0 ; i--, j++) {
	    			if(binary.charAt(i) == '1') {
	    				temp3 = temp3.add(pows[j]); 
	    			}
				}
    			
//    			sc.println("temp2: "+temp2.toString(2));
//    			sc.println("temp3: "+temp3);
    			sc.println(temp.min(temp3)); 
    		}
    		
    	}
    	sc.close();

	}
	
	

}


/*
 * 
2 3
10 3
1 2
5 2
1023 11
7 2
0 -1
*/
