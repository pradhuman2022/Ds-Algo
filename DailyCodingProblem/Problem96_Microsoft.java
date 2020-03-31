/*package whatever //do not write package name here */
//refractoring

import java.util.*;

class GFG {
    
    public static void main(String ar[]){
       ArrayList <String> al = new ArrayList<String>() ; 
       al.add("") ;
        int k = getPer("123", al) ; 
    
      for(String p : al)
      System.out.println(p);
	   
	}
	static int getPer(String Input, ArrayList<String> al){
	    
	    
	    //base Case 
	    // when we have only one char in string then there will onlly be one permutation//
	    if(Input.length() == 1)
	      {
	          al.add(Input) ; 
	          return 1 ; 
	      }
	      
	      //we will try to get permutations if we attach every element at starting of everyString//
	      String substr ;
	      int  totalPermutations = 0 ; 
	      int  k = 0 ;
	      int index = 0 ; 
	      for(int i = 0 ; i < Input.length();  i++){
	          
	         if(i != 0) 
	         substr = Input.substring(0, i) + Input.substring(i + 1, Input.length()) ; 
	         else 
	         substr = Input.substring(1, Input.length()) ;
	         k = getPer(substr, al) ;  
	      //just attaching ith char at starting of substr//
	      int size = al.size() ; 
	      index = size - k ; 
	      for(int t = 0 ; t < k ; t++){
	           al.set(index, Input.charAt(i) + al.get(index)) ;
	           index++ ;
	      }
	      totalPermutations += k ; 
	      }
	      return totalPermutations ; 
	}

	
}
