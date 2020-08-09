class DetectCycle
{
    static boolean isVisited[];
    static int vertices ;
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
       // add your code here
       vertices = V;
       isVisited = new boolean[V];
       
       /**
       *We need to traverse all nodes because, 
       *there may be disconnected graph.
       **/
       for(int vertex = 0; vertex < V; vertex++) {
           if(!isVisited[vertex])
                if(isCyclicUsingDFS(vertex, adj, -1))
                    return true;
       }
       return false;
    }
    /**
     * Mujse glti ye hui ki mai sirf ek node  ko lekr chal ra tha ye ni soucha tha ki agar graph disconneted
     * hai. So hmko sare nodes pr visited krna pdega jinko hmne visit ni kiya hai.
     * Ek fault ye bhi ki, hme check krna pdega ki agar hme koi node visited mil ra h to wo 
     * currentSource ka parent ni hona chaiye, kyuki wo adjacentnodes honge.
    **/
    public static boolean isCyclicUsingDFS(int source, ArrayList<ArrayList<Integer>> adj, int parent) {
        isVisited[source] = true; 
        for(int connectedNode : adj.get(source)) {
            //If adjacentNode is visited already and parent should not be its adjacentNode
            if(isVisited[connectedNode] && parent != connectedNode)
                return true;
            //if adjacentNode is not visited and there is cyclic in remaining node
            else if(!isVisited[connectedNode] && isCyclicUsingDFS(connectedNode, adj, source))
                return true;
        }
        isVisited[source] = false;
        return false;
    }
}
