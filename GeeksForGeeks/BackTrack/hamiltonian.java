import java.lang.*;
import java.util.*;

class findPath {
    static boolean visited[] ; 
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt() ;
	  label:	while(T-- > 0){
		    
		    int v = sc.nextInt() ; 
		    int e = sc.nextInt() ;
		    Hamiltonian g = new Hamiltonian(v);
		    visited = new boolean[v + 1] ;
		    while(e-- > 0){
		        g.addVertex(sc.nextInt(), sc.nextInt());
		    }
		    visited = new boolean[v + 1] ;
		    
		    for(int i = 1 ; i <= v ; i++)
		   {
		       int totalNodes = g.doYourSearch(i, v, 0) ;
		    //    System.out.println(totalNodes);
		       if(totalNodes == v)
		            {
		             System.out.println(1);
		             continue label ;
		            }
		   }
		    System.out.println(0);    
		    
		}
	}
	
  
	static class Hamiltonian{
	    
	    int adjMatrix[][]   ;
	    
	    Hamiltonian(int v){
	        adjMatrix = new int[v + 1][v + 1]; 
	    }
	    
	    public void addVertex(int a , int b){
	      adjMatrix[a][b] = 1 ; 
	      adjMatrix[b][a] = 1 ; 
	    }
	    
	   int doYourSearch(int sourcePoint, int v, int totalNodesTillNow){
	        visited[sourcePoint] = true ;
	        totalNodesTillNow++ ;
	        
	        if(totalNodesTillNow == v)
	          return totalNodesTillNow ;
	        
	        int ans = totalNodesTillNow ;
	        for(int i = 1 ; i <= v ; i++){
	          
	          if(adjMatrix[i][sourcePoint] != 0){
	              if(!visited[i]){
	                  ans = Math.max(ans, doYourSearch(i, v, totalNodesTillNow)) ;
	              }
	          }      
	            
	        }
	        visited[sourcePoint] = false ;
	        return ans ;
	    }
	}
	
}
