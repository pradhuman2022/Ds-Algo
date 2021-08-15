class Solution {
    public int[] avoidFlood(int[] rains) {

        HashMap<Integer, Integer> lakes = new HashMap<>();
        TreeSet<Integer> drainage = new TreeSet<>();
        int ans[] = new int[rains.length];
        Arrays.fill(ans, 1);
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if(lakes.containsKey(lake)) {
                Integer key = drainage.ceiling(lakes.get(lake));
                if(key == null)
                        return new int[] {};
                ans[key] = lake;
                drainage.remove(key);
            } 
            if(lake == 0)
                drainage.add(i);
            else {
               lakes.put(lake, i);
               ans[i] = -1;
            }
                
        }
        return ans;
    }
}
