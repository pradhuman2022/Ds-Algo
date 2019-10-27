/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ;
		int T = sc.nextInt();
		sc.nextLine() ; 
		
		while(T-- > 0){
		   String posix = sc.nextLine() ;
		   System.out.println(Evaluation(posix)) ;
		}
	}
	
	static int Evaluation(String posix) {
	    int ans  ;
	    Stack<Integer>st = new Stack<Integer>() ;
	    
	    for(int i = 0 ; i < posix.length() ; i++){
	        char ch = posix.charAt(i) ; 
	        
	        if(Character.isDigit(ch)) 
	           st.push(Integer.parseInt(String.valueOf(ch))) ;
	        else
	        {
	            int a = st.pop() ;
	            int b = st.pop() ;
	            ans = getCalc(b, a, ch) ;
	            st.push(ans) ;
	        }
	    }
	    return st.pop() ;
	}
	
	static int getCalc(int a, int b, char ch){
	    
	    if(ch == '+')
	      return a + b ; 
	    else if(ch == '-')
	      return a - b ;
	    else if(ch == '*')
	      return a * b ;
	    else if(ch == '/')
	      return a / b ; 
	    else 
	      return a ^ b ;
	}
}
