/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
    
        Graph g = new Graph(5);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(3, 4);
        System.out.println(g.dfs()) ; 
        
	}
	static class Graph{
	    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	    int vertexCount;
	    
	    Graph(int vertexCount) {
	        this.vertexCount = vertexCount;
	        for(int i = 0; i < vertexCount; i++)
	            adjList.add(new ArrayList<Integer>());
	    }
	    
	    void addEdge(int src, int dest) {
	        adjList.get(src).add(dest); 
	        adjList.get(dest).add(src);
	    }
	    
	    void dfsUtil(int src, boolean visited[]) {
	        visited[src] = true;
	        
	        for (Integer adjNode : adjList.get(src)) {
	            if(!visited[adjNode]) {
	                dfsUtil(adjNode, visited) ; 
	            }
	        }
	        
	    }
	    
	    int dfs() {
	        int trees = 0; 
	        boolean visited[] = new boolean[vertexCount] ;
	        for (int i = 0; i < vertexCount; i++) {
	            if(!visited[i]) {
	                dfsUtil(i, visited); 
	                trees++ ;
	            }
	        }
	        return trees; 
	    }
	}
}
