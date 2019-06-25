/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pradhuman
 */
import java.util.*;

public class Solu1 {

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
        ArrayList<Integer> al = printPathDfs(adMat, s.nextInt(), visited, s.nextInt()) ;
	for(int x : al)
            System.out.print(x+" ") ;
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
    }
    static ArrayList<Integer> printPathDfs(int adMat[][], int start, int visited[], int end)
    {
        if(start == end)
        {
            visited[end] = 1 ;
            ArrayList<Integer> e = new ArrayList<Integer>() ;
            e.add(end) ;
            return e;
        }
        visited[start] = 1; 
        for(int i = 0; i < visited.length ; i++)
        {
            if(i == start)
                continue ;
            if(visited[i] == 0 &&adMat[start][i] == 1)
            {
               //visited[i] = 1 ;
               ArrayList<Integer> output = printPathDfs(adMat, i, visited, end) ;
               if(output != null)
               {
                   output.add(start) ;
                   return output ;
               }
            }
        }
        return null  ;
    }
}
