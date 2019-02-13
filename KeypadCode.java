Return Keypad Code
Send Feedback
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note : The order of strings are not important.
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf


import java.util.*;
public class solution {
static String s1 [] = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
		// Write your code here
         ArrayList <String> out = new ArrayList<>();              
         findSequences(out , n); 
        return  Arrays.asList(out.toArray()).toArray(new String[0]);
	}
	
    static void findSequences(ArrayList<String> out, int n)
    {
        if(n == 0)
        {
            out.add("");
            return ;
        }
       
       findSequences(out , n / 10 );
      
       String s= get(n % 10);
      
       String [] temp = copy(out);
      
       int k = 0;
       for(int i = 0; i < s.length(); i++)
       {
           for(int j = 0; j < temp.length; j++)
           {
               if(k < temp.length)
               out.set(k,temp[j] + Character.toString(s.charAt(i))) ;
               else
               out.add(k,temp[j] + Character.toString(s.charAt(i)));
               k++;
           }
       }
    }
    static String get(int n)
       {
           return s1[n-2];
       }
    static String []copy(ArrayList <String> out )
    {
        String temp [] = new String [out.size()] ;
        for( int i = 0; i< out.size(); i++)
           temp[i] = out.get(i) ;
        return temp;
    }
}
