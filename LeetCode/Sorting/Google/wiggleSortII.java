class Solution {

public void wiggleSort(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
    for (int i = 0; i < nums.length; i++) {
        pq.add(nums[i]);
    }
    int n = nums.length;
    
    int i = 1;
    int j = n / 2;
    while(j-- > 0) {
        nums[i] = pq.poll();
        i += 2;
    }
    
    j = n % 2 != 0 ? (n / 2 + 1) : n / 2;
    i = 0;
    
    while (j--> 0) {
        nums[i] = pq.poll();
        i += 2;
    }
    
}
}
