 */
import java.util.* ;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        return priority_QSol(lists) ;
    }
    // NLogK + O(K)for space 
    ListNode priority_QSol(ListNode list[])
    {
        Queue<ListNode>pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val)  ;   
          
        for(ListNode l : list)
             if(l != null) pq.add(l) ;

        ListNode head = null ;
        ListNode curr = null ;
        
        while(!pq.isEmpty())
        {
            
            ListNode l = pq.poll() ;
            if(head == null)
            {
                head = l ; 
                curr = l ;
            }else
            {
                curr.next = l ; 
                curr = l ;
            }
            if(l.next != null)
            {
               pq.add(l.next) ; 
            }
        }        
        return head ;
    }
    
    //N * K + O(1)space
    ListNode NK_BruteForce(ListNode [] list)
    {
        ListNode head = null;
        ListNode curr = null;
        
        boolean isNodes = true ;
        int size = list.length ;
        
        while(isNodes)
        {
            if(size > 0)
            {  
                ListNode point = new ListNode(Integer.MAX_VALUE) ;
                int index  = 0 ;
                int temp = list.length ;
                for(int i = 0 ; i < list.length ;i++)
                {
                      if(list[i] != null && point.val > list[i].val)
                      {
                          point = list[i] ;
                          index = i ;
                      }
                     if(list[i] == null)
                         temp-- ;
                }
                size = temp ;
                list[index] = point.next ;
                
                if(temp > 0)
                {
                if(head == null)
                {
                    head = point  ;
                    curr = point ;
                }else
                {
                curr.next = point ;
                curr = point ;            
                }
                }
            }
            if(size == 0)
                isNodes = false ;
        }
        return head ;
    }    
    
}
