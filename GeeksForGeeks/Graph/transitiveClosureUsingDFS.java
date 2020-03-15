/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
    
        Graph g = new Graph(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        int tClosure[][] = g.dfs(); 
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++)
                { System.out.print(tClosure[i][j]+" ") ;} 
                System.out.println();
        }     
        
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
	    
	    void dfsUtil(int src, int dest, int tc[][]) {
	        tc[src][dest] = 1;
	        for (Integer adjNode : adjList.get(dest)) {
	            if(tc[src][adjNode] == 0) {
	                dfsUtil(src ,adjNode, tc) ; 
	            }
	        }
	    }
	    
	    int[][] dfs() {
	        visited = new boolean[vertexCount] ;
	        int tc[][] = new int[vertexCount][vertexCount];
	        
	        for (int i = 0; i < vertexCount; i++) 
	            dfsUtil(i, i, tc); 
	        
	        return tc; 
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
