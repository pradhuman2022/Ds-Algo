class GFG  
{  
//this is just include and exclude type question.      
static int maxRevenue(int m, int[] x, int[] revenue, int n, int t)  
{  
   int dp[] = new int[m + 1] ; 
   int billBoard = 0; 
   for(int i = 1; i <= m; i++) {
       //if i <= t then we will look for f(i - 1) ans else f(i - t - 1)
       if(billBoard < n) {
           
       if(x[billBoard] != i) {
           dp[i] = dp[i - 1]; 
       }else {       
       if(i <= t)
        dp[i] = Math.max(revenue[billBoard], dp[i - 1]) ; 
      else 
        dp[i] = Math.max(revenue[billBoard] + dp[i - t - 1], dp[i - 1]) ; 
      billBoard++; 
       }
       }else{
           dp[i] = dp[i - 1]; 
       }
      
    }
  return dp[m];  
}  
  
// Driver Code 
public static void main(String []args)  
{  
    int m = 20;  
    int[] x = new int[]{6, 7, 12, 13, 14};  
    int[] revenue = new int[]{5, 6, 5, 3, 1};  
    int n = x.length;  
    int t = 5;  
    System.out.println(maxRevenue(m, x, revenue, n, t));  
} 
} 
  
