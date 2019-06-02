public class Solution {
    public int solve(int[] A, int B) {
        int left = 0 ; 
        int n = A.length ;
        int right = n - 1 ;
        int ans = 0 ;
        while(left < right)
        {
            if(A[left] + A[right] < B)
                left++ ;
                
            else if(A[left] + A[right] == B)
           {  
              ans += 1 ;
              left++ ;
              right--;
           }
            else
                right-- ;
            
        }
        return ans ;
    }
}
