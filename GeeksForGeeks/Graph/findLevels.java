/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
    
        Graph g = new Graph(8);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(6, 7);
        int level[] = new int[8] ; 
        g.bfs(level); 
        for(int i = 0; i < 8; i++)
            System.out.println(level[i]) ; 
        
	}
	static class Graph{
	    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	    int vertexCount;
	    boolean visited[];
	    Graph(int vertexCount) {
	        this.vertexCount = vertexCount;
	        for(int i = 0; i < vertexCount; i++)
	            adjList.add(new ArrayList<Integer>());
	    }
	    
	    void addEdge(int src, int dest) {
	        adjList.get(src).add(dest); 
	        //adjList.get(dest).add(src);
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
	        visited = new boolean[vertexCount] ;
	        for (int i = 0; i < vertexCount; i++) {
	            if(!visited[i]) {
	                dfsUtil(i, visited); 
	                trees++ ;
	            }
	        }
	        return trees; 
	    }
	    
	    void bfs(int level[]) {
	        visited = new boolean[vertexCount];
	        Queue<Integer> queue = new LinkedList<Integer>() ; 
	        queue.offer(0) ; 
	        level[0] = 0; 
	        while(!queue.isEmpty()) {
	            int node = queue.poll(); 
	            visited[node] = true; 
	            for (Integer adjNode : adjList.get(node)) {
	                if(!visited[adjNode]) {
	                    queue.add(adjNode);
	                    level[adjNode] = level[node] + 1 ; 
	                }     
	            }
	        }
	    }
	}
}
