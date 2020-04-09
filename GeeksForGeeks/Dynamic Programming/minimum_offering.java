import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0) {
	        int N = sc.nextInt();
	        int arr[] = new int[N];
	        for(int i =0; i < N; i++)
	            arr[i] = sc.nextInt();
	        System.out.println(minimumOffering(arr, N));
	    }
	 }
	 static int minimumOffering(int arr[], int N) {
	     int left[] = new int[N];
	     int right[] = new int[N] ;
	     left[0] = 1; 
	     for(int i = 1; i < N; i++)
	        if(arr[i] > arr[i - 1])
	            left[i] = left[i - 1] + 1;
	        else 
	            left[i] = 1;

	     right[N - 1] = 1; 
	     for(int i = N - 2; i >= 0; i--)
	        if(arr[i] > arr[i + 1])
	            right[i] = right[i + 1] + 1; 
	        else
	            right[i] = 1;
	    int min_offers = 0 ;
	    for(int i = 0 ; i < N; i++)
	        min_offers += Math.max(left[i], right[i]) ;
        return min_offers; 
	 }
}
