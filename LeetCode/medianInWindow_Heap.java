class Solution {
    //maxHeap contains leftSide values(first half of sorted array)
    PriorityQueue<Double> maxHeap;
    //minHeap contains rightSide values(second half of sorted array)
    PriorityQueue<Double> minHeap;
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        maxHeap = new PriorityQueue<Double>((a, b) -> b.compareTo(a));
        minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < k; i++) {
            addChocoInHeap((double)nums[i]);
            //System.out.println(minHeap.size()+ " " + maxHeap.size());
        }
        
        double ans [] = new double[nums.length - k + 1];
        System.out.println(minHeap.size()+ " " + maxHeap.size());
        ans[0] = getMedian();
        int temp = 1;
        for (int i = k; i < nums.length; i++) {
            
            int chocoNeedToRemove = nums[i - k]; 
            removeChocoFromHeap((double)chocoNeedToRemove);
            addChocoInHeap((double)nums[i]);
            ans[temp++] = getMedian();
        }
        
        return ans;
    }
    
    
    public void balanceHeaps() {
        
        if(minHeap.size()  + 1 < maxHeap.size()) {
            //allowing n + 1 element in leftSide
            minHeap.add(maxHeap.remove());
        } else if(maxHeap.size() < minHeap.size()){
            //take value from rightSide and add it to leftSide
            maxHeap.add(minHeap.remove());            
        }
        
    }
    
    public void addChocoInHeap(double choco) {
        
        if(minHeap.size() == 0 || maxHeap.peek() <= choco) {
            minHeap.add(choco);
        } else {
            maxHeap.add(choco);
        }
        
        balanceHeaps();
    }
    
    public double getMedian() {
        
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
    
    public void removeChocoFromHeap(double removedChoco) {
        
        if (minHeap.contains(removedChoco)) {
            minHeap.remove(removedChoco);
        } else {
            maxHeap.remove(removedChoco);
        }
        
        balanceHeaps();
    }
    
}
