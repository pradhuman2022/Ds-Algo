/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode a) {
	       ListNode fast = a.next.next ; 
	       ListNode slow = a ; 
	       
	       while(fast != null && fast.next != null && slow != fast)
	         {
	             fast = fast.next.next ;
	             slow = slow.next ; 
	         }
	         
	         if(slow != fast)
	           return null ;
	         else
	           return getStartPoint(slow, a) ;
	}
	
	 public ListNode getStartPoint(ListNode slow, ListNode head) {
	     ListNode ptr1 = head ;
	     ListNode ptr2 ; 
	     
	     while(true)
	     {
	         ptr2 = slow ; 
	         
	         while(ptr2.next != ptr1 && ptr2.next != slow)
	          ptr2 = ptr2.next ; 
	         
	         if(ptr2.next == ptr1)
	           break ; 
	         
	         ptr1 = ptr1.next ;   
	     }
	     return ptr2.next ; 
	     
	 }
}
