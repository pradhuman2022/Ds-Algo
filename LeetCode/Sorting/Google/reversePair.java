class Solution {
    int count;
    public int reversePairs(int[] nums) {
        this.count = 0;
        mergeSort(0, nums.length - 1, nums);
        return count;
    }
    
    public void mergeSort(int start, int end, int nums[]) {
        if (start >= end)
            return;
        
        int mid = (start + end) / 2;
        
        mergeSort(start, mid , nums);
        mergeSort(mid + 1, end, nums);
        merge(start, mid, end, nums);
    } 
    
    public void merge(int start, int mid, int end, int nums[]) {
        
        int left = start;
        int right = mid + 1;
        int prev = mid + 1;
        
        
        for (int i = start; i <= mid; i++) {
            
            while(right <= end && (long) nums[i] > (long) 2 * nums[right])
                right++;
            
            this.count += (right - prev) * (mid - i + 1);
            prev = right;
        }
        
        int sortedArray[] = new int[end - start + 1];
        
        int i = 0;
        right = mid + 1;
        
        while(i < sortedArray.length) {
            
            int num1 = left <= mid ? nums[left] : Integer.MAX_VALUE;
            int num2 = right <= end ? nums[right] : Integer.MAX_VALUE;
            
            sortedArray[i++] = num1 <= num2 ? nums[left++] : nums[right++];
        }
        
        for (int k = start; k <= end; k++) {
            nums[k] = sortedArray[k - start];
        }
    }
}
