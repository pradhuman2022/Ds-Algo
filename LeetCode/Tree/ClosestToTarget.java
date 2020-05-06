public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    double minAbsDiff = Integer.MAX_VALUE;
    int secondValue = -1;
    public int closestValue(TreeNode root, double target) {
        // write your code here
        getNumberClosestToK(root, target);
        return secondValue;
    }
    /*
        actually BST ki jo property uska use kr skte ki agr root ka value target se bda h theek to 
        agr hm right m jayge to gap bdega , so hm log root ke left m jyge ok.
        if root ka value target se chota h to agr left m gye to fr gap se bd jyga then hmko right m 
        ana chaiye so hm right m move krege.
        
        i wasnt able to think about this gap wala thing.
    
    */
    void getNumberClosestToK(TreeNode root, double target) {
        if(root == null)
            return ;
        if(root.val == target){
            secondValue = root.val;
            return ;
        }        
        if(minAbsDiff > Math.abs(root.val - target)) {
            minAbsDiff = Math.abs(root.val - target);
            secondValue = root.val;
        }
        if(target < root.val)
            getNumberClosestToK(root.left, target);
        else
            getNumberClosestToK(root.right, target);
    }
}
