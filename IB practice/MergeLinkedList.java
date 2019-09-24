/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        
        ListNode hA = A ;
        ListNode hB = B ;
        ListNode head = null;
        ListNode curr = null ;
        
        while(hA != null && hB != null)
        {
              if(head == null)
              {
                   if(hA.val > hB.val)
                    {
                        head = hB;
                        hB = hB.next;
                    }else{
                        head = hA;
                        hA = hA.next ;
                    }
                    curr = head ;
               }else if(hA.val > hB.val)
                {
                        curr.next = hB;
                        curr = hB ;
                        hB = hB.next;
                }else{
                        curr.next = hA;
                        curr = hA;
                        hA = hA.next ;
                }
        }
        while(hA != null)
        {
            curr.next = hA ;
            curr = hA ;
            hA = hA.next ;
        }
        while(hB != null)
        {
            curr.next = hB ;
            curr = hB ;
            hB = hB.next ; 
        }
        return head ;
    }
}
