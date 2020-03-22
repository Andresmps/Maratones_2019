/**
 * 
 */
package euclidProblem;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/* 
	 * Uva 10104	Euclid Problem
	 */
	
    static BufferedReader bf = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int x, y, d;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        String s;
        while ((s = bf.readLine()) != null) {

            in = new StringTokenizer(s);
            int a = Integer.valueOf(in.nextToken());
            int b = Integer.valueOf(in.nextToken());
            extended(a, b);
            pw.println(x+" "+y+" "+d);
	    }
	    pw.close();
    }

    public static void extended(int a, int b) {

        if (b == 0) {
            x = 1;
            y = 0;
            d = a;

        } else {
            extended(b, a % b);
            int x1 = y;
            int y1 = x - ((a / b) * y);
            x = x1;
            y = y1;
        }
    }

}



