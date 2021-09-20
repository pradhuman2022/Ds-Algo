class Solution {
    int indices[];
    int ans[];
    public List<Integer> countSmaller(int[] nums) {
        indices = new int[nums.length];
        ans = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++)
            indices[i] = i;
        
        mergeSort(0, nums.length - 1, nums);
        
        List<Integer> list = new ArrayList<>();
        
        for (int i: ans)
            list.add(i);
    
        return list;
    }
    
    public void mergeSort(int start, int end, int nums[]) {
        if (start >= end)
            return;
        
        int mid = (start + end) / 2;
        
        mergeSort(start, mid, nums);
        mergeSort(mid + 1, end, nums);
        merge(start, end, mid, nums);
    }
    
    public void merge(int start, int end, int mid, int nums[]) {
        
        int arr[] = new int[end - start + 1];
        
        int left = start;
        int right = mid + 1;
        int i = 0;
        
        while(left <= mid && right <= end) {
            if(nums[indices[left]] <= nums[indices[right]]) {
                ans[indices[left]] += right - mid - 1;
                arr[i] = indices[left];
                left++;
            } else {
                arr[i] = indices[right];
                right++;
            }
            i++;
        }
        
        while(left <= mid) {
            ans[indices[left]] += right - mid - 1;
            arr[i] = indices[left];
            i++;
            left++;
        }
        
        while(right <= end) {
            arr[i] = indices[right];
            i++;
            right++;
        }
        
        for (int k = start; k <= end; k++) {
            indices[k] = arr[k - start];
        }
    }
}
