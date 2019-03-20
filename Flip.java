public class Solution {
    public ArrayList<Integer> flip(String A) {
        int globalSum = 0, left = -1, right = -1, localSum = 0, localLeft = -1, localRight = -1;
        
        for(int i = 0; i < A.length(); i++)
            if(A.charAt(i) == '0'){
                localSum += 1;
                if(localLeft == -1)
                    localLeft = i;
                localRight = i;
                if(localSum > globalSum){
                    globalSum = localSum;
                    left = localLeft;
                    right = localRight;
                }
            }
            else{
                localSum -= 1;
                if(localSum < 0)
                {
                    localSum = 0;
                    localLeft = -1;
                    localRight = -1;
                }
            }
        
        if(globalSum == 0 || left == -1 || right == -1)
            return new ArrayList<Integer>();
        else 
            {
                ArrayList<Integer> res = new ArrayList<Integer>();
                res.add(left+1);
                res.add(right+1);
                return res;
            }
                
            
                
    }
}

