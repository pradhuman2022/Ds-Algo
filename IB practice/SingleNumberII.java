public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
             int bit[] = new int[32] ;
             int n = A.length ; 
             for(int i = 0 ; i < n ; i++)
             {
                 int x = A[i] ;
                 for(int k = 31; k >= 0; k--)
                 {
                     if(x % 2 == 1)
                      bit[k]++ ;
                     x = x >> 1 ;
                 }
             }
             int ans = 0 ;
             int baseIndex = 1;
             for(int j = 31 ; j >= 0 ; j--)
             {
                 int bitSet = bit[j] % 3 ;
                 ans += bitSet * (1 << baseIndex - 1) ;
                 baseIndex++ ;
             }
             
             return ans ;
    }
}
