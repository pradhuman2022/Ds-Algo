/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {
        ListNode less = null ;
        ListNode greater = null ; 
        
        ListNode lessCurr = null ;
        ListNode greaterCurr = null ;
        
        ListNode curr = A ;
        
        while(curr != null){
            if(curr.val < B)
             {
                 if(less == null){
                     less = curr  ;
                     lessCurr = curr ;
                 }else{
                     lessCurr.next = curr  ;
                     lessCurr = curr ;
                 }
                 curr = curr.next ;
                 lessCurr.next = null  ;
             }else
             {
                 if(greater == null){
                    greater = curr ;
                    greaterCurr = curr ;
                 }else{
                     greaterCurr.next = curr ;
                     greaterCurr = curr;
                 }
                 curr = curr.next ;
                 greaterCurr.next = null ;
             }
        }
        ListNode ans ;
        if(less != null)
        {
            lessCurr.next = greater;
            ans = less ;
        }else
        ans = greater ;
        return ans ;
    }
    
}
