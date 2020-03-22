/**
 * 
 */
package practice;

import java.util.Arrays;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(binaryExponentiation(250, 25, 2));
		System.out.println(exponenciacionModular(250, 25,2));
System.out.println(Arrays.toString(euclidesExtendido(450, 350)));
	}

	public static long exponenciacionModular(long a, long k, long n){
		long b = 1;
		if(k==0)
			return b;
		long A = a;
		
		if(k %2==1)
			b = a;
		
		while((k = k/2)!=0) {
			A = (A*A) %n;
			if(k %2==1)
				b=(A*b) %n;
		}
		return b;
	}
	
	public static long binaryExponentiation (long a, long b, long c) {
		  if (b == 0) return 1;
			if (b % 2 == 0){
			  long temp = binaryExponentiation(a, b/2, c);
			  return (temp * temp) % c;
			} else {
			  long temp = binaryExponentiation(a, b-1, c);
			  return (temp * a) % c;
		  }
	}
	
	public static long[] euclidesExtendido(long a, long b)	
	{
	     long[] resp = new long[3];
	     long x=0,y=0,d=0;
			
	     if(b==0) {
		resp[0] = a;	resp[1] = 1;	resp[2] = 0;
	     }else {
	    	long x2 = 1, x1 = 0, y2 = 0, y1 = 1;
	    	long q = 0, r = 0;
	    			
	    	while(b > 0) {
	        	q = (a/b);
	        	r = a - q * b;
	        	x = x2 - q * x1;
	        	y = y2 - q * y1;
	        	a = b;
	        	b = r;
	        	x2 = x1;
	        	x1 = x;
	        	y2 = y1;
	        	y1 = y;
	    	}
	    	resp[0] = a; resp[1] = x2; resp[2] = y2;
	    }
	 
	    return resp;		
	} 
	
}
