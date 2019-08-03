class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
         int ans[]= new int[n] ; 
        
        for(int b[]: bookings)
        {
            int i = b[0] ; 
            int j = b[1] ;
            int k = b[2] ; 
           
            ans[i - 1] += k ; 
            if(j < n)
                 ans[j] -= k ;
        
        }
        for(int i = 1 ; i < n ; i++)
        {
            ans[i] += ans[i - 1] ;
        }
        return ans ;
    }
}
