class Solution {
    Map<Integer, List<Integer>> adjList;
    String names[];
    String targetPath[];
    int nextChoiceForMin[][];
    int dp[][];
    
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        adjList = new HashMap<>();
        this.names = names;
        this.targetPath = targetPath;
        this.dp = new int[names.length][targetPath.length];
        nextChoiceForMin = new int[names.length][targetPath.length];
        for(int [] arr: dp)
            Arrays.fill(arr, -1);
        
        for(int i = 0; i < roads.length; i++) {
            List<Integer> arr1 = adjList.getOrDefault(roads[i][0], new ArrayList<>());
            List<Integer> arr2 = adjList.getOrDefault(roads[i][1], new ArrayList<>());
            
            arr1.add(roads[i][1]);
            arr2.add(roads[i][0]);
            adjList.put(roads[i][0], arr1);
            adjList.put(roads[i][1], arr2);
        }
        
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int dist = minEditDist(0, i);
            if(dist < min) {
                min = dist;
                start = i;
            } 
        }
        
        List<Integer> list = new ArrayList<>();
        while(list.size() < targetPath.length) {
            list.add(start);
            start = nextChoiceForMin[start][list.size() - 1];
        }
        
        return list;
    }
    
    int minEditDist(int currentPosInTargetPath, int currentNodeIndex) {
        
        if(currentPosInTargetPath == targetPath.length) {
            return 0; //achived target path;et6
        }
        
        if(dp[currentNodeIndex][currentPosInTargetPath] != -1)
            return dp[currentNodeIndex][currentPosInTargetPath];
        
        int ans;
        
        if(names[currentNodeIndex].equals(targetPath[currentPosInTargetPath])) {
            ans = 0;
         } else {
            ans = 1;
        }
        
        return dp[currentNodeIndex][currentPosInTargetPath] = ans + peformMinEditDistOnAdjacents(currentNodeIndex, 
                                                                                            currentPosInTargetPath);
    }
        
    int peformMinEditDistOnAdjacents(int currentNodeIndex, int currentPosInTargetPath) {
        int min = Integer.MAX_VALUE;
        for(int adjNode: adjList.getOrDefault(currentNodeIndex, new ArrayList<>())) {
            int val =  minEditDist(currentPosInTargetPath + 1, adjNode);
            if(min > val) {
                min = val;
                nextChoiceForMin[currentNodeIndex][currentPosInTargetPath] = adjNode;
            }
        }

        return min;
    }
}
