package frequencies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class Frequencies {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	static Random rand = new Random();
	
	public static void main(String[] args) throws IOException{
		
		
		in = new StringTokenizer(bf.readLine().trim());
		int n = Integer.valueOf(in.nextToken());
		int k = Integer.valueOf(in.nextToken());
		
//		int n = rand.nextInt(1000000);
//		int k = rand.nextInt(100);
		int s, temp;

//		System.out.println(n);
//		System.out.println(k);
		Vector<Integer> A = new Vector<>();
		Vector<Integer> S = new Vector<>();
		boolean[] mark = new boolean[200000100];
		
		
		
		in = new StringTokenizer(bf.readLine().trim());
		
		for (int i = 0; i < n; i++) {
			temp = Integer.valueOf(in.nextToken());
//			temp = rand.nextInt(100000000); 
			mark[temp] = true;
			A.add(temp);
			
		}
		
		in = new StringTokenizer(bf.readLine().trim());
		
		for (int i = 0; i < k; i++) {
			S.add(Integer.valueOf(in.nextToken()));
//			S.add(Integer.valueOf(rand.nextInt(200000000)));
		}
		
//		System.out.println(A);
//		System.out.println(S);
		
		Vector<Vector<Integer>> result = new Vector<>();
		//int[][] result = new int[101][2];
//		System.out.println(result);
		
		int count;
		
		for (int i = 0; i < k; i++) {
			s = S.get(i);
			count = 0;
			for (int j = 0; j < n; j++) {
				mark[A.get(j)] = false;
				
				if(s - A.get(j) >= 0 && mark[s - A.get(j)]) {
					count++;
					mark[s - A.get(j)] = false;
				}else {
					mark[A.get(j)] = true;
				}
			}
			
			if(count != 0) {
				Vector<Integer> tp = new Vector<>();
				tp.add(s);
				tp.add(count);
				result.add(tp);
			}
		} 
		
		//printMatrix(result);
		//printMatrix(result2);
		MergeSort(result, 0, result.size()-1);
		
		printMatrix(result);
		sc.close();
	}
	
	public static void printMatrix(Vector<Vector<Integer>> A) {
		for (int i = 0; i < A.size(); i++) {
			sc.println(A.get(i).get(0)+ " "+ A.get(i).get(1));
		}
	}

	/*
6 3
6 5 1 4 2 3
7 8 6
	 */
	public static void MergeSort(Vector<Vector<Integer>> A, int p, int r) {
		
		if(p < r) {
		
			int q = (p+r) / 2;
			  
			MergeSort(A, p, q);
			MergeSort(A, q+1, r);
			
			Merge(A, p, q, r);

		}
	}
	
	public static void Merge(Vector<Vector<Integer>> A, int p, int q, int r) {
		
		int n1 = q - p + 1;
		int n2 = r - q;
				
		int[][] L = new int[n1][2];
		int[][] R = new int[n2][2];
		
		for (int i = 0; i < L.length; i++) {
			for (int j = 0; j < 2; j++) {
				L[i][j] = A.get(p+1).get(j);
			}
		}
		
		for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < 2; j++) {
				R[i][j] = A.get(i+q+1).get(j);
			}
		}
		
		
		
		int i = 0, j = 0, k;
		
		for (k = p; k < r && i < n1 && j < n2; k++) {
		
			if(L[i][1] > R[j][1]) {
				Vector<Integer> tp = new Vector<>();
				tp.add(L[i][0]);
				tp.add(L[i][1]);
				A.set(k, tp);
				i++;
			}else if(L[i][1] == R[j][1]){
				
				if(L[i][0] <= R[j][0]) {
					Vector<Integer> tp = new Vector<>();
					tp.add(L[i][0]);
					tp.add(L[i][1]);
					A.set(k, tp);
					i++;
				}else {
					Vector<Integer> tp = new Vector<>();
					tp.add(R[j][0]);
					tp.add(R[j][1]);
					A.set(k, tp);
					
					j++;
				}
			}else {
				Vector<Integer> tp = new Vector<>();
				tp.add(R[j][0]);
				tp.add(R[j][1]);
				A.set(k, tp);
				j++;
			}
		}
		
		while (i < n1) 
        { 
			Vector<Integer> tp = new Vector<>();
			tp.add(L[i][0]);
			tp.add(L[i][1]);
			A.set(k, tp);
            i++; 
            k++; 
        
        } 

        while (j < n2) 
        { 
        	Vector<Integer> tp = new Vector<>();
			tp.add(R[j][0]);
			tp.add(R[j][1]);
			A.set(k, tp); 
            j++; 
            k++; 
        
        } 

		
	}
}
/*
6 3
6 5 1 4 2 3
7 8 6
7 3
6 2
8 2
//*/