package camp;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Camp {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static Point[] points ;
	
	public static void main(String[] args) throws IOException{
		
		int C = Integer.valueOf(bf.readLine().trim());
		
		for (int i = 0; i < C; i++) {
			int N = Integer.valueOf(bf.readLine().trim());
			points = new Point[N];
			
			for (int j = 0; j < N; j++) {
				in = new StringTokenizer(bf.readLine().trim());
				int x = Integer.valueOf(in.nextToken());
				int y = Integer.valueOf(in.nextToken());
//				System.out.println(x);
//				System.out.println(y);
				Point p1 = new Point(x, y);
				points[j] = p1;
			}
			
			Arrays.sort(points,(x1, y1) -> y1.x - x1.x);
//			System.out.println(Arrays.toString(points));
			
			Point temp = new Point();
			double distance = 0;
			for (int j = 1; j < points.length; j++) {
				 if(points[j-1].getY() < points[j].getY()){
					 temp = points[j];
					 distance += distanc(points[j-1].getX(), points[j].getX(), points[j-1].getY(), points[j].getY());
				 }
			}
			System.out.println(distance);
		}

	}
	
	public static double distanc(double x1, double x2, double y1, double y2){
		return Math.sqrt(((y2-y1)*(y2-y1)) + ((x2-x1)*(x2-x1)));
	}

}
/*
2
11
1100 1200
0 500
1400 100
600 600
2800 0
400 1100
1700 600
1500 800
2100 300
1800 700
2400 500
2
0 1000
1000 0
*/