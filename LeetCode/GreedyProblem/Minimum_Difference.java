class Solution {
    public int minDifference(int[] nums) {
   
        int n = nums.length - 1;
        if(nums.length < 5) 
            return 0;
        Arrays.sort(nums);
        
        int ans = Math.abs(nums[3] - nums[n]);
        ans = Math.min(ans, Math.abs(nums[n - 3] - nums[0]));
        ans = Math.min(ans, Math.abs(nums[n - 1] - nums[2]));
        ans = Math.min(ans, Math.abs(nums[1] - nums[n - 2]));
        
        return ans;
    }
}
