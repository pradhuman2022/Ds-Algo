public class Solution {
    public int[][] solve(int[][] A, int B) {
        int mod = (int)Math.pow(10, 9) + 7 ;
        Pair[] p = new Pair[A.length] ;
        for(int i = 0 ; i < A.length ; i++)
        {
            long x = (long)A[i][0] ; 
            long y = (long)A[i][1] ;
            
            p[i] = new Pair(i, (((x * x)) + ((y * y)))) ;
            
        }
        Arrays.sort(p, new Comparator<Pair>(){
           public int compare(Pair p1, Pair p2)
           {
               return p1.Eud.compareTo(p2.Eud) ;
           }
        });
        
        int ans[][]= new int[B][2] ;
        for(int i = 0 ; i < B ; i++)
        {
            ans[i][0] = A[p[i].index][0] ;
            ans[i][1] = A[p[i].index][1] ;
        }
        return ans ;
    }
    static class Pair{
        Integer index ;
        Long Eud ;
        Pair(int index, Long Eud)
        {
            this.index = index ;
            this.Eud = Eud ;
        }
    }
}
