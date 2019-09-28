class LinkedList
{
    
        // add your code here
          //return middle of linkedlist-----------------
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
