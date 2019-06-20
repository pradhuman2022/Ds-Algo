public class Solution {
    public String countAndSay(int A) {
        String ans = "" ; 
        StringBuilder curr = new StringBuilder("1") ;
        A-- ;
        while(A-- > 0)
        {
            int index = 0 ;
            StringBuilder temp = new StringBuilder() ;
            while(index < curr.length())
            {
                int freq = 1 ;
                while(index + 1 < curr.length() && curr.charAt(index) == curr.charAt(index + 1))
                {
                    freq++ ;
                    index++ ;
                }
                temp = temp.append(Integer.toString(freq)+curr.charAt(index));
                index++ ;
            }
            curr = temp ;
        }
        return curr.toString() ;
    }
}
