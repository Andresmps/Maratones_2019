/**
 * 
 */
package ecologicalPremium;

/**
 * @author Andres Martinez
 * Uva 10300	Ecological Premium
 */
import java.util.*;
import java.io.*;

public class EcologicalPremium {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		int n, f, a, b, c;
		long sum; 
		n = Integer.valueOf(bf.readLine().trim());
		
		for(int i = 0; i < n; ++i) {
			f = Integer.valueOf(bf.readLine().trim());
			sum = 0;
			for(int j = 0; j < f; ++j) {
				st = new StringTokenizer(bf.readLine().trim());
				a = Integer.valueOf(st.nextToken());
				b = Integer.valueOf(st.nextToken());
				c = Integer.valueOf(st.nextToken());
				
				sum += a*c;
			}
			
			pw.println(sum);
		}
		pw.close();
	}

}
