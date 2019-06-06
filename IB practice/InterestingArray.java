public class Solution {
    public String solve(int[] A) {
        int odd = 0 ; 
        for(int i = 0 ; i < A.length; i++)
        {
            if(A[i] % 2 == 1) 
            {
                odd++ ;
            }
        }
        if(odd % 2 == 0)
        {
            return "Yes" ;
        }else
          return "No" ;
    }
}
