import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-- >0) {
	       int boardSize = sc.nextInt();
	       int kx = sc.nextInt();
	       int ky = sc.nextInt();
	       int tx = sc.nextInt();
	       int ty = sc.nextInt();
	       System.out.println(findMinimumSteps(kx, ky, tx, ty, boardSize));
	    }
	 }
	 static int findMinimumSteps(int kx, int ky, int tx, int ty, int boardSize) {
	 
	    Queue<Pair> q = new LinkedList<Pair>();
	    Pair source = new Pair(kx, ky, 0);
	    int minimumSteps = 0;
	    int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2}; 
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1}; 
        q.offer(source);
	    boolean visited[][] = new boolean[boardSize + 1][boardSize + 1]; 
	    while(!q.isEmpty()) {
	        
	        Pair p = q.poll();
	        if(p.x == tx && p.y == ty)
	            return p.steps;
	        visited[p.x][p.y] = true;
	        for (int cordinates = 0; cordinates < dx.length; cordinates++) {
	            int px = dx[cordinates] + p.x;
	            int py = dy[cordinates] + p.y;
	            
	            if(px >= 1 && px <= boardSize && py >= 1 && py <= boardSize && !visited[px][py]) {
	                q.offer(new Pair(px, py, p.steps + 1));
	            }
	        }
	    }
	    
	    return minimumSteps;
	 }
	 
	 static class Pair {
	     int x;
	     int y;
	     int steps; 
	     Pair(int x, int y, int steps){
	         this.x = x;
	         this.y = y;
	         this.steps = steps ; 
	     }
	 }
}
