class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix.length == 0)
            return 0;
        
        int maximumSizedRectangle = Integer.MIN_VALUE;
        int dp[]= new int[matrix[0].length];
        int maxAreaRectangle = Integer.MIN_VALUE;
        
        for (int i = 0; i < matrix.length; i++) {
                int temp[] = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxAreaRectangle = Math.max(maxAreaRectangle, getMaxAreaRectangle(temp));
            dp = null;
            dp = temp;
        }
        
        return maxAreaRectangle;
    }
    
    
    private int getMaxAreaRectangle(int histo[]) {
        Stack<Integer> st = new Stack<>();
        
        int leftLimit[] = new int[histo.length];
        int rightLimit[] = new int[histo.length];
        Arrays.fill(rightLimit, -1);
        for (int i = 0; i < histo.length; i++) {
            if(st.isEmpty()) {
                st.push(i);
            } else {
                while(!st.isEmpty() && histo[st.peek()] >= histo[i]) {
                    rightLimit[st.pop()] = i - 1;
                }
                leftLimit[i] = st.isEmpty() ? 0 : st.peek() + 1; 
            }
            st.push(i);
        }
        
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < histo.length; i++) {
            rightLimit[i] = rightLimit[i] == -1 ? histo.length - 1 : rightLimit[i];
            
            maxArea = Math.max(maxArea, (rightLimit[i] - leftLimit[i] + 1) * histo[i]);
        }
        return maxArea;
    }
}
