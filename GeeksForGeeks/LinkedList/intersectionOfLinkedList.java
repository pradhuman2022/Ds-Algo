/*class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}*/
class GFG
{
    static Node findIntersection(Node head1, Node head2)
    {
        
        // add your code here
        Node l1 = mergeSort(head1) ;
        Node l2 = mergeSort(head2) ;
        Node dummy = new Node(-1) ; 
        Node ans = dummy ;
        Node intersection = null;
        int latestVal  = -1 ;           
       while(l1 != null && l2 != null){
            // System.out.println(l1.data+" "+l2.data) ;
             if(l1.data == l2.data){
                 Node next = l1.next ;
                 if(l1.data != latestVal){
                     ans.next = l1;
                     ans.next.next = null ;
                     ans = ans.next ; 
                     latestVal = ans.data ;
                 }
                 l1 = next ; 
                 l2 = l2.next ; 
             }else if(l1.data > l2.data){
                 l2 = l2.next ;
             }else{
                 l1 = l1.next ;
             }
          //   System.out.println() ;
           
       }
       return dummy.next ; 
    }
     static Node getMiddle(Node h){
       
       if(h == null || h.next == null)
          return h ;
       
       Node fast = h.next ; 
       Node slow = h ;
       while(fast != null && fast.next != null){
            fast = fast.next.next ;
            slow = slow.next ;
       }
       return slow ;
    }
    static Node mergeSort(Node h){
        
        if(h == null || h.next == null)
          return h ;
        
        Node mid = getMiddle(h) ;
        Node right = mid.next ;
        mid.next = null ;
        Node leftSortedList = mergeSort(h) ;
        Node rightSortedList = mergeSort(right) ;
        Node sortedList = merge(leftSortedList, rightSortedList) ;
        return sortedList ;
    }
    //-----------------merge to merge sortedList------------------------
    
     static Node merge(Node left , Node right){
         
         if(left == null)
           return right ;
         if(right == null)
           return left ;
    
         Node mergeList ;  
         if(left.data <= right.data){
              mergeList = left ;
              mergeList.next = merge(left.next, right) ;
         }else
         {
             mergeList = right ;
             mergeList.next = merge(left, right.next) ;
         }
         
         return mergeList ;
     }
  
}
