/**
 * 
 */
package improveSpam;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	static int[][] adjList;
	static boolean[] marks;
	static int count2 = 0;
	static int[] memoization = new int[2001];
	
	public static void main(String[] args) throws IOException{
		
		int N, L, temp, count = 0;
		
		sc = new StringTokenizer(bf.readLine());
		N = Integer.valueOf(sc.nextToken());
		L = Integer.valueOf(sc.nextToken());
		
		
		adjList =  new int[L][];
		marks = new boolean[N+1];
		
		for(int i = 0; i < L; i++) {
			sc = new StringTokenizer(bf.readLine());
			temp = Integer.valueOf(sc.nextToken());
			adjList[i] = new int[temp];
			for(int j = 0; j < temp; j++) {
				adjList[i][j] = Integer.valueOf(sc.nextToken())-1;
			}
		}
		
		
		pw.println(recursiveDFS(0, L, 0));
		pw.println(count2);
		pw.close();
	}
	
	
	public static int recursiveDFS(int root, int min, int count) {
		
		int leaf;
	
		
		for(int i = 0; i < adjList[root].length; ++i) {
			leaf = adjList[root][i]; 
			if(leaf < min) {
				if(memoization[leaf] != 0) {
					count += memoization[leaf];
//					System.out.println("HOla");
				}else {
					count = recursiveDFS(leaf, min, count);
				}
			}else {
				count++;
				if(!marks[leaf]) 
					count2++;
					marks[leaf] = true;
					
			}
		}
//		System.out.println("count: "+count);
		return memoization[root] = count;
	}
	
	public static int iterativeDFS(int root, int min) {
		
		Stack<Integer> stack = new Stack<>();
		int leaf, count = 0;
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			root = stack.pop();
			
			for(int i = 0; i < adjList[root].length; ++i) {
				leaf = adjList[root][i];
//				System.out.println("leaf: "+(leaf+1));
				if(memoization[leaf] != 0 ) {
					System.out.println("HOla");
					count+= memoization[leaf];
					continue;
				}
				if(leaf < min) {
					stack.push(leaf);
				}else {
					count++;
					if(!marks[leaf]) 
						count2++;
						marks[leaf] = true;
						
				}
				
			}
			memoization[root] = count;
	//			System.out.println("root: "+(root+1)+" ; pila: "+stack+" ; marks: "+Arrays.toString(marks));
		
		}
		return count;
	}
	
}
