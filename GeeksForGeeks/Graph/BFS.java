//bfs using queue 
class Traversal
{
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean visited[], int nov)
    {
       // add your code here
       Queue<Integer> q = new ArrayDeque<Integer>();
       q.offer(s) ; 
       while(!q.isEmpty()){
            int vertex = q.poll();
            if(!visited[vertex])
                System.out.print(vertex+" ");
            visited[vertex] = true ;
            for(Integer adj : list.get(vertex)){
                if(!visited[adj]){
                    q.offer(adj); 
                }
            }
       }
    }
}

