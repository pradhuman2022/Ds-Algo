class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        int mod = (int)Math.pow(10, 9) + 7 ;
        int lcm = A * B / gcd(A, B) ;
        long low = 1L ; 
        long high = (long)1e15 ;
        while(low < high)
        {
            long mid = (low + high) / 2 ;
            if(magical_Nums(mid, A,B,lcm) < N)
                low = mid + 1 ;
            else
                high = mid ;
        }
        return (int)(low % mod) ;
        
    }
    static long magical_Nums(long x , int A, int B, int lcm)
    {
        return   Math.abs(x / A + x / B - x / lcm) ;
    }
   
    static int gcd(int a, int b) 
    { 
        // GCD(0, b) == b; GCD(a, 0) == a,  
        // GCD(0, 0) == 0 
        if (a == 0) 
            return b; 
        if (b == 0) 
            return a; 
  
        // Finding K, where K is the greatest  
        // power of 2 that divides both a and b 
        int k; 
        for (k = 0; ((a | b) & 1) == 0; ++k)  
        { 
            a >>= 1; 
            b >>= 1; 
        } 
  
        // Dividing a by 2 until a becomes odd  
        while ((a & 1) == 0) 
            a >>= 1; 
  
        // From here on, 'a' is always odd. 
        do { 
            // If b is even, remove  
            // all factor of 2 in b 
            while ((b & 1) == 0) 
                b >>= 1; 
  
            // Now a and b are both odd. Swap  
            // if necessary so a <= b, then set  
            // b = b - a (which is even) 
            if (a > b)  
            { 
  
                // Swap u and v. 
                int temp = a; 
                a = b; 
                b = temp; 
            } 
  
            b = (b - a); 
        } while (b != 0); 
  
        // restore common factors of 2  
        return a << k; 
    } 

}
