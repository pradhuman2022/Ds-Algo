import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int INF = 10000000 ;
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0) {
	        int V = sc.nextInt();
	        int graph[][] = new int[V][V];
	        for (int i = 0; i < V; i++) {
	            for(int j = 0; j < V; j++)
	                graph[i][j] = sc.nextInt();
	        }
	        floydWarshell(graph, V) ;
	    }
	 }
	 static void floydWarshell(int graph[][], int V) {
	     int dp[][] = new int[V][V];
	     
	     for(int i = 0; i < V; i++) {
	         for(int j = 0; j < V; j++)
	            dp[i][j] = graph[i][j] ;
	     }
	     
	     for(int k = 0; k < V; k++) {
	         for(int i = 0; i < V; i++) {
	             for(int j = 0; j < V; j++) {
	                 dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]) ; 
	             }
	         }
	     }
	     for(int i = 0; i < V; i++) {
	         for(int j = 0; j < V; j++) {
	             if(dp[i][j] == INF) 
	                System.out.print("INF"+" ");
	             else
	                System.out.print(dp[i][j]+" ");
	         }
	         System.out.println(); 
	     }
	     
	     
	 }
}
