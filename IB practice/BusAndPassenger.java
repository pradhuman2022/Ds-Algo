public class Solution {
    public int[] solve(int[] A, String B) {
        int ans[] = new int[B.length()] ;
        Pair[] p = new Pair[A.length] ;
        for(int i = 0 ; i < A.length ;i++) 
        {
            p[i] = new Pair(A[i], i + 1) ;
        }
        
        Arrays.sort(p, new Comparator<Pair>(){
           public int compare(Pair p1, Pair p2)
           {
               return p1.width.compareTo(p2.width) ;
           }
        });
        
        Stack <Integer> Lar = new Stack<Integer>() ;
        int currentRow = 0 ;
        for(int i = 0 ; i < B.length(); i++)
        {
         if(B.charAt(i) == '0')
         {
             ans[i] = p[currentRow].row ;
             Lar.push(p[currentRow].row) ;
             currentRow++;
         }else
         {
             if(!Lar.isEmpty())
             {
                 ans[i] = Lar.pop() ;
             }
         }
        }
        return ans ;
    }
    class Pair
    {
        Integer width ;
        Integer row ;
        Pair(int w, int i)
        {
            this.width = w ;
            this.row = i ;
        }
    }
}
