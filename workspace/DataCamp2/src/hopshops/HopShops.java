package hopshops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HopShops {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	
	public static void main(String[] args) throws IOException{
		in = new StringTokenizer(bf.readLine().trim());
		
		double a = Integer.valueOf(in.nextToken());
		double x = Integer.valueOf(in.nextToken());
		double y = Integer.valueOf(in.nextToken());

		
		if(y == 0){
			System.out.println("-1");
		}else if(Math.ceil(y/a) == 1){
			if(x > -a/2 && x < a/2 && y % a != 0 ){
				System.out.println((int)(Math.ceil(y/a) + Math.floor((Math.ceil(y/a)-1)/2))); 
			}else{
				System.out.println("-1");
			}
		}else if(Math.ceil(y/a) % 2 == 0){
			if(x > -a/2 && x < a/2 && y % a != 0){
				System.out.println((int)(Math.ceil(y/a) + Math.floor((Math.ceil(y/a)-1)/2))); 
			}else{
				System.out.println("-1");
			}
		}else{
			if(x > -a && x < 0 && y % a != 0){
				System.out.println((int)(Math.ceil(y/a) + Math.floor((Math.ceil(y/a)-1)/2)-1)); 
			}else if(x < a && x > 0 && y % a != 0){
				System.out.println((int)(Math.ceil(y/a) + Math.floor((Math.ceil(y/a)-1)/2)));
			}else{
				System.out.println("-1");
			}
		}
		
	}

}
