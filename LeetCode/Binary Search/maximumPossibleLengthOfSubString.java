class Solution {
    public int findLength(int[] A, int[] B) {
        /**
        Take length l and check whether l length can have common length if yes then < l length will have common lengths automatically.
        */
        int len1 = A.length;
        int len2 = B.length;
        
        int end = Math.min(len1, len2);
        int start = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(isCommonLengthAvailable(A, B, mid)) {
                start = mid + 1; 
            } else {
                end = mid - 1;
            }
        }
        return end; 
    }
    
    public boolean isCommonLengthAvailable(int A[], int B[], int length) {
        Set<String> seen = new HashSet();
        for (int i = 0; i + length <= A.length; ++i) {
            seen.add(Arrays.toString(Arrays.copyOfRange(A, i, i+length)));
        }
        for (int j = 0; j + length <= B.length; ++j) {
            if (seen.contains(Arrays.toString(Arrays.copyOfRange(B, j, j+length)))) {
                return true;
            }
        }
        return false;
    }
}
