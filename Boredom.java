
//Bottom up 
public class Boredom {
    static int maximise(int a1[])
    {
        int freq[] = new int[1001] ;
        int dpMax[] = new int[1001] ;
        for(int a: a1)
            freq[a]++ ;
        dpMax[1] = 1 ;
        dpMax[2] = 2 * freq[2] ;
        for(int i = 3 ; i < 1001 ; i++)
        {
            dpMax[i] = Math.max(dpMax[i - 2] + (i * freq[i]) ,dpMax[i - 1]) ;
        }
        return dpMax[1000] ;
    }
}
