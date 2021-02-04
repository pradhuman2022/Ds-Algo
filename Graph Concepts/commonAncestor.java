/*

Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.

             15
             |
         14  13
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11

parentChildPairs1 = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (4, 8), (4, 9), (9, 11), (14, 4), (13, 12),
    (12, 9),(15, 13)
]

Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 9) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 3, 1) => false
hasCommonAncestor(parentChildPairs1, 7, 11) => true
hasCommonAncestor(parentChildPairs1, 6, 5) => true
hasCommonAncestor(parentChildPairs1, 5, 6) => true

Additional example: In this diagram, 4 and 12 have a common ancestor of 11.

        11
       /  \
      10   12
     /  \
1   2    5
 \ /    / \
  3    6   7
   \        \
    4        8

parentChildPairs2 = [
    (1, 3), (11, 10), (11, 12), (2, 3), (10, 2),
    (10, 5), (3, 4), (5, 6), (5, 7), (7, 8),
]

hasCommonAncestor(parentChildPairs2, 4, 12) => true
hasCommonAncestor(parentChildPairs2, 1, 6) => false
hasCommonAncestor(parentChildPairs2, 1, 12) => false

n: number of pairs in the input

*/

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] argv) {
    int[][] parentChildPairs1 = new int[][] {
        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},
        {15, 13}
    };

    int[][] parentChildPairs2 = new int[][] {
        {1, 3}, {11, 10}, {11, 12}, {2, 3}, {10, 2},
        {10, 5}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
    };
    
  System.out.println(commonAncestor(parentChildPairs1, 1, 3));
  System.out.println(commonAncestor(parentChildPairs1, 3, 8));
  System.out.println(commonAncestor(parentChildPairs1, 5, 8));
  System.out.println(commonAncestor(parentChildPairs1, 6, 8));
  System.out.println(commonAncestor(parentChildPairs1, 7, 11));
  System.out.println(commonAncestor(parentChildPairs1, 3, 1));
  }
  
  public static boolean commonAncestor(int childPairs[][], int x, int y) {
    
    HashMap<Integer, List<Integer>> childToParent = new HashMap<>();
    HashSet<Integer> hashSet = new HashSet<>();
    int max = Integer.MIN_VALUE;
    
    for (int i = 0; i < childPairs.length; i++) {
      int parent = childPairs[i][0];
      int child = childPairs[i][1];
      List<Integer> parents = childToParent.getOrDefault(child, new
                                                         ArrayList<Integer>()); 
      parents.add(parent);
      childToParent.put(child, parents);
      hashSet.add(childPairs[i][0]);
      hashSet.add(childPairs[i][1]);
      max = Math.max(max, Math.max(childPairs[i][0], childPairs[i][1]));
    }
    
    boolean visitedForX [] = new boolean[max + 1];
    boolean visitedForY[] = new boolean[max + 1];
    
    dfs(x, visitedForX, childToParent);
    dfs(y, visitedForY, childToParent);
  
    for (int i = 0; i <= max; i++) {
      if(visitedForX[i] && visitedForY[i] && i != x && y != i) {
        return true;
      }
    }
    
    return false;
  }
  
  
  public static void dfs(int child, boolean visitedForChild[], HashMap<Integer,
                         List<Integer>> childToParent) {
    
    visitedForChild[child] = true;
    for (Integer parent: childToParent.getOrDefault(child, new ArrayList<Integer>())) {
      if(!visitedForChild[parent]) {
        dfs(parent, visitedForChild, childToParent);
      }
    }
  }
  
  public static List<List<Integer>> getNodesWithConstraint(int [][]childPairs) {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> hashSet = new HashSet<>();
    for (int i = 0; i< childPairs.length;i++) {
      map.put(childPairs[i][1], map.getOrDefault(childPairs[i][1], 0) + 1);
      hashSet.add(childPairs[i][0]);
      hashSet.add(childPairs[i][1]);
    }
    
    List<Integer> listOfzeroParent = new ArrayList<>();
    List<Integer> listOfOneParent = new ArrayList<>();
    
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        listOfOneParent.add(entry.getKey());
      }
      hashSet.remove(entry.getKey());
    }
    
  
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<>(hashSet));
    ans.add(listOfOneParent);
    
    return ans;
  }
}
