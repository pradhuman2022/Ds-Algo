Return subset of an array
Send Feedback
Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :

Line 1 : Size of array

Line 2 : Array elements (separated by space)

Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12 
Download Test Cases

Main Code

public class solution {
	public static void printSubsets(int input[]) {
		// Write your code here
        int n = input.length ;
        int comp = (int) Math.pow(2, n) - 1 ;
        
      int subset[][] = new int [comp][] ; 
      
      subsets(input ,0 , subset);
      
      for(int i = 0; i< subset.length; i++)
      {
        for(int j = 0 ; j < subset[i].length ; j++)
        {
          System.out.print(subset[i][j]+ " ") ;
        }
        System.out.println();
      }
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
      
      int j = 0;
      for(; j < out[i].length ; j++)
      {
        out[c][j] = out[i][j] ;
        
      }
      out[c][j] = input[start] ;
      c++ ;
    }
    
    getSizeOfOut = c ;
       return c;
  }
}
