class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int dp[][] = new int[nums.length][2];
        
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        
        dp[0][0] = 0;
        dp[0][1] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            dp[i][0] = i;
            dp[i][1] = 1;

            for (int j = 0; j < i; j++) {
	            if (currentNum % nums[j] == 0 && dp[j][1]  + 1 > dp[i][1]) {
	            dp[i][1] = dp[j][1] + 1;
                dp[i][0] = j;
                max = Math.max(dp[i][1], max);
                } 	
            }
       }
  
      for (int i = 0; i < nums.length; i++) {
        if (dp[i][1] == max) {
            int prev = i;
            while(prev != dp[prev][0]) {
                ans.add(nums[prev]);
                prev = dp[prev][0];
            }
            ans.add(nums[prev]);
            return ans;
        }
      }
      return ans;
    }
}

/***

[1, 2, 4, 8]

mod(i, j) = x --> 5 % 2 = 1
mod(j , k) = x --> 9 % 5 == 1
mod(i, k) = 9 % 2 == 1

we can have max mod = max % min 
create array of mod 0 to 



inorder to find subset i < j so then j % i

**/
