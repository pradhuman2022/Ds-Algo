class Solution {
    long prefix[];
    int nums[];
    
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        
        prefix = new long[n + 1];
        this.nums = nums;
        
        for (int i = 1; i <= n; i++)
            prefix[i] = prefix[i - 1] + nums[i - 1];
        
        int ans = 0;
        
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, i - getLastIndex(i, k) + 1);
        }
        
        return ans;
    }
          
      /**
     Number of operations needed for all elements in the window [startIndex, endIndex] to hit A[endIndex]
     Example:
     Consider arr with [1, 2, 3, 4] with startIndex = 0; endIndex = 3: i.e If 1, 2, 3 wants to become 4.
     Number of operations needed
     = (4-1)+(4-2)+(4-3)+(4-4) = 6.
     =  4 + 4 + 4 + 4 - (1 + 2 + 3+ 4)
     = 4 * 4 - (1 + 2 + 3 + 4)
     = (number of elements) * ElementToReach - sum of elements in the window
     */
    
    public int getLastIndex(int index, int k) {
        
        int start = 1;
        int end = index;
        
        while(start < end) {
            int mid = (start + end) / 2;
            
            if ((prefix[index] - prefix[mid - 1]) + k >= (long)(index - mid + 1) * nums[index - 1])
                end = mid; 
            else
                start = mid + 1;
        }
        
        return start;
    }
}
