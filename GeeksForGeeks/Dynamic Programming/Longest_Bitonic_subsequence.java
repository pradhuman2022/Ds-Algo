/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String arg[])
	{
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt() ;
	    while(T-->0)
	    {
	    	int n = sc.nextInt() ;
	    	int arr[] = new int[n] ;
	    	for(int i = 0 ; i < n ; i++)
	    		 arr[i] = sc.nextInt() ; 
	    	System.out.println(longestIncDescSub(arr, n)) ; 
	    }
		
	}
	
	static int longestIncDescSub(int arr[], int n)
	{
	//	int ans = Integer.MIN_VALUE ;
		int inc[] = new int[n] ; 
		int desc[] = new int[n] ;
	    inc[0] = 1 ;
	    desc[n - 1] = 1 ;
	    // for inc
	    int maxInc = Integer.MIN_VALUE ;
	    for(int i = 1; i < n ; i++)
	    {  
	    	int currLen = 1 ; 
	    	for(int j = i - 1; j >= 0; j--)
	    	{
	    		if(arr[i] > arr[j])
	    			currLen = Math.max(currLen, inc[j] + 1) ;
	    		
	    		   
	    	}
	    	inc[i] = currLen ;
	    	maxInc = Math.max(maxInc, inc[i]) ;
	    }
	    //desc 
	    int maxDesc = Integer.MIN_VALUE ;
	    for(int i = n - 2 ; i >= 0 ; i--)
	    {
	    	int currLen = 1 ;
	    	for(int j = i + 1 ; j < n; j++)
	    	{
	    		if(arr[i] > arr[j])
	    			currLen = Math.max(currLen, desc[j] + 1) ;
	    	}
	    	desc[i] = currLen ; 
	    	maxDesc = Math.max(maxDesc, desc[i]) ;
	    }
	    int ans = Integer.MIN_VALUE ;
	    for(int i =0 ; i < n ; i++)
	    {
	        ans = Math.max(inc[i] + desc[i] - 1, ans) ; 
	    }
	    return ans; 
	}
	

}
