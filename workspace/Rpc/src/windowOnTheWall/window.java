/**
 * 
 */
package windowOnTheWall;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class window {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{

		int h, w, d;
		
		st = new StringTokenizer(bf.readLine());
		
		w = Integer.valueOf(st.nextToken());
		h = Integer.valueOf(st.nextToken());
		d = Integer.valueOf(st.nextToken());
		
		if(w < d+d || h < d+d) {
			pw.println(0);
		}else {
			w += -2*d;
			h += -2*d;
			pw.println(h*w);
		}
		pw.close();

	}

}
/*

40 25 5 
30 20 12
30 20 50
999 888 7

450 0 0 860890

*/