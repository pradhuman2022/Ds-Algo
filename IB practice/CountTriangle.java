public class Solution {
    public int nTriang(int[] A) {
        int n = A.length ; 
        int ans = 0 ;
        java.util.Arrays.sort(A) ;
        int mod = (int) Math.pow(10, 9) + 7 ;
        for(int i = 0 ; i < n ;i++)
        {
            int k = i + 2 ;
            for(int j = i + 1 ; j < n ; j++)
             {
                  ruko : for(; k < n && A[i] + A[j] > A[k] ; k++)
                  {
                        ans += (k - j) ;
                    }
                  ans %= mod ;
             }
        }
        return ans ;
        
    }
}
