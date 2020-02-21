class Traversal
{
    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
       // add your code here
       vis[src] = true;
       System.out.print(src+" ");
       
       for(Integer adj : list.get(src)){
           if(!vis[adj])
             dfs(adj, list, vis);
       }
    }
}

