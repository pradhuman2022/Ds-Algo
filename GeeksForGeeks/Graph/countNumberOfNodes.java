/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
        	Graph g = new Graph(6); 
            g.addEdge(0, 1); 
            g.addEdge(0, 2); 
            g.addEdge(1, 3); 
            g.addEdge(2, 4); 
            g.addEdge(2, 5);
            System.out.println(g.bfs(0, 2));
	}
	
	static class Graph {
	   ArrayList<ArrayList<Integer>> adjList = new ArrayList<>() ;
	   int vertexCount ; 
	   
	   Graph(int vertexCount) {
	       this.vertexCount = vertexCount ; 
	       for (int i = 0; i < vertexCount; i++) {
	            adjList.add(new ArrayList<Integer>()) ;    
	       }
	   }
	   
	   void addEdge(int a, int b) {
	       adjList.get(a).add(b) ;
	       adjList.get(b).add(a) ;
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
