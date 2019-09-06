class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> sm ; 
    Queue<Integer> bg ; ;
    public MedianFinder() {
        bg = new PriorityQueue<Integer>((a, b) -> a - b);
        sm = new PriorityQueue<Integer>((a, b)-> b - a);
        }
        /*
		
so we need to maintain the order of numbers we use min heap for one half and max heap for one half , 
	suppose the numbers are 2 4 3 5 
	then 
	max heap => 2,
	min heap => 3, 4 , 5 
	but here we need to return median as length is even so when diff of len is 2 then 
	we can say that we need to move one element from one half to other half ! 
 so min heap => 2, 3  
max heap => 4, 5 
then we will return 3 + 4 / 2 as answer ;
*/
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
