package phoneList;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 * Uva 11362
 */

public class PhoneList {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter sc = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
    public static void main(String[] args) throws IOException {
        
        int t = Integer.valueOf(bf.readLine().trim());
        
        for (int j = 0; j < t; j++) {
			
	        int n = Integer.valueOf(bf.readLine().trim());
	        
	        boolean flag = true;
	        Node trie = new Node(0);
	        
	        for (int i = 0; i < n; i++) {
	            String s = bf.readLine().trim();
	            
	            if(!buildTrie(trie, s)) {
	            	flag = false;
//	            	break;
	            }
	        }
	        
	        if (flag) {
				sc.println("YES");
			}else {
				sc.println("NO");
			}
        }
        sc.close();
    }

    private static boolean buildTrie(Node trie, String s) {
        
    	Node currentTrie = trie;

        for (int i = 0; i < s.length(); i++) {
	
            if(currentTrie.end) {
            	return false;
            }else if (currentTrie.links[s.charAt(i) - '0'] == null) { 
            	Node n = new Node(s.charAt(0) - '0'); 
                currentTrie = currentTrie.links[s.charAt(i) - '0'] = n; 
            } else {
                currentTrie = currentTrie.links[s.charAt(i) - '0']; 
            }
		}
        
        currentTrie.end = true;
        
        for (Node n: currentTrie.links) {
			if (n != null) {
				return false;
			}
		}
        
        return true;
    }
 
    
    static class Node {
        
    	int id; 
        boolean end; 
        Node[] links;
        
        public Node(int id) {
            this.id = id;
            end = false;
            this.links = new Node[10]; 
        }
    }
}

/* 

3
3
911
97625999
91125426
3
97625999
91125426
911
5
113
12340
123440
12345
98346

 */



