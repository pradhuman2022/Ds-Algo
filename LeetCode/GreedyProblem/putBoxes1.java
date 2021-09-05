class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int ans =  0;
	    Arrays.sort(boxes);
	    for (int i = 1; i < warehouse.length; i++) {
		    warehouse[i] = Math.min(warehouse[i - 1], warehouse[i]);
	    }
	
	    for (int i = warehouse.length - 1; i >= 0; i--) {
		    if (ans < boxes.length && warehouse[i] >= boxes[ans]) 
			    ans++;
        }
        
	    return ans;
    }
}

