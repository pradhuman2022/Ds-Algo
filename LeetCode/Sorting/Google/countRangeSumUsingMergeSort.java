class Solution {
    int count;
    int lower;
    int upper;
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.count = 0;
        this.lower = lower;
        this.upper = upper;
        long prefix[] = new long[nums.length + 1];
        
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        
        mergeSort(prefix, 0, prefix.length - 1);
        return count;
    }
    
    
    public void mergeSort(long prefix[], int start, int end) {
        
        if(start >= end)
            return;
        
        int mid = start + (end - start) / 2;
        
        mergeSort(prefix, start, mid);
        mergeSort(prefix, mid + 1, end);
        merge(prefix, start, mid , end);
    }
    
    public void merge(long prefix[], int start, int mid ,int end) {
        int right = mid + 1;
        int j = mid + 1;
        
        for (int i = start; i <= mid; i++) {
            //as right will be sorted so find a point for which prefix[j] - prefix[i] > lower
            while(j <= end && prefix[j] - prefix[i] < lower) {
                j++;
            }
            
            while(right <= end && prefix[right] - prefix[i] <= upper) {
                right++;
            }
            
            //then find a first for while prefix[right] - prefix[i] > upper
            this.count += right - j;
        }
        
        int left = start;
        right = mid + 1;
        int index = 0;
        long sortedArray[] = new long[end - start + 1];
        
        while(index < end - start + 1) {

            long num1 = left <= mid ? prefix[left] : Long.MAX_VALUE;
            long num2 = right <= end ? prefix[right] : Long.MAX_VALUE;
            
            sortedArray[index++] = num1 <= num2 ? prefix[left++] : prefix[right++];    
        }
        
        for (int i = start; i <= end; i++) {
            prefix[i] = sortedArray[i - start];
        }
        
    }
}
