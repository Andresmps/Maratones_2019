/**
 * 
 */
package pieceFactory;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class PieceFactory {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer sc;
	static Hashtable<String, Integer> pieces = new Hashtable<>();
	static Hashtable<String, String> piecesC = new Hashtable<>();
	 
	public static void main(String[] args) throws IOException{
		
		int N = Integer.valueOf(bf.readLine()), value;
		String compoundMsg = "", s, key, Fkey;
		
		for(int i = 0; i < N; ++i) {
			sc = new StringTokenizer(bf.readLine());
			pieces.put(sc.nextToken(), Integer.valueOf(sc.nextToken()));
		}
	  
		while((s = bf.readLine()) != null) {
			if(s.equals("0")) break; 
			key = s.split(" ")[0];
			if(piecesC.containsKey(key)) {
				piecesC.replace(key, piecesC.get(key) + ":" + s);
			}else {
				piecesC.put(key, s);
				compoundMsg += key+" ";
			}
		}
		
//		System.out.println(piecesC);
		
		sc = new StringTokenizer(compoundMsg.trim());
//		System.out.println(compoundMsg);
		
		while(sc.hasMoreTokens()) {
			key = sc.nextToken();
		
			String[] split = piecesC.get(key).split(":");
			System.out.println(Arrays.toString(split));
			
			for(int i = 0; i < split.length; ++i) {
				Fkey = split[i].split(" ")[1];
				value = Integer.valueOf(split[i].split(" ")[2]);
				if(i == 0) {
					if(pieces.containsKey(Fkey)) {
						pieces.put(key, pieces.get(Fkey)*value);	
					}
				}else {
					if(pieces.containsKey(Fkey)) {
						pieces.put(key, pieces.get(key) + (pieces.get(Fkey)*value));
					}
				}
			}
			
			pw.println(key+" "+pieces.get(key));
		}
		
		
		pw.close();
	}
	
	
}


