/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
import java.util.* ;

public class Solution {
    public int lPalin(ListNode head) {
        
        Stack <ListNode> nodes = new Stack<ListNode>();
        ListNode curr = head ;
        
        while(curr != null){
            nodes.push(curr);
            curr = curr.next ;
        }
        
        curr = head ; 
        while(curr != null & !nodes.isEmpty()){
            if(curr.val != nodes.peek().val)
              return 0 ;
            curr = curr.next ; 
            nodes.pop();
        }
        return 1 ;
        
    }
}
