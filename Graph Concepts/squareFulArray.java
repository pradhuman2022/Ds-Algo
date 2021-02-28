class Solution {
    HashSet<String> permutations;
    HashMap<Integer, Integer> count;
    int A[];
    
    public int numSquarefulPerms(int[] A) {
        this.A = A;
        count = new HashMap<>();
        permutations = new HashSet<>();
        
        for(int ele: A) {
            count.put(ele, count.getOrDefault(ele, 0) + 1);
        }
        f(A.length, 0, "");
        return permutations.size();
    }
    
    void f(int availableNums, int prevElement, String currentPermutation) {
        
        if(availableNums == 0) {
            System.out.println(count);
            permutations.add(currentPermutation);
        }
        
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            int currentNum = entry.getKey();
            int countOfCurrentNum = entry.getValue();
            
            if(countOfCurrentNum > 0) {
                if(availableNums == A.length) {
                    commonOps(availableNums, currentNum, countOfCurrentNum, currentPermutation);
                } else if(isPerfectSquare(prevElement, currentNum)) {
                    commonOps(availableNums, currentNum, countOfCurrentNum, currentPermutation);
                }
            }
        } 
    }
    
    public void commonOps(int availableNums, int currentNum, int countOfCurrentNum, String currentPermutation) {
         if(availableNums == A.length) {
            currentPermutation = currentPermutation + currentNum;
         } else { 
          currentPermutation = currentPermutation + " " + currentNum;
         }
        count.put(currentNum, countOfCurrentNum - 1);
        f(availableNums - 1, currentNum, currentPermutation);
        count.put(currentNum, countOfCurrentNum);
    }
    
    public boolean isPerfectSquare(int a, int b) {
        int sqrt = (int)Math.sqrt(a + b);
        int sq = sqrt * sqrt;
        
        if(sq == (a + b)) 
            return true;
        else
            return false;
    }
}
