class Solution {
    public int[][] kClosest(int[][] points, int k) {
           QuickSelect(0, points.length - 1, points, k);
           int ans[][] = new int[k][2];
        
            for (int i = 0; i < k; i++)
                ans[i] = points[i];
        
            return ans;
    }
    
    public void QuickSelect(int start, int end, int[][] points, int k) {
        if (start == end)
	        return;

        int pivotIndex = partition(start, end, points);

        if (pivotIndex + 1 == k)
	        return;

        else if(pivotIndex + 1 < k)
	        QuickSelect(pivotIndex + 1, end, points, k);

        else 
	        QuickSelect(start, pivotIndex - 1, points, k);
    }

    int partition(int start, int end, int[][] arr) {
	    int pivotValue = (arr[end][0] * arr[end][0])  + (arr[end][1] * arr[end][1]);
	    int pivotIndex = start;
	    for (int i = start; i <= end; i++) {
		    int  d = (arr[i][0] * arr[i][0])  + (arr[i][1] * arr[i][1]);
		    if ( d < pivotValue) {
	            swap(i, pivotIndex++, arr);
            }
        }
        swap(end, pivotIndex, arr);
        return pivotIndex;
    }

    void swap(int i, int j, int p[][]) {
        int temp[] = p[i];
        p[i] = p[j];
        p[j] = temp;
    }
}

