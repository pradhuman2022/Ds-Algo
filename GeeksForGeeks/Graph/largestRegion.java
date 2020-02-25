import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner input = new Scanner(System.in);
	    int cases = input.nextInt();
	    
	    while(cases-->0) { 
	    int N = input.nextInt();
	    int M = input.nextInt();
	    int mat[][] = new int[N][M];
	    boolean visited[][] = new boolean[N][M];
	    
	    for(int i = 0 ; i < N; i++) {
	        for(int j = 0; j < M; j++) {
	            mat[i][j] = input.nextInt();
	        }
	    }
	    int maxArea = Integer.MIN_VALUE ; 
	    int count[] ;
	    for(int row = 0; row < N; row++) {
	        for(int col = 0; col < M; col++) {
	            if(!visited[row][col] && mat[row][col] == 1)
	              {
	                  count = new int[1] ;
	                  dfs(visited, mat, row, col, count, N,M);
	                  maxArea = Math.max(maxArea, count[0]) ; 
	              }
	        }
	    }
	    System.out.println(maxArea);
	   }
	 }
	 static void dfs(boolean visited[][], int mat[][], int row, int col, int count[], int N, int M) {
	     
	     if(row < 0 || col < 0 || row >= N || col >= M || visited[row][col])
	        return ;
	     visited[row][col] = true; 
	     
	     if(mat[row][col] == 1) {
	        
	        count[0] = count[0] + 1; 
	     
	        dfs(visited, mat, row, col - 1, count, N, M);
	        dfs(visited, mat, row, col + 1, count, N, M);
	        dfs(visited, mat, row - 1, col, count, N, M);
	        dfs(visited, mat, row + 1, col, count, N , M);
	        dfs(visited, mat, row + 1, col + 1, count, N, M);
	        dfs(visited, mat, row - 1, col - 1, count, N, M);
	        dfs(visited, mat, row + 1, col - 1, count, N, M);
	        dfs(visited, mat, row - 1, col + 1, count, N, M);
	     }
	 }
}
