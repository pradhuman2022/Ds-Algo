import java.util.* ;
public class SecondMax {
    public static void main(String ar[])
    {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt() ;
        while(T-- > 0)
        {
            int N = sc.nextInt() ;
            sc.nextLine() ;
            int arr[] = new int[27] ;
            while(N-- > 0)
            {
               String s = sc.nextLine() ;
               for(int i = 0 ; i < s.length() ; i++)
                   arr[s.charAt(i) - 97 + 1]++ ;
            }
            int c = arr[3] ;
            int d = arr[4] ;
            int e = arr[5] ; 
            int f = arr[6] ;
            int h = arr[8] ;
            int o = arr[15];
            int ans = Math.min(c, Math.min(d, Math.min(e, Math.min(f,Math.min(h, o))))) ;
            System.out.println(ans) ;
        }
        
        
    }
}


