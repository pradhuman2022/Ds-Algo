public class Solution {
    /**
     * @param preorder: List[int]
     * @return: return a boolean
     */
     /*
       we can see in preorder of a tree is tha ki root sbse phle aata h then left fr right 
       ab agr koi v value jo ki root se choti h or right side aati h to preorder gltb hoga
       .
       jb b hmko koi bdi value milegi hm stack se eleement nikalte jyege jbtk current element se bdi
       value na mil jaye. last value jo hogi wo root ki value hogi. so ab next time jb preorder[i]
       check krege to preorder[i] > root kyuki hmne root k sare left ko traverse krlia hai.
     */
    public boolean verifyPreorder(int[] preorder) {
        // write your code here
        Stack<Integer> st = new Stack<Integer>();
        int root = Integer.MIN_VALUE;
        
        for(int i = 0; i < preorder.length; i++) {
            if(preorder[i] < root)
                return false;
                
            while(!st.isEmpty() && st.peek() < preorder[i]){
                root = st.pop();
            }
            st.push(preorder[i]);
        }
        return true;
    }
}
