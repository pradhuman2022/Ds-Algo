class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        
        HashSet<Integer> n1;
        HashSet<Integer> n2;

        int start = 0;
        int end = 1000;

        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (isPossible(nums1, nums2, mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }


    public boolean isPossible (int nums1[], int nums2[], int mid) {
        HashSet<Long> n1 = new HashSet<>();
        HashSet<Long> n2 = new HashSet<>();

        rollingHash(nums1, mid, n1);
        rollingHash(nums2, mid, n2);

        for (Long s: n1) {
            if (n2.contains(s))
                return true;
        }

        return false;
    }


    public void rollingHash (int num[], int len, HashSet<Long> set) {
        long hash = 0;
        long mod = (int)10e9 + 7;
        long power = 1;
        int base = 101;

        for (int i = 0; i < len; i++) {
            power = (power * base) % mod;
        }

        for (int i = 0; i < num.length; i++) {
            hash = (hash * base + num[i]) % mod;
            if (i >= len) {
                hash = (hash - num[i - len]) * power % mod;
            }
            
            if (i >= len - 1) {
                set.add(hash);
            }
        }
    }
}
