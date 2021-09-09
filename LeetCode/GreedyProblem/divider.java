class Solution {
    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                current++;
                max = Math.max(current, max);
            } else {
                current = 1;
            }   
        }
        
        
        return nums.length < k * max ? false : true;
            
    }
}

