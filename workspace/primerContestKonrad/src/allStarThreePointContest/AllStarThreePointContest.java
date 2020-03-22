/**
 * 
 */
package allStarThreePointContest;

/**
 * @author Andres Martinez
 * Uva 13293	All-star Three-point Contest
 */
import java.util.*;
import java.io.*;
public class AllStarThreePointContest {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st, st2;
	
	public static void main(String[] args) throws IOException{
		
		String s;
		int k = 0;
		while((s = bf.readLine()) != null) {
//			if(s.equals("-1")) break;
			ArrayList<Player> players = new ArrayList<>();
			
			for(int i = 0; i < Integer.valueOf(s); ++i) {	
				
				st = new StringTokenizer(bf.readLine().trim(), ";");
				String nombre = st.nextToken();
				Integer points =0;
				
				while(st.hasMoreElements()) {
					st2 = new StringTokenizer(st.nextToken());
	
					for(int j = 0; st2.countTokens() > 0; ++j) {
						int temp = Integer.valueOf(st2.nextToken());
						if(st2.countTokens() != 0) points+=temp;
						else if(temp == 1) points +=2;
					}
				}
				Player p = new Player(nombre,points);
				players.add(p);
			}
			
			Collections.sort(players);
			k++;
			pw.println("Case "+k+":");
			for(int j = 0; j < players.size(); ++j) {
				pw.println(players.get(j));
			}
		}
		
		pw.close();
	}

	
}

class Player implements Comparable<Player>{
	
	String nombre;
	Integer points;
	
	public Player(String nombre, Integer points) {
		this.nombre = nombre;
		this.points = points;
	}
	
	@Override
	public String toString() {
		return nombre+" "+points;
	}
	
	@Override
    public int compareTo(Player o) {        
        if(this.points == o.points){
            return this.nombre.toLowerCase().compareTo(o.nombre.toLowerCase());
        }else{
            return this.points.compareTo(o.points)*-1;
        }
    }   
	
}