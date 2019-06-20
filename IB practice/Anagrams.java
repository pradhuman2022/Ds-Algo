
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[][] anagrams(final String[] A) {
         HashMap<String, ArrayList<Integer>> hs = new HashMap<String, ArrayList<Integer>>() ;
        
        for(int i = 0; i < A.length ; i++) 
        {
            StringBuilder s = new StringBuilder() ;
            String k = A[i] ; 
            int arr[] = new int[26] ;
            for(int j = 0 ; j < k.length() ; j++)
            {
                arr[k.charAt(j) - 97]++ ;
            }
            for(int j = 0 ; j < 26 ; j++)
            {
                s.append(Integer.toString(arr[j])) ;
            }
            
            ArrayList <Integer> al = hs.getOrDefault(s.toString(),new ArrayList<Integer>()) ;
            al.add(i + 1) ;
            hs.put(s.toString(), al) ;
        }
        
        ArrayList<ArrayList<Integer>> k = new ArrayList<ArrayList<Integer>>() ;
       
        for (Map.Entry<String,ArrayList<Integer>> entry : hs.entrySet())  
        {
            k.add(entry.getValue()) ;
        }
        int ans[][] = new int[k.size()][] ;
        int i = 0 ;
        for(ArrayList<Integer> al : k)
        {
            int j = 0 ;
            ans[i] = new int[al.size()] ;
            for(int x : al)
            {
                 ans[i][j]  = x ;
                j++ ;
            }
            
            
            i++ ;
           
        }
        return ans ;
    }
}
