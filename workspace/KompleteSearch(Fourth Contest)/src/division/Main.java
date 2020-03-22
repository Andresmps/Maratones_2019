/**
 * 
 */
package division;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 * Uva 725 Division
 */

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        
    	int n = 0, nTemp, y, l;
    	
    	l = Integer.valueOf(bf.readLine());
            
        while (l != 0) {
            
            boolean flag = false;
            n = 0;
            for (int a = 0; a <= 9; ++a) {
                n |= (1 << a);
                for (int b = 0; b <= 9; ++b) {
                    if (a == b) continue;
                    n |= (1 << b);
                    for (int c = 0; c <= 9; ++c) {
                        if (c == b || c == a) continue;
                        n |= (1 << c);
                        for (int d = 0; d <= 9; ++d) {
                            if (d == b || d == a || d == c) continue;
                            n |= (1 << d);
                            for (int e = 0; e <= 9; ++e) {
                                if (e == b || e == a || e == c || e == d) continue;
                                
                                nTemp = n;
                                y = Integer.valueOf(a + "" + b + "" + c + "" + d + "" + e);
                                
                                String x = (y * l) + "";

                                if (x.length() != 5) continue;
                                
                                n |= (1 << e);
                                
                                for (int q = 0; q < x.length(); q++) 
                                    n |= (1 << Integer.valueOf(x.charAt(q) + ""));
                                
                                if (Integer.bitCount(n) == 10) {
                                    pw.println(x + " / " + (a + "" + b + "" + c + "" + d + "" + e) + " = " + l);
                                    flag = true;
                                }

                                n = nTemp;
                                n &= ~(1 << e);
                            }
                            n &= ~(1 << d);
                        }
                        n &= ~(1 << c);
                    }
                    n &= ~(1 << b);
                }
                n &= ~(1 << a);
            }
            if (!flag) {
                pw.println("There are no solutions for " + l + ".");
            }
            
            l = Integer.valueOf(bf.readLine());
            if(l != 0) pw.println("");
        }
        pw.close();
        
    }
}