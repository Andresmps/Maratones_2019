package inversion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Inversion {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer in;
	static long inv;
	static Random rand = new Random();
	
	public static void main(String[] args) throws IOException{
		
		while(true) {
			
			int n = Integer.valueOf(bf.readLine());
			//int n = rand.nextInt(100000);
			if(n == 0) break;
			inv = 0;
//			int inv2 = 0;
			int[] A = new int[n];
			
			for (int i = 0; i < A.length; i++) {
				A[i] = Integer.valueOf(bf.readLine());
				//A[i] = rand.nextInt(100000000); 
			}
			
//			for (int i = 0; i < A.length; i++) {
//				for (int j = i+1; j < A.length; j++) {
//					if(A[i] > A[j]) inv2++;
//				}
//			}
			
			//sc.println(Arrays.toString(A));
			
			MergeSort(A, 0, n-1);
			
			//sc.println(Arrays.toString(A));
			
			//System.out.println(inv+" "+inv2);
			System.out.println(inv);
			
		}	
		sc.close();
	}
	
	public static void MergeSort(int[] A, int p, int r) {
		
		if(p < r) {
		
			int q = (p+r) / 2;
			  
			MergeSort(A, p, q);
			MergeSort(A, q+1, r);
			
			Merge(A, p, q, r);

		}
	}
	
	public static void Merge(int[] A, int p, int q, int r) {
		
		int n1 = q - p + 1;
		int n2 = r - q;
				
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for (int i = 0; i < L.length; i++) {
			L[i] = A[p + i];
		}
		
		for (int j = 0; j < R.length; j++) {
			R[j] = A[j + q + 1];
		}
		
		
		int i = 0, j = 0, k;
		
		for (k = p; k < r && i < n1 && j < n2; k++) {
		
			if(L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			}else {
				A[k] = R[j];
				
				inv += n1-i;
				
				j++;
			}
		}
		
		while (i < n1) 
        { 
            A[k] = L[i]; 
            i++; 
            k++; 
        
        } 

        while (j < n2) 
        { 
            A[k] = R[j]; 
            j++; 
            k++; 
        
        } 

		
	}
	
}


/*
 * 
5
3
2
8
1
6

5
5
4
3
2
1

1
10

0
 */