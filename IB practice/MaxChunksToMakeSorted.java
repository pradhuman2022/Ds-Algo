public class Solution {
    public int solve(int[] A) {
    int max = A[0] ; 
    int chunks = 0 ; 
    for(int i = 0 ; i < A.length; i++)
    {
        max = Math.max(max, A[i]);
        if(max == i)
        {  chunks++ ;
           if(i + 1 < A.length) max = A[i + 1] ;
        }
        
    }
     return chunks++ ;
    }
}
