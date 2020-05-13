class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxCount = 0; 
    public int[] findFrequentTreeSum(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        findFrequentSum(root);
        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            if(m.getValue() == maxCount)
                list.add(m.getKey());
        }
        int ansArray[] = new int[list.size()];
        int i = 0; 
        for(int x : list)
            ansArray[i++] = x; 
        return ansArray;
    }
    int findFrequentSum(TreeNode root) {
        if(root == null)
            return 0; 
        int leftSum = findFrequentSum(root.left);
        int rightSum = findFrequentSum(root.right);
        int totalSum = root.val + leftSum + rightSum;
        map.put(totalSum, map.getOrDefault(totalSum, 0) + 1);
        maxCount = Math.max(maxCount, map.get(totalSum));
        return totalSum;
    }
    
}
