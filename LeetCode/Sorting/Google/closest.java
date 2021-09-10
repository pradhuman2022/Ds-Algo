class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        if (arr.length == k)
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
       List<Integer> ans = new ArrayList<>();

        //find closest element to x
    	
	int left = 0, right = arr.length - 1;
	
	while(left <= right) {
	int mid = (left + right) / 2;
	if (arr[mid] > x) {
	right = mid - 1;
} else {
	left = mid + 1;
}
}
    
    
    left--;
	right = left + 1;
        
	int count = 0 ;
    while(right - left - 1 < k) {
        //if left < 0 then we should move right
        
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
        
for (int i = left + 1; i < right; i++) 
	ans.add(arr[i]);
return ans;
    }
}
