class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        QuickSelect(0, nums.length - 1, nums, n - k + 1);
        return nums[n - k];
    }
    
  /****
    1) Use QuickSelect as same of smallest element
    2) Since we need Kth largest, hence it will be n - k + 1th element from left which will be at n - kth index from left, that's why we just manipulated
       values.
  */
    public void QuickSelect(int start, int end, int arr[], int k) {
        
        if (start == end)
            return;
        
        int pivotIndex = partition(start, end, arr);
        
        if(pivotIndex + 1 == k)
            return ;
        else if (pivotIndex + 1 < k)
            QuickSelect(pivotIndex + 1, end, arr, k);
        else
            QuickSelect(start, pivotIndex - 1, arr, k);
    }
    
    public int partition(int start, int end, int arr[]) {
        
        int pivotValue = arr[end];
        int pivotIndex = start;
        for (int i = start; i <= end; i++) {
            if(pivotValue > arr[i]) {
                swap(pivotIndex,i, arr);
                pivotIndex++;
            }   
        }
        
        swap(pivotIndex, end, arr);
        return pivotIndex;
    }
    
    public void swap(int i, int j, int nums[]) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
