class Solution {
    public int[][] merge(int[][] intervals) {
    	Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
	    LinkedList<int[]> merged = new LinkedList<>();
	
	    for (int interval[] : intervals) {
		    if (merged.isEmpty() || interval[0] > merged.getLast()[1]) {
			    merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(interval[1], merged.getLast()[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

