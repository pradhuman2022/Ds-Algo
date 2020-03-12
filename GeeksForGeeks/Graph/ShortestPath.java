/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    ArrayList<ArrayList<Integer>> adjList ;
    int vertexCount ;
    
	public static void main (String[] args) {
	
	}
	
	GFG(int vertexCount) {
	    this.vertexCount = vertexCount ; 
	    for(int i = 0 ; i < vertexCount; i++)
	        adjList.add(new ArrayList<Integer>()) ; 
	}
	
	void sieveOfEra(ArrayList<Integer> set){
	    int n = 9999; 
	    boolean prime[] = new boolean[n + 1]; 
	    Arrays.fill(prime, true); 
	    
	    for (int i = 2; i <= n; i++) {
	        prime[i] = true;
	        for(int j = i * i; j <= n; j += i) {
	             prime[j] = false ; 
	        }
	    }
	    
	    for(int i = 1000; i <= n ; i++) 
	        if(prime[i]) 
	            set.add(i) ;
	}
	
	int getShortestPath(int num1, int num2) {
        
        ArrayList <Integer> set = new ArrayList<Integer>() ;
        sieveOfEra(set); 
        
        for(int i = 0; i < set.size(); i++) {
            for(int j = i + 1; j < set.size(); j++)
                if(compare(set.get(i), set.get(j)))
                    addEdge(set.get(i), set.get(j)) ; 
        }
        
        int n1 = 0; 
        int n2 = 0;
        
        return bfs(n1, n2);
	}
	
	int bfs(int n1, int n2) {
	    int visited[] = new int[vertexCount];
	    Queue<Integer> q = new LinkedList<Integer>();
	    visited[n1] = 1; 
	    q.offer(n1) ; 
	    while(!q.isEmpty()) {
	        int val = q.pop() ; 
	        for (Integer v : adjList.get(val)) {
	            if(visited[v] == 0) 
	                visited[v] = visited[val] + 1 ; 
	            if(v == n2)
	                return visited[v] ; 
	        }
	    }
	    return -1; //unreachable
	}
	
	/*
	    comparison between one digit differenced numbers
	*/
	public boolean compare(int num1, int num2) {
	    
	    int diff = 0 ; 
	    String n1 = Integer.toString(num1);
	    String n2 = Integer.toString(num2);
	    
	    for(int i = 0; i < n1.length(); i++)
	        if(n1.charAt(i) != n2.charAt(i))
	            diff++ ; 
	    return diff == 1 ? true : false ;
	}
	
	/*
	    add edge 
	*/
	void addEdge(int num1, int num2) {
	    adjList.get(num1).add(num2) ; 
	}
	
}
