class GFG { 
 
static int max(int x, int y)  
{  
    return (x > y) ? x : y;  
}  

static class Node  
{  
    int data;  
    Node left, right;  
};  

static int LISS(Node root)  
{  
   
   if(root == null) 
    return 0 ; 
   //if we exclude current node from our set then find subset in left and right then sum up them.
   int excludeCurrent = LISS(root.left) + LISS(root.right) ; 
   
   //if we include in our set then include 
   int subsetSize = 0 ; 
   if(root.left != null) { 
       subsetSize = LISS(root.left.left) + LISS(root.left.right);
   }
   
   if(root.right != null) {
       subsetSize += LISS(root.right.right) + LISS(root.right.left) ; 
   }

   return max(subsetSize + 1, excludeCurrent) ; 
}  
  
// A utility function to create a node  
static Node newNode( int data )  
{  
    Node temp = new Node(); 
    temp.data = data;  
    temp.left = temp.right = null;  
    return temp;  
}  
  
// Driver Code 
public static void main(String args[]) { 
    // Let us construct the tree  
    // given in the above diagram  
    Node root = newNode(20);  
    root.left = newNode(8);  
    root.left.left = newNode(4);  
    root.left.right = newNode(12);  
    root.left.right.left = newNode(10);  
    root.left.right.right = newNode(14);  
    root.right = newNode(22);  
    root.right.right = newNode(25);  
  
    System.out.println("Size of the Largest"
        + " Independent Set is "
        + LISS(root));  
    } 
} 
