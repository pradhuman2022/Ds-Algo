/*package whatever //do not write package name here */

import java.util.*;

public class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		long n = sc.nextLong() ; 
		long s = sc.nextLong() ; 
		
		long endPoint = -1 ; 
		long start = 0L ; 
		long end = n ;
		
		while(start <= end){
		    long mid = (start + end) / 2 ; 
		    
		    if(calc(mid) >= s)
		     {
		         endPoint = mid ; 
		         end = mid - 1; 
		     }else{
		         start = mid + 1 ; 
		     }
		}
		if(endPoint != -1)
		 System.out.println(n - endPoint + 1) ; 
		else 
		 System.out.println(0) ; 
	}
	
	static long calc(long mid){
	    long cal = mid ; 
	    long sum = 0 ; 
	    while(cal > 0){
	        sum += cal % 10 ; 
	        cal /= 10  ;
	    }
	    return mid - sum ; 
	}
}
