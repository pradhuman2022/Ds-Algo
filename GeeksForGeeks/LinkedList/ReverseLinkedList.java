class ReverseLL
{
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverseList(Node head)
   {
        // add code here
        if(head == null)
          return null ; 
        Node first = head ; 
        Node rest = head.next ; 
        
        if(rest == null)
           return head  ;
        
        Node h1 = reverseList(rest) ; 
        rest.next = first ; 
        first.next = null ; 
        head = rest ;
        return h1 ;
   }
    
       
}
