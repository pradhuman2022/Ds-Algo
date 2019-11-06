class GfG{
    static ArrayList<String> paths ;
    static boolean visited [][] ;
     public static ArrayList<String> printPath(int[][] m, int n)
     {
          //Your code here
         paths = new ArrayList<String>();  
         visited = new boolean[n][n] ;  
         getAllPaths(m, n , 0 , 0, "") ; // getAllPaths(currRow, currCol, "") ;
         Collections.sort(paths) ;
         return paths ; 
     }
     
     static void getAllPaths(int m[][], int n, int currRow, int currCol, String path){
         
        // if we are out of boundries 
        if(currRow < 0 || currCol < 0 || currRow >= n || currCol >= n || visited[currRow][currCol] == true || m[currRow][currCol] == 0)
            return ; 
         // if we reached at n - 1, n - 1 
         if(currRow == n - 1 && currCol == n - 1)
        {
            paths.add(path) ; 
            return ;
        }
        visited[currRow][currCol] = true ;
        getAllPaths(m, n, currRow - 1, currCol , path+"U"); 
        getAllPaths(m, n, currRow + 1, currCol , path+"D"); 
        getAllPaths(m, n, currRow , currCol - 1, path+"L"); 
        getAllPaths(m, n, currRow , currCol + 1, path+"R"); 
        visited[currRow][currCol] = false ;
     }
}
