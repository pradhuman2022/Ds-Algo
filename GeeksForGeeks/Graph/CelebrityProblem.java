class Celebrity {
int getId(int M[][], int n)
    {
        // Your code here
       
       /*Stack<Integer> st = new Stack<Integer>() ; 
        
        for(int i = 0 ; i < n; i++)
            st.push(i);
        
        while(st.size() > 1) {
        
            int A = st.pop();
            int B = st.pop();
            
            if(knows(A, B, M))
                st.push(B);
            else
                st.push(A);
        }
        
        int c = st.pop();
        
        for(int i = 0; i < n; i++) {
            if((knows(c, i, M) || !knows(i, c, M)) && i != c)
                 return -1;
        }
        return c; */
        
        //Every celebrity is node and if any node having n - 1 inDegree and
        //0 as outDegree so that will be our answer.
        int inDegree[] = new int[n];
        int outDegree[] = new int[n] ;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(M[i][j] == 1 && i != j) {
                    inDegree[j]++;
                    outDegree[i]++;
                }
            }
        }
        
        for(int i = 0; i < n; i++) 
            if(outDegree[i] == 0 && inDegree[i] == n - 1)
                return i;
        return -1;
    }
    
    static boolean knows(int a,int b, int Mat[][]) {
        if(Mat[a][b] == 1)
            return true;
        return false;
    }
}
