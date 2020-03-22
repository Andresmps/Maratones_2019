/**
 * 
 */
package babyBites;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Andres Martinez
 *
 */
public class baby {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	/**
	 * Baby Bites
	 * 
	 */
	public static void main(String[] args) throws IOException{
		
		String temp;
		int n = Integer.valueOf(bf.readLine().trim());
		boolean flag = false;
		st = new StringTokenizer(bf.readLine());
		
		for(int i = 1; i <= n; ++i) {
			
			temp = st.nextToken();
			
			if(temp.equals("mumble")) continue;
			if(!temp.equals(String.valueOf(i))) {
				flag = true;
				break;
			}
			
		}
		
		pw.println(flag ? "something is fishy" :"makes sense");

		pw.close();
	}

}
