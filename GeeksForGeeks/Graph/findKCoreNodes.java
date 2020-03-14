
/*kcore nodes package whatever //do not write package name here */

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
     int degree[] = new int[9];
     int minVertex = g1.findMinDegreeVertex(degree); 
     boolean visited[] = new boolean[9]; 
     g1.dfsUtil(visited, degree, minVertex, coreValue);
     for (int currentVertex = 0; currentVertex < 9; currentVertex++) {
         if(!visited[currentVertex]) 
         g1. dfsUtil(visited, degree, currentVertex, coreValue);
     }
     g1.printKCoreNodes(degree, coreValue) ;
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
	        adjList.get(v).add(u) ; 
	    }
	    
	      /*
	      *Modified DFS , so we can remove vertex whose degreee is less than coreValue by finding
	      *minDegreeVertex and again we need to call dfs over all vertices who are not visited after visiting
	      *minDegreeVertex.
	      */
       
	    boolean dfsUtil(boolean visited[], int degree[], int minDegreeVertex, int coreValue) {
	        visited[minDegreeVertex] = true; 
	        
	        for(int adjacentVertex = 0; adjacentVertex < adjList.get(minDegreeVertex).size(); adjacentVertex++) {
	            if(degree[minDegreeVertex] < coreValue)
	                degree[adjList.get(minDegreeVertex).get(adjacentVertex)]-- ;
	                
	            if(!visited[adjList.get(minDegreeVertex).get(adjacentVertex)]) { 
	                if(dfsUtil(visited, degree, adjList.get(minDegreeVertex).get(adjacentVertex), coreValue))
	                    degree[minDegreeVertex]--;
	            }
	        }
          
	        return degree[minDegreeVertex] < coreValue ; 
	    }
      
	       /*
         * find vertices whose degree is minimum and call dfs on that vertices.
         */
	    int findMinDegreeVertex(int degree[]) {
	        
	        int minVertex = 0; 
	        
	        for (int currentVertex = 0 ; currentVertex < vertexCount; currentVertex++) {
	            degree[currentVertex] = adjList.get(currentVertex).size() ; 
	            
	            if(degree[currentVertex] < degree[minVertex]) 
	                minVertex = currentVertex; 
	        }
          
	        return minVertex ;
	    }
      
	      /*
        *Print nodes whose degree is greater or equal to coreValue.
        *after using modified dfs.
        */
	    void printKCoreNodes(int degree[], int coreValue) {
	        for(int currentVertex = 0; currentVertex < vertexCount; currentVertex++) {
	            if(degree[currentVertex] >= coreValue) {
	                System.out.print(currentVertex+":"); 
	                
	                for (int adjNode : adjList.get(currentVertex)) {
	                    if(degree[adjNode] >= coreValue) {
	                        System.out.print("->"+adjNode);
	                    }
	                }
	            }
	            System.out.println();
	        }
	    }
	}
}
