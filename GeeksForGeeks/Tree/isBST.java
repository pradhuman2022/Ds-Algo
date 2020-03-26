public class Tree
{
        boolean isBST(Node root)
        {
            // code here.
            if (root == null)
                return true;
            
            boolean leftIsBst = isBST(root.left);
            boolean rightIsBst = isBST(root.right);
            int max = max(root.left);
            int min = min(root.right);
            if(max < root.data && min > root.data) {
                if (leftIsBst && rightIsBst) {
                    max = Math.max(max, root.data);
                    min = Math.min(min, root.data);
                    return true;
                }
            }
            return false;
        }
    int max(Node root) {
        
        if(root == null)
            return Integer.MIN_VALUE;
        
        int leftMax = max(root.left);
        int rightMax = max(root.right);
        return Math.max(leftMax, Math.max(rightMax, root.data));
        
    }
    int min(Node root) {
        if(root == null)
            return Integer.MAX_VALUE;
        int leftMin = min(root.left);
        int rightMin = min(root.right);
        return Math.min(leftMin, Math.min(rightMin, root.data));
    }
}
