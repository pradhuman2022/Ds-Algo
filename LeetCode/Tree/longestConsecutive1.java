public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    int longestConsecutiveSequence = 1;
    ArrayList<NodeInfo> list = new ArrayList<>();
    public int longestConsecutive(TreeNode root) {
        // write your code here
        findLongestSequence(root);
        return longestConsecutiveSequence;
    }
    /*
       I was able to solve this question, there was only runtime error because of constructor.
    */
    public NodeInfo findLongestSequence (TreeNode root) {
        if(root == null) {
            NodeInfo newNode = new NodeInfo(Integer.MAX_VALUE, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            return newNode;
        }
        NodeInfo leftSequence =  findLongestSequence(root.left);
        NodeInfo rightSequence = findLongestSequence(root.right);
        int sequenceSize = 1; 
        int max = root.val ; 
        int min = root.val;
        
        if(root.val < leftSequence.startingNodeValue && root.val + 1 == leftSequence.startingNodeValue && leftSequence.min > root.val) {
            max = leftSequence.max;
            min = root.val; 
            sequenceSize = leftSequence.sequenceSize + 1;    
        }
        if(root.val < rightSequence.startingNodeValue && root.val + 1 == rightSequence.startingNodeValue && rightSequence.min > root.val) {
            sequenceSize = Math.max(sequenceSize, rightSequence.sequenceSize + 1);
            min = root.val; 
            max = rightSequence.max;
        }
        longestConsecutiveSequence = Math.max(sequenceSize, longestConsecutiveSequence);
        NodeInfo newNode = new NodeInfo(root.val,  sequenceSize, max, min);
        return newNode;
    }
   class NodeInfo {
       int startingNodeValue;
       int sequenceSize;
       int min;
       int max; 
       NodeInfo(int startingNodeValue, int sequenceSize, int max, int min) {
           this.startingNodeValue = startingNodeValue;
           this.sequenceSize = sequenceSize;
           this.min = min;
           this.max = max;
       }
   } 
}
