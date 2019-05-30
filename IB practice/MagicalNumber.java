public class Solution {
    public int solve(int A) {
        
        int pow = 1 ; 
        int ans = 0 ;
        while(A != 0)
        {
            pow *= 5 ;
            if((int)(A & 1) == 1)
               ans += pow ;
            A >>= 1 ;
        }
        return ans ;
    }
}
