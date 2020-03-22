/**
 * 
 */
package hourForRun;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException{
		
		int V, N, totalSigns;
		double percent;
		
		st = new StringTokenizer(bf.readLine());
		
		V = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		
		totalSigns = V*N;
		percent = totalSigns/10.0;
		
		pw.println((int)Math.ceil(percent)+" "+(int)Math.ceil(percent*2)+" "+(int)Math.ceil(percent*3)+" "+(int)Math.ceil(percent*4)+" "+(int)Math.ceil(percent*5)+" "+(int)Math.ceil(percent*6)+" "+(int)Math.ceil(percent*7)+" "+(int)Math.ceil(percent*8)+" "+(int)Math.ceil(percent*9));
		pw.close();
		
	}

}
