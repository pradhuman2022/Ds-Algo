import java.util.* ; 

public class Solution {
     
    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>() ; 
    List<Stack<Integer>> freq = new ArrayList<Stack<Integer>>() ; 
    
    
    public int push(int x){
        map.put(x, map.getOrDefault(x, 0) + 1) ;
        int currFreq = map.get(x) ; 
        
        if(currFreq - 1 >= freq.size()) 
          freq.add(new Stack<Integer>()) ; 
         
        freq.get(currFreq - 1).push(x) ;
        return -1; 
    }
    
    public int pop(){
        int maxFreq = freq.size() ; 
        int x = freq.get(maxFreq - 1).pop() ; 
        
        if(freq.get(maxFreq - 1).isEmpty())
          freq.remove(maxFreq - 1) ;
        
        map.put(x, map.get(x) - 1) ;
        
        if(map.get(x) == 0)
         map.remove(x)  ;
        return x ; 
    }
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
         
            ArrayList<Integer> ans = new ArrayList<Integer> () ; 
            
            for(ArrayList <Integer> a : A){
               if(a.get(0) == 1)
                  ans.add(push(a.get(1))) ;
                else
                  ans.add(pop()) ; 
            }
           return ans ; 
    }
}
