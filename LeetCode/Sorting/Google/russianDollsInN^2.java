class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int max = 1;
        
        int dp[] = new int[envelopes.length];
        dp [0] = 1;
        
        // if we sort same heights with ascending order of width then //	                //we have careful about that we should not include same heights envelope.
        Arrays.sort(envelopes, (a, b) -> {
        if (a[0] == b[0])  
            return b[1] - a[1]; 
        else
	        return a[0] - b[0];
        }); 

 	    for (int i = 1; i < envelopes.length; i++) {
		    dp[i] = 1;
		    for(int j = 0; j < i; j++) {
	            if (envelopes[j][1] < envelopes[i][1]) {
	                dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}


