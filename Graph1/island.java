public class solution {
    
    public int solve(int n,int m,int U[],int V[]) {
        //write your code here
       int E = U.length; 
       int visited[] = new int[n + 1] ;
       int adMat[][] = new int[n + 1][n + 1] ;
       int ans = 0;
       for(int i = 0; i < E; i++)
       {
           int a = U[i] ;
           int b = V[i] ; 
           adMat[a][b] = 1 ;
           adMat[b][a] = 1 ;
       } 
       for(int i = 1 ; i <= n ; i++)
       {
           if(visited[i] == 0)
           {
               doDfs(i, adMat, visited) ;
               ans++ ;
           }
       }
        return ans ;
    }
    static void doDfs(int start, int adMat[][], int visited[])
    {
        visited[start] = 1 ;
        for(int i = 1 ; i < visited.length ; i++)
        {
            if(adMat[start][i] == 1 && visited[i] == 0)
            {
                doDfs(i, adMat, visited) ;
            }
        }
    }
}
