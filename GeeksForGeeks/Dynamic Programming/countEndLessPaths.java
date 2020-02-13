/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    
	    int mat[][] = new int[n][m];
	    for(int i = 0; i < n; i++){
	        for(int j = 0 ; j < m; j++)
	         mat[i][j] = sc.nextInt();
	    }
	    System.out.print(countEndLessPaths(mat, n, m)) ;
	}
	
	static int countEndLessPaths(int mat[][], int n, int m){
	    boolean row[][] = new boolean[n][m] ; 
	    boolean col[][] = new boolean[n][m] ;
	    
	    for (int i = 0 ; i < n; i++){
	        boolean isEndLess = true ;
	        for(int j = n - 1 ; j >= 0; j--){
	            if(mat[i][j] == 0)
	            isEndLess = false ; 
	            
	            row[i][j] = isEndLess ;
	        }
	    }
	    
	    for (int j = 0; j < n; j++){
	        boolean isEndLess = true;
	        for (int i = n - 1 ; i >= 0; i--){
	            if(mat[i][j] == 0)
	            isEndLess = false ;
	            
	            col[i][j] = isEndLess ;
	        }
	    }
	    
	    int ans = 0 ;
	    for(int i = 0 ; i < n; i++){
	        for(int j = 0 ; j < m; j++)
	          if(row[i][j] && col[i][j])
	            ans++ ;
	    }
	    
	    return ans ;
	}
}
