class Tree
{
    public static void connect(Node p)
        {
            // code here.
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(p);
            
            while(!queue.isEmpty()) {
                Queue<Node> curr = new LinkedList<Node>();
                Node prev = null;
                while(!queue.isEmpty()) {
                    Node front = queue.poll() ; 
                    if(prev != null) {
                        prev.nextRight = front;
                    }
                    prev = front;
                    if(front.left != null)
                        curr.offer(front.left);
                    if(front.right != null)
                        curr.offer(front.right);
                }
                queue = curr ;
            }
        }
        
}
