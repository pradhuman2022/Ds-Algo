import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, long c_lib, long c_road, int[][] cities) {
         Map<Integer, Set<Integer>> adjList = new HashMap<>();
        
         if(c_road > c_lib)
            return (long)n * c_lib;
            
        for (int i = 0; i < cities.length; i++) {
            Set<Integer> adjNodes1 = adjList.getOrDefault(cities[i][0],
                                                            new HashSet<>());
            Set<Integer> adjNodes2 = adjList.getOrDefault(cities[i][1], 
                                                                new HashSet<>());
            adjNodes1.add(cities[i][1]);
            adjNodes2.add(cities[i][0]);
            
            adjList.put(cities[i][0], adjNodes1);
            adjList.put(cities[i][1], adjNodes2);
        }
        
        int visited[] = new int[n + 1];     
        long totalAns = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        
        for (int i = 1; i <= n; i++) {
           if(visited[i] == 0)
                totalAns = totalAns + c_lib + (c_road * (dfs(i, visited, adjList) - 1));
        }
            
        return totalAns;
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

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
