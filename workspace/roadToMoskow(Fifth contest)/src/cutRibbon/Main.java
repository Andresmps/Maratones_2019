/**
 * 
 */
package cutRibbon;

import java.io.*;
import java.util.*;

/**
 *
 * @author Andrés Martínez
 */
public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer sc;
    static int numbers[] = new int[3];
    static int counts[][] = new int[4100][3];
    
    public static void main(String[] args) throws IOException{
        
        int n;
        
        sc = new StringTokenizer(bf.readLine());
        
        n = Integer.valueOf(sc.nextToken());
        numbers[0] = Integer.valueOf(sc.nextToken());
        numbers[1] = Integer.valueOf(sc.nextToken());
        numbers[2] = Integer.valueOf(sc.nextToken());
        
        int max = 0;
        init();
        Arrays.sort(numbers);
        for(int i = 0; i < 3; ++i){
            max = Math.max(recursiveCall(n-numbers[i], i), max);
//            System.out.println(i+" "+n+" "+max+"\n");
        }
        System.out.println(max);
    }
    
    public static int recursiveCall(int value, int j){
       
//        System.out.println(j+" "+value);
  
        
        if (value == 0) {
            return 1;
        }
        
         if (value < 0) {
            return 0;
         }
       if(counts[value][j] != -1){
            return counts[value][j];
        }
        
         int count  = 0;
        for(int i = j; i < 3; ++i){
            count = Math.max(recursiveCall(value-numbers[i], i), count);
//            System.out.println("j: "+j+" i: "+i+" count: "+count);
        }
        counts[value][j] = count;
        
        return  count == 0 ? 0 : count+1;
    }
    public static void init(){
        for (int i = 0; i < 4000; i++) {
            for (int j = 0; j < 3; j++) {
                counts[i][j] = -1;
            }
        }
    }
}