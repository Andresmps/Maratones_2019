/**
 * 
 */
package tobyStacks;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class TobyStacks {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	static ArrayList<Stack<Integer>> tobyStack = new ArrayList<>();
	static int[] sizes = new int[1000100];
	static int[] tops = new int[1000100];
	
	public static void main(String[] args) throws IOException{
		
		Stack<Integer> zero = new Stack<>();
		
		tobyStack.add(zero);
		
		int N = Integer.valueOf(bf.readLine().trim());
		
		int id, x, operation, index;
		
		for (int i = 0; i < N; i++) {
			
			in = new StringTokenizer(bf.readLine().trim());
			
			id = Integer.valueOf(in.nextToken());
			operation = Integer.valueOf(in.nextToken());
		
			index = tobyStack.size();
			
			Stack<Integer> copy = new Stack<>();
			
			copy.push(id);
			tobyStack.add(copy);
			
			sizes[index] = sizes[id]; 
			tops[index] = tops[id];
			
			//createCopy(id);
			
			switch(operation) {
				// Push
				case 0:
					x = Integer.valueOf(in.nextToken());
					
					tops[index] = index;
					sizes[index]++;
					
					tobyStack.get(index).push(x); 
  
					sc.println(sizes[index]);					
					break;
					
				// Pop
				case 1:
					
					if(tobyStack.get(tops[index]).isEmpty()) {
						sc.println("-1");
					}else {
						sizes[index]--;
						
						sc.println(tobyStack.get(tops[index]).peek());
						
						tobyStack.get(index).pop();
						tobyStack.get(index).push(tobyStack.get(tops[index]).firstElement());
						tops[index] = tops[tobyStack.get(index).firstElement()]; 
					}
					
					break;
			}

		}
		sc.close();
	}
	
}	
	
	
/*
 * 
10
0 1
1 1
1 0 25
0 0 0
4 1
0 1
1 0 11
5 1
5 1
6 0 58

	
8
0 1
1 0 4
2 0 6
3 0 7
3 1
2 1
6 0 4
7 1	
 */

