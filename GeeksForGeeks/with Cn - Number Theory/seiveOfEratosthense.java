/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ;
		int T = sc.nextInt() ; 
		
		while(T-- > 0){
		    int n = sc.nextInt() ;
		    boolean prime[] = new boolean[n + 1] ;
		    for(int i = 2 ; i <= n ; i++)
		     prime[i] = true ; 
		    
		    getPrimesUsingEratosthenes(prime, n) ; 
		     
		     for(int i = 0 ; i <= n ; i++)
		       if(prime[i])
		         System.out.print(i+" ");
		     
		     System.out.println() ;
		}
	}
	
	 static boolean checkPrime(int n){
	     int count = 0 ; 
	     
	     for(int i = 1 ; i <= (int)Math.sqrt(n); i++) {
	       
	       if(n % i == 0){    
	           if(i % i == n)
	            count++ ;
	           else
	            count += 2 ; 
	       }
	     }
	      if(count == 2)
	        return true ; 
	        
	     return false;  
	 }
	
	 static void getPrimesUsingEratosthenes(boolean prime[], int n){
	     
	        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
	            
	            if(!prime[i]) //if calculated already 
	              continue ;
	            
	            if(checkPrime(i)){
	            int k = i  ; 
	            for(int j = i * i ; j <= n ;){
	                //System.out.println(j+" "+i);
	                prime[j] = false ; 
	                j = i * (k++) ;
	            }
	        }
	        }
	     
	 }
}
