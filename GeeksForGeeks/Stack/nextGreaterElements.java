/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		while(T--> 0)
		{
		    int n = sc.nextInt() ; 
		    long arr[] = new long[n] ; 
		    for(int i = 0 ; i < n ; i++)
		     arr[i] = sc.nextInt() ; 
		    for(long x : getNextGreater(arr, n))
		       System.out.print(x+" ") ;
		    System.out.println() ;     
		}
	}
	 
	static long [] getNextGreater(long arr[], int n)
	{
	         long ans[] = new long[n] ; 
	         Stack<Integer> st = new Stack<Integer>() ; 
	         st.push(0) ; 
	         
	         for(int i = 1 ; i < n; i++)
	         {
	                  if(st.isEmpty())
	                    continue ;
	                  
	                  while(!st.isEmpty() && arr[i] > arr[st.peek()])
	                  {
	                            ans[st.pop()] = arr[i] ;
	                  }
	                  
	                  st.push(i);
	         }
	         
	         while(!st.isEmpty())
	         {
	             ans[st.pop()] = -1 ; 
	         }
	         return ans ;
	}
	
}
