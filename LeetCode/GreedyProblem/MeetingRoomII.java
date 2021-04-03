class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Pair []p = new Pair[intervals.length * 2];
        
        int currentPos = 0;
        int i = 0;
        while(i < intervals.length){
            p[currentPos] = new Pair(intervals[i][0], true);
            p[++currentPos] = new Pair(intervals[i][1], false);
            i++;
            currentPos++;
        }
        
        Arrays.sort(p, new Comparator<Pair>(){
            public int compare(Pair a,Pair b) {
                if(a.time != b.time) {
                    return a.time - b.time;
                } else  {
                    if(a.isArrivalTime == false)
                        return -1;
                    else if(b.isArrivalTime == false) 
                        return 1;
                    else
                        return 0;
                }
        }});
        
        int minRooms = 0;
        int currentRooms = 0;
        
        for (int j = 0; j < p.length; j++) {
            
            if(p[j].isArrivalTime) {
                currentRooms++;
            } else {
                currentRooms--;
            }
            minRooms = Math.max(minRooms,currentRooms);
        }
        
        return minRooms;
    }
    
    class Pair {
        boolean isArrivalTime;
        int time;
        Pair(int time, boolean isArrivalTime) {
            this.isArrivalTime = isArrivalTime;
            this.time = time;
        }
    }
}

/***
We can also solve it using min heap just creating rooms and put it in min heap , if min departure time is less than current start time then allocate the current 
interval with preivous room which was allocated to min departure time of heap.
