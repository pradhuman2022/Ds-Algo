public class Solution {
    public long solve(int[] A, int B) {
         long hr [] = new long[B + 1] ;
        int n = A.length ;
        for(int i = 0 ; i < n ; i++)
        {
            ++hr[A[i] % B] ;
        }
        long pairs = 0 ;
        int mod = (int)Math.pow(10, 9) + 7 ;
        pairs = (hr[0] * (hr[0] - 1)) / 2 ; 
        for(int i = 1 ; i < B / 2 ; i++)
        {
            pairs = (pairs + (hr[i] * hr[B - i])) ;
            while(pairs >= mod)
             pairs -= mod ;
        }
        
        if((B) % 2 == 0)
        {
            pairs = (pairs + ((hr[B / 2] - 1) * hr[B / 2]) / 2 )  ;
             while(pairs >= mod)
             pairs -= mod ;
        }else 
        {
         pairs = (pairs + ((hr[B / 2]) * hr[(B / 2) + 1])) ; 
          while(pairs >= mod)
             pairs -= mod ;
        }
        return pairs ;
        
    }
}
