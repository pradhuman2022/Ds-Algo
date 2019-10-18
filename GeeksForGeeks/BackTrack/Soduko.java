/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ;
		int soduko[][] ;
		while(T-- > 0){
		    soduko = new int[9][9] ;
		    for(int i = 0 ; i < 9 ; i++){
		        for(int j = 0 ; j < 9 ; j++){
		            soduko[i][j] = sc.nextInt();
		        }
		    }
	      if(sodukoSolver(soduko)) 
	      {
		   for(int row[] : soduko){
		       for(int x : row)
		        System.out.print(x+" ");
		   } 
		   System.out.println();  
		 }else
		     System.out.println("Not Possible") ;
		 
		}
	}
	
	public static boolean sodukoSolver(int sodukoBoard[][]){
	    
	    int pos[] = new int[2] ;
	    
	    if(!findPosition(sodukoBoard, pos))
	    {
	         return true ;
	    }
	    
	    for(int i = 1 ; i <= 9 ; i++){
	        
	           if(valid(sodukoBoard, i, pos[0], pos[1])){
	               
	               sodukoBoard[pos[0]][pos[1]] = i ; 
	               
	               if(sodukoSolver(sodukoBoard))
	                 return true ;
	               
	               sodukoBoard[pos[0]][pos[1]] = 0 ;
	           }
	    }
	    return false ;
	}
	
	public static boolean findPosition(int sodukoBoard[][], int pos[]){
	    
	        for(int i = 0 ; i < 9 ; i++){
	            for(int j = 0 ; j <9 ; j++){
	               if(sodukoBoard[i][j] == 0)
	               {
	                   pos[0] = i ; 
	                   pos[1] = j ;
	                   return true ;
	               }
	            }
	        }
	        return false ;
	}
	
	public static boolean valid(int sodukoBoard[][], int value , int currRow, int currCol){
	    
	    //find in row 
	    for(int i = 0 ; i < 9; i++){
	        if(sodukoBoard[currRow][i] == value)
	         return false  ;
	    }
	      
	  // find in col
	    for(int i = 0 ; i < 9; i++){
	        if(sodukoBoard[i][currCol] == value)
	         return false ;
	    }
	  
	 //find  3 x 3 grid      
       currRow = currRow - (currRow % 3) ;
       currCol = currCol - (currCol % 3) ;
       
       for(int i = 0 ; i < 3 ;i++){
           for(int j = 0 ; j < 3 ; j++){
               if(sodukoBoard[currRow + i][currCol + j] == value)
                  return false; 
           }
       }
	    return true ;
	}
}
