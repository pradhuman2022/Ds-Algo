class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int start = 0;
        int end = nums1.length;
        int totalLength = nums1.length + nums2.length;
        
        while(start <= end) {
            int positionX = (start + end) / 2;
            int positionY = ((totalLength + 1) / 2) - positionX;
            
            int maxLeftX = positionX <= 0 ? Integer.MIN_VALUE : nums1[positionX - 1];
            int maxLeftY = positionY <= 0 ? Integer.MIN_VALUE : nums2[positionY - 1];
            int rightMinX = positionX >= nums1.length ? Integer.MAX_VALUE : nums1[positionX];
            int rightMinY = positionY >= nums2.length ? Integer.MAX_VALUE: nums2[positionY];
            
            if (maxLeftX <= rightMinY && maxLeftY <= rightMinX) {
                if (totalLength % 2 == 0) {
                    return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(rightMinX, rightMinY)) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
                
            } else if (maxLeftX > rightMinY) {
                end = positionX - 1;
            } else {
                start = positionX + 1;
            }
        }
         return -1;
    }
}




/******
1 2 4 6 10

3 7 9 11 12

1 2 3 4 6 7 9 10 11 12

7 + 6 / 2 --> median

a1 a2 a3 a4 a5 
b1 b3 b3 b4 b5

edge a5 < b1 then a1.... b1....b5 
edge b5 < a1 then b1...b5 a1...a5

a1 a2 a3 a4 a5  2
b1 b3 a4 b4 b5  2

1 2 3 4 6 
3 4 5 6 8

1 2 3 3 4 5 6 6 8









*****/
