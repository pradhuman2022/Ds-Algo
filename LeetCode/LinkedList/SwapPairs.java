/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode next  = null;
        ListNode prev = null;
        ListNode curr = head ;
        int t = 2;
        ListNode test = head;
        while(test!= null && t-->0)
            {
              test = test.next;
            }
        if(t > 0)
            return curr ;
        t  = 2 ;
        while(t-->0 && curr != null)
            {
              next = curr.next ;
            curr.next = prev ;
            prev = curr;
            curr = next;
        }
        
        if(curr != null){
            head.next = swapPairs(curr);
         }   
           
        return prev ;
    }
}
