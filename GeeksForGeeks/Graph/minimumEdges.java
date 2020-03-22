/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
    
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(1, 3);
        int u = 0; 
        int v = 4; 
        System.out.println(g.bfs_returnMinEdges(u, v)); 
        
	}
	static class Graph{
	    int nonAccessNode ; 
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
	        adjList.get(dest).add(src);
	    }
	    
	    void dfs(int node, boolean visited[]) {
	        visited[node] = true; 
	        
	        for(Integer adjNode: adjList.get(node)) {
	            if(!visited[adjNode]) {
	                nonAccessNode++ ; 
	                dfs(adjNode, visited) ;
	            }
	        }
	   }
	   
	   //return number of nonAccessNodes using dfs 
	   int canNotAccessible() {
	        boolean visited[] = new boolean[vertexCount] ;
	        int totalNonAccessNodes = 0;
	        for(int i =0 ; i < vertexCount; i++) {
	            if(!visited[i]) {
	                nonAccessNode = 1 ; 
	                dfs(i, visited);
	                totalNonAccessNodes += nonAccessNode * (vertexCount - nonAccessNode); 
	            }
	        }
	        return totalNonAccessNodes; 
	   } 
	  
	  /*  
	   int maxEdges(){
	       long count_color[] = new long[2];
	       //dfs(count_color, 1, false, 0);
	       return (int) (count_color[0] * count_color[1] - (vertexCount - 1)) ;
	   }
	   
	   */
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
	    
	    int bfs_returnMinEdges(int u, int v) {
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	        boolean visited[] = new boolean[vertexCount];
	        int distance[] = new int[vertexCount];
	        q.offer(u) ; 
	        
	        while(!q.isEmpty()) {
	            int front = q.poll();
	            
	            visited[front] = true;
	            for (Integer adjNode : adjList.get(front)) {
	                if(!visited[adjNode]) {
	                    distance[adjNode] = distance[front] + 1 ;
	                    q.offer(adjNode);
	                }
	            }
	        }
	        return distance[v];
	    }
	}
}
