/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode head) {
        
        if(head == null || head.next == null)
           return null ; 
        
        ListNode fast = head ; 
        ListNode prev = null ;
        ListNode slow = head ; 
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next ;
            prev = slow ;
            slow =  slow.next ;
        }
        prev.next = slow.next ; 
        return head ; 
    }
}
