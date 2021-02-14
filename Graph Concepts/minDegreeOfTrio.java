class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < edges.length;i++) {
            Set<Integer> set1 = adjList.getOrDefault(edges[i][0], new HashSet<>());
            Set<Integer> set2 = adjList.getOrDefault(edges[i][1], new HashSet<>());
            
            set1.add(edges[i][1]);
            set2.add(edges[i][0]);
            
            adjList.put(edges[i][0], set1);
            adjList.put(edges[i][1], set2); 
        }
        
        
        int minDegree = Integer.MAX_VALUE;
        for (int edge[]: edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            
            int degreeOfV1 = adjList.get(v1).size() - 2;
            int degreeOfV2 = adjList.get(v2).size() - 4;
            
            Set set1 = adjList.get(v1);
            Set set2 = adjList.get(v2);
               
            for(Object setValue: set1) {
                if(set2.contains(setValue)) {
                    Set set3 = adjList.get(setValue);
                    if(set3.contains(v1) && set3.contains(v2)) {
                        minDegree = Math.min(minDegree, degreeOfV1 + degreeOfV2 + set3.size());
                    }
                }
            }
        }
        
        return minDegree == Integer.MAX_VALUE ? -1 : minDegree;
        
    }
}
