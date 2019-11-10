class NumArray {
   int[] prefixSum;  ;
    public NumArray(int[] nums) {
          prefixSum = new int[nums.length + 1] ; 
          for(int i = 1 ; i <= nums.length; i++){
              prefixSum[i] = prefixSum[i - 1] + nums[i - 1] ;
          } 
    }
    
    public int sumRange(int i, int j) {
        return  prefixSum[j + 1] - prefixSum[i] ;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
