/**
 * 
 */
package shirtColor;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class ShirtColor {


	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	static double LAMBDA = 700;
	static double C = Math.pow(10,8)*3;
	 
	public static void main(String[] args) throws IOException{
		
		double V = Double.valueOf(bf.readLine().trim());
		
		double result = V < 0 ? 0 : equation(V);
		
//		System.out.println(result);
		
		if (result < 400 || result >= 750) {
			pw.println("invisivel");
		} else if (result >= 400 && result < 425) {
			pw.println("violeta");
		} else if (result >= 425 && result < 445) {
			pw.println("anil");
		} else if (result >= 445 && result < 500) {
			pw.println("azul");
		} else if (result >= 500 && result < 575) {
			pw.println("verde");
		} else if (result >= 575 && result < 585) {
			pw.println("amarelo");
		} else if (result >= 585 && result < 620) {
			pw.println("laranja");
		} else if (result >= 620 && result < 750) {
			pw.println("vermelho");
		}
		
		pw.close();
	}
		
		
	public static double equation(double V) {	
		return (LAMBDA*( Math.sqrt( (C-V) / (C+V) ) - 1)) + LAMBDA;
	}
}
