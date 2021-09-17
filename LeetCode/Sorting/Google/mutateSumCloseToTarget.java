class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int minSum = Integer.MAX_VALUE;
        int ans = -1;
        
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        
        for (int i = 1; i < n; i++)
	        prefix[i] = prefix[i - 1] + arr[i];

        for (int i = 0; i <= arr[n - 1]; i++) {
	        int start = 0;
	        int end = arr.length - 1;
	        while(start < end) {
	            int mid = (start + end) / 2;
	            if (arr[mid] > i)
		            end = mid;
	        else
		        start = mid + 1;
            }
    
           
            int currentSum = ((n - start) * i);
           
            if (start > 0)
                currentSum += prefix[start - 1];
        
            if (minSum > Math.abs(target - currentSum)){
		        minSum = Math.abs(target - currentSum);
		        ans = i;
            }
        }
        return ans;
    }
}


/**
arr 
target
sum(0...n) = n * value
4, 3, 9, 11, 12

4 * 2 == 8
3 * 2 == 9
9 * 2 == 18
12
5, 7
10 14
    10                   7
    10                   8
    
    currentSum value
    if (currentSum < (target - sum(0, i2) + value * (i3 - i4))
        we know that we can have closet value as 
    else
        
    
Eq = (target - sum(0, i2) + value * (i3 - i4)) --> x 
(target - sum(0, i2) + value1 * (i3 - i4)) --> y

x > y
x < y

fine a value who has more larger values
{i1, i2, i3, i4}


if (n * value < target)
 | n * value - target |
 
**/
