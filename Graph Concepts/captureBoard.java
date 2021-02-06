public class Solution {
    ArrayList<ArrayList<Character>> mat;
    boolean visited[][];
    static int steps[][] = {{-1, 0}, {0, -1}, {1, 0}, {0 ,1}};
    
	public void solve(ArrayList<ArrayList<Character>> a) {
	    this.mat = a;
	    this.visited = new boolean[a.size()][a.get(0).size()];
	    if(visited.length <= 2 && visited[0].length <= 2)
	        return;
	    
      
	    for (int col = 0; col < visited[0].length; col++) {
	        if(a.get(0).get(col) == 'O')
	            dfs(0, col);
	        
	        if(a.get(visited.length - 1).get(col) == 'O')
	            dfs(visited.length - 1, col);   
	    }
	    
	    for (int row = 0; row < visited.length; row++) {
	        if(a.get(row).get(0) == 'O')
	            dfs(row, 0);
	            
	        if(a.get(row).get(visited[0].length - 1) == 'O')
	            dfs(row, visited[0].length - 1);
	    }

        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[i].length; j++) {
                if(!visited[i][j])
                    a.get(i).set(j, 'X');
            }
        }
        
	}
	
	public void dfs(int row, int col) {
	       visited[row][col] = true;
	       
	       for (int i = 0; i < 4; i++) {
	           int newRow = row + steps[i][0];
	           int newCol = col + steps[i][1];
	           
	           if(isValid(newRow, newCol) && !visited[newRow][newCol] && mat.get(newRow).get(newCol) == 'O') {
	               dfs(newRow, newCol);
	           }
	       }
	}
	
	public boolean isValid(int row, int col) {
	    if(row < 0 || col < 0 || row >= mat.size() || col >= mat.get(0).size())
	        return false;
	    return true;
	}
}

/***
Problem Description

Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.



Problem Constraints

1 <= N, M <= 1000


Input Format

First and only argument is a N x M character matrix A.


Output Format

Make changes to the the input only as matrix is passed by reference.


Example Input

Input 1:

 A = [ 
       [X, X, X, X],
       [X, O, O, X],
       [X, X, O, X],
       [X, O, X, X] 
     ]

Input 2:

 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]



Example Output

Output 1:

 After running your function, the board should be:
 A = [
       [X, X, X, X],
       [X, X, X, X],
       [X, X, X, X],
       [X, O, X, X]
     ]

Output 2:

 After running your function, the board should be:
 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]
     
     
     **/
