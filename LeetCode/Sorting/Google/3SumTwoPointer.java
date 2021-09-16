class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0 ; i < nums.length; i++) {
            int value = target - nums[i];
            
            int start = i + 1;
            int end = nums.length - 1;
            
            while (start < end) {
                if (nums[start] + nums[end] < value) {
                    ans += end - start;
                    start++;
                } else {
                    end--;   
                }
            }             
        }
        
        return ans;
    }
}

