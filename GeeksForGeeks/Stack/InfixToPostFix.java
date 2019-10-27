/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//codev
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		sc.nextLine() ;
		while(T-- > 0){
		    String s = sc.nextLine() ;
		    System.out.println(getPostfix(s, s.length()));
		}
	}
	
	static int prec(char ch){
	    
	    switch(ch){
	        case '+' :
	        case '-' :
	            return 1 ; 
	        case '*' :
	        case '/' :
	            return 2 ; 
	        case '^' :
	            return 3 ;
	    }
	    return -1 ;
	}
	
	static StringBuilder getPostfix(String str, int n){
	    StringBuilder ans = new StringBuilder() ;
	    
	    Stack<Character> st = new Stack<Character>() ;
	    
	    for(int i = 0 ; i < n ; i++){
	        
	        char ch = str.charAt(i) ; 
	        
	        if(Character.isLetterOrDigit(ch))
	          ans.append(ch) ;
	        else if(ch == '(')
	          st.push(ch) ;
	        else if(ch == ')'){
	            while(!st.isEmpty() && st.peek() != '(')
	             ans.append(st.pop()) ;
	            
	            if(!st.isEmpty() && st.peek() != '(')
	              return new StringBuilder("Invalid Expression") ;
	            else 
	              st.pop();
	        }
	       else {
	             
	             while(!st.isEmpty() && prec(st.peek()) >= prec(ch))
	              ans.append(st.pop()); 
	             st.push(ch) ; 
	       } 
	          
	    }//--------------end of for
	    
	    //if some op remain in stack then pop 
	    
	    while(!st.isEmpty()){
	        if(st.peek() == '(')
	          return new StringBuilder("Invalid Expression");
	        ans.append(st.pop()) ;  
	    }
	    
	    return ans ;
	    
	}
}
