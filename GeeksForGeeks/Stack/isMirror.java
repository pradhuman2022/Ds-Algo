/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc =  new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		
		while(T-- > 0){
		    int n = sc.nextInt() ; 
		    int e = sc.nextInt() ; 
		    
		    ArrayList<Stack<Integer>> t1 = new ArrayList<Stack<Integer>>() ; 
		    ArrayList<Queue<Integer>> t2 = new ArrayList<Queue<Integer>>() ;
		    
		    int u1[] = new int[n] ;  
		    int v1[] = new int[n] ; 
		    
		    int u2[] = new int[n] ;
		    int v2[] = new int[n] ;
		    
		    for(int i = 0 ; i < e ; i++)
		      {
		          u1[i] = sc.nextInt() ;
		          v1[i] = sc.nextInt() ; 
		      }
		    
		    for(int i = 0 ; i < e ; i++)
		      {
		          u2[i] = sc.nextInt() ;
		          v2[i] = sc.nextInt() ; 
		      }
		    
		    t1 = InitializeStack(t1, n , e)  ;
		    t2 = InitializeQueue(t2, n , e) ; 
		     
		    //----------stack----------   
		    for(int i = 0 ; i < n ; i++){
		        t1.get(u1[i]).push(v1[i]) ; 
		    }    
		    //---------- queue----------
		    for(int i = 0 ; i < n ; i++){
		        t2.get(u2[i]).offer(v2[i]) ; 
		    }
		    System.out.println(isMirror(t1, t2) == true ? 1 : 0) ;
		    
		  } 
	}
	
	static boolean isMirror(ArrayList<Stack<Integer>> t1, ArrayList<Queue<Integer>> t2){
	    
	    for(int i = 1; i < t1.size() ; i++){
	        Stack<Integer> st = t1.get(i) ; 
	        Queue<Integer> qu = t2.get(i) ; 
	        
	        while(!st.isEmpty() && !qu.isEmpty() && st.peek() == qu.peek())
	          {
	              st.pop() ; 
	              qu.poll() ;
	          }
	          
	          if(!st.isEmpty() || !qu.isEmpty())
	            return false ;
	    }
	    return true ;
	}
	
	
	//---------initialize stack for every node--------------------------
	public static ArrayList<Stack<Integer>> InitializeStack(ArrayList<Stack<Integer>> t1, int n, int e){
	     for(int i = 0 ; i < n + 1 ; i++){
	         t1.add(new Stack<Integer>()) ;
	     }
	     return t1 ; 
	}
	//------------intialize queue for every node------------------------
	public static ArrayList<Queue<Integer>>InitializeQueue(ArrayList<Queue<Integer>> t1, int n, int e){
	    for(int i = 0 ; i < n + 1; i++){
	        t1.add(new ArrayDeque<Integer>()) ;
	    }
	    return t1 ;
	}
	
	
}
