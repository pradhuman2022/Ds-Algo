int i, j, k; 
          
        // assigning the length -1 value 
        // to each of three variables 
        i = A.length - 1; 
        j = B.length - 1; 
        k = C.length - 1; 
          
        int min_diff, current_diff, max_term; 
  
        // calculating min difference 
        // from last index of lists 
        min_diff = Math.abs(Math.max(A[i], Math.max(B[j], C[k]))  
                  - Math.min(A[i], Math.min(B[j], C[k]))); 
  
        while (i != -1 && j != -1 && k != -1)  
        { 
            current_diff = Math.abs(Math.max(A[i], Math.max(B[j], C[k]))  
                          - Math.min(A[i], Math.min(B[j], C[k]))); 
  
            // checking condition 
            if (current_diff < min_diff) 
                min_diff = current_diff; 
  
            // calculating max term from list 
            max_term = Math.max(A[i], Math.max(B[j], C[k])); 
  
            // Moving to smaller value in the 
            // array with maximum out of three. 
            if (A[i] == max_term) 
                i -= 1; 
            else if (B[j] == max_term) 
                j -= 1; 
            else
                k -= 1; 
        } 
        return min_diff;
