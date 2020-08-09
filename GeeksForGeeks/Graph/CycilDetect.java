class DetectCycle
{
    static boolean isVisited[]; 
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        // add your code here
        isVisited = new boolean[V];
        for(int vertex = 0; vertex < V; vertex++) {
            if(isCyclicUsingDFS(vertex, adj))
                return true;
        }
        return false;
    }
    
    public static boolean isCyclicUsingDFS(int source, ArrayList<ArrayList<Integer>> adj) {
        isVisited[source] = true; 
        for(int directedConnectedNode : adj.get(source)) {
            /*
            * Hm check krre hai ki yaha agar aage kahi cycle ho ya directedNode phle se hi visited ho toh 
            */
            if(isVisited[directedConnectedNode] || isCyclicUsingDFS(directedConnectedNode, adj))
                return true;
        }
        isVisited[source] = false;
        return false;
    }
}
