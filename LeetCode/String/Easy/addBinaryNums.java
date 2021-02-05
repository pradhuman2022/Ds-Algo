class Solution {
    public String addBinary(String a, String b) {
          
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean carry = false;
        StringBuilder ans = new StringBuilder();
        
        while(i >= 0 && j >= 0) {
            
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(j) - '0';
            
            if(num1 == 1 && num2 == 1) {
                if(carry) {
                    ans.append(Integer.toString(1));
                } else {
                    ans.append(Integer.toString(0));
                }
                carry = true;
            } else {
                if(num1 == 1 && num2 == 0 || num1 == 0 && num2 == 1) {
                    if(carry) {
                        ans.append(0);
                    } else {
                        ans.append(1);
                    }
                } else {
                    if(carry) {
                        ans.append(1);
                        carry = false;
                    } else {
                        ans.append(0);
                    }
                }   
            }
            
            i--;
            j--;
        }
        
        while(i >= 0) {
            int num1 = a.charAt(i) - '0';
            if(num1 == 1) {
                if(carry) {
                    ans.append(0);
                } else {
                    ans.append(1);
                }
            } else {
                if(carry) {
                    ans.append(1);
                } else {
                    ans.append(0);
                }
                carry = false;
            }
            
            i--;
        }
        
        while(j >= 0) {
            int num1 = b.charAt(j) - '0';
            if(num1 == 1) {
                if(carry) {
                    ans.append(0);
                } else {
                    ans.append(1);
                }
            } else {
                if(carry) {
                    ans.append(1);
                } else {
                    ans.append(0);
                }
                carry = false;
            }
            
            j--;
        }   
        
        if(carry)
            ans.append(1);
        return ans.reverse().toString();
        
    }
}
