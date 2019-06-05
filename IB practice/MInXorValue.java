public class Solution {
    public int findMinXor(int[] A) {
        java.util.Arrays.sort(A) ;
        int minXor = Integer.MAX_VALUE ;
        int pairs= 0 ;
        for(int i = 1; i < A.length ; i++)
        {
           minXor = Math.min(minXor, A[i] ^ A[i - 1]) ;
        }
        for(int i = 1 ; i < A.length ;i++)
        {
            if((A[i] ^ A[i - 1])== minXor)
             pairs = pairs + 1; 
        }
        return minXor ;
    }
}
