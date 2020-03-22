
package looRolls;


import java.util.Scanner;

public class loorolls {
	
	static Scanner sc = new Scanner(System.in);
	static int Z[];
	
	public static void main(String[] args) {
		String meow = sc.nextLine();
		getZarr("meow$"+meow);
		
	}
	
	private static void getZarr(String str) { 
		int max = 0;
		Z = new int[str.length()];  
        int n = str.length(); 
          
        
        int L = 0, R = 0; 
  
        for(int i = 1; i < n; ++i) { 
  
           
            if(i > R){ 
  
                L = R = i; 
  
               
  
                while(R < n && str.charAt(R - L) == str.charAt(R)) 
                    R++; 
                  
                Z[i] = R - L; 
                R--; 
  
            } 
            else{ 
  
                 
                int k = i - L; 
  
              
                if(Z[k] < R - i + 1) 
                    Z[i] = Z[k]; 
  
               
                else{ 
  
  
               
                    L = i; 
                    while(R < n && str.charAt(R - L) == str.charAt(R)) 
                        R++; 
                      
                    Z[i] = R - L; 
                    R--; 
                } 
            } 
        } 
        
        for (int i = 0; i < Z.length; i++) {
			if(Z[i]>max) {
				max = Z[i];
			}
		}
        
        if(max == 0) {
        	System.out.println("4");
        }else {
        	System.out.println(4-max);
        }
    } 
	
}





//import java.io.*;
//import java.util.*;
//
///**
// * @author Andres Martinez
// *
// */
//public class loorolls {
//
//	/**
//	 * @param args
//	 */
//	
//	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//	static StringTokenizer sc;
//	
//	public static void main(String[] args) throws IOException{
//		
//		
//		sc = new StringTokenizer(bf.readLine());
//		long a = Long.valueOf(sc.nextToken()); 
//		long b = Long.valueOf(sc.nextToken());
//		long k = 1;
//		
//		
//		while(a % b !=0) {
//			b = ( ((a / b) + 1) * b ) - a;
//			k++;
//		}
//		pw.println(k);
//		pw.close();
//	}
//
//}
