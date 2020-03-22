/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
	    System.out.println(bfs_minOperations(4, 7));
	}
	
	static int bfs_minOperations(int source, int target) {
	    Queue<Pair> q = new LinkedList<Pair> ();
	    boolean visited[] = new boolean[10001];
	    q.offer(new Pair(source, 0));
	    
	    while(!q.isEmpty()) {
	        Pair node = q.poll();
	        int mul = node.value * 2;
	        int sub = node.value - 1;
	        
	        if(node.value == target) 
	            return node.steps;
	        
	        visited[node.value] = true;
	        if(mul > 0 && mul < 1000 && !visited[mul]) {
	            q.offer(new Pair(mul, node.steps + 1));
	        }
	        
	        if(sub > 0 && mul < 1000 & !visited[sub]) {
	            q.offer(new Pair(sub, node.steps + 1));
	        }
	    }
	    return -1;
	}
	static class Pair {
	    int value;
	    int steps; 
	    Pair(int value, int steps) {
	        this.value = value;
	        this.steps = steps;
	    }
	}
}
