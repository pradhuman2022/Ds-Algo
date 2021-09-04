class Solution {
    public boolean isPossible(int[] nums) {
       
         HashMap<Integer, PriorityQueue<Integer>> bucket = new HashMap<>();
         for (int num: nums) {
	bucket.put(num, new PriorityQueue<>());
         }
        
        for (int num: nums) {
if (bucket.containsKey(num - 1) && !bucket.get(num - 1).isEmpty()) {
	int size = bucket.get(num - 1).poll();

    bucket.get(num).offer(size + 1);
}
else {
        bucket.get(num).offer(1);
}
}
          for (Map.Entry<Integer, PriorityQueue<Integer>> entry: bucket.entrySet()) {
		if (!entry.getValue().isEmpty() && (entry.getValue().peek() == 1 || entry.getValue().peek() == 2))
			return false;
        	}
	return true;
    	}
    }

