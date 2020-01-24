/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		while(T-->0)
		 {
		     int coins = sc.nextInt() ;
		     int coin[] = new int[coins] ;
		     for(int i= 0 ; i < coin.length ; i++)
		       coin[i] = sc.nextInt() ; 
		  
		     int cents = sc.nextInt() ; 
		     int tab[] = new int[cents + 1] ; 
		     tab[0] = 1 ; //if n is 0 then we will have only one combination
		     
		     //for every coin, we will check combination if we include that coin in combination.....
		     //tab[j] is nothing but a combination of ways to make j if we use ith coin.
		     for(int i = 0 ; i < coins; i++)
		      {
		           for(int j = coin[i] ; j <= cents ; j++)
		             tab[j] += tab[j - coin[i]] ;
		      }
		     
		     System.out.println(tab[cents]) ;
		 }
	}
	
     //iterative
    
}
