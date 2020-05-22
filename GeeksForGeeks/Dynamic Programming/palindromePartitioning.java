import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static String str;
    static int dp[][];
    boolean isPalindrome[][]; 
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
  
	public static void main (String[] args)
	 {
	 //code
	    FastReader sc = new FastReader();
	    int testCases = sc.nextInt();
	    while(testCases-->0){
	        str = sc.nextLine();
	        dp = new int[str.length()][str.length()];
	        for(int a[] : dp)
	            Arrays.fill(a, -1);
	        isPalindrome = new boolean[str.length()][str.length()];
	        isPalindromePresent(0, str.length() - 1);
	        System.out.println(minCuts(0, str.length() - 1));
	    }
	 }
	 public static int minCuts(int i, int j) {
	     
	     if(i == j || isPalindrome[i][j])
	        return 0;
	     if(dp[i][j] != -1)
	        return dp[i][j];
	     int min = Integer.MAX_VALUE;
	     for(int k = i; k < j; k++) {
	        min = Math.min(min, minCuts(i, k) + 1 + minCuts(k + 1, j));   
	     }
	     return dp[i][j] = min;
	 }
}
