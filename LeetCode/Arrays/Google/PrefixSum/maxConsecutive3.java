class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int left = 0;
        int ans = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] == 0)
                zeros++;
            
            while(left < nums.length && zeros > k) {
                if (nums[left] == 0)
                    zeros--;
                left++;
            }
            
            ans = Math.max(ans, i - left + 1);
        }
        
        return ans;
    }
    
}
