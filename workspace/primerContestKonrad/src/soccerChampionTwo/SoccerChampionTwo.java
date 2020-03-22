/**
 * 
 */
package soccerChampionTwo;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class SoccerChampionTwo {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static ArrayList<Team> teams = new ArrayList<>();
	static ArrayList<String[]> results = new ArrayList<>();
	static Hashtable<String, Team> names = new Hashtable<>();
	static int c;
	
	
	public static void main(String[] args) throws IOException{
		
		String s;

		while((s = bf.readLine()) != null) {
	
			String L, V;
			int X, Y, M, paradox = 0;
			
			M = Integer.valueOf(s);
			
			if(M == -1) break;
			c = 0;
			
			for(int i = 0; i < M; ++i) {
				
				String[] split = bf.readLine().split(" vs. ");
				
				String[] a = split[0].split(" ");
				String[] b = split[1].split(" ");
				L = ""; V = "";
				
				for(int k = 0; k < a.length-1; ++k) L += a[k]+ " ";
				for(int k = 1; k < b.length; ++k) V += b[k]+" ";
				
				L = L.trim(); // Team 1
				V = V.trim(); // Team 2
				
				X = Integer.valueOf(a[a.length-1]); 	// Score Team 1
				Y = Integer.valueOf(b[0]); 				// Score Team 2
				
				
				String[] result = new String[2];
				
				if(X == Y) {
					match(L, 1, 0, X, 0);
					match(V, 1, 0, Y, Y);
				}else if(X > Y){
					result[0] = L; result[1] = V; results.add(result);
					
					match(L, 3, X-Y, X, 0);
					match(V, 0, Y-X, Y, Y);
				}else {
					result[0] = V; result[1] = L; results.add(result);
					
					match(L, 0, X-Y, X, 0);
					match(V, 3, Y-X, Y, Y);
				}
				
			}
			
			Collections.sort(teams);
			
			// results = array [winner, loser]
			// teams = Team [name, point, goal, ...]
			
			
			for(int j = 0; j < results.size(); ++j) {
				String[] temp = results.get(j);
		
				for(int k = 0; k < teams.size(); ++k){
					String name = teams.get(k).name;
				
					if(temp[1].equals(name)) {
						paradox++;
						break;
					}else if(temp[0].equals(name)) break;
				}
			}
			
			pw.println("The paradox occurs "+paradox+" time(s).");
			for(int j = 0; j < teams.size(); ++j) {
				pw.println((j+1)+". "+teams.get(j).name);
			}
			teams.clear();
			names.clear();
			results.clear();
		}
		
		pw.close();
		
	}
	
	public static void match(String name, Integer points, Integer difference, Integer goals, Integer goalsAsVisitor) {
		if(names.containsKey(name)) {
			teams.get(names.get(name).index).match(points, difference, goals, goalsAsVisitor); 
		}else {
			Team team = new Team(name, c++, points, difference, goals, goalsAsVisitor);
			names.put(name, team);
			teams.add(team);
		}
	}

}

class Team implements Comparable<Team>{
	
	public String name;
	public Integer index;
	public Integer points;
	public Integer difference;
	public Integer goals;
	public Integer goalsAsVisitor;

	public Team(String name, Integer index, Integer points, Integer difference, Integer goals, Integer goalsAsVisitor) {
		this.name = name;
		this.index = index;
		this.points = points;
		this.difference = difference;
		this.goals = goals;
		this.goalsAsVisitor = goalsAsVisitor;
	}
	
	public void match(Integer points, Integer difference, Integer goals, Integer goalsAsVisitor) {
		this.points += points;
		this.difference += difference;
		this.goals += goals;
		this.goalsAsVisitor += goalsAsVisitor;
	}
	
	@Override
	public String toString() {
		return "{ Name: "+name+", Index: "+index+", Points: "+points+", Difference: "+difference+", Goals: "+goals+", GoalsAsVisitor: "+goalsAsVisitor+" }";
	}
	
	
	@Override
	public int compareTo(Team o) {
		
		if(o.points == this.points) {
			if(this.difference == o.difference) {
				if(this.goals == o.goals) {
					if(this.goalsAsVisitor == o.goalsAsVisitor) 
						return this.name.compareTo(o.name);
					else 
						return this.goalsAsVisitor.compareTo(o.goalsAsVisitor)*-1;
				
				}else 
					return this.goals.compareTo(o.goals)*-1;
			
			}else 
				return this.difference.compareTo(o.difference)*-1;
			
		}else 
			return this.points.compareTo(o.points)*-1;
	}
	
	
}