class Loop{
    
    // This function will remove the loop from the linked list
    public static void removeTheLoop(Node a)
    {
        //Your code here
         Node fast = a.next.next ; 
	     Node slow = a ; 
	       
	       while(fast != null && fast.next != null && slow != fast)
	         {
	             fast = fast.next.next ;
	             slow = slow.next ; 
	         }
	         
	         if(slow != fast)
	           return  ;
	         else
	            getStartPoint(slow, a) ;
    }
    public static void getStartPoint(Node slow, Node head) {
	     Node ptr1 = head ;
	     Node ptr2 ; 
	     
	     while(true)
	     {
	         ptr2 = slow ; 
	         
	         while(ptr2.next != ptr1 && ptr2.next != slow)
	          ptr2 = ptr2.next ; 
	         
	         if(ptr2.next == ptr1)
	           break ; 
	         
	         ptr1 = ptr1.next ;   
	     }
	     ptr2.next = null ; 
	     
	 }
}
