/*
I was not able to think about how should i store value in arraylist. 
I was able to handle size wise answer condition. 
*/

public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int currentSum = 0;
        int maxSum = 0 ;
        ArrayList<Integer> max = new ArrayList<Integer>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        
        for(int v : A) {
            if(v >= 0){
                currentSum += v ;
                curr.add(v); 
            }
            else{
                currentSum = 0 ;
                curr = new ArrayList<Integer>(); 
            }
            if((currentSum > maxSum) || ((currentSum == maxSum) && (curr.size() > max.size()))) {
                maxSum = currentSum ;
                max = curr; 
            }
        }
        return max;     
    }
}
