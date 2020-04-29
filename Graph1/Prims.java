//refractor
{
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;
public class Driver_class {
    
    
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i=0; i<V; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j = 0; j < V; j++)
                    temp.add(Integer.MAX_VALUE);
                graph.add(temp);
            }
            str = read.readLine().trim().split(" ");
            int k = 0;
            while(E-- > 0)
            {
                int u = Integer.parseInt(str[k++]);
                int v = Integer.parseInt(str[k++]);
                int w = Integer.parseInt(str[k++]);
                u--;
                v--;
                graph.get(u).set(v, w);
                graph.get(v).set(u, w);
            }
            System.out.println(new MST().spanningTree(V,E,graph));
        }
    }
}
    
    
}
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
//import java.util.* ;
class MST
{
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph)
    {
        // Add your code here
        int parent[] = new int[V] ;
        int key[] = new int[V] ;
        boolean inMst[] = new boolean[V] ;
        
        for(int i = 0 ; i < V; i++)
        {
            key[i] = Integer.MAX_VALUE ;
            inMst[i] = false; 
        }
        key[0] = 0 ;
        parent[0] = -1 ;
        
        for(int i = 0 ; i < V ; i++)
        {
            int u = getMinVertex(key, inMst) ;
            
            if(u == -1)
             break ; 
            
            inMst[u] = true ; 
            for(int  k = 0; k < V ; k++)
            {
                
                if(inMst[k] == false && graph.get(u).get(k) != 0 && graph.get(u).get(k) < key[k])
                {
                    parent[k] = u ; 
                    key[k] = graph.get(u).get(k) ;
                }
                
            }
            
            
            
        }
        
        return getSumOfMst(parent, graph) ;
    }
    
    
  static  int getMinVertex(int key[], boolean inMst[])
  {
    int min = Integer.MAX_VALUE ;
    int min_index = -1 ;
    for(int i = 0 ; i < inMst.length; i++)
    {
        if(inMst[i] == false && key[i] < min)
        {
            min = key[i] ; 
            min_index = i ;
        }
    }
    return min_index ; 
  }
  
  static int getSumOfMst(int parent[], ArrayList<ArrayList<Integer>> graph)
  {
      int sum = 0 ; 
      for(int i = 1 ; i < parent.length; i++)
      {
          sum += graph.get(i).get(parent[i]) ;
      }
      return sum ;
  }
}
