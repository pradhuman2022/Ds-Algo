class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
	    int n = nums.length ;
	    int start = 0;
	    int end = nums[n - 1] - nums[0];
	    while(start < end) {
            int mid = (start + end) / 2;
            if (mayItBeKthSmallest(mid, nums, k))
		        end = mid;
            else
	            start = mid + 1;
        }
        return start;
    }

    public boolean mayItBeKthSmallest(int i, int nums[], int k) {
		int left = 0;
		int count = 0;
		for (int right = 0; right < nums.length; right++) {
	        while(nums[right] - nums[left] > i) 
		        left++;
	    count += right - left;
        }

        if (count >= k)
	        return true;
        return false;
    }
}


/***
lastPossibleAnswer = max - min
min - (max - 1) 
mi

if we sort the array 

97

1, 2, 3, 100, 120

left = 0
right = 0;

left = 0
right = 1;

count = 1; (1, 2)

left = 0;
right = 2; (1, 3) (2, 3)

count = 1 + 2 = 3

left = 0;
right = 100;

left = 3;
right = 100

count = 4;

left = 3;
right = 120;
count = 4;

left = 100;
right = 120;
count = 5;

1 - 2 < 1 - 3 < 1 - 100 < 1 - 120

pair with 1: 1 < 2 < 99 < 119
pair wth 2:  1 < 98 < 118
pair with 3: 97 < 117
pair with 100:20


_ _ _ _ _ _ K _ _ _ _

**/
