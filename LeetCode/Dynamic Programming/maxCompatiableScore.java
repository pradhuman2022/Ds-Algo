class Solution {
    int[][] students;
    int[][] mentors;
    int m ;
    int n ;
    int dp[][];
    
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        this.students = students;
        this.mentors = mentors;
        this.m = mentors.length;
        this.n = students[0].length;
        dp = new int[m][(int)Math.pow(2, m)];
        for(int a[]: dp)
            Arrays.fill(a, -1);
        
        return fun(0, 0);
    }
    
    public int fun(int sId, int mentorBit) {
        if(sId >= m || mentorBit > (int)Math.pow(2, m))
            return 0;
        
        int ans = 0;
        int temp = mentorBit;
        if(dp[sId][mentorBit] > 0)
            return dp[sId][mentorBit];
        
        for(int i = 0; i < m; i++) {
            int mBit = (int)Math.pow(2, i);
            
            if((mentorBit & mBit) == 0) {
                int comp = 0;
                //--
                for (int j = 0 ; j < n; j++)
                    if((students[sId][j] ^ mentors[i][j]) == 0)
                        comp++;
                //--
                ans = Math.max(ans, fun(sId + 1, mentorBit |  mBit) + comp);
            }
        }
        return dp[sId][mentorBit] = ans ;
    }
}
