public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        
        //tranpose matrix 
        int n = a.size() ;
        // System.out.println(n) ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i; j < n ; j++)
              { 
                  int temp = a.get(i).get(j) ; 
                  a.get(i).set(j, a.get(j).get(i));
                  a.get(j).set(i, temp);    
               }
           }
       reverseByRows(a, n) ;
    }
    
    void swap(int row , int col, ArrayList<ArrayList<Integer>> list){
        int temp = list.get(row).get(col) ; 
        list.get(row).set(col, list.get(col).get(row));
        list.get(col).set(row, temp);    
       // System.out.println("something") ;
    }
    
    void reverseByRows(ArrayList<ArrayList<Integer>>list, int n){
        for(int i = 0 ; i < n ; i++){
            int j = 0 ; 
            int k = n - 1 ;
            
            while(j <= k){
               int temp = list.get(i).get(j) ;
               list.get(i).set(j , list.get(i).get(k)) ;
               list.get(i).set(k , temp) ;
               j++ ; 
               k-- ;
            }
        }
    }
}
