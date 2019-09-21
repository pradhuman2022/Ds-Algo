import java.util.* ;
class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int mat[][] = new int[n][m];
		    int dp[][] = new int[n][m];
		    for(int i = 0; i < n ; i++)
		    {
		        for(int j = 0; j < m ; j++)
		        {
		            dp[i][j] = -1;
		            mat[i][j] = sc.nextInt();
		        }
		    }
		    //int rowPos = -1;
		    //int colPos = 0; 
		    int goldAmt = Integer.MIN_VALUE;
		    
		    for(int i = 0; i<n ; i++)
		    {
                goldAmt = Math.max(goldAmt,getMax(i, 0, mat, n - 1, m - 1, dp));    		        

		    }
		    System.out.println(goldAmt);
		}
	}
	     static int getMax(int rpos, int cpos, int mat[][], int n , int m , int dp[][])
	     {
	            if(rpos > n || cpos > m || rpos < 0)
	               return 0;
	            if(cpos == m)
	              return mat[rpos][m] ;
	             
	             if(dp[rpos][cpos] != -1)
	               return dp[rpos][cpos];
	             
	             int right = getMax(rpos, cpos + 1, mat, n, m, dp) + mat[rpos][cpos];
	             int rightUp = getMax(rpos - 1, cpos + 1, mat ,n ,m , dp) + mat[rpos][cpos];
	             int rightDown = getMax(rpos + 1, cpos + 1, mat , n , m , dp) + mat[rpos][cpos];
	             int ans = Math.max(right,Math.max(rightUp, rightDown));
	             return dp[rpos][cpos] = ans;
	     }
}
