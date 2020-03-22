package aNeedleInTheHaystack;

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class ANeedleInTheHaystack {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		
		String s, text, pattern;
		int m;

		while ((s = bf.readLine()) != null) {

			m = Integer.valueOf(s);
			// if(m == -1) break;
			pattern = bf.readLine();
			text = bf.readLine();

			kmp(text, pattern);
			sc.println();
		}
		sc.close();
	}

	public static Vector<Integer> kmp(String text, String pattern) {

		Vector<Integer> indexes = new Vector<>();
		int[] lps = Lps(pattern);
		int m = text.length(), n = pattern.length();

		for (int i = 0, j = 0; i < m;) {

			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;

				if (j == n) {
					sc.println(i - j);
					indexes.add(i - j);
					j = lps[n - 1];
				}
			} else {
				if (j == 0)
					i++;
				else
					j = lps[j - 1];
			}
		}

		return indexes;
	}

	// Lps
	// Longest prefix that is also a suffix but is not equal to the string

	public static int[] Lps(String pattern) {

		int m = pattern.length();
		int[] lps = new int[m];

		// Lps[0] is always 0
		lps[0] = 0;

		for (int i = 1, j = 0; i < m;) {

			// There is a match. Both pointer have to be increase.
			if (pattern.charAt(i) == pattern.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			} else {
				// If j == 0 it means there has not been a match before.
				if (j == 0) {
					lps[i] = 0;
					i++;

					// Otherwise, we have to look for the last match that appear.
					// Note that i has not been increase.
				} else {
					j = lps[j - 1];
				}
			}
		}

		return lps;
	}
}

/*
 * 
 * 2 na banananobano 6 foobar foo 9 foobarfoo barfoobarfoobarfoobarfoobarfoo -1
 * 
 */
