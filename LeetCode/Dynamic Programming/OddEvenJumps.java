class Solution {
    public int oddEvenJumps(int[] A) {
        return getGoodIndexes(A, A.length);
    }
    
    public int getGoodIndexes(int A[], int n) {
        boolean even[] = new boolean[n];
        boolean odd[] = new boolean[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        odd[n - 1] = even[n - 1] = true;
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int val = A[i];
            if(map.containsKey(val)) {
                even[i] = odd[map.get(val)];
                odd[i] = even[map.get(val)];
            } else {
                Integer lower = map.lowerKey(val);
                Integer higher = map.higherKey(val);
                if(lower != null) {
                    /***
                    *As we are considering it as even jump, so 
                    we need to take odd jump next time, and to make even jump
                    we should have smallest value. that's why we first find smallest
                    value from right side and next jump should be odd, so we are finding
                    whether we can reach to end from lower stored in odd[lower] or not.
                    **/
                    even[i] = odd[map.get(lower)];
                }
                if(higher != null) {
                    /**
                    *As we are considering it as starting index so we have to find A[i] >= A[j] for next jump,
                    *So odd jump will take higher and closest by distance value
                    *to reach jth index.
                    *i --> j we take odd jump from i, at that time A[i] <= A[j]
                    *but when we reach j then we have to take even step which should 
                    *be j --> k, A[j] <= A[k], that's why we finding higher value 
                    *at starting.
                    ****/
                    odd[i] = even[map.get(higher)];
                }
            }
            map.put(val, i); 
        }
        map = null;
        int ans = 0;
        /**
        * every starting index will be 1st jump so it will be
        * odd, that's why we are finding our answer from odd array.
        */
        for (boolean canReach: odd) {
            if(canReach)
                ans++;
        }
        return ans;
    }
}
