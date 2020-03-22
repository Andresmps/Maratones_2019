package SubSum;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 *
 * @author Andres Martinez
 */
public class subSums {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer in;
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Long> numbers = new ArrayList<>();
    static ArrayList<Long> prefix = new ArrayList<>();

    public static void main(String[] args) {
    	
        long N, S, sum, temp = 0;
        int ini, end;
        
        while (scan.hasNext()) {
            in = new StringTokenizer(scan.nextLine());

            N = Long.valueOf(in.nextToken());
            if(N == -1) break;
            S = Long.valueOf(in.nextToken());
            temp = 0;
            sum = 0;

            boolean flag = false;

            in = new StringTokenizer(scan.nextLine());

            for (int i = 0; i < N; i++) {
            	numbers.add(Long.valueOf(in.nextToken()));
            	temp += numbers.get(numbers.size()-1); 
                prefix.add(temp);
            }
//            8 16
//            1 3 4 8 6 1 4 2
            
            long a, b;
            ini = 0;
            end = 0;
            
            for (int i = 0; i < N; i++) {
            	
            	sum += numbers.get(i);
            	end = i;
            	
            	if(sum == S) {
            		flag = true;
            		break;
            	}else if(sum > S) {
            		while(sum > S && sum != 0) {
            			sum -= numbers.get(ini);
            			ini++;
            		}
            		if(sum == S) {
                		flag = true;
                		break;
            		}
            	}
            	
			}
            
            if (flag) {
				sc.println((ini+1)+" "+(end+1));
			}else {
				sc.println("-1");
			}
            
            numbers.clear();
            prefix.clear();
        }
        sc.close();
    }

}


