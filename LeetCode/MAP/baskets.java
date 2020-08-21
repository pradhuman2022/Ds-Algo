import java.util.*;
class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer,Integer> mapOfBuckets = new HashMap<>();
        if(tree.length == 1)
            return 1; 
        int maxFruits = 0;
        int currentFruits = 0;
        for (int i = 0; i < tree.length; i++) {
            if(mapOfBuckets.size() == 0 || mapOfBuckets.size() == 1) {
                mapOfBuckets.put(tree[i], i);
                currentFruits++;
            }
            else if(!mapOfBuckets.containsKey(tree[i])) {
                int lastTree = tree[i - 1];
                int lastIndexOfLastTree = mapOfBuckets.get(tree[i - 1]);
                int lastIndexOfBeforeLastTree = -1;
                int lastTreeOfBeforeLastTree = -1;
                //It will only have 2 buckets, will swap buckets in following code.
                for (Map.Entry<Integer,Integer> entry: mapOfBuckets.entrySet()) {
                    if(entry.getKey() != lastTree) {
                        lastIndexOfBeforeLastTree = entry.getValue(); 
                        lastTreeOfBeforeLastTree = entry.getKey();
                    }
                }
                mapOfBuckets.remove(lastTreeOfBeforeLastTree);
                maxFruits = Math.max(maxFruits, currentFruits);
                currentFruits = lastIndexOfLastTree - lastIndexOfBeforeLastTree + 1 ;
                mapOfBuckets.put(tree[i], i);
            }
            else {
                currentFruits++;
                mapOfBuckets.put(tree[i], i);
            } 
        }
        return Math.max(maxFruits, currentFruits); 
    }
}
