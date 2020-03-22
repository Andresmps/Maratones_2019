package brackets;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/**
	 * Case Of Zeros And Ones
	 */
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	static long MOD = 1000000007;
	
	public static void main(String[] args) throws IOException{
	
		
		Stack<String> operation = new Stack<>();
		
		int n = Integer.valueOf(bf.readLine());
		sc = new StringTokenizer("( "+bf.readLine()+" )");
		boolean flag = false;
		String value, temp;
		long result;
		
		while(sc.hasMoreTokens()) {
			value = sc.nextToken();
			if( value.equals("(") ) {
				operation.push(value);
				flag = !flag;
			}else if( value.equals(")") ) {
				temp = operation.pop();
				result = flag ? 0:1;
				while(!temp.equals("(")) {
					result = flag ? (result + Long.valueOf(temp)) % MOD : (result * Long.valueOf(temp)) % MOD;
					temp = operation.pop();
				}
				operation.push((result % MOD)+"");
				flag = !flag;
					
			} else {
				operation.push(value);
			}
		}
		pw.println(operation.pop());
		
		
		pw.close();
	}

}