import java.util.*;
import java.lang.*;
import java.io.*;
class TransitiveClosure
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    
	    int T = sc.nextInt();
	    while(T-->0){
	        int vertexCount = sc.nextInt();
	        
	        int adjMat[][] = new int[vertexCount][vertexCount];
	        for (int i = 0; i < vertexCount; i++) {
	            for (int j = 0; j < vertexCount; j++) {
	                adjMat[i][j] = sc.nextInt();
	            }
	        }
	        transitiveClosure(adjMat, vertexCount);
	        System.out.println();
	    }
	 }
	 
	 //implementation using floyd warshel algorithm
	 static void transitiveClosure(int adjMat[][], int vertexCount) {
	    int closure[][] = new int[vertexCount][vertexCount]; 
	    
	    for (int i = 0 ; i < vertexCount ;i++) {
	        for (int j = 0 ; j < vertexCount; j++) {
	            if(i == j) {
	                closure[i][j] = 1;
	                continue;
	            }
	            closure[i][j] = adjMat[i][j] ; 
	        }
	    }
	    
	    for (int sourceVertex = 0; sourceVertex < vertexCount; sourceVertex++) {
	      for (int destinationVertex = 0; destinationVertex < vertexCount; destinationVertex++) {
	        for (int midVertex = 0 ; midVertex < vertexCount; midVertex++) {
	               if(closure[sourceVertex][destinationVertex] == 0)
	                closure[sourceVertex][destinationVertex] = (closure[sourceVertex][midVertex] != 0) && (closure[midVertex][destinationVertex] != 0) ? 1 : 0;  
	        }  
	      }  
	    }
	   
	   for (int source = 0 ; source < vertexCount; source++) {
	        for (int destination = 0; destination < vertexCount; destination++) {
	            System.out.print(closure[source][destination]+" ");
	        }
	    }
	    
	 }
}
