/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    HashMap<Integer, HashMap<Integer>>  diffSet;
	public static void main(String[] args) {
		diffSet = new HashSet<>();
		nodeValues = new HashSet<>();
		mapForNodeToLevel = new HashMap<>();
		
		inorder(root);
	    TreeNode x1 
	    TreeNode x2
	    
	
	}
	
	public void inorder(TreeNode root, int level) {
	    if (root == null)
	        return;
	    
	    diffSet.add(x - root.value);
	    inoder(root.left, level + 1);
	    inorder(root.right, level + 1);
	}
	
	public boolean isPairExist(TreeNode root) {
	    
	    if(root == null)
	        return false;
	    
	    if (diffSet.contains(root.value)) {
	        return true;
	    }
	    
	    return isPairExist(root.left) || isPairExist(root.right);
	}
	
	/**
	 * Tree 
	 * x 
	 * find a if there is any such pair whose sum will be x
	 * 
	 * {1, 1, 2}
	 * x = 3
	 * a + b = x
	 * a = x - b
	 * 
	 * sorted array find single element 
	 * 1, 1, 2, 2, 3, 3, 4, 5, 5
	 * 
	 * 0, 1, 2, 3, 4, 5, 6, 7, 8
	 * 
	 * 
	 * yes yes yes, no no non o
	 * start = 0;
	 * end = 8
	 * mid = 4;
	 * 
	 * if (mid is even)
	 *  then check its value is present at next index
	 * 
	 * 1, 1, 2, 2, 3, 4, 4
	 * 
	 * 0, 1, 2, 3, 4, 5, 6
	 * start == 0 
	 * end = 6
	 * 
	 * start = 4
	 * end = 6
	 * mid = 5
	 * 
	 * start = 4
	 * end = 5
	 * mid = 4
	 * 
	 * start = 4
	 * end = 4
	 * mid = 4
	 * */
	 
	 public boolean isSingleElementExist(int arr[]) {
	     int start = 0;
	     int end = arr.length - 1;
	     
	     while(start < end) {
	         int mid = (start + end) / 2;
	         
	         if (mid % 2 != 0) {
	             if (arr[mid] != arr[mid - 1]) 
	                end = mid - 1;
	             else   
	                start = mid + 1;
	         } else {
	             if (arr[mid] != arr[mid + 1]) {
	                 end = mid;
	             } else {
	                 start = mid + 2;
	             }
	         }
	     }
	 }
}
