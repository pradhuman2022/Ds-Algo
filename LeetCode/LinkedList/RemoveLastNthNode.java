/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
            
             ListNode dummy = new ListNode(0) ;
             dummy.next = head ; 
             ListNode curr = head ;
             
             int len = 0 ; 
             while(curr != null){
                 len++ ;
                 curr = curr.next ; 
             }
            curr = dummy ; 
            ListNode prev = null ;
            int lenToTravel =  len - n ;
            len = 0 ;    
            while(len < lenToTravel){
                System.out.println(curr.val) ;
                curr = curr.next ;
                len++;
            }
        //   if(prev != null)
            System.out.println(curr.next.val);
            curr.next = curr.next.next ;
            return dummy.next ;
    }
}
