import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCase = sc.nextInt();
	    int moves[] = new int[31];
	    while(testCase-->0) {
	        for (int i = 0; i <= 30; i++)
	            moves[i] = -1; 
	        int n = sc.nextInt();
	        for (int i = 0; i < n; i++) {    
	            int a = sc.nextInt();
	            int b = sc.nextInt();
	            moves[a] = b; 
	        }
	        System.out.println(minimumSteps(moves));
	       }
	   }
	    static int minimumSteps(int moves[])  {
	    
	    Queue<Pair> q = new LinkedList<Pair>();
	    q.offer(new Pair(1, 0));
	    boolean visited[] = new boolean[31];
	    while(!q.isEmpty()) {
	        Pair front = q.poll();
	        
	        if(front.cellValue == 30)
	            return front.steps;
	       
	        visited[front.cellValue] = true;
	        for (int i = front.cellValue + 1; i <= front.cellValue + 6 && i <= 30; i++) {
	            if(!visited[i]) {
	                if(moves[i] == -1) 
	                    q.offer(new Pair(i, front.steps + 1));
	                else
	                    q.offer(new Pair(moves[i], front.steps + 1));
	            }
	        }
	    }
	    return -1;
	 }
	 static class Pair{
	     int cellValue;
	     int steps;
	     Pair(int cv, int steps){
	         this.cellValue = cv;
	         this.steps = steps;
	     }
	 }
}
