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
	        for (int i = 0; i < n; i++)
	            arr[i] = sc.nextInt();
	        System.out.println(minimumStepsToSort(arr, n));
	    }
	 }/*
    muje LIS ka ye variation ni dikha tha ki lis nikal lo to baki sbko SORT krdo 
    to fr jo lis ayga usko array length se minus krdo jisse baki bache elements ko sort krna pdega isliy.
   */
	 public static int minimumStepsToSort(int arr[], int n) {
	     int lis[] = new int[n]; 
	     int max = 1; 
	     for(int i = 0; i < n; i++) {
	         lis[i] = 1;
	         for(int j = 0; j < i; j++) {
	             if(arr[i] >= arr[j])
	                lis[i] = Math.max(lis[j] + 1, lis[i]);
	         }
	         max = Math.max(lis[i], max) ; 
	     }
	     return n - max; 
	 }
}
