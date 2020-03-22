
package pantsOnfire;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class pants {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static Hashtable<String, ArrayList<String>> facts = new Hashtable<>();
	
	public static void main(String[] args) throws IOException{
		
		String x, y, read;
		int n, m;
		
		st = new StringTokenizer(bf.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		for(int i = 0; i < n; ++i) {
			read = bf.readLine();
			x = read.split(" are worse than ")[0];
			y = read.split(" are worse than ")[1];
			facts.put(x, new ArrayList<String>());
			facts.get(x).add(y);
			
			if(facts.containsKey(y)) {
				for(String temp : facts.get(y)) 
					facts.get(x).add(temp);
			}
		}
//		System.out.println();
//		facts.forEach((t, s) -> System.out.print(t+" "+s+", "));
//		System.out.println();
		
		boolean flag;
		for(int i = 0; i < m; ++i) {
			read = bf.readLine();
			x = read.split(" are worse than ")[0];
			y = read.split(" are worse than ")[1];
			flag= false;
			
			if(facts.containsKey(x)) {
				for(String temp : facts.get(x)) {
					if(temp.equals(y)) {
						pw.println("Fact");
						flag = true;
						break;
					}
				}
				
			}
			if(facts.containsKey(y) && !flag) {
				for(String temp : facts.get(y)) {
					if(temp.equals(x)) {
						pw.println("Alternative Fact");
						flag = true;
						break;
					}
				}
			}
			
			if(!flag)
				pw.println("Pants on Fire");
			
		}
		pw.close();
	}

}
/*

4 5
Mexicans are worse than Americans
Russians are worse than Mexicans
NorthKoreans are worse than Germans
Canadians are worse than Americans
Russians are worse than Americans
Germans are worse than NorthKoreans
NorthKoreans are worse than Mexicans
NorthKoreans are worse than French
Mexicans are worse than Canadians

*/