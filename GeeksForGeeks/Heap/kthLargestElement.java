/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		while(T-- >0)
		{
		    int k = sc.nextInt() ;
		    int n = sc.nextInt() ;
		    int arr[] = new int[n] ; 
		    for(int i = 0 ; i < n ; i++)
		    arr[i] = sc.nextInt() ;
		    for(int x : getAns(arr, k ,n))
		    System.out.print(x+" ");
		    System.out.println() ;
		}
	}
	static int[]getAns(int arr[], int k , int n)
	{
	   Queue<Integer> pq = new PriorityQueue<Integer>((a, b)-> a-b);
	   
	   int ans []= new int[n];
	   
	   for(int i = 0 ; i <= k - 2 ; i++)
	   {
	       pq.add(arr[i]);
	       ans[i] = -1 ;
	   }
	   pq.add(arr[k - 1]);
	   ans[k - 1] = pq.peek();
	   
	   
	   for(int i = k ; i < n ;i++)
	   {
	       if(pq.peek() < arr[i])
	         {
	             pq.poll();
	             pq.add(arr[i]);
	             ans[i] = pq.peek();
	         }else
	         {
	             ans[i] = pq.peek();
	         }
	   }
	   return ans ;
	   
	}
}
