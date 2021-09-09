class Solution {
    public int minDeletionSize(String[] strs) {
        //jsut think in terms of matrix
        // if previos column is sorted then why do we want to sort the next columns(greedy)
        //   so we only delete a column if we sure that previous columns are not sorted
        //        col
        //  row [    ]
        boolean sorted [] = new boolean[strs.length];
        int result = 0;
        int n = strs[0].length();
        
        for (int j = 0; j < strs[0].length(); j++) {
            
            int i = 0;
            for (; i < strs.length - 1; i++) {
                
                if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    System.out.println(j);
                    result++;
                    break;
                }
                
            }
            
            if (i < strs.length - 1) 
                continue;
            
            i = 0; 
            for (; i < strs.length - 1; i++) 
                if (strs[i].charAt(j) < strs[i + 1].charAt(j))
                    sorted[i] = true;
            
        }
        return result;
        
    }
}
