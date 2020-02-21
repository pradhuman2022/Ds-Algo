/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Graph g = new Graph(7);
	    
	    g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3); 
        g.addEdge(4, 1); 
        g.addEdge(6, 4); 
        g.addEdge(5, 6); 
        g.addEdge(5, 2); 
        g.addEdge(6, 0); 
	    g.dfs();
	}
	
	//implementation for directed Graph
    static class Graph{
        
        int v ; 
        List<Integer> adjList[]; 
        
        public Graph(int v){
            this.adjList = new ArrayList[v];
            this.v = v; 
            for (int i = 0; i < v; i++)
                adjList[i] = new ArrayList<Integer>();
        }
        
        public void addEdge(int a, int b){
            adjList[a].add(b);    
        }
        
        void dfs(){
            boolean visited[] = new boolean[v];
            int motherVertex = 0;
            /*
            **last encountered unvisited vertex will be mother vertex,
            **as it will make every vertex visited.
            */
            for(int i = 0; i < v; i++){
                
                if(!visited[i]){
                    motherVertex = i; 
                    dfsUtil(i, visited);
                }
            }
            
            /*
            **Then we will do dfs last encountered vertex,
            **and check whether it will make every vextex visited.
            */
            Arrays.fill(visited, false);
            dfsUtil(motherVertex, visited);
            if(isMotherVertex(motherVertex, visited))
                System.out.print(motherVertex);
            else
                System.out.print(-1);
        }
        
        void dfsUtil(int startVertex, boolean visited[]){
            visited[startVertex] = true ;
            
            for(Integer adjNode : adjList[startVertex]){
                if(!visited[adjNode]){
                    dfsUtil(adjNode, visited);
                }
            }
        }
        
        
        boolean isMotherVertex(int vertex, boolean visited[]){
            
            for(int i = 0; i < v; i++){
                if(visited[i] == false)
                    return false;
            }
            return true;
        }
        
    }
}
