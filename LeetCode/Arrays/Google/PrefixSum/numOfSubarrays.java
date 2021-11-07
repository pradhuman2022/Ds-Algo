class Solution {
    public int numOfSubarrays(int[] arr) {
      
        int sum = 0;
        int ans = 0;
        int even = 1;
        int odd = 0;
        
        int mod = (int)1e9 + 7;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if (sum % 2 == 0) {
                ans = (ans + odd) % mod;
                even++;
            } else {
                ans = (ans + even) % mod;
                odd++;
            }
        }
        
        return ans;
    }
}
