import java.util.* ;
public class TimeChosing {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ; 
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt() ;
        int TL = sc.nextInt() ;
        Arrays.sort(arr) ;
        int things = 0 ; 
        int currentThings = 0 ;
        for(int x : arr)
            if(currentThings + x <= TL){currentThings += x ; things++ ;}
        System.err.println(things);
               
    }
}
