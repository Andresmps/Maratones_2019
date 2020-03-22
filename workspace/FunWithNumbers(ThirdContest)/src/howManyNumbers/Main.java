/**
 * 
 */
package howManyNumbers;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int MAX = 2001;
	static BigInteger[] factorial = new BigInteger[MAX+1];
	
	/**
	 * Uva 10303	How Many Trees?
	 */
	public static void main(String[] args) throws IOException{
		getFactorial();
		String s;
		while((s = bf.readLine()) != null) {
			int i = Integer.valueOf(s); 
			System.out.println(factorial[2*i].divide(factorial[i].multiply(factorial[i+1]))); 
		}
		
	}
	
	public static void getFactorial() {
		factorial[1] = factorial[0] = BigInteger.ONE;
		
		for(int i = 2; i <= MAX; i++) {
			factorial[i] = factorial[i-1].multiply(new BigInteger(i+""));
		}
		
	}

}
/*

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
40
50
60
70
80
90
100
110
120
130
140
150
160
170
180
190
200
210
220
230
240
250
260
270
280
290
300
350
400
450
500
550
600
650
700
750
800
850
900
950
1000





*/