import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) {
	 //code
	  Scanner input = new Scanner(System.in) ; 
	  int cases = input.nextInt();
	 while(cases-->0) {
	    int N = input.nextInt();
	    int M = input.nextInt();
	    input.nextLine();
	    char mat[][] = new char[N][M];
	    String srr[] = input.nextLine().split(" "); 
	    
	    for(int string = 0; string < N; string++) {
	        String s = srr[string];
	        System.out.println(s+" "+s.length()+" "+M);
	        
	        for(int col = 0; col < s.length(); col++) {
	            mat[string][col] = s.charAt(col) ; 
	        }
	    }
	  
	    boolean visited[][] = new boolean[N][M]; 
	    int ans = 0;
	  
	    for(int row = 0; row < N; row++) {
	        for(int col = 0; col < M; col++) {
	            if(!visited[row][col] && mat[row][col] == 'X') {
	                ans++;
	                dfs(N, M, row, col, visited, mat) ;
	            }
	        }
	    }
	    System.out.println(ans);
    }
  }
	
    static void dfs(int N, int M, int row, int col, boolean visited[][], char mat[][]) {
        if(row < 0 ||col < 0 || col >= M ||row >= N)
            return ;
        
        visited[row][col] = true;
        
        if(row < N - 1 && !visited[row + 1][col] && mat[row + 1][col] == 'X')
            dfs(N, M, row + 1, col, visited, mat);
        if(col < M - 1 && !visited[row][col + 1] && mat[row][col + 1] == 'X')
            dfs(N, M, row, col + 1, visited, mat);
        if(row > 0 && !visited[row - 1][col] && mat[row - 1][col] == 'X')
            dfs(N, M, row - 1, col, visited, mat);
        if(col > 0 && !visited[row][col - 1] && mat[row][col - 1] == 'X')
            dfs(N, M, row, col - 1, visited, mat);
    }
}
