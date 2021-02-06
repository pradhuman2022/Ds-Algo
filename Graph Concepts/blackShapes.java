public class Solution {
    char mat[][];
    int steps[][] = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    boolean visited[][];
    public int black(String[] A) {
        
        if(A == null || A.length == 0)
            return 0;
        
        init(A);
        
        int ans = 0;
        for (int i = 0; i < this.mat.length; i++) {
            for(int j = 0; j < this.mat[0].length; j++) {
                if(!visited[i][j] && mat[i][j] == 'X') {
                    dfs(i, j);
                    ans++;
                }
                
            }
        }
        
        return ans;
    }
    
    public void init(String A[]) {
        this.mat = new char[A.length][A[0].length()];
        visited = new boolean[A.length][A[0].length()];
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length(); j++) {
                this.mat[i][j] = A[i].charAt(j);
            }
        }
    }
    
    public void dfs(int row, int col) {
        visited[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + steps[i][0];
            int newCol = col + steps[i][1];
                    
            if(isValid(newRow, newCol) && !visited[newRow][newCol] && mat[newRow][newCol] == 'X')
                dfs(newRow, newCol);
        }
    }
    
    public boolean isValid(int row, int col) {
        if(row < 0 || col < 0 || row >= mat.length || col >= mat[0].length)
            return false;
        return true;
    }
}

/***
Black Shapes

Problem Description

Given character matrix A of O's and X's, where O = white, X = black.

Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)



Problem Constraints

1 <= |A|,|A[0]| <= 1000

A[i][j] = 'X' or 'O'



Input Format

The First and only argument is character matrix A.


Output Format

Return a single integer denoting number of black shapes.


Example Input

Input 1:

 A = [ [X, X, X], [X, X, X], [X, X, X] ]

Input 2:

 A = [ [X, O], [O, X] ]



Example Output

Output 1:

 1

Output 2:

 2



Example Explanation

Explanation 1:

 All X's belong to single shapes

Explanation 2:

 Both X's belong to different shapes
**/
