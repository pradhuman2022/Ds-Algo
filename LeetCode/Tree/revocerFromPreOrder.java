class Solution {
    int index = 0;
    public TreeNode recoverFromPreorder(String S) {
        return buildTree(S, 0);      
    }
    /*
        we will have depth of current node, now we need to check 
        whatever node is coming after dashses having same number of dashesh as its depth,
        1-2--4
        now if, index will point to 4th index which is - then find number of dashes which 2 for 
        4,and depth is also 2 so we need to create node, if it is not true just return null.
        m solution to likh para tha but kb muje next node ni dalana wali condition par ni kar para tha.
    */
    public TreeNode buildTree(String s, int depth) {
        
        int numberOfDashes = 0;
        int currentIndex = index; 
        while(currentIndex < s.length() && s.charAt(currentIndex) == '-') {
            System.out.print(Character.toString(s.charAt(currentIndex))+" ");
            numberOfDashes++;
            currentIndex++;
            
        }
        if(numberOfDashes != depth)
            return null;
        String nodeValue = "";
        while(s.length() > currentIndex && s.charAt(currentIndex) != '-') {
            nodeValue += s.charAt(currentIndex);
            currentIndex++;
        }            
        TreeNode root = new TreeNode(Integer.parseInt(nodeValue)); 
        index = currentIndex; 
        root.left = buildTree(s, depth + 1);
        root.right = buildTree(s, depth + 1);
        return root;
    }
    
}
