/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
	
	   int mat[][] = {{1,2,3},{2,3,1},{1,1,1}};
	   Pair [] p = new Pair[mat.length * mat[0].length] ;
	   int index = 0 ;
	   for(int i = 0 ; i < mat.length; i++) {
	       for(int j = 0; j < mat[0].length; j++) {
	           p[index++] = new Pair(i, j, mat[i][j]) ; 
	       }
	   }
	   
	   Arrays.sort(p, new Comparator<Pair>(){
	       public int compare(Pair p1, Pair p2) {
	           return p2.data.compareTo(p1.data);
	       }
	   });
	   
	   boolean visited[][] = new boolean[mat.length][mat[0].length] ; 
	   
	   for(int i = 0; i < p.length; i++) {
	       if(!visited[p[i].row][p[i].col]) {
	           System.out.println(p[i].row+" "+p[i].col) ; 
	           dfs(p[i].col, p[i].row, mat, visited, mat.length, mat[0].length) ;
	       }
	   }
	}
	
   static void dfs(int col, int row, int mat[][], boolean visited[][], int rowBound, int colBound) {
	    visited[row][col] = true;
	    
	    if(col + 1 < colBound && !visited[row][col + 1] && mat[row][col + 1] <= mat[row][col])
	        dfs(col + 1, row, mat, visited, rowBound, colBound);
	   
	    if(row + 1 < rowBound && !visited[row + 1][col] && mat[row + 1][col] <= mat[row][col])
	        dfs(col, row + 1, mat, visited, rowBound, colBound);
	        
	    if(row - 1 >= 0 && !visited[row - 1][col] && mat[row - 1][col] <= mat[row][col])
	        dfs(col, row - 1, mat, visited, rowBound, colBound);
	    
	    if(col - 1 >= 0 && !visited[row][col - 1] && mat[row][col - 1] <= mat[row][col])
	        dfs(col - 1, row, mat, visited, rowBound, colBound);
	}
	
	static class Pair {
	    int row;
	    int col;
	    Integer data;
	    
	    Pair(int row, int col, Integer data) {
	        this.row = row;
	        this.col = col;
	        this.data = data;
	    }
	}
}
