class Solution {
    public String addStrings(String num1, String num2) {
       
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        
        while(len1 >= 0 || len2 >= 0) {
            int x1 = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int x2 = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int res = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            result.append(res);
            len1--;
            len2--;
        }    
        
        if(carry != 0)
            result.append(carry);
        
        return result.reverse().toString();
    }
}
