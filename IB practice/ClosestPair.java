public class Solution {
      
    public int[] solve(int[] A, int[] B, int C) {
        int i = 0 ;
        int j = B.length - 1  ;
        int currentMin = Integer.MAX_VALUE ;
        int currentI = 0 ; 
        int currentJ = 0 ;
        
        while(i < A.length  && j >= 0)
        {
           int exp = Math.abs(A[i] + B[j] - C) ;
           //cureentMin = Math.min(currentMin, exp) ;
           if(currentMin > exp)
           {
               currentI = i  ;
               currentJ = j ;
               currentMin = exp ;
           }
           if(currentMin == exp)
           {
               if(currentI == i)
               {
                   currentJ = Math.min(currentJ, j) ;
               }else if(currentJ == j)
               {
                   currentI = Math.min(currentI, i) ;
               }
           }
           if(A[i] + B[j] > C) 
               j-- ;
           else 
            i++ ;
        }
        int [] ans = new int[2] ;
        ans[0] = A[currentI] ;
        ans[1] = B[currentJ] ;
        return ans ;
    }
}
