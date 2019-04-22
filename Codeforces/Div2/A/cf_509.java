import java.util.* ;
public class Hate_A {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner (System.in) ;
        int n = sc.nextInt() ; 
       int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt() ;
        }
        Arrays.sort(arr) ;
        int min = arr[0] ;
        int max = arr[n - 1] ;
        System.out.println(Math.max(0,(max - min) - n + 1)) ;
    }
    }
