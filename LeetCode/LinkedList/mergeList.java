/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null)
            return l2 ;
        if(l2 == null)
             return l1 ;
        
        ListNode curr = null ; 
        ListNode head = null ;//new ListNode(0) ;
        
        while(l1 != null && l2 != null){
            
            if(head == null)
            {
                if(l1.val > l2.val){
                    head = l2 ;     
                    l2 = l2.next ;
                }else{
                    head = l1 ;
                    l1 = l1.next ;
                }
                curr = head ; 
            }else{
                if(l1.val > l2.val){
                    curr.next = l2 ;
                    l2 = l2.next ;
                    curr.next.next = null;
                
                }else{
                    curr.next = l1 ;
                    l1 = l1.next ;
                    curr.next.next = null ;
                    //l1 = l1.next ;
                }
                curr = curr.next ;
            }
            
        }
        
        if(l1 != null){
            curr.next = l1 ; 
        }
        if(l2 != null){
            curr.next = l2 ;
        }
        return head ;
        
        
    }
}
