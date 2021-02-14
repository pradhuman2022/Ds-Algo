public class Solution {
    public int solve(int A, int[][] B) {
        boolean visited[] = new boolean[A + 1]; 
        //process and mark it true if ith edge is minimum and add it to MST.
        
        int cost[] = new int[A + 1];
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> 
                    Integer.valueOf(cost[a]).compareTo(Integer.valueOf(cost[b])));
        
        Map<Integer, List<NodeDetail>> adjList = new HashMap<>();
        
        int startNode = getAndInitGraphDetails(B, adjList, cost);
        cost[startNode] = 0;
        p.add(startNode);
        int totalCost = 0;
        
        while(!p.isEmpty()) {
            int currentNode = p.poll( );
            if(!visited[currentNode]) {
                visited[currentNode] = true;
                totalCost += cost[currentNode];
                for (NodeDetail node: adjList.getOrDefault(currentNode, new ArrayList<>())) {
                    if(!visited[node.nodeValue] && cost[node.nodeValue] > node.weight) {
                        cost[node.nodeValue] = node.weight;
                        p.add(node.nodeValue);
                    }
                }
            }
        }
      
        return totalCost;
    }
    
    class NodeDetail {
        int nodeValue;
        int weight;
        
        NodeDetail(int nodeValue, int weight) {
            this.nodeValue = nodeValue;
            this.weight = weight;
        }
    }
    
    public int getAndInitGraphDetails(int B[][], Map<Integer, List<NodeDetail>> adjList, int cost[]) {
    
        
        Arrays.fill(cost, Integer.MAX_VALUE);
        int startNode = -1;
        int minWeight = Integer.MAX_VALUE;
        
        for (int i = 0; i < B.length; i++) {
            if(minWeight > B[i][2]) {
                startNode = B[i][0];
                minWeight = B[i][2];
            }
            
            List<NodeDetail> list1 = adjList.getOrDefault(B[i][0], new ArrayList<>());
            List<NodeDetail> list2 = adjList.getOrDefault(B[i][1], new ArrayList<>());
            list1.add(new NodeDetail(B[i][1], B[i][2]));
            list2.add(new NodeDetail(B[i][0], B[i][2]));
            adjList.put(B[i][0], list1);
            adjList.put(B[i][1], list2);
        }
        
        return startNode;

    }
        
}

/**
Commutable Islands

Problem Description

There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints

1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103



Input Format

The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format

Return an integer representing the minimal cost required.


Example Input

Input 1:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]

Input 2:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]



Example Output

Output 1:

 6

Output 2:

 6



Example Explanation

Explanation 1:

 We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.

Explanation 2:

 We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
**/
