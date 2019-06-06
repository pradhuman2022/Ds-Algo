public class Solution {
    public long divide(int A, int B) {
        long ans = 0 ;
        long remainder = 0 ;
        int sign = 1 ;
        if(B == 1)
         return A ;
       
       
        if(A < 0 && B > 0 || A > 0 && B < 0)
         {
             sign = -1 ;
         }
          long a = Math.abs((long)A) ;
          long b=  Math.abs((long)B);
        for(int i = 31 ; i >= 0; i--)
        {
             if((b << i) + remainder <= a)
             {
                 remainder += b << i ;
                 ans |= (1L << i) ;
             }
        }
        if(ans * sign > Integer.MAX_VALUE)
         return Integer.MAX_VALUE ;
        else 
         return ans * sign ;
    }
}
