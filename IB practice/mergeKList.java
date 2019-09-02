/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> a) {
	       Queue<ListNode> pq = new PriorityQueue<ListNode>((k, b) -> k.val - b.val) ;
	         
	         for(ListNode l : a)
	         {
	             if(l != null)
	               pq.add(l) ;
	         }
	        ListNode head = null ;
	        ListNode curr = null ; 
	        
	        while(!pq.isEmpty())
	        {
	            ListNode l  = pq.poll() ;
	            if(head == null)
	            {
	                head = l ; 
	                curr = l ;
	            }
	            else
	            {
	                curr.next = l ; 
	                curr = l ;
	            }
	           if(l.next != null)
	             pq.add(l.next) ;
	        }
	        return head ;
	}
}
