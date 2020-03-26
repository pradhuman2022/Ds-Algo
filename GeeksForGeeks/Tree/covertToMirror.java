class Tree
{
void mirror(Node node)
{
// Your code here
if(node == null)
return ;

Node left = node.left;
node.left = node.right;
node.right = left;
mirror(node.left);
mirror(node.right);

}
}
