/**
 * 
 */
package santasToys;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class SantasToys {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	
	public static void main(String[] args) throws IOException{
		
		int N, F, M;
		
		N = Integer.valueOf(bf.readLine());
		F = M = 0;
		
		for(int i = 0; i < N; ++i) {
			if(bf.readLine().split(" ")[1].equals("F"))F++;
			else M++;
		}
		
		pw.println(M+" carrinhos\n"+F+" bonecas");
		pw.close();
	}
}


