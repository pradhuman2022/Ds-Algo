/*package whatever //do not write package name here */

import java.util.*;

class GFG {
     
     static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>() ; 
     static ArrayList<ArrayList<Node>> colorList = new ArrayList<>() ; 
     
    
    GFG(int vertices, int colors){
        for(int i = 0 ; i <= vertices ; i++){
            adjList.add(new ArrayList<>()) ; 
        }
        
        for(int i = 0 ; i <= colors ; i++){
            colorList.add(new ArrayList<>()) ;
        }
    }
    
    //add vertex ...
   static void addVertex(int a, int b) {
        adjList.get(a).add(b) ; 
    }
    //add colors 
    static void addColors(Node vertex, int color){
        colorList.get(color).add(vertex) ; 
    }
    
    
    public static void main(String ar[]){
     
      Scanner sc = new Scanner(System.in) ; 
      int n = sc.nextInt(); 
      int c = sc.nextInt()  ; 
      
      GFG g = new GFG(n, c) ; 
      
      //we have adjacecy List now we need to assign levels based on list  ;  
      for(int i = 1 ; i <= n - 1; i++){
          addVertex(sc.nextInt(), i + 1) ; 
      }
      
      //assign levels-------------
      HashMap<Integer, Integer> hs = new HashMap<>() ;
      dfs(1, 0, new boolean[n + 1], hs) ; 
      //---------------------------
      
      
      
      for(int i = 0 ; i < n ; i++){
          int color = sc.nextInt() ; 
          addColors(new Node(i + 1, hs.get(i + 1)), color) ;
      }
      
      hs = null ; 
      
      
      //sort by level
      for(ArrayList <Node> N : colorList)
      Collections.sort(N, (a, b) -> a.level - b.level) ; 
      
     //now find ancestors for vertex
     int ans[] = new int[n] ; 
     
      for(int i = 1 ; i <= c ; i++){
          
          ArrayList<Node> nodes = colorList.get(i) ; 
          //now we can use binarySearch on list based on level ; 
          for(int f = 0 ; f < nodes.size(); f++){
              System.out.println(nodes.get(f).level+" "+nodes.get(f).value) ;
              int l = nodes.get(f).level ; 
              
              if(f == 0){
                  ans[nodes.get(f).value - 1] = -1 ; 
              }else{
                  
                  int start = 0 ; 
                  int end = f - 1 ; 
                  
                  while(start < end){
                      int mid = (start + end) / 2 ; 
                      
                      if(nodes.get(mid).level < l)
                          start = mid + 1 ; 
                      else
                          end = mid - 1  ;
                  }
                 System.out.println(nodes.get(start).value)  ; 
                 ans[nodes.get(f).value - 1] = nodes.get(start).value ; 
              }
             
          }
        
      }
      
      for(int aw : ans)
       System.out.print(aw+" ") ;      	
	   
	}
	
   static class Node{
       int level  ; 
       int value ; 
       
       Node(int v, int l){
           level = l ; 
           value = v ; 
       }
   }	
	//--------------------------------------------------------------------------------
   static  void dfs(int vertex, int level, boolean visited[], HashMap<Integer, Integer> hs){
        
        visited[vertex] = true ; 
        hs.put(vertex, level) ; 
        
        for(Integer adjacents : adjList.get(vertex)){
            if(!visited[adjacents])
             {
                 dfs(adjacents, level + 1 , visited, hs) ; 
             }
        }
        visited[vertex] = false ;
    }
	
}

/*

Question 1 :
 
Ram and Shyam decide to go on a fun weekend camping trip. As they were passing through a forest, they stumbled upon a unique tree of V nodes. Vertices are numbered from 1 to N.
 
Each node of the tree is assigned a color (out of C possible colors). The tree is rooted at vertex 1. For each node, they want to find its closest ancestor having the same color.
 
Input format
 
The first row will be having 2 integers N and C representing the number of vertices in the tree and the number of possible colors.
The second line contains  integers. The  integer denotes the parent of the  vertex.
The third line contains N integers, denoting the colors of the vertices. Each color lies between 1 and C inclusive.
 
Output format
Print N space-separated integers. The  integer is the vertex number of closest ancestor of the  node which has the same colour. If there is no such ancestor, print -1 for that node.
 
Input
5  4
1  1  3  3
1  4  2  1  2
 
Output
-1 -1 -1 1 3
 
 
*/
