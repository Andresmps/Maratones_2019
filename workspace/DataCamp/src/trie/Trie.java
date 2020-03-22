package trie;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 *
 * @author arlese.rodriguezp
 * Trie Data Structure implemented in Java
 * 
 */
public class Trie {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Node trie = new Node(0);
        System.out.println(trie);
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            buildTrie(trie, s);
        }
        
        
    }

    private static void buildTrie(Node trie, String s) {
        int i = 0;
        Node currentTrie = trie;
        while (i < s.length()) {
        	System.out.println(currentTrie);
            if (currentTrie.links[s.charAt(i) - 'A'] == null) { //if letter is empty stores this letter in current trie.
                Node n = new Node(s.charAt(0) - 'A'); 
                currentTrie = currentTrie.links[s.charAt(i) - 'A'] = n; //update current to last letter.
                System.out.println("1");
            } else {
                currentTrie = currentTrie.links[s.charAt(i) - 'A']; //use current letter.
                System.out.println("2");
            }
            i++;
        }
        
        currentTrie.end = true;
        System.out.println(currentTrie);
    }

    //Base Node of a Trie 
    static class Node {
        int id; //indicates symbol in this case letter
        boolean end; //indicates end of a String given
        Node[] links;
        
        public Node(int id) {
            this.id = id;
            end = false;
            this.links = new Node[27]; //27 in this case because is implemented for letters
        }
        
        
        public String toString() {
        	return "Id:"+id+", links: "+toLinks()+", end: "+end;
        }
        
        public String toLinks() {
        	String linksToString = "\n{ ";
        	
        	for (int i = 0; i < links.length; i++) {
        		if(links[i] != null) {
        		if(i != links.length-1) linksToString += (char)('A'+i)+" "+links[i]+", ";
        		else linksToString += links[i];
        		}
			}
        	
        	linksToString += " }\n";
        	
        	return linksToString;
        }

    }
}