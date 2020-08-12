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
       int rank[] = new int[V];
       for(int i = 0 ; i < V; i++)
        parent[i] = i ;
        for (int edge = 0; edge < graph.edges.size(); edge++) {
            int source = graph.edges.get(edge).source;
            int destination = graph.edges.get(edge).destination;
            
            int setOfSource = find(parent, source);
            int setOfDestination = find(parent, destination);
            
            if(setOfSource == setOfDestination) {
                return true;
            }
            union(rank , parent, setOfSource, setOfDestination);
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
    
    //Path compression, so man lo A ka parent Z hai toh Z tak jb pahuchege to Z root hoga sbka, to parentOfA Z ko set krdege.
    static int find(int parent[], int vertex) {
        if(parent[vertex] != vertex)
            parent[vertex] = find(parent, parent[vertex]); 
        return parent[vertex];
    }
    
    static void union(int rank[], int parent[], int vertex1, int vertex2) {
        
        if(rank[vertex1] < rank[vertex2])
            parent[vertex1] = vertex2;
        else if(rank[vertex2] < rank[vertex1])
            parent[vertex2] = vertex1;
        else {
            parent[vertex1] = vertex2; 
            rank[vertex2]++; 
        }
    }

}
