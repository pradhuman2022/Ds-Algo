Return Permutations - String
Send Feedback
Given a string S, find and return all the possible permutations of the input string.
Note 1 : The order of permutations is not important.
Note 2 : If original string contains duplicate characters, permutations will also be duplicates.
Input Format :
String S
Output Format :
All permutations (in different lines)
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba
Download Test Cases

Main Code

import java.util.* ;
public class solution {
	
	public static String[] permutationOfString(String input){
		// Write your code here
       ArrayList<String> al = new ArrayList<>() ;
      
      getPermutations(input, al) ;
      return al.toArray(new String[0]) ;
	}
	  static  int getPermutations(String input , ArrayList<String> al)
    {
        if(input.length() == 1)
        {
            al.add(input) ;
            return 1 ;
        }
          int index = 0;
          int totalResult = 0 ;
        for(int i = 0 ; i < input.length(); i++)
        {
            int k ;
            if(i == 0 )
            {
              k = getPermutations(input.substring(i + 1, input.length()), al) ;  
            }
            else
            {
                k = getPermutations(input.substring(0, i) + input.substring(i + 1, input.length()), al) ;
            }
        //    System.out.println(k +" "+ al) ; 
            totalResult = totalResult + k ; 
            index = al.size() - k ;
            
            for(int j = 0 ; j < k ; j++)
            {
                al.set(index, Character.toString(input.charAt(i))+al.get(index)) ;
                 index++ ;
            }
             
        }
        return totalResult ;
    }
            
    

}
