import java.io.*;
import java.util.*;

class Solution {
  // i can't hear you,can you refresh
  static int grids[][];
	static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
		// your code goes here
    Queue<Pair> q = new LinkedList<>();
    int steps[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int ans = 0;
    
    if(grid[sr][sc] == 0 || grid[tr][tc] == 0) {
      return -1;
    }
    
    boolean visited[][] = new boolean[grid.length][grid[0].length];
    q.add(new Pair(sr, sc));
    visited[sr][sc] = true; 
    grids = grid;
    boolean didWeGet = false;
    
   while(!q.isEmpty()) {
      ans++;
      int levelSize = q.size();
      label: for (int l = 0; l < levelSize; l++) {
        Pair currentPair = q.poll();
        for (int i = 0; i < 4; i++) {
          int currentX = currentPair.x + steps[i][0];
          int currentY = currentPair.y + steps[i][1];
          if(currentX == tr && currentY == tc) {
            return ans;
          }
          if(isValid(currentX, currentY) && !visited[currentX][currentY]) {
            q.add(new Pair(currentX, currentY));
            visited[currentX][currentY] = true;
          }
        }
      }
    }
    q = null;
    visited = null;
    System.gc();
    
    return -1;
	}
  
  
  public static boolean isValid(int currentX, int currentY) {
    if(currentX < 0 || currentY < 0 || currentX >= grids.length || currentY >= grids[0].length 
       || grids[currentX][currentY] == 0) {
      return false;
    }
    
    return true;
  }

	public static void main(String[] args) {
	
	}
  
  static class Pair {
    int x;
    int y;
    Pair(int x, int y) {
      this.x = x; 
      this.y = y;
    }
  }
}
