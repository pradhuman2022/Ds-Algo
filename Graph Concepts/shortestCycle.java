public class Solution {
    
    int ans = Integer.MAX_VALUE;
    public int solve(int A, int[][] B) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        int weight[][] = new int[A + 1][A + 1];
        
        for (int i = 0; i < B.length; i++) {
            Set<Integer> list = adjList.getOrDefault(B[i][0], new HashSet<Integer>());
            Set<Integer> list1 = adjList.getOrDefault(B[i][1], new HashSet<Integer>());
            list.add(B[i][1]);
            list1.add(B[i][0]);
            adjList.put(B[i][0], list);
            adjList.put(B[i][1], list1);
            weight[B[i][0]][B[i][1]] = B[i][2];
            weight[B[i][1]][B[i][0]] = B[i][2];
        }
        
        for (int i = 0; i < B.length; i++) {
            adjList.get(B[i][0]).remove(B[i][1]);
            adjList.get(B[i][1]).remove(B[i][0]);
            int cost = dijsktra(B[i][1], B[i][0], adjList, weight);
            if(cost != Integer.MAX_VALUE)
                ans = Math.min(ans, cost + weight[B[i][0]][B[i][1]]);
            adjList.get(B[i][0]).add(B[i][1]);
            adjList.get(B[i][1]).add(B[i][0]);
        }
        
        /**
         * boolean visited[];
        for (Map.Entry<Integer, List<Node>> entry: adjList.entrySet()) {
            visited = new boolean[A + 1];
            dfs(entry.getKey(), entry.getKey(), adjList, visited, 0, -1);
        }**/
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    
    public int dijsktra(int source, int destination, Map<Integer, Set<Integer>> adjList, int weight[][]) {
        
        int distance[] = new int[weight.length];
        int visited[] = new int[weight.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> distance[a] - distance[b]);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        pq.add(source);
        
        while(!pq.isEmpty()) {
           int currentNode = pq.poll();
           if(visited[currentNode] == 0) {
               visited[currentNode] = 1;
               for (int adjNode: adjList.get(currentNode)) {
                   if(distance[adjNode] > distance[currentNode] + weight[currentNode][adjNode]) {
                       distance[adjNode] = distance[currentNode] + weight[currentNode][adjNode];
                       pq.add(adjNode);
                   }
               }
           }
        }
        
        return distance[destination];
    }
    
    /**public void dfs(int source, int destination, Map<Integer, List<Node>> adjList,
                                            boolean visited[], int currentPathSum, int parent) {

        visited[source] = true;
        
        for (Node node: adjList.getOrDefault(source, new ArrayList<>())) {
            if(visited[node.childNode] && parent != node.childNode) {
                 if(node.childNode == destination)
                    ans = Math.min(ans, currentPathSum + node.weight);
                visited[source] = false;
                return;
            } else if(!visited[node.childNode])
                dfs(node.childNode, destination, adjList, visited, currentPathSum + node.weight, source);
        }
        
         visited[source] = false;
    }**/
    
    
    /**
    class Node {
        int childNode;
        int weight;
        Node(int childNode, int weight) {
            this.childNode = childNode;
            this.weight = weight;
        }
    }**/
}

/**

Minimum Weighted Cycle

Problem Description

Given an integer A, representing number of vertices in a graph.

Also you are given a matrix of integers B of size N x 3 where N represents number of Edges in a Graph and Triplet (B[i][0], B[i][1], B[i][2]) implies there is an undirected edge between B[i][0] and B[i][1] and weight of that edge is B[i][2].

Find and return the weight of minimum weighted cycle and if there is no cycle return -1 instead.

NOTE: Graph may contain multiple edges and self loops.



Problem Constraints

1 <= A <= 1000

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 100000



Input Format

The first argument given is the integer A.

The second argument given is the integer matrix B.



Output Format

Return the weight of minimum weighted cycle and if there is no cycle return -1 instead.


Example Input

Input 1:

 A = 4
 B = [  [1 ,2 ,2]
        [2 ,3 ,3]
        [3 ,4 ,1]
        [4 ,1 ,4]
        [1 ,3 ,15]  ]

Input 2:

 A = 3
 B = [  [1 ,2 ,2]
        [2 ,3 ,3]  ]



Example Output

Output 1:

 10 

Output 2:

 -1



Example Explanation

Explanation 1:

 Given graph forms 3 cycles
 1. 1 ---> 2 ---> 3 ---> 4 ---> 1 weight = 10
 2. 1 ---> 2 ---> 3 ---> 1 weight = 20
 3. 1 ---> 3---> 4 ---> 1 weight = 20
 so answer would be 10.

Explanation 2:

 Given graph forms 0 cycles so return -1.

**/
