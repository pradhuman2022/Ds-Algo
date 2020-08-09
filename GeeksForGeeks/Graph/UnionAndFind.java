class DetectCycle
{
    static class Graph {
        int vertices;
        ArrayList<Edge> edges;
        
        Graph(int vertices) {
            this.vertices = vertices;
            edges = new ArrayList<>();
        }
        
        void addEdgeInGraph(int source, int destination) {
            Edge e = new Edge(source, destination); 
            edges.add(e);
        }
        
      class Edge {
          int source;
          int destination;
          Edge(int source, int destination) {
              this.source = source;
              this.destination = destination;
          }
      }
    }
    
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
       // add your code here
       Graph graph = new Graph(V);
       addEdgesFromAdjList(adj, V, graph);
       int parent[] = new int[V];
        Arrays.fill(parent, -1);
        for (int edge = 0; edge < graph.edges.size(); edge++) {
            int source = graph.edges.get(edge).source;
            int destination = graph.edges.get(edge).destination;
            
            int setOfSource = find(parent, source);
            int setOfDestination = find(parent, destination);
            
            if(setOfSource == setOfDestination) {
                return true;
            }
            union(parent, setOfSource, setOfDestination);
        }
        return false;
    }
    
    static void addEdgesFromAdjList(ArrayList<ArrayList<Integer>> adj, int V, Graph graph) {
        int mapOfEdges[][] = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int adjNode : adj.get(i)) {
                if(mapOfEdges[i][adjNode] == 0) {
                    mapOfEdges[adjNode][i] = 1; 
                    graph.addEdgeInGraph(i, adjNode);
                }
            }
        }
    }
    
    static int find(int parent[], int vertex) {
        if(parent[vertex] == -1)
            return vertex;
        return find(parent, parent[vertex]);
    }
    
    static void union(int parent[], int vertex1, int vertex2) {
        int subsetOfVertex1 = find(parent, vertex1);
        int subsetOfVertex2 = find(parent, vertex2);
        parent[subsetOfVertex1] = subsetOfVertex2; 
    }

}
