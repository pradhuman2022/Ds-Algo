class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);
        
        for (int i = 1 ; i < nums.length; i++) {
            //if top of stack is greater than current then pop until you hit lesser number but ensure to keep 
            //space to cover remaining elements;
            if(st.peek() > nums[i]) {
                int rem = nums.length - i - 1;
                while(!st.isEmpty() && st.peek() > nums[i] && st.size() + rem >= k) {
                    st.pop();
                }
            }
            st.push(nums[i]);
        }
        
        while(st.size() > k)
            st.pop();
        
        System.out.println(st.size());
        int ans[] = new int[k];
        for(int i = k - 1 ; i >= 0; i--) {
            ans[i] = st.pop();
        }
        
        return ans;
    }
}
