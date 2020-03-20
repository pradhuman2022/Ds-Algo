/*package whatever //do not write package name here */
//can be done using Priority Queues
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ;
		sc.nextLine() ;
		
		while(T-- > 0)
		{
		  String s = sc.nextLine() ;    
		  System.out.println(isPossible(s)) ;   
		}
	}
	
	static int isPossible(String s)
	{
	    Queue<pair> pq = new PriorityQueue<pair>((a, b)-> b.count - a.count) ;
	    int count1[] = new int[26] ;
	    int n = s.length() ;
	    
	    for(int i = 0 ; i < n; i++)
	    {
	        count1[s.charAt(i) - 'a']++ ;
	        if(count1[s.charAt(i) - 'a'] > (n + 1) / 2)
	          return  0 ;
	    }
	   return 1 ;     
	}

}
