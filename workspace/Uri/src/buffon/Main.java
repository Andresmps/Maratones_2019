/**
 * 
 */
package buffon;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
	public static void main(String[] args) throws IOException{

		int N, max, temp;
		boolean flag = true;
		
		N = Integer.valueOf(bf.readLine());

		max = Integer.valueOf(bf.readLine());
		
		for(int i = 1; i < N; ++i) {
			temp = Integer.valueOf(bf.readLine());
			if(max < temp) {
				flag = false;
				break;
			}
		}
		
		pw.println(flag? "S": "N");
		pw.close();
		
	}

}
