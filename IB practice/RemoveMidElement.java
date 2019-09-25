/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    
    public ListNode solve(ListNode a) {
        
        ListNode fast = a ;
        ListNode slow = a ;
        ListNode prev = null;
        if(a.next == null)
          return null ;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            prev = slow ;
            slow = slow.next ;
        }
        
        if(prev != null)
        prev.next = slow.next ;
        
        return a ; 
    }
}
