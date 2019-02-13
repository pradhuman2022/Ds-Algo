Suppose you have a string made up of only 'a' and 'b'. Write a recursive function that checks if the string was generated using the following rules:
a. The string begins with an 'a'
b. Each 'a' is followed by nothing or an 'a' or "bb"
c. Each "bb" is followed by nothing or an 'a'
If all the rules are followed by the given string, return true otherwise return false.
Sample Input:
abb
Sample Output:
true
Download Test Cases

public class Solution {

	public static boolean checkAB(String input) {
		// Write your code here
		
		boolean b=true;
		if(input.charAt(0)!='a'){
			b=false;
		}else{
			b=check(input);
		}
		
		return b;

	}
	
	public static boolean check(String s){
		
		if(s.length()==0)
			return true;
		boolean b=false;
		if(s.charAt(0)=='a'){
			if(s.length()==1){
				return true;
			}else if(s.charAt(1)=='a'){
				b=check(s.substring(1));
			}else if(s.length()>=3 && s.substring(1, 3).equals("bb")){
				b=check(s.substring(2));
			}else{
				return false;
			}
		}else if(s.charAt(0)=='b'){
			if(s.length()==1){
				return true;
			}else if(s.charAt(1)=='a'){
				b=check(s.substring(1));
			}else{
				return false;
			}
		}
		
		return b;
	}
}
