/**
 * 
 */
package triangleCounting;

/**
 * @author Andres Martinez
 *
 */

import java.util.*;
import java.io.*;

/* 
 * Uva 11401 Triangle Counting
 */
public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int MAX = 500000;
    static long[] even = new long[MAX+1];
    static long[] odd = new long[MAX+1];
    
    public static void main(String[] args) throws IOException{
    
    	initArrays();
        while(true){
            int n = Integer.valueOf(bf.readLine()), sum1 = 0;
            if(n < 3) break;
            pw.println(n % 2 == 0? even[(n/2)-1]: odd[(n/2)-1]);
            
        }
        
        pw.close();
    }
    
    public static void initArrays() {
    	
    	for(long i = 1; i <= MAX; ++i) {
    		even[(int)i] = even[(int)i-1] + (i*(2*i - 1));
    		odd[(int)i] = odd[(int)i-1] + (i*(2*i + 1));
    	}
    	
    }
    
    
}

