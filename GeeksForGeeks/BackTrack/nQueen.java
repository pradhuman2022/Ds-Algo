/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static ArrayList<String> ans ;  
	public static void main (String[] args) {
		//code
		Scanner sc =  new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		
		while(T-- > 0){
		    int n = sc.nextInt() ;
		    ans = new ArrayList<String>() ;
		    if(n == 3 || n == 2)
		      {
		          System.out.println(-1) ; 
		          continue ;
		      }
            getAllQueensPlaces(0,n, "[", new int[n][n]) ;
            for(String s : ans)
            System.out.print(s+" ") ;
            System.out.println() ;
		}
	}
	
	
	static void getAllQueensPlaces(int currRow, int n , String combn, int board[][]){
	   ;
	         if(currRow >= n){
	             ans.add(combn+"]") ;
	             return ;
	         }
	          
	          
	        for(int col = 0 ; col < n ; col++){  
	         
	         if(canPlaceQ(board, col, currRow, n)){
	             board[currRow][col] = 1 ; 
	             getAllQueensPlaces(currRow + 1, n , combn+(col+1)+" ", board) ;
	             board[currRow][col] = 0 ; 
	         }
	         
	        }
	}
	
	static boolean canPlaceQ(int board[][], int currCol , int currRow, int n){
	    // can we place our queen in curr cell 
	    // we neee to check all eight directions 
	    
	    
	    //4 diagonals 
	    
	    //i - 1 , j + 1 
	    int i = currRow - 1 ; 
	    int j = currCol + 1 ;
	    
	    while(i >= 0 && j < n){
	        if(board[i][j] == 1)
	          return false ;
	          i--  ; 
	          j++ ;
	    }
	    //i - 1 , j - 1
	    
	    i = currRow - 1 ; 
	    j = currCol - 1 ;
	    
	    while(i >= 0 && j >= 0){
	        if(board[i][j] == 1)
	         return false ; 
	         i-- ; 
	         j-- ;
	    }
	    
	    // i + 1 , j - 1
	    
	    i = currRow + 1 ; 
	    j = currCol - 1 ; 
	    
	    while(i < n  && j >= 0){
	        if(board[i][j] == 1)
	         return false ;
	         i++ ; 
	         j-- ;
	    }
	    
	    // i + 1, j + 1 
	    
	    i = currRow + 1 ;
	    j = currCol + 1 ;
	    
	    while(i < n && j < n){
	        if(board[i][j] == 1)
	          return false ; 
	          i++ ;
	          j++ ;
	    }
	    
	    // i - 1, j  up
	    
	    i = currRow - 1 ; 
	    j = currCol ; 
	    while(i >= 0){
	        if(board[i][j] == 1)
	         return false ; 
	         i-- ;
	    }
	    //i + 1, j down 
	    
	    i = currRow + 1 ; 
	    
	    while(i < n){
	        if(board[i][j] == 1)
	          return false ;
	          i++ ; 
	    }
	    
	    // i , j - 1 , left
	    i = currRow ;
	    j = currCol - 1 ;
	    
	    while(j >= 0){
	        if(board[i][j] == 1)
	          return false ; 
	          j-- ;
	    }
	    
	    // i , j + 1 , right
	    j = currCol + 1 ; 
	    while(j < n){
	        if(board[i][j] == 1)
	          return false ;
	          j++ ;
	    }
	    return true ;
	}
	
}
