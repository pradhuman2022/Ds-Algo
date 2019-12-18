/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		HashSet<Integer> hs  ; 
		int arr[] ; 
		boolean visited[] ; 
		while(T-- > 0){
		    int n = sc.nextInt() ; 
		    arr = new int[n] ; 
		    hs = new HashSet<>() ; 
		    visited = new boolean[100001] ; 
		    int ans = Integer.MIN_VALUE ;
 		    for(int i = 0 ; i < n ; i++)
		    {
		        arr[i] = sc.nextInt() ; 
		        hs.add(arr[i]) ;
		    }
		    
		    for(int i =  0 ; i < n ; i++){
		        
		      if (!hs.contains(arr[i]-1)) 
            { 
                // Then check for next elements in the 
                // sequence 
                int j = arr[i]; 
                while (hs.contains(j)) 
                    j++; 
  
                // update  optimal length if this length 
                // is more 
                if (ans<j-arr[i]) 
                    ans = j-arr[i]; 
            } 
		    }
		     System.out.println(ans == Integer.MIN_VALUE ? 1 : ans) ; 
		}
	}
}
