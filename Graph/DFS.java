import java.util.*;
//using recursion
public class DFS {
    static void print(int sn, int edges[][], boolean visited[], int n)
    {
        System.out.print(sn);
        visited[sn] = true;
        for(int i = 0 ; i < n; i++)
        {            
          if(i == sn)
              continue ;
          if(edges[sn][i] == 1)
          {
              if(visited[i])
                  continue ;
              print(i, edges, visited, n) ;
          }
        }                         
    }
  public static void main(String ar[])
  {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt(); 
      int edges[][] = new int[n][n];
      int e = sc.nextInt();
      for(int i = 0 ; i < e ; i++)
      {
          int f , s ;
          f = sc.nextInt();
          s = sc.nextInt();
          edges[f][s] = 1 ; 
          edges[s][f] = 1 ;
      }
      boolean visited[] = new boolean[n];
      print(0, edges,visited, n);
  }
}
