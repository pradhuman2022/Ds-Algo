import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int countSteppingNum;
    
	public static void main (String[] args)
	 {
	 //code
	    Scanner input = new Scanner(System.in);
	    int cases = input.nextInt();
	    
	    while(cases-->0) {
	        int n = input.nextInt();
	        int m = input.nextInt();
	        countSteppingNum = 0;
	        for(int i = 0; i <= 9; i++)
	            bfs(i, n, m);
	        System.out.println(countSteppingNum);
	    }
	 
	 }
	 
	 static void bfs(int num, int n, int m) {
	     Queue<Integer> q = new ArrayDeque<Integer>();
	     
	     q.offer(num); 
	     
	     while(!q.isEmpty()) {
	         
	         int stepNum = q.poll();
	         
	         if(stepNum <= m && stepNum >= n)
	            countSteppingNum++ ;
	         
	         if(num == 0 || stepNum > m)
	            continue;
	         
	         int lastDigit = stepNum % 10;
	         
	         int inc = stepNum * 10 + lastDigit + 1;
	         int des = stepNum * 10 + lastDigit - 1;
	         
	         if(lastDigit == 0)
	            q.offer(inc);
	         else if(lastDigit == 9)
	            q.offer(des) ; 
	         else {
	             q.offer(inc);
	             q.offer(des);
	         }
	     }
	 }
}
