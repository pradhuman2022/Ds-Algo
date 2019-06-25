public class Solution {
    public int firstMissingPositive(int[] A) {
          for(int i = 0 ; i < A.length; i++)
          {
              if(A[i] > 0 && A[i] < A.length)
              {
                  int pos = A[i] - 1;
                  if(A[i] != A[pos])
                  {
                      int temp = A[i] ;
                      A[i] =A[pos] ;
                      A[pos]=  temp ;
                      i-- ;
                  }
              }
          }
          for(int i = 0 ; i < A.length; i++)
          {
              if(A[i] != i + 1)
               return i + 1 ;
          }
          return A.length + 1  ;
    }
}
