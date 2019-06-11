public class Solution {
    public int solve(int[][] A, int B) {
        
        for(int i =  0; i < A.length ; i++)
        {
             for(int j = 0 ; j < A[0].length ; j++)
             {
                 if(A[i][j] == B)
                 {
                     return ((i + 1) * 1009) + (j + 1) ;
                 }
             }
        }
         return -1 ;  
    }
}
