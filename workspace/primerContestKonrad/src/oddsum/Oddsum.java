/**
 * 
 */
package oddsum;

/**
 * @author Andres Martinez
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Andrés Martínez
 * Uva 10783	Odd Sum
 */
public class Oddsum {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException{
        
        int t, a, b, count;
        
        t = Integer.valueOf(bf.readLine());
        
        for(int i = 0; i < t; ++i){
            a = Integer.valueOf(bf.readLine());
            b = Integer.valueOf(bf.readLine());
            count= 0;
            if(a %2 == 0) a++;
            
            for(int j = a; j <= b; j += 2){
                count+=j;
            }
            System.out.println("Case "+(i+1)+": "+count);
        }
        
    }
    
}
