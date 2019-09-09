import java.util.* ;
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
       
        Queue<Pair> pq = new PriorityQueue<Pair>((a, b)-> b.sum - a.sum) ;
       
        Collections.sort(A) ;
        Collections.sort(B) ;
        
        int N = A.size() ;
        ArrayList<Integer> ans = new ArrayList<Integer>() ; 
        
        if(N == 1)
          {
              ans.add(A.get(0) + B.get(0)) ;
              return ans ;
              //return new ArrayList<Integer>().add(A.get(0) + B.get(0)) ;
          }
        int visited[][] = new int[N][N] ; 
        visited[N - 1][N - 1] = 1 ;
        int i1 = N - 1;
        int j1 = N - 1;
        pq.add(new Pair(i1, j1, A.get(i1) + B.get(j1))) ;
        
        while(N-- > 0)
        {
            Pair p = pq.poll() ; 
            ans.add(p.sum) ;
            
            if(p.x - 1 >= 0 && visited[p.x - 1][p.y] == 0)
            {
                pq.add(new Pair(p.x - 1, p.y, A.get(p.x - 1) + B.get(p.y))) ;
                visited[p.x - 1][p.y] = 1 ;
            }
            if(p.y - 1 >= 0 && visited[p.x][p.y - 1] == 0)
            {
                pq.add(new Pair(p.x, p.y - 1, A.get(p.x) + B.get(p.y - 1))) ;
                visited[p.x][p.y - 1] = 1 ;
            }
        }
        visited = null ;
        pq = null ;
        System.gc();
        return ans ;
    }
    static class Pair{
         
         int x;
         int y ;
         int sum ;
        
        Pair(int x, int y , int sum)
        {
            this.x = x ; 
            this.y = y ;
            this.sum = sum ;
        }
     /* [ 3, 2, 4, 2 ]
B : [ 4, 3, 1, 2 ]
Your function returned the following :  
4 6 5 7 
The expected returned value :
8 7 7 6 */   
    }
}
