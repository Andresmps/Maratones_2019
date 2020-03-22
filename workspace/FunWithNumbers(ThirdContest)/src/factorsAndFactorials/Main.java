/**
 * 
 */
package factorsAndFactorials;

import java.math.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Andrés Martínez
 */

public class Main {

        
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static ArrayList<Integer> primes = new ArrayList<>();
	static int MAX = 1000000;
    static boolean[] marks = new boolean[MAX+1];
    
    public static void main(String[] args) throws IOException{
 
    	calculatePrimes();
    	String message;
        int number;
        
//        System.out.println(factorizacion(factorial(99)));
        
        while(true) {
            number = Integer.valueOf(bf.readLine());
            if (number == 0) break;
            
            Vector<Integer> factors = factorizacion(factorial(number));
            
            if(number < 10) message = "  "+number+"! =";
            else if(number < 100) message = " " + number+"! =";
            else message = number+"! =";
            
            for(int i = 0; i < factors.size(); ++i) {
            	if(i == 15) message +="\n      ";
            	int temp = factors.get(i);
            	if(temp < 10) message += "  "+temp;
            	else message += " "+temp;
            }
            pw.println(message);
        }
        pw.close();
    }



    public static Vector<Integer> factorizacion(BigInteger numero) {

    	Vector<Integer> factors = new Vector<>();
    	int count;
        for(int i = 0; numero.compareTo(new BigInteger((i*i) +"")) > 0; ++i) {
        	count = 0;
        	while(numero.remainder(new BigInteger(primes.get(i)+"")).compareTo(BigInteger.ZERO) == 0) {
        		count++;
        		numero  = numero.divide(new BigInteger(primes.get(i)+""));
        	}
        	factors.add(count);
        }
    	if(numero.compareTo(BigInteger.ONE) > 0)  
    		factors.add(1);
    	
        return factors;
    }

    public static BigInteger factorial(int numero) {

        BigInteger factorial = BigInteger.ONE; 

        for (int i = 2; i <= numero; i++) {
            factorial = factorial.multiply(new BigInteger(i + ""));
        }

        return factorial;
    }
    
    public static void calculatePrimes() {

        for (int i = 2; i <= MAX; i++) {
        	if(marks[i]) continue;
        	
        	primes.add(i);
            for (int j = 2*i; j <= MAX; j += i) 
            	marks[j] = true;
        }
    }
}
