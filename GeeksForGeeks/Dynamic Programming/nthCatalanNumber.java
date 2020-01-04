/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		long catalanNumber[] = new long[101] ; 
		
		catalanNumber[1] = 1 ; 
		catalanNumber[0] = 1 ;
		for(int i = 2 ; i <= 100 ; i++){
		    
		    for(int j = 0; j < i; j++)
		      catalanNumber[i] += catalanNumber[j] * catalanNumber[i - j - 1] ;
		}
		
		while(T-->0){
		    int n = sc.nextInt(); 
		    System.out.println(catalanNumber[n]) ;
		}
	}
}
