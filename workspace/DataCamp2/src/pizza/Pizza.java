package pizza;

import java.awt.Point;
import java.awt.Shape;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Pizza {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static Vector<Point> points = new Vector<>();
	static Vector<Integer> radius = new Vector<>();

	public static void main(String[] args) throws IOException{

		in = new StringTokenizer(bf.readLine());
		
		int r = Integer.valueOf(in.nextToken());
		int d = Integer.valueOf(in.nextToken());
		int n = Integer.valueOf(bf.readLine());
		double dis;
		for (int i = 0; i < n; i++) {
			in = new StringTokenizer(bf.readLine());
			points.addElement(new Point(Integer.valueOf(in.nextToken()), Integer.valueOf(in.nextToken())));
			radius.addElement(Integer.valueOf(in.nextToken())); 
		}
		
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			
			dis = Math.sqrt( (points.elementAt(i).x*points.elementAt(i).x) + (points.elementAt(i).y*points.elementAt(i).y) );
			if(dis - radius.get(i) >= r-d && dis +radius.get(i) <= r){
				count++;
			}
			
		}
		System.out.println(count);
		
	}
	
	public static boolean insideCircle(Point c, int radius){
		
		int dx = c.x;
		int dy = c.y;
		int dis = dx*dx + dy*dy;
		int rad = radius*radius;
		
		if (dis <= rad) {
			return true;
		}else
			return false;
	}
	
	

}
