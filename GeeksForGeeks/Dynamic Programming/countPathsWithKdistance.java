import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int graph[][];
    static int vertices;
    static int source; 
    static int destination;
    static int edgesToWalkOn; 
    static int count[][]; 
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0) {
	        vertices = sc.nextInt();
	        graph = new int[vertices][vertices]; 
	        for(int i = 0; i < vertices; i++) {
	            for(int j = 0; j < vertices; j++) {
	               
	                graph[i][j] = sc.nextInt();
	            }
	        }
	        source = sc.nextInt();
	        destination = sc.nextInt();
	        edgesToWalkOn = sc.nextInt();
	        count = new int[vertices][edgesToWalkOn + 1];
	        for(int cnt[] : count)
	            Arrays.fill(cnt, -1);
	            
	        System.out.println(countAllPaths(source, edgesToWalkOn));
	    }
	 }
	 static int countAllPaths(int source, int edgesToWalkOn) {
	      if(source == destination && edgesToWalkOn == 0)
	        return 1;
	      if(edgesToWalkOn == 1 && graph[source][destination] == 1)
	        return 1;
	        
	      if(edgesToWalkOn <= 0)
	        return 0; 
	      if(count[source][edgesToWalkOn] != -1)
	        return count[source][edgesToWalkOn];
	      int ans = 0 ; 
	      for (int i = 0; i < vertices; i++) {
	          if(graph[source][i] == 1 )
	            ans += countAllPaths(i, edgesToWalkOn - 1); 
	      }
	      return count[source][edgesToWalkOn] = ans ;
	 }
}
