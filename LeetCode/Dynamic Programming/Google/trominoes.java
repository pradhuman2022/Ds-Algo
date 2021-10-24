class Solution {
    public int numTilings(int n) {
        
        long f[] = new long[n + 1];
        long g[] = new long[n + 1];
        long mod = 1000000007;
        
        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                f[i] = i;
                g[i] = i;
            } else {
                g[i] = (f[i - 1] + g[i - 1]) % mod;
                f[i] = (f[i - 1] + f[i - 2] + (2 * g[i - 2])) % mod;
            }
        }
        
        return (int)(f[n] % mod);
    }
}
