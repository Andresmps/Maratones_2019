package aPlusb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Andrés Martínez
 */
public class barrels {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer sc;
    static int[][] pascal = new int[1010][1010];
    static int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException{
        
    	int A, B, K, C;
    	long ocurrence = 0;
    	
    	sc = new StringTokenizer(bf.readLine());
    	initPascal();
    	
    	A = Integer.valueOf(sc.nextToken());
    	B = Integer.valueOf(sc.nextToken());
    	K = Integer.valueOf(sc.nextToken());
    	C = Integer.valueOf(sc.nextToken());

    	if(C != A && C != B) {
    		pw.println(ocurrence);
    	}else {
    		for (int i = 0; i <= K; i++) {
    			ocurrence += (pascal[K][i]*i) % MOD;
    		}
    		ocurrence %= MOD;
    		pw.println(ocurrence);
    	}
    	
        pw.close();
    }
    
    public static void initPascal() {
    	pascal[0][0] = 1;
    	pascal[1][0] = pascal[1][1] = 1;
    	
    	for (int i = 2; i < 1005; i++) {
        	for (int j = 0; j <= i; j++) {
        		if(j == 0 || j == i) pascal[i][j] = 1;
        		else pascal[i][j] = (pascal[i-1][j-1] + pascal[i-1][j]) % MOD; 
    		}
		}
    	
    }
}