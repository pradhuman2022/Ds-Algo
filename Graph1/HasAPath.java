
import java.util.* ;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
        int visited[] = new int[V] ;
        
        Graph g = new Graph(V) ;
        for(int i = 0 ; i < E ; i++)
        {
          g.addEdges(sc.nextInt(), sc.nextInt()) ;  
        }
        for(ArrayList a : g.adList)
        {
            Collections.sort(a) ;
        }
        System.out.println(g.bfs(sc.nextInt(), sc.nextInt(), V, visited)) ;
		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
	}
    static class Graph 
    {
        ArrayList<ArrayList<Integer>> adList ; 
        public  Graph(int V)
        {
            adList = new ArrayList<ArrayList<Integer>>();
            for(int i = 0 ; i < V ; i++)
            {
                adList.add(new ArrayList<Integer>()) ;
            }
        }
        void addEdges(int a, int b)
        {
            adList.get(a).add(b) ;
            adList.get(b).add(a) ;
        }
       boolean bfs(int start , int end, int V, int visited[])
       {
           Queue<Integer> q = new ArrayDeque<Integer>() ;
           q.add(start) ;
           while(!q.isEmpty())
           {
               
               int current = q.poll() ;
               if(visited[current] == 0)
               {
               if(current == end)
                return true ;
               visited[current] = 1 ;    
               for(int x : adList.get(current))
               {
                  q.offer(x) ; 
               }
               }
           }
           return false ;
       }
    }
   
}
