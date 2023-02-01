class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length == k)
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> ans = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1; 
        // We should not go for just smaller value than x in binary search because you will end up with very left indices array 
        /**
            for ex: Js is just smaller element than x and Jg is just just greater element than x

            for this arry : z, i , l, Js, Js, Js, x, Jg, Jg, Jg
            if we use just smaller value using binary search then we will end up with Js which is at
            3rd index in this array.
         */
        while (left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= x)
                right = mid;
            else
                left = mid + 1;
        }

        right = left;
        left--;

        while(right - left - 1 < k) {
           if (left == -1) {
            right++;
            continue;
        }
        
        
        if (arr.length == right || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
            left--;
        } else {
            right++;
        }
        
        }

        for (int l = left + 1; l < right; l++) {
            ans.add(arr[l]);
        }

        return ans;
    }
}
