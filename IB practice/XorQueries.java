public class Solution {
    public int[][] solve(int[] A, int[][] B) {
        
        int ans[][] = new int[B.length][2] ;
        
        for(int i = 0 ; i < B.length; i++)
        {
              int l = B[i][0] ; 
              int r = B[i][1] ;
              int unsetBit = 0 ;
              int xor = 0 ;
              
              for(int k = l - 1 ; k <= r - 1; k++)
              {
                  xor = xor ^ A[k] ;
                  unsetBit += (1 - A[k]) ;
              }
             ans[i][0] = xor ;
             ans[i][1] = unsetBit ;
        }
        return ans ;
    }
}
