public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) 
            return "null";
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    int currentNode = 0; 
    public TreeNode deserialize(String data) {
        String treeNodes[] = data.split(",");   
        return buildTree(treeNodes);
    }
    /*
     i was not able to think about preorder and deserialize from string.
     bs preorder niklana hai or ek global var lekr sari serialize krlo
    */
    public TreeNode buildTree(String treeNodes[]) {
        if(currentNode >= treeNodes.length)
            return null;
        if(treeNodes[currentNode].equals("null")){
            currentNode++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(treeNodes[currentNode]));
        currentNode++;
        root.left = buildTree(treeNodes);
        root.right = buildTree(treeNodes);
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
