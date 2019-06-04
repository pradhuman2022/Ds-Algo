import java.util.* ;
public class Solution {
    public int solve(int[] A, int cows) {
        Arrays.sort(A) ;
        int low = Integer.MAX_VALUE ;
        for(int i = 1 ; i < A.length ; i++)
        {
            low = Math.min(low, A[i] - A[i - 1]) ;
        }
        int high = A[A.length - 1] - A[0] ;
        int ans = Integer.MIN_VALUE ;
        while(low <= high)
        {
            int mid = (low + high) / 2 ;
            if(isPossible(A, mid, cows))
            {
            ans = Math.max(ans, mid) ;
            low = mid  + 1;
            }else
            {
                high = mid -  1 ;
            }
        }
        return ans;
    }
    public static boolean isPossible(int A[], int dist, int cows)
    {
        int currentCows = 1 ;
        int currentPlace = A[0] ;
        for(int i = 1 ; i < A.length ; i++)
        {
            if(A[i] - currentPlace >= dist)
             {
                 currentCows++ ;
                 currentPlace = A[i] ;
             }
        }
        if(currentCows >= cows) 
         return true ; 
        else 
          return false ;
    }
}
