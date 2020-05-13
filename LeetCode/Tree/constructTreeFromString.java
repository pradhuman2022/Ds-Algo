public class Solution {
    /**
     * @param s: a string
     * @return: a root of this tree
     */
    String str ;
    public TreeNode str2tree(String s) {
        // write your code here
        str = s;
        return buildTree(0, s.length() - 1);
    }
    /*
        mostly solution hogya tha bs negative integer k liy or multiple digit number k liy
        handle krana tha, baki krlia tha khud se.
    */
    public TreeNode buildTree(int start, int end) {
        if(start > end)
            return null ;
            
        String currentRoot = "";
        int temp = start;
        while(start <= end && str.charAt(start) != '(') {
            currentRoot += str.charAt(start++);
        }
        start--;
        int Value = Integer.parseInt(currentRoot);
        TreeNode root = new TreeNode(Value);
        int paritionIndex = findParitionIndex(start, end);
        if(paritionIndex == -1)
            return root;
        root.left = buildTree(start + 2, paritionIndex - 1);
        root.right = buildTree(paritionIndex + 2, end - 1); 
        return root;
    }
    public int findParitionIndex(int start, int end) {
        int brackets = 0;
        for(int i = start; i <= end; i++) {
            if(str.charAt(i) == '(')
                brackets++;
            else if(str.charAt(i) == ')')
                brackets--;
            //System.out.print(brackets+" ");
            if(brackets == 0 && str.charAt(i) == ')')
                return i;
        }  
        return -1;
    }
}
