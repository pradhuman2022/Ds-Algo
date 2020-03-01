/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
                    Graph g = new Graph(4); 
                    g.addEdge(0, 1); 
                    g.addEdge(0, 2); 
                    g.addEdge(0, 3); 
                    g.addEdge(2, 0); 
                    g.addEdge(2, 1); 
                    g.addEdge(1, 3);             
                    System.out.println(g.countPaths(2, 3));
	}
	
	static class Graph {
	   ArrayList<ArrayList<Integer>> adjList = new ArrayList<>() ;
	   int vertexCount ; 
	   int pathCount ; 
	   
	   Graph(int vertexCount) {
	       this.vertexCount = vertexCount ; 
	       for (int i = 0; i < vertexCount; i++) {
	            adjList.add(new ArrayList<Integer>()) ;    
	       }
	   }
	   
	   void addEdge(int a, int b) {
	       adjList.get(a).add(b) ;
	   }
	   
	   int countPaths(int source, int destination) {
	       this.pathCount = 0 ;
	       boolean visited[] = new boolean[vertexCount]; 
	       dfs(source, destination, visited) ; 
	       return pathCount;
	   }
	   
	   void dfs(int s, int d, boolean visited[]) {
	       visited[s] = true;
	       if(s == d)
	        pathCount++;
	        
	       for(Integer adjNode : adjList.get(s)) {
	           if(!visited[adjNode]) 
	            dfs(adjNode, d, visited);
	       }
	       visited[s] = false;
	   }
	   
	   
	   int bfs(int root, int l) {
	       Queue<Integer> queue = new ArrayDeque<Integer>();
	       queue.add(0) ; 
	       int ansNodes = 0;
	       boolean visited[] = new boolean[vertexCount];
	       int level[] = new int[vertexCount] ;
	       
	       while(!queue.isEmpty()) {
	            
	            int parent = queue.poll() ; 
	            for (Integer adjNode : adjList.get(parent)) {
	                if(!visited[adjNode]) {
	                    visited[adjNode] = true;
	                    level[adjNode] = level[parent] + 1;
	                    queue.offer(adjNode);
	                }
	            }
	       }
	       
	       for(int i = 0 ; i < vertexCount; i++) 
	            if(level[i] == l)
	                ansNodes++;
	       return ansNodes;
	   }

	}
}
