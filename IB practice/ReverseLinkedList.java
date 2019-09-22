class ReverseLL
{
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverseList(Node head)
   {
       
       Node curr = head  ;
       Node prev = null ; 
       Node next = null ;
       
       while(curr != null)
       {
           next = curr.next ; 
           curr.next = prev ;
           prev = curr ;
           curr = next ;
       }
       return prev ; 
        // add code here
       /* if(head == null)
          return null ; 
        Node first = head ; 
        Node rest = head.next ; 
        
        if(rest == null)
           return head  ;
        
        Node h1 = reverseList(rest) ; 
        rest.next = first ; 
        first.next = null ; 
        head = rest ;
        return h1 ;*/
   }
    
       
}
