class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int start = 1;
        int end = 1000000000;

        while (start < end) {
            int mid = (start + end) / 2;

            if (isPossible(piles, h, mid))
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }

    public boolean isPossible (int [] piles, int h, int banana) {
        
        int timeToFinish = 0;
        for (int i = 0; i < piles.length; i++) {
            timeToFinish += (int)Math.ceil(((double) piles[i]) / banana);
        }

        return timeToFinish <= h;
    }
}
