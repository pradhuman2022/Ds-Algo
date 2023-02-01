class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int w: weights) {
            sum += w;
            max = Math.max(max, w);
        }

        int start = max;
        int end = sum;

        while (start < end) {
            int mid = (start + end) / 2;
            if (isPortingPossible(weights, days, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    boolean isPortingPossible(int weights[], int days, int least_weight) {
        int currentSum = 0;
        
        for (int w = 0; w < weights.length; w++) {
            if (weights[w] > least_weight)
                return false;
            
            if (currentSum + weights[w] > least_weight) {
                days--;
                currentSum = weights[w]; //we need more days to port w[i]
            } else {
                currentSum += weights[w];
            }

            //if all days have been spent and weight is remaining, days will be zero only if days-- would happen and weight[w] is more than least_weight
            if (days <= 0)
                return false;
        }
        return true;
    }
}
