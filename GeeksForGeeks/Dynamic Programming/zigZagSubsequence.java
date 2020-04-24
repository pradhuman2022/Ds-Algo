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
	        int n = sc.nextInt();
	        int arr[] = new int[n]; 
	        for(int i = 0; i < n; i++)
	            arr[i] = sc.nextInt();
	        System.out.println(printLongestAlternate(arr, n)); 
	    }   
	 }
	 static int printLongestAlternate(int arr[], int n) {
	    int inc[] = new int[n];
	    int dec[] = new int[n];
	    
	    for (int i = 0; i < n; i++){
	        inc[i] = 1;
	        dec[i] = 1;
	        for(int j = 0; j < i; j++) {
	            if(arr[i] > arr[j])
	                inc[i] = Math.max(inc[i], dec[j] + 1);
	            if(arr[i] < arr[j])
	                dec[i] = Math.max(dec[i], inc[j] + 1);
	        }
	    }
	    int longestSequence = 1 ;
	    for(int i = 0; i < n; i++)
	        longestSequence = Math.max(longestSequence, Math.max(inc[i], dec[i]));
	    return longestSequence;
    }
}
