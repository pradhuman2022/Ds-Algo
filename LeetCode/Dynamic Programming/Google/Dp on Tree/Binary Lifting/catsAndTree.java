import java.io.*;
import java.util.*;

public class Main {
    
  static HashMap<Integer, List<Integer>> map;
  static int up[][];
  
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
		
	String inp[] = br.readLine().split(" ");
		
    int parent[] = new int[n + 1];

    for (int i = 1 ; i <= n; i++) {
      parent[i] = Integer.parseInt(inp[i - 1]);
    }
    
    init(parent, n);
    
    int isNodeAllocated[] = new int[n + 1];
    isNodeAllocated[0] = 1;
    
    int cats[] = new int[n + 1];
	String in[] = br.readLine().split(" ");
		
    for (int i = 0; i < n; i++)
       System.out.println(climbTree(Integer.parseInt(in[i]), isNodeAllocated));
  }
  
  static int climbTree(int currentNode, int isNodeAllocated[]) {
      
      int jump = 1;
      
      if (isNodeAllocated[currentNode] == 1)
        return 0;
      
      for (int i = 18; i >= 0; i--) {
          if (isNodeAllocated[up[currentNode][i]] == 0) {
            currentNode = up[currentNode][i];
            jump += 1 << i;
          }
      }
      
      isNodeAllocated[currentNode] = 1;
      
      return jump;
  }
    
  static void init(int parent[], int n) {
    
    up = new int[n + 1][19];
    map = new HashMap<>();

    for (int i = 1; i < parent.length; i++) {
      List<Integer> child = map.getOrDefault(parent[i], new ArrayList<>());
      child.add(i);
      map.put(parent[i], child);
    }

    binaryLifting(map.get(0).get(0), 0);
  }
  
  
  static void binaryLifting(int source, int parent) {
    
    up[source][0] = parent;
    
    for (int i = 1; i <= 18; i++) {
        
        if (up[source][i - 1] != 0)
            up[source][i] = up[up[source][i - 1]][i - 1];
        else
            up[source][i] = 0;
    }
    
    for (int child: map.getOrDefault(source, new ArrayList<>())) {
        
        if(child != parent)
            binaryLifting(child, source);
    }
  }
}
