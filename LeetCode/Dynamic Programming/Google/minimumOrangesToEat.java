class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    public int minDays(int n) {
       dp = new HashMap<Integer, Integer>();
       
       return minDays1(n);
    }
    
    public int minDays1(int n) {
        if(n <= 1)
            return n;
        
        if (dp.containsKey(n))
            return dp.get(n);
        
        dp.put(n, 1 + Math.min(n % 2 + minDays1(n / 2), n % 3 + minDays1(n / 3)));
        
        return dp.get(n);
    }
}
