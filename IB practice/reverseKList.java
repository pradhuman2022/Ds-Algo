/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head, int k) {
        
        int count = 0 ;
        ListNode curr = head ; 
        ListNode prev = null ;
        ListNode next = null ;
        
        while(count++ < k && curr != null)
        {
            next = curr.next ;
            curr.next = prev ;
            prev = curr ; 
            curr = next ;
        }
        
        if(curr != null)
          head.next = reverseList(curr, k) ;
        
        return prev ;        
    }
    
   
}
