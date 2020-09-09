class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int type1 = 0 ;
        int type2 = 0; 
        HashMap<Long, Integer> type1Map = new HashMap<>();
        HashMap<Long, Integer> type2Map = new HashMap<>();
        
        for (int i = 0 ; i < nums1.length; i++) {
            long square = (long)nums1[i] * (long)nums1[i];
            type1Map.put(square, type1Map.getOrDefault(square, 0) + 1);
        }
            
        for (int i = 0; i < nums2.length; i++) {
            long square = (long)nums2[i] * (long)nums2[i];
            type2Map.put(square, type2Map.getOrDefault(square, 0) + 1);
        }
        
        for (int j = 0; j < nums2.length; j++) {
            for (int k = j + 1; k < nums2.length; k++) {
                long multiply = (long)nums2[j] * (long)nums2[k];
                if(type1Map.containsKey(multiply)) {
                     type1 += type1Map.get(multiply);
                }
            }
        }
        
        for (int j = 0; j < nums1.length; j++) {
            for (int k = j + 1; k < nums1.length; k++) {
                long multiply = (long)nums1[j] * (long)nums1[k];
                if(type2Map.containsKey(multiply)) {
                     type2 += type2Map.get(multiply);
                }
            }
        }
        
        return type1 + type2; 
    }
}
