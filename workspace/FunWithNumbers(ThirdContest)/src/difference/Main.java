/**
 * 
 */
package difference;

import java.io.*;
import java.util.*;


/**
 *
 * @author Andres Martinez
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int MAX = 2*100000001;
    static boolean[] marks = new boolean[MAX];
    static ArrayList<Integer> sucesion = new ArrayList<>();

    public static void main(String[] args) throws IOException{

    	int r, m;
    	st = new StringTokenizer(bf.readLine());
    	
    	r = Integer.valueOf(st.nextToken());
    	m = Integer.valueOf(st.nextToken());
    	
    	sucesion.add(r);
    	marks[r] = true;
    	
    	for(int i = 1, k = 0; i < MAX; ++i) {
    		if(marks[i]) continue;
    		
    		if(marks[m]) {
    			System.out.println(k+1); break;
    		}
    		
    		sucesion.add(sucesion.get(k)+i); 
    		marks[sucesion.get(k++)+i] = true;
    		
    		for(int j = 0; j < sucesion.size()-1; ++j) {
    			marks[sucesion.get(sucesion.size()-1) - sucesion.get(j)] = true;
    		}
    	}
    	
    	
    }
}


