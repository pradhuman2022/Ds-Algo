import java.util.* ;
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
         //     Arrays.sort(piles) ;
              int high = (int)1e9 ;
              int low  = 1 ;
       
        while(low < high)
        {
            int mid = (low + high)/ 2; 
            if(! possible(mid, H, piles))
                low = mid + 1 ;
            else
                high = mid   ;
        }
        return low ;
    }
    static boolean possible(int k , int H, int piles[])
    {
        int time = 0 ;
        for(int x : piles)
            time += Math.ceil((double)x / (double)k) ;
            return time <= H ;
    }
    
}
