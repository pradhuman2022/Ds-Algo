import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
        int adMat[][] = new int[V][V] ;
        for(int i = 0 ; i < E ; i++)
        {
            int a = s.nextInt() ;
            int b = s.nextInt() ;
            adMat[a][b] = 1 ;
            adMat[b][a] = 1 ;
        }
        int visited[] = new int[V] ;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>> () ;
        
        for(int i = 0 ; i < V; i++)
        {
            if(visited[i] == 0)
            {
                ArrayList<Integer> k = new ArrayList<Integer>() ;
                doDfs(i, visited, adMat, k) ;
                ans.add(k) ;
            }    
        }
        for(ArrayList<Integer> a : ans)
        {
            Collections.sort(a) ;
            for(int x : a)
            {
                System.out.print(x+" ") ;
            }
            System.out.println() ;
        }
		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
	}
    static void doDfs(int start, int visited[], int adMat[][], ArrayList<Integer> k)
    {
        visited[start]  = 1;
        k.add(start) ;
        for(int i = 0 ; i < visited.length ; i++)
        {
            if(adMat[start][i] == 1 && visited[i] == 0)
                doDfs(i, visited, adMat, k) ;
        }
    }
}
