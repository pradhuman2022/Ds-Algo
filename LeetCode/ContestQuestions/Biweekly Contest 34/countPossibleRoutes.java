class Solution {
    static int mod = 1_000_000_007;
    long dp[][];
    int ending;
    int[] locations;
    public int countRoutes(int[] location, int start, int finish, int fuel) {
        locations = location;
        dp = new long[locations.length][fuel + 1];
        ending = finish;
        for (long a[]: dp)
            Arrays.fill(a, -1);
        return (int)returnAllPossibleRoutes(start, fuel);
    }
    
    long returnAllPossibleRoutes(int start, int fuel) {
        
        if(fuel < 0)
            return 0; 
        
        long ans = 0;
        if(start == ending)
            ans = 1; 
        
        if(dp[start][fuel] != -1)
            return dp[start][fuel];
        
        for (int i = 0 ; i < locations.length; i++) {
            if(start == i)
                continue;
            ans =   (ans % mod + returnAllPossibleRoutes(i, fuel - Math.abs(locations[i] - locations[start])) % mod) % mod;
        }
        
        return dp[start][fuel] = ans;
    }
}
