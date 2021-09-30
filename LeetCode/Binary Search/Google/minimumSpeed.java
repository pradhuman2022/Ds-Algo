class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int start = 1;
        int end =  10000000;
        while(start < end) {
            int speed = (start + end) / 2;
            
            if (isPossibleToReachEnd(speed, dist, hour)) {
                end = speed;
            } else {
                start = speed + 1;
            }
        }
        
        return isPossibleToReachEnd(start, dist, hour) ? start : -1;
    }
    
    public boolean isPossibleToReachEnd(int speed, int dist[], double hour) {
        
        double totalTime = 0;
        
        for (int d = 0; d < dist.length - 1; d++) {
            totalTime = totalTime + Math.ceil((double) dist[d] / speed);
        }
        
        totalTime = totalTime + ((double)dist[dist.length - 1] / speed);
        
        if (totalTime > hour)
            return false;
        
        return true;
    }
}


