/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        
        ListNode next  = null;
        ListNode prev = null;
        ListNode curr = head ;
        int t = k;
        ListNode test = head;
        while(test!= null && t-->0)
            {
              test = test.next;
            }
        if(t > 0)
            return curr ;
        t  = k ;
        while(t-->0 && curr != null)
            {
              next = curr.next ;
            curr.next = prev ;
            prev = curr;
            curr = next;
        }
        
        if(curr != null){
            head.next = reverseKGroup(curr, k);
         }   
           
        return prev ;
        
    }
}
