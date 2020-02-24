/*package whatever //do not write package name here */

import java.util.*;

class FunTime {
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
     int coreValue = 3; 
     Graph g1 = new Graph(9); 
     g1.addEdge(0, 1); 
     g1.addEdge(0, 2); 
     g1.addEdge(1, 2); 
     g1.addEdge(1, 5); 
     g1.addEdge(2, 3); 
     g1.addEdge(2, 4); 
     g1.addEdge(2, 5); 
     g1.addEdge(2, 6); 
     g1.addEdge(3, 4); 
     g1.addEdge(3, 6); 
     g1.addEdge(3, 7); 
     g1.addEdge(4, 6); 
     g1.addEdge(4, 7); 
     g1.addEdge(5, 6); 
     g1.addEdge(5, 8); 
     g1.addEdge(6, 7); 
     g1.addEdge(6, 8); 
     g1.dfs();
     
     
 }
	static class Graph {
	    int vertexCount;
	    ArrayList<ArrayList<Integer>> adjList;
	    Graph(int vertexCount) {
	        this.vertexCount = vertexCount;
	        adjList = new ArrayList<ArrayList<Integer>>();
	        for (int i = 0; i < vertexCount; i++) 
	            adjList.add(new ArrayList<Integer>());
	    }
	    
	    void addEdge(int u, int v) {
	        adjList.get(u).add(v) ; 
	    }
	    
	    void iterativeDfs(int src, boolean visited[]) {
	        
	        Stack<Integer> st = new Stack<Integer>();
	         
	        
	        st.push(src); 
	        while(!st.isEmpty()) {
	             
	             int node = st.pop();
	             if(!visited[node])
	              System.out.print(node+" ");
	             visited[node] = true;
	             for(int nodes : adjList.get(node)) {
	                 if(!visited[nodes]) 
	                  st.push(nodes);
	             }
	        }
	        
	    }
	    
	    void dfs() {
	        boolean visited[] = new boolean[vertexCount] ;
	        for(int i = 0 ; i < vertexCount; i++) {
	            if(!visited[i])
	                iterativeDfs(i, visited);
	        }
	    }
	}
}
