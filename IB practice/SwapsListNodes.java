/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
         ListNode prev = null  ;
         ListNode curr = A ; 
         while(curr != null && curr.next != null)
         {
              if(prev == null)
            {
               
               A = curr.next;
               curr.next = A.next ; 
               A.next = curr ;
               prev = curr ;
               curr = curr.next ;
            }else{
                prev.next = curr.next ;
                curr.next = prev.next.next ;
                prev.next.next = curr ;
                prev = curr ;
                curr = curr.next ;
            }
              
         }
         return A ;
        
    }
}
