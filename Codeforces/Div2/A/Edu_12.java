        import java.util.*;
         
        public class MyCode {
           
           public static void main(String ar[]) {
            
             Scanner sc = new Scanner(System.in);
             int testCases = sc.nextInt();
             while(testCases-->0) {
                int n = sc.nextInt();
                Pair[] p = new Pair[n];
                for(int i = 0; i < n; i++) {
                   p[i] = new Pair(sc.nextInt(), sc.nextInt());
                }
                System.out.println(isCorrectSequence(p));
             }
           }
            static String isCorrectSequence(Pair p []) {
                 if(p[0].p - p[0].c < 0)
                    return "NO";
                 for(int i = 1; i < p.length; i++) {
                    //int diff1 = p[i].p - p[i].c ; 
                    int diff2 = p[i].c - p[i - 1].c ; 
                    int diff3 = p[i].p - p[i - 1].p;
                    if(diff2 > diff3 || diff2 < 0 || diff3 < 0)
                       return "NO";
                 }
                 return "YES" ; 
             }
             static class Pair{
                int p, c;
                Pair(int p, int c) {
                  this.p = p ; 
                  this.c = c ;
                }
             }
        }
