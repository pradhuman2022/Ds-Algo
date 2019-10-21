public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        
        Deque <Integer> neg = new LinkedList<Integer>() ; 
        
        for(int i = 0 ; i < B ; i++){
            if(A.get(i) < 0)
               neg.add(i) ;
            
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>() ;
        
        for(int i = B ; i < A.size() ; i++){
            ans.add( neg.isEmpty() == false ? A.get(neg.peekFirst()) : 0) ; 
            
            while(!neg.isEmpty() && neg.peekFirst() <= i - B)
              neg.removeFirst() ;
              
            if(A.get(i) < 0)
               neg.add(i) ;
               
            
        }
          ans.add( neg.isEmpty() == false ? A.get(neg.peekFirst()) : 0) ; 
              
        return ans; 
    }
}
