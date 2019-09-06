class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> sm ; 
    Queue<Integer> bg ; ;
    public MedianFinder() {
        bg = new PriorityQueue<Integer>((a, b) -> a - b);
        sm = new PriorityQueue<Integer>((a, b)-> b - a);
        }
    
    public void addNum(int num) {
        
        if(bg.size() == 0 && sm.size() == 0)
             sm.add(num) ;
        else if(sm.peek() < num)
            bg.add(num) ; 
        else 
            sm.add(num) ;
        
        if(sm.size() - bg.size() == 2)
                 bg.add(sm.poll()) ;
        if(bg.size() - sm.size() == 2)
            sm.add(bg.poll()) ;
    }
    
    public double findMedian() {
        
        if(sm.size() > bg.size())
             return sm.peek();        
        else if(sm.size()< bg.size())
            return bg.peek() ;
        else
            return ((double)bg.peek() + (double)sm.peek()) / 2 ;
            
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
