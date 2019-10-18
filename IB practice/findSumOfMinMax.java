import java.util.* ;
import java.math.* ;
public class Solution {
    public int solve(int[] A, int k) {
      Deque <Integer> max = new ArrayDeque<Integer>(); 
      Deque <Integer> min = new ArrayDeque<Integer>() ;
      BigInteger sum = new BigInteger("0") ; 
      int mod = (int)Math.pow(10, 9) + 7;
      int n = A.length ;
      //int k = 0 ;//
      ///first go for first k windo
      int i = 0 ;
      for(; i < k ; i++){
          while(!max.isEmpty() && A[max.peekLast()] <= A[i])
              max.removeLast() ;
              
          max.add(i) ;
          
          while(!min.isEmpty() && A[min.peekLast()] >= A[i])
           min.removeLast() ;
           
          min.add(i) ;
      }
         
      
      for( ; i < n; i++) 
      {
          BigInteger minValue = new BigInteger(Integer.toString(A[min.peekFirst()])) ; // convert to string 
          BigInteger maxValue = new BigInteger(Integer.toString(A[max.peekFirst()])) ;
          BigInteger sum1 = minValue.add(maxValue) ;
          sum = sum.add(sum1) ;
      
             while(Math.abs(i - k) >= max.peekFirst())
               max.removeFirst(); 
             while(Math.abs(i - k) >= min.peekFirst())
               min.removeFirst() ;
             
            while(!max.isEmpty() && A[max.peekLast()] <= A[i])
              max.removeLast() ;
             
               max.add(i) ;
          
           while(!min.isEmpty() && A[min.peekLast()] >= A[i])
              min.removeLast() ;
           
             min.add(i) ;
      }
          BigInteger minValue = new BigInteger(Integer.toString(A[min.peekFirst()])) ; // convert to string 
          BigInteger maxValue = new BigInteger(Integer.toString(A[max.peekFirst()])) ;
          BigInteger sum1 = minValue.add(maxValue) ;
          sum = sum.add(sum1) ;
          sum = sum.mod(new BigInteger(Integer.toString(mod))) ;
          return sum.intValue();
    }
}
