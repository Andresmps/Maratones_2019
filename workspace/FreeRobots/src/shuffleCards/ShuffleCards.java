package shuffleCards;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class ShuffleCards {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	public static void main(String[] args) throws IOException{
		
		int[] p = new int[10000000];
		
		System.out.println(Arrays.toString(p));
		
		
		int T = Integer.valueOf(bf.readLine()), count, c;
		String word;
		
		for (int i = 0; i < T; i++) {
			word = bf.readLine();
			count = 0;
			c = 0;
			
			for (int j = word.length()-1; j >= 0 ; j--) {
				//sc.println("i: "+i+" word: "+word.length()); 
				if(word.charAt(j) == ('a'+c)) {  

					count++;
					if(c == 0) {c = 1;}
					else if(c == 1) {c = 0;}
				} 
			}
			sc.println(count);
		}
		sc.close();
	}

}
