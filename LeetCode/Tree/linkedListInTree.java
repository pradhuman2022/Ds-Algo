class Solution {
   /*
   I was not able write solution for it.
   */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null)
            return true;
        if(root == null)
            return false;
        return isSubPathPresent(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    public boolean isSubPathPresent(ListNode head, TreeNode root) {
        if(head == null)
            return true;
        if(root == null)
            return false;
        
       return head.val == root.val && (isSubPathPresent(head.next, root.left) ||  isSubPathPresent(head.next, root.right));
       
    }
}
