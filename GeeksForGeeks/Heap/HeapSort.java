void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            hs.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    public void heapSort(int arr[], int n)
    {
        GfG g = new GfG();
        g.buildHeap(arr, n);
        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            g.heapify(arr, i, 0);
        }
    }
}

}
/*This is a function problem.You only need to complete the function given below*/
class GfG
{
     void buildHeap(int arr[], int n)
    {
        // Your code here
        for(int i = (n / 2) - 1; i >= 0 ;i--)
        {
            heapify(arr, n, i) ;
        }
        
    }
    
    
    
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int l = (2 * i) + 1 ; 
        int r = (2 * i) + 2 ;
        int lar = i ;
        
        if(l < n && arr[l] > arr[lar])
            lar = l  ;
        if(r < n && arr[r] > arr[lar])
           lar = r ;
         
        if(lar != i)
        {
            swap(lar, i, arr) ;
            heapify(arr, n, lar) ;
        }
    }
    void swap(int i , int lar, int arr[])
    {
        int t = arr[i]; 
        arr[i] = arr[lar] ;
        arr[lar] = t ;
    }
 }
 
 
