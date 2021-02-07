public class Solution {
    public String multiple(int A) {
        return solve(A);
        
        /**Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> visited1 = new HashSet<>();
        q.add("1");
        visited.add("1");
        
        HashSet<String> temp;
        int alter = 0;
        
        while(!q.isEmpty()) {
            
            if(alter == 0) {
                temp = visited;
            } else {
                temp = visited1;
            }
            
            String possibleMultiple = q.poll();
            if(isDivisible(possibleMultiple, (long)A))
                return possibleMultiple;
           
            String nextMutliple1 = possibleMultiple+"1";
            if(!temp.contains(nextMutliple1))
                q.add(nextMutliple1);
            visited.add(nextMutliple1);
            
            String nextMultiple2 = "1" + possibleMultiple;
            if(!visited.contains(nextMultiple2))
                q.add(nextMultiple2);
            visited.add(nextMultiple2);
            
            String nextMultiple3 = possibleMultiple + "0";
            if(!visited.contains(nextMultiple3))
                q.add(nextMultiple3);
             visited.add(nextMultiple3);
        }
        
        visited = null;
        q = null;
        System.gc();
        return "-1";**/
    }
    
    public String solve(int A) {
        int parent[] = new int[A];
        int rems[] = new int[A];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1 % A);
        boolean visited[] = new boolean[A];
        visited[1 % A] = true;
        rems[1 % A] = 1;
        
        while(!q.isEmpty()) {
          int currentRem = q.poll();
          
          if(currentRem == 0) {
              //return ans
              StringBuilder ans = new StringBuilder();
              int p = parent[0];
              ans.append(rems[0]);
              while(p != 0) {
                  ans.append(rems[p]);
                  p = parent[p];
              }
              return ans.reverse().toString();
          }
          
          int newRemWithZero = (currentRem * 10) % A;
          if(!visited[newRemWithZero]) {
              rems[newRemWithZero] = 0;
              q.add(newRemWithZero);
              visited[newRemWithZero] = true;
              parent[newRemWithZero] = currentRem;
          }
          
          int newRemWithOne = (currentRem * 10 + 1) % A;
          
          if(!visited[newRemWithOne]) {
              rems[newRemWithOne] = 1;
              q.add(newRemWithOne);
              visited[newRemWithOne] = true;
              parent[newRemWithOne] = currentRem;
              
          }
        }
        
        return "";
    }
    
    public boolean isDivisible(String divisor, Long dividend) {
            Long d = Long.valueOf(divisor);
            
        return d % dividend == 0;
    }
}

/**
Smallest Multiple With 0 and 1

Problem Description

You are given an integer A. You have to find smallest multiple of A which consists of digits 0 and 1 only.

Since this multiple could be large, return it in form of a string.

NOTE: Returned string should not contain leading zeroes.



Problem Constraints

1 <= A <= 105


Input Format

First and only argument is an integer A.


Output Format

Return a string denoting the above answer.


Example Input

Input 1:

 A = 55 

Input 2:

 A = 2



Example Output

Output 1:

 110

Output 2:

 10



Example Explanation

Explanation 1:

 110 is the smallest multiple of 55 which consist of only 0 and 1.

Explanation 2:

 10 is the smallest multiple of 2 which consist of only 0 and 1.
 **/
