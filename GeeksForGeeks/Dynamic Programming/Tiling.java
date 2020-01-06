/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		long tile[] = new long[71] ; 
		fillTiles(tile) ;
		while(T-->0){
		    int n = sc.nextInt() ; 
		    System.out.println(tile[n]) ; 
		}
	}
	
	static void fillTiles(long tile[]){
	    int W = 71 ; 
	    tile[1] = 1 ; 
	    tile[2] = 2 ;
	    for(int i = 3 ; i < W ; i++)
	     tile[i] = tile[i - 1] + tile[i - 2] ;
	}
}
