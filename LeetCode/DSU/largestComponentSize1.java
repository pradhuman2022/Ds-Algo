class Solution {
    int parent[];
    public int largestComponentSize(int[] A) {
        int length = A.length;
        parent = new int[length];
        for (int node = 0; node < length; node++) 
            parent[node] = node;
        int val = 0;
        for(int firstNode = 0; firstNode < length; firstNode++) {
            int node1 = A[firstNode]; 
            int node2; 
            for (int secondNode = firstNode + 1; secondNode < length; secondNode++) {
                node2 = A[secondNode];
                if(shareCommonFactor(node1, node2)) {
                    union(firstNode, secondNode);
                }
            }
        }
        
        for(int i = 0; i < length; i++) {
            find(i);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int largestComponent = Integer.MIN_VALUE; 
        for(int i = 0; i < length; i++) {
            map.put(parent[i], map.getOrDefault(parent[i], 0) + 1);
            largestComponent = Math.max(largestComponent, map.get(parent[i]));
        }
        return largestComponent; 
    }
    
    public boolean shareCommonFactor(int node1, int node2) {
        if(gcd(node1, node2) != 1)
            return true;
        return false;
    }
    
    int gcd(int node1, int node2) {
        if(node1 == 0) {
            return node2;
        }
        return gcd(node2 % node1, node1); 
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
