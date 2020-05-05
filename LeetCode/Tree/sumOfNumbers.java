class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null)
            return 0; 
        List<String> ansList = findSumNumbers(root);
        for (String num: ansList)
            sum += Integer.valueOf(num);
        
        return sum;   
    }
    List<String> findSumNumbers(TreeNode root){
        List<String> ansList = new ArrayList<>();
        if(root.left == null && root.right == null){
            ansList.add(Integer.toString(root.val));
            return ansList;
        }
        List<String> leftTree = new ArrayList<>();
        if(root.left != null)
            leftTree = findSumNumbers(root.left);
        List<String> rightTree = new ArrayList<>();
        if(root.right != null)
           rightTree = findSumNumbers(root.right);
        for(String num: leftTree){
            ansList.add(root.val + num);
        }
        for(String num: rightTree){
            ansList.add(root.val + num);
        }
       return ansList;
    }
    
}
