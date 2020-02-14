/*package whatever //do not write package name here */
//wherever K shows , it is like heap
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ;
		int T = sc.nextInt() ;
		while(T -- > 0)
		{
		    int n = sc.nextInt() ;
		    int k = sc.nextInt() ;
		    Heap h = new Heap(k) ;
		    
		    for(int i = 0 ; i < k ; i++)
		      h.insertKey(sc.nextInt()) ;
		      
		    for(int i = 0 ; i < n - k; i++)
		    {
		       int e = sc.nextInt() ;
		       if(h.heap[0] < e)
		        {
		            h.heap[0] = e ; 
		            h.heapify(0);
		        }
		    }
		   
		    Arrays.sort(h.heap) ; 
		    for(int p = h.heap_size - 1; p >= 0; p--)
		    System.out.print(h.heap[p]+" ") ;
		    System.out.println() ;
		}
	}
	
	static class Heap {
    
    int heap[] ; 
    int heap_size; 
    int capacity ;
    Heap(int cap)
    {
        capacity = cap ;
        heap_size = 0 ;
        heap = new int[cap] ;
    }
    int parent(int i)
    {
        return (i - 1) / 2 ;
    }
    
    int left(int i)
    {
        return (2 * i) + 1 ;
    }
    
    int right(int i)
    {
        return (2 * i) + 2 ;
    }
    void swap(int k1, int k2)
    {
        int t = heap[k1] ; 
        heap[k1] = heap[k2] ;
        heap[k2] = t ;
    }
    void insertKey(int key)
    {
        heap_size++ ;
        int i = heap_size - 1 ;
        heap[heap_size - 1] = key ;
        while(i!= 0 && heap[parent(i)] > heap[i])
        {
            swap(parent(i), i) ;
            i = parent(i) ;
        }
    }
    
    void decreaseKey(int k , int val)
    {
        heap[k] = val ;
        while(k != 0 && heap[parent(k)] > heap[k])
        {
            swap(parent(k), k) ;
            k = parent(k) ;
        }
    }
    
    void heapify(int i)
    {
        int l = left(i) ;
        int r = right(i) ;
        int smallest = i ;
        
        if(l < heap_size && heap[l] < heap[i])
             smallest = l ;
        if(r < heap_size && heap[r] < heap[smallest])
            smallest = r ;
        
        if(smallest != i)
        {
            swap(smallest, i) ;
            heapify(smallest) ;
        }
    }
    
    int extractMin()
    {
        if(heap_size <= 0)
             return -1 ;
        if(heap_size == 1)
        {
            heap_size-- ;
            return heap[0] ;
        }
        
        int root = heap[0] ;
        heap[0] = heap[heap_size - 1];
        heap_size-- ;
        heapify(0) ;
        return root ;
    }
    
    void delete(int key)
    {
        heap[key] = Integer.MIN_VALUE ;
        heapify(0) ;
        extractMin();
    }
}

	

}
