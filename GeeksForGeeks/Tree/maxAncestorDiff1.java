class Solution {
    public int maxAncestorDiff(TreeNode root) {
        NodeUtil r = maxAncestorDiff1(root);
        return r.res; 
    }
   
    static NodeUtil maxAncestorDiff1(TreeNode root) {
        NodeUtil node = new NodeUtil();
        if(root == null) {
            node.min = Integer.MAX_VALUE;
            node.max = Integer.MIN_VALUE;
            return node;
        }
        
        NodeUtil left = maxAncestorDiff1(root.left);
        NodeUtil right = maxAncestorDiff1(root.right);
        
        if(root.left == null && root.right == null) {
            node.min = root.val;
            node.max = root.val;
            return node;
        }
        int min = Math.min(left.min, right.min);
        int max = Math.max(left.max, right.max);
        int res = Math.abs(min - root.val);
        res = Math.max(res, Math.abs(max - root.val));
        res = Math.max(res, Math.max(left.res, right.res));
        node.min = Math.min(min, root.val);
        node.max = Math.max(max, root.val); 
        node.res = res;
        
        return node; 
    }
    
   static class NodeUtil{
       int min;
       int max;
       int res;
   }
}
