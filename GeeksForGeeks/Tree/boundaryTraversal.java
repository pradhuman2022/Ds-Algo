class Solution
{
	void printBoundary(Node node)
	{ 
	    if(node == null)
	        return; 
	    System.out.print(node.data + " ");
	    printLeftBoundary(node.left);
	    printLeaves(node.left);
	    printLeaves(node.right);
	    printRightBoundary(node.right);
	}
	
	void printLeftBoundary(Node node) {
	    if(node == null)
	        return ;
	    if(node.left != null) {
	        System.out.print(node.data+" ");
	        printLeftBoundary(node.left);
	    }else if(node.right != null){
	        System.out.print(node.data+" ");
	        printLeftBoundary(node.right);
	    }
	}
	
	void printLeaves(Node node) {
	    if(node == null)
	        return ;
	    printLeaves(node.left);
	    if(node.right == null && node.left == null)
	        System.out.print(node.data+" ");
	    printLeaves(node.right);
	}
	
	void printRightBoundary(Node node) {
	    if(node == null) 
	        return;
	    if(node.right != null) {
	        printRightBoundary(node.right);
	        System.out.print(node.data+" ");
	    }else if(node.left != null) {
	        printRightBoundary(node.left);
	        System.out.print(node.data+" ");
	    }
	}
}
