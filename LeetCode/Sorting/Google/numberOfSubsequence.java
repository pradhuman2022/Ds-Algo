class Solution {
    public int numSubseq(int[] nums, int target) {
   	Arrays.sort(nums);
    
    int left = 0;
    int right = nums.length - 1;
    int ans = 0;
    int mod =  (int)1e9 + 7;
    int[] dp = new int[nums.length + 1];
    dp[0] = 1;
    for (int i = 1; i <= nums.length; ++i) {
        dp[i] = (dp[i - 1] * 2) % mod;
    }
        
    while (left <= right) {
	    if (nums[left] + nums[right] > target)
		    right--;
	    else
		    ans = (ans + dp[right - left++]) % mod ;
    }
        return ans;   
    }
}

