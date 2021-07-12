class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int minRooms = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
         // Sort the intervals by start time
   /** Arrays.sort(
        intervals,
        new Comparator<int[]>() {
          public int compare(final int[] a, final int[] b) {
            return a[0] - b[0];
          }
        });**/
        
        pq.add(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i++) {
            
            if(intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
                pq.add(intervals[i][1]);
        }
        return pq.size();
        
    }
}
/**
1) just put all values with flag in sorted order then if flag is for arrival then incremebt
currentRooms otherwise decrement currentRooms and keep maximum so far.

2) Just allocate room if top of minHeap is > to start time of current meeting, otherwise poll meeting and add dep of currentmeeting **/
