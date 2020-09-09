class Solution {
    public int minCost(String s, int[] cost) {
       Stack<Integer> st = new Stack();
       st.push(0);
       long currentCost = 0;
       
       for (int i = 1; i < s.length(); i++) {
           if(s.charAt(st.peek()) == s.charAt(i)) {
               if(cost[st.peek()] < cost[i]) {
                   currentCost += cost[st.peek()];
                   st.pop();
                   st.push(i);
               } else {
                 currentCost += cost[i];
               }
           }else {
                st.push(i);
           }
       }
        return (int)currentCost;
    }
}
