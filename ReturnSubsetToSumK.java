/*
Problem
Result
Return subsets sum to K
Send Feedback
Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K 
Constraints :
1 <= n <= 20
Sample Input :
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1

*/

import java.util.*;
public class solution {

	// Return a 2D array that contains all the subsets which sum to k
	public static int[][] subsetsSumK(int input[], int k) {
		// Write your code here
       
     int n = input.length ;
        int comp = (int) Math.pow(2, n) - 1 ;
        
      int subset[][] = new int [comp][] ; 
       
      subsets(input, subset, 0) ;
     ArrayList<ArrayList<Integer>> sub1 = new ArrayList <>() ;
      
      for(int i = 0; i< subset.length; i++)
      {
        int sum = 0;
        for(int j = 0 ; j < subset[i].length ; j++)
        {
           sum = sum + subset[i][j] ;
         }
        if(sum == k)
        {
          ArrayList<Integer> temp = new ArrayList<>() ;
          for(int k1 = 0; k1 < subset[i].length ; k1++) 
          temp.add(subset[i][k1]) ;
          
          sub1.add(temp) ;
        }  
        
      }
      int subset1[][] = new int[sub1.size()][] ;
      for(int i = 0 ; i < sub1.size() ; i++)
      {
        ArrayList <Integer> temp = sub1.get(i);
        subset1[i] = new int[temp.size()] ;
        for(int j = 0 ; j < temp.size() ; j ++)
        {
          subset1[i][j] = temp.get(j) ; 
        }
        
        
      }
      
      
      return subset1 ;
	}
  
  
  
  
          static int subsets(int input [], int [][] out, int start)
  {
    if( start == input.length - 1)
    {  
      out[0] = new int [1] ;
      out[0][0] = input[start] ; 
      return 1 ;
   }
    
    int getSizeOfOut = subsets(input, out , start+1) ;
    
     int c = getSizeOfOut + 1 ;
    out[getSizeOfOut] = new int[1] ;
    out[getSizeOfOut][0] = input[start] ; 
     
  
    for(int i = 0; i < getSizeOfOut; i++)
    {
      
      out[c] = new int[out[i].length + 1] ;
      
      out[c][0] = input[start] ;
      for(int j = 0; j < out[i].length ; j++)
      {
        out[c][j + 1] = out[i][j] ;
        
      }
    //  out[c][j] = input[start] ;
      c++ ;
    }
    
    getSizeOfOut = c ;
       return c;
  }
}
