/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

/import for Scanner and other utility classes*/
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

        Scanner inputScanner = new Scanner(System.in);
        int testCases = inputScanner.nextInt();

        while(testCases--> 0) {
            
            int vertices = inputScanner.nextInt();
            int edges = inputScanner.nextInt();
            Graph g = new Graph(vertices);
            while(edges--> 0) {
                g.addEdge(inputScanner.nextInt(), inputScanner.nextInt());
            }
            System.out.println(g.isColorAble() == true ? "BICOLORABLE." : "NOT BICOLORABLE.");
        }
    }

    static class Graph {
        private List<List<Integer>> adjList;
        private int vertices;
        private int edges;

        Graph(int vertices) {
            this.vertices = vertices;
            intializeAdjList(vertices);
        }

        private void intializeAdjList(int vertices) {
            adjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                ArrayList<Integer> childList = new ArrayList<>();
                adjList.add(childList);
            }
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        public boolean isColorAble() {
            boolean doYouWantDfs = true;
            if(doYouWantDfs) {
                int colors[] = new int[vertices];
                Arrays.fill(colors, -1);
                return isColorAbleWithDfs(0, colors);
            } else {
                return isColorAbleWithBfs();
            }
        }


        private boolean isColorAbleWithBfs() {
            Queue<Integer> queue = new LinkedList<>();
            HashSet<Integer> isVisited = new HashSet<>();
            queue.add(0);
            int colors[] = new int[vertices];
            Arrays.fill(colors, -1);
            colors[0] = 1;
            isVisited.add(0);

            while(!queue.isEmpty()) {
                int nodeValue = queue.poll();

                for (int adjNode: adjList.get(nodeValue)) {
                    if(colors[adjNode] == -1 && !isVisited.contains(adjNode)) {
                        isVisited.add(adjNode);
                        colors[adjNode] = 1 - colors[nodeValue]; //just flip the color
                        queue.add(adjNode); 
                    } else if(isVisited.contains(adjNode) && colors[adjNode]
                                                 == colors[nodeValue]) {
                        return false; // found cycle 
                    }  
                }
            }
            return true;
        }

        private boolean isColorAbleWithDfs(int currentNode, int colors[]) {
            if (currentNode == vertices)
                return true;
        
            for (int currentColor = 0 ; currentColor < 2; currentColor++) {
                if(isValidWithCurrentColor(currentColor, 
                                        currentNode, colors)) {
                    colors[currentNode] = currentColor;
                    if(isColorAbleWithDfs(currentNode + 1, colors)) {
                        return true;
                    }
                    colors[currentNode] = -1;
                }
            }
            return false; 
        }

        private boolean isValidWithCurrentColor(int currentColor, int currentNode, int colors[]) {
            for (int adjNode: adjList.get(currentNode)) {
                if(colors[adjNode] == currentColor)
                    return false;
            }
            return true;
        }
    }
}
