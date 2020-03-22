package frequencies;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Frequencies {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;
	static ArrayList<Integer> S = new ArrayList<>();
	static boolean[] mark = new boolean[200000100];
	static Random rand = new Random();
	
	public static void main(String[] args) throws IOException{
		
		in = new StringTokenizer(bf.readLine().trim());
		int n = Integer.valueOf(in.nextToken());
		int k = Integer.valueOf(in.nextToken());
		
//		// rand.nextInt(1000000)
//		int n = 100;
//		int k = 7;
		
//		System.out.println("n: "+n);
//		System.out.println("k: "+k);
		
		int s, temp;
		
		in = new StringTokenizer(bf.readLine().trim());
		
		for (int i = 0; i < n; i++) {
			temp = Integer.valueOf(in.nextToken());
//			temp = rand.nextInt(100);
			mark[temp] = true;
//			A.add(temp);
			
		}
//		System.out.println("A: "+A);
		//
		in = new StringTokenizer(bf.readLine().trim());
		
		for (int i = 0; i < k; i++) {
			S.add(Integer.valueOf(in.nextToken()));
//			S.add(Integer.valueOf(rand.nextInt(200)));			
		}

//		System.out.println("S: "+S);
		
		//Collections.sort(S); 
		Vector<Vector<Integer>> result = new Vector<>();
		
		int count, limit;
		
		for (int i = 0; i < k; i++) {
			s = S.get(i);
			
			if(s % 2 == 0) limit = (s/2) - 1;
			else limit = (s/2);
			
			count = 0;
			for (int j = 0; j < limit; j++) {
				if(mark[--s]) {
					if(mark[S.get(i) - s]) {
//						System.out.println("("+s+", "+(S.get(i) - s)+")");
						count++;
					}
				}
			}
//			 System.out.println();
			if(count != 0) {
				Vector<Integer> tp = new Vector<>();
				tp.add(S.get(i)); 
				tp.add(count);
				result.add(tp);
			}
		} 
		
		MergeSort(result, 0, result.size()-1);

		printMatrix(result);
		sc.close();
	}
	
	public static void printMatrix(Vector<Vector<Integer>> A) {
		for (int i = 0; i < A.size(); i++) {
			sc.println(A.get(i).get(0)+ " "+ A.get(i).get(1));
		}
	}

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
				L[i][j] = A.get(p+i).get(j);
			}
		}
		
		for (int j = 0; j < R.length; j++) {
			for (int i = 0; i < 2; i++) {
				R[j][i] = A.get(j+q+1).get(i);
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