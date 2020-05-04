class Solution {
    List<List<Integer>> ansList = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target = sum;
        if(root == null)
            return ansList;
        findPathSum(root, root.val);
        return ansList;
    }
    /*
     yeh solution khud se kiye mene chlo kuch to shanti mili, but yar time jyda lga diya itna jra sa souchne me.
    */
    public void findPathSum(TreeNode root, int Sum) {
        
        if(root == null && Sum != target){
            return ;
        }
        if(root != null && root.left == null && root.right == null && Sum == target){
            list.add(root.val);
            ArrayList<Integer> newList = new ArrayList<>(list);
            list.remove(list.size() - 1);
            ansList.add(newList);
            return ;
        }
        list.add(root.val);
        if(root.left != null){
            findPathSum(root.left, root.left.val + Sum);
        }
        if(root.right != null){
            findPathSum(root.right, root.right.val + Sum);
        }
        list.remove(list.size() - 1);
    }
    
}
