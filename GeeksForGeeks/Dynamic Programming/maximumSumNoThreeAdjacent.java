import java.io.*;
import java.util.* ; 

class GFG {
	public static void main (String[] args) {
	   Scanner sc = new Scanner(System.in); 
	   int n = sc.nextInt() ; 
	   int arr[] = new int[n] ;
	    
	   for(int i = 0 ; i < n; i++)
	    arr[i] = sc.nextInt() ; 
	   
	   System.out.println(getMaximumSum(arr, n)) ;   
	}
	static int getMaximumSum(int arr[], int n){
	    int sum[] = new int[n] ; 
	    
	    if (n >= 1) 
        sum[0] = arr[0]; 
  
        if (n >= 2) 
        sum[1] = arr[0] + arr[1]; 
  
        if (n > 2) 
        sum[2] = max(sum[1], max(arr[1] + arr[2], arr[0] + arr[2])); 
  
	    for(int i = 3; i < n; i++)
	     {
	         sum[i] = Math.max(sum[i - 1], Math.max(sum[i - 3] + arr[i] + arr[i - 1], arr[i] + sum[i - 2]) ; 
	     }
	     
	   return sum[n - 1]; 
	}
}
