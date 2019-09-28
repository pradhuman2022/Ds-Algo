/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        
           ListNode fast = A ;
           ListNode slow = A ;
           
           while(fast != null && fast.next != null){
               fast = fast.next.next ;
               slow = slow.next ;
               if(slow == fast)
                 break ;
           }
          
          if(fast == slow)
            return removeCycle(fast , A);
          else
            return A ; 
    }
    
      ListNode removeCycle(ListNode slow, ListNode head){
        
        ListNode p1 = head ; 
        ListNode p2 ;
        
        while(true){
            p2 = slow;
            
            while(p2.next != p1 && p2.next != slow)
              p2 = p2.next ;
              
            if(p2.next == p1)
              {
                  p2.next = null ;
                  break ;
              }
            p1 = p1.next;
        }
      return head ; 
      }
}
