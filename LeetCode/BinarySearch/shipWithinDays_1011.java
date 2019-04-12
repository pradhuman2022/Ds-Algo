        
  
class Solution {
  public int shipWithinDays(int[] weights, int D) 
    {
         int cap = 0 ;
        for(int w : weights)
        {
            cap += w ;
        }
        int start = 1 ;
        int end = cap;//weights.length * 500 ;
        int ans = cap ;
        while(start <= end)
        {
            int mid = (start + end) / 2 ;
            if(possible(D, weights, mid))
            {
                if(ans > mid)
                     ans = mid ;
                end = mid - 1 ;
            }
            else
            {
                start = mid + 1 ;
            }
        }
        return ans ;
         
    }
   static boolean possible(int D ,int weights[], int capacity)
   {
          int day = 1, w = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity || day > D) return false;
            if (w + weights[i] > capacity) {
                w = weights[i];
                day++;
            } else {
                w += weights[i];
            }
        }
        return day <= D;
   }
   
} 
