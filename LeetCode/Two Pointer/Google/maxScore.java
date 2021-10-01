class Solution {
    public int maximumScore(int[] nums, int k) {
        int i = k, j = k, min = nums[k], n = nums.length, result = nums[k];
        
        while(i > 0 || j < n - 1) {
           if (i == 0)
               j++;
           else if(j == n - 1)
               i--;
           else if (nums[i - 1] < nums[j + 1])
	           j++;
           else
               i--;
           min = Math.min(min, Math.min(nums[i], nums[j]));
           result = Math.max(result, min * (j - i + 1));
        }
          return result;   
    }
}

