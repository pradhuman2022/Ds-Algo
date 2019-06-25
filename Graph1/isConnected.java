import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
        int adMat[][] = new int[V][V]; 
        for(int i = 0 ; i < E ; i++)
        {
            int a = s.nextInt() ;
            int b = s.nextInt() ;
            adMat[a][b] = 1 ;
            adMat[b][a] = 1 ;
        }
        int visited[] = new int[V] ;
        doDfs(0, visited, adMat) ;
        for(int i = 0 ; i < V; i++)
        {
            if(visited[i] < 1)
            {
                System.out.print(false) ;
                return ;
            }
        }
        System.out.print(true) ;
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
	}
    static void doDfs(int start , int visited[], int adMat[][])
    {
        visited[start] = 1 ;
        for(int i = 0 ; i < visited.length; i++)
        {
            if(adMat[i][start] == 1 && visited[i] == 0)
            {
                doDfs(i, visited, adMat) ;
            }
        }
    }
}
