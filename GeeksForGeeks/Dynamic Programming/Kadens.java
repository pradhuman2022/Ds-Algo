import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)throws IOException
	 {
	 //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n =Integer.parseInt(br.readLine());
            int[] a = new int[n];
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(strs[i]);
            }	        
	    System.out.println(largestContigousSum(n, a));     
	 }
	 
	 }
	 
	 static int largestContigousSum(int n, int arr[]){
	     int dp[] = new int[n];
	     int ans = arr[0];
	     dp[0] = arr[0] ;
	     for(int i = 1; i < n; i++){
	        
	        dp[i] = Math.max(dp[i - 1], 0) + arr[i] ;
	        ans = Math.max(dp[i], ans);
	     }
	  
	    return ans ;
	 }
}
