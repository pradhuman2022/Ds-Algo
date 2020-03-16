/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
    
        Graph g = new Graph(6);
        g.addEdge(1, 2); 
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        System.out.println(g.maxEdges()); 
        
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
	    
	    void dfs(long count_color[], int src, boolean color, int parent) {
	        
	        count_color[color == false ? 0 : 1]++;
	        for (int node : adjList.get(src))
	            if(node != parent)
	                dfs(count_color, node, !color, src);
	   }
	    
	   int maxEdges(){
	       long count_color[] = new long[2];
	       dfs(count_color, 1, false, 0);
	       return (int) (count_color[0] * count_color[1] - (vertexCount - 1)) ;
         //we need to remove n - 1 edges as graph of n nodes will have.
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
