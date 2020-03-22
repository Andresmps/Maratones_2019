package playingDartsByDistance;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */

public class PlayingDartsByDistance {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	
	public static void main(String[] args) throws IOException{
		
		int N, J, M;
		
		N = Integer.valueOf(bf.readLine());
		
		
		for(int i = 0; i < N; ++i) {
			
			J = M = 0;
			
			for(int j = 0; j < 3; ++j) {
				sc = new StringTokenizer(bf.readLine());
				J += Integer.valueOf(sc.nextToken()) * Integer.valueOf(sc.nextToken());
			}
			
			for(int j = 0; j < 3; ++j) {
				sc = new StringTokenizer(bf.readLine());
				M += Integer.valueOf(sc.nextToken()) * Integer.valueOf(sc.nextToken());
			}
			
			pw.println(J < M ? "MARIA" : "JOAO");
		}
		
		pw.close();
	}
	
}
