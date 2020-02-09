/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-->0){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    
		    sc.nextLine();
		    String s[] = sc.nextLine().split(" ");
		    String str1 = s[0];
		    String str2 = s[1];
		    System.out.println(getMinStepToConvertStr(n, m, str1, str2)) ;
		}
	}
	static int getMinStepToConvertStr(int n, int m, String str1, String str2){
	    
	    int dp[][] = new int[n + 2][m + 2] ; 
	    
	    
	    int col = 1 ; 
	    for(int j = m ; j >= 0 ; j--)
	        dp[n + 1][j] = col++; 
          
	    int row = 1;    
	    for(int i = n ; i >= 0; i--)
	        dp[i][m + 1] =  row++;
	    
	    for(int i = n; i >= 1; i--){
	        for(int j = m; j >= 1; j--){
	            if(str1.charAt(i - 1) == str2.charAt(j - 1)) 
	                dp[i][j] = dp[i + 1][j + 1] ; 
	            else
	                dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i][j + 1], dp[i + 1][j]));
	        }
	    }
      
	    /*for(int i = 1; i <= n + 1; i++){
	        System.out.println("row"+i+"num");
	        for(int j = 1; j <= m + 1; j++)
	         System.out.print(dp[i][j]+" ");
	         
	         System.out.println();
	    }
	    System.out.println((str1.charAt(5) == str2.charAt(4))+" "+str1.charAt(5)+" "+str2.charAt(4));
	    */
      
	    return dp[1][1] ; 
	}
}
