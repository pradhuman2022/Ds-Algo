class Solution {
    HashMap<String, HashMap<String, Integer>> dp;
    public int kSimilarity(String A, String B) {
        dp = new HashMap<>();
        return f(A, B);
    }
    
    int f(String A, String B) {
        if(A.length() == 0 || B.length() == 0)
            return 0;
        
        if(dp.containsKey(A) && dp.get(A).containsKey(B))
            return dp.get(A).get(B);
        
        if(A.charAt(0) == B.charAt(0))
            return f(A.substring(1, A.length()), B.substring(1, B.length()));
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < B.length(); i++) {
            if(A.charAt(0) == B.charAt(i))  {
                String newA = A.charAt(i) + A.substring(1, i) + A.substring(i + 1, A.length());
                String newB = B.substring(0, i) + B.substring(i + 1, B.length());
                min = Math.min(min, f(newA, newB) + 1);
            }
        }
        
        HashMap<String, Integer> map = dp.getOrDefault(A, new HashMap<>());
        map.put(B, min);
        dp.put(A, map);
        return min;   
    }                     
}
