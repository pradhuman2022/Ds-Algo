/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
	
	    Scanner sc = new Scanner(System.in);
	    
	    int n = sc.nextInt();
	    int arr[] = new int[n]; 
	    for(int i = 0; i < n; i++)
	        arr[i] = sc.nextInt();
	    printLongestAlternatingIndex(arr, n);
	}
	static void printLongestAlternatingIndex(int arr[], int n){
	
	    int count[] = new int[n];
	    
	    count[0] = 1; 
	    for(int i = 1; i < n; i++){
	            count[i] = 1;
	            if(arr[i] * arr[i - 1] < 0)
	                count[i] = count[i - 1] + 1 ;
	    }
	    
	    for(int cnt : count)
	        System.out.println(cnt);
	}
}
