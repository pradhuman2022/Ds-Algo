import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    
	    while(T-->0){
	        int n = sc.nextInt();
	        int arr[] = new int[n] ;
	        
	        for(int i = 0 ; i < n; i++)
	            arr[i] = sc.nextInt();
	        System.out.println(getMinChanges(arr, n));
	    }
	 }
	 
	 static int getMinChanges(int arr[], int n){
	     
	     int Lis[] = new int[n] ; 
	     
	     for(int i = 0; i < n; i++){
	         Lis[i] = 1 ; 
	         for(int j = i - 1; j >= 0; j--)
	            if(arr[i] > arr[j] && (i-j) <= (arr[i]-arr[j])) // if differnce between arr[i] and arr[j] is not greater the
	                Lis[i] = Math.max(Lis[i], Lis[j] + 1); // no of elements present bretween i and j so we cannt take this in Lis.
	     }
	     int maxLis = Integer.MIN_VALUE ;
	     
	     for(int lis : Lis)
	        maxLis = Math.max(maxLis, lis) ; 
	       
	     return n - maxLis ; 
	     
	 }
}
