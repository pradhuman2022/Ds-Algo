class Islands
{
    
    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M)
    {
        boolean visited[][] = new boolean[N][M];
        // Your code here
        int count[] = new int[1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && list.get(i).get(j) == 1) {
                    dfs(N, M, visited, count, list, i, j) ; 
                    count[0] = count[0] + 1;
                }
            }
        }
        return count[0];
      
    }
    
    static void dfs(int N, int M, boolean visited[][], int count[], ArrayList<ArrayList<Integer>> list, int row, int col){
        
        if(row >= N || col >= M || row < 0 || col < 0 || visited[row][col] || list.get(row).get(col) == 0)
            return ;
        visited[row][col] = true;
      
        
        if(list.get(row).get(col) == 1){
            dfs(N, M, visited, count, list, row - 1, col - 1) ;
            dfs(N, M, visited, count, list, row + 1, col + 1) ;
            dfs(N, M, visited, count, list, row + 1, col);
            dfs(N, M, visited, count, list, row, col + 1);
            dfs(N, M, visited, count, list, row - 1, col) ;
            dfs(N, M, visited, count, list, row, col - 1);
            dfs(N, M, visited, count, list, row - 1, col + 1);
            dfs(N, M, visited, count, list, row + 1, col - 1);
        }
    }
    
}
