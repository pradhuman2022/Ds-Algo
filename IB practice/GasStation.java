public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int canCompleteCircuit(final int[] A, final int[] B) {
        int start = 0; //start position
        int remain = 0; //current remain gas
        int debt = 0; //previous trips owes gas
        
        for(int i = 0; i < A.length; i++){
            remain += A[i] - B[i];
            if(remain<0){
                debt += remain;
                start = i + 1;
                remain = 0;
            }
        }
        
        return remain + debt >= 0 ? start : -1;
        
    }
}
