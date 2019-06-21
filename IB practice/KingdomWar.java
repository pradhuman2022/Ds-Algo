public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        
        int mat[][] = new int[A.size()][A.get(0).size()] ;
        int n = mat.length; 
        int m = mat[0].length ;
         
        for(int row = 0 ; row < n ; row++)
        {
            for(int col = 0 ; col < m ; col++)
            {
                mat[row][col] = A.get(row).get(col) ;
            }
        }
        for(int i = 0 ; i < n ; i++)
        {   
            for(int j = m - 1 ; j >= 0 ; j--)
            {
                if(j == m - 1)
                 continue ;
                mat[i][j] += mat[i][j + 1] ;
            }
        }
        
        for(int col = 0 ; col < m ; col++)
        {
            for(int row = n - 1 ; row >= 0; row--)
            {
                if(row == n - 1) 
                continue ;
                mat[row][col] += mat[row + 1][col] ;
            }
        }
        int ans = Integer.MIN_VALUE ;
        
        for(int row = 0 ; row < n ; row++)
        {
            for(int col = 0 ; col < m ; col++)
            {
                ans = Math.max(ans, mat[row][col]) ;
            }
        }
        
        return ans ;
    }
}
