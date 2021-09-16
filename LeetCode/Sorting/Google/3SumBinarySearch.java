class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        //choose any two and apply binary search on it to find range ]
        int ans = 0;
        for (int i = 0 ; i < nums.length; i++) {
		    for (int j = i + 1; j < nums.length; j++) {
			    int value = target - (nums[i] + nums[j]);
	            int start = j; // not j + 1 beacuse it is not always possible that answer will be there, but at worst case it may contain j - (j + 1) which will add 1 repeatedly.
	            int end = nums.length - 1;
	            while(start < end) {
	                int mid = (start + end + 1) / 2;
	                if (nums[mid] < value) {
	                    start = mid;
                    } else {
	                    end = mid - 1;
                        }
                }
                ans += start - j;
            }
        }
        
        return ans;
    }
}

