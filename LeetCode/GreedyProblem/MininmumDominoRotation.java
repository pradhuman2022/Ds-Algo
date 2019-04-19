class Solution {
    public int minDominoRotations(int[] A, int[] B) {
     int freq1 [] = new int[7] ;
     int freq2 [] = new int[7] ;
    
    int moves = Integer.MAX_VALUE ;
      for(int i = 1 ; i < 7; i++)
      {
          int mA = 0 ; 
          int mB = 0;
          int j ;
          for(j  = 0 ; j < B.length ; j++)
          {
             if(A[j] !=i   && B[j] != i)
                 break ;
              if(A[j] != i && B[j] == i)
                  mA++ ;
              if(A[j] == i && B[j] != i)
                  mB++ ;
          }
         if(j == A.length)
          moves = Math.min(moves, Math.min(mA, mB)) ;
      }
        return moves == Integer.MAX_VALUE ? -1 : moves; 
}
