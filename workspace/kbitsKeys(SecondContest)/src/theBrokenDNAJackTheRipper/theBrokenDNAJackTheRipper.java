/**
 * 
 */
package theBrokenDNAJackTheRipper;

import java.io.*;
import java.util.*;

/**
 * @author Andres Martinez
 *
 */
public class theBrokenDNAJackTheRipper {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static Vector<String> DNAS = new Vector<>();
	
	public static void main(String[] args) throws IOException{

		String DNA, message;
		int n;
		long len, temp1, temp2, countOnes, sum;
		
		n = Integer.valueOf(bf.readLine().trim());
		
		long[][] DNAS = new long[n][2];
		
		DNA = bf.readLine().trim();
		len = DNA.length();
		DNAS[0] = createStringBit(DNA);
		
		for(int i = 1; i < n; ++i) {
			DNA = bf.readLine().trim();
			DNAS[i] = createStringBit(DNA);
		}
		
		 
		for(int i = 0; i < n; ++i) {
			sum = 0; message = (i+1)+": ";
			for(int j = 0; j < i; ++j) {
				temp1 = DNAS[i][0] & DNAS[j][0];
				countOnes = Long.bitCount(temp1);
				System.out.println(Long.toBinaryString(DNAS[i][0]));
				System.out.println(Long.toBinaryString(DNAS[j][0]));
				System.out.println(Long.toBinaryString(temp1));
				System.out.println(countOnes);
				temp2 = DNAS[i][1] & DNAS[j][1];
				countOnes -= Long.bitCount(temp2)*3;
				System.out.println(countOnes);
				if(countOnes == len) {message += (j+1)+" "; sum++;}
			}
			pw.print(sum != 0 ? message.trim()+"\n" : "");
		
		}
		
		
		
		
		pw.close();
	}
	
	public static long[] createStringBit(String dnaSequence) {
		long[] stringBit = new long[2];
		System.out.println();
		for(int i = 0; i < dnaSequence.length(); ++i) {
			System.out.println(Long.toBinaryString(stringBit[0]));
			if(dnaSequence.charAt(i) == 'A') stringBit[0] |= (1 << 4*i);
			if(dnaSequence.charAt(i) == 'C') stringBit[0] |= (1 << 4*i + 1);
			if(dnaSequence.charAt(i) == 'G') stringBit[0] |= (1 << 4*i + 2);
			if(dnaSequence.charAt(i) == 'T') stringBit[0] |= (1 << 4*i + 3);
			if(dnaSequence.charAt(i) == '-') {
				stringBit[0] |= (15 << 4*i); stringBit[1] |= (1 << i);
			}		
		}
		System.out.println();
		return stringBit;
	}
}

/*
 * 
8
AC-CG-
A-A-GG
ACACGT
ACACGG
ACACAC
---TT-
------
ACACAC

 * 
 */
