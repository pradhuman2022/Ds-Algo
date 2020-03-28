class Solution
{
    Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    public int isPairPresent(Node root,int k)
    {
        // Write your code here
        inorder(root);
        for (Map.Entry <Integer, Integer> m : map.entrySet()) {
            int key = m.getKey();
            int count = m.getValue();
            
            if(k == 2 * key) { 
                if(count > 1)
                    return 1; 
                else
                    continue;
            }
            if(map.containsKey(k - key))
                return 1; 
        }
        
        return 0;
    }
    void inorder(Node root) {
        if(root == null)
            return ;
        
        inorder(root.left);
        map.put(root.data, map.getOrDefault(root.data, 0) + 1);
        inorder(root.right);
    }
}
