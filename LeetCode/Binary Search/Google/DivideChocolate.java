class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int start = 1;
        int end = (int)1e9 / (k + 1);
        while(start < end) {
            int mid = (start + end + 1) / 2;
    
            int current = 0;
            int cuts = 0;
            for (int x : sweetness) {
                current += x;
	            if (current >= mid) {
                    current = 0;
                    cuts++;
                    
                    if (cuts > k)
                        break;
                }
            }

            if (cuts > k)
	            start = mid;
            else
	            end  = mid - 1;
        }

        return start;
    }
}

/**
max(minS1, minS2, minS3, minS4)

[1,2,3,4,5,6,7,8,9], k = 2


***/
