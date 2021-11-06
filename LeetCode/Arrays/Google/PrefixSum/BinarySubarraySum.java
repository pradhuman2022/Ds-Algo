class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int prefixSum[] = new int[nums.length + 1];
        
        for (int i = 1; i <= nums.length; i++)
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int ans = 0;
        
        for (int pSum : prefixSum) {
            ans += map.getOrDefault(pSum, 0);
            map.put(pSum + goal, map.getOrDefault(pSum + goal, 0) + 1);
        }
        
        return ans;
    }
}
