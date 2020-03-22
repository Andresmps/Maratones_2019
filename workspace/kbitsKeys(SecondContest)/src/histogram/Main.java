/**
 * 
 */
package histogram;
import java.io.*;
import java.util.*;

/**
 * Utility class to generate permutations from bitmasks 
 * @author arlese.rodriguezp
 * PermutationsDP
 */

public class Main {
	
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int N;
	static int[] values; 
	static int[][] count;
	static int[][] dp;

	public static void main(String[] args) throws IOException{
		
		int maxPer, numPer, temp, allMask;
		
		while(true) {
			N =  Integer.valueOf(bf.readLine().trim());
			if(N == 0) break;
			
			initMemo();
			
			//Create and read values
			st = new StringTokenizer(bf.readLine());
			values = new int[N];
			
			for(int j = 0; j < N; j++) 
				values[j] = Integer.valueOf(st.nextToken());
			
			
			maxPer = numPer = temp = 0;
			
			allMask = (1 << N) -1;

			for(int i = 0; i < N; i++) {
				temp = solve(i, allMask^(1 << i)) + values[i];				
				if(temp > maxPer) {
					maxPer = temp;numPer = count[i][allMask ^ (1 << i)];
				}else if(temp == maxPer)  
					numPer += count[i][allMask ^ (1 << i)]; 
				
			}
			pw.println((maxPer+N+N)+" "+numPer);
		}
		pw.close();
	}
	
	
	
	static int solve(int curr, int mask) {
//		System.out.println("curr:" + values[curr] + ", mask:"+Integer.toBinaryString(mask));
		int ans, tempA, tempC;
		
		if (mask == 0) {
			count[curr][mask] = 1;
			return values[curr];
		}
		if (dp[curr][mask] != -1) 
 			return dp[curr][mask];
		
		ans = tempC = 0;

		for (int i = 0; i < N; i++) {
			if ((mask & (1 << i)) != 0) {
				tempA = solve(i, mask ^ (1 << i)) + Math.abs(values[i] - values[curr]);
				if(tempA > ans) {
					ans = tempA; tempC = count[i][mask ^ (1 << i)];
				}else if(tempA == ans)  
					tempC += count[i][mask ^ (1 << i)];
			}
		}
		count[curr][mask] = tempC;
		return dp[curr][mask] = ans; //assing dp
	}

	public static void initMemo() {
		count = new int[N][1 << N]; dp = new int[N][1 << N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; (j < (1 << N)); j++) {
				dp[i][j] = -1;
			}
		}
	}
}

/*s

3
1 2 3
0

4
1 2 3 4
0


4
1 2 3 4
3
2 6 5
0
 
 
 */

