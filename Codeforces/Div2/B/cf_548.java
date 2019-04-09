import java.util.* ;
public class Cf_548 {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int arr [] = new int[n] ;
        int ans[] = new int[n] ; 
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        ans[n - 1] = arr[n - 1] ;
        for(int i = n - 2; i >= 0; i--)
        {
            if(arr[i] < ans[i + 1]){
                ans[i] = arr[i] ;
            }
            else
            {
                if(ans[i + 1] - 1 < 0)
                     ans[i] = 0 ;
                else
                    ans[i] = ans[i + 1] - 1;
            }
                
        }
        long sum = 0 ;
       // int mod = 1000000007 ;
        for(int x : ans)
           sum = ((sum + x) ; 
      System.out.println(sum) ;
    }
    
}
