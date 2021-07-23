class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int left = -1;
        int right  = -1;
        
        for (int i = 0 ; i < nums.length; i++) {
        
            while(i <= nums.length - 1 && !st.isEmpty() && st.peek() > nums[i]) {
                left = i;
                i++;
            }
                   
            if(i < nums.length)
                st.push(nums[i]);
        }
        
        st.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while(i >= 0 && !st.isEmpty() && st.peek() < nums[i]) {
                right = i;
                i--;
            }

            if(i > 0)
                st.push(nums[i]); 
        }
        
        return  left < 0 || right < 0 ? 0 : left - right + 1;
    }
}
