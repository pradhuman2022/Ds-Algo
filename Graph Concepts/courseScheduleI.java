class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    
        boolean visited[] = new boolean[numCourses];
        HashSet<Integer> vertices = new HashSet<>();
        if(numCourses == 1 || prerequisites.length == 0)
            return true;
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> adjacents = adjList.getOrDefault(prerequisites[i][1],
                                                 new ArrayList<Integer>());
            adjacents.add(prerequisites[i][0]);
            adjList.put(prerequisites[i][1], adjacents);
            vertices.add(prerequisites[i][0]);
            vertices.add(prerequisites[i][1]);
        }
        
        System.out.println(adjList);
        boolean dp[] = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if(dfs(i, adjList, visited, dp)) 
                    return false;
            }

         return true;
    }
    
    public boolean dfs(int source, Map<Integer, List<Integer>> adjList,  
                       boolean visited[], boolean dp[]) {
        
        if(dp[source]) {
            return false;//if we checked that we previously visited this source with no cycle then 
            //we can simply store its value and retrun false if source don't have any cycle.
        }
        
        if(visited[source]) {
            return true;
        }
       // System.out.println(source);
        visited[source] = true; 
        for (Integer childNode: adjList.getOrDefault(source, new ArrayList<>())) {
                if(dfs(childNode, adjList, visited, dp)) {
                    return true;
            }
            System.out.println(childNode);
        }
        
        visited[source] = false;
        dp[source] = true;
        return false;
    }
     
}
