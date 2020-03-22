
package caseOfZerosAndOnes;

import java.io.*;
import java.util.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        Stack<Integer> pila = new Stack<>();
        
        int n = Integer.valueOf(bf.readLine()), temp;
        String numbers = bf.readLine();
        for(int i = 0; i < n; ++i){
        	
            temp = Integer.valueOf(numbers.charAt(i)+"");
            
            if(pila.isEmpty()){
                pila.push(temp);
            }else{
//                System.out.println(temp+" "+pila.peek()+" "+i);
                
                if(pila.peek() != temp){
                   
                    pila.pop();
                }else{
                    pila.push(temp);
                }
                
            }
//            System.out.println(pila);
        }
        pw.println(pila.size());
        pw.close();
    }
    
}