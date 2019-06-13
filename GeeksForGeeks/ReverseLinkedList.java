/* class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
} */
class ReverseLL
{
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverseList(Node head)
   {
        // add code here
       // Node current = head ; 
        Node prev = head ;
        while(prev.next != null)
        {
            Node current = prev.next ;
            prev.next = current.next ;
            current.next = head ;
            head = current ;
        }
        return head ;
   }
}
