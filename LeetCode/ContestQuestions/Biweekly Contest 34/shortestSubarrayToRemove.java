class Solution {
    public int findLengthOfShortestSubarray(int[] arr) { 
        boolean suffixDp[] = new boolean[arr.length];
        boolean prefixDp[] = new boolean[arr.length];
        
        suffixDp[arr.length - 1] = true;
        for (int i = arr.length - 2; i >= 0; i--) {
           suffixDp[i] = suffixDp[i + 1] && arr[i + 1] >= arr[i];
        }
        prefixDp[0] = true;
        for (int i = 1; i < arr.length; i++) {
            prefixDp[i] = prefixDp[i - 1] && arr[i - 1] <= arr[i];
        }
        int start = 0; 
        int end = arr.length;
        while(start <= end) {
            int mid = (start + end) / 2; 
            if(isPossible(mid, arr, suffixDp, prefixDp))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }
    
    boolean isPossible(int subarraySize, int arr[], boolean suffixDp[], boolean prefixDp[]) {
    
        for (int i = 0; i <= arr.length - subarraySize; i++) {
           if(i == 0) {
               if(suffixDp[i + subarraySize]) 
                    return true;
           } else if(i + subarraySize >= arr.length)
               return prefixDp[i - 1];
            
           else if(prefixDp[i - 1] && suffixDp[i + subarraySize] && (arr[i - 1] <= arr[i + subarraySize]))
               return true;
        }
        return false;
    }
}
