class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCap = 0;
        int currentCap = 0;
        int station = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalCap += gas[i] - cost[i];
            currentCap += gas[i] - cost[i];
            
            if(currentCap < 0) {
                //no worth to start from previous selected start station to i, it is better to start from i + 1
                station = i + 1;
                currentCap = 0;
            }
        }
        
        return totalCap >= 0 ? station : -1;
    }
}
