/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    static String s1 ;
    static String s2 ;
    static int n ;
    static int m ;
    static int k ;
	public static void main (String[] args) {
	    s1 = "aggasdfa"; 
        s2 = "aggajasdfa";
        n = s1.length();
        m = s2.length();
        k = 4 ;
        System.out.println(len(0, 0)); 
	}
	static int len(int i, int j) {
	    
	    if(i == n || j == m)
	        return 0 ;
	    //first we find common length starting from i and j   
	    int commonLength = 0 ; 
	    for(int l = i, p = j; l < n && p < m; l++, p++) {
	        if(s1.charAt(l) == s2.charAt(p)) {
	            commonLength++;  
	        }
	    }
	    int ans = 0;
	    /*if common length is equal and greater than k , then there may be chance that,
	    if we don't include i + k, j + k to current consecutive seuquence so we will try find 
	    all possiblities.
	    */
	    if(commonLength >= k) {
	     for(int l = k; l <= commonLength; l++){
	       ans = Math.max(ans, len(l + i, l + j) + l);
	     }
	    }else {
	        /*if commonLength is less than k then we need to check for i + 1, j and i, j + 1
	        as same as lcs.*/
	        ans = Math.max(len(i + 1, j) , len(i , j + 1));     
	    }
	    return ans; 
	}
}
