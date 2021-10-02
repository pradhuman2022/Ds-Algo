class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int left[] = new int[k + 1];
        int right[] = new int[nums.length - k];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        
        left[k] = nums[k];
        for (int i = k - 1; i >= 0; i--)
            left[i] = Math.min(left[i + 1], nums[i]);
        
        int l = 1;
        right[0] = nums[k];
        for (int j = k + 1; j < nums.length; j++) 
            right[l] = Math.min(right[l++ - 1], nums[j]);
       
        return Math.max(binarySearch(left, right, k), binarySearch1(left, right, k));
    }
    
    public int binarySearch(int left[], int right[], int k) {
      
        int result = Integer.MIN_VALUE;
        
        for (int i = 0 ; i < left.length; i++) {
            int start = 0;
            int end = right.length - 1;
            
            while(start < end) {
                int mid = (start + end + 1) / 2;
            
                if (left[i] <= right[mid])
                    start = mid;
                else
                    end = mid - 1;        
            }
            result = Math.max(result, (k + start - i + 1) * left[i]);
        }
        
        return result;
    }
    
    public int binarySearch1(int left[], int right[], int k) {
    
        int result = Integer.MIN_VALUE;
        
        for (int i = 0 ; i < right.length; i++) {
            int start = 0;
            int end = left.length - 1;
            while(start < end) {
                int mid = (start + end) / 2;
            
                if (right[i] <= left[mid])
                    end = mid;
                else
                    start = mid + 1;        
            }
            result = Math.max(result, (k + i - start + 1) * right[i]);
        }
        return result;
    }
}

