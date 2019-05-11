class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt() ;
        int k = sc.nextInt() ;
        int mod = (int)Math.min(10, 9) +  7 ;
        int arr[] = new int[n] ;
        ArrayList<Integer> al = new ArrayList<Integer>() ;
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt() ;
            al.add(arr[i]) ;
        }
        int curr = 0 ;
        for(int i = 1 ; i < n ; i++)
        {
            curr += Math.abs(arr[i] - arr[i - 1]) ;
        }
        for(int j = 1 ; j <= k; j++)
        {
            int last = -1 ;
            int value  = 0;
            int prevValue = Integer.MIN_VALUE;
            int size = al.size() ;
            for(int i = 0 ; i < size ; i++)
            {
            if(i == 0 )
               value = Math.abs(curr- Math.abs(al.get(0) - al.get(1))) ;                                // value = Math.abs(curr - Math.abs(arr[i - 1] - arr[i]) - Math.abs(arr[i] - arr[i + 1]) + Math.abs(arr[i - 1] - arr[i + 1])) ;
            else if(i == size - 1)
               value = Math.abs(curr - Math.abs(al.get(i - 1) - al.get(i))) ;
            else    
                value = Math.abs(curr - (Math.abs(al.get(i - 1) - al.get(i)) + Math.abs(al.get(i) - al.get(i + 1))) + Math.abs(al.get(i - 1) - al.get(i + 1)))  ;
               // System.out.println(value +" "+prevValue+"gbb ") ;
               if(value > prevValue)
                 {
                     last = i ;
                     prevValue = value ;
                 }else
                 value = prevValue ;
            }
            al.remove(last) ;
            curr = value ;
        }
        System.out.println(curr) ;

    }
}
