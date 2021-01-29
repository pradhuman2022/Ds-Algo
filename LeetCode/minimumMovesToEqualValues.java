class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            moves += nums[i] - nums[0];
        }
        return moves;
    }
    /***
    Instead of incrementing n - 1 values,hm log souch skte hai max value ko 
    decrement krne ka
    **/
}
