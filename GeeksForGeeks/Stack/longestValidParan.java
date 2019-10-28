/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		sc.nextLine() ;
		
		while(T-- > 0){
		    String str = sc.nextLine() ; 
		    System.out.println(longestValidSubString(str));
		}
	}
	
	static int longestValidSubString(String str){
	    int res = 0 ;
	    Stack<Integer> st = new Stack<Integer>() ; 
	    
	    st.push(-1) ; 
	    
	    for(int i = 0 ; i < str.length() ; i++){
	        
	        if(str.charAt(i) == '(')
	           st.push(i)  ;
	       else{
	           st.pop()  ; 
	           
	           if(!st.isEmpty()){
	               //calc max length
	               res = Math.max(res, i - st.peek()) ;
	            }
	            else{
	               st.push(i) ;
	           }
	       }    
	    }
	    return res ; 
	}
}
