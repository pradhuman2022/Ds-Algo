class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int res[] = new int[2];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int left = i - 1 < 0 ? Integer.MAX_VALUE : nums[i - 1];
            int right = i + 1 >= n ? Integer.MAX_VALUE : nums[i + 1];
            
            int ans = nums[i] - Math.min(left, right) + 1;
            if(ans > 0)
                res[i % 2] += ans;
        }
        return Math.min(res[0], res[1]);
    }
}


