public class Solution {
    public int solve(int[] A) {
        int low = 0 ; 
        int high = A.length -1 ;
        int ans = -1;
        while(low <= high)
        {
            int mid = (low + high) / 2 ;
            if(mid > 0 && mid < A.length - 1)
            {
                  if(A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1])
                    {
                        ans =  A[mid] ;
                        break ;
                    }
                  int max = Math.max(A[mid + 1], A[mid - 1]) ; 
                  if(A[mid + 1] == max)
                    low = mid + 1 ;
                  else
                    high = mid - 1 ;
            }
            else if(mid == 0)
            {
                if(A[mid] >= A[mid + 1])
                 {
                     ans = A[mid] ;
                     break ;
                 }
                // else return - 1 ;
            }else //(mid == A.length - 1)
            {
                if(A[mid] >= A[mid - 1])
                 {
                     ans = A[mid] ;
                     break ;
                 }
                //else return -1 ; 
            }
        }
        return ans ;
    }
}
