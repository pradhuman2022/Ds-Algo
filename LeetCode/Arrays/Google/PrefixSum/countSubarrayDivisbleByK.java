class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int map[] = new int[k];
        
        int sum = 0;
        int ans = 0;
        map[0] = 1;
        
        for (int i = 1; i <= nums.length; i++) {
            sum = (sum + nums[i - 1]) % k;
            if (sum < 0)
                sum += k;
            
            ans += map[sum];
            map[sum] += 1;
        }

        return ans;
    }
}
