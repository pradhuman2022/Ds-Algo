class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>(); // contains previous smaller values
        Stack<Integer> st1 = new Stack<>(); // contains next smaller values
        int leftLimit[] = new int[heights.length];
        int rightLimit[] = new int[heights.length];
        Arrays.fill(rightLimit, -1);
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        
        for (int i = 0; i < n; i++) {
            int barHeight = heights[i];
            if(st.isEmpty()) {
                leftLimit[i] = 0;
            } else {
                while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                    st.pop();
                }
                
                leftLimit[i] = st.isEmpty() ? 0 : st.peek() + 1;
            }
            st.push(i);
            
            while(!st1.isEmpty() && heights[i] <= heights[st1.peek()]) {
                rightLimit[st1.pop()] = i - 1; 
            }
            st1.push(i);
        }
        
            for (int i = 0; i < n; i++) {
             rightLimit[i] = rightLimit[i] == -1 ? n - 1: rightLimit[i] ;
             maxArea = Math.max(maxArea, (rightLimit[i] - leftLimit[i] + 1) * heights[i]);
         }
         
         return maxArea;
    }
    
    private void findPreviousSmallerBar(Stack<Integer> st, int leftLimits[]) {
        
        while(!st.isEmpty()) {
            
        }
    }
    
    
}
