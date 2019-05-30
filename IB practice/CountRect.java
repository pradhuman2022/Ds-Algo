public class Solution {
    public int solve(int[] A, int B) {
        int left = 0 ; 
        int right = A.length - 1 ;
        int ans = 0;
        int mod = (int)Math.pow(10, 9) + 7 ;
        while(left != right)
        {
            if(A[left] * A[right] >= B)
              right-- ;
            else
            {
                ans = ((ans % mod)+ ((2 *(right - left + 1)) - 1) % mod) % mod ;
                left++ ;
            }
        }
        if(A[left] *A[right] < B)
        ans += 1 ;
        return ans % mod ;
    }
}
