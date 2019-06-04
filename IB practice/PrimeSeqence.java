public class Solution {
    public int[] solve(int A, int B, int C, int D) {
        int i = 0 ; 
        int j = 0 ;
        int k = 0 ;
        int ans [] = new int[D + 1] ;
        ans[0] = 1 ;
        
        for(int k1 = 1 ; k1 < ans.length ;)
        {
            int mi = ans[i] * A ;
            int mj = ans[j] * B ;
            int mk = ans[k] * C ;
            int min = Math.min(mi, Math.min(mj, mk));
            if(ans[k1 - 1] == mi || ans[k1 - 1] == mj || ans[k1 - 1] == mk)
            {
                if(ans[k1 - 1] == mi)
                 i++ ;
                else if(ans[k1 - 1] == mj)
                 j++ ;
                else
                 k++ ;
                 continue ;
            }
            if(mi == min)
              {
                  ans[k1] = mi ;
                  i++ ;
              }else if(mj == min)
              {
                  ans[k1] = mj ;
                  j++ ;
              }else
              {
                  ans[k1] = mk ;
                  k++ ;
              }
              k1++ ;
        }
        int ans1 [] = new int[D] ;
        for(int l = 1 ; l < ans.length ; l++)
        {
            ans1[l - 1] = ans[l] ;
        }
        return ans1 ;
    }
}
