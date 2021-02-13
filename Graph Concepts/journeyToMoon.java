import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the journeyToMoon function below.
    static int journeyToMoon(int n, int[][] astronaut) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        
        for (int i = 0; i < astronaut.length; i++) {
            Set<Integer> adjNodes1 = adjList.getOrDefault(astronaut[i][0],
                                                            new HashSet<>());
            Set<Integer> adjNodes2 = adjList.getOrDefault(astronaut[i][1], 
                                                                new HashSet<>());
            adjNodes1.add(astronaut[i][1]);
            adjNodes2.add(astronaut[i][0]);

            adjList.put(astronaut[i][0], adjNodes1);
            adjList.put(astronaut[i][1], adjNodes2);
        } 
        
        List<Integer> list = new ArrayList<Integer>();
        int visited[] = new int[n + 1];  
        List<Integer> prefix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           if(visited[i] == 0) {
                list.add(dfs(i, visited, adjList));
                if(prefix.size() == 0) {
                    prefix.add(list.get(list.size() - 1));
                    continue;
                }
                prefix.add(prefix.get(prefix.size() - 1) 
                                + list.get(list.size() - 1));
           }
        }
        
        long ans = 0;
        ans = (prefix.get(prefix.size() - 1) - prefix.get(0)) * list.get(0);
        for(int i = 1; i < list.size() - 1; i++) {
            ans += list.get(i) * ()
        }
        
        Collections.reverse(prefix);
        System.out.println(prefix);
        return (int)ans;
    }
    
    public static int dfs(int source, int visited[], Map<Integer, Set<Integer>> adjList) {

        visited[source] = 1;
        int ans = 0;
        for (int node: adjList.getOrDefault(source, new HashSet<Integer>())) {
            if(visited[node] == 0) {
                ans += dfs(node, visited, adjList);
            }
        }
        return ans + 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        int result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
