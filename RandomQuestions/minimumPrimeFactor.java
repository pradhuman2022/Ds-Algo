import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String [] temp = br.readLine().split(" ");
         int x = Integer.parseInt(temp[0]);
         int n = Integer.parseInt(temp[1]);
         String[] arr_a = br.readLine().split(" ");
         int[] a = new int[n];
         for(int i_a=0; i_a<arr_a.length; i_a++)
         {
         	a[i_a] = Integer.parseInt(arr_a[i_a]);
         }

         int out_ = evaluate(a, x, n);
         System.out.println(out_);

         wr.close();
         br.close();
    }

    static int smallestPrime[] = new int[1000001];
    static boolean sieve[] = new boolean[1000001];
    static int maxValue = 1000000;
    static int evaluate(int[] a, int x, int n){
        // Write your code here
        createSieve();
        Pair[] p = new Pair[n]; 
        /*
            storing number of prime factor for each element in array
        */
        for(int i = 0; i < n; i++){
            HashSet<Integer> distinctPrimeFactors = new HashSet<>();
            int smallestPrimeNumber = smallestPrime[a[i]];
            int currentNum = a[i];
            Pair currentPair = new Pair();
            if(a[i] == 1 || a[i] == 0){
                p[i] = currentPair;
                currentPair.value = a[i];
                continue;
            }
            while(currentNum > 1){
                distinctPrimeFactors.add(smallestPrime[currentNum]);
                currentNum /= smallestPrime[currentNum];
            } 
            currentPair.distinctPrime = distinctPrimeFactors.size();
            currentPair.value = a[i];
            p[i] = currentPair;
        }
        Deque<Integer> Qi = new LinkedList<Integer>();
        int minimumAns = Integer.MAX_VALUE;

         int i = 0;
         for (i = 0; i < x; ++i) { 
            while (!Qi.isEmpty() && p[i].distinctPrime >= p[Qi.peekLast()].distinctPrime) 
                Qi.removeLast();             
            Qi.addLast(i); 
        } 
        for (; i < n; ++i) { 
                minimumAns = Math.min(p[Qi.peek()].value, minimumAns);
            while ((!Qi.isEmpty()) && Qi.peek() <= i - x) 
                Qi.removeFirst(); 
            while ((!Qi.isEmpty()) && p[i].distinctPrime >= p[Qi.peekLast()].distinctPrime) 
                Qi.removeLast(); 
            Qi.addLast(i); 
        }
            minimumAns = Math.min(minimumAns, p[Qi.peek()].value);
            return minimumAns;
    }

    static class Pair{
        int distinctPrime;
        int value;
    }
    static void createSieve(){
        smallestPrime[1] = 1;
        for(int i = 2; i <= maxValue; i++)
            smallestPrime[i] = i;

        for(int i = 2; i <= (int)Math.sqrt(maxValue); i++) {
            if(sieve[i] == false && isPrime(i)){
                smallestPrime[i] = i;
                int k = i;
                for(int j = i * i; j <= maxValue;) {
                    if(j < 0)
                        continue;
                    sieve[j] = true;
                    smallestPrime[j] = i;
                    j = i * k++;
                }
            }
        }
    }
    static boolean isPrime(int n){
        int sqrt = (int)Math.sqrt(n);
        int countFactor = 0;
        for(int i = 2 ; i <= sqrt; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
