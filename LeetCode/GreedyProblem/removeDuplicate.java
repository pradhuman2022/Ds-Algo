class Solution {
    public String removeDuplicateLetters(String s) {
        
        return removeDuplicateMonoStack(s);
    }
    
  
  //just choose smallest character and remove top char from stack if 
  //top element is lesser and present in next part of string.
    public String removeDuplicateMonoStack(String s) {
        Stack<Character> st = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(!seen.contains(s.charAt(i))) {
                
                while(!st.isEmpty() && st.peek() > c && map.get(st.peek()) > i) {
                    seen.remove(st.pop());
                }
                seen.add(c);
                st.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder(st.size());
        for (Character c : st) sb.append(c.charValue());
        return sb.toString();
    }
}
