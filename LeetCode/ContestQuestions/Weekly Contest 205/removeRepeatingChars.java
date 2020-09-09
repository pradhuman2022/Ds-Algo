class Solution {
    public String modifyString(String s) {
    /*B ? A   A ? A  A ? B
    B ? ?   A ? ?
    B ? B   
        
    i == 0 ? ? X   ? A X     ? X A
                   B A X     A X A
        
    B A ?
    A B ? **/
   if(s.length() == 1)
        return "a";     
    char ch [] = s.toCharArray();
    for (int i = 0; i < ch.length; i++) {
        if(ch[i] == '?') {
            if(i == 0) {
                if(ch[i + 1] == '?') {
                   ch[i] = 'a'; 
                } else {
                    ch[i] = ch[i + 1] != 'a' ? 'a' : 'b'; 
                }
            } else if(i == ch.length - 1) {
                ch[i] = ch[i - 1] != 'a' ? 'a' : 'b'; 
            } else {
                ch[i] = ch[i - 1] != 'a' && ch[i + 1] != 'a' ? 'a' : (ch[i - 1] == 'b' && ch[i + 1] == 'a' || ch[i + 1] == 'b' && ch[i - 1] == 'a' ) ? 'c' : 'b';
            } 
        }
      
    }
     return new String(ch);     
}
    
}
