/**
 * 
 */
package theTrip;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static DecimalFormat format = new DecimalFormat("00.00");

	public static void main(String[] args) throws IOException{
		
		int n = Integer.valueOf(bf.readLine());
		double average, costs;
		double[] spends;
		
		while(n != 0) {
			
			spends = new double[n];
			costs = average = 0;
			
			for(int i = 0; i < n; ++i) {
				spends[i] = Double.valueOf(bf.readLine());
				average += spends[i];
				System.out.println(average);
			}
			
			average /= n;
			System.out.println(average);
			average = Math.round(average * 100d)/100d;
			System.out.println(average);
			for(int i = 0; i < n; ++i) {
				if(spends[i] < average)
					costs += average - spends[i]; 
			}
			pw.println("$"+Math.round(costs * 100d)/100d);
			n = Integer.valueOf(bf.readLine());
		}
		pw.close();
	}

}
