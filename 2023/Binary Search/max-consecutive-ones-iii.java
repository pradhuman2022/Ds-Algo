class Solution {
    public int longestOnes(int[] nums, int k) {

        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = (start + end + 1) / 2;

            if (canConvert(nums, mid, k))
                start = mid;
            else
                end = mid - 1;
        }

        return start;
    }

    public boolean canConvert (int nums[], int len, int k) {
        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0)
                zeros++;
            else
                ones++;
        }

        //System.out.println("ones " + ones + " zeros " + zeros);
        
        if (zeros <= k && zeros + ones == len)
                return true;

        for (int i = 1; i <= nums.length - len; i++) {

            if (nums[i - 1] == 0)
                zeros--;
            else
                ones--;
            
            if (nums[i + len - 1] == 0)
                zeros++;
            else
                ones++;

            //System.out.println("ones " + ones + " zeros " + zeros + " len " + len);

            if (zeros <=k && zeros + ones == len)
                return true;
        }

        return false;
    }
}
