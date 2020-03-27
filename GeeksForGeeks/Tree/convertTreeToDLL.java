class GfG
{
Node head;
Node bToDLL(Node root)
{
// Your code here
if(root == null)
return null;
//assume we converted right subtree to DLL
bToDLL(root.right);


//so whatever the head we need to make it as next of root/current node.

root.right = head ;


//if we have already head then we need to make current node as previous.
if(head != null)
head.left = root ;
//head will our root.

head = root;
/*till now , we convert our tree from root to its right subtree, will have DLL. Now we will convert left substree to DLL.*/

bToDLL(root.left);
return head ;
}
}
