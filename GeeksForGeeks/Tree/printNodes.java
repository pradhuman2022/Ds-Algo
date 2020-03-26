class Tree
{
SortedSet<integer> list;

void printSibling(Node node)
{
// Your code here
list = new TreeSet<>();
printSibling1(node);
for(Integer n : list)
System.out.print(n+" ");
if(list.size() == 0)
System.out.print(-1);

}
void printSibling1(Node node)
{
// Your code here
if(node == null)
return;

if(node.left == null && node.right != null)
list.add(node.right.data);

if(node.right == null && node.left != null)
list.add(node.left.data);

printSibling1(node.right);
printSibling1(node.left);

}
}
