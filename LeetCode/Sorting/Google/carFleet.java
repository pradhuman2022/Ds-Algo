class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
       //observations
	// 1) car can’t take over any other car it mean if p(ci) < p(cj) and s(ci) > s(cj)
	// but if p(ci) < p(cj) and s(ci) < s(cj)
	int ans = 0;
	double carConfig[][] = new double[pos.length][2];
	
for (int car = 0; car < pos.length; car++) {
		carConfig[car] = new double[] {pos[car], (double)(target - pos[car]) / speed[car]};
}
	
Arrays.sort(carConfig, (a, b) -> Double.compare(a[0], b[0]));
        for (double d[]: carConfig){
            System.out.print(d[1]+ " ");
        }
       
        // we should start from last because
        // car from end positions can slow down cars having high speed
        /// if end car speed is lesser than starting Ecar > Scar and SpeedEcar < SpeedOfScar
	double currentTimeOfFleetToReachDestination = 0;
	for (int car = pos.length - 1; car >=0; car--) {
	if (currentTimeOfFleetToReachDestination < carConfig[car][1])  {
	    ans++; 
        currentTimeOfFleetToReachDestination = carConfig[car][1];
    }
        
    

}

return ans;
    }
}

