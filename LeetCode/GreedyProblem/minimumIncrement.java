class Solution {
    public int minNumberOperations(int[] target) {
        Stack<Integer> stack = new Stack();
        int count = target[0];
        for(int i = 1; i < target.length; i++) { 
            if(target[i] > target[i - 1]) 
                count += target[i] - target[i - 1];
        }  
        return count;
    }
}
