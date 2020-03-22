/**
 * 
 */
package walkingAroundWisely;

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class WalkingAroundWisely {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer in;
    
	public static void main(String[] args) throws IOException{

		Point begin, end;
		int C, N, W;
		boolean [][][][] marks;
		long[][] city;
		
		C = Integer.valueOf(bf.readLine());

		for(int i = 0; i < C; i++) {
			
			N = Integer.valueOf(bf.readLine());
			marks = new boolean[N][N][N][N];
			city = new long[N][N];
			
			in = new StringTokenizer(bf.readLine());
			begin = new Point(Integer.valueOf(in.nextToken())-1,Integer.valueOf(in.nextToken())-1);
			
			in = new StringTokenizer(bf.readLine());
			end = new Point(Integer.valueOf(in.nextToken())-1,Integer.valueOf(in.nextToken())-1);
			
			W = Integer.valueOf(bf.readLine());
			initMarks(W, marks);
 
			for (int j = begin.x; j <= end.x; j++) {
				for (int k = begin.y; k <= end.y; k++) {
					if(j == begin.x && k == begin.y) city[j][k] = 1;
					else {
						
						if(j - 1 >= 0 && !marks[j][k][j-1][k]) {
							city[j][k] += city[j-1][k];
						}
						if(k - 1 >= 0 && !marks[j][k][j][k-1]) {
							city[j][k] += city[j][k-1];
						}
					}	
				}
				
			}
			sc.println(city[end.x][end.y]); 
		}
		sc.close();
		
	}
	
	public static void initMarks(int W, boolean[][][][] marks) throws IOException{
		
		String direction;
		Point temp;
		
		for(int j = 0; j < W; j++) {
			in = new StringTokenizer(bf.readLine());
			temp = new Point(Integer.valueOf(in.nextToken())-1,Integer.valueOf(in.nextToken())-1);
			direction = in.nextToken();
			
			switch(direction) {
				case "N":
					marks[temp.x][temp.y][temp.x][temp.y+1] = marks[temp.x][temp.y+1][temp.x][temp.y] = true;
					break;
				case "S":
					marks[temp.x][temp.y][temp.x][temp.y-1] = marks[temp.x][temp.y-1][temp.x][temp.y] = true;
					break;
				case "W":
					marks[temp.x][temp.y][temp.x-1][temp.y] = marks[temp.x-1][temp.y][temp.x][temp.y] = true;
					break;
				case "E":
					marks[temp.x][temp.y][temp.x+1][temp.y] = marks[temp.x+1][temp.y][temp.x][temp.y] = true;
					break;
			}
		}
	}

}
/* 

2
3
1 1
3 3
2
2 3 S
2 2 W
3
1 1
3 3
0

 */

