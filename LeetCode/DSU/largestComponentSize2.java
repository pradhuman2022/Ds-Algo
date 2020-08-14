class Solution {
    int parent[];
    public int largestComponentSize(int[] A) {
        int length = A.length;
        int maxValue = 0;
        for(int val : A)
            maxValue = Math.max(maxValue, val);
        parent = new int[maxValue + 1];
        for (int node = 0; node <= maxValue; node++) 
            parent[node] = node;
        
        
        /**
        * We are taking lead as factor values,
        * merging values with factor values.
        * is approach se phle mai har number ko select krke
        * parent banane ki kosis krra tha jo N2logN time dega.
        **/
        for(int i = 0; i < length; i++) {
            for(int factor = 2; factor <= (int)Math.sqrt(A[i]); factor++) {
                if(A[i] % factor == 0) {
                    union(A[i], factor);
                    union(A[i], A[i] / factor);
                }
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int largestComponent = Integer.MIN_VALUE; 
        for(int i = 0; i < length; i++) {
            //Finding final parent of an element.
            int finalParent = find(A[i]);
            map.put(finalParent, map.getOrDefault(finalParent, 0) + 1); 
            System.out.println(map.get(parent[i])+" "+i+" "+parent[i]);
            largestComponent = Math.max(largestComponent, map.get(finalParent));
        }
        return largestComponent;
    }
    public void union(int x, int y) {
        int xset = find(x); 
        int yset = find(y);
        parent[xset] = yset; 
    }
    
    public int find(int x) {
        if(parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    } 
}
