class Solution {
    public int[] findPermutation(String s) {
     
    Stack<Integer> st = new Stack<>();
    int ans[] = new int[s.length() + 1];
    int index = 0;
    for (int i = 1; i <= s.length(); i++) {
if (s.charAt(i - 1) == 'I') {
	st.push(i);
 	while(!st.isEmpty()) {
	ans[index++] = st.pop();
}
} else {
	st.push(i);
}
    }
    
  st.push(s.length() + 1);     
  while(!st.isEmpty()) 
ans[index++] = st.pop();

        return ans;
}
}

