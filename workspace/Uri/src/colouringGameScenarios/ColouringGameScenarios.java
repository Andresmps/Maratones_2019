/**
 * 
 */
package colouringGameScenarios;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class ColouringGameScenarios {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static ArrayList<int[]> adjList = new ArrayList<>();
	static boolean[] scenarioMarks;
	static int count = 0, N, M;
	
	static String[] colors = {"\033[30m", "\033[31m", "\033[32m", "\033[33m", "\033[34m", "\033[35m", "\033[36m"};
	static int[][] processWithColors;
	
	public static void main(String[] args) throws IOException{
		
		System.out.println(colors[2]+"hola");
		
		st = new StringTokenizer(bf.readLine().trim());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		processWithColors = new int[N][M];
		scenarioMarks = new boolean[N*M];
		String[] lines = new String[N];
		
		for(int i = 0; i < N; ++i) lines[i] = bf.readLine().trim();
		
		createdAdjList(lines);
		
//		pw.println(Arrays.toString(scenarioMarks));
//		showNumericRepresentation();
//		pw.print("\n"+adjList);
		
		pw.println(numberClicksNeeded());
		pw.close();
		
	}
	
	public static void showProcces() {
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				pw.print(processWithColors[i][j] == -1 ? (colors[0]+ (char) 9608) : (processWithColors[i][j]+ (char) 9608));
			}
			pw.println();
		}
	}
	
	public static int numberClicksNeeded() {
		
		int clicks = 0, root;
		
		for(int i = 0; i < adjList.size(); ++i) {
			root = adjList.get(i)[0];
			
			if(!scenarioMarks[root]) {
				showProcces();
//				pw.print("\nroot: "+root);
//				recursiveDFS(root);
				iterativeDFS(root, ++clicks);
//				iterativeBFS(root);
			}
		}		
		return clicks;
	}
	
	public static void showNumericRepresentation() {
		pw.println();
		for(int i = 0, c = 0; i < N; ++i ) {
			for(int j = 0; j < M; j++, c++) {
				if(!scenarioMarks[c]) pw.print(c < 10 ? ("("+c+")  ") : ("("+c+") "));
				else pw.print(c < 10 ? "[ ]  " : "[  ] ");
			}
			pw.println();
		}
	}
	
	public static void createdAdjList(String[] lines) {
		
		for(int i = 0, c = 0; i < N; ++i ) {
			for(int j = 0; j < M; j++, c++) {
				int[] temp = new int[5];
				temp[0] = c;
				if(lines[i].charAt(j) == 'o') {
					scenarioMarks[c] = true; 
					processWithColors[i][j] = -1;
				}
				
				if(j != M-1 && lines[i].charAt(j+1) != 'o') temp[1] = c+1;
				if(i != N-1 && lines[i+1].charAt(j) != 'o') temp[2] = c+M;
				if(j != 0 && lines[i].charAt(j-1) != 'o') temp[3] = c-1;
				if(i != 0 && lines[i-1].charAt(j) != 'o') temp[4] = c-M;
				
				adjList.add(temp);
			}
		}
	}
	
	public static void recursiveDFS(int root) {
		
		int leaf;
		scenarioMarks[root] = true;
		
		for(int i = 1; i < adjList.get(root).length; ++i) {
			leaf = adjList.get(root)[i]; 
			if(!scenarioMarks[leaf]) recursiveDFS(leaf);
		}
	}
	
	public static void iterativeDFS(int root, int color) {
		
		Stack<Integer> stack = new Stack<>();
		int leaf;
		
		stack.push(root);
		scenarioMarks[root] = true;
		processWithColors[root/M][root % M] = color;
		
		while(!stack.isEmpty()) {
			root = stack.pop();
			
			for(int i = 1; i < adjList.get(root).length; ++i) {
				leaf = adjList.get(root)[i]; 
				if(!scenarioMarks[leaf]) {
					stack.push(leaf);
					scenarioMarks[leaf] = true;
					processWithColors[leaf/M][leaf % M] = color;
				}
			}
			
		}
	}
	
	public static void iterativeBFS(int root) {
		
		Queue<Integer> stack = new LinkedList<>();
		int leaf;
		
		stack.add(root);
		scenarioMarks[root] = true;
		
		while(!stack.isEmpty()) {
			root = stack.poll();
//			pw.println("root ["+(count++)+"]: "+root);
			for(int i = 1; i < adjList.get(root).length; ++i) {
				leaf = adjList.get(root)[i]; 
				if(!scenarioMarks[leaf]) {
					stack.add(leaf);
					scenarioMarks[leaf] = true;
				}
			}
			
		}
	}
	
}
/*

6 9
.ooo.ooo.
o...o...o
.o.....o.
..o...o..
...o.o...
....o....
   
 */
