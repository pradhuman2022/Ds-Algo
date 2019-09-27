/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
       ListNode curr = A ;
       ListNode dummy = new ListNode(0);
       ListNode prev = dummy;
       dummy.next = A ; 
       
       while(curr != null){
           
           while(curr != null && curr.next != null && curr.next.val == prev.next.val)
             curr = curr.next ; 
           
           if(prev.next == curr)
             prev = curr ; 
           else
             prev.next = curr.next ;
             curr = curr.next  ;
       }
       return dummy.next ;
    }
}
