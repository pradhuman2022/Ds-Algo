import java.util.*;
public class Jon_Snow {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ;
        int k = sc.nextInt() ;
        int x = sc.nextInt() ;
        int arr[] = new int[1024] ;
        for(int i = 0; i < n; i++)
            arr[sc.nextInt()]++;
        MiMaStrength(arr,k, x) ;
    }
    static void MiMaStrength(int arr[], int k, int x)
    {
        int dp[] = new int[1024] ;
       // int cuurentTotal = 0 ;
        for(int i = 0 ; i < k ; i++)
        {
            int currentTotal = 0 ;
            int dptemp[] = new int[1024];
            for(int j = 0 ; j <= 1023 ; j++)
            {
                if(arr[j] % 2 == 0)
                {
                    dptemp[j] += arr[j] / 2 ;
                    dptemp[j ^ x] += arr[j] / 2 ;
                }else if(currentTotal % 2 == 0)
                {
                    dptemp[j] = arr[j] / 2;
                    dptemp[j ^ x] += arr[j] / 2 + 1 ;
                }
                else
                {
                    dptemp[j ^ x] += arr[j] / 2 ;
                    dptemp[j] += arr[j] / 2 + 1 ;
                }
                
             }
              arr = dptemp ;
        }
        	int min = Integer.MAX_VALUE;
      	for (int i = 0; i <= 1023; i++) {
          	if (arr[i] != 0) {
              	min = i;
              	break;
            }
        }
      	int max = Integer.MIN_VALUE;
      	for (int i = 1023; i >= 1; i--) {
          	if (arr[i] != 0) {
              	max = i;
              	break;
            }
        }
      
      	System.out.println(max + " " + min);
    }
}
