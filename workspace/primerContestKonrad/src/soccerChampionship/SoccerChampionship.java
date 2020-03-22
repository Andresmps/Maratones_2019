/**
 * 
 */
package soccerChampionship;

import java.util.*;
import java.io.*;
/**
 * @author Andres Martinez
 * Uva 13259	Soccer Championship
 */
public class SoccerChampionship {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static int c = 0;
	
	public static void main(String[] args) throws IOException{
		
		String s;
		while((s = bf.readLine()) != null) {

		    Map<String, Team> table = new HashMap<>();
			String L, V;

			int M = Integer.valueOf(s), X, Y, paradox = 0;

			for(int i = 0; i < M; ++i) {
				
				String[] split = bf.readLine().split(" vs. ");
				// digame
				// cual era el runtime?
				String[] a = split[0].split(" ");
				String[] b = split[1].split(" ");
				
				L = ""; V ="";
				for(int k = 0; k < a.length-1; ++k) L += a[k]+" ";
				for(int k = 1; k < b.length; ++k) V += b[k]+" ";
				
				L = L.trim();//local
				V = V.trim();//visitante
				
				X = Integer.valueOf(a[a.length-1]);//score local
				Y = Integer.valueOf(b[0]);//score visitante
				

				Team local, visitante;
				if(table.containsKey(L))
				{
					local=table.get(L);
				}else {
					local=new Team();
					local.name=L;
					table.put(L, local);
				}
				
				if(table.containsKey(V)) 
					visitante=table.get(V);
				else {
					visitante=new Team();
					visitante.name=V;
					table.put(V, visitante);
				}
				
				if(X == Y) {
					local.points++;
					visitante.points++;
					
				}else if(X > Y){
					local.points+=3;
					local.difference+=X-Y;
					visitante.difference+=Y-X;
					visitante.teamLost.add(L);
				}else {
					visitante.points+=3;
					local.difference+=X-Y;
					visitante.difference+=Y-X;
					local.teamLost.add(V);
				}
				local.goals+=X;
				visitante.goals+=Y;
				visitante.goalsAsVisitor+=Y;
				
			}
			ArrayList<Team> teams = new ArrayList<>();
			table.forEach((k,v)->teams.add(v));
			Collections.sort(teams);
			
			for (int i = 0; i < teams.size(); i++) {
				Team t=teams.get(i);
				List<String> nameLost=t.teamLost;
				for (String name : nameLost) {
					for (int j = i+1; j < teams.size(); j++) {
						if(name.equals(teams.get(j).name)) paradox++;
					}
				}
			}

			c=0;
			System.out.println("The paradox occurs "+paradox+" time(s).");
			teams.forEach(t->System.out.printf("%d. %s\n",++c,t));

		}
	}	
}

class Team implements Comparable<Team>{

	String name;
	int index, points, difference, goals, goalsAsVisitor;
	List<String> teamLost;

	public Team() {
		teamLost=new ArrayList<>();
	}

	
	@Override
	public String toString() {
		return name;//+" "+teamLost;
	}
	
	@Override
	public int compareTo(Team o) {
		int c;
		c=o.points-this.points;
		if(c==0) {
			c=o.difference-this.difference;
			if(c==0) {
				c=o.goals-this.goals;
				if(c==0) {
					c=o.goalsAsVisitor-this.goalsAsVisitor;
					if(c==0)c=this.name.compareTo(o.name);		
				}
			}	
		}
		return c;
		
	}
	
	
}
 
/*
 * 
13
B. DORTMUND 2 vs. 2 REAL MADRID
SP. PORTUGAL 2 vs. 0 LEGIA
SP. PORTUGAL 1 vs. 2 B. DORTMUND
REAL MADRID 5 vs. 1 LEGIA
B. DORTMUND 1 vs. 0 SP. PORTUGAL
LEGIA 3 vs. 3 REAL MADRID
MONACO 3 vs. 0 CSKA M.
SP. PORTUGAL 1 vs. 2 REAL MADRID
B. DORTMUND 8 vs. 4 LEGIA
REAL MADRID 2 vs. 2 B. DORTMUND
LEGIA 1 vs. 0 SP. PORTUGAL
MONACO 1 vs. 0 SP. PORTUGAL
CSKA M. 1 vs. 0 B. DORTMUND
2
TEAM 1 4 vs. 2 TEAM 2
TEAM 2 2 vs. 0 TEAM 1
-1
 */

