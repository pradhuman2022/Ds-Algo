class Solution {
    int parent[];
    public int numSimilarGroups(String[] A) {
        parent = new int[A.length];
        for(int i = 0; i < A.length; i++)
            parent[i] = i;
        
        for (int i = 0; i < A.length; i++) {
            String x = A[i];
            for(int j = i + 1; j < A.length; j++) {
                String y = A[j]; 
                System.out.println(areXandYSame(x, y));
                if(areXandYSame(x, y)) {
                    union(i, j);
                }
            }   
        }
        int ans = 0; 
        
        for(int i = 0 ; i < A.length; i++) {
            if(parent[i] == i)
                ans++;
        }
        return ans;
        
    }
    
    public boolean areXandYSame(String x, String y) {
        
        if(x.equals(y))
            return true;
        
        if(x.length() != y.length())
            return false;
        
        List<Integer> unmatchedVals = new ArrayList<>();
        
        for(int i = 0 ; i < x.length(); i++) {
            if(x.charAt(i) != y.charAt(i))
                unmatchedVals.add(i);
        }
        
        if(unmatchedVals.size() != 2)
            return false;

        if(x.charAt(unmatchedVals.get(0)) != y.charAt(unmatchedVals.get(1)) 
           || x.charAt(unmatchedVals.get(1)) !=  y.charAt(unmatchedVals.get(0)))
                return false;
        
        return true;
    }
    
    public void union(int x, int y) {
        
        int xRoot = find_root(x, parent);
        int yRoot = find_root(y, parent);
        parent[yRoot] = xRoot;
    }
    
    public int find_root(int x, int parent[]) {
        if(parent[x] != x)
            return parent[x] = find_root(parent[x], parent);
        
        return x;
    }
    
}
