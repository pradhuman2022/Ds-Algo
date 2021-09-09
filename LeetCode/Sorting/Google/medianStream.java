class MedianFinder {

   
    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
	maxHeap.add(num);
       }
       else {
	minHeap.add(num);
       }
   
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
} else if ((maxHeap.size() + minHeap.size()) % 2 == 0 && maxHeap.size() > minHeap.size()) {
minHeap.add(maxHeap.poll());
}
    }
    
    public double findMedian() {
         return maxHeap.size() > minHeap.size() ? maxHeap.peek() :(minHeap.peek() + maxHeap.peek()) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
